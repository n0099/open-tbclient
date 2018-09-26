package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.eaQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), e.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.awG != null) {
            aVar2.ayh.setText(aVar.awG);
        }
        switch (aVar.eaR) {
            case 2:
                aVar2.aT(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
            case 3:
                aVar2.aT(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        private int aCJ;
        public TextView ayh;
        public View dBk;
        public View dBl;
        public ViewGroup eaB;
        public ImageView eaC;

        public a(View view) {
            super(view);
            this.aCJ = 3;
            this.dBk = view.findViewById(e.g.concern_emotion_tip_top_line);
            this.eaB = (ViewGroup) view.findViewById(e.g.ll_concern_emotion_tip);
            this.eaC = (ImageView) view.findViewById(e.g.iv_concern_emotion_tip_pic);
            this.ayh = (TextView) view.findViewById(e.g.tv_concern_emotion_tip);
            this.dBl = view.findViewById(e.g.concern_emotion_tip_bottom_line);
        }

        protected void aT(int i, int i2) {
            if (this.aCJ != i) {
                al.j(this.dBk, e.d.cp_bg_line_c);
                al.c(this.eaC, i2);
                al.h(this.ayh, e.d.cp_cont_b);
                al.j(this.dBl, e.d.cp_bg_line_c);
            }
            this.aCJ = i;
        }
    }
}
