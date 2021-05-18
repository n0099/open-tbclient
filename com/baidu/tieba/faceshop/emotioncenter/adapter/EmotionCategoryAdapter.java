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
public class EmotionCategoryAdapter extends a<d.a.k0.l0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14904a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14905b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14906c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14907d;

        /* renamed from: e  reason: collision with root package name */
        public View f14908e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f14904a = view;
            b();
        }

        public final void b() {
            View view = this.f14904a;
            if (view == null) {
                return;
            }
            this.f14905b = (TextView) view.findViewById(R.id.emotion_title);
            this.f14906c = (ImageView) this.f14904a.findViewById(R.id.emotion_change_iv);
            this.f14907d = (TextView) this.f14904a.findViewById(R.id.emotion_function);
            this.f14905b.setText(this.f14904a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f14906c.setVisibility(8);
            this.f14907d.setVisibility(8);
            this.f14908e = this.f14904a.findViewById(R.id.category_line_top);
        }

        public void c(int i2) {
            SkinManager.setBackgroundColor(this.f14908e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f14905b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public EmotionCategoryViewHolder P(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.l0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
