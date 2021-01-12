package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes2.dex */
public class b extends g {
    private c kec;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sX() {
        this.kec = new c(this.mContext, this.agL);
        this.kec.setStageType("2001");
        return this.kec;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.kec != null) {
            this.kec.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.kec != null) {
            this.kec.onResume();
        }
    }
}
