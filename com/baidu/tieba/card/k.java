package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class k extends j {
    private bj ajF;
    private com.baidu.tieba.card.data.n bKQ;
    private View.OnClickListener bKR;
    private View.OnClickListener bKS;
    private TbPageContext mF;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKR = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ajF != null && k.this.ajF.getAuthor() != null && !StringUtils.isNull(k.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(k.this.ajF.getAuthor().getUserId()) && k.this.ajF.rG() != null) {
                    if (k.this.XA() != null) {
                        k.this.XA().a(view, k.this.bKQ);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.mF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.ajF.getAuthor().getUserId(), 0L), false, k.this.ajF.getAuthor().isBigV())));
                }
            }
        };
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.XA() != null) {
                    k.this.XA().a(view, k.this.bKQ);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bcJ != null) {
            this.bKQ = nVar;
            this.ajF = nVar.bcJ;
            nVar.sourceType = 0;
        }
    }

    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.j
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }
}
