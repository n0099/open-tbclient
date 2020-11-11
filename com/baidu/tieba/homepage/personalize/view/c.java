package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes22.dex */
public class c extends h {
    private f jGT;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.jGT = new f(this.mContext, this.aiw);
        this.jGT.setStageType("2001");
        return this.jGT;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jGT != null) {
            this.jGT.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jGT != null) {
            this.jGT.onResume();
        }
    }
}
