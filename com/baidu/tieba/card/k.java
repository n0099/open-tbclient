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
    private bl akj;
    private TbPageContext alI;
    private com.baidu.tieba.card.data.n bHm;
    private View.OnClickListener bHn;
    private View.OnClickListener bHo;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHn = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akj != null && k.this.akj.getAuthor() != null && !StringUtils.isNull(k.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(k.this.akj.getAuthor().getUserId()) && k.this.akj.rK() != null) {
                    if (k.this.We() != null) {
                        k.this.We().a(view, k.this.bHm);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.alI.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(k.this.akj.getAuthor().getUserId(), 0L), false, k.this.akj.getAuthor().isBigV())));
                }
            }
        };
        this.bHo = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.We() != null) {
                    k.this.We().a(view, k.this.bHm);
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bcL != null) {
            this.bHm = nVar;
            this.akj = nVar.bcL;
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
