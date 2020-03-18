package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    public g(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.gZB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
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
        switch (cVar.gZC) {
            case 2:
                aVar.bT(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.bT(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        private int Nj;
        public ViewGroup gYQ;
        public ImageView gYR;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.Nj = 3;
            this.gYQ = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.gYR = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void bT(int i, int i2) {
            if (this.Nj != i) {
                am.setViewTextColor(this.tipText, (int) R.color.cp_cont_j);
            }
            am.setImageResource(this.gYR, i2);
            this.Nj = i;
        }
    }
}
