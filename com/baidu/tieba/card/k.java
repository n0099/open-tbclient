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
    private bh ajq;
    private com.baidu.tieba.card.data.n bSL;
    private View.OnClickListener bSM;
    private View.OnClickListener bSN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bSM = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ajq != null && k.this.ajq.rt() != null && !StringUtils.isNull(k.this.ajq.rt().getName_show()) && !StringUtils.isNull(k.this.ajq.rt().getUserId()) && k.this.ajq.rz() != null) {
                    if (k.this.ZJ() != null) {
                        k.this.ZJ().a(view, k.this.bSL);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.ajq.rt().getUserId(), 0L), false, k.this.ajq.rt().isBigV())));
                }
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ZJ() != null) {
                    k.this.ZJ().a(view, k.this.bSL);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bff != null) {
            this.bSL = nVar;
            this.ajq = nVar.bff;
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
