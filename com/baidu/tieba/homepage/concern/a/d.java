package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.dBn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.i.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.alc != null) {
            aVar2.amw.setText(aVar.alc);
        }
        switch (aVar.dBo) {
            case 2:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.aM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends q.a {
        public TextView amw;
        private int aqQ;
        public ViewGroup dAY;
        public ImageView dAZ;
        public View deq;
        public View der;

        public a(View view2) {
            super(view2);
            this.aqQ = 3;
            this.deq = view2.findViewById(d.g.concern_emotion_tip_top_line);
            this.dAY = (ViewGroup) view2.findViewById(d.g.ll_concern_emotion_tip);
            this.dAZ = (ImageView) view2.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.amw = (TextView) view2.findViewById(d.g.tv_concern_emotion_tip);
            this.der = view2.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void aM(int i, int i2) {
            if (this.aqQ != i) {
                ak.j(this.deq, d.C0126d.cp_bg_line_c);
                ak.c(this.dAZ, i2);
                ak.h(this.amw, d.C0126d.cp_cont_b);
                ak.j(this.der, d.C0126d.cp_bg_line_c);
            }
            this.aqQ = i;
        }
    }
}
