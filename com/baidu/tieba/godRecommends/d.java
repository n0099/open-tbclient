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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.MFollow.MFollowResult;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private com.baidu.tbadk.core.dialog.a VR;
    private a fDN;
    private ViewGroup fDS;
    private com.baidu.tieba.godRecommends.a fDT;
    private TextView fDU;
    private View fDV;
    private TextView fDW;
    private View fDX;
    private TextView fDY;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private ListView mListView;
    private View.OnClickListener mOnClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private View mTopLine;
    private List<MetaData> fDZ = new ArrayList();
    private List<MetaData> fEa = new ArrayList();
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.godRecommends.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bkS()) {
                if (!d.this.co(d.this.fDZ)) {
                    d.this.fDT.setData(d.this.fDZ);
                } else {
                    d.this.atv();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cl(List<MetaData> list);
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
        this.fDN = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && !v.T(cVar.bkP())) {
            atv();
            this.fDZ.clear();
            this.fEa.clear();
            List<MetaData> bkP = cVar.bkP();
            int size = bkP.size();
            if (size <= 3) {
                this.fDZ.addAll(bkP);
            } else {
                this.fDZ.addAll(bkP.subList(0, 3));
                this.fEa.addAll(bkP.subList(3, size));
            }
            initUI();
            this.fDU.setText(d.j.god_recommend_title);
            al.k(this.fDS, d.f.bg_god_recommend_layout);
            al.j(this.fDU, d.C0277d.cp_cont_d);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
            al.l(this.fDV, d.C0277d.cp_bg_line_a);
            al.j(this.fDW, d.C0277d.cp_cont_f);
            al.k(this.fDW, d.f.god_recommend_left_button_selector);
            al.l(this.fDX, d.C0277d.cp_bg_line_a);
            al.j(this.fDY, d.C0277d.cp_link_tip_a);
            al.k(this.fDY, d.f.god_recommend_right_button_selertor);
            this.fDT.setData(this.fDZ);
            this.mListView.setAdapter((ListAdapter) this.fDT);
            this.VR.reset();
            this.VR.b(this.mContext).aaW();
        }
    }

    private void initUI() {
        if (this.fDS == null) {
            this.fDS = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.god_recommend_content_layout, (ViewGroup) null);
            this.fDU = (TextView) this.fDS.findViewById(d.g.god_title);
            this.mTopLine = this.fDS.findViewById(d.g.top_line);
            this.fDV = this.fDS.findViewById(d.g.content_button_divider);
            this.fDW = (TextView) this.fDS.findViewById(d.g.btn_to_do_leter);
            this.fDW.setOnClickListener(this);
            this.fDX = this.fDS.findViewById(d.g.button_divider);
            this.fDY = (TextView) this.fDS.findViewById(d.g.btn_attention_all);
            this.fDY.setOnClickListener(this);
            this.mListView = (ListView) this.fDS.findViewById(d.g.listview);
            this.fDT = new com.baidu.tieba.godRecommends.a(this.mActivity);
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            this.fDT.setOnClickListener(this.mOnClickListener);
        }
        if (this.VR == null) {
            this.VR = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            this.VR.az(this.fDS);
            this.VR.gE(1);
            this.VR.dr(true);
        }
    }

    private List<MetaData> bkQ() {
        if (v.T(this.fDZ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MetaData metaData : this.fDZ) {
            if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                arrayList.add(metaData);
            }
        }
        return arrayList;
    }

    public MetaData sa(int i) {
        return this.fDT.getItem(i);
    }

    public void n(List<MFollowResult> list, boolean z) {
        if (!v.T(list) && bkS()) {
            boolean cn2 = cn(list);
            if (z) {
                if (cn2) {
                    l.showToast(this.mActivity, d.j.attention_success);
                    atv();
                    return;
                }
                this.fDT.setData(this.fDZ);
                l.showToast(this.mActivity, d.j.attention_fail);
            } else if (cn2) {
                this.fDT.setData(this.fDZ);
                bkR();
            } else {
                l.showToast(this.mActivity, cm(list));
            }
        }
    }

    private String cm(List<MFollowResult> list) {
        String str;
        String str2;
        int i;
        int i2 = 0;
        String str3 = null;
        if (v.T(list)) {
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
        return (i2 != 1 || StringUtils.isNull(str)) ? this.mActivity.getString(d.j.attention_fail) : str;
    }

    private void bkR() {
        if (!v.T(this.fEa)) {
            int size = this.fDZ.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.fDZ.get(size) == null || !this.fDZ.get(size).getGodUserData().getIsLike()) {
                        size--;
                    } else {
                        this.fDZ.remove(size);
                        this.fDZ.add(this.fEa.remove(0));
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

    private boolean cn(List<MFollowResult> list) {
        if (v.T(list)) {
            return true;
        }
        boolean z = true;
        for (MFollowResult mFollowResult : list) {
            if (!mFollowResult.is_success.booleanValue()) {
                z = false;
            } else {
                Iterator<MetaData> it = this.fDZ.iterator();
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
    public boolean co(List<MetaData> list) {
        if (!v.T(list)) {
            for (MetaData metaData : list) {
                if (metaData != null && !metaData.getGodUserData().getIsLike()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkS() {
        return this.VR != null && this.VR.isShowing();
    }

    public void atv() {
        if (bkS()) {
            this.VR.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.btn_to_do_leter) {
            this.VR.dismiss();
        }
        if (id == d.g.btn_attention_all && this.fDN != null) {
            this.fDN.cl(bkQ());
        }
    }
}
