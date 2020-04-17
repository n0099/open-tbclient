package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class d extends x {
    private f hQY;

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        this.hQY = new f(this.mContext, this.afy);
        return this.hQY;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hQY != null) {
            this.hQY.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hQY != null) {
            this.hQY.onResume();
        }
    }
}
