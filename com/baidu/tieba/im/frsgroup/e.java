package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes23.dex */
public class e extends com.baidu.tieba.frs.k<GroupInfoData, f> {
    private View.OnClickListener eUh;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.eUh = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (e.this.getItem(intValue) instanceof GroupInfoData) {
                            GroupInfoData groupInfoData = (GroupInfoData) e.this.getItem(intValue);
                            if (bg.checkUpIsLogin(e.this.mPageContext.getPageActivity()) && groupInfoData != null) {
                                long groupId = groupInfoData.getGroupId();
                                int from = groupInfoData.getFrom();
                                if (from == 4 || from == 5 || from == 6) {
                                    TiebaStatic.log(new aq("c10331").dR("obj_type", String.valueOf(groupId)));
                                }
                                t.a(CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(e.this.mPageContext.getPageActivity(), groupId, from));
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public f c(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(R.layout.frs_group_item_view, (ViewGroup) null), this.eUh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, GroupInfoData groupInfoData, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) groupInfoData, (GroupInfoData) fVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (fVar.ajq != this.mSkinType) {
            this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.mPageContext.getLayoutMode().onModeChanged(view);
            fVar.ajq = this.mSkinType;
        }
        if (groupInfoData != null) {
            fVar.rootView.setTag(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.valueOf(i));
            fVar.a(groupInfoData);
            ap.setBackgroundResource(fVar.rootView, R.drawable.frs_group_item_bg);
            ap.setViewTextColor(fVar.kfl, R.color.cp_cont_b, 1);
            ap.setViewTextColor(fVar.kfm, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(fVar.kfm, R.drawable.bg_jinqun_meizi);
            fVar.kfm.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_jinqun_meizi), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(fVar.kfn, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(fVar.kfp, R.drawable.icon_grade_small_star);
            ap.setBackgroundResource(fVar.kfq, R.drawable.icon_grade_small_star);
            ap.setBackgroundResource(fVar.kfr, R.drawable.icon_grade_small_star);
            ap.setViewTextColor(fVar.kfo, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(fVar.dividerLine, R.color.cp_bg_line_c);
        }
        return view;
    }
}
