package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ConcernEmotionTipAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.b, ConcernEmotionTipViewHolder> {
    public ConcernEmotionTipAdapter(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.kbM);
    }

    public ConcernEmotionTipAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public ConcernEmotionTipViewHolder e(ViewGroup viewGroup) {
        return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.b bVar, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        if (bVar.tipString != null) {
            concernEmotionTipViewHolder.tipText.setText(bVar.tipString);
        }
        if (bVar.getType() == com.baidu.tieba.homepage.concern.a.b.kbL) {
            if (bVar.kbN == 2) {
                concernEmotionTipViewHolder.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
            } else {
                concernEmotionTipViewHolder.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
            }
        }
        switch (bVar.kbN) {
            case 2:
                concernEmotionTipViewHolder.cC(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                concernEmotionTipViewHolder.cC(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return concernEmotionTipViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {
        private int ajU;
        public ViewGroup kaX;
        public ImageView kaY;
        public TextView tipText;

        public ConcernEmotionTipViewHolder(View view) {
            super(view);
            this.ajU = 3;
            this.kaX = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.kaY = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cC(int i, int i2) {
            if (this.ajU != i) {
                ap.setViewTextColor(this.tipText, R.color.CAM_X0107);
            }
            ap.setImageResource(this.kaY, i2);
            this.ajU = i;
        }
    }
}
