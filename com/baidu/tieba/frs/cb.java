package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cb extends av<com.baidu.tbadk.core.data.s, ay> {
    private com.baidu.tbadk.core.data.s aMs;
    private int axG;
    private Drawable axH;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cb(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.axG = com.baidu.tieba.s.cp_cont_d;
        this.size = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public ay a(ViewGroup viewGroup) {
        return new ay(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_recommend_friend_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar, ay ayVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tbadk.core.data.s) ayVar);
        this.aMs = sVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.ba.i(ayVar.aKK, com.baidu.tieba.u.frs_item_control_btn_bg);
        ayVar.aKJ.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        ayVar.aKJ.setPadding(0, this.aHU, 0, 0);
        ayVar.aKL.azx.setOnClickListener(new cc(this, sVar));
        view.setOnClickListener(new cd(this, sVar));
        this.aJT.getLayoutMode().X(z);
        this.aJT.getLayoutMode().h(view);
        a(ayVar, sVar, z);
        return view;
    }

    private void a(ay ayVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (ayVar != null && sVar != null && sVar.qq() != null) {
            a(ayVar.aKL, sVar.qq(), z);
            if (sVar.qn() > 0) {
                if (!TextUtils.isEmpty(sVar.qo())) {
                    ayVar.azi.setText(sVar.qo());
                }
                if (sVar.qn() < 3) {
                    ayVar.azj.setVisibility(8);
                } else {
                    ayVar.azj.setVisibility(0);
                    ayVar.azj.setText(com.baidu.tieba.y.add_friend_forum_count);
                }
            } else {
                ayVar.azq.setVisibility(8);
                ayVar.aKM.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.px().pB() && sVar.qr() != null && sVar.qr().size() > 0) {
                ayVar.azp.setVisibility(0);
                if (sVar.qq().qx()) {
                    ayVar.azk.setText(com.baidu.tieba.y.add_friend_her_posts);
                } else {
                    ayVar.azk.setText(com.baidu.tieba.y.add_friend_his_posts);
                }
                switch (sVar.qr().size()) {
                    case 1:
                        ayVar.azm.setVisibility(0);
                        ayVar.azn.setVisibility(4);
                        ayVar.azo.setVisibility(4);
                        ayVar.azm.c(sVar.qr().get(0), 10, false);
                        break;
                    case 2:
                        ayVar.azm.setVisibility(0);
                        ayVar.azn.setVisibility(0);
                        ayVar.azo.setVisibility(4);
                        ayVar.azm.c(sVar.qr().get(0), 10, false);
                        ayVar.azn.c(sVar.qr().get(1), 10, false);
                        break;
                    default:
                        ayVar.azm.setVisibility(0);
                        ayVar.azn.setVisibility(0);
                        ayVar.azo.setVisibility(0);
                        ayVar.azm.c(sVar.qr().get(0), 10, false);
                        ayVar.azn.c(sVar.qr().get(1), 10, false);
                        ayVar.azo.c(sVar.qr().get(2), 10, false);
                        break;
                }
            } else {
                ayVar.azp.setVisibility(8);
                ayVar.aKM.setVisibility(8);
            }
            ce ceVar = new ce(this, sVar);
            ayVar.azm.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azn.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azo.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azm.setTag(com.baidu.tieba.v.tag_second, 0);
            ayVar.azn.setTag(com.baidu.tieba.v.tag_second, 1);
            ayVar.azo.setTag(com.baidu.tieba.v.tag_second, 2);
            ayVar.azm.setOnClickListener(ceVar);
            ayVar.azn.setOnClickListener(ceVar);
            ayVar.azo.setOnClickListener(ceVar);
        }
    }

    private void a(az azVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && azVar != null) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                azVar.azr.setVisibility(0);
                if (!TextUtils.isEmpty(tVar.qw())) {
                    azVar.azr.setUserId(String.valueOf(tVar.getUserId()));
                    azVar.azr.setImageDrawable(null);
                    azVar.azr.c(tVar.qw(), 12, false);
                }
            } else {
                azVar.azr.setVisibility(8);
            }
            if (tVar.qz() != null && !TextUtils.isEmpty(tVar.qz().getUrl())) {
                azVar.azs.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVar.qz());
                azVar.azs.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                azVar.azs.setVisibility(8);
            }
            azVar.azt.setText(tVar.getName());
            azVar.azu.setText(tVar.qy());
            if (tVar.qx()) {
                com.baidu.tbadk.core.util.ba.c(azVar.azy, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ba.c(azVar.azy, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            a(azVar, this.aMs, z);
            if (tVar.qv()) {
                azVar.azx.setClickable(false);
                azVar.azx.setBackgroundResource(com.baidu.tieba.s.transparent);
                azVar.azx.setText(com.baidu.tieba.y.waiting);
                azVar.azx.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                return;
            }
            azVar.azx.setClickable(true);
            azVar.azx.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
        }
    }

    public void al(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aMs != null && this.aMs.qq() != null && TextUtils.equals(this.aMs.qq().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aMs.qq().getUserId()))) {
            this.aMs.qq().qu();
            notifyDataSetChanged();
        }
    }

    public void a(az azVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && azVar != null) {
            if (sVar.getLbsInfo() != null) {
                if (sVar.getLbsInfo().wE() == 1) {
                    azVar.axL.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.b(azVar.axL, this.axG, 1);
                    azVar.axL.setText(this.mContext.getResources().getString(com.baidu.tieba.y.contact_yinshen));
                    azVar.axL.setCompoundDrawables(null, null, null, null);
                    azVar.azu.setVisibility(8);
                } else if (sVar.getLbsInfo().wE() == 0) {
                    if (StringUtils.isNull(sVar.getLbsInfo().getDistance())) {
                        azVar.axL.setVisibility(8);
                        azVar.azu.setVisibility(0);
                    } else {
                        azVar.azu.setVisibility(8);
                        azVar.axL.setVisibility(0);
                        azVar.axL.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.distance_of_you)) + sVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ba.b(azVar.axL, this.axG, 1);
                        this.axH = com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_friend_pin);
                        this.axH.setBounds(0, 0, this.size, this.size);
                        azVar.axL.setCompoundDrawables(this.axH, null, null, null);
                    }
                } else {
                    azVar.axL.setVisibility(8);
                    azVar.azu.setVisibility(0);
                }
            } else {
                azVar.axL.setVisibility(8);
                azVar.azu.setVisibility(0);
            }
            if (sVar.qq() != null && StringUtils.isNull(sVar.qq().qy())) {
                azVar.azu.setVisibility(8);
            }
        }
    }
}
