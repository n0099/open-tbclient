package com.baidu.tieba.im.live.room;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements TextWatcher {
    final /* synthetic */ bb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.a = bbVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        LiveRoomEntranceActivity liveRoomEntranceActivity;
        Button button2;
        Button button3;
        LiveRoomEntranceActivity liveRoomEntranceActivity2;
        Button button4;
        if (editable == null || editable.toString().length() < 2) {
            button = this.a.a;
            liveRoomEntranceActivity = this.a.c;
            button.setTextColor(liveRoomEntranceActivity.getResources().getColor(com.baidu.tieba.r.cp_cont_g_4c));
            button2 = this.a.a;
            button2.setEnabled(false);
            return;
        }
        button3 = this.a.a;
        liveRoomEntranceActivity2 = this.a.c;
        button3.setTextColor(liveRoomEntranceActivity2.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
        button4 = this.a.a;
        button4.setEnabled(true);
    }
}
