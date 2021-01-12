package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes7.dex */
public class RelateCardForumAdapter extends com.baidu.adp.widget.ListView.a<n, CardGroupRelateForumHolder> {
    public boolean kkD;
    private HotTopicActivity kku;
    public final TbPageContext<?> mPageContext;
    private BdUniqueId mTag;

    public BdUniqueId getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelateCardForumAdapter(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kkD = true;
        this.mTag = null;
        this.kku = hotTopicActivity;
        this.mPageContext = hotTopicActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public CardGroupRelateForumHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.view.a aVar = new com.baidu.tieba.hottopic.view.a(this.kku.getPageContext());
        aVar.setTag(getTag());
        aVar.setFrom("home");
        this.kkD = true;
        return new CardGroupRelateForumHolder(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, CardGroupRelateForumHolder cardGroupRelateForumHolder) {
        if (cardGroupRelateForumHolder == null || cardGroupRelateForumHolder.kkE == null) {
            return null;
        }
        if (this.kkD) {
            cardGroupRelateForumHolder.kkE.a(nVar);
            this.kkD = false;
        }
        cardGroupRelateForumHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return cardGroupRelateForumHolder.getView();
    }

    /* loaded from: classes7.dex */
    public class CardGroupRelateForumHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.hottopic.view.a kkE;
        private int mSkinType;

        public CardGroupRelateForumHolder(com.baidu.tieba.hottopic.view.a aVar) {
            super(aVar.getView());
            this.mSkinType = 3;
            this.kkE = aVar;
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                if (this.kkE != null) {
                    this.kkE.onChangeSkinType(this.kkE.getTbPageContext(), i);
                }
                this.mSkinType = i;
            }
        }
    }
}
