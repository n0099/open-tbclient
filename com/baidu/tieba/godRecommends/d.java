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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a SK;
    private a dXW;
    private ViewGroup dYb;
    private com.baidu.tieba.godRecommends.a dYc;
    private TextView dYd;
    private View dYe;
    private TextView dYf;
    private View dYg;
    private TextView dYh;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> dYi = new ArrayList();
    private List<MetaData> dYj = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aEU()) {
                if (!d.this.bN(d.this.dYi)) {
                    d.this.dYc.setData(d.this.dYi);
                } else {
                    d.this.PS();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bK(List<MetaData> list);
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
        this.dXW = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.z(cVar.aER())) {
            PS();
            this.dYi.clear();
            this.dYj.clear();
            List<MetaData> aER = cVar.aER();
            int size = aER.size();
            if (size <= 3) {
                this.dYi.addAll(aER);
            } else {
                this.dYi.addAll(aER.subList(0, 3));
                this.dYj.addAll(aER.subList(3, size));
            }
            initUI();
            this.dYd.setText(e.j.god_recommend_title);
            al.i(this.dYb, e.f.bg_god_recommend_layout);
            al.h(this.dYd, e.d.cp_cont_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.dYe, e.d.cp_bg_line_a);
            al.h(this.dYf, e.d.cp_cont_f);
            al.i(this.dYf, e.f.god_recommend_left_button_selector);
            al.j(this.dYg, e.d.cp_bg_line_a);
            al.h(this.dYh, e.d.cp_link_tip_a);
            al.i(this.dYh, e.f.god_recommend_right_button_selertor);
            this.dYc.setData(this.dYi);
            this.mListView.setAdapter((ListAdapter) this.dYc);
            this.SK.reset();
            this.SK.b(this.mContext).yl();
        }
    }

    private void initUI() {
        if (this.dYb == null) {
            this.dYb = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.god_recommend_content_layout, (ViewGroup) null);
            this.dYd = (TextView) this.dYb.findViewById(e.g.god_title);
            this.mTopLine = this.dYb.findViewById(e.g.top_line);
            this.dYe = this.dYb.findViewById(e.g.content_button_divider);
            this.dYf = (TextView) this.dYb.findViewById(e.g.btn_to_do_leter);
            this.dYf.setOnClickListener(this);
            this.dYg = this.dYb.findViewById(e.g.button_divider);
            this.dYh = (TextView) this.dYb.findViewById(e.g.btn_attention_all);
            this.dYh.setOnClickListener(this);
            this.mListView = (ListView) this.dYb.findViewById(e.g.listview);
            this.dYc = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dYc.setOnClickListener(this.mOnClickListener);
        }
        if (this.SK == null) {
            this.SK = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.SK.G(this.dYb);
            this.SK.cr(1);
            this.SK.aF(true);
        }
    }

    private List<MetaData> aES() {
        if (v.z(this.dYi)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dYi) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData mX(int i) {
        return this.dYc.getItem(i);
    }

    public void k(List<MFollowResult> list, boolean z) {
        if (!v.z(list) && aEU()) {
            boolean bM = bM(list);
            if (z) {
                if (bM) {
                    l.showToast(this.mActivity, e.j.attention_success);
                    PS();
                    return;
                }
                this.dYc.setData(this.dYi);
                l.showToast(this.mActivity, e.j.attention_fail);
            } else if (bM) {
                this.dYc.setData(this.dYi);
                aET();
            } else {
                l.showToast(this.mActivity, bL(list));
            }
        }
    }

    private String bL(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.z(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(e.j.attention_fail) : str;
    }

    private void aET() {
        if (!v.z(this.dYj)) {
            int size = this.dYi.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dYi.get(size) == null || !this.dYi.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dYi.remove(size);
                        this.dYi.add(this.dYj.remove(0));
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

    private boolean bM(List<MFollowResult> list) {
        if (v.z(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dYi.iterator();
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
    public boolean bN(List<MetaData> list) {
        if (!v.z(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEU() {
        return this.SK != null && this.SK.isShowing();
    }

    public void PS() {
        if (aEU()) {
            this.SK.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.btn_to_do_leter) {
            this.SK.dismiss();
        }
        if (id == e.g.btn_attention_all && this.dXW != null) {
            this.dXW.bK(aES());
        }
    }
}
