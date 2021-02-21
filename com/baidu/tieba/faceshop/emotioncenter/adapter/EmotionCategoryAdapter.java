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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class EmotionCategoryAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.faceshop.emotioncenter.data.a, EmotionCategoryViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public EmotionCategoryViewHolder e(ViewGroup viewGroup) {
        EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.emotion_category_layout, viewGroup, false));
        emotionCategoryViewHolder.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        return emotionCategoryViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.faceshop.emotioncenter.data.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        return emotionCategoryViewHolder.getView();
    }

    /* loaded from: classes9.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {
        private ImageView iYn;
        private TextView iYo;
        private View iYp;
        private TextView mTitle;
        private View mView;

        public EmotionCategoryViewHolder(View view) {
            super(view);
            this.mView = view;
            initView();
        }

        private void initView() {
            if (this.mView != null) {
                this.mTitle = (TextView) this.mView.findViewById(R.id.emotion_title);
                this.iYn = (ImageView) this.mView.findViewById(R.id.emotion_change_iv);
                this.iYo = (TextView) this.mView.findViewById(R.id.emotion_function);
                this.mTitle.setText(this.mView.getResources().getText(R.string.emotion_center_quality_recommend));
                this.iYn.setVisibility(8);
                this.iYo.setVisibility(8);
                this.iYp = this.mView.findViewById(R.id.category_line_top);
            }
        }

        public void onChangeSkin(int i) {
            ap.setBackgroundColor(this.iYp, R.color.common_color_10312);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        }
    }
}
