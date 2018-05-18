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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a JR;
    private View azf;
    private ViewGroup dzA;
    private com.baidu.tieba.godRecommends.a dzB;
    private TextView dzC;
    private View dzD;
    private TextView dzE;
    private View dzF;
    private TextView dzG;
    private a dzv;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> dzH = new ArrayList();
    private List<MetaData> dzI = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.awD()) {
                if (!d.this.bE(d.this.dzH)) {
                    d.this.dzB.setData(d.this.dzH);
                } else {
                    d.this.Vp();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bB(List<MetaData> list);
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
        this.dzv = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.w(cVar.awA())) {
            Vp();
            this.dzH.clear();
            this.dzI.clear();
            List<MetaData> awA = cVar.awA();
            int size = awA.size();
            if (size <= 3) {
                this.dzH.addAll(awA);
            } else {
                this.dzH.addAll(awA.subList(0, 3));
                this.dzI.addAll(awA.subList(3, size));
            }
            initUI();
            this.dzC.setText(d.k.god_recommend_title);
            ak.i(this.dzA, d.f.bg_god_recommend_layout);
            ak.h(this.dzC, d.C0126d.cp_cont_d);
            ak.j(this.azf, d.C0126d.cp_bg_line_b);
            ak.j(this.dzD, d.C0126d.cp_bg_line_a);
            ak.h(this.dzE, d.C0126d.cp_cont_f);
            ak.i(this.dzE, d.f.god_recommend_left_button_selector);
            ak.j(this.dzF, d.C0126d.cp_bg_line_a);
            ak.h(this.dzG, d.C0126d.cp_link_tip_a);
            ak.i(this.dzG, d.f.god_recommend_right_button_selertor);
            this.dzB.setData(this.dzH);
            this.mListView.setAdapter((ListAdapter) this.dzB);
            this.JR.reset();
            this.JR.b(this.mContext).tC();
        }
    }

    private void initUI() {
        if (this.dzA == null) {
            this.dzA = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.god_recommend_content_layout, (ViewGroup) null);
            this.dzC = (TextView) this.dzA.findViewById(d.g.god_title);
            this.azf = this.dzA.findViewById(d.g.top_line);
            this.dzD = this.dzA.findViewById(d.g.content_button_divider);
            this.dzE = (TextView) this.dzA.findViewById(d.g.btn_to_do_leter);
            this.dzE.setOnClickListener(this);
            this.dzF = this.dzA.findViewById(d.g.button_divider);
            this.dzG = (TextView) this.dzA.findViewById(d.g.btn_attention_all);
            this.dzG.setOnClickListener(this);
            this.mListView = (ListView) this.dzA.findViewById(d.g.listview);
            this.dzB = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dzB.setOnClickListener(this.mOnClickListener);
        }
        if (this.JR == null) {
            this.JR = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.JR.w(this.dzA);
            this.JR.cc(1);
            this.JR.as(true);
        }
    }

    private List<MetaData> awB() {
        if (v.w(this.dzH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dzH) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData lO(int i) {
        return this.dzB.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!v.w(list) && awD()) {
            boolean bD = bD(list);
            if (z) {
                if (bD) {
                    l.showToast(this.mActivity, d.k.attention_success);
                    Vp();
                    return;
                }
                this.dzB.setData(this.dzH);
                l.showToast(this.mActivity, d.k.attention_fail);
            } else if (bD) {
                this.dzB.setData(this.dzH);
                awC();
            } else {
                l.showToast(this.mActivity, bC(list));
            }
        }
    }

    private String bC(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.w(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(d.k.attention_fail) : str;
    }

    private void awC() {
        if (!v.w(this.dzI)) {
            int size = this.dzH.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dzH.get(size) == null || !this.dzH.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dzH.remove(size);
                        this.dzH.add(this.dzI.remove(0));
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

    private boolean bD(List<MFollowResult> list) {
        if (v.w(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dzH.iterator();
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
    public boolean bE(List<MetaData> list) {
        if (!v.w(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awD() {
        return this.JR != null && this.JR.isShowing();
    }

    public void Vp() {
        if (awD()) {
            this.JR.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == d.g.btn_to_do_leter) {
            this.JR.dismiss();
        }
        if (id == d.g.btn_attention_all && this.dzv != null) {
            this.dzv.bB(awB());
        }
    }
}
