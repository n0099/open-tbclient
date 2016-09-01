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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cd extends bf<com.baidu.tbadk.core.data.av, bl> {
    private Drawable aTA;
    private int aTz;
    private com.baidu.tbadk.core.data.av bSI;
    private int size;

    public cd(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aTz = t.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(t.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.av avVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) avVar, (com.baidu.tbadk.core.data.av) blVar);
        this.bSI = avVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.av.k(blVar.bRl, t.f.frs_item_control_btn_bg);
        blVar.bRk.setBackgroundColor(this.mContext.getResources().getColor(t.d.common_color_10022));
        blVar.bRk.setPadding(0, bQL, 0, 0);
        blVar.bRm.aVp.setOnClickListener(new ce(this, avVar));
        view.setOnClickListener(new cf(this, avVar));
        this.aPR.getLayoutMode().ah(z);
        this.aPR.getLayoutMode().x(view);
        a(blVar, avVar, z);
        return view;
    }

    private void a(bl blVar, com.baidu.tbadk.core.data.av avVar, boolean z) {
        if (blVar != null && avVar != null && avVar.qE() != null) {
            a(blVar.bRm, avVar.qE(), z);
            if (avVar.qB() > 0) {
                if (!TextUtils.isEmpty(avVar.qC())) {
                    blVar.aVa.setText(avVar.qC());
                }
                if (avVar.qB() < 3) {
                    blVar.aVb.setVisibility(8);
                } else {
                    blVar.aVb.setVisibility(0);
                    blVar.aVb.setText(t.j.add_friend_forum_count);
                }
            } else {
                blVar.aVi.setVisibility(8);
                blVar.bRn.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.oG().oM() && avVar.qF() != null && avVar.qF().size() > 0) {
                blVar.aVh.setVisibility(0);
                if (avVar.qE().qP()) {
                    blVar.aVc.setText(t.j.add_friend_her_posts);
                } else {
                    blVar.aVc.setText(t.j.add_friend_his_posts);
                }
                switch (avVar.qF().size()) {
                    case 1:
                        blVar.aVe.setVisibility(0);
                        blVar.aVf.setVisibility(4);
                        blVar.aVg.setVisibility(4);
                        blVar.aVe.c(avVar.qF().get(0), 10, false);
                        break;
                    case 2:
                        blVar.aVe.setVisibility(0);
                        blVar.aVf.setVisibility(0);
                        blVar.aVg.setVisibility(4);
                        blVar.aVe.c(avVar.qF().get(0), 10, false);
                        blVar.aVf.c(avVar.qF().get(1), 10, false);
                        break;
                    default:
                        blVar.aVe.setVisibility(0);
                        blVar.aVf.setVisibility(0);
                        blVar.aVg.setVisibility(0);
                        blVar.aVe.c(avVar.qF().get(0), 10, false);
                        blVar.aVf.c(avVar.qF().get(1), 10, false);
                        blVar.aVg.c(avVar.qF().get(2), 10, false);
                        break;
                }
            } else {
                blVar.aVh.setVisibility(8);
                blVar.bRn.setVisibility(8);
            }
            cg cgVar = new cg(this, avVar);
            blVar.aVe.setTag(t.g.tag_first, avVar);
            blVar.aVf.setTag(t.g.tag_first, avVar);
            blVar.aVg.setTag(t.g.tag_first, avVar);
            blVar.aVe.setTag(t.g.tag_second, 0);
            blVar.aVf.setTag(t.g.tag_second, 1);
            blVar.aVg.setTag(t.g.tag_second, 2);
            blVar.aVe.setOnClickListener(cgVar);
            blVar.aVf.setOnClickListener(cgVar);
            blVar.aVg.setOnClickListener(cgVar);
        }
    }

    private void a(bl.a aVar, com.baidu.tbadk.core.data.ax axVar, boolean z) {
        if (axVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.oG().oI()) {
                aVar.aVj.setVisibility(0);
                if (!TextUtils.isEmpty(axVar.qO())) {
                    aVar.aVj.setUserId(String.valueOf(axVar.getUserId()));
                    aVar.aVj.setImageDrawable(null);
                    aVar.aVj.c(axVar.qO(), 12, false);
                }
            } else {
                aVar.aVj.setVisibility(8);
            }
            if (axVar.qR() != null && !TextUtils.isEmpty(axVar.qR().getUrl())) {
                aVar.aVk.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(axVar.qR());
                aVar.aVk.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(t.e.ds32), this.mContext.getResources().getDimensionPixelSize(t.e.ds32), this.mContext.getResources().getDimensionPixelSize(t.e.ds8));
            } else {
                aVar.aVk.setVisibility(8);
            }
            aVar.aVl.setText(axVar.getName());
            aVar.aVm.setText(axVar.qQ());
            if (axVar.qP()) {
                com.baidu.tbadk.core.util.av.c(aVar.aVq, t.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.av.c(aVar.aVq, t.f.icon_pop_qz_boy);
            }
            a(aVar, this.bSI, z);
            if (axVar.qN()) {
                aVar.aVp.setClickable(false);
                aVar.aVp.setBackgroundResource(t.d.common_color_10022);
                aVar.aVp.setText(t.j.waiting);
                aVar.aVp.setTextColor(z ? this.mContext.getResources().getColor(t.d.cp_cont_d) : this.mContext.getResources().getColor(t.d.cp_cont_d_1));
                return;
            }
            aVar.aVp.setClickable(true);
            aVar.aVp.setText(t.j.frs_recommend_friend_item_add);
        }
    }

    public void aw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bSI != null && this.bSI.qE() != null && TextUtils.equals(this.bSI.qE().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bSI.qE().getUserId()))) {
            this.bSI.qE().qM();
            notifyDataSetChanged();
        }
    }

    public void a(bl.a aVar, com.baidu.tbadk.core.data.av avVar, boolean z) {
        if (avVar != null && aVar != null) {
            if (avVar.getLbsInfo() != null) {
                if (avVar.getLbsInfo().Ar() == 1) {
                    aVar.aTD.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(aVar.aTD, this.aTz, 1);
                    aVar.aTD.setText(this.mContext.getResources().getString(t.j.contact_yinshen));
                    aVar.aTD.setCompoundDrawables(null, null, null, null);
                    aVar.aVm.setVisibility(8);
                } else if (avVar.getLbsInfo().Ar() == 0) {
                    if (StringUtils.isNull(avVar.getLbsInfo().Aq())) {
                        aVar.aTD.setVisibility(8);
                        aVar.aVm.setVisibility(0);
                    } else {
                        aVar.aVm.setVisibility(8);
                        aVar.aTD.setVisibility(0);
                        aVar.aTD.setText(String.valueOf(this.mContext.getString(t.j.distance_of_you)) + avVar.getLbsInfo().Aq());
                        com.baidu.tbadk.core.util.av.c(aVar.aTD, this.aTz, 1);
                        this.aTA = com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_friend_pin);
                        this.aTA.setBounds(0, 0, this.size, this.size);
                        aVar.aTD.setCompoundDrawables(this.aTA, null, null, null);
                    }
                } else {
                    aVar.aTD.setVisibility(8);
                    aVar.aVm.setVisibility(0);
                }
            } else {
                aVar.aTD.setVisibility(8);
                aVar.aVm.setVisibility(0);
            }
            if (avVar.qE() != null && StringUtils.isNull(avVar.qE().qQ())) {
                aVar.aVm.setVisibility(8);
            }
        }
    }
}
