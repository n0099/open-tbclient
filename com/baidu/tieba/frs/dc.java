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
public class dc extends bn<com.baidu.tbadk.core.data.q, br> {
    private int aGa;
    private Drawable aGb;
    private com.baidu.tbadk.core.data.q aXZ;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public dc(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aGa = i.c.cp_cont_d;
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar, br brVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tbadk.core.data.q) brVar);
        this.aXZ = qVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.am.i(brVar.aWh, i.e.frs_item_control_btn_bg);
        brVar.aWg.setBackgroundColor(this.mContext.getResources().getColor(i.c.transparent));
        brVar.aWg.setPadding(0, this.aSH, 0, 0);
        brVar.aWi.aHR.setOnClickListener(new dd(this, qVar));
        view.setOnClickListener(new de(this, qVar));
        this.aRT.getLayoutMode().ad(z);
        this.aRT.getLayoutMode().k(view);
        a(brVar, qVar, z);
        return view;
    }

    private void a(br brVar, com.baidu.tbadk.core.data.q qVar, boolean z) {
        if (brVar != null && qVar != null && qVar.rS() != null) {
            a(brVar.aWi, qVar.rS(), z);
            if (qVar.rP() > 0) {
                if (!TextUtils.isEmpty(qVar.rQ())) {
                    brVar.aHC.setText(qVar.rQ());
                }
                if (qVar.rP() < 3) {
                    brVar.aHD.setVisibility(8);
                } else {
                    brVar.aHD.setVisibility(0);
                    brVar.aHD.setText(i.h.add_friend_forum_count);
                }
            } else {
                brVar.aHK.setVisibility(8);
                brVar.aWj.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.qX().rb() && qVar.rT() != null && qVar.rT().size() > 0) {
                brVar.aHJ.setVisibility(0);
                if (qVar.rS().rZ()) {
                    brVar.aHE.setText(i.h.add_friend_her_posts);
                } else {
                    brVar.aHE.setText(i.h.add_friend_his_posts);
                }
                switch (qVar.rT().size()) {
                    case 1:
                        brVar.aHG.setVisibility(0);
                        brVar.aHH.setVisibility(4);
                        brVar.aHI.setVisibility(4);
                        brVar.aHG.d(qVar.rT().get(0), 10, false);
                        break;
                    case 2:
                        brVar.aHG.setVisibility(0);
                        brVar.aHH.setVisibility(0);
                        brVar.aHI.setVisibility(4);
                        brVar.aHG.d(qVar.rT().get(0), 10, false);
                        brVar.aHH.d(qVar.rT().get(1), 10, false);
                        break;
                    default:
                        brVar.aHG.setVisibility(0);
                        brVar.aHH.setVisibility(0);
                        brVar.aHI.setVisibility(0);
                        brVar.aHG.d(qVar.rT().get(0), 10, false);
                        brVar.aHH.d(qVar.rT().get(1), 10, false);
                        brVar.aHI.d(qVar.rT().get(2), 10, false);
                        break;
                }
            } else {
                brVar.aHJ.setVisibility(8);
                brVar.aWj.setVisibility(8);
            }
            df dfVar = new df(this, qVar);
            brVar.aHG.setTag(i.f.tag_first, qVar);
            brVar.aHH.setTag(i.f.tag_first, qVar);
            brVar.aHI.setTag(i.f.tag_first, qVar);
            brVar.aHG.setTag(i.f.tag_second, 0);
            brVar.aHH.setTag(i.f.tag_second, 1);
            brVar.aHI.setTag(i.f.tag_second, 2);
            brVar.aHG.setOnClickListener(dfVar);
            brVar.aHH.setOnClickListener(dfVar);
            brVar.aHI.setOnClickListener(dfVar);
        }
    }

    private void a(br.a aVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (rVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.qX().qZ()) {
                aVar.aHL.setVisibility(0);
                if (!TextUtils.isEmpty(rVar.rY())) {
                    aVar.aHL.setUserId(String.valueOf(rVar.getUserId()));
                    aVar.aHL.setImageDrawable(null);
                    aVar.aHL.d(rVar.rY(), 12, false);
                }
            } else {
                aVar.aHL.setVisibility(8);
            }
            if (rVar.sb() != null && !TextUtils.isEmpty(rVar.sb().getUrl())) {
                aVar.aHM.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(rVar.sb());
                aVar.aHM.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin));
            } else {
                aVar.aHM.setVisibility(8);
            }
            aVar.aHN.setText(rVar.getName());
            aVar.aHO.setText(rVar.sa());
            if (rVar.rZ()) {
                com.baidu.tbadk.core.util.am.c(aVar.aHS, i.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.am.c(aVar.aHS, i.e.icon_pop_qz_boy);
            }
            a(aVar, this.aXZ, z);
            if (rVar.rX()) {
                aVar.aHR.setClickable(false);
                aVar.aHR.setBackgroundResource(i.c.transparent);
                aVar.aHR.setText(i.h.waiting);
                aVar.aHR.setTextColor(z ? this.mContext.getResources().getColor(i.c.cp_cont_d) : this.mContext.getResources().getColor(i.c.cp_cont_d_1));
                return;
            }
            aVar.aHR.setClickable(true);
            aVar.aHR.setText(i.h.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aXZ != null && this.aXZ.rS() != null && TextUtils.equals(this.aXZ.rS().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aXZ.rS().getUserId()))) {
            this.aXZ.rS().rW();
            notifyDataSetChanged();
        }
    }

    public void a(br.a aVar, com.baidu.tbadk.core.data.q qVar, boolean z) {
        if (qVar != null && aVar != null) {
            if (qVar.getLbsInfo() != null) {
                if (qVar.getLbsInfo().yy() == 1) {
                    aVar.aGe.setVisibility(0);
                    com.baidu.tbadk.core.util.am.b(aVar.aGe, this.aGa, 1);
                    aVar.aGe.setText(this.mContext.getResources().getString(i.h.contact_yinshen));
                    aVar.aGe.setCompoundDrawables(null, null, null, null);
                    aVar.aHO.setVisibility(8);
                } else if (qVar.getLbsInfo().yy() == 0) {
                    if (StringUtils.isNull(qVar.getLbsInfo().getDistance())) {
                        aVar.aGe.setVisibility(8);
                        aVar.aHO.setVisibility(0);
                    } else {
                        aVar.aHO.setVisibility(8);
                        aVar.aGe.setVisibility(0);
                        aVar.aGe.setText(String.valueOf(this.mContext.getString(i.h.distance_of_you)) + qVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.am.b(aVar.aGe, this.aGa, 1);
                        this.aGb = com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_friend_pin);
                        this.aGb.setBounds(0, 0, this.size, this.size);
                        aVar.aGe.setCompoundDrawables(this.aGb, null, null, null);
                    }
                } else {
                    aVar.aGe.setVisibility(8);
                    aVar.aHO.setVisibility(0);
                }
            } else {
                aVar.aGe.setVisibility(8);
                aVar.aHO.setVisibility(0);
            }
            if (qVar.rS() != null && StringUtils.isNull(qVar.rS().sa())) {
                aVar.aHO.setVisibility(8);
            }
        }
    }
}
