package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes21.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, a> {
    private HotTopicActivity kbN;
    public boolean kbW;
    public final TbPageContext<?> mPageContext;
    private BdUniqueId mTag;

    public BdUniqueId getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kbW = true;
        this.mTag = null;
        this.kbN = hotTopicActivity;
        this.mPageContext = hotTopicActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public a c(ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.view.a aVar = new com.baidu.tieba.hottopic.view.a(this.kbN.getPageContext());
        aVar.setTag(getTag());
        aVar.setFrom("home");
        this.kbW = true;
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (aVar == null || aVar.kbX == null) {
            return null;
        }
        if (this.kbW) {
            aVar.kbX.a(nVar);
            this.kbW = false;
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public class a extends af.a {
        public com.baidu.tieba.hottopic.view.a kbX;
        private int mSkinType;

        public a(com.baidu.tieba.hottopic.view.a aVar) {
            super(aVar.getView());
            this.mSkinType = 3;
            this.kbX = aVar;
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                if (this.kbX != null) {
                    this.kbX.onChangeSkinType(this.kbX.getTbPageContext(), i);
                }
                this.mSkinType = i;
            }
        }
    }
}
