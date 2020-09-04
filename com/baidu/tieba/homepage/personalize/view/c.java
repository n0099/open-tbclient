package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes16.dex */
public class c extends com.baidu.card.g {
    private f iQQ;

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        this.iQQ = new f(this.mContext, this.ahJ);
        this.iQQ.setStageType("2001");
        return this.iQQ;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
        if (this.iQQ != null) {
            this.iQQ.onPause();
        }
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
        if (this.iQQ != null) {
            this.iQQ.onResume();
        }
    }
}
