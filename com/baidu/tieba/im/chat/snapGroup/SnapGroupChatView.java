package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.cp;
import com.baidu.tieba.view.HorizontalPanelView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NumCountDownView;
import com.baidu.tieba.view.ProgressCountDownView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SnapGroupChatView extends com.baidu.tieba.im.chat.a {
    private AlertDialog i;
    private AlertDialog j;
    private HorizontalPanelView k;
    private ProgressCountDownView l;
    private NumCountDownView m;
    private TextView n;

    public SnapGroupChatView(SnapGroupChatActivity snapGroupChatActivity, boolean z) {
        super(snapGroupChatActivity, z, 2);
        a(snapGroupChatActivity);
        b(snapGroupChatActivity);
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(R.dimen.horizontal_panel_view_height)));
        i().addHeaderView(view);
    }

    public HorizontalPanelView P() {
        return this.k;
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void a(cp cpVar, boolean z) {
        super.a(cpVar, z);
        this.n = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, cpVar.getString(R.string.snap_group_chat_change_group), cpVar);
        this.k = (HorizontalPanelView) ((ViewStub) cpVar.findViewById(R.id.snap_chat_header_stub)).inflate();
        this.l = (ProgressCountDownView) this.k.findViewById(R.id.count_down);
        this.m = (NumCountDownView) ((ViewStub) cpVar.findViewById(R.id.snap_chat_float_tip_stub)).inflate();
        this.m.setNoticeText(cpVar.getString(R.string.snap_group_chat_float_tip));
    }

    protected void a(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.i == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(R.string.snap_group_chat_quit_confirm_tip_cancel, new i(this));
            builder.setPositiveButton(R.string.snap_group_chat_quit_confirm_tip_ok, new j(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_quit_confirm_tip));
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }

    protected void b(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(R.string.cancel, new k(this));
            builder.setPositiveButton(R.string.confirm, snapGroupChatActivity);
            builder.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_change_confirm_tip));
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void b(cp cpVar) {
        if (this.e == null) {
            CharSequence[] charSequenceArr = {cpVar.getString(R.string.operate_copy), cpVar.getString(R.string.msg_at), cpVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
            builder.setTitle(cpVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, cpVar);
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void c(cp cpVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {cpVar.getString(R.string.msg_at), cpVar.getString(R.string.msg_img_save), cpVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
            builder.setTitle(cpVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, cpVar);
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void d(cp cpVar) {
        if (this.g != null) {
            this.g = null;
        }
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = TiebaApplication.h().aj() ? cpVar.getString(R.string.group_close_receiver) : cpVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = cpVar.getString(R.string.msg_at);
        charSequenceArr[2] = cpVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
        builder.setTitle(cpVar.getString(R.string.operation));
        builder.setItems(charSequenceArr, cpVar);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog Q() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog R() {
        return this.j;
    }

    public NumCountDownView S() {
        return this.m;
    }

    public ProgressCountDownView T() {
        return this.l;
    }

    public TextView U() {
        return this.n;
    }
}
