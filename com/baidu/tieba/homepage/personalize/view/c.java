package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private f ivM;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rP() {
        this.ivM = new f(this.mContext, this.agI);
        return this.ivM;
    }

    @Override // com.baidu.card.ar
    public void onPause() {
        super.onPause();
        if (this.ivM != null) {
            this.ivM.onPause();
        }
    }

    @Override // com.baidu.card.ar
    public void onResume() {
        super.onResume();
        if (this.ivM != null) {
            this.ivM.onResume();
        }
    }
}
