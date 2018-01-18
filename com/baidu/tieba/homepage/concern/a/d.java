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
        super(context, com.baidu.tieba.homepage.concern.b.a.ebW);
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
        if (aVar.aXS != null) {
            aVar2.aZs.setText(aVar.aXS);
        }
        switch (aVar.ebX) {
            case 2:
                aVar2.bM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
            case 3:
                aVar2.bM(TbadkCoreApplication.getInst().getSkinType(), d.f.emotion_dashen);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public TextView aZs;
        private int bdK;
        public View dHY;
        public View dHZ;
        public ViewGroup ebH;
        public ImageView ebI;

        public a(View view) {
            super(view);
            this.bdK = 3;
            this.dHY = view.findViewById(d.g.concern_emotion_tip_top_line);
            this.ebH = (ViewGroup) view.findViewById(d.g.ll_concern_emotion_tip);
            this.ebI = (ImageView) view.findViewById(d.g.iv_concern_emotion_tip_pic);
            this.aZs = (TextView) view.findViewById(d.g.tv_concern_emotion_tip);
            this.dHZ = view.findViewById(d.g.concern_emotion_tip_bottom_line);
        }

        protected void bM(int i, int i2) {
            if (this.bdK != i) {
                aj.t(this.dHY, d.C0107d.cp_bg_line_c);
                aj.c(this.ebI, i2);
                aj.r(this.aZs, d.C0107d.cp_cont_b);
                aj.t(this.dHZ, d.C0107d.cp_bg_line_c);
            }
            this.bdK = i;
        }
    }
}
