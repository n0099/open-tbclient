package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes22.dex */
public class c extends h {
    private d jVv;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tK() {
        this.jVv = new d(this.mContext, this.ajA);
        this.jVv.setStageType("2001");
        return this.jVv;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.jVv != null) {
            this.jVv.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.jVv != null) {
            this.jVv.onResume();
        }
    }
}
