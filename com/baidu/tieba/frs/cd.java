package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cd extends bf<com.baidu.tbadk.core.data.ax, bl> {
    private int aUj;
    private Drawable aUk;
    private com.baidu.tbadk.core.data.ax bSB;
    private int size;

    public cd(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aUj = r.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(r.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) blVar);
        this.bSB = axVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.av.k(blVar.bRe, r.f.frs_item_control_btn_bg);
        blVar.bRd.setBackgroundColor(this.mContext.getResources().getColor(r.d.common_color_10022));
        blVar.bRd.setPadding(0, bQE, 0, 0);
        blVar.bRf.aVY.setOnClickListener(new ce(this, axVar));
        view.setOnClickListener(new cf(this, axVar));
        this.aRd.getLayoutMode().ah(z);
        this.aRd.getLayoutMode().x(view);
        a(blVar, axVar, z);
        return view;
    }

    private void a(bl blVar, com.baidu.tbadk.core.data.ax axVar, boolean z) {
        if (blVar != null && axVar != null && axVar.qP() != null) {
            a(blVar.bRf, axVar.qP(), z);
            if (axVar.qM() > 0) {
                if (!TextUtils.isEmpty(axVar.qN())) {
                    blVar.aVJ.setText(axVar.qN());
                }
                if (axVar.qM() < 3) {
                    blVar.aVK.setVisibility(8);
                } else {
                    blVar.aVK.setVisibility(0);
                    blVar.aVK.setText(r.j.add_friend_forum_count);
                }
            } else {
                blVar.aVR.setVisibility(8);
                blVar.bRg.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.oH().oN() && axVar.qQ() != null && axVar.qQ().size() > 0) {
                blVar.aVQ.setVisibility(0);
                if (axVar.qP().ra()) {
                    blVar.aVL.setText(r.j.add_friend_her_posts);
                } else {
                    blVar.aVL.setText(r.j.add_friend_his_posts);
                }
                switch (axVar.qQ().size()) {
                    case 1:
                        blVar.aVN.setVisibility(0);
                        blVar.aVO.setVisibility(4);
                        blVar.aVP.setVisibility(4);
                        blVar.aVN.c(axVar.qQ().get(0), 10, false);
                        break;
                    case 2:
                        blVar.aVN.setVisibility(0);
                        blVar.aVO.setVisibility(0);
                        blVar.aVP.setVisibility(4);
                        blVar.aVN.c(axVar.qQ().get(0), 10, false);
                        blVar.aVO.c(axVar.qQ().get(1), 10, false);
                        break;
                    default:
                        blVar.aVN.setVisibility(0);
                        blVar.aVO.setVisibility(0);
                        blVar.aVP.setVisibility(0);
                        blVar.aVN.c(axVar.qQ().get(0), 10, false);
                        blVar.aVO.c(axVar.qQ().get(1), 10, false);
                        blVar.aVP.c(axVar.qQ().get(2), 10, false);
                        break;
                }
            } else {
                blVar.aVQ.setVisibility(8);
                blVar.bRg.setVisibility(8);
            }
            cg cgVar = new cg(this, axVar);
            blVar.aVN.setTag(r.g.tag_first, axVar);
            blVar.aVO.setTag(r.g.tag_first, axVar);
            blVar.aVP.setTag(r.g.tag_first, axVar);
            blVar.aVN.setTag(r.g.tag_second, 0);
            blVar.aVO.setTag(r.g.tag_second, 1);
            blVar.aVP.setTag(r.g.tag_second, 2);
            blVar.aVN.setOnClickListener(cgVar);
            blVar.aVO.setOnClickListener(cgVar);
            blVar.aVP.setOnClickListener(cgVar);
        }
    }

    private void a(bl.a aVar, com.baidu.tbadk.core.data.az azVar, boolean z) {
        if (azVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.oH().oJ()) {
                aVar.aVS.setVisibility(0);
                if (!TextUtils.isEmpty(azVar.qZ())) {
                    aVar.aVS.setUserId(String.valueOf(azVar.getUserId()));
                    aVar.aVS.setImageDrawable(null);
                    aVar.aVS.c(azVar.qZ(), 12, false);
                }
            } else {
                aVar.aVS.setVisibility(8);
            }
            if (azVar.rc() != null && !TextUtils.isEmpty(azVar.rc().getUrl())) {
                aVar.aVT.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(azVar.rc());
                aVar.aVT.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds8));
            } else {
                aVar.aVT.setVisibility(8);
            }
            aVar.aVU.setText(azVar.getName());
            aVar.aVV.setText(azVar.rb());
            if (azVar.ra()) {
                com.baidu.tbadk.core.util.av.c(aVar.aVZ, r.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.av.c(aVar.aVZ, r.f.icon_pop_qz_boy);
            }
            a(aVar, this.bSB, z);
            if (azVar.qY()) {
                aVar.aVY.setClickable(false);
                aVar.aVY.setBackgroundResource(r.d.common_color_10022);
                aVar.aVY.setText(r.j.waiting);
                aVar.aVY.setTextColor(z ? this.mContext.getResources().getColor(r.d.cp_cont_d) : this.mContext.getResources().getColor(r.d.cp_cont_d_1));
                return;
            }
            aVar.aVY.setClickable(true);
            aVar.aVY.setText(r.j.frs_recommend_friend_item_add);
        }
    }

    public void aw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bSB != null && this.bSB.qP() != null && TextUtils.equals(this.bSB.qP().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bSB.qP().getUserId()))) {
            this.bSB.qP().qX();
            notifyDataSetChanged();
        }
    }

    public void a(bl.a aVar, com.baidu.tbadk.core.data.ax axVar, boolean z) {
        if (axVar != null && aVar != null) {
            if (axVar.getLbsInfo() != null) {
                if (axVar.getLbsInfo().Au() == 1) {
                    aVar.aUn.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(aVar.aUn, this.aUj, 1);
                    aVar.aUn.setText(this.mContext.getResources().getString(r.j.contact_yinshen));
                    aVar.aUn.setCompoundDrawables(null, null, null, null);
                    aVar.aVV.setVisibility(8);
                } else if (axVar.getLbsInfo().Au() == 0) {
                    if (StringUtils.isNull(axVar.getLbsInfo().At())) {
                        aVar.aUn.setVisibility(8);
                        aVar.aVV.setVisibility(0);
                    } else {
                        aVar.aVV.setVisibility(8);
                        aVar.aUn.setVisibility(0);
                        aVar.aUn.setText(String.valueOf(this.mContext.getString(r.j.distance_of_you)) + axVar.getLbsInfo().At());
                        com.baidu.tbadk.core.util.av.c(aVar.aUn, this.aUj, 1);
                        this.aUk = com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_friend_pin);
                        this.aUk.setBounds(0, 0, this.size, this.size);
                        aVar.aUn.setCompoundDrawables(this.aUk, null, null, null);
                    }
                } else {
                    aVar.aUn.setVisibility(8);
                    aVar.aVV.setVisibility(0);
                }
            } else {
                aVar.aUn.setVisibility(8);
                aVar.aVV.setVisibility(0);
            }
            if (axVar.qP() != null && StringUtils.isNull(axVar.qP().rb())) {
                aVar.aVV.setVisibility(8);
            }
        }
    }
}
