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
import d.b.b.j.e.a;
/* loaded from: classes4.dex */
public class EmotionCategoryAdapter extends a<d.b.i0.l0.y.c.a, EmotionCategoryViewHolder> {

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15765a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15766b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f15767c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15768d;

        /* renamed from: e  reason: collision with root package name */
        public View f15769e;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.f15765a = view;
            b();
        }

        public final void b() {
            View view = this.f15765a;
            if (view == null) {
                return;
            }
            this.f15766b = (TextView) view.findViewById(R.id.emotion_title);
            this.f15767c = (ImageView) this.f15765a.findViewById(R.id.emotion_change_iv);
            this.f15768d = (TextView) this.f15765a.findViewById(R.id.emotion_function);
            this.f15766b.setText(this.f15765a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f15767c.setVisibility(8);
            this.f15768d.setVisibility(8);
            this.f15769e = this.f15765a.findViewById(R.id.category_line_top);
        }

        public void c(int i) {
            SkinManager.setBackgroundColor(this.f15769e, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.f15766b, R.color.CAM_X0107);
        }
    }

    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public EmotionCategoryViewHolder R(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.l0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.a();
    }
}
