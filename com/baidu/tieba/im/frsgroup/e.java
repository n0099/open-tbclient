package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.g<GroupInfoData, f> {
    private View.OnClickListener bbO;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bbO = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(Integer.MAX_VALUE);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (ay.ba(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new ak("c10331").ab("obj_type", String.valueOf(groupId)));
                                }
                                com.baidu.tbadk.util.m.a(2008011, new GroupInfoActivityConfig(e.this.mPageContext.getPageActivity(), groupId, from));
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(d.h.frs_group_item_view, (ViewGroup) null), this.bbO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, groupInfoData, fVar);
        this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (fVar.bfC != this.mSkinType) {
            this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().aM(view);
            fVar.bfC = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(Integer.MAX_VALUE, Integer.valueOf(i));
            fVar.a(groupInfoData);
            aj.s(fVar.rootView, d.f.frs_group_item_bg);
            aj.e(fVar.eDC, d.C0141d.cp_cont_b, 1);
            aj.e(fVar.eDD, d.C0141d.cp_cont_b, 1);
            aj.s(fVar.eDD, d.f.bg_jinqun_meizi);
            fVar.eDD.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(fVar.eDE, d.C0141d.cp_cont_b, 1);
            aj.s(fVar.eDG, d.f.icon_grade_small_star);
            aj.s(fVar.eDH, d.f.icon_grade_small_star);
            aj.s(fVar.eDI, d.f.icon_grade_small_star);
            aj.e(fVar.eDF, d.C0141d.cp_cont_c, 1);
            aj.t(fVar.bQi, d.C0141d.cp_bg_line_b);
        }
        return view;
    }
}
