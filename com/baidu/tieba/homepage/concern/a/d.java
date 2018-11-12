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
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.eke);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), e.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.aCg != null) {
            aVar2.aDG.setText(aVar.aCg);
        }
        switch (aVar.ekf) {
            case 2:
                aVar2.aY(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
            case 3:
                aVar2.aY(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public TextView aDG;
        private int aIf;
        public View dKo;
        public View dKp;
        public ViewGroup ejP;
        public ImageView ejQ;

        public a(View view) {
            super(view);
            this.aIf = 3;
            this.dKo = view.findViewById(e.g.concern_emotion_tip_top_line);
            this.ejP = (ViewGroup) view.findViewById(e.g.ll_concern_emotion_tip);
            this.ejQ = (ImageView) view.findViewById(e.g.iv_concern_emotion_tip_pic);
            this.aDG = (TextView) view.findViewById(e.g.tv_concern_emotion_tip);
            this.dKp = view.findViewById(e.g.concern_emotion_tip_bottom_line);
        }

        protected void aY(int i, int i2) {
            if (this.aIf != i) {
                al.j(this.dKo, e.d.cp_bg_line_c);
                al.c(this.ejQ, i2);
                al.h(this.aDG, e.d.cp_cont_b);
                al.j(this.dKp, e.d.cp_bg_line_c);
            }
            this.aIf = i;
        }
    }
}
