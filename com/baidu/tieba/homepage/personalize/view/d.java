package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.y;
/* loaded from: classes9.dex */
public class d extends y {
    private f igB;

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.card.y, com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        this.igB = new f(this.mContext, this.afX);
        return this.igB;
    }

    @Override // com.baidu.card.am
    public void onPause() {
        super.onPause();
        if (this.igB != null) {
            this.igB.onPause();
        }
    }

    @Override // com.baidu.card.am
    public void onResume() {
        super.onResume();
        if (this.igB != null) {
            this.igB.onResume();
        }
    }
}
