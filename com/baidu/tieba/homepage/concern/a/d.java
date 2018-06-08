package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dNx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.i.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.atk != null) {
            aVar2.auE.setText(aVar.atk);
        }
        switch (aVar.dNy) {
            case 2:
                aVar2.aN(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aN(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public TextView auE;
        private int ayX;
        public ViewGroup dNk;
        public ImageView dNl;
        public View doK;
        public View doL;

        public a(View view) {
            super(view);
            this.ayX = 3;
            this.doK = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.dNk = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.dNl = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.auE = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.doL = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aN(int i, int i2) {
            if (this.ayX != i) {
                al.j(this.doK, d.C0141d.cp_bg_line_c);
                al.c(this.dNl, i2);
                al.h(this.auE, d.C0141d.cp_cont_b);
                al.j(this.doL, d.C0141d.cp_bg_line_c);
            }
            this.ayX = i;
        }
    }
}
