package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.x;
/* loaded from: classes9.dex */
public class b extends x {
    private d hfO;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.x, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mZ() {
        this.hfO = new d(this.mContext, this.MK);
        return this.hfO;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
        if (this.hfO != null) {
            this.hfO.onPause();
        }
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
        if (this.hfO != null) {
            this.hfO.onResume();
        }
    }
}
