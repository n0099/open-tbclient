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
        super(context, com.baidu.tieba.homepage.concern.b.a.det);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.ajo != null) {
            aVar2.akV.setText(aVar.ajo);
        }
        switch (aVar.deu) {
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
        public TextView akV;
        private int api;
        public View cEJ;
        public View cEK;
        public ViewGroup def;
        public ImageView deg;

        public a(View view) {
            super(view);
            this.api = 3;
            this.cEJ = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.def = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.deg = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.akV = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.cEK = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aN(int i, int i2) {
            if (this.api != i) {
                aj.k(this.cEJ, d.C0080d.cp_bg_line_c);
                aj.c(this.deg, i2);
                aj.i(this.akV, d.C0080d.cp_cont_b);
                aj.k(this.cEK, d.C0080d.cp_bg_line_c);
            }
            this.api = i;
        }
    }
}
