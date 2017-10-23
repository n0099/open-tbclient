package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class k extends j {
    private bh aiU;
    private com.baidu.tieba.card.data.n bKR;
    private View.OnClickListener bKS;
    private View.OnClickListener bKT;
    private TbPageContext mH;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aiU != null && k.this.aiU.getAuthor() != null && !StringUtils.isNull(k.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(k.this.aiU.getAuthor().getUserId()) && k.this.aiU.rt() != null) {
                    if (k.this.Xn() != null) {
                        k.this.Xn().a(view, k.this.bKR);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.mH.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.aiU.getAuthor().getUserId(), 0L), false, k.this.aiU.getAuthor().isBigV())));
                }
            }
        };
        this.bKT = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.Xn() != null) {
                    k.this.Xn().a(view, k.this.bKR);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bee != null) {
            this.bKR = nVar;
            this.aiU = nVar.bee;
            nVar.sourceType = 0;
        }
    }

    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.j
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }
}
