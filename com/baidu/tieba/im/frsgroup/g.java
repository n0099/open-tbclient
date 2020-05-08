package com.baidu.tieba.im.frsgroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.CreateGroupMainActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes10.dex */
public class g extends com.baidu.tieba.frs.h<h, i> {
    private View.OnClickListener dFZ;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dFZ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof Integer) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (g.this.getItem(intValue) instanceof h) {
                        h hVar = (h) g.this.getItem(intValue);
                        int cfP = hVar.cfP();
                        if (cfP == 0 && (hVar.rJ() instanceof GroupPermData)) {
                            g.this.a((GroupPermData) hVar.rJ());
                        } else if (cfP == 1) {
                            bc.checkUpIsLogin(g.this.mPageContext.getPageActivity());
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public i b(ViewGroup viewGroup) {
        return new i(LayoutInflater.from(this.mContext).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null), this.dFZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, i iVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) iVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (hVar != null) {
            iVar.a(hVar.cfQ(), hVar.cfM(), hVar.cfN(), hVar.cfO());
            iVar.ilN.setTag(Integer.valueOf(i));
        }
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
                    this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupStepActivityConfig(this.mPageContext.getPageActivity(), 3, com.baidu.adp.lib.f.b.toInt(forumId, 0), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                    return;
                }
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupMainActivityConfig(this.mPageContext.getPageActivity(), groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), com.baidu.adp.lib.f.b.toInt(forumId, 0), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
        }
    }
}
