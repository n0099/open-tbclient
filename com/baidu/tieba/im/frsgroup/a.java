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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.f<GroupPermData, b> {
    private View.OnClickListener ani;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ani = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    Object tag = view2.getTag();
                    if (tag instanceof Integer) {
                        int intValue = ((Integer) tag).intValue();
                        if (a.this.getItem(intValue) instanceof GroupPermData) {
                            GroupPermData groupPermData = (GroupPermData) a.this.getItem(intValue);
                            if (az.aK(a.this.mPageContext.getPageActivity())) {
                                TiebaStatic.log(new al("c10332"));
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
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.frs_create_group_item_view, (ViewGroup) null), this.ani);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, GroupPermData groupPermData, b bVar) {
        super.onFillViewHolder(i, view2, viewGroup, groupPermData, bVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().u(view2);
        bVar.rootView.setTag(Integer.valueOf(i));
        ak.i(bVar.rootView, d.f.frs_group_item_bg);
        ak.j(bVar.cUm, d.C0126d.cp_bg_line_c);
        ak.c(bVar.dXD, d.C0126d.cp_cont_b, 1);
        bVar.dXD.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_add_croup), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.i(bVar.divider, d.C0126d.cp_bg_line_b);
        return view2;
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
