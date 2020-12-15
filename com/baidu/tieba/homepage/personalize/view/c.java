package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes22.dex */
public class c extends h {
    private d jVx;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tK() {
        this.jVx = new d(this.mContext, this.ajA);
        this.jVx.setStageType("2001");
        return this.jVx;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jVx != null) {
            this.jVx.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jVx != null) {
            this.jVx.onResume();
        }
    }
}
