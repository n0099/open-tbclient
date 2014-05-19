package com.baidu.tieba.im.live.livelist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ LiveGroupHistoryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LiveGroupHistoryActivity liveGroupHistoryActivity) {
        this.a = liveGroupHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ak akVar;
        String str;
        akVar = this.a.a;
        Object item = akVar.e().getItem(i);
        if (item instanceof com.baidu.tieba.im.data.i) {
            this.a.d = ((com.baidu.tieba.im.data.i) item).c();
            str = this.a.d;
            if (str != null) {
                int q = com.baidu.tieba.im.live.b.b().q();
                if (q == 1 || q == 2) {
                    new AlertDialog.Builder(this.a).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.live_replay_interrupt_other_notice).setPositiveButton(com.baidu.tieba.u.live_replay_interrupt_other_notice_yes, new ah(this)).setNegativeButton(com.baidu.tieba.u.live_replay_interrupt_other_notice_no, (DialogInterface.OnClickListener) null).create().show();
                } else {
                    this.a.g();
                }
            }
        }
    }
}
