package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes15.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, a> {
    private HotTopicActivity iXq;
    public boolean iXz;
    public final TbPageContext<?> mPageContext;
    private BdUniqueId mTag;

    public BdUniqueId getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iXz = true;
        this.mTag = null;
        this.iXq = hotTopicActivity;
        this.mPageContext = hotTopicActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public a b(ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.view.a aVar = new com.baidu.tieba.hottopic.view.a(this.iXq.getPageContext());
        aVar.setTag(getTag());
        aVar.setFrom("home");
        this.iXz = true;
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (aVar == null || aVar.iXA == null) {
            return null;
        }
        if (this.iXz) {
            aVar.iXA.a(nVar);
            this.iXz = false;
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes15.dex */
    public class a extends af.a {
        public com.baidu.tieba.hottopic.view.a iXA;
        private int mSkinType;

        public a(com.baidu.tieba.hottopic.view.a aVar) {
            super(aVar.getView());
            this.mSkinType = 3;
            this.iXA = aVar;
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                if (this.iXA != null) {
                    this.iXA.onChangeSkinType(this.iXA.getTbPageContext(), i);
                }
                this.mSkinType = i;
            }
        }
    }
}
