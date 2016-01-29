package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dx extends bv<com.baidu.tbadk.core.data.y, cm> {
    private int aKH;
    private Drawable aKI;
    private com.baidu.tbadk.core.data.y blb;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public dx(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aKH = t.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public cm b(ViewGroup viewGroup) {
        return new cm(LayoutInflater.from(this.mContext).inflate(t.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.y yVar, cm cmVar) {
        super.a(i, view, viewGroup, (ViewGroup) yVar, (com.baidu.tbadk.core.data.y) cmVar);
        this.blb = yVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.ar.k(cmVar.bjf, t.f.frs_item_control_btn_bg);
        cmVar.bje.setBackgroundColor(this.mContext.getResources().getColor(t.d.transparent));
        cmVar.bje.setPadding(0, this.beC, 0, 0);
        cmVar.bjg.aMy.setOnClickListener(new dy(this, yVar));
        view.setOnClickListener(new dz(this, yVar));
        this.bdK.getLayoutMode().ac(z);
        this.bdK.getLayoutMode().x(view);
        a(cmVar, yVar, z);
        return view;
    }

    private void a(cm cmVar, com.baidu.tbadk.core.data.y yVar, boolean z) {
        if (cmVar != null && yVar != null && yVar.sE() != null) {
            a(cmVar.bjg, yVar.sE(), z);
            if (yVar.sB() > 0) {
                if (!TextUtils.isEmpty(yVar.sC())) {
                    cmVar.aMj.setText(yVar.sC());
                }
                if (yVar.sB() < 3) {
                    cmVar.aMk.setVisibility(8);
                } else {
                    cmVar.aMk.setVisibility(0);
                    cmVar.aMk.setText(t.j.add_friend_forum_count);
                }
            } else {
                cmVar.aMr.setVisibility(8);
                cmVar.bjh.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.rn().rt() && yVar.sF() != null && yVar.sF().size() > 0) {
                cmVar.aMq.setVisibility(0);
                if (yVar.sE().sP()) {
                    cmVar.aMl.setText(t.j.add_friend_her_posts);
                } else {
                    cmVar.aMl.setText(t.j.add_friend_his_posts);
                }
                switch (yVar.sF().size()) {
                    case 1:
                        cmVar.aMn.setVisibility(0);
                        cmVar.aMo.setVisibility(4);
                        cmVar.aMp.setVisibility(4);
                        cmVar.aMn.d(yVar.sF().get(0), 10, false);
                        break;
                    case 2:
                        cmVar.aMn.setVisibility(0);
                        cmVar.aMo.setVisibility(0);
                        cmVar.aMp.setVisibility(4);
                        cmVar.aMn.d(yVar.sF().get(0), 10, false);
                        cmVar.aMo.d(yVar.sF().get(1), 10, false);
                        break;
                    default:
                        cmVar.aMn.setVisibility(0);
                        cmVar.aMo.setVisibility(0);
                        cmVar.aMp.setVisibility(0);
                        cmVar.aMn.d(yVar.sF().get(0), 10, false);
                        cmVar.aMo.d(yVar.sF().get(1), 10, false);
                        cmVar.aMp.d(yVar.sF().get(2), 10, false);
                        break;
                }
            } else {
                cmVar.aMq.setVisibility(8);
                cmVar.bjh.setVisibility(8);
            }
            ea eaVar = new ea(this, yVar);
            cmVar.aMn.setTag(t.g.tag_first, yVar);
            cmVar.aMo.setTag(t.g.tag_first, yVar);
            cmVar.aMp.setTag(t.g.tag_first, yVar);
            cmVar.aMn.setTag(t.g.tag_second, 0);
            cmVar.aMo.setTag(t.g.tag_second, 1);
            cmVar.aMp.setTag(t.g.tag_second, 2);
            cmVar.aMn.setOnClickListener(eaVar);
            cmVar.aMo.setOnClickListener(eaVar);
            cmVar.aMp.setOnClickListener(eaVar);
        }
    }

    private void a(cm.a aVar, com.baidu.tbadk.core.data.aa aaVar, boolean z) {
        if (aaVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.rn().rp()) {
                aVar.aMs.setVisibility(0);
                if (!TextUtils.isEmpty(aaVar.sO())) {
                    aVar.aMs.setUserId(String.valueOf(aaVar.getUserId()));
                    aVar.aMs.setImageDrawable(null);
                    aVar.aMs.d(aaVar.sO(), 12, false);
                }
            } else {
                aVar.aMs.setVisibility(8);
            }
            if (aaVar.sR() != null && !TextUtils.isEmpty(aaVar.sR().getUrl())) {
                aVar.aMt.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aaVar.sR());
                aVar.aMt.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin));
            } else {
                aVar.aMt.setVisibility(8);
            }
            aVar.aMu.setText(aaVar.getName());
            aVar.aMv.setText(aaVar.sQ());
            if (aaVar.sP()) {
                com.baidu.tbadk.core.util.ar.c(aVar.aMz, t.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ar.c(aVar.aMz, t.f.icon_pop_qz_boy);
            }
            a(aVar, this.blb, z);
            if (aaVar.sN()) {
                aVar.aMy.setClickable(false);
                aVar.aMy.setBackgroundResource(t.d.transparent);
                aVar.aMy.setText(t.j.waiting);
                aVar.aMy.setTextColor(z ? this.mContext.getResources().getColor(t.d.cp_cont_d) : this.mContext.getResources().getColor(t.d.cp_cont_d_1));
                return;
            }
            aVar.aMy.setClickable(true);
            aVar.aMy.setText(t.j.frs_recommend_friend_item_add);
        }
    }

    public void ao(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.blb != null && this.blb.sE() != null && TextUtils.equals(this.blb.sE().getName(), str2) && TextUtils.equals(str, String.valueOf(this.blb.sE().getUserId()))) {
            this.blb.sE().sM();
            notifyDataSetChanged();
        }
    }

    public void a(cm.a aVar, com.baidu.tbadk.core.data.y yVar, boolean z) {
        if (yVar != null && aVar != null) {
            if (yVar.getLbsInfo() != null) {
                if (yVar.getLbsInfo().AA() == 1) {
                    aVar.aKL.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.b(aVar.aKL, this.aKH, 1);
                    aVar.aKL.setText(this.mContext.getResources().getString(t.j.contact_yinshen));
                    aVar.aKL.setCompoundDrawables(null, null, null, null);
                    aVar.aMv.setVisibility(8);
                } else if (yVar.getLbsInfo().AA() == 0) {
                    if (StringUtils.isNull(yVar.getLbsInfo().getDistance())) {
                        aVar.aKL.setVisibility(8);
                        aVar.aMv.setVisibility(0);
                    } else {
                        aVar.aMv.setVisibility(8);
                        aVar.aKL.setVisibility(0);
                        aVar.aKL.setText(String.valueOf(this.mContext.getString(t.j.distance_of_you)) + yVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ar.b(aVar.aKL, this.aKH, 1);
                        this.aKI = com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_friend_pin);
                        this.aKI.setBounds(0, 0, this.size, this.size);
                        aVar.aKL.setCompoundDrawables(this.aKI, null, null, null);
                    }
                } else {
                    aVar.aKL.setVisibility(8);
                    aVar.aMv.setVisibility(0);
                }
            } else {
                aVar.aKL.setVisibility(8);
                aVar.aMv.setVisibility(0);
            }
            if (yVar.sE() != null && StringUtils.isNull(yVar.sE().sQ())) {
                aVar.aMv.setVisibility(8);
            }
        }
    }
}
