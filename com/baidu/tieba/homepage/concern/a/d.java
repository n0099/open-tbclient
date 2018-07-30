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
        super(context, com.baidu.tieba.homepage.concern.b.a.dTC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.atr != null) {
            aVar2.auW.setText(aVar.atr);
        }
        switch (aVar.dTD) {
            case 2:
                aVar2.aP(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aP(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public TextView auW;
        private int azI;
        public ViewGroup dTp;
        public ImageView dTq;
        public View duG;
        public View duH;

        public a(View view) {
            super(view);
            this.azI = 3;
            this.duG = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.dTp = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.dTq = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.auW = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.duH = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aP(int i, int i2) {
            if (this.azI != i) {
                am.j(this.duG, d.C0140d.cp_bg_line_c);
                am.c(this.dTq, i2);
                am.h(this.auW, d.C0140d.cp_cont_b);
                am.j(this.duH, d.C0140d.cp_bg_line_c);
            }
            this.azI = i;
        }
    }
}
