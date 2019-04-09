package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.fGI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.bOv != null) {
            aVar2.bPV.setText(aVar.bOv);
        }
        switch (aVar.fGJ) {
            case 2:
                aVar2.bu(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.bu(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public TextView bPV;
        private int bUN;
        public ViewGroup fGs;
        public ImageView fGt;
        public View fhN;
        public View fhO;

        public a(View view) {
            super(view);
            this.bUN = 3;
            this.fhN = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.fGs = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.fGt = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.bPV = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.fhO = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void bu(int i, int i2) {
            if (this.bUN != i) {
                al.l(this.fhN, d.C0277d.cp_bg_line_c);
                al.c(this.fGt, i2);
                al.j(this.bPV, d.C0277d.cp_cont_b);
                al.l(this.fhO, d.C0277d.cp_bg_line_c);
            }
            this.bUN = i;
        }
    }
}
