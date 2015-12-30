package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b<com.baidu.tieba.card.a.k> {
    private String aNP;
    private com.baidu.tbadk.widget.a.a aOc;

    public void n(String str, String str2, String str3) {
        this.aOc.an(str, str2);
        this.aNP = str3;
    }

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aNP = null;
        this.aOc = new com.baidu.tbadk.widget.a.a(getContext());
        this.aOc.setTag(getTag());
        this.aOc.setLoadMoreClickListener(this);
        this.aNu.addView(this.aOc);
        this.aNm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.aOc != null) {
            this.aOc.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
        this.aOc.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aOc != null) {
            this.aOc.cK(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.k kVar) {
        super.a((u) kVar);
        if (kVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<com.baidu.tbadk.widget.a.g> DS = kVar.DS();
        int l = com.baidu.tbadk.core.util.y.l(DS);
        if (l <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (l > 10) {
            DS = DS.subList(0, 10);
        }
        this.aOc.a(DS, Ie());
        onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aNm == view || (this.aOc != null && this.aOc.getLastItemView() == view)) {
            if (!TextUtils.isEmpty(this.aNP)) {
                TiebaStatic.log(this.aNP);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 1)));
            } else {
                UtilHelper.showToast(Ie().getPageActivity(), n.j.plugin_config_not_found);
            }
        }
    }
}
