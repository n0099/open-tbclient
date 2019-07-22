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
    private com.baidu.tbadk.core.dialog.a TX;
    private a fZK;
    private ViewGroup fZP;
    private com.baidu.tieba.godRecommends.a fZQ;
    private TextView fZR;
    private View fZS;
    private TextView fZT;
    private View fZU;
    private TextView fZV;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fZW = new ArrayList();
    private List<MetaData> fZX = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.buq()) {
                if (!d.this.cx(d.this.fZW)) {
                    d.this.fZQ.setData(d.this.fZW);
                } else {
                    d.this.azP();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cu(List<MetaData> list);
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
        this.fZK = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.aa(cVar.bun())) {
            azP();
            this.fZW.clear();
            this.fZX.clear();
            List<MetaData> bun = cVar.bun();
            int size = bun.size();
            if (size <= 3) {
                this.fZW.addAll(bun);
            } else {
                this.fZW.addAll(bun.subList(0, 3));
                this.fZX.addAll(bun.subList(3, size));
            }
            initUI();
            this.fZR.setText(R.string.god_recommend_title);
            am.k(this.fZP, R.drawable.bg_god_recommend_layout);
            am.j(this.fZR, R.color.cp_cont_d);
            am.l(this.mTopLine, R.color.cp_bg_line_b);
            am.l(this.fZS, R.color.cp_bg_line_a);
            am.j(this.fZT, R.color.cp_cont_f);
            am.k(this.fZT, R.drawable.god_recommend_left_button_selector);
            am.l(this.fZU, R.color.cp_bg_line_a);
            am.j(this.fZV, R.color.cp_link_tip_a);
            am.k(this.fZV, R.drawable.god_recommend_right_button_selertor);
            this.fZQ.setData(this.fZW);
            this.mListView.setAdapter((ListAdapter) this.fZQ);
            this.TX.reset();
            this.TX.b(this.mContext).agI();
        }
    }

    private void initUI() {
        if (this.fZP == null) {
            this.fZP = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.god_recommend_content_layout, (ViewGroup) null);
            this.fZR = (TextView) this.fZP.findViewById(R.id.god_title);
            this.mTopLine = this.fZP.findViewById(R.id.top_line);
            this.fZS = this.fZP.findViewById(R.id.content_button_divider);
            this.fZT = (TextView) this.fZP.findViewById(R.id.btn_to_do_leter);
            this.fZT.setOnClickListener(this);
            this.fZU = this.fZP.findViewById(R.id.button_divider);
            this.fZV = (TextView) this.fZP.findViewById(R.id.btn_attention_all);
            this.fZV.setOnClickListener(this);
            this.mListView = (ListView) this.fZP.findViewById(R.id.listview);
            this.fZQ = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fZQ.setOnClickListener(this.mOnClickListener);
        }
        if (this.TX == null) {
            this.TX = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.TX.aH(this.fZP);
            this.TX.hx(1);
            this.TX.dR(true);
        }
    }

    private List<MetaData> buo() {
        if (v.aa(this.fZW)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fZW) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData tA(int i) {
        return this.fZQ.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.aa(list) && buq()) {
            boolean cw = cw(list);
            if (z) {
                if (cw) {
                    l.showToast(this.mActivity, (int) R.string.attention_success);
                    azP();
                    return;
                }
                this.fZQ.setData(this.fZW);
                l.showToast(this.mActivity, (int) R.string.attention_fail);
            } else if (cw) {
                this.fZQ.setData(this.fZW);
                bup();
            } else {
                l.showToast(this.mActivity, cv(list));
            }
        }
    }

    private String cv(List<MFollowResult> list) {
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

    private void bup() {
        if (!v.aa(this.fZX)) {
            int size = this.fZW.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fZW.get(size) == null || !this.fZW.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fZW.remove(size);
                        this.fZW.add(this.fZX.remove(0));
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

    private boolean cw(List<MFollowResult> list) {
        if (v.aa(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.fZW.iterator();
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
    public boolean cx(List<MetaData> list) {
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
    public boolean buq() {
        return this.TX != null && this.TX.isShowing();
    }

    public void azP() {
        if (buq()) {
            this.TX.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_to_do_leter) {
            this.TX.dismiss();
        }
        if (id == R.id.btn_attention_all && this.fZK != null) {
            this.fZK.cu(buo());
        }
    }
}
