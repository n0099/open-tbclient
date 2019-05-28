package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import com.baidu.card.t;
/* loaded from: classes4.dex */
public class b extends t {
    private d geU;

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.card.t, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geU = new d(this.mContext, this.Xi);
        return this.geU;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geU != null) {
            this.geU.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geU != null) {
            this.geU.onResume();
        }
    }
}
