package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak extends b<com.baidu.tieba.card.a.s> {
    private String aGe;
    private String aGf;
    private String aSN;
    private List<k> aTb;

    public void p(String str, String str2, String str3) {
        this.aGe = str;
        this.aGf = str2;
        this.aSN = str3;
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aTb = new ArrayList();
        this.aRp.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.s sVar) {
        super.a((ak) sVar);
        if (sVar == null || com.baidu.tbadk.core.util.y.p(sVar.FZ()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        J(sVar.FZ());
        d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void J(List<com.baidu.tieba.card.a.h> list) {
        for (int i = 0; i < 5; i++) {
            if (i < list.size()) {
                com.baidu.tieba.card.a.h hVar = list.get(i);
                k kVar = (k) com.baidu.tbadk.core.util.y.b(this.aTb, i);
                if (kVar != null) {
                    kVar.a(hVar);
                } else {
                    kVar = new k(Lb());
                    kVar.setTag(getTag());
                    kVar.a(hVar);
                    this.aRx.addView(kVar.getView());
                    this.aTb.add(kVar);
                }
                kVar.setFrom(getFrom());
                kVar.at(this.aGe, this.aGf);
                kVar.getView().setVisibility(0);
                kVar.d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
            } else {
                k kVar2 = (k) com.baidu.tbadk.core.util.y.b(this.aTb, i);
                if (kVar2 != null) {
                    kVar2.getView().setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aTb != null) {
            for (k kVar : this.aTb) {
                kVar.d(tbPageContext, i);
            }
        }
        super.d(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aRp == view) {
            if (!TextUtils.isEmpty(this.aSN)) {
                TiebaStatic.log(this.aSN);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 2)));
            } else {
                UtilHelper.showToast(Lb().getPageActivity(), t.j.plugin_config_not_found);
            }
        }
    }
}
