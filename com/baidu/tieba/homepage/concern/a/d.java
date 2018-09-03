package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dTx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), f.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.ats != null) {
            aVar2.auV.setText(aVar.ats);
        }
        switch (aVar.dTy) {
            case 2:
                aVar2.aP(TbadkCoreApplication.getInst().getSkinType(), f.C0146f.emotion_dashen);
                break;
            case 3:
                aVar2.aP(TbadkCoreApplication.getInst().getSkinType(), f.C0146f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public TextView auV;
        private int azF;
        public ViewGroup dTk;
        public ImageView dTl;
        public View duD;
        public View duE;

        public a(View view) {
            super(view);
            this.azF = 3;
            this.duD = view.findViewById(f.g.concern_emotion_tip_top_line);
            this.dTk = (ViewGroup) view.findViewById(f.g.ll_concern_emotion_tip);
            this.dTl = (ImageView) view.findViewById(f.g.iv_concern_emotion_tip_pic);
            this.auV = (TextView) view.findViewById(f.g.tv_concern_emotion_tip);
            this.duE = view.findViewById(f.g.concern_emotion_tip_bottom_line);
        }

        protected void aP(int i, int i2) {
            if (this.azF != i) {
                am.j(this.duD, f.d.cp_bg_line_c);
                am.c(this.dTl, i2);
                am.h(this.auV, f.d.cp_cont_b);
                am.j(this.duE, f.d.cp_bg_line_c);
            }
            this.azF = i;
        }
    }
}
