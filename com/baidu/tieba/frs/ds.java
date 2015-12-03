package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ds extends bm<com.baidu.tbadk.core.data.u, cc> {
    private int aIe;
    private Drawable aIf;
    private com.baidu.tbadk.core.data.u beq;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public ds(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aIe = n.c.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public cc a(ViewGroup viewGroup) {
        return new cc(LayoutInflater.from(this.mContext).inflate(n.g.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.u uVar, cc ccVar) {
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tbadk.core.data.u) ccVar);
        this.beq = uVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.as.i(ccVar.bcv, n.e.frs_item_control_btn_bg);
        ccVar.bcu.setBackgroundColor(this.mContext.getResources().getColor(n.c.transparent));
        ccVar.bcu.setPadding(0, this.aYo, 0, 0);
        ccVar.bcw.aJV.setOnClickListener(new dt(this, uVar));
        view.setOnClickListener(new du(this, uVar));
        this.aXA.getLayoutMode().af(z);
        this.aXA.getLayoutMode().k(view);
        a(ccVar, uVar, z);
        return view;
    }

    private void a(cc ccVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (ccVar != null && uVar != null && uVar.so() != null) {
            a(ccVar.bcw, uVar.so(), z);
            if (uVar.sl() > 0) {
                if (!TextUtils.isEmpty(uVar.sm())) {
                    ccVar.aJG.setText(uVar.sm());
                }
                if (uVar.sl() < 3) {
                    ccVar.aJH.setVisibility(8);
                } else {
                    ccVar.aJH.setVisibility(0);
                    ccVar.aJH.setText(n.i.add_friend_forum_count);
                }
            } else {
                ccVar.aJO.setVisibility(8);
                ccVar.bcx.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.rh().rn() && uVar.sp() != null && uVar.sp().size() > 0) {
                ccVar.aJN.setVisibility(0);
                if (uVar.so().sv()) {
                    ccVar.aJI.setText(n.i.add_friend_her_posts);
                } else {
                    ccVar.aJI.setText(n.i.add_friend_his_posts);
                }
                switch (uVar.sp().size()) {
                    case 1:
                        ccVar.aJK.setVisibility(0);
                        ccVar.aJL.setVisibility(4);
                        ccVar.aJM.setVisibility(4);
                        ccVar.aJK.d(uVar.sp().get(0), 10, false);
                        break;
                    case 2:
                        ccVar.aJK.setVisibility(0);
                        ccVar.aJL.setVisibility(0);
                        ccVar.aJM.setVisibility(4);
                        ccVar.aJK.d(uVar.sp().get(0), 10, false);
                        ccVar.aJL.d(uVar.sp().get(1), 10, false);
                        break;
                    default:
                        ccVar.aJK.setVisibility(0);
                        ccVar.aJL.setVisibility(0);
                        ccVar.aJM.setVisibility(0);
                        ccVar.aJK.d(uVar.sp().get(0), 10, false);
                        ccVar.aJL.d(uVar.sp().get(1), 10, false);
                        ccVar.aJM.d(uVar.sp().get(2), 10, false);
                        break;
                }
            } else {
                ccVar.aJN.setVisibility(8);
                ccVar.bcx.setVisibility(8);
            }
            dv dvVar = new dv(this, uVar);
            ccVar.aJK.setTag(n.f.tag_first, uVar);
            ccVar.aJL.setTag(n.f.tag_first, uVar);
            ccVar.aJM.setTag(n.f.tag_first, uVar);
            ccVar.aJK.setTag(n.f.tag_second, 0);
            ccVar.aJL.setTag(n.f.tag_second, 1);
            ccVar.aJM.setTag(n.f.tag_second, 2);
            ccVar.aJK.setOnClickListener(dvVar);
            ccVar.aJL.setOnClickListener(dvVar);
            ccVar.aJM.setOnClickListener(dvVar);
        }
    }

    private void a(cc.a aVar, com.baidu.tbadk.core.data.v vVar, boolean z) {
        if (vVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.rh().rj()) {
                aVar.aJP.setVisibility(0);
                if (!TextUtils.isEmpty(vVar.su())) {
                    aVar.aJP.setUserId(String.valueOf(vVar.getUserId()));
                    aVar.aJP.setImageDrawable(null);
                    aVar.aJP.d(vVar.su(), 12, false);
                }
            } else {
                aVar.aJP.setVisibility(8);
            }
            if (vVar.sx() != null && !TextUtils.isEmpty(vVar.sx().getUrl())) {
                aVar.aJQ.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(vVar.sx());
                aVar.aJQ.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin));
            } else {
                aVar.aJQ.setVisibility(8);
            }
            aVar.aJR.setText(vVar.getName());
            aVar.aJS.setText(vVar.sw());
            if (vVar.sv()) {
                com.baidu.tbadk.core.util.as.c(aVar.aJW, n.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.as.c(aVar.aJW, n.e.icon_pop_qz_boy);
            }
            a(aVar, this.beq, z);
            if (vVar.st()) {
                aVar.aJV.setClickable(false);
                aVar.aJV.setBackgroundResource(n.c.transparent);
                aVar.aJV.setText(n.i.waiting);
                aVar.aJV.setTextColor(z ? this.mContext.getResources().getColor(n.c.cp_cont_d) : this.mContext.getResources().getColor(n.c.cp_cont_d_1));
                return;
            }
            aVar.aJV.setClickable(true);
            aVar.aJV.setText(n.i.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.beq != null && this.beq.so() != null && TextUtils.equals(this.beq.so().getName(), str2) && TextUtils.equals(str, String.valueOf(this.beq.so().getUserId()))) {
            this.beq.so().ss();
            notifyDataSetChanged();
        }
    }

    public void a(cc.a aVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (uVar != null && aVar != null) {
            if (uVar.getLbsInfo() != null) {
                if (uVar.getLbsInfo().zw() == 1) {
                    aVar.aIi.setVisibility(0);
                    com.baidu.tbadk.core.util.as.b(aVar.aIi, this.aIe, 1);
                    aVar.aIi.setText(this.mContext.getResources().getString(n.i.contact_yinshen));
                    aVar.aIi.setCompoundDrawables(null, null, null, null);
                    aVar.aJS.setVisibility(8);
                } else if (uVar.getLbsInfo().zw() == 0) {
                    if (StringUtils.isNull(uVar.getLbsInfo().getDistance())) {
                        aVar.aIi.setVisibility(8);
                        aVar.aJS.setVisibility(0);
                    } else {
                        aVar.aJS.setVisibility(8);
                        aVar.aIi.setVisibility(0);
                        aVar.aIi.setText(String.valueOf(this.mContext.getString(n.i.distance_of_you)) + uVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.as.b(aVar.aIi, this.aIe, 1);
                        this.aIf = com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_friend_pin);
                        this.aIf.setBounds(0, 0, this.size, this.size);
                        aVar.aIi.setCompoundDrawables(this.aIf, null, null, null);
                    }
                } else {
                    aVar.aIi.setVisibility(8);
                    aVar.aJS.setVisibility(0);
                }
            } else {
                aVar.aIi.setVisibility(8);
                aVar.aJS.setVisibility(0);
            }
            if (uVar.so() != null && StringUtils.isNull(uVar.so().sw())) {
                aVar.aJS.setVisibility(8);
            }
        }
    }
}
