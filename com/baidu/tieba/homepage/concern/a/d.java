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
        super(context, com.baidu.tieba.homepage.concern.b.a.cWd);
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
        if (aVar.aiS != null) {
            aVar2.akz.setText(aVar.aiS);
        }
        switch (aVar.cWe) {
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
        public TextView akz;
        private int aoN;
        public View cVN;
        public ViewGroup cVO;
        public ImageView cVP;
        public View cVQ;

        public a(View view) {
            super(view);
            this.aoN = 3;
            this.cVN = view.findViewById(d.h.concern_emotion_tip_top_line);
            this.cVO = (ViewGroup) view.findViewById(d.h.ll_concern_emotion_tip);
            this.cVP = (ImageView) view.findViewById(d.h.iv_concern_emotion_tip_pic);
            this.akz = (TextView) view.findViewById(d.h.tv_concern_emotion_tip);
            this.cVQ = view.findViewById(d.h.concern_emotion_tip_bottom_line);
        }

        protected void aM(int i, int i2) {
            if (this.aoN != i) {
                aj.k(this.cVN, d.e.cp_bg_line_c);
                aj.c(this.cVP, i2);
                aj.i(this.akz, d.e.cp_cont_b);
                aj.k(this.cVQ, d.e.cp_bg_line_c);
            }
            this.aoN = i;
        }
    }
}
