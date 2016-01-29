package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends b<com.baidu.tieba.card.a.n> {
    private String aPS;
    private com.baidu.tbadk.widget.a.a aQf;

    public void n(String str, String str2, String str3) {
        this.aQf.an(str, str2);
        this.aPS = str3;
    }

    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPS = null;
        this.aQf = new com.baidu.tbadk.widget.a.a(getContext());
        this.aQf.setTag(getTag());
        this.aQf.setLoadMoreClickListener(this);
        this.aOI.addView(this.aQf);
        this.aOA.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.aQf != null) {
            this.aQf.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
        this.aQf.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aQf != null) {
            this.aQf.db(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.n nVar) {
        super.a((ab) nVar);
        if (nVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<com.baidu.tbadk.widget.a.g> Fm = nVar.Fm();
        int o = com.baidu.tbadk.core.util.x.o(Fm);
        if (o <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (o > 10) {
            Fm = Fm.subList(0, 10);
        }
        this.aQf.a(Fm, JK());
        d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aOA == view || (this.aQf != null && this.aQf.getLastItemView() == view)) {
            if (!TextUtils.isEmpty(this.aPS)) {
                TiebaStatic.log(this.aPS);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 1)));
            } else {
                UtilHelper.showToast(JK().getPageActivity(), t.j.plugin_config_not_found);
            }
        }
    }
}
