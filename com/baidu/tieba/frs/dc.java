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
    private int aGl;
    private Drawable aGm;
    private com.baidu.tbadk.core.data.r aYk;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public dc(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aGl = i.c.cp_cont_d;
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
        this.aYk = rVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.an.i(brVar.aWs, i.e.frs_item_control_btn_bg);
        brVar.aWr.setBackgroundColor(this.mContext.getResources().getColor(i.c.transparent));
        brVar.aWr.setPadding(0, this.aSS, 0, 0);
        brVar.aWt.aIc.setOnClickListener(new dd(this, rVar));
        view.setOnClickListener(new de(this, rVar));
        this.aSe.getLayoutMode().ad(z);
        this.aSe.getLayoutMode().k(view);
        a(brVar, rVar, z);
        return view;
    }

    private void a(br brVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (brVar != null && rVar != null && rVar.rS() != null) {
            a(brVar.aWt, rVar.rS(), z);
            if (rVar.rP() > 0) {
                if (!TextUtils.isEmpty(rVar.rQ())) {
                    brVar.aHN.setText(rVar.rQ());
                }
                if (rVar.rP() < 3) {
                    brVar.aHO.setVisibility(8);
                } else {
                    brVar.aHO.setVisibility(0);
                    brVar.aHO.setText(i.h.add_friend_forum_count);
                }
            } else {
                brVar.aHV.setVisibility(8);
                brVar.aWu.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.qX().rb() && rVar.rT() != null && rVar.rT().size() > 0) {
                brVar.aHU.setVisibility(0);
                if (rVar.rS().rZ()) {
                    brVar.aHP.setText(i.h.add_friend_her_posts);
                } else {
                    brVar.aHP.setText(i.h.add_friend_his_posts);
                }
                switch (rVar.rT().size()) {
                    case 1:
                        brVar.aHR.setVisibility(0);
                        brVar.aHS.setVisibility(4);
                        brVar.aHT.setVisibility(4);
                        brVar.aHR.d(rVar.rT().get(0), 10, false);
                        break;
                    case 2:
                        brVar.aHR.setVisibility(0);
                        brVar.aHS.setVisibility(0);
                        brVar.aHT.setVisibility(4);
                        brVar.aHR.d(rVar.rT().get(0), 10, false);
                        brVar.aHS.d(rVar.rT().get(1), 10, false);
                        break;
                    default:
                        brVar.aHR.setVisibility(0);
                        brVar.aHS.setVisibility(0);
                        brVar.aHT.setVisibility(0);
                        brVar.aHR.d(rVar.rT().get(0), 10, false);
                        brVar.aHS.d(rVar.rT().get(1), 10, false);
                        brVar.aHT.d(rVar.rT().get(2), 10, false);
                        break;
                }
            } else {
                brVar.aHU.setVisibility(8);
                brVar.aWu.setVisibility(8);
            }
            df dfVar = new df(this, rVar);
            brVar.aHR.setTag(i.f.tag_first, rVar);
            brVar.aHS.setTag(i.f.tag_first, rVar);
            brVar.aHT.setTag(i.f.tag_first, rVar);
            brVar.aHR.setTag(i.f.tag_second, 0);
            brVar.aHS.setTag(i.f.tag_second, 1);
            brVar.aHT.setTag(i.f.tag_second, 2);
            brVar.aHR.setOnClickListener(dfVar);
            brVar.aHS.setOnClickListener(dfVar);
            brVar.aHT.setOnClickListener(dfVar);
        }
    }

    private void a(br.a aVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.qX().qZ()) {
                aVar.aHW.setVisibility(0);
                if (!TextUtils.isEmpty(sVar.rY())) {
                    aVar.aHW.setUserId(String.valueOf(sVar.getUserId()));
                    aVar.aHW.setImageDrawable(null);
                    aVar.aHW.d(sVar.rY(), 12, false);
                }
            } else {
                aVar.aHW.setVisibility(8);
            }
            if (sVar.sb() != null && !TextUtils.isEmpty(sVar.sb().getUrl())) {
                aVar.aHX.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(sVar.sb());
                aVar.aHX.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin));
            } else {
                aVar.aHX.setVisibility(8);
            }
            aVar.aHY.setText(sVar.getName());
            aVar.aHZ.setText(sVar.sa());
            if (sVar.rZ()) {
                com.baidu.tbadk.core.util.an.c(aVar.aId, i.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.an.c(aVar.aId, i.e.icon_pop_qz_boy);
            }
            a(aVar, this.aYk, z);
            if (sVar.rX()) {
                aVar.aIc.setClickable(false);
                aVar.aIc.setBackgroundResource(i.c.transparent);
                aVar.aIc.setText(i.h.waiting);
                aVar.aIc.setTextColor(z ? this.mContext.getResources().getColor(i.c.cp_cont_d) : this.mContext.getResources().getColor(i.c.cp_cont_d_1));
                return;
            }
            aVar.aIc.setClickable(true);
            aVar.aIc.setText(i.h.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aYk != null && this.aYk.rS() != null && TextUtils.equals(this.aYk.rS().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aYk.rS().getUserId()))) {
            this.aYk.rS().rW();
            notifyDataSetChanged();
        }
    }

    public void a(br.a aVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (rVar != null && aVar != null) {
            if (rVar.getLbsInfo() != null) {
                if (rVar.getLbsInfo().yy() == 1) {
                    aVar.aGp.setVisibility(0);
                    com.baidu.tbadk.core.util.an.b(aVar.aGp, this.aGl, 1);
                    aVar.aGp.setText(this.mContext.getResources().getString(i.h.contact_yinshen));
                    aVar.aGp.setCompoundDrawables(null, null, null, null);
                    aVar.aHZ.setVisibility(8);
                } else if (rVar.getLbsInfo().yy() == 0) {
                    if (StringUtils.isNull(rVar.getLbsInfo().getDistance())) {
                        aVar.aGp.setVisibility(8);
                        aVar.aHZ.setVisibility(0);
                    } else {
                        aVar.aHZ.setVisibility(8);
                        aVar.aGp.setVisibility(0);
                        aVar.aGp.setText(String.valueOf(this.mContext.getString(i.h.distance_of_you)) + rVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.an.b(aVar.aGp, this.aGl, 1);
                        this.aGm = com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_pin);
                        this.aGm.setBounds(0, 0, this.size, this.size);
                        aVar.aGp.setCompoundDrawables(this.aGm, null, null, null);
                    }
                } else {
                    aVar.aGp.setVisibility(8);
                    aVar.aHZ.setVisibility(0);
                }
            } else {
                aVar.aGp.setVisibility(8);
                aVar.aHZ.setVisibility(0);
            }
            if (rVar.rS() != null && StringUtils.isNull(rVar.rS().sa())) {
                aVar.aHZ.setVisibility(8);
            }
        }
    }
}
