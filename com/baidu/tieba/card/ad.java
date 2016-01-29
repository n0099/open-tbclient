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
public class ad extends b<com.baidu.tieba.card.a.p> {
    private String aEJ;
    private String aEK;
    private String aPS;
    private List<k> aQg;

    public void n(String str, String str2, String str3) {
        this.aEJ = str;
        this.aEK = str2;
        this.aPS = str3;
    }

    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQg = new ArrayList();
        this.aOA.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.p pVar) {
        super.a((ad) pVar);
        if (pVar == null || com.baidu.tbadk.core.util.x.o(pVar.Fm()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        G(pVar.Fm());
        d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void G(List<com.baidu.tieba.card.a.h> list) {
        for (int i = 0; i < 5; i++) {
            if (i < list.size()) {
                com.baidu.tieba.card.a.h hVar = list.get(i);
                k kVar = (k) com.baidu.tbadk.core.util.x.b(this.aQg, i);
                if (kVar != null) {
                    kVar.a(hVar);
                } else {
                    kVar = new k(JK());
                    kVar.setTag(getTag());
                    kVar.a(hVar);
                    this.aOI.addView(kVar.getView());
                    this.aQg.add(kVar);
                }
                kVar.setFrom(getFrom());
                kVar.an(this.aEJ, this.aEK);
                kVar.getView().setVisibility(0);
                kVar.d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
            } else {
                k kVar2 = (k) com.baidu.tbadk.core.util.x.b(this.aQg, i);
                if (kVar2 != null) {
                    kVar2.getView().setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aQg != null) {
            for (k kVar : this.aQg) {
                kVar.d(tbPageContext, i);
            }
        }
        super.d(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aOA == view) {
            if (!TextUtils.isEmpty(this.aPS)) {
                TiebaStatic.log(this.aPS);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 2)));
            } else {
                UtilHelper.showToast(JK().getPageActivity(), t.j.plugin_config_not_found);
            }
        }
    }
}
