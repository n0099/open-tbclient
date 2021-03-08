package com.baidu.tieba.homepage.video.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> {
    private ab<k> ahy;
    private s anC;
    private BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<k>() { // from class: com.baidu.tieba.homepage.video.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.blp() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.video.c.a.p(kVar);
                    } else if (id == R.id.user_avatar) {
                        com.baidu.tieba.homepage.video.c.a.o(kVar);
                    } else if (id == R.id.user_name) {
                        com.baidu.tieba.homepage.video.c.a.o(kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fIy);
        dVar.bs(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.video.a.f.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
            }
        });
        dVar.b(this.mPageContext);
        aVar.a(dVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.anC);
        a2.setSourceForPb(19);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new w() { // from class: com.baidu.tieba.homepage.video.a.f.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (f.this.ahy != null) {
                        f.this.ahy.a(threadCardViewHolder2.getView(), kVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(kVar, view.getContext(), 19, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eLr == null) {
            return null;
        }
        kVar.xe(kVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.a(kVar.eLr.blz(), (FollowUserButton.a) null);
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP, this.gfx);
        threadCardViewHolder.b((ThreadCardViewHolder<k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        return threadCardViewHolder.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIy = bdUniqueId;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }
}
