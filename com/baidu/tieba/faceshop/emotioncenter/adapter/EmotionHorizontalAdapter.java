package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView;
import d.b.b.j.e.a;
import d.b.i0.l0.y.c.b;
/* loaded from: classes4.dex */
public class EmotionHorizontalAdapter extends a<b, EmotionGridViewHolder> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionHorizontalView f15769a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f15769a = (EmotionHorizontalView) view;
        }

        public void b(b bVar) {
            EmotionHorizontalView emotionHorizontalView = this.f15769a;
            if (emotionHorizontalView == null || bVar == null) {
                return;
            }
            emotionHorizontalView.setData(bVar.f56683e);
        }
    }

    public EmotionHorizontalAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public EmotionGridViewHolder R(ViewGroup viewGroup) {
        EmotionHorizontalView emotionHorizontalView = new EmotionHorizontalView(this.m);
        EmotionGridViewHolder emotionGridViewHolder = new EmotionGridViewHolder(emotionHorizontalView);
        emotionHorizontalView.f(TbadkCoreApplication.getInst().getSkinType());
        return emotionGridViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, EmotionGridViewHolder emotionGridViewHolder) {
        emotionGridViewHolder.b(bVar);
        return emotionGridViewHolder.a();
    }
}
