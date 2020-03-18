package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class c extends com.baidu.card.g {
    private e hhn;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hhn = new e(this.mContext, this.MN);
        return this.hhn;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hhn != null) {
            this.hhn.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hhn != null) {
            this.hhn.onResume();
        }
    }
}
