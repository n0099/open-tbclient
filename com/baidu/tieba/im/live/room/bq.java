package com.baidu.tieba.im.live.room;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bq extends Dialog {
    public Context a;
    public LiveRoomChatActivity b;
    public TextView c;
    public TextView d;
    public EditText e;
    public Window f;
    public ScrollView g;

    public bq(Context context, LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(context, i);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = context;
        this.b = liveRoomChatActivity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.reminder_notice_edit_layout);
        setCancelable(false);
        this.g = (ScrollView) findViewById(com.baidu.tieba.u.reminder_notice_scrollview);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setHorizontalScrollBarEnabled(false);
        this.f = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int width = this.f.getWindowManager().getDefaultDisplay().getWidth();
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds520);
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.gravity = 51;
        layoutParams.y = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds272);
        layoutParams.x = (width - dimensionPixelSize) / 2;
        layoutParams.format = -3;
        this.f.setAttributes(layoutParams);
        this.e = (EditText) findViewById(com.baidu.tieba.u.reminder_notice_edittext);
        this.b.ShowSoftKeyPadDelay(this.e, 150);
        this.e.setOnFocusChangeListener(new br(this));
        this.e.addTextChangedListener(new bs(this));
        this.d = (TextView) findViewById(com.baidu.tieba.u.cancel_reminder_notice);
        this.d.setOnClickListener(new bt(this));
        this.c = (TextView) findViewById(com.baidu.tieba.u.send_reminder_notice);
        this.c.setOnClickListener(new bu(this));
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            com.baidu.adp.lib.util.j.a(this.b, this.e);
            dismiss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public View a() {
        return this.e;
    }
}
