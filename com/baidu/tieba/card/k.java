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
    private bh ajg;
    private com.baidu.tieba.card.data.n bLd;
    private View.OnClickListener bLe;
    private View.OnClickListener bLf;
    private TbPageContext mG;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bLe = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.ajg != null && k.this.ajg.getAuthor() != null && !StringUtils.isNull(k.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(k.this.ajg.getAuthor().getUserId()) && k.this.ajg.rA() != null) {
                    if (k.this.Xr() != null) {
                        k.this.Xr().a(view, k.this.bLd);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.mG.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.ajg.getAuthor().getUserId(), 0L), false, k.this.ajg.getAuthor().isBigV())));
                }
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.Xr() != null) {
                    k.this.Xr().a(view, k.this.bLd);
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bes != null) {
            this.bLd = nVar;
            this.ajg = nVar.bes;
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
