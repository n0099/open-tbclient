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
public class EmotionCategoryAdapter extends a<d.a.j0.l0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15589a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15590b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f15591c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15592d;

        /* renamed from: e  reason: collision with root package name */
        public View f15593e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f15589a = view;
            b();
        }

        public final void b() {
            View view = this.f15589a;
            if (view == null) {
                return;
            }
            this.f15590b = (TextView) view.findViewById(R.id.emotion_title);
            this.f15591c = (ImageView) this.f15589a.findViewById(R.id.emotion_change_iv);
            this.f15592d = (TextView) this.f15589a.findViewById(R.id.emotion_function);
            this.f15590b.setText(this.f15589a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f15591c.setVisibility(8);
            this.f15592d.setVisibility(8);
            this.f15593e = this.f15589a.findViewById(R.id.category_line_top);
        }

        public void c(int i2) {
            SkinManager.setBackgroundColor(this.f15593e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f15590b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public EmotionCategoryViewHolder P(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.l0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
