package com.baidu.tieba.godRecommends;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a TW;
    private TextView gcA;
    private View gcB;
    private TextView gcC;
    private a gcr;
    private ViewGroup gcw;
    private com.baidu.tieba.godRecommends.a gcx;
    private TextView gcy;
    private View gcz;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> gcD = new ArrayList();
    private List<MetaData> gcE = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bvr()) {
                if (!d.this.cw(d.this.gcD)) {
                    d.this.gcx.setData(d.this.gcD);
                } else {
                    d.this.aAd();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void ct(List<MetaData> list);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void a(a aVar) {
        this.gcr = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.bvo())) {
            aAd();
            this.gcD.clear();
            this.gcE.clear();
            List<MetaData> bvo = cVar.bvo();
            int size = bvo.size();
            if (size <= 3) {
                this.gcD.addAll(bvo);
            } else {
                this.gcD.addAll(bvo.subList(0, 3));
                this.gcE.addAll(bvo.subList(3, size));
            }
            initUI();
            this.gcy.setText(R.string.god_recommend_title);
            am.k(this.gcw, R.drawable.bg_god_recommend_layout);
            am.j(this.gcy, R.color.cp_cont_d);
            am.l(this.mTopLine, R.color.cp_bg_line_c);
            am.l(this.gcz, R.color.cp_bg_line_c);
            am.j(this.gcA, R.color.cp_cont_f);
            am.k(this.gcA, R.drawable.god_recommend_left_button_selector);
            am.l(this.gcB, R.color.cp_bg_line_c);
            am.j(this.gcC, R.color.cp_link_tip_a);
            am.k(this.gcC, R.drawable.god_recommend_right_button_selertor);
            this.gcx.setData(this.gcD);
            this.mListView.setAdapter((ListAdapter) this.gcx);
            this.TW.reset();
            this.TW.b(this.mContext).agO();
        }
    }

    private void initUI() {
        if (this.gcw == null) {
            this.gcw = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.gcy = (TextView) this.gcw.findViewById(R.id.god_title);
            this.mTopLine = this.gcw.findViewById(R.id.top_line);
            this.gcz = this.gcw.findViewById(R.id.content_button_divider);
            this.gcA = (TextView) this.gcw.findViewById(R.id.btn_to_do_leter);
            this.gcA.setOnClickListener(this);
            this.gcB = this.gcw.findViewById(R.id.button_divider);
            this.gcC = (TextView) this.gcw.findViewById(R.id.btn_attention_all);
            this.gcC.setOnClickListener(this);
            this.mListView = (ListView) this.gcw.findViewById(R.id.listview);
            this.gcx = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.gcx.setOnClickListener(this.mOnClickListener);
        }
        if (this.TW == null) {
            this.TW = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TW.aH(this.gcw);
            this.TW.hy(1);
            this.TW.dR(true);
        }
    }

    private List<MetaData> bvp() {
        if (v.aa(this.gcD)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.gcD) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData tG(int i) {
        return this.gcx.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && bvr()) {
            boolean cv = cv(list);
            if (z) {
                if (cv) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    aAd();
                    return;
                }
                this.gcx.setData(this.gcD);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cv) {
                this.gcx.setData(this.gcD);
                bvq();
            } else {
                l.showToast(this.mActivity, cu(list));
            }
        }
    }

    private String cu(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.aa(list)) {
            str = null;
        } else {
            for (MFollowResult mFollowResult : list) {
                if (mFollowResult == null || mFollowResult.is_success.booleanValue()) {
                    str2 = str3;
                    i = i2;
                } else {
                    i = i2 + 1;
                    str2 = mFollowResult.msg;
                }
                i2 = i;
                str3 = str2;
            }
            str = str3;
        }
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(R.string.attention_fail) : str;
    }

    private void bvq() {
        if (!v.aa(this.gcE)) {
            int size = this.gcD.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.gcD.get(size) == null || !this.gcD.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.gcD.remove(size);
                        this.gcD.add(this.gcE.remove(0));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean cv(List<MFollowResult> list) {
        if (v.aa(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.gcD.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MetaData next = it.next();
                        String str = mFollowResult.portrait;
                        if (next != null && str != null && str.equals(next.getPortrait())) {
                            next.getGodUserData().setIsLike(true);
                            break;
                        }
                    }
                }
            }
            z = z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(List<MetaData> list) {
        if (!v.aa(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvr() {
        return this.TW != null && this.TW.isShowing();
    }

    public void aAd() {
        if (bvr()) {
            this.TW.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.TW.dismiss();
        }
        if (id == R.id.btn_attention_all && this.gcr != null) {
            this.gcr.ct(bvp());
        }
    }
}
