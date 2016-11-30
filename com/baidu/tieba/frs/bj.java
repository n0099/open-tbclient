package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bj extends aq<com.baidu.tbadk.core.data.az, at> {
    private int aWu;
    private Drawable aWv;
    private com.baidu.tbadk.core.data.az bUQ;
    private int size;

    public bj(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aWu = r.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public at a(ViewGroup viewGroup) {
        return new at(LayoutInflater.from(this.mContext).inflate(r.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.az azVar, at atVar) {
        super.a(i, view, viewGroup, (ViewGroup) azVar, (com.baidu.tbadk.core.data.az) atVar);
        this.bUQ = azVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.at.k(atVar.bTw, r.f.frs_item_control_btn_bg);
        atVar.bTv.setBackgroundColor(this.mContext.getResources().getColor(r.d.common_color_10022));
        atVar.bTv.setPadding(0, bTm, 0, 0);
        atVar.bTx.aYk.setOnClickListener(new bk(this, azVar));
        view.setOnClickListener(new bl(this, azVar));
        this.aTb.getLayoutMode().ai(z);
        this.aTb.getLayoutMode().x(view);
        a(atVar, azVar, z);
        return view;
    }

    private void a(at atVar, com.baidu.tbadk.core.data.az azVar, boolean z) {
        if (atVar != null && azVar != null && azVar.qR() != null) {
            a(atVar.bTx, azVar.qR(), z);
            if (azVar.qO() > 0) {
                if (!TextUtils.isEmpty(azVar.qP())) {
                    atVar.aXV.setText(azVar.qP());
                }
                if (azVar.qO() < 3) {
                    atVar.aXW.setVisibility(8);
                } else {
                    atVar.aXW.setVisibility(0);
                    atVar.aXW.setText(r.j.add_friend_forum_count);
                }
            } else {
                atVar.aYd.setVisibility(8);
                atVar.bTy.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.oJ().oP() && azVar.qS() != null && azVar.qS().size() > 0) {
                atVar.aYc.setVisibility(0);
                if (azVar.qR().rc()) {
                    atVar.aXX.setText(r.j.add_friend_her_posts);
                } else {
                    atVar.aXX.setText(r.j.add_friend_his_posts);
                }
                switch (azVar.qS().size()) {
                    case 1:
                        atVar.aXZ.setVisibility(0);
                        atVar.aYa.setVisibility(4);
                        atVar.aYb.setVisibility(4);
                        atVar.aXZ.c(azVar.qS().get(0), 10, false);
                        break;
                    case 2:
                        atVar.aXZ.setVisibility(0);
                        atVar.aYa.setVisibility(0);
                        atVar.aYb.setVisibility(4);
                        atVar.aXZ.c(azVar.qS().get(0), 10, false);
                        atVar.aYa.c(azVar.qS().get(1), 10, false);
                        break;
                    default:
                        atVar.aXZ.setVisibility(0);
                        atVar.aYa.setVisibility(0);
                        atVar.aYb.setVisibility(0);
                        atVar.aXZ.c(azVar.qS().get(0), 10, false);
                        atVar.aYa.c(azVar.qS().get(1), 10, false);
                        atVar.aYb.c(azVar.qS().get(2), 10, false);
                        break;
                }
            } else {
                atVar.aYc.setVisibility(8);
                atVar.bTy.setVisibility(8);
            }
            bm bmVar = new bm(this, azVar);
            atVar.aXZ.setTag(r.g.tag_first, azVar);
            atVar.aYa.setTag(r.g.tag_first, azVar);
            atVar.aYb.setTag(r.g.tag_first, azVar);
            atVar.aXZ.setTag(r.g.tag_second, 0);
            atVar.aYa.setTag(r.g.tag_second, 1);
            atVar.aYb.setTag(r.g.tag_second, 2);
            atVar.aXZ.setOnClickListener(bmVar);
            atVar.aYa.setOnClickListener(bmVar);
            atVar.aYb.setOnClickListener(bmVar);
        }
    }

    private void a(at.a aVar, com.baidu.tbadk.core.data.bb bbVar, boolean z) {
        if (bbVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.oJ().oL()) {
                aVar.aYe.setVisibility(0);
                if (!TextUtils.isEmpty(bbVar.rb())) {
                    aVar.aYe.setUserId(String.valueOf(bbVar.getUserId()));
                    aVar.aYe.setImageDrawable(null);
                    aVar.aYe.c(bbVar.rb(), 12, false);
                }
            } else {
                aVar.aYe.setVisibility(8);
            }
            if (bbVar.re() != null && !TextUtils.isEmpty(bbVar.re().getUrl())) {
                aVar.aYf.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(bbVar.re());
                aVar.aYf.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds32), this.mContext.getResources().getDimensionPixelSize(r.e.ds8));
            } else {
                aVar.aYf.setVisibility(8);
            }
            aVar.aYg.setText(bbVar.getName());
            aVar.aYh.setText(bbVar.rd());
            if (bbVar.rc()) {
                com.baidu.tbadk.core.util.at.c(aVar.aYl, r.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.at.c(aVar.aYl, r.f.icon_pop_qz_boy);
            }
            a(aVar, this.bUQ, z);
            if (bbVar.ra()) {
                aVar.aYk.setClickable(false);
                aVar.aYk.setBackgroundResource(r.d.common_color_10022);
                aVar.aYk.setText(r.j.waiting);
                aVar.aYk.setTextColor(z ? this.mContext.getResources().getColor(r.d.cp_cont_d) : this.mContext.getResources().getColor(r.d.cp_cont_d_1));
                return;
            }
            aVar.aYk.setClickable(true);
            aVar.aYk.setText(r.j.frs_recommend_friend_item_add);
        }
    }

    public void ax(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bUQ != null && this.bUQ.qR() != null && TextUtils.equals(this.bUQ.qR().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bUQ.qR().getUserId()))) {
            this.bUQ.qR().qZ();
            notifyDataSetChanged();
        }
    }

    public void a(at.a aVar, com.baidu.tbadk.core.data.az azVar, boolean z) {
        if (azVar != null && aVar != null) {
            if (azVar.getLbsInfo() != null) {
                if (azVar.getLbsInfo().AB() == 1) {
                    aVar.aWy.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(aVar.aWy, this.aWu, 1);
                    aVar.aWy.setText(this.mContext.getResources().getString(r.j.contact_yinshen));
                    aVar.aWy.setCompoundDrawables(null, null, null, null);
                    aVar.aYh.setVisibility(8);
                } else if (azVar.getLbsInfo().AB() == 0) {
                    if (StringUtils.isNull(azVar.getLbsInfo().AA())) {
                        aVar.aWy.setVisibility(8);
                        aVar.aYh.setVisibility(0);
                    } else {
                        aVar.aYh.setVisibility(8);
                        aVar.aWy.setVisibility(0);
                        aVar.aWy.setText(String.valueOf(this.mContext.getString(r.j.distance_of_you)) + azVar.getLbsInfo().AA());
                        com.baidu.tbadk.core.util.at.c(aVar.aWy, this.aWu, 1);
                        this.aWv = com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_friend_pin);
                        this.aWv.setBounds(0, 0, this.size, this.size);
                        aVar.aWy.setCompoundDrawables(this.aWv, null, null, null);
                    }
                } else {
                    aVar.aWy.setVisibility(8);
                    aVar.aYh.setVisibility(0);
                }
            } else {
                aVar.aWy.setVisibility(8);
                aVar.aYh.setVisibility(0);
            }
            if (azVar.qR() != null && StringUtils.isNull(azVar.qR().rd())) {
                aVar.aYh.setVisibility(8);
            }
        }
    }
}
