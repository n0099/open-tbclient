package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class d extends x {
    private f hho;

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hho = new f(this.mContext, this.MN);
        return this.hho;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hho != null) {
            this.hho.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hho != null) {
            this.hho.onResume();
        }
    }
}
