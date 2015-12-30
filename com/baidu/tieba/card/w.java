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
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends b<com.baidu.tieba.card.a.m> {
    private String aDT;
    private String aDU;
    private String aNP;
    private List<h> aOd;

    public void n(String str, String str2, String str3) {
        this.aDT = str;
        this.aDU = str2;
        this.aNP = str3;
    }

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOd = new ArrayList();
        this.aNm.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.m mVar) {
        super.a((w) mVar);
        if (mVar == null || com.baidu.tbadk.core.util.y.l(mVar.DS()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        C(mVar.DS());
        onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void C(List<com.baidu.tieba.card.a.g> list) {
        for (int i = 0; i < 5; i++) {
            if (i < list.size()) {
                com.baidu.tieba.card.a.g gVar = list.get(i);
                h hVar = (h) com.baidu.tbadk.core.util.y.b(this.aOd, i);
                if (hVar != null) {
                    hVar.a(gVar);
                } else {
                    hVar = new h(Ie());
                    hVar.setTag(getTag());
                    hVar.a(gVar);
                    this.aNu.addView(hVar.getView());
                    this.aOd.add(hVar);
                }
                hVar.setFrom(getFrom());
                hVar.an(this.aDT, this.aDU);
                hVar.getView().setVisibility(0);
                hVar.onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
            } else {
                h hVar2 = (h) com.baidu.tbadk.core.util.y.b(this.aOd, i);
                if (hVar2 != null) {
                    hVar2.getView().setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aOd != null) {
            for (h hVar : this.aOd) {
                hVar.onChangeSkinType(tbPageContext, i);
            }
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aNm == view) {
            if (!TextUtils.isEmpty(this.aNP)) {
                TiebaStatic.log(this.aNP);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 2)));
            } else {
                UtilHelper.showToast(Ie().getPageActivity(), n.j.plugin_config_not_found);
            }
        }
    }
}
