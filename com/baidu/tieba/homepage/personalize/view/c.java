package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.h;
/* loaded from: classes21.dex */
public class c extends h {
    private f iZx;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.iZx = new f(this.mContext, this.aie);
        this.iZx.setStageType("2001");
        return this.iZx;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
        if (this.iZx != null) {
            this.iZx.onPause();
        }
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
        if (this.iZx != null) {
            this.iZx.onResume();
        }
    }
}
