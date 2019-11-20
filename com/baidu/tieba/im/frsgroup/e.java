package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.util.q;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes5.dex */
public class e extends com.baidu.tieba.frs.h<GroupInfoData, f> {
    private View.OnClickListener cot;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cot = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(Integer.MAX_VALUE);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (bc.checkUpIsLogin(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new an("c10331").bS("obj_type", String.valueOf(groupId)));
                                }
                                q.a(CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(e.this.mPageContext.getPageActivity(), groupId, from));
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public f b(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(R.layout.frs_group_item_view, (ViewGroup) null), this.cot);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) groupInfoData, (GroupInfoData) fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (fVar.csg != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().onModeChanged(view);
            fVar.csg = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(Integer.MAX_VALUE, Integer.valueOf(i));
            fVar.a(groupInfoData);
            am.setBackgroundResource(fVar.rootView, R.drawable.frs_group_item_bg);
            am.setViewTextColor(fVar.gGj, R.color.cp_cont_b, 1);
            am.setViewTextColor(fVar.gGk, R.color.cp_cont_b, 1);
            am.setBackgroundResource(fVar.gGk, R.drawable.bg_jinqun_meizi);
            fVar.gGk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(fVar.gGl, R.color.cp_cont_b, 1);
            am.setBackgroundResource(fVar.gGn, R.drawable.icon_grade_small_star);
            am.setBackgroundResource(fVar.gGo, R.drawable.icon_grade_small_star);
            am.setBackgroundResource(fVar.gGp, R.drawable.icon_grade_small_star);
            am.setViewTextColor(fVar.gGm, R.color.cp_cont_c, 1);
            am.setBackgroundColor(fVar.dividerLine, R.color.cp_bg_line_c);
        }
        return view;
    }
}
