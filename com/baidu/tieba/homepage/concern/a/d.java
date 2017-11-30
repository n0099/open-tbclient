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
        super(context, com.baidu.tieba.homepage.concern.b.a.dnu);
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
        switch (aVar.dnv) {
            case 2:
                aVar2.aN(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aN(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public TextView als;
        private int apA;
        public View cOi;
        public View cOj;
        public ViewGroup dnf;
        public ImageView dng;

        public a(View view) {
            super(view);
            this.apA = 3;
            this.cOi = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.dnf = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.dng = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.als = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.cOj = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aN(int i, int i2) {
            if (this.apA != i) {
                aj.k(this.cOi, d.C0082d.cp_bg_line_c);
                aj.c(this.dng, i2);
                aj.i(this.als, d.C0082d.cp_cont_b);
                aj.k(this.cOj, d.C0082d.cp_bg_line_c);
            }
            this.apA = i;
        }
    }
}
