package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView;
import d.a.c.j.e.a;
import d.a.j0.l0.y.c.b;
/* loaded from: classes4.dex */
public class EmotionHorizontalAdapter extends a<b, EmotionGridViewHolder> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionHorizontalView f15594a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f15594a = (EmotionHorizontalView) view;
        }

        public void b(b bVar) {
            EmotionHorizontalView emotionHorizontalView = this.f15594a;
            if (emotionHorizontalView == null || bVar == null) {
                return;
            }
            emotionHorizontalView.setData(bVar.f56517e);
        }
    }

    public EmotionHorizontalAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public EmotionGridViewHolder P(ViewGroup viewGroup) {
        EmotionHorizontalView emotionHorizontalView = new EmotionHorizontalView(this.m);
        EmotionGridViewHolder emotionGridViewHolder = new EmotionGridViewHolder(emotionHorizontalView);
        emotionHorizontalView.f(TbadkCoreApplication.getInst().getSkinType());
        return emotionGridViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, b bVar, EmotionGridViewHolder emotionGridViewHolder) {
        emotionGridViewHolder.b(bVar);
        return emotionGridViewHolder.a();
    }
}
