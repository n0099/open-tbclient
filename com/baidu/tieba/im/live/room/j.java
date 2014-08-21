package com.baidu.tieba.im.live.room;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LiveRoomChatActivity liveRoomChatActivity, String str, String str2, String str3, String str4, boolean z) {
        this.a = liveRoomChatActivity;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        this.a.a(this.b, this.c, this.d, this.e, this.f);
    }
}
