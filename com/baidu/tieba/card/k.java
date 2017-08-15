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
    private bl akl;
    private com.baidu.tieba.card.data.n bHV;
    private View.OnClickListener bHW;
    private View.OnClickListener bHX;
    private int mSkinType;
    private TbPageContext oV;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHW = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akl != null && k.this.akl.getAuthor() != null && !StringUtils.isNull(k.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(k.this.akl.getAuthor().getUserId()) && k.this.akl.rK() != null) {
                    if (k.this.WA() != null) {
                        k.this.WA().a(view, k.this.bHV);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(k.this.oV.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(k.this.akl.getAuthor().getUserId(), 0L), false, k.this.akl.getAuthor().isBigV())));
                }
            }
        };
        this.bHX = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.WA() != null) {
                    k.this.WA().a(view, k.this.bHV);
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.j, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        super.a(nVar);
        if (nVar != null && nVar.bcM != null) {
            this.bHV = nVar;
            this.akl = nVar.bcM;
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
