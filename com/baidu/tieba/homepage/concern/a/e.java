package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.a, a> {
    public e(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.a.gfB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.bYl != null) {
            aVar2.bZL.setText(aVar.bYl);
        }
        switch (aVar.gfC) {
            case 2:
                aVar2.bG(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar2.bG(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public TextView bZL;
        private int ceL;
        public ViewGroup gfg;
        public ImageView gfh;

        public a(View view) {
            super(view);
            this.ceL = 3;
            this.gfg = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.gfh = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.bZL = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void bG(int i, int i2) {
            if (this.ceL != i) {
                am.j(this.bZL, R.color.cp_cont_b);
            }
            am.c(this.gfh, i2);
            this.ceL = i;
        }
    }
}
