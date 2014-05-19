package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LiveRoomChatActivity liveRoomChatActivity, String str, String str2, String str3, String str4, boolean z) {
        this.a = liveRoomChatActivity;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a(this.b, this.c, this.d, this.e, this.f);
    }
}
