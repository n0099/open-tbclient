package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.cy;
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
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(R.string.snap_group_chat_quit_confirm_tip_cancel, new i(this));
            builder.setPositiveButton(R.string.snap_group_chat_quit_confirm_tip_ok, new j(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_quit_confirm_tip));
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        if (this.l == null) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(snapGroupChatActivity);
            builder2.setNegativeButton(R.string.cancel, new k(this));
            builder2.setPositiveButton(R.string.confirm, snapGroupChatActivity);
            builder2.setTitle(snapGroupChatActivity.getString(R.string.snap_group_chat_change_confirm_tip));
            this.l = builder2.create();
            this.l.setCanceledOnTouchOutside(true);
        }
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(R.dimen.horizontal_panel_view_height)));
        h().addHeaderView(view);
    }

    public final HorizontalPanelView P() {
        return this.m;
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void a(cy cyVar, boolean z) {
        super.a(cyVar, z);
        this.p = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, cyVar.getString(R.string.snap_group_chat_change_group), cyVar);
        this.m = (HorizontalPanelView) ((ViewStub) cyVar.findViewById(R.id.snap_chat_header_stub)).inflate();
        this.n = (ProgressCountDownView) this.m.findViewById(R.id.count_down);
        this.o = (NumCountDownView) ((ViewStub) cyVar.findViewById(R.id.snap_chat_float_tip_stub)).inflate();
        this.o.setNoticeText(cyVar.getString(R.string.snap_group_chat_float_tip));
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void b(cy cyVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {cyVar.getString(R.string.operate_copy), cyVar.getString(R.string.msg_at), cyVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
            builder.setTitle(cyVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, cyVar);
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void c(cy cyVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {cyVar.getString(R.string.msg_at), cyVar.getString(R.string.msg_img_save), cyVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
            builder.setTitle(cyVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, cyVar);
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void d(cy cyVar) {
        if (this.h != null) {
            this.h = null;
        }
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = TiebaApplication.g().ab() ? cyVar.getString(R.string.group_close_receiver) : cyVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = cyVar.getString(R.string.msg_at);
        charSequenceArr[2] = cyVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
        builder.setTitle(cyVar.getString(R.string.operation));
        builder.setItems(charSequenceArr, cyVar);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlertDialog Q() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlertDialog R() {
        return this.l;
    }

    public final NumCountDownView S() {
        return this.o;
    }

    public final ProgressCountDownView T() {
        return this.n;
    }

    public final TextView U() {
        return this.p;
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void e(cy cyVar) {
    }
}
