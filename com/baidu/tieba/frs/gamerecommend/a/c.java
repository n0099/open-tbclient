package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.l;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private z gzt;
    private com.baidu.tieba.card.e gzv;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.fNI);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> b(ViewGroup viewGroup) {
        this.gzv = new com.baidu.tieba.card.e(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.gzv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar) {
        if (aVar.bue() == null) {
            return null;
        }
        aVar.bue().a(bVar);
        aVar.bue().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.bue().c(new z<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new an("c13047").Z("obj_locate", 3).cp("fid", c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return aVar.bue().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.axQ(), null, l.azJ(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.axQ().getFid()));
        createFromThreadCfg.setForumName(bVar.axQ().aAc());
        createFromThreadCfg.setStartFrom(0);
        l.zC(bVar.axQ().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.gzt != null) {
            this.gzt.a(view, bVar);
        }
    }

    public void d(z zVar) {
        this.gzt = zVar;
    }
}
