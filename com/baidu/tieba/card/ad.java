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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends b<com.baidu.tieba.card.a.o> {
    private String aSN;
    private com.baidu.tbadk.widget.a.a aTa;

    public void p(String str, String str2, String str3) {
        this.aTa.at(str, str2);
        this.aSN = str3;
    }

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSN = null;
        this.aTa = new com.baidu.tbadk.widget.a.a(getContext());
        this.aTa.setTag(getTag());
        this.aTa.setLoadMoreClickListener(this);
        this.aRx.addView(this.aTa);
        this.aRp.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.aTa != null) {
            this.aTa.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
        this.aTa.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aTa != null) {
            this.aTa.de(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.o oVar) {
        super.a((ad) oVar);
        if (oVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<com.baidu.tbadk.widget.a.g> FZ = oVar.FZ();
        int p = com.baidu.tbadk.core.util.y.p(FZ);
        if (p <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (p > 10) {
            FZ = FZ.subList(0, 10);
        }
        this.aTa.a(FZ, Lb());
        d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aRp == view || (this.aTa != null && this.aTa.getLastItemView() == view)) {
            if (!TextUtils.isEmpty(this.aSN)) {
                TiebaStatic.log(this.aSN);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 1)));
            } else {
                UtilHelper.showToast(Lb().getPageActivity(), t.j.plugin_config_not_found);
            }
        }
    }
}
