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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<GroupInfoData, f> {
    private View.OnClickListener aEo;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.aEo = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (ba.bG(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new am("c10331").ax("obj_type", String.valueOf(groupId)));
                                }
                                n.a(2008011, new GroupInfoActivityConfig(e.this.mPageContext.getPageActivity(), groupId, from));
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(e.h.frs_group_item_view, (ViewGroup) null), this.aEo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, groupInfoData, fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (fVar.aIf != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().onModeChanged(view);
            fVar.aIf = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.valueOf(i));
            fVar.a(groupInfoData);
            al.i(fVar.rootView, e.f.frs_group_item_bg);
            al.c(fVar.eID, e.d.cp_cont_b, 1);
            al.c(fVar.eIE, e.d.cp_cont_b, 1);
            al.i(fVar.eIE, e.f.bg_jinqun_meizi);
            fVar.eIE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(fVar.eIF, e.d.cp_cont_b, 1);
            al.i(fVar.eIH, e.f.icon_grade_small_star);
            al.i(fVar.eII, e.f.icon_grade_small_star);
            al.i(fVar.eIJ, e.f.icon_grade_small_star);
            al.c(fVar.eIG, e.d.cp_cont_c, 1);
            al.j(fVar.dividerLine, e.d.cp_bg_line_b);
        }
        return view;
    }
}
