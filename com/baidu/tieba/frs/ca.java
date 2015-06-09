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
    private com.baidu.tbadk.core.data.s aOO;
    private int azB;
    private Drawable azC;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public ca(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.azB = com.baidu.tieba.n.cp_cont_d;
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
        this.aOO = sVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.ay.i(ayVar.aNc, com.baidu.tieba.p.frs_item_control_btn_bg);
        ayVar.aNb.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.n.transparent));
        ayVar.aNb.setPadding(0, this.aKl, 0, 0);
        ayVar.aNd.aBr.setOnClickListener(new cb(this, sVar));
        view.setOnClickListener(new cc(this, sVar));
        this.aMl.getLayoutMode().ab(z);
        this.aMl.getLayoutMode().j(view);
        a(ayVar, sVar, z);
        return view;
    }

    private void a(ay ayVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (ayVar != null && sVar != null && sVar.qW() != null) {
            a(ayVar.aNd, sVar.qW(), z);
            if (sVar.qT() > 0) {
                if (!TextUtils.isEmpty(sVar.qU())) {
                    ayVar.aBc.setText(sVar.qU());
                }
                if (sVar.qT() < 3) {
                    ayVar.aBd.setVisibility(8);
                } else {
                    ayVar.aBd.setVisibility(0);
                    ayVar.aBd.setText(com.baidu.tieba.t.add_friend_forum_count);
                }
            } else {
                ayVar.aBk.setVisibility(8);
                ayVar.aNe.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.qc().qg() && sVar.qX() != null && sVar.qX().size() > 0) {
                ayVar.aBj.setVisibility(0);
                if (sVar.qW().rd()) {
                    ayVar.aBe.setText(com.baidu.tieba.t.add_friend_her_posts);
                } else {
                    ayVar.aBe.setText(com.baidu.tieba.t.add_friend_his_posts);
                }
                switch (sVar.qX().size()) {
                    case 1:
                        ayVar.aBg.setVisibility(0);
                        ayVar.aBh.setVisibility(4);
                        ayVar.aBi.setVisibility(4);
                        ayVar.aBg.c(sVar.qX().get(0), 10, false);
                        break;
                    case 2:
                        ayVar.aBg.setVisibility(0);
                        ayVar.aBh.setVisibility(0);
                        ayVar.aBi.setVisibility(4);
                        ayVar.aBg.c(sVar.qX().get(0), 10, false);
                        ayVar.aBh.c(sVar.qX().get(1), 10, false);
                        break;
                    default:
                        ayVar.aBg.setVisibility(0);
                        ayVar.aBh.setVisibility(0);
                        ayVar.aBi.setVisibility(0);
                        ayVar.aBg.c(sVar.qX().get(0), 10, false);
                        ayVar.aBh.c(sVar.qX().get(1), 10, false);
                        ayVar.aBi.c(sVar.qX().get(2), 10, false);
                        break;
                }
            } else {
                ayVar.aBj.setVisibility(8);
                ayVar.aNe.setVisibility(8);
            }
            cd cdVar = new cd(this, sVar);
            ayVar.aBg.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBh.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBi.setTag(com.baidu.tieba.q.tag_first, sVar);
            ayVar.aBg.setTag(com.baidu.tieba.q.tag_second, 0);
            ayVar.aBh.setTag(com.baidu.tieba.q.tag_second, 1);
            ayVar.aBi.setTag(com.baidu.tieba.q.tag_second, 2);
            ayVar.aBg.setOnClickListener(cdVar);
            ayVar.aBh.setOnClickListener(cdVar);
            ayVar.aBi.setOnClickListener(cdVar);
        }
    }

    private void a(az azVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && azVar != null) {
            if (com.baidu.tbadk.core.n.qc().qe()) {
                azVar.aBl.setVisibility(0);
                if (!TextUtils.isEmpty(tVar.rc())) {
                    azVar.aBl.setUserId(String.valueOf(tVar.getUserId()));
                    azVar.aBl.setImageDrawable(null);
                    azVar.aBl.c(tVar.rc(), 12, false);
                }
            } else {
                azVar.aBl.setVisibility(8);
            }
            if (tVar.rf() != null && !TextUtils.isEmpty(tVar.rf().getUrl())) {
                azVar.aBm.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVar.rf());
                azVar.aBm.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin));
            } else {
                azVar.aBm.setVisibility(8);
            }
            azVar.aBn.setText(tVar.getName());
            azVar.aBo.setText(tVar.re());
            if (tVar.rd()) {
                com.baidu.tbadk.core.util.ay.c(azVar.aBs, com.baidu.tieba.p.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ay.c(azVar.aBs, com.baidu.tieba.p.icon_pop_qz_boy);
            }
            a(azVar, this.aOO, z);
            if (tVar.rb()) {
                azVar.aBr.setClickable(false);
                azVar.aBr.setBackgroundResource(com.baidu.tieba.n.transparent);
                azVar.aBr.setText(com.baidu.tieba.t.waiting);
                azVar.aBr.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_d_1));
                return;
            }
            azVar.aBr.setClickable(true);
            azVar.aBr.setText(com.baidu.tieba.t.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aOO != null && this.aOO.qW() != null && TextUtils.equals(this.aOO.qW().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aOO.qW().getUserId()))) {
            this.aOO.qW().ra();
            notifyDataSetChanged();
        }
    }

    public void a(az azVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && azVar != null) {
            if (sVar.getLbsInfo() != null) {
                if (sVar.getLbsInfo().xy() == 1) {
                    azVar.azF.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.b(azVar.azF, this.azB, 1);
                    azVar.azF.setText(this.mContext.getResources().getString(com.baidu.tieba.t.contact_yinshen));
                    azVar.azF.setCompoundDrawables(null, null, null, null);
                    azVar.aBo.setVisibility(8);
                } else if (sVar.getLbsInfo().xy() == 0) {
                    if (StringUtils.isNull(sVar.getLbsInfo().getDistance())) {
                        azVar.azF.setVisibility(8);
                        azVar.aBo.setVisibility(0);
                    } else {
                        azVar.aBo.setVisibility(8);
                        azVar.azF.setVisibility(0);
                        azVar.azF.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.t.distance_of_you)) + sVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ay.b(azVar.azF, this.azB, 1);
                        this.azC = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_friend_pin);
                        this.azC.setBounds(0, 0, this.size, this.size);
                        azVar.azF.setCompoundDrawables(this.azC, null, null, null);
                    }
                } else {
                    azVar.azF.setVisibility(8);
                    azVar.aBo.setVisibility(0);
                }
            } else {
                azVar.azF.setVisibility(8);
                azVar.aBo.setVisibility(0);
            }
            if (sVar.qW() != null && StringUtils.isNull(sVar.qW().re())) {
                azVar.aBo.setVisibility(8);
            }
        }
    }
}
