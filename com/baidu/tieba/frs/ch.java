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
public class ch extends bj<com.baidu.tbadk.core.data.at, bp> {
    private int aOf;
    private Drawable aOg;
    private com.baidu.tbadk.core.data.at bHC;
    private int size;

    public ch(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aOf = u.d.cp_cont_d;
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.at atVar, bp bpVar) {
        super.a(i, view, viewGroup, (ViewGroup) atVar, (com.baidu.tbadk.core.data.at) bpVar);
        this.bHC = atVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.av.k(bpVar.bGd, u.f.frs_item_control_btn_bg);
        bpVar.bGc.setBackgroundColor(this.mContext.getResources().getColor(u.d.common_color_10022));
        bpVar.bGc.setPadding(0, bFD, 0, 0);
        bpVar.bGe.aPV.setOnClickListener(new ci(this, atVar));
        view.setOnClickListener(new cj(this, atVar));
        this.bem.getLayoutMode().af(z);
        this.bem.getLayoutMode().w(view);
        a(bpVar, atVar, z);
        return view;
    }

    private void a(bp bpVar, com.baidu.tbadk.core.data.at atVar, boolean z) {
        if (bpVar != null && atVar != null && atVar.pA() != null) {
            a(bpVar.bGe, atVar.pA(), z);
            if (atVar.px() > 0) {
                if (!TextUtils.isEmpty(atVar.py())) {
                    bpVar.aPG.setText(atVar.py());
                }
                if (atVar.px() < 3) {
                    bpVar.aPH.setVisibility(8);
                } else {
                    bpVar.aPH.setVisibility(0);
                    bpVar.aPH.setText(u.j.add_friend_forum_count);
                }
            } else {
                bpVar.aPO.setVisibility(8);
                bpVar.bGf.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.nL().nR() && atVar.pB() != null && atVar.pB().size() > 0) {
                bpVar.aPN.setVisibility(0);
                if (atVar.pA().pL()) {
                    bpVar.aPI.setText(u.j.add_friend_her_posts);
                } else {
                    bpVar.aPI.setText(u.j.add_friend_his_posts);
                }
                switch (atVar.pB().size()) {
                    case 1:
                        bpVar.aPK.setVisibility(0);
                        bpVar.aPL.setVisibility(4);
                        bpVar.aPM.setVisibility(4);
                        bpVar.aPK.c(atVar.pB().get(0), 10, false);
                        break;
                    case 2:
                        bpVar.aPK.setVisibility(0);
                        bpVar.aPL.setVisibility(0);
                        bpVar.aPM.setVisibility(4);
                        bpVar.aPK.c(atVar.pB().get(0), 10, false);
                        bpVar.aPL.c(atVar.pB().get(1), 10, false);
                        break;
                    default:
                        bpVar.aPK.setVisibility(0);
                        bpVar.aPL.setVisibility(0);
                        bpVar.aPM.setVisibility(0);
                        bpVar.aPK.c(atVar.pB().get(0), 10, false);
                        bpVar.aPL.c(atVar.pB().get(1), 10, false);
                        bpVar.aPM.c(atVar.pB().get(2), 10, false);
                        break;
                }
            } else {
                bpVar.aPN.setVisibility(8);
                bpVar.bGf.setVisibility(8);
            }
            ck ckVar = new ck(this, atVar);
            bpVar.aPK.setTag(u.g.tag_first, atVar);
            bpVar.aPL.setTag(u.g.tag_first, atVar);
            bpVar.aPM.setTag(u.g.tag_first, atVar);
            bpVar.aPK.setTag(u.g.tag_second, 0);
            bpVar.aPL.setTag(u.g.tag_second, 1);
            bpVar.aPM.setTag(u.g.tag_second, 2);
            bpVar.aPK.setOnClickListener(ckVar);
            bpVar.aPL.setOnClickListener(ckVar);
            bpVar.aPM.setOnClickListener(ckVar);
        }
    }

    private void a(bp.a aVar, com.baidu.tbadk.core.data.av avVar, boolean z) {
        if (avVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.nL().nN()) {
                aVar.aPP.setVisibility(0);
                if (!TextUtils.isEmpty(avVar.pK())) {
                    aVar.aPP.setUserId(String.valueOf(avVar.getUserId()));
                    aVar.aPP.setImageDrawable(null);
                    aVar.aPP.c(avVar.pK(), 12, false);
                }
            } else {
                aVar.aPP.setVisibility(8);
            }
            if (avVar.pN() != null && !TextUtils.isEmpty(avVar.pN().getUrl())) {
                aVar.aPQ.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(avVar.pN());
                aVar.aPQ.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds32), this.mContext.getResources().getDimensionPixelSize(u.e.ds8));
            } else {
                aVar.aPQ.setVisibility(8);
            }
            aVar.aPR.setText(avVar.getName());
            aVar.aPS.setText(avVar.pM());
            if (avVar.pL()) {
                com.baidu.tbadk.core.util.av.c(aVar.aPW, u.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.av.c(aVar.aPW, u.f.icon_pop_qz_boy);
            }
            a(aVar, this.bHC, z);
            if (avVar.pJ()) {
                aVar.aPV.setClickable(false);
                aVar.aPV.setBackgroundResource(u.d.common_color_10022);
                aVar.aPV.setText(u.j.waiting);
                aVar.aPV.setTextColor(z ? this.mContext.getResources().getColor(u.d.cp_cont_d) : this.mContext.getResources().getColor(u.d.cp_cont_d_1));
                return;
            }
            aVar.aPV.setClickable(true);
            aVar.aPV.setText(u.j.frs_recommend_friend_item_add);
        }
    }

    public void av(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bHC != null && this.bHC.pA() != null && TextUtils.equals(this.bHC.pA().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bHC.pA().getUserId()))) {
            this.bHC.pA().pI();
            notifyDataSetChanged();
        }
    }

    public void a(bp.a aVar, com.baidu.tbadk.core.data.at atVar, boolean z) {
        if (atVar != null && aVar != null) {
            if (atVar.getLbsInfo() != null) {
                if (atVar.getLbsInfo().zc() == 1) {
                    aVar.aOj.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(aVar.aOj, this.aOf, 1);
                    aVar.aOj.setText(this.mContext.getResources().getString(u.j.contact_yinshen));
                    aVar.aOj.setCompoundDrawables(null, null, null, null);
                    aVar.aPS.setVisibility(8);
                } else if (atVar.getLbsInfo().zc() == 0) {
                    if (StringUtils.isNull(atVar.getLbsInfo().getDistance())) {
                        aVar.aOj.setVisibility(8);
                        aVar.aPS.setVisibility(0);
                    } else {
                        aVar.aPS.setVisibility(8);
                        aVar.aOj.setVisibility(0);
                        aVar.aOj.setText(String.valueOf(this.mContext.getString(u.j.distance_of_you)) + atVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.av.c(aVar.aOj, this.aOf, 1);
                        this.aOg = com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_friend_pin);
                        this.aOg.setBounds(0, 0, this.size, this.size);
                        aVar.aOj.setCompoundDrawables(this.aOg, null, null, null);
                    }
                } else {
                    aVar.aOj.setVisibility(8);
                    aVar.aPS.setVisibility(0);
                }
            } else {
                aVar.aOj.setVisibility(8);
                aVar.aPS.setVisibility(0);
            }
            if (atVar.pA() != null && StringUtils.isNull(atVar.pA().pM())) {
                aVar.aPS.setVisibility(8);
            }
        }
    }
}
