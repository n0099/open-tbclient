package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ee extends bx<com.baidu.tbadk.core.data.ai, co> {
    private int aND;
    private Drawable aNE;
    private com.baidu.tbadk.core.data.ai bqr;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public ee(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aND = t.d.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public co b(ViewGroup viewGroup) {
        return new co(LayoutInflater.from(this.mContext).inflate(t.h.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ai aiVar, co coVar) {
        super.a(i, view, viewGroup, (ViewGroup) aiVar, (com.baidu.tbadk.core.data.ai) coVar);
        this.bqr = aiVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.at.k(coVar.bnQ, t.f.frs_item_control_btn_bg);
        coVar.bnP.setBackgroundColor(this.mContext.getResources().getColor(t.d.transparent));
        coVar.bnP.setPadding(0, this.bjo, 0, 0);
        coVar.bnR.aPt.setOnClickListener(new ef(this, aiVar));
        view.setOnClickListener(new eg(this, aiVar));
        this.bix.getLayoutMode().ab(z);
        this.bix.getLayoutMode().x(view);
        a(coVar, aiVar, z);
        return view;
    }

    private void a(co coVar, com.baidu.tbadk.core.data.ai aiVar, boolean z) {
        if (coVar != null && aiVar != null && aiVar.sz() != null) {
            a(coVar.bnR, aiVar.sz(), z);
            if (aiVar.sw() > 0) {
                if (!TextUtils.isEmpty(aiVar.sx())) {
                    coVar.aPe.setText(aiVar.sx());
                }
                if (aiVar.sw() < 3) {
                    coVar.aPf.setVisibility(8);
                } else {
                    coVar.aPf.setVisibility(0);
                    coVar.aPf.setText(t.j.add_friend_forum_count);
                }
            } else {
                coVar.aPm.setVisibility(8);
                coVar.bnS.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.qE().qK() && aiVar.sA() != null && aiVar.sA().size() > 0) {
                coVar.aPl.setVisibility(0);
                if (aiVar.sz().sK()) {
                    coVar.aPg.setText(t.j.add_friend_her_posts);
                } else {
                    coVar.aPg.setText(t.j.add_friend_his_posts);
                }
                switch (aiVar.sA().size()) {
                    case 1:
                        coVar.aPi.setVisibility(0);
                        coVar.aPj.setVisibility(4);
                        coVar.aPk.setVisibility(4);
                        coVar.aPi.c(aiVar.sA().get(0), 10, false);
                        break;
                    case 2:
                        coVar.aPi.setVisibility(0);
                        coVar.aPj.setVisibility(0);
                        coVar.aPk.setVisibility(4);
                        coVar.aPi.c(aiVar.sA().get(0), 10, false);
                        coVar.aPj.c(aiVar.sA().get(1), 10, false);
                        break;
                    default:
                        coVar.aPi.setVisibility(0);
                        coVar.aPj.setVisibility(0);
                        coVar.aPk.setVisibility(0);
                        coVar.aPi.c(aiVar.sA().get(0), 10, false);
                        coVar.aPj.c(aiVar.sA().get(1), 10, false);
                        coVar.aPk.c(aiVar.sA().get(2), 10, false);
                        break;
                }
            } else {
                coVar.aPl.setVisibility(8);
                coVar.bnS.setVisibility(8);
            }
            eh ehVar = new eh(this, aiVar);
            coVar.aPi.setTag(t.g.tag_first, aiVar);
            coVar.aPj.setTag(t.g.tag_first, aiVar);
            coVar.aPk.setTag(t.g.tag_first, aiVar);
            coVar.aPi.setTag(t.g.tag_second, 0);
            coVar.aPj.setTag(t.g.tag_second, 1);
            coVar.aPk.setTag(t.g.tag_second, 2);
            coVar.aPi.setOnClickListener(ehVar);
            coVar.aPj.setOnClickListener(ehVar);
            coVar.aPk.setOnClickListener(ehVar);
        }
    }

    private void a(co.a aVar, com.baidu.tbadk.core.data.ak akVar, boolean z) {
        if (akVar != null && aVar != null) {
            if (com.baidu.tbadk.core.l.qE().qG()) {
                aVar.aPn.setVisibility(0);
                if (!TextUtils.isEmpty(akVar.sJ())) {
                    aVar.aPn.setUserId(String.valueOf(akVar.getUserId()));
                    aVar.aPn.setImageDrawable(null);
                    aVar.aPn.c(akVar.sJ(), 12, false);
                }
            } else {
                aVar.aPn.setVisibility(8);
            }
            if (akVar.sM() != null && !TextUtils.isEmpty(akVar.sM().getUrl())) {
                aVar.aPo.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(akVar.sM());
                aVar.aPo.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin));
            } else {
                aVar.aPo.setVisibility(8);
            }
            aVar.aPp.setText(akVar.getName());
            aVar.aPq.setText(akVar.sL());
            if (akVar.sK()) {
                com.baidu.tbadk.core.util.at.c(aVar.aPu, t.f.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.at.c(aVar.aPu, t.f.icon_pop_qz_boy);
            }
            a(aVar, this.bqr, z);
            if (akVar.sI()) {
                aVar.aPt.setClickable(false);
                aVar.aPt.setBackgroundResource(t.d.transparent);
                aVar.aPt.setText(t.j.waiting);
                aVar.aPt.setTextColor(z ? this.mContext.getResources().getColor(t.d.cp_cont_d) : this.mContext.getResources().getColor(t.d.cp_cont_d_1));
                return;
            }
            aVar.aPt.setClickable(true);
            aVar.aPt.setText(t.j.frs_recommend_friend_item_add);
        }
    }

    public void av(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.bqr != null && this.bqr.sz() != null && TextUtils.equals(this.bqr.sz().getName(), str2) && TextUtils.equals(str, String.valueOf(this.bqr.sz().getUserId()))) {
            this.bqr.sz().sH();
            notifyDataSetChanged();
        }
    }

    public void a(co.a aVar, com.baidu.tbadk.core.data.ai aiVar, boolean z) {
        if (aiVar != null && aVar != null) {
            if (aiVar.getLbsInfo() != null) {
                if (aiVar.getLbsInfo().Bd() == 1) {
                    aVar.aNH.setVisibility(0);
                    com.baidu.tbadk.core.util.at.b(aVar.aNH, this.aND, 1);
                    aVar.aNH.setText(this.mContext.getResources().getString(t.j.contact_yinshen));
                    aVar.aNH.setCompoundDrawables(null, null, null, null);
                    aVar.aPq.setVisibility(8);
                } else if (aiVar.getLbsInfo().Bd() == 0) {
                    if (StringUtils.isNull(aiVar.getLbsInfo().getDistance())) {
                        aVar.aNH.setVisibility(8);
                        aVar.aPq.setVisibility(0);
                    } else {
                        aVar.aPq.setVisibility(8);
                        aVar.aNH.setVisibility(0);
                        aVar.aNH.setText(String.valueOf(this.mContext.getString(t.j.distance_of_you)) + aiVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.at.b(aVar.aNH, this.aND, 1);
                        this.aNE = com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_friend_pin);
                        this.aNE.setBounds(0, 0, this.size, this.size);
                        aVar.aNH.setCompoundDrawables(this.aNE, null, null, null);
                    }
                } else {
                    aVar.aNH.setVisibility(8);
                    aVar.aPq.setVisibility(0);
                }
            } else {
                aVar.aNH.setVisibility(8);
                aVar.aPq.setVisibility(0);
            }
            if (aiVar.sz() != null && StringUtils.isNull(aiVar.sz().sL())) {
                aVar.aPq.setVisibility(8);
            }
        }
    }
}
