package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, am<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String ahw;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.homepage.topic.topictab.b.a> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.e eVar = new com.baidu.tieba.homepage.personalize.view.e(this.mContext, this.mPageContext);
        eVar.setTag(this.mPageId);
        aVar.c(eVar);
        aVar.tV().bx(0);
        aVar.tV().by(0);
        aVar.tV().bz(0);
        aVar.tV().bw(0);
        aVar.tV().bv(0);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup);
        a2.setSourceForPb(2);
        am<com.baidu.tieba.homepage.topic.topictab.b.a> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.w.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (view.getTag() instanceof am)) {
                    com.baidu.tieba.homepage.topic.topictab.b.a aVar2 = (com.baidu.tieba.homepage.topic.topictab.b.a) qVar;
                    if (aVar2 != null && aVar2.from != 1) {
                        TiebaStatic.log(new ar("c13351").w("topic_id", aVar2.topicId).ak("obj_locate", aVar2.index));
                    }
                    if (aVar2 != null && aVar2.from == 1) {
                        TiebaStatic.log(new ar("c13449").w("topic_id", aVar2.topicId));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(w.this.mContext, aVar2.topicId)));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, am<com.baidu.tieba.homepage.topic.topictab.b.a> amVar) {
        if (aVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new ar("c13448").w("topic_id", aVar.topicId));
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahw);
        amVar.aN(false).a(this.fOM);
        amVar.b((am<com.baidu.tieba.homepage.topic.topictab.b.a>) aVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }
}
