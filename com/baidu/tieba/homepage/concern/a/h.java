package com.baidu.tieba.homepage.concern.a;

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
/* loaded from: classes16.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    public h(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.iHJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.c cVar, a aVar) {
        if (cVar.tipString != null) {
            aVar.tipText.setText(cVar.tipString);
        }
        switch (cVar.iHK) {
            case 2:
                aVar.cv(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.cv(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        private int aiB;
        public ViewGroup iHd;
        public ImageView iHe;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.aiB = 3;
            this.iHd = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.iHe = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cv(int i, int i2) {
            if (this.aiB != i) {
                ap.setViewTextColor(this.tipText, R.color.cp_cont_j);
            }
            ap.setImageResource(this.iHe, i2);
            this.aiB = i;
        }
    }
}
