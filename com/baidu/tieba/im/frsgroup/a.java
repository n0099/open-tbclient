package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.CreateGroupMainActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.h<GroupPermData, b> {
    private View.OnClickListener avD;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.avD = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (a.this.getItem(intValue) instanceof GroupPermData) {
                            GroupPermData groupPermData = (GroupPermData) a.this.getItem(intValue);
                            if (bb.aU(a.this.mPageContext.getPageActivity())) {
                                TiebaStatic.log(new an("c10332"));
                                a.this.a(groupPermData);
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(f.h.frs_create_group_item_view, (ViewGroup) null), this.avD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GroupPermData groupPermData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, groupPermData, bVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        bVar.rootView.setTag(Integer.valueOf(i));
        am.i(bVar.rootView, f.C0146f.frs_group_item_bg);
        am.j(bVar.djk, f.d.cp_bg_line_c);
        am.c(bVar.erG, f.d.cp_cont_b, 1);
        bVar.erG.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_add_croup), (Drawable) null, (Drawable) null, (Drawable) null);
        am.i(bVar.divider, f.d.cp_bg_line_b);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupPermData groupPermData) {
        if (groupPermData != null) {
            String forumId = groupPermData.getForumId();
            if (!groupPermData.isManager()) {
                if (!groupPermData.isCreateNormal()) {
                    this.mPageContext.showToast(groupPermData.getCreateNormalTip());
                    return;
                } else {
                    this.mPageContext.sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(this.mPageContext.getPageActivity(), 3, com.baidu.adp.lib.g.b.g(forumId, 0), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                    return;
                }
            }
            this.mPageContext.sendMessage(new CustomMessage(2002001, new CreateGroupMainActivityConfig(this.mPageContext.getPageActivity(), groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), com.baidu.adp.lib.g.b.g(forumId, 0), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
        }
    }
}
