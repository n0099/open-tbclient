package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.j.e.a;
/* loaded from: classes4.dex */
public class EmotionCategoryAdapter extends a<d.b.i0.l0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15428a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15429b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f15430c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15431d;

        /* renamed from: e  reason: collision with root package name */
        public View f15432e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f15428a = view;
            b();
        }

        public final void b() {
            View view = this.f15428a;
            if (view == null) {
                return;
            }
            this.f15429b = (TextView) view.findViewById(R.id.emotion_title);
            this.f15430c = (ImageView) this.f15428a.findViewById(R.id.emotion_change_iv);
            this.f15431d = (TextView) this.f15428a.findViewById(R.id.emotion_function);
            this.f15429b.setText(this.f15428a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f15430c.setVisibility(8);
            this.f15431d.setVisibility(8);
            this.f15432e = this.f15428a.findViewById(R.id.category_line_top);
        }

        public void c(int i) {
            SkinManager.setBackgroundColor(this.f15432e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f15429b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public EmotionCategoryViewHolder R(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.l0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
