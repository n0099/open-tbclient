package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public d(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.egr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(viewGroup.getContext(), d.h.concern_emotion_tip_layout, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.aZx != null) {
            aVar2.baZ.setText(aVar.aZx);
        }
        switch (aVar.egs) {
            case 2:
                aVar2.bK(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.bK(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public TextView baZ;
        private int bfz;
        public View dLi;
        public View dLj;
        public ViewGroup egc;
        public ImageView egd;

        public a(View view) {
            super(view);
            this.bfz = 3;
            this.dLi = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.egc = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.egd = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.baZ = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.dLj = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void bK(int i, int i2) {
            if (this.bfz != i) {
                aj.t(this.dLi, d.C0141d.cp_bg_line_c);
                aj.c(this.egd, i2);
                aj.r(this.baZ, d.C0141d.cp_cont_b);
                aj.t(this.dLj, d.C0141d.cp_bg_line_c);
            }
            this.bfz = i;
        }
    }
}
