package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e dUJ;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private ad vh;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.dkq);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dUJ = new com.baidu.tieba.card.e(this.mPageContext, this.mForumId, this.mForumName);
        return new com.baidu.tieba.card.a.a<>(this.dUJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar2) {
        if (aVar2.aqe() == null) {
            return null;
        }
        aVar2.aqe().a(aVar);
        aVar2.aqe().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar2.aqe().b(new ad<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar3) {
                TiebaStatic.log(new am("c13047").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, b.this.mForumId));
                b.this.a(view2, aVar3);
            }
        });
        return aVar2.aqe().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.ZR(), null, o.zu(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.ZR().getFid()));
        createFromThreadCfg.setForumName(aVar.ZR().zM());
        createFromThreadCfg.setStartFrom(0);
        o.mD(aVar.ZR().getTid());
        this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        if (this.vh != null) {
            this.vh.a(view, aVar);
        }
    }

    public void d(ad adVar) {
        this.vh = adVar;
    }
}
