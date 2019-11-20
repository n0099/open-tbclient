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
        super(context, com.baidu.tieba.homepage.concern.b.a.geg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.a aVar, a aVar2) {
        if (aVar.tipString != null) {
            aVar2.tipText.setText(aVar.tipString);
        }
        switch (aVar.geh) {
            case 2:
                aVar2.bA(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
                break;
            case 3:
                aVar2.bA(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                break;
        }
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private int csg;
        public ViewGroup gdL;
        public ImageView gdM;
        public TextView tipText;

        public a(View view) {
            super(view);
            this.csg = 3;
            this.gdL = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.gdM = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        protected void bA(int i, int i2) {
            if (this.csg != i) {
                am.setViewTextColor(this.tipText, (int) R.color.cp_cont_b);
            }
            am.setImageResource(this.gdM, i2);
            this.csg = i;
        }
    }
}
