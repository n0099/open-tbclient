package com.baidu.tieba.im.live.room;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements TextWatcher {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.a = azVar;
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
            button = this.a.c;
            liveRoomEntranceActivity = this.a.e;
            button.setTextColor(liveRoomEntranceActivity.getResources().getColor(com.baidu.tieba.o.cp_cont_g_4c));
            button2 = this.a.c;
            button2.setEnabled(false);
            return;
        }
        button3 = this.a.c;
        liveRoomEntranceActivity2 = this.a.e;
        button3.setTextColor(liveRoomEntranceActivity2.getResources().getColor(com.baidu.tieba.o.cp_cont_g));
        button4 = this.a.c;
        button4.setEnabled(true);
    }
}
