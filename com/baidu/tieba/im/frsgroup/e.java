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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<GroupInfoData, f> {
    private View.OnClickListener avF;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.avF = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (ba.aV(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new an("c10331").af("obj_type", String.valueOf(groupId)));
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
        return new f(LayoutInflater.from(this.mContext).inflate(d.h.frs_group_item_view, (ViewGroup) null), this.avF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, groupInfoData, fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (fVar.azI != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().onModeChanged(view);
            fVar.azI = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.valueOf(i));
            fVar.a(groupInfoData);
            am.i(fVar.rootView, d.f.frs_group_item_bg);
            am.c(fVar.esk, d.C0140d.cp_cont_b, 1);
            am.c(fVar.esl, d.C0140d.cp_cont_b, 1);
            am.i(fVar.esl, d.f.bg_jinqun_meizi);
            fVar.esl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(fVar.esm, d.C0140d.cp_cont_b, 1);
            am.i(fVar.eso, d.f.icon_grade_small_star);
            am.i(fVar.esp, d.f.icon_grade_small_star);
            am.i(fVar.esq, d.f.icon_grade_small_star);
            am.c(fVar.esn, d.C0140d.cp_cont_c, 1);
            am.j(fVar.bkw, d.C0140d.cp_bg_line_b);
        }
        return view;
    }
}
