package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
/* loaded from: classes4.dex */
public class a extends com.baidu.card.e {
    private c geT;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.card.e, com.baidu.card.ac
    protected com.baidu.tieba.play.operableVideoView.a qj() {
        this.geT = new c(this.mContext, this.Xi);
        return this.geT;
    }

    @Override // com.baidu.card.ac
    public void onPause() {
        super.onPause();
        if (this.geT != null) {
            this.geT.onPause();
        }
    }

    @Override // com.baidu.card.ac
    public void onResume() {
        super.onResume();
        if (this.geT != null) {
            this.geT.onResume();
        }
    }
}
