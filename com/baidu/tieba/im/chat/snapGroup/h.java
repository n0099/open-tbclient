package com.baidu.tieba.im.chat.snapGroup;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        this.a.a.finish();
        z = this.a.a.v;
        if (z) {
            this.a.a.showToast(this.a.a.getString(R.string.snap_group_chat_kick_out_by_silence), false);
        }
    }
}
