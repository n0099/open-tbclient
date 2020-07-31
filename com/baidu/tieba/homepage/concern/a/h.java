package com.baidu.tieba.homepage.concern.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.c, a> {
    public h(Context context) {
        super(context, com.baidu.tieba.homepage.concern.b.c.its);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.c cVar, a aVar) {
        if (cVar.tipString != null) {
            aVar.tipText.setText(cVar.tipString);
        }
        switch (cVar.itt) {
            case 2:
                aVar.cn(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar.cn(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private int aho;
        public ViewGroup isM;
        public ImageView isN;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.aho = 3;
            this.isM = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.isN = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void cn(int i, int i2) {
            if (this.aho != i) {
                ao.setViewTextColor(this.tipText, R.color.cp_cont_j);
            }
            ao.setImageResource(this.isN, i2);
            this.aho = i;
        }
    }
}
