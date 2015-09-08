package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cn extends bd<com.baidu.tbadk.core.data.r, bh> {
    private int aHh;
    private Drawable aHi;
    private com.baidu.tbadk.core.data.r aYx;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cn(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aHh = i.c.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public bh a(ViewGroup viewGroup) {
        return new bh(LayoutInflater.from(this.mContext).inflate(i.g.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.r rVar, bh bhVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tbadk.core.data.r) bhVar);
        this.aYx = rVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.al.h(bhVar.aWO, i.e.frs_item_control_btn_bg);
        bhVar.aWN.setBackgroundColor(this.mContext.getResources().getColor(i.c.transparent));
        bhVar.aWN.setPadding(0, this.aTL, 0, 0);
        bhVar.aWP.aIZ.setOnClickListener(new co(this, rVar));
        view.setOnClickListener(new cp(this, rVar));
        this.aSX.getLayoutMode().ad(z);
        this.aSX.getLayoutMode().k(view);
        a(bhVar, rVar, z);
        return view;
    }

    private void a(bh bhVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (bhVar != null && rVar != null && rVar.rX() != null) {
            a(bhVar.aWP, rVar.rX(), z);
            if (rVar.rU() > 0) {
                if (!TextUtils.isEmpty(rVar.rV())) {
                    bhVar.aIK.setText(rVar.rV());
                }
                if (rVar.rU() < 3) {
                    bhVar.aIL.setVisibility(8);
                } else {
                    bhVar.aIL.setVisibility(0);
                    bhVar.aIL.setText(i.h.add_friend_forum_count);
                }
            } else {
                bhVar.aIS.setVisibility(8);
                bhVar.aWQ.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.rb().rf() && rVar.rY() != null && rVar.rY().size() > 0) {
                bhVar.aIR.setVisibility(0);
                if (rVar.rX().se()) {
                    bhVar.aIM.setText(i.h.add_friend_her_posts);
                } else {
                    bhVar.aIM.setText(i.h.add_friend_his_posts);
                }
                switch (rVar.rY().size()) {
                    case 1:
                        bhVar.aIO.setVisibility(0);
                        bhVar.aIP.setVisibility(4);
                        bhVar.aIQ.setVisibility(4);
                        bhVar.aIO.d(rVar.rY().get(0), 10, false);
                        break;
                    case 2:
                        bhVar.aIO.setVisibility(0);
                        bhVar.aIP.setVisibility(0);
                        bhVar.aIQ.setVisibility(4);
                        bhVar.aIO.d(rVar.rY().get(0), 10, false);
                        bhVar.aIP.d(rVar.rY().get(1), 10, false);
                        break;
                    default:
                        bhVar.aIO.setVisibility(0);
                        bhVar.aIP.setVisibility(0);
                        bhVar.aIQ.setVisibility(0);
                        bhVar.aIO.d(rVar.rY().get(0), 10, false);
                        bhVar.aIP.d(rVar.rY().get(1), 10, false);
                        bhVar.aIQ.d(rVar.rY().get(2), 10, false);
                        break;
                }
            } else {
                bhVar.aIR.setVisibility(8);
                bhVar.aWQ.setVisibility(8);
            }
            cq cqVar = new cq(this, rVar);
            bhVar.aIO.setTag(i.f.tag_first, rVar);
            bhVar.aIP.setTag(i.f.tag_first, rVar);
            bhVar.aIQ.setTag(i.f.tag_first, rVar);
            bhVar.aIO.setTag(i.f.tag_second, 0);
            bhVar.aIP.setTag(i.f.tag_second, 1);
            bhVar.aIQ.setTag(i.f.tag_second, 2);
            bhVar.aIO.setOnClickListener(cqVar);
            bhVar.aIP.setOnClickListener(cqVar);
            bhVar.aIQ.setOnClickListener(cqVar);
        }
    }

    private void a(bh.a aVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.rb().rd()) {
                aVar.aIT.setVisibility(0);
                if (!TextUtils.isEmpty(sVar.sd())) {
                    aVar.aIT.setUserId(String.valueOf(sVar.getUserId()));
                    aVar.aIT.setImageDrawable(null);
                    aVar.aIT.d(sVar.sd(), 12, false);
                }
            } else {
                aVar.aIT.setVisibility(8);
            }
            if (sVar.sg() != null && !TextUtils.isEmpty(sVar.sg().getUrl())) {
                aVar.aIU.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(sVar.sg());
                aVar.aIU.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin));
            } else {
                aVar.aIU.setVisibility(8);
            }
            aVar.aIV.setText(sVar.getName());
            aVar.aIW.setText(sVar.sf());
            if (sVar.se()) {
                com.baidu.tbadk.core.util.al.c(aVar.aJa, i.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.al.c(aVar.aJa, i.e.icon_pop_qz_boy);
            }
            a(aVar, this.aYx, z);
            if (sVar.sc()) {
                aVar.aIZ.setClickable(false);
                aVar.aIZ.setBackgroundResource(i.c.transparent);
                aVar.aIZ.setText(i.h.waiting);
                aVar.aIZ.setTextColor(z ? this.mContext.getResources().getColor(i.c.cp_cont_d) : this.mContext.getResources().getColor(i.c.cp_cont_d_1));
                return;
            }
            aVar.aIZ.setClickable(true);
            aVar.aIZ.setText(i.h.frs_recommend_friend_item_add);
        }
    }

    public void ar(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aYx != null && this.aYx.rX() != null && TextUtils.equals(this.aYx.rX().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aYx.rX().getUserId()))) {
            this.aYx.rX().sb();
            notifyDataSetChanged();
        }
    }

    public void a(bh.a aVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (rVar != null && aVar != null) {
            if (rVar.getLbsInfo() != null) {
                if (rVar.getLbsInfo().yO() == 1) {
                    aVar.aHl.setVisibility(0);
                    com.baidu.tbadk.core.util.al.b(aVar.aHl, this.aHh, 1);
                    aVar.aHl.setText(this.mContext.getResources().getString(i.h.contact_yinshen));
                    aVar.aHl.setCompoundDrawables(null, null, null, null);
                    aVar.aIW.setVisibility(8);
                } else if (rVar.getLbsInfo().yO() == 0) {
                    if (StringUtils.isNull(rVar.getLbsInfo().getDistance())) {
                        aVar.aHl.setVisibility(8);
                        aVar.aIW.setVisibility(0);
                    } else {
                        aVar.aIW.setVisibility(8);
                        aVar.aHl.setVisibility(0);
                        aVar.aHl.setText(String.valueOf(this.mContext.getString(i.h.distance_of_you)) + rVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.al.b(aVar.aHl, this.aHh, 1);
                        this.aHi = com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_pin);
                        this.aHi.setBounds(0, 0, this.size, this.size);
                        aVar.aHl.setCompoundDrawables(this.aHi, null, null, null);
                    }
                } else {
                    aVar.aHl.setVisibility(8);
                    aVar.aIW.setVisibility(0);
                }
            } else {
                aVar.aHl.setVisibility(8);
                aVar.aIW.setVisibility(0);
            }
            if (rVar.rX() != null && StringUtils.isNull(rVar.rX().sf())) {
                aVar.aIW.setVisibility(8);
            }
        }
    }
}
