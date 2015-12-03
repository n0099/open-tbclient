package com.baidu.tieba.a;

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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b<com.baidu.tieba.a.a.j> {
    private String aCl;
    private String aCm;
    private String aMo;
    private List<g> aMs;

    public void n(String str, String str2, String str3) {
        this.aCl = str;
        this.aCm = str2;
        this.aMo = str3;
    }

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMs = new ArrayList();
        this.aLN.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a.b
    public void a(com.baidu.tieba.a.a.j jVar) {
        super.a((q) jVar);
        if (jVar == null || y.k(jVar.Ed()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        B(jVar.Ed());
        onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void B(List<com.baidu.tieba.a.a.e> list) {
        for (int i = 0; i < 5; i++) {
            if (i < list.size()) {
                com.baidu.tieba.a.a.e eVar = list.get(i);
                g gVar = (g) y.b(this.aMs, i);
                if (gVar != null) {
                    gVar.a(eVar);
                } else {
                    gVar = new g(Io());
                    gVar.a(eVar);
                    this.aLV.addView(gVar.getView());
                    this.aMs.add(gVar);
                }
                gVar.setFrom(getFrom());
                gVar.ao(this.aCl, this.aCm);
                gVar.getView().setVisibility(0);
                gVar.onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
            } else {
                g gVar2 = (g) y.b(this.aMs, i);
                if (gVar2 != null) {
                    gVar2.getView().setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.a.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aMs != null) {
            for (g gVar : this.aMs) {
                gVar.onChangeSkinType(tbPageContext, i);
            }
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aLN == view) {
            if (!TextUtils.isEmpty(this.aMo)) {
                TiebaStatic.log(this.aMo);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 2)));
            } else {
                UtilHelper.showToast(Io().getPageActivity(), n.i.plugin_config_not_found);
            }
        }
    }
}
