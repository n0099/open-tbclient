package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.f<GroupInfoData, f> {
    private View.OnClickListener ani;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ani = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    Object tag = view2.getTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (az.aK(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new al("c10331").ac("obj_type", String.valueOf(groupId)));
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
    /* renamed from: bc */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(d.i.frs_group_item_view, (ViewGroup) null), this.ani);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.onFillViewHolder(i, view2, viewGroup, groupInfoData, fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().u(view2);
        if (fVar.aqQ != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().u(view2);
            fVar.aqQ = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.valueOf(i));
            fVar.a(groupInfoData);
            ak.i(fVar.rootView, d.f.frs_group_item_bg);
            ak.c(fVar.dYd, d.C0126d.cp_cont_b, 1);
            ak.c(fVar.dYe, d.C0126d.cp_cont_b, 1);
            ak.i(fVar.dYe, d.f.bg_jinqun_meizi);
            fVar.dYe.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(fVar.dYf, d.C0126d.cp_cont_b, 1);
            ak.i(fVar.dYh, d.f.icon_grade_small_star);
            ak.i(fVar.dYi, d.f.icon_grade_small_star);
            ak.i(fVar.dYj, d.f.icon_grade_small_star);
            ak.c(fVar.dYg, d.C0126d.cp_cont_c, 1);
            ak.j(fVar.bae, d.C0126d.cp_bg_line_b);
        }
        return view2;
    }
}
