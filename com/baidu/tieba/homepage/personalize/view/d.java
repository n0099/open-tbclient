package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.y;
/* loaded from: classes9.dex */
public class d extends y {
    private f ifO;

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.card.y, com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        this.ifO = new f(this.mContext, this.afX);
        return this.ifO;
    }

    @Override // com.baidu.card.am
    public void onPause() {
        super.onPause();
        if (this.ifO != null) {
            this.ifO.onPause();
        }
    }

    @Override // com.baidu.card.am
    public void onResume() {
        super.onResume();
        if (this.ifO != null) {
            this.ifO.onResume();
        }
    }
}
