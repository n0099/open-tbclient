package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ch extends bj<com.baidu.tbadk.core.data.ao, bp> {
    private int aNl;
    private Drawable aNm;
    private com.baidu.tbadk.core.data.ao bGg;
    private int size;

    public ch(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aNl = u.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public bp a(ViewGroup viewGroup) {
        return new bp(LayoutInflater.from(this.mContext).inflate(u.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ao aoVar, bp bpVar) {
        super.a(i, view, viewGroup, (ViewGroup) aoVar, (com.baidu.tbadk.core.data.ao) bpVar);
        this.bGg = aoVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.av.k(bpVar.bEP, u.f.frs_item_control_btn_bg);
        bpVar.bEO.setBackgroundColor(this.mContext.getResources().getColor(u.d.common_color_10022));
        bpVar.bEO.setPadding(0, bBA, 0, 0);
        bpVar.bEQ.aPb.setOnClickListener(new ci(this, aoVar));
        view.setOnClickListener(new cj(this, aoVar));
        this.bkc.getLayoutMode().ad(z);
        this.bkc.getLayoutMode().w(view);
        a(bpVar, aoVar, z);
        return view;
    }

    private void a(bp bpVar, com.baidu.tbadk.core.data.ao aoVar, boolean z) {
        if (bpVar != null && aoVar != null && aoVar.pR() != null) {
            a(bpVar.bEQ, aoVar.pR(), z);
            if (aoVar.pO() > 0) {
                if (!TextUtils.isEmpty(aoVar.pP())) {
                    bpVar.aOM.setText(aoVar.pP());
                }
                if (aoVar.pO() < 3) {
                    bpVar.aON.setVisibility(8);
                } else {
                    bpVar.aON.setVisibility(0);
                    bpVar.aON.setText(u.j.add_friend_forum_count);
                }
            } else {
                bpVar.aOU.setVisibility(8);
                bpVar.bER.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.nW().oc() && aoVar.pS() != null && aoVar.pS().size() > 0) {
                bpVar.aOT.setVisibility(0);
                if (aoVar.pR().qc()) {
                    bpVar.aOO.setText(u.j.add_friend_her_posts);
                } else {
                    bpVar.aOO.setText(u.j.add_friend_his_posts);
                }
                switch (aoVar.pS().size()) {
                    case 1:
                        bpVar.aOQ.setVisibility(0);
                        bpVar.aOR.setVisibility(4);
                        bpVar.aOS.setVisibility(4);
                        bpVar.aOQ.c(aoVar.pS().get(0), 10, false);
                        break;
                    case 2:
                        bpVar.aOQ.setVisibility(0);
                        bpVar.aOR.setVisibility(0);
                        bpVar.aOS.setVisibility(4);
                        bpVar.aOQ.c(aoVar.pS().get(0), 10, false);
                        bpVar.aOR.c(aoVar.pS().get(1), 10, false);
                        break;
                    default:
                        bpVar.aOQ.setVisibility(0);
                        bpVar.aOR.setVisibility(0);
                        bpVar.aOS.setVisibility(0);
                        bpVar.aOQ.c(aoVar.pS().get(0), 10, false);
                        bpVar.aOR.c(aoVar.pS().get(1), 10, false);
                        bpVar.aOS.c(aoVar.pS().get(2), 10, false);
                        break;
                }
            } else {
                bpVar.aOT.setVisibility(8);
                bpVar.bER.setVisibility(8);
            }
            ck ckVar = new ck(this, aoVar);
            bpVar.aOQ.setTag(u.g.tag_first, aoVar);
            bpVar.aOR.setTag(u.g.tag_first, aoVar);
            bpVar.aOS.setTag(u.g.tag_first, aoVar);
            bpVar.aOQ.setTag(u.g.tag_second, 0);
            bpVar.aOR.setTag(u.g.tag_second, 1);
            bpVar.aOS.setTag(u.g.tag_second, 2);
            bpVar.aOQ.setOnClickListener(ckVar);
            bpVar.aOR.setOnClickListener(ckVar);
            bpVar.aOS.setOnClickListener(ckVar);
        }
    }

    private void a(bp.a aVar, com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (aqVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.nW().nY()) {
                aVar.aOV.setVisibility(0);
                if (!TextUtils.isEmpty(aqVar.qb())) {
                    aVar.aOV.setUserId(String.valueOf(aqVar.getUserId()));
                    aVar.aOV.setImageDrawable(null);
                    aVar.aOV.c(aqVar.qb(), 12, false);
                }
            } else {
                aVar.aOV.setVisibility(8);
            }
            if (aqVar.qe() != null && !TextUtils.isEmpty(aqVar.qe().getUrl())) {
                aVar.aOW.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aqVar.qe());
                aVar.aOW.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds8));
            } else {
                aVar.aOW.setVisibility(8);
            }
            aVar.aOX.setText(aqVar.getName());
            aVar.aOY.setText(aqVar.qd());
            if (aqVar.qc()) {
                com.baidu.tbadk.core.util.av.c(aVar.aPc, u.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.av.c(aVar.aPc, u.f.icon_pop_qz_boy);
            }
            a(aVar, this.bGg, z);
            if (aqVar.qa()) {
                aVar.aPb.setClickable(false);
                aVar.aPb.setBackgroundResource(u.d.common_color_10022);
                aVar.aPb.setText(u.j.waiting);
                aVar.aPb.setTextColor(z ? this.mContext.getResources().getColor(u.d.cp_cont_d) : this.mContext.getResources().getColor(u.d.cp_cont_d_1));
                return;
            }
            aVar.aPb.setClickable(true);
            aVar.aPb.setText(u.j.frs_recommend_friend_item_add);
        }
    }

    public void av(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bGg != null && this.bGg.pR() != null && TextUtils.equals(this.bGg.pR().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bGg.pR().getUserId()))) {
            this.bGg.pR().pZ();
            notifyDataSetChanged();
        }
    }

    public void a(bp.a aVar, com.baidu.tbadk.core.data.ao aoVar, boolean z) {
        if (aoVar != null && aVar != null) {
            if (aoVar.getLbsInfo() != null) {
                if (aoVar.getLbsInfo().zc() == 1) {
                    aVar.aNp.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(aVar.aNp, this.aNl, 1);
                    aVar.aNp.setText(this.mContext.getResources().getString(u.j.contact_yinshen));
                    aVar.aNp.setCompoundDrawables(null, null, null, null);
                    aVar.aOY.setVisibility(8);
                } else if (aoVar.getLbsInfo().zc() == 0) {
                    if (StringUtils.isNull(aoVar.getLbsInfo().getDistance())) {
                        aVar.aNp.setVisibility(8);
                        aVar.aOY.setVisibility(0);
                    } else {
                        aVar.aOY.setVisibility(8);
                        aVar.aNp.setVisibility(0);
                        aVar.aNp.setText(String.valueOf(this.mContext.getString(u.j.distance_of_you)) + aoVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.av.c(aVar.aNp, this.aNl, 1);
                        this.aNm = com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_friend_pin);
                        this.aNm.setBounds(0, 0, this.size, this.size);
                        aVar.aNp.setCompoundDrawables(this.aNm, null, null, null);
                    }
                } else {
                    aVar.aNp.setVisibility(8);
                    aVar.aOY.setVisibility(0);
                }
            } else {
                aVar.aNp.setVisibility(8);
                aVar.aOY.setVisibility(0);
            }
            if (aoVar.pR() != null && StringUtils.isNull(aoVar.pR().qd())) {
                aVar.aOY.setVisibility(8);
            }
        }
    }
}
