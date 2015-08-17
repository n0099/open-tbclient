package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cj extends bc<com.baidu.tbadk.core.data.q, bg> {
    private int aGU;
    private Drawable aGV;
    private com.baidu.tbadk.core.data.q aYi;
    private int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public cj(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aGU = i.c.cp_cont_d;
        this.size = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds24);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public bg a(ViewGroup viewGroup) {
        return new bg(LayoutInflater.from(this.mContext).inflate(i.g.frs_recommend_friend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar, bg bgVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tbadk.core.data.q) bgVar);
        this.aYi = qVar;
        boolean z = this.mSkinType == 1;
        com.baidu.tbadk.core.util.al.i(bgVar.aWw, i.e.frs_item_control_btn_bg);
        bgVar.aWv.setBackgroundColor(this.mContext.getResources().getColor(i.c.transparent));
        bgVar.aWv.setPadding(0, this.aTx, 0, 0);
        bgVar.aWx.aIM.setOnClickListener(new ck(this, qVar));
        view.setOnClickListener(new cl(this, qVar));
        this.aSJ.getLayoutMode().ad(z);
        this.aSJ.getLayoutMode().k(view);
        a(bgVar, qVar, z);
        return view;
    }

    private void a(bg bgVar, com.baidu.tbadk.core.data.q qVar, boolean z) {
        if (bgVar != null && qVar != null && qVar.rZ() != null) {
            a(bgVar.aWx, qVar.rZ(), z);
            if (qVar.rW() > 0) {
                if (!TextUtils.isEmpty(qVar.rX())) {
                    bgVar.aIx.setText(qVar.rX());
                }
                if (qVar.rW() < 3) {
                    bgVar.aIy.setVisibility(8);
                } else {
                    bgVar.aIy.setVisibility(0);
                    bgVar.aIy.setText(i.C0057i.add_friend_forum_count);
                }
            } else {
                bgVar.aIF.setVisibility(8);
                bgVar.aWy.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.rd().rh() && qVar.sa() != null && qVar.sa().size() > 0) {
                bgVar.aIE.setVisibility(0);
                if (qVar.rZ().sg()) {
                    bgVar.aIz.setText(i.C0057i.add_friend_her_posts);
                } else {
                    bgVar.aIz.setText(i.C0057i.add_friend_his_posts);
                }
                switch (qVar.sa().size()) {
                    case 1:
                        bgVar.aIB.setVisibility(0);
                        bgVar.aIC.setVisibility(4);
                        bgVar.aID.setVisibility(4);
                        bgVar.aIB.d(qVar.sa().get(0), 10, false);
                        break;
                    case 2:
                        bgVar.aIB.setVisibility(0);
                        bgVar.aIC.setVisibility(0);
                        bgVar.aID.setVisibility(4);
                        bgVar.aIB.d(qVar.sa().get(0), 10, false);
                        bgVar.aIC.d(qVar.sa().get(1), 10, false);
                        break;
                    default:
                        bgVar.aIB.setVisibility(0);
                        bgVar.aIC.setVisibility(0);
                        bgVar.aID.setVisibility(0);
                        bgVar.aIB.d(qVar.sa().get(0), 10, false);
                        bgVar.aIC.d(qVar.sa().get(1), 10, false);
                        bgVar.aID.d(qVar.sa().get(2), 10, false);
                        break;
                }
            } else {
                bgVar.aIE.setVisibility(8);
                bgVar.aWy.setVisibility(8);
            }
            cm cmVar = new cm(this, qVar);
            bgVar.aIB.setTag(i.f.tag_first, qVar);
            bgVar.aIC.setTag(i.f.tag_first, qVar);
            bgVar.aID.setTag(i.f.tag_first, qVar);
            bgVar.aIB.setTag(i.f.tag_second, 0);
            bgVar.aIC.setTag(i.f.tag_second, 1);
            bgVar.aID.setTag(i.f.tag_second, 2);
            bgVar.aIB.setOnClickListener(cmVar);
            bgVar.aIC.setOnClickListener(cmVar);
            bgVar.aID.setOnClickListener(cmVar);
        }
    }

    private void a(bg.a aVar, com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (rVar != null && aVar != null) {
            if (com.baidu.tbadk.core.m.rd().rf()) {
                aVar.aIG.setVisibility(0);
                if (!TextUtils.isEmpty(rVar.sf())) {
                    aVar.aIG.setUserId(String.valueOf(rVar.getUserId()));
                    aVar.aIG.setImageDrawable(null);
                    aVar.aIG.d(rVar.sf(), 12, false);
                }
            } else {
                aVar.aIG.setVisibility(8);
            }
            if (rVar.si() != null && !TextUtils.isEmpty(rVar.si().getUrl())) {
                aVar.aIH.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(rVar.si());
                aVar.aIH.a(arrayList, 1, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin));
            } else {
                aVar.aIH.setVisibility(8);
            }
            aVar.aII.setText(rVar.getName());
            aVar.aIJ.setText(rVar.sh());
            if (rVar.sg()) {
                com.baidu.tbadk.core.util.al.c(aVar.aIN, i.e.icon_pop_qz_girl);
            } else {
                com.baidu.tbadk.core.util.al.c(aVar.aIN, i.e.icon_pop_qz_boy);
            }
            a(aVar, this.aYi, z);
            if (rVar.se()) {
                aVar.aIM.setClickable(false);
                aVar.aIM.setBackgroundResource(i.c.transparent);
                aVar.aIM.setText(i.C0057i.waiting);
                aVar.aIM.setTextColor(z ? this.mContext.getResources().getColor(i.c.cp_cont_d) : this.mContext.getResources().getColor(i.c.cp_cont_d_1));
                return;
            }
            aVar.aIM.setClickable(true);
            aVar.aIM.setText(i.C0057i.frs_recommend_friend_item_add);
        }
    }

    public void aq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.aYi != null && this.aYi.rZ() != null && TextUtils.equals(this.aYi.rZ().getName(), str2) && TextUtils.equals(str, String.valueOf(this.aYi.rZ().getUserId()))) {
            this.aYi.rZ().sd();
            notifyDataSetChanged();
        }
    }

    public void a(bg.a aVar, com.baidu.tbadk.core.data.q qVar, boolean z) {
        if (qVar != null && aVar != null) {
            if (qVar.getLbsInfo() != null) {
                if (qVar.getLbsInfo().yH() == 1) {
                    aVar.aGY.setVisibility(0);
                    com.baidu.tbadk.core.util.al.b(aVar.aGY, this.aGU, 1);
                    aVar.aGY.setText(this.mContext.getResources().getString(i.C0057i.contact_yinshen));
                    aVar.aGY.setCompoundDrawables(null, null, null, null);
                    aVar.aIJ.setVisibility(8);
                } else if (qVar.getLbsInfo().yH() == 0) {
                    if (StringUtils.isNull(qVar.getLbsInfo().getDistance())) {
                        aVar.aGY.setVisibility(8);
                        aVar.aIJ.setVisibility(0);
                    } else {
                        aVar.aIJ.setVisibility(8);
                        aVar.aGY.setVisibility(0);
                        aVar.aGY.setText(String.valueOf(this.mContext.getString(i.C0057i.distance_of_you)) + qVar.getLbsInfo().getDistance());
                        com.baidu.tbadk.core.util.al.b(aVar.aGY, this.aGU, 1);
                        this.aGV = com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_pin);
                        this.aGV.setBounds(0, 0, this.size, this.size);
                        aVar.aGY.setCompoundDrawables(this.aGV, null, null, null);
                    }
                } else {
                    aVar.aGY.setVisibility(8);
                    aVar.aIJ.setVisibility(0);
                }
            } else {
                aVar.aGY.setVisibility(8);
                aVar.aIJ.setVisibility(0);
            }
            if (qVar.rZ() != null && StringUtils.isNull(qVar.rZ().sh())) {
                aVar.aIJ.setVisibility(8);
            }
        }
    }
}
