package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, a> {
    public i(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.c.jwU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.c cVar, a aVar) {
        if (cVar.tipString != null) {
            aVar.tipText.setText(cVar.tipString);
        }
        switch (cVar.jwV) {
            case 2:
                aVar.cC(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.cC(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private int ajq;
        public ViewGroup jwk;
        public ImageView jwl;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.ajq = 3;
            this.jwk = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.jwl = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cC(int i, int i2) {
            if (this.ajq != i) {
                ap.setViewTextColor(this.tipText, R.color.cp_cont_j);
            }
            ap.setImageResource(this.jwl, i2);
            this.ajq = i;
        }
    }
}
