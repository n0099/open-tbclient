package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes2.dex */
public class b extends g {
    private c kml;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        this.kml = new c(this.mContext, this.agA);
        this.kml.setStageType("2001");
        return this.kml;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.kml != null) {
            this.kml.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.kml != null) {
            this.kml.onResume();
        }
    }
}
