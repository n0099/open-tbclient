package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView;
import d.a.c.k.e.a;
import d.a.o0.m0.y.c.b;
/* loaded from: classes4.dex */
public class EmotionHorizontalAdapter extends a<b, EmotionGridViewHolder> {
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionHorizontalView f14951a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f14951a = (EmotionHorizontalView) view;
        }

        public void b(b bVar) {
            EmotionHorizontalView emotionHorizontalView = this.f14951a;
            if (emotionHorizontalView == null || bVar == null) {
                return;
            }
            emotionHorizontalView.setData(bVar.f61228e);
        }
    }

    public EmotionHorizontalAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public EmotionGridViewHolder Q(ViewGroup viewGroup) {
        EmotionHorizontalView emotionHorizontalView = new EmotionHorizontalView(this.m);
        EmotionGridViewHolder emotionGridViewHolder = new EmotionGridViewHolder(emotionHorizontalView);
        emotionHorizontalView.f(TbadkCoreApplication.getInst().getSkinType());
        return emotionGridViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, b bVar, EmotionGridViewHolder emotionGridViewHolder) {
        emotionGridViewHolder.b(bVar);
        return emotionGridViewHolder.a();
    }
}
