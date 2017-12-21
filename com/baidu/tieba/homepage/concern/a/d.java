package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.doE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.ajK != null) {
            aVar2.als.setText(aVar.ajK);
        }
        switch (aVar.doF) {
            case 2:
                aVar2.aO(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aO(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public TextView als;
        private int apG;
        public View cOx;
        public View cOy;
        public ViewGroup dop;
        public ImageView doq;

        public a(View view) {
            super(view);
            this.apG = 3;
            this.cOx = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.dop = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.doq = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.als = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.cOy = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aO(int i, int i2) {
            if (this.apG != i) {
                aj.k(this.cOx, d.C0095d.cp_bg_line_c);
                aj.c(this.doq, i2);
                aj.i(this.als, d.C0095d.cp_cont_b);
                aj.k(this.cOy, d.C0095d.cp_bg_line_c);
            }
            this.apG = i;
        }
    }
}
