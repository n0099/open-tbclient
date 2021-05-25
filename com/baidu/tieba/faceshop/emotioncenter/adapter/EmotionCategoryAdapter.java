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
import d.a.c.j.e.a;
/* loaded from: classes4.dex */
public class EmotionCategoryAdapter extends a<d.a.n0.m0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14807a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14808b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14809c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14810d;

        /* renamed from: e  reason: collision with root package name */
        public View f14811e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f14807a = view;
            b();
        }

        public final void b() {
            View view = this.f14807a;
            if (view == null) {
                return;
            }
            this.f14808b = (TextView) view.findViewById(R.id.emotion_title);
            this.f14809c = (ImageView) this.f14807a.findViewById(R.id.emotion_change_iv);
            this.f14810d = (TextView) this.f14807a.findViewById(R.id.emotion_function);
            this.f14808b.setText(this.f14807a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f14809c.setVisibility(8);
            this.f14810d.setVisibility(8);
            this.f14811e = this.f14807a.findViewById(R.id.category_line_top);
        }

        public void c(int i2) {
            SkinManager.setBackgroundColor(this.f14811e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f14808b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public EmotionCategoryViewHolder P(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.m0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
