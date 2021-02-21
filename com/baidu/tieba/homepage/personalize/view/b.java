package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes2.dex */
public class b extends g {
    private c kmz;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        this.kmz = new c(this.mContext, this.agA);
        this.kmz.setStageType("2001");
        return this.kmz;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.kmz != null) {
            this.kmz.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.kmz != null) {
            this.kmz.onResume();
        }
    }
}
