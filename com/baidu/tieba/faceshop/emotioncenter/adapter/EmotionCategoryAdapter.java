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
import d.a.c.k.e.a;
/* loaded from: classes4.dex */
public class EmotionCategoryAdapter extends a<d.a.n0.m0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14864a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14865b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14866c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14867d;

        /* renamed from: e  reason: collision with root package name */
        public View f14868e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f14864a = view;
            b();
        }

        public final void b() {
            View view = this.f14864a;
            if (view == null) {
                return;
            }
            this.f14865b = (TextView) view.findViewById(R.id.emotion_title);
            this.f14866c = (ImageView) this.f14864a.findViewById(R.id.emotion_change_iv);
            this.f14867d = (TextView) this.f14864a.findViewById(R.id.emotion_function);
            this.f14865b.setText(this.f14864a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f14866c.setVisibility(8);
            this.f14867d.setVisibility(8);
            this.f14868e = this.f14864a.findViewById(R.id.category_line_top);
        }

        public void c(int i2) {
            SkinManager.setBackgroundColor(this.f14868e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f14865b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public EmotionCategoryViewHolder Q(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.m0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
