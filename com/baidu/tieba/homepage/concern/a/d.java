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
        super(context, com.baidu.tieba.homepage.concern.b.a.eux);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), e.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.aGk != null) {
            aVar2.aHK.setText(aVar.aGk);
        }
        switch (aVar.euy) {
            case 2:
                aVar2.aZ(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
            case 3:
                aVar2.aZ(TbadkCoreApplication.getInst().getSkinType(), e.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public TextView aHK;
        private int aMk;
        public View dUp;
        public View dUq;
        public ViewGroup eui;
        public ImageView euj;

        public a(View view) {
            super(view);
            this.aMk = 3;
            this.dUp = view.findViewById(e.g.concern_emotion_tip_top_line);
            this.eui = (ViewGroup) view.findViewById(e.g.ll_concern_emotion_tip);
            this.euj = (ImageView) view.findViewById(e.g.iv_concern_emotion_tip_pic);
            this.aHK = (TextView) view.findViewById(e.g.tv_concern_emotion_tip);
            this.dUq = view.findViewById(e.g.concern_emotion_tip_bottom_line);
        }

        protected void aZ(int i, int i2) {
            if (this.aMk != i) {
                al.j(this.dUp, e.d.cp_bg_line_c);
                al.c(this.euj, i2);
                al.h(this.aHK, e.d.cp_cont_b);
                al.j(this.dUq, e.d.cp_bg_line_c);
            }
            this.aMk = i;
        }
    }
}
