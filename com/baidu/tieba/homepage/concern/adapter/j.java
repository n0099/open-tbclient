package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.b, a> {
    public j(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.jLm);
    }

    public j(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.b bVar, a aVar) {
        if (bVar.tipString != null) {
            aVar.tipText.setText(bVar.tipString);
        }
        if (bVar.getType() == com.baidu.tieba.homepage.concern.a.b.jLl) {
            if (bVar.jLn == 2) {
                aVar.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
            } else {
                aVar.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
            }
        }
        switch (bVar.jLn) {
            case 2:
                aVar.cH(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.cH(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private int aku;
        public ImageView jKA;
        public ViewGroup jKz;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.aku = 3;
            this.jKz = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.jKA = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cH(int i, int i2) {
            if (this.aku != i) {
                ap.setViewTextColor(this.tipText, R.color.CAM_X0107);
            }
            ap.setImageResource(this.jKA, i2);
            this.aku = i;
        }
    }
}
