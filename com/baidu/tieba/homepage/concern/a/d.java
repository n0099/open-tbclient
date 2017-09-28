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
    Context mContext;

    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.cWp);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.j.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.aje != null) {
            aVar2.akL.setText(aVar.aje);
        }
        switch (aVar.cWq) {
            case 2:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.g.emotion_dashen);
                break;
            case 3:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.g.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public TextView akL;
        private int aoZ;
        public View cVZ;
        public ViewGroup cWa;
        public ImageView cWb;
        public View cWc;

        public a(View view) {
            super(view);
            this.aoZ = 3;
            this.cVZ = view.findViewById(d.h.concern_emotion_tip_top_line);
            this.cWa = (ViewGroup) view.findViewById(d.h.ll_concern_emotion_tip);
            this.cWb = (ImageView) view.findViewById(d.h.iv_concern_emotion_tip_pic);
            this.akL = (TextView) view.findViewById(d.h.tv_concern_emotion_tip);
            this.cWc = view.findViewById(d.h.concern_emotion_tip_bottom_line);
        }

        protected void aM(int i, int i2) {
            if (this.aoZ != i) {
                aj.k(this.cVZ, d.e.cp_bg_line_c);
                aj.c(this.cWb, i2);
                aj.i(this.akL, d.e.cp_cont_b);
                aj.k(this.cWc, d.e.cp_bg_line_c);
            }
            this.aoZ = i;
        }
    }
}
