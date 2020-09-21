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
/* loaded from: classes21.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.c, a> {
    public h(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.c.iPF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
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
        switch (cVar.iPG) {
            case 2:
                aVar.cy(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.cy(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        private int aiX;
        public ViewGroup iOV;
        public ImageView iOW;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.aiX = 3;
            this.iOV = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.iOW = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cy(int i, int i2) {
            if (this.aiX != i) {
                ap.setViewTextColor(this.tipText, R.color.cp_cont_j);
            }
            ap.setImageResource(this.iOW, i2);
            this.aiX = i;
        }
    }
}
