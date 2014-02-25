package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.cz;
import com.baidu.tieba.view.HorizontalPanelView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NumCountDownView;
import com.baidu.tieba.view.ProgressCountDownView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SnapGroupChatView extends com.baidu.tieba.im.chat.a {
    private AlertDialog k;
    private AlertDialog l;
    private HorizontalPanelView m;
    private ProgressCountDownView n;
    private NumCountDownView o;
    private TextView p;

    public SnapGroupChatView(SnapGroupChatActivity snapGroupChatActivity, boolean z) {
        super(snapGroupChatActivity, z, 2);
        a(snapGroupChatActivity);
        b(snapGroupChatActivity);
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(R.dimen.horizontal_panel_view_height)));
        i().addHeaderView(view);
    }

    public HorizontalPanelView R() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public void a(cz czVar, boolean z) {
        super.a(czVar, z);
        this.p = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, czVar.getString(R.string.snap_group_chat_change_group), czVar);
        this.m = (HorizontalPanelView) ((ViewStub) czVar.findViewById(R.id.snap_chat_header_stub)).inflate();
        this.n = (ProgressCountDownView) this.m.findViewById(R.id.count_down);
        this.o = (NumCountDownView) ((ViewStub) czVar.findViewById(R.id.snap_chat_float_tip_stub)).inflate();
        this.o.setNoticeText(czVar.getString(R.string.snap_group_chat_float_tip));
    }

    protected void a(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(R.string.snap_group_chat_quit_confirm_tip_cancel, new i(this));
            builder.setPositiveButton(R.string.snap_group_chat_quit_confirm_tip_ok, new j(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_quit_confirm_tip));
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
    }

    protected void b(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(R.string.cancel, new k(this));
            builder.setPositiveButton(R.string.confirm, snapGroupChatActivity);
            builder.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_change_confirm_tip));
            this.l = builder.create();
            this.l.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void b(cz czVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {czVar.getString(R.string.operate_copy), czVar.getString(R.string.msg_at), czVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
            builder.setTitle(czVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, czVar);
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void c(cz czVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {czVar.getString(R.string.msg_at), czVar.getString(R.string.msg_img_save), czVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
            builder.setTitle(czVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, czVar);
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void d(cz czVar) {
        if (this.h != null) {
            this.h = null;
        }
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = TiebaApplication.g().ai() ? czVar.getString(R.string.group_close_receiver) : czVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = czVar.getString(R.string.msg_at);
        charSequenceArr[2] = czVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
        builder.setTitle(czVar.getString(R.string.operation));
        builder.setItems(charSequenceArr, czVar);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog S() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog T() {
        return this.l;
    }

    public NumCountDownView U() {
        return this.o;
    }

    public ProgressCountDownView V() {
        return this.n;
    }

    public TextView W() {
        return this.p;
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void e(cz czVar) {
    }
}
