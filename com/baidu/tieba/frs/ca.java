package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ca extends av<com.baidu.tbadk.core.data.s, ay> {
    private com.baidu.tbadk.core.data.s aON;
    private int azA;
    private Drawable azB;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public ca(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.azA = com.baidu.tieba.n.cp_cont_d;
        this.size = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.o.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public ay a(ViewGroup viewGroup) {
        return new ay(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_recommend_friend_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar, ay ayVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tbadk.core.data.s) ayVar);
        this.aON = sVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.ay.i(ayVar.aNb, com.baidu.tieba.p.frs_item_control_btn_bg);
        ayVar.aNa.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.n.transparent));
        ayVar.aNa.setPadding(0, this.aKk, 0, 0);
        ayVar.aNc.aBq.setOnClickListener(new cb(this, sVar));
        view.setOnClickListener(new cc(this, sVar));
        this.aMk.getLayoutMode().ab(z);
        this.aMk.getLayoutMode().j(view);
        a(ayVar, sVar, z);
        return view;
    }

    private void a(ay ayVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (ayVar != null && sVar != null && sVar.qW() != null) {
            a(ayVar.aNc, sVar.qW(), z);
            if (sVar.qT() > 0) {
                if (!TextUtils.isEmpty(sVar.qU())) {
                    ayVar.aBb.setText(sVar.qU());
                }
                if (sVar.qT() < 3) {
                    ayVar.aBc.setVisibility(8);
                } else {
                    ayVar.aBc.setVisibility(0);
                    ayVar.aBc.setText(com.baidu.tieba.t.add_friend_forum_count);
                }
            } else {
                ayVar.aBj.setVisibility(8);
                ayVar.aNd.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.qc().qg() && sVar.qX() != null && sVar.qX().size() > 0) {
                ayVar.aBi.setVisibility(0);
                if (sVar.qW().rd()) {
                    ayVar.aBd.setText(com.baidu.tieba.t.add_friend_her_posts);
                } else {
                    ayVar.aBd.setText(com.baidu.tieba.t.add_friend_his_posts);
                }
                switch (sVar.qX().size()) {
                    case 1:
                        ayVar.aBf.setVisibility(0);
                        ayVar.aBg.setVisibility(4);
                        ayVar.aBh.setVisibility(4);
                        ayVar.aBf.c(sVar.qX().get(0), 10, false);
                        break;
                    case 2:
                        ayVar.aBf.setVisibility(0);
                        ayVar.aBg.setVisibility(0);
                        ayVar.aBh.setVisibility(4);
                        ayVar.aBf.c(sVar.qX().get(0), 10, false);
                        ayVar.aBg.c(sVar.qX().get(1), 10, false);
                        break;
                    default:
                        ayVar.aBf.setVisibility(0);
                        ayVar.aBg.setVisibility(0);
                        ayVar.aBh.setVisibility(0);
                        ayVar.aBf.c(sVar.qX().get(0), 10, false);
                        ayVar.aBg.c(sVar.qX().get(1), 10, false);
                        ayVar.aBh.c(sVar.qX().get(2), 10, false);
                        break;
                }
            } else {
                ayVar.aBi.setVisibility(8);
                ayVar.aNd.setVisibility(8);
            }
            cd cdVar = new cd(this, sVar);
            ayVar.aBf.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBg.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBh.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBf.setTag(com.baidu.tieba.q.tag_second, 0);
            ayVar.aBg.setTag(com.baidu.tieba.q.tag_second, 1);
            ayVar.aBh.setTag(com.baidu.tieba.q.tag_second, 2);
            ayVar.aBf.setOnClickListener(cdVar);
            ayVar.aBg.setOnClickListener(cdVar);
            ayVar.aBh.setOnClickListener(cdVar);
        }
    }

    private void a(az azVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && azVar != null) {
            if (com.baidu.tbadk.core.n.qc().qe()) {
                azVar.aBk.setVisibility(0);
                if (!TextUtils.isEmpty(tVar.rc())) {
                    azVar.aBk.setUserId(String.valueOf(tVar.getUserId()));
                    azVar.aBk.setImageDrawable(null);
                    azVar.aBk.c(tVar.rc(), 12, false);
                }
            } else {
                azVar.aBk.setVisibility(8);
            }
            if (tVar.rf() != null && !TextUtils.isEmpty(tVar.rf().getUrl())) {
                azVar.aBl.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVar.rf());
                azVar.aBl.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin));
            } else {
                azVar.aBl.setVisibility(8);
            }
            azVar.aBm.setText(tVar.getName());
            azVar.aBn.setText(tVar.re());
            if (tVar.rd()) {
                com.baidu.tbadk.core.util.ay.c(azVar.aBr, com.baidu.tieba.p.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ay.c(azVar.aBr, com.baidu.tieba.p.icon_pop_qz_boy);
            }
            a(azVar, this.aON, z);
            if (tVar.rb()) {
                azVar.aBq.setClickable(false);
                azVar.aBq.setBackgroundResource(com.baidu.tieba.n.transparent);
                azVar.aBq.setText(com.baidu.tieba.t.waiting);
                azVar.aBq.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_d_1));
                return;
            }
            azVar.aBq.setClickable(true);
            azVar.aBq.setText(com.baidu.tieba.t.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aON != null && this.aON.qW() != null && TextUtils.equals(this.aON.qW().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aON.qW().getUserId()))) {
            this.aON.qW().ra();
            notifyDataSetChanged();
        }
    }

    public void a(az azVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && azVar != null) {
            if (sVar.getLbsInfo() != null) {
                if (sVar.getLbsInfo().xx() == 1) {
                    azVar.azE.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.b(azVar.azE, this.azA, 1);
                    azVar.azE.setText(this.mContext.getResources().getString(com.baidu.tieba.t.contact_yinshen));
                    azVar.azE.setCompoundDrawables(null, null, null, null);
                    azVar.aBn.setVisibility(8);
                } else if (sVar.getLbsInfo().xx() == 0) {
                    if (StringUtils.isNull(sVar.getLbsInfo().getDistance())) {
                        azVar.azE.setVisibility(8);
                        azVar.aBn.setVisibility(0);
                    } else {
                        azVar.aBn.setVisibility(8);
                        azVar.azE.setVisibility(0);
                        azVar.azE.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.t.distance_of_you)) + sVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ay.b(azVar.azE, this.azA, 1);
                        this.azB = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_friend_pin);
                        this.azB.setBounds(0, 0, this.size, this.size);
                        azVar.azE.setCompoundDrawables(this.azB, null, null, null);
                    }
                } else {
                    azVar.azE.setVisibility(8);
                    azVar.aBn.setVisibility(0);
                }
            } else {
                azVar.azE.setVisibility(8);
                azVar.aBn.setVisibility(0);
            }
            if (sVar.qW() != null && StringUtils.isNull(sVar.qW().re())) {
                azVar.aBn.setVisibility(8);
            }
        }
    }
}
