package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.g;
/* loaded from: classes2.dex */
public class b extends g {
    private c kiJ;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a ti() {
        this.kiJ = new c(this.mContext, this.ahC);
        this.kiJ.setStageType("2001");
        return this.kiJ;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.kiJ != null) {
            this.kiJ.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.kiJ != null) {
            this.kiJ.onResume();
        }
    }
}
