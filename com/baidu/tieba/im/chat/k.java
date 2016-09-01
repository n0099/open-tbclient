package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cSu;
    private final /* synthetic */ MsglistActivity cSv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cSu = absMsglistView;
        this.cSv = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cSv.getActivity(), this.cSv.getActivity().getCurrentFocus());
        if (this.cSu.mTool != null) {
            this.cSu.mTool.AS();
        }
        this.cSu.MainOnTouch();
        return false;
    }
}
