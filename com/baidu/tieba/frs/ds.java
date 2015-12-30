package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ds extends bp<com.baidu.tbadk.core.data.u, cf> {
    private int aJC;
    private Drawable aJD;
    private com.baidu.tbadk.core.data.u bil;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public ds(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aJC = n.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public cf a(ViewGroup viewGroup) {
        return new cf(LayoutInflater.from(this.mContext).inflate(n.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.u uVar, cf cfVar) {
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tbadk.core.data.u) cfVar);
        this.bil = uVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.as.i(cfVar.bgv, n.f.frs_item_control_btn_bg);
        cfVar.bgu.setBackgroundColor(this.mContext.getResources().getColor(n.d.transparent));
        cfVar.bgu.setPadding(0, this.bcn, 0, 0);
        cfVar.bgw.aLt.setOnClickListener(new dt(this, uVar));
        view.setOnClickListener(new du(this, uVar));
        this.bbA.getLayoutMode().ac(z);
        this.bbA.getLayoutMode().k(view);
        a(cfVar, uVar, z);
        return view;
    }

    private void a(cf cfVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (cfVar != null && uVar != null && uVar.rX() != null) {
            a(cfVar.bgw, uVar.rX(), z);
            if (uVar.rU() > 0) {
                if (!TextUtils.isEmpty(uVar.rV())) {
                    cfVar.aLe.setText(uVar.rV());
                }
                if (uVar.rU() < 3) {
                    cfVar.aLf.setVisibility(8);
                } else {
                    cfVar.aLf.setVisibility(0);
                    cfVar.aLf.setText(n.j.add_friend_forum_count);
                }
            } else {
                cfVar.aLm.setVisibility(8);
                cfVar.bgx.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.qQ().qW() && uVar.rY() != null && uVar.rY().size() > 0) {
                cfVar.aLl.setVisibility(0);
                if (uVar.rX().se()) {
                    cfVar.aLg.setText(n.j.add_friend_her_posts);
                } else {
                    cfVar.aLg.setText(n.j.add_friend_his_posts);
                }
                switch (uVar.rY().size()) {
                    case 1:
                        cfVar.aLi.setVisibility(0);
                        cfVar.aLj.setVisibility(4);
                        cfVar.aLk.setVisibility(4);
                        cfVar.aLi.d(uVar.rY().get(0), 10, false);
                        break;
                    case 2:
                        cfVar.aLi.setVisibility(0);
                        cfVar.aLj.setVisibility(0);
                        cfVar.aLk.setVisibility(4);
                        cfVar.aLi.d(uVar.rY().get(0), 10, false);
                        cfVar.aLj.d(uVar.rY().get(1), 10, false);
                        break;
                    default:
                        cfVar.aLi.setVisibility(0);
                        cfVar.aLj.setVisibility(0);
                        cfVar.aLk.setVisibility(0);
                        cfVar.aLi.d(uVar.rY().get(0), 10, false);
                        cfVar.aLj.d(uVar.rY().get(1), 10, false);
                        cfVar.aLk.d(uVar.rY().get(2), 10, false);
                        break;
                }
            } else {
                cfVar.aLl.setVisibility(8);
                cfVar.bgx.setVisibility(8);
            }
            dv dvVar = new dv(this, uVar);
            cfVar.aLi.setTag(n.g.tag_first, uVar);
            cfVar.aLj.setTag(n.g.tag_first, uVar);
            cfVar.aLk.setTag(n.g.tag_first, uVar);
            cfVar.aLi.setTag(n.g.tag_second, 0);
            cfVar.aLj.setTag(n.g.tag_second, 1);
            cfVar.aLk.setTag(n.g.tag_second, 2);
            cfVar.aLi.setOnClickListener(dvVar);
            cfVar.aLj.setOnClickListener(dvVar);
            cfVar.aLk.setOnClickListener(dvVar);
        }
    }

    private void a(cf.a aVar, com.baidu.tbadk.core.data.v vVar, boolean z) {
        if (vVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.qQ().qS()) {
                aVar.aLn.setVisibility(0);
                if (!TextUtils.isEmpty(vVar.sd())) {
                    aVar.aLn.setUserId(String.valueOf(vVar.getUserId()));
                    aVar.aLn.setImageDrawable(null);
                    aVar.aLn.d(vVar.sd(), 12, false);
                }
            } else {
                aVar.aLn.setVisibility(8);
            }
            if (vVar.sg() != null && !TextUtils.isEmpty(vVar.sg().getUrl())) {
                aVar.aLo.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(vVar.sg());
                aVar.aLo.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin));
            } else {
                aVar.aLo.setVisibility(8);
            }
            aVar.aLp.setText(vVar.getName());
            aVar.aLq.setText(vVar.sf());
            if (vVar.se()) {
                com.baidu.tbadk.core.util.as.c(aVar.aLu, n.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.as.c(aVar.aLu, n.f.icon_pop_qz_boy);
            }
            a(aVar, this.bil, z);
            if (vVar.sc()) {
                aVar.aLt.setClickable(false);
                aVar.aLt.setBackgroundResource(n.d.transparent);
                aVar.aLt.setText(n.j.waiting);
                aVar.aLt.setTextColor(z ? this.mContext.getResources().getColor(n.d.cp_cont_d) : this.mContext.getResources().getColor(n.d.cp_cont_d_1));
                return;
            }
            aVar.aLt.setClickable(true);
            aVar.aLt.setText(n.j.frs_recommend_friend_item_add);
        }
    }

    public void ao(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bil != null && this.bil.rX() != null && TextUtils.equals(this.bil.rX().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bil.rX().getUserId()))) {
            this.bil.rX().sb();
            notifyDataSetChanged();
        }
    }

    public void a(cf.a aVar, com.baidu.tbadk.core.data.u uVar, boolean z) {
        if (uVar != null && aVar != null) {
            if (uVar.getLbsInfo() != null) {
                if (uVar.getLbsInfo().zi() == 1) {
                    aVar.aJG.setVisibility(0);
                    com.baidu.tbadk.core.util.as.b(aVar.aJG, this.aJC, 1);
                    aVar.aJG.setText(this.mContext.getResources().getString(n.j.contact_yinshen));
                    aVar.aJG.setCompoundDrawables(null, null, null, null);
                    aVar.aLq.setVisibility(8);
                } else if (uVar.getLbsInfo().zi() == 0) {
                    if (StringUtils.isNull(uVar.getLbsInfo().getDistance())) {
                        aVar.aJG.setVisibility(8);
                        aVar.aLq.setVisibility(0);
                    } else {
                        aVar.aLq.setVisibility(8);
                        aVar.aJG.setVisibility(0);
                        aVar.aJG.setText(String.valueOf(this.mContext.getString(n.j.distance_of_you)) + uVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.as.b(aVar.aJG, this.aJC, 1);
                        this.aJD = com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_friend_pin);
                        this.aJD.setBounds(0, 0, this.size, this.size);
                        aVar.aJG.setCompoundDrawables(this.aJD, null, null, null);
                    }
                } else {
                    aVar.aJG.setVisibility(8);
                    aVar.aLq.setVisibility(0);
                }
            } else {
                aVar.aJG.setVisibility(8);
                aVar.aLq.setVisibility(0);
            }
            if (uVar.rX() != null && StringUtils.isNull(uVar.rX().sf())) {
                aVar.aLq.setVisibility(8);
            }
        }
    }
}
