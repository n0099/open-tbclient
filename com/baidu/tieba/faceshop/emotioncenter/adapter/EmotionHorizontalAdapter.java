package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.emotioncenter.data.b;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView;
/* loaded from: classes8.dex */
public class EmotionHorizontalAdapter extends com.baidu.adp.widget.ListView.a<b, EmotionGridViewHolder> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public EmotionHorizontalAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public EmotionGridViewHolder e(ViewGroup viewGroup) {
        EmotionHorizontalView emotionHorizontalView = new EmotionHorizontalView(this.mPageContext);
        EmotionGridViewHolder emotionGridViewHolder = new EmotionGridViewHolder(emotionHorizontalView);
        emotionHorizontalView.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        return emotionGridViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, EmotionGridViewHolder emotionGridViewHolder) {
        emotionGridViewHolder.a(bVar);
        return emotionGridViewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionHorizontalView iSx;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.iSx = (EmotionHorizontalView) view;
        }

        public void a(b bVar) {
            if (this.iSx != null && bVar != null) {
                this.iSx.setData(bVar.iSA);
            }
        }
    }
}
