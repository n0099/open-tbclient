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
    private com.baidu.tbadk.core.data.s aMD;
    private int axO;
    private Drawable axP;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cb(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.axO = com.baidu.tieba.s.cp_cont_d;
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
        this.aMD = sVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.ba.i(ayVar.aKU, com.baidu.tieba.u.frs_item_control_btn_bg);
        ayVar.aKT.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.tieba.s.transparent));
        ayVar.aKT.setPadding(0, this.aIc, 0, 0);
        ayVar.aKV.azF.setOnClickListener(new cc(this, sVar));
        view.setOnClickListener(new cd(this, sVar));
        this.aKd.getLayoutMode().X(z);
        this.aKd.getLayoutMode().h(view);
        a(ayVar, sVar, z);
        return view;
    }

    private void a(ay ayVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (ayVar != null && sVar != null && sVar.qq() != null) {
            a(ayVar.aKV, sVar.qq(), z);
            if (sVar.qn() > 0) {
                if (!TextUtils.isEmpty(sVar.qo())) {
                    ayVar.azq.setText(sVar.qo());
                }
                if (sVar.qn() < 3) {
                    ayVar.azr.setVisibility(8);
                } else {
                    ayVar.azr.setVisibility(0);
                    ayVar.azr.setText(com.baidu.tieba.y.add_friend_forum_count);
                }
            } else {
                ayVar.azy.setVisibility(8);
                ayVar.aKW.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.px().pB() && sVar.qr() != null && sVar.qr().size() > 0) {
                ayVar.azx.setVisibility(0);
                if (sVar.qq().qx()) {
                    ayVar.azs.setText(com.baidu.tieba.y.add_friend_her_posts);
                } else {
                    ayVar.azs.setText(com.baidu.tieba.y.add_friend_his_posts);
                }
                switch (sVar.qr().size()) {
                    case 1:
                        ayVar.azu.setVisibility(0);
                        ayVar.azv.setVisibility(4);
                        ayVar.azw.setVisibility(4);
                        ayVar.azu.c(sVar.qr().get(0), 10, false);
                        break;
                    case 2:
                        ayVar.azu.setVisibility(0);
                        ayVar.azv.setVisibility(0);
                        ayVar.azw.setVisibility(4);
                        ayVar.azu.c(sVar.qr().get(0), 10, false);
                        ayVar.azv.c(sVar.qr().get(1), 10, false);
                        break;
                    default:
                        ayVar.azu.setVisibility(0);
                        ayVar.azv.setVisibility(0);
                        ayVar.azw.setVisibility(0);
                        ayVar.azu.c(sVar.qr().get(0), 10, false);
                        ayVar.azv.c(sVar.qr().get(1), 10, false);
                        ayVar.azw.c(sVar.qr().get(2), 10, false);
                        break;
                }
            } else {
                ayVar.azx.setVisibility(8);
                ayVar.aKW.setVisibility(8);
            }
            ce ceVar = new ce(this, sVar);
            ayVar.azu.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azv.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azw.setTag(com.baidu.tieba.v.tag_first, sVar);
            ayVar.azu.setTag(com.baidu.tieba.v.tag_second, 0);
            ayVar.azv.setTag(com.baidu.tieba.v.tag_second, 1);
            ayVar.azw.setTag(com.baidu.tieba.v.tag_second, 2);
            ayVar.azu.setOnClickListener(ceVar);
            ayVar.azv.setOnClickListener(ceVar);
            ayVar.azw.setOnClickListener(ceVar);
        }
    }

    private void a(az azVar, com.baidu.tbadk.core.data.t tVar, boolean z) {
        if (tVar != null && azVar != null) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                azVar.azz.setVisibility(0);
                if (!TextUtils.isEmpty(tVar.qw())) {
                    azVar.azz.setUserId(String.valueOf(tVar.getUserId()));
                    azVar.azz.setImageDrawable(null);
                    azVar.azz.c(tVar.qw(), 12, false);
                }
            } else {
                azVar.azz.setVisibility(8);
            }
            if (tVar.qz() != null && !TextUtils.isEmpty(tVar.qz().getUrl())) {
                azVar.azA.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tVar.qz());
                azVar.azA.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                azVar.azA.setVisibility(8);
            }
            azVar.azB.setText(tVar.getName());
            azVar.azC.setText(tVar.qy());
            if (tVar.qx()) {
                com.baidu.tbadk.core.util.ba.c(azVar.azG, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.ba.c(azVar.azG, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            a(azVar, this.aMD, z);
            if (tVar.qv()) {
                azVar.azF.setClickable(false);
                azVar.azF.setBackgroundResource(com.baidu.tieba.s.transparent);
                azVar.azF.setText(com.baidu.tieba.y.waiting);
                azVar.azF.setTextColor(z ? this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d) : this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                return;
            }
            azVar.azF.setClickable(true);
            azVar.azF.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
        }
    }

    public void al(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aMD != null && this.aMD.qq() != null && TextUtils.equals(this.aMD.qq().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aMD.qq().getUserId()))) {
            this.aMD.qq().qu();
            notifyDataSetChanged();
        }
    }

    public void a(az azVar, com.baidu.tbadk.core.data.s sVar, boolean z) {
        if (sVar != null && azVar != null) {
            if (sVar.getLbsInfo() != null) {
                if (sVar.getLbsInfo().wK() == 1) {
                    azVar.axT.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.b(azVar.axT, this.axO, 1);
                    azVar.axT.setText(this.mContext.getResources().getString(com.baidu.tieba.y.contact_yinshen));
                    azVar.axT.setCompoundDrawables(null, null, null, null);
                    azVar.azC.setVisibility(8);
                } else if (sVar.getLbsInfo().wK() == 0) {
                    if (StringUtils.isNull(sVar.getLbsInfo().getDistance())) {
                        azVar.axT.setVisibility(8);
                        azVar.azC.setVisibility(0);
                    } else {
                        azVar.azC.setVisibility(8);
                        azVar.axT.setVisibility(0);
                        azVar.axT.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.distance_of_you)) + sVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.ba.b(azVar.axT, this.axO, 1);
                        this.axP = com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_friend_pin);
                        this.axP.setBounds(0, 0, this.size, this.size);
                        azVar.axT.setCompoundDrawables(this.axP, null, null, null);
                    }
                } else {
                    azVar.axT.setVisibility(8);
                    azVar.azC.setVisibility(0);
                }
            } else {
                azVar.axT.setVisibility(8);
                azVar.azC.setVisibility(0);
            }
            if (sVar.qq() != null && StringUtils.isNull(sVar.qq().qy())) {
                azVar.azC.setVisibility(8);
            }
        }
    }
}
