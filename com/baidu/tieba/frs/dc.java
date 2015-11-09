package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dc extends bn<com.baidu.tbadk.core.data.r, br> {
    private int aFf;
    private Drawable aFg;
    private com.baidu.tbadk.core.data.r aYt;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public dc(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aFf = i.c.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public br a(ViewGroup viewGroup) {
        return new br(LayoutInflater.from(this.mContext).inflate(i.g.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.r rVar, br brVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tbadk.core.data.r) brVar);
        this.aYt = rVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.an.i(brVar.aWA, i.e.frs_item_control_btn_bg);
        brVar.aWz.setBackgroundColor(this.mContext.getResources().getColor(i.c.transparent));
        brVar.aWz.setPadding(0, this.aTa, 0, 0);
        brVar.aWB.aGW.setOnClickListener(new dd(this, rVar));
        view.setOnClickListener(new de(this, rVar));
        this.aSm.getLayoutMode().ad(z);
        this.aSm.getLayoutMode().k(view);
        a(brVar, rVar, z);
        return view;
    }

    private void a(br brVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (brVar != null && rVar != null && rVar.rR() != null) {
            a(brVar.aWB, rVar.rR(), z);
            if (rVar.rO() > 0) {
                if (!TextUtils.isEmpty(rVar.rP())) {
                    brVar.aGH.setText(rVar.rP());
                }
                if (rVar.rO() < 3) {
                    brVar.aGI.setVisibility(8);
                } else {
                    brVar.aGI.setVisibility(0);
                    brVar.aGI.setText(i.h.add_friend_forum_count);
                }
            } else {
                brVar.aGP.setVisibility(8);
                brVar.aWC.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.qV().qZ() && rVar.rS() != null && rVar.rS().size() > 0) {
                brVar.aGO.setVisibility(0);
                if (rVar.rR().rY()) {
                    brVar.aGJ.setText(i.h.add_friend_her_posts);
                } else {
                    brVar.aGJ.setText(i.h.add_friend_his_posts);
                }
                switch (rVar.rS().size()) {
                    case 1:
                        brVar.aGL.setVisibility(0);
                        brVar.aGM.setVisibility(4);
                        brVar.aGN.setVisibility(4);
                        brVar.aGL.d(rVar.rS().get(0), 10, false);
                        break;
                    case 2:
                        brVar.aGL.setVisibility(0);
                        brVar.aGM.setVisibility(0);
                        brVar.aGN.setVisibility(4);
                        brVar.aGL.d(rVar.rS().get(0), 10, false);
                        brVar.aGM.d(rVar.rS().get(1), 10, false);
                        break;
                    default:
                        brVar.aGL.setVisibility(0);
                        brVar.aGM.setVisibility(0);
                        brVar.aGN.setVisibility(0);
                        brVar.aGL.d(rVar.rS().get(0), 10, false);
                        brVar.aGM.d(rVar.rS().get(1), 10, false);
                        brVar.aGN.d(rVar.rS().get(2), 10, false);
                        break;
                }
            } else {
                brVar.aGO.setVisibility(8);
                brVar.aWC.setVisibility(8);
            }
            df dfVar = new df(this, rVar);
            brVar.aGL.setTag(i.f.tag_first, rVar);
            brVar.aGM.setTag(i.f.tag_first, rVar);
            brVar.aGN.setTag(i.f.tag_first, rVar);
            brVar.aGL.setTag(i.f.tag_second, 0);
            brVar.aGM.setTag(i.f.tag_second, 1);
            brVar.aGN.setTag(i.f.tag_second, 2);
            brVar.aGL.setOnClickListener(dfVar);
            brVar.aGM.setOnClickListener(dfVar);
            brVar.aGN.setOnClickListener(dfVar);
        }
    }

    private void a(br.a aVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.qV().qX()) {
                aVar.aGQ.setVisibility(0);
                if (!TextUtils.isEmpty(sVar.rX())) {
                    aVar.aGQ.setUserId(String.valueOf(sVar.getUserId()));
                    aVar.aGQ.setImageDrawable(null);
                    aVar.aGQ.d(sVar.rX(), 12, false);
                }
            } else {
                aVar.aGQ.setVisibility(8);
            }
            if (sVar.sa() != null && !TextUtils.isEmpty(sVar.sa().getUrl())) {
                aVar.aGR.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(sVar.sa());
                aVar.aGR.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin));
            } else {
                aVar.aGR.setVisibility(8);
            }
            aVar.aGS.setText(sVar.getName());
            aVar.aGT.setText(sVar.rZ());
            if (sVar.rY()) {
                com.baidu.tbadk.core.util.an.c(aVar.aGX, i.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.an.c(aVar.aGX, i.e.icon_pop_qz_boy);
            }
            a(aVar, this.aYt, z);
            if (sVar.rW()) {
                aVar.aGW.setClickable(false);
                aVar.aGW.setBackgroundResource(i.c.transparent);
                aVar.aGW.setText(i.h.waiting);
                aVar.aGW.setTextColor(z ? this.mContext.getResources().getColor(i.c.cp_cont_d) : this.mContext.getResources().getColor(i.c.cp_cont_d_1));
                return;
            }
            aVar.aGW.setClickable(true);
            aVar.aGW.setText(i.h.frs_recommend_friend_item_add);
        }
    }

    public void an(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aYt != null && this.aYt.rR() != null && TextUtils.equals(this.aYt.rR().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aYt.rR().getUserId()))) {
            this.aYt.rR().rV();
            notifyDataSetChanged();
        }
    }

    public void a(br.a aVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (rVar != null && aVar != null) {
            if (rVar.getLbsInfo() != null) {
                if (rVar.getLbsInfo().yA() == 1) {
                    aVar.aFj.setVisibility(0);
                    com.baidu.tbadk.core.util.an.b(aVar.aFj, this.aFf, 1);
                    aVar.aFj.setText(this.mContext.getResources().getString(i.h.contact_yinshen));
                    aVar.aFj.setCompoundDrawables(null, null, null, null);
                    aVar.aGT.setVisibility(8);
                } else if (rVar.getLbsInfo().yA() == 0) {
                    if (StringUtils.isNull(rVar.getLbsInfo().getDistance())) {
                        aVar.aFj.setVisibility(8);
                        aVar.aGT.setVisibility(0);
                    } else {
                        aVar.aGT.setVisibility(8);
                        aVar.aFj.setVisibility(0);
                        aVar.aFj.setText(String.valueOf(this.mContext.getString(i.h.distance_of_you)) + rVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.an.b(aVar.aFj, this.aFf, 1);
                        this.aFg = com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_pin);
                        this.aFg.setBounds(0, 0, this.size, this.size);
                        aVar.aFj.setCompoundDrawables(this.aFg, null, null, null);
                    }
                } else {
                    aVar.aFj.setVisibility(8);
                    aVar.aGT.setVisibility(0);
                }
            } else {
                aVar.aFj.setVisibility(8);
                aVar.aGT.setVisibility(0);
            }
            if (rVar.rR() != null && StringUtils.isNull(rVar.rR().rZ())) {
                aVar.aGT.setVisibility(8);
            }
        }
    }
}
