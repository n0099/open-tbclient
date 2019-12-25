package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes6.dex */
public class b extends x {
    private d gZY;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        this.gZY = new d(this.mContext, this.Mf);
        return this.gZY;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.gZY != null) {
            this.gZY.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.gZY != null) {
            this.gZY.onResume();
        }
    }
}
