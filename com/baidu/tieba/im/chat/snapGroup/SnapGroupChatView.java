package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ProgressCountDownView;
import com.baidu.tieba.im.chat.CommonGroupMsglistView;
import com.baidu.tieba.im.chat.dn;
import com.baidu.tieba.im.view.HorizontalPanelView;
import com.baidu.tieba.im.view.NumCountDownView;
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
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(com.baidu.tieba.im.j.snap_group_chat_quit_confirm_tip_cancel, new j(this));
            builder.setPositiveButton(com.baidu.tieba.im.j.snap_group_chat_quit_confirm_tip_ok, new k(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(com.baidu.tieba.im.j.snap_group_chat_quit_confirm_tip));
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        if (this.l == null) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(snapGroupChatActivity);
            builder2.setNegativeButton(com.baidu.tieba.im.j.cancel, new l(this));
            builder2.setPositiveButton(com.baidu.tieba.im.j.confirm, snapGroupChatActivity);
            builder2.setTitle(snapGroupChatActivity.getString(com.baidu.tieba.im.j.snap_group_chat_change_confirm_tip));
            this.l = builder2.create();
            this.l.setCanceledOnTouchOutside(true);
        }
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.horizontal_panel_view_height)));
        j().addHeaderView(view);
    }

    public final HorizontalPanelView R() {
        return this.m;
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void a(dn dnVar, boolean z) {
        super.a(dnVar, z);
        this.p = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, dnVar.getString(com.baidu.tieba.im.j.snap_group_chat_change_group), dnVar);
        this.m = (HorizontalPanelView) ((ViewStub) dnVar.findViewById(com.baidu.tieba.im.h.snap_chat_header_stub)).inflate();
        this.n = (ProgressCountDownView) this.m.findViewById(com.baidu.tieba.im.h.count_down);
        this.o = (NumCountDownView) ((ViewStub) dnVar.findViewById(com.baidu.tieba.im.h.snap_chat_float_tip_stub)).inflate();
        this.o.setNoticeText(dnVar.getString(com.baidu.tieba.im.j.snap_group_chat_float_tip));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlertDialog S() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlertDialog T() {
        return this.l;
    }

    public final NumCountDownView U() {
        return this.o;
    }

    public final ProgressCountDownView V() {
        return this.n;
    }

    public final TextView W() {
        return this.p;
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final int k() {
        return 0;
    }
}
