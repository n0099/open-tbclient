package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dv extends bw<com.baidu.tbadk.core.data.am, cl> {
    private int aJN;
    private Drawable aJO;
    private com.baidu.tbadk.core.data.am blt;
    private int size;

    public dv(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aJN = t.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public cl b(ViewGroup viewGroup) {
        return new cl(LayoutInflater.from(this.mContext).inflate(t.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.am amVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) amVar, (com.baidu.tbadk.core.data.am) clVar);
        this.blt = amVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.at.k(clVar.bjk, t.f.frs_item_control_btn_bg);
        clVar.bjj.setBackgroundColor(this.mContext.getResources().getColor(t.d.transparent));
        clVar.bjj.setPadding(0, this.bfo, 0, 0);
        clVar.bjl.aLD.setOnClickListener(new dw(this, amVar));
        view.setOnClickListener(new dx(this, amVar));
        this.bek.getLayoutMode().ae(z);
        this.bek.getLayoutMode().x(view);
        a(clVar, amVar, z);
        return view;
    }

    private void a(cl clVar, com.baidu.tbadk.core.data.am amVar, boolean z) {
        if (clVar != null && amVar != null && amVar.pX() != null) {
            a(clVar.bjl, amVar.pX(), z);
            if (amVar.pU() > 0) {
                if (!TextUtils.isEmpty(amVar.pV())) {
                    clVar.aLo.setText(amVar.pV());
                }
                if (amVar.pU() < 3) {
                    clVar.aLp.setVisibility(8);
                } else {
                    clVar.aLp.setVisibility(0);
                    clVar.aLp.setText(t.j.add_friend_forum_count);
                }
            } else {
                clVar.aLw.setVisibility(8);
                clVar.bjm.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.ob().oh() && amVar.pY() != null && amVar.pY().size() > 0) {
                clVar.aLv.setVisibility(0);
                if (amVar.pX().qi()) {
                    clVar.aLq.setText(t.j.add_friend_her_posts);
                } else {
                    clVar.aLq.setText(t.j.add_friend_his_posts);
                }
                switch (amVar.pY().size()) {
                    case 1:
                        clVar.aLs.setVisibility(0);
                        clVar.aLt.setVisibility(4);
                        clVar.aLu.setVisibility(4);
                        clVar.aLs.c(amVar.pY().get(0), 10, false);
                        break;
                    case 2:
                        clVar.aLs.setVisibility(0);
                        clVar.aLt.setVisibility(0);
                        clVar.aLu.setVisibility(4);
                        clVar.aLs.c(amVar.pY().get(0), 10, false);
                        clVar.aLt.c(amVar.pY().get(1), 10, false);
                        break;
                    default:
                        clVar.aLs.setVisibility(0);
                        clVar.aLt.setVisibility(0);
                        clVar.aLu.setVisibility(0);
                        clVar.aLs.c(amVar.pY().get(0), 10, false);
                        clVar.aLt.c(amVar.pY().get(1), 10, false);
                        clVar.aLu.c(amVar.pY().get(2), 10, false);
                        break;
                }
            } else {
                clVar.aLv.setVisibility(8);
                clVar.bjm.setVisibility(8);
            }
            dy dyVar = new dy(this, amVar);
            clVar.aLs.setTag(t.g.tag_first, amVar);
            clVar.aLt.setTag(t.g.tag_first, amVar);
            clVar.aLu.setTag(t.g.tag_first, amVar);
            clVar.aLs.setTag(t.g.tag_second, 0);
            clVar.aLt.setTag(t.g.tag_second, 1);
            clVar.aLu.setTag(t.g.tag_second, 2);
            clVar.aLs.setOnClickListener(dyVar);
            clVar.aLt.setOnClickListener(dyVar);
            clVar.aLu.setOnClickListener(dyVar);
        }
    }

    private void a(cl.a aVar, com.baidu.tbadk.core.data.ao aoVar, boolean z) {
        if (aoVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.ob().od()) {
                aVar.aLx.setVisibility(0);
                if (!TextUtils.isEmpty(aoVar.qh())) {
                    aVar.aLx.setUserId(String.valueOf(aoVar.getUserId()));
                    aVar.aLx.setImageDrawable(null);
                    aVar.aLx.c(aoVar.qh(), 12, false);
                }
            } else {
                aVar.aLx.setVisibility(8);
            }
            if (aoVar.qk() != null && !TextUtils.isEmpty(aoVar.qk().getUrl())) {
                aVar.aLy.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(aoVar.qk());
                aVar.aLy.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin));
            } else {
                aVar.aLy.setVisibility(8);
            }
            aVar.aLz.setText(aoVar.getName());
            aVar.aLA.setText(aoVar.qj());
            if (aoVar.qi()) {
                com.baidu.tbadk.core.util.at.c(aVar.aLE, t.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.at.c(aVar.aLE, t.f.icon_pop_qz_boy);
            }
            a(aVar, this.blt, z);
            if (aoVar.qg()) {
                aVar.aLD.setClickable(false);
                aVar.aLD.setBackgroundResource(t.d.transparent);
                aVar.aLD.setText(t.j.waiting);
                aVar.aLD.setTextColor(z ? this.mContext.getResources().getColor(t.d.cp_cont_d) : this.mContext.getResources().getColor(t.d.cp_cont_d_1));
                return;
            }
            aVar.aLD.setClickable(true);
            aVar.aLD.setText(t.j.frs_recommend_friend_item_add);
        }
    }

    public void av(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.blt != null && this.blt.pX() != null && TextUtils.equals(this.blt.pX().getName(), str2) && TextUtils.equals(str, String.valueOf(this.blt.pX().getUserId()))) {
            this.blt.pX().qf();
            notifyDataSetChanged();
        }
    }

    public void a(cl.a aVar, com.baidu.tbadk.core.data.am amVar, boolean z) {
        if (amVar != null && aVar != null) {
            if (amVar.getLbsInfo() != null) {
                if (amVar.getLbsInfo().yW() == 1) {
                    aVar.aJR.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(aVar.aJR, this.aJN, 1);
                    aVar.aJR.setText(this.mContext.getResources().getString(t.j.contact_yinshen));
                    aVar.aJR.setCompoundDrawables(null, null, null, null);
                    aVar.aLA.setVisibility(8);
                } else if (amVar.getLbsInfo().yW() == 0) {
                    if (StringUtils.isNull(amVar.getLbsInfo().getDistance())) {
                        aVar.aJR.setVisibility(8);
                        aVar.aLA.setVisibility(0);
                    } else {
                        aVar.aLA.setVisibility(8);
                        aVar.aJR.setVisibility(0);
                        aVar.aJR.setText(String.valueOf(this.mContext.getString(t.j.distance_of_you)) + amVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.at.c(aVar.aJR, this.aJN, 1);
                        this.aJO = com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_friend_pin);
                        this.aJO.setBounds(0, 0, this.size, this.size);
                        aVar.aJR.setCompoundDrawables(this.aJO, null, null, null);
                    }
                } else {
                    aVar.aJR.setVisibility(8);
                    aVar.aLA.setVisibility(0);
                }
            } else {
                aVar.aJR.setVisibility(8);
                aVar.aLA.setVisibility(0);
            }
            if (amVar.pX() != null && StringUtils.isNull(amVar.pX().qj())) {
                aVar.aLA.setVisibility(8);
            }
        }
    }
}
