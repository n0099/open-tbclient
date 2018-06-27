package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dQP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.i.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.atN != null) {
            aVar2.avq.setText(aVar.atN);
        }
        switch (aVar.dQQ) {
            case 2:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public TextView avq;
        private int azP;
        public ViewGroup dQC;
        public ImageView dQD;
        public View drT;
        public View drU;

        public a(View view) {
            super(view);
            this.azP = 3;
            this.drT = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.dQC = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.dQD = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.avq = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.drU = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aM(int i, int i2) {
            if (this.azP != i) {
                am.j(this.drT, d.C0142d.cp_bg_line_c);
                am.c(this.dQD, i2);
                am.h(this.avq, d.C0142d.cp_cont_b);
                am.j(this.drU, d.C0142d.cp_bg_line_c);
            }
            this.azP = i;
        }
    }
}
