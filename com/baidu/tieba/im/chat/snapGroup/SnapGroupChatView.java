package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ProgressCountDownView;
import com.baidu.tieba.im.chat.CommonGroupMsglistView;
import com.baidu.tieba.im.chat.dd;
import com.baidu.tieba.im.view.HorizontalPanelView;
import com.baidu.tieba.im.view.NumCountDownView;
import com.baidu.tieba.p;
import com.baidu.tieba.r;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SnapGroupChatView extends CommonGroupMsglistView {
    private AlertDialog k;
    private AlertDialog l;
    private HorizontalPanelView m;
    private ProgressCountDownView n;
    private NumCountDownView o;
    private TextView p;

    public SnapGroupChatView(SnapGroupChatActivity snapGroupChatActivity, boolean z) {
        super(snapGroupChatActivity, z);
        a(snapGroupChatActivity);
        b(snapGroupChatActivity);
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(p.horizontal_panel_view_height)));
        m().addHeaderView(view);
    }

    public HorizontalPanelView Q() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public void a(dd ddVar, boolean z) {
        super.a(ddVar, z);
        this.p = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, ddVar.getString(u.snap_group_chat_change_group), ddVar);
        this.m = (HorizontalPanelView) ((ViewStub) ddVar.findViewById(r.snap_chat_header_stub)).inflate();
        this.n = (ProgressCountDownView) this.m.findViewById(r.count_down);
        this.o = (NumCountDownView) ((ViewStub) ddVar.findViewById(r.snap_chat_float_tip_stub)).inflate();
        this.o.setNoticeText(ddVar.getString(u.snap_group_chat_float_tip));
    }

    protected void a(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(u.snap_group_chat_quit_confirm_tip_cancel, new j(this));
            builder.setPositiveButton(u.snap_group_chat_quit_confirm_tip_ok, new k(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(u.snap_group_chat_quit_confirm_tip));
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
    }

    protected void b(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(u.cancel, new l(this));
            builder.setPositiveButton(u.confirm, snapGroupChatActivity);
            builder.setTitle(snapGroupChatActivity.getString(u.snap_group_chat_change_confirm_tip));
            this.l = builder.create();
            this.l.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog R() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog S() {
        return this.l;
    }

    public NumCountDownView T() {
        return this.o;
    }

    public ProgressCountDownView U() {
        return this.n;
    }

    public TextView V() {
        return this.p;
    }

    @Override // com.baidu.tieba.im.chat.h
    protected int n() {
        return 0;
    }
}
