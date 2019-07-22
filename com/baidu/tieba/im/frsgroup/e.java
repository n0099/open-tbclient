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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes5.dex */
public class e extends com.baidu.tieba.frs.h<GroupInfoData, f> {
    private View.OnClickListener bZH;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bZH = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (bd.cF(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new an("c10331").bT("obj_type", String.valueOf(groupId)));
                                }
                                r.a(2008011, new GroupInfoActivityConfig(e.this.mPageContext.getPageActivity(), groupId, from));
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(R.layout.frs_group_item_view, (ViewGroup) null), this.bZH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, groupInfoData, fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (fVar.cdL != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().onModeChanged(view);
            fVar.cdL = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.valueOf(i));
            fVar.a(groupInfoData);
            am.k(fVar.rootView, R.drawable.frs_group_item_bg);
            am.f(fVar.gGs, R.color.cp_cont_b, 1);
            am.f(fVar.gGt, R.color.cp_cont_b, 1);
            am.k(fVar.gGt, R.drawable.bg_jinqun_meizi);
            fVar.gGt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(fVar.gGu, R.color.cp_cont_b, 1);
            am.k(fVar.gGw, R.drawable.icon_grade_small_star);
            am.k(fVar.gGx, R.drawable.icon_grade_small_star);
            am.k(fVar.gGy, R.drawable.icon_grade_small_star);
            am.f(fVar.gGv, R.color.cp_cont_c, 1);
            am.l(fVar.dividerLine, R.color.cp_bg_line_b);
        }
        return view;
    }
}
