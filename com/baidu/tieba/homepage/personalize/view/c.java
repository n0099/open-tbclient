package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes22.dex */
public class c extends h {
    private f jow;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.jow = new f(this.mContext, this.aiv);
        this.jow.setStageType("2001");
        return this.jow;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jow != null) {
            this.jow.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jow != null) {
            this.jow.onResume();
        }
    }
}
