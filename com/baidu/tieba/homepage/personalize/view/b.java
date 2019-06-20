package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d geW;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geW = new d(this.mContext, this.Xh);
        return this.geW;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geW != null) {
            this.geW.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geW != null) {
            this.geW.onResume();
        }
    }
}
