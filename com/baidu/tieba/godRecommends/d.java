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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a Qm;
    private View aIx;
    private a dNW;
    private ViewGroup dOb;
    private com.baidu.tieba.godRecommends.a dOc;
    private TextView dOd;
    private View dOe;
    private TextView dOf;
    private View dOg;
    private TextView dOh;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<MetaData> dOi = new ArrayList();
    private List<MetaData> dOj = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.aCb()) {
                if (!d.this.bN(d.this.dOi)) {
                    d.this.dOc.setData(d.this.dOi);
                } else {
                    d.this.Zr();
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
        this.dNW = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !w.A(cVar.aBY())) {
            Zr();
            this.dOi.clear();
            this.dOj.clear();
            List<MetaData> aBY = cVar.aBY();
            int size = aBY.size();
            if (size <= 3) {
                this.dOi.addAll(aBY);
            } else {
                this.dOi.addAll(aBY.subList(0, 3));
                this.dOj.addAll(aBY.subList(3, size));
            }
            initUI();
            this.dOd.setText(d.k.god_recommend_title);
            am.i(this.dOb, d.f.bg_god_recommend_layout);
            am.h(this.dOd, d.C0142d.cp_cont_d);
            am.j(this.aIx, d.C0142d.cp_bg_line_b);
            am.j(this.dOe, d.C0142d.cp_bg_line_a);
            am.h(this.dOf, d.C0142d.cp_cont_f);
            am.i(this.dOf, d.f.god_recommend_left_button_selector);
            am.j(this.dOg, d.C0142d.cp_bg_line_a);
            am.h(this.dOh, d.C0142d.cp_link_tip_a);
            am.i(this.dOh, d.f.god_recommend_right_button_selertor);
            this.dOc.setData(this.dOi);
            this.mListView.setAdapter((ListAdapter) this.dOc);
            this.Qm.reset();
            this.Qm.b(this.mContext).xn();
        }
    }

    private void initUI() {
        if (this.dOb == null) {
            this.dOb = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.god_recommend_content_layout, (ViewGroup) null);
            this.dOd = (TextView) this.dOb.findViewById(d.g.god_title);
            this.aIx = this.dOb.findViewById(d.g.top_line);
            this.dOe = this.dOb.findViewById(d.g.content_button_divider);
            this.dOf = (TextView) this.dOb.findViewById(d.g.btn_to_do_leter);
            this.dOf.setOnClickListener(this);
            this.dOg = this.dOb.findViewById(d.g.button_divider);
            this.dOh = (TextView) this.dOb.findViewById(d.g.btn_attention_all);
            this.dOh.setOnClickListener(this);
            this.mListView = (ListView) this.dOb.findViewById(d.g.listview);
            this.dOc = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.dOc.setOnClickListener(this.mOnClickListener);
        }
        if (this.Qm == null) {
            this.Qm = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.Qm.w(this.dOb);
            this.Qm.cf(1);
            this.Qm.ax(true);
        }
    }

    private List<MetaData> aBZ() {
        if (w.A(this.dOi)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.dOi) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData mh(int i) {
        return this.dOc.getItem(i);
    }

    public void j(List<MFollowResult> list, boolean z) {
        if (!w.A(list) && aCb()) {
            boolean bM = bM(list);
            if (z) {
                if (bM) {
                    l.showToast(this.mActivity, d.k.attention_success);
                    Zr();
                    return;
                }
                this.dOc.setData(this.dOi);
                l.showToast(this.mActivity, d.k.attention_fail);
            } else if (bM) {
                this.dOc.setData(this.dOi);
                aCa();
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
        if (w.A(list)) {
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

    private void aCa() {
        if (!w.A(this.dOj)) {
            int size = this.dOi.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.dOi.get(size) == null || !this.dOi.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.dOi.remove(size);
                        this.dOi.add(this.dOj.remove(0));
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
        if (w.A(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.dOi.iterator();
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
        if (!w.A(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCb() {
        return this.Qm != null && this.Qm.isShowing();
    }

    public void Zr() {
        if (aCb()) {
            this.Qm.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.Qm.dismiss();
        }
        if (id == d.g.btn_attention_all && this.dNW != null) {
            this.dNW.bK(aBZ());
        }
    }
}
