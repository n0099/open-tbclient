package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class k extends j {
    private bl aiQ;
    private TbPageContext ako;
    private com.baidu.tieba.card.data.n bGc;
    private View.OnClickListener bGd;
    private View.OnClickListener bGe;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGd = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aiQ != null && k.this.aiQ.getAuthor() != null && !StringUtils.isNull(k.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(k.this.aiQ.getAuthor().getUserId()) && k.this.aiQ.rA() != null) {
                    if (k.this.VZ() != null) {
                        k.this.VZ().a(view, k.this.bGc);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.ako.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.aiQ.getAuthor().getUserId(), 0L), false, k.this.aiQ.getAuthor().isBigV())));
                }
            }
        };
        this.bGe = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.VZ() != null) {
                    k.this.VZ().a(view, k.this.bGc);
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bbB != null) {
            this.bGc = nVar;
            this.aiQ = nVar.bbB;
            nVar.sourceType = 0;
        }
    }

    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.j
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }
}
