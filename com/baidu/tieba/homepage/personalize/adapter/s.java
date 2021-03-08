package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, ThreadCardViewHolder<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String ajx;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.homepage.topic.topictab.b.a> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.d dVar = new com.baidu.tieba.homepage.personalize.view.d(this.mContext, this.mPageContext);
        dVar.setTag(this.mPageId);
        aVar.c(dVar);
        aVar.ti().bA(0);
        aVar.ti().bB(0);
        aVar.ti().bC(0);
        aVar.ti().bz(0);
        aVar.ti().by(0);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<com.baidu.tieba.homepage.topic.topictab.b.a> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.s.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    com.baidu.tieba.homepage.topic.topictab.b.a aVar2 = (com.baidu.tieba.homepage.topic.topictab.b.a) nVar;
                    if (aVar2 != null && aVar2.from != 1) {
                        TiebaStatic.log(new ar("c13351").v("topic_id", aVar2.topicId).aq("obj_locate", aVar2.index));
                    }
                    if (aVar2 != null && aVar2.from == 1) {
                        TiebaStatic.log(new ar("c13449").v("topic_id", aVar2.topicId));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(s.this.mContext, aVar2.topicId)));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, ThreadCardViewHolder<com.baidu.tieba.homepage.topic.topictab.b.a> threadCardViewHolder) {
        if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        TiebaStatic.log(new ar("c13448").v("topic_id", aVar.topicId));
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.tj().setPage(this.ajx);
        threadCardViewHolder.aK(false).a(this.gfx);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.homepage.topic.topictab.b.a>) aVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }
}
