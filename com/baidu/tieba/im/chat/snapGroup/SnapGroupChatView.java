package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ProgressCountDownView;
import com.baidu.tieba.im.chat.CommonGroupMsglistView;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.HorizontalPanelView;
import com.baidu.tieba.im.view.NumCountDownView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SnapGroupChatView extends CommonGroupMsglistView {
    private AlertDialog l;
    private AlertDialog m;
    private HorizontalPanelView n;
    private ProgressCountDownView o;
    private NumCountDownView p;
    private TextView q;

    public SnapGroupChatView(SnapGroupChatActivity snapGroupChatActivity, boolean z) {
        super(snapGroupChatActivity, z);
        a(snapGroupChatActivity);
        b(snapGroupChatActivity);
        View view = new View(snapGroupChatActivity);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, snapGroupChatActivity.getResources().getDimensionPixelSize(t.horizontal_panel_view_height)));
        m().addHeaderView(view);
    }

    public HorizontalPanelView S() {
        return this.n;
    }

    @Override // com.baidu.tieba.im.chat.g
    protected void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        this.q = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, talkableActivity.getString(y.snap_group_chat_change_group), talkableActivity);
        this.n = (HorizontalPanelView) ((ViewStub) talkableActivity.findViewById(v.snap_chat_header_stub)).inflate();
        this.o = (ProgressCountDownView) this.n.findViewById(v.count_down);
        this.p = (NumCountDownView) ((ViewStub) talkableActivity.findViewById(v.snap_chat_float_tip_stub)).inflate();
        this.p.setNoticeText(talkableActivity.getString(y.snap_group_chat_float_tip));
    }

    protected void a(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(y.snap_group_chat_quit_confirm_tip_cancel, new j(this));
            builder.setPositiveButton(y.snap_group_chat_quit_confirm_tip_ok, new k(this, snapGroupChatActivity));
            builder.setTitle(snapGroupChatActivity.getString(y.snap_group_chat_quit_confirm_tip));
            this.l = builder.create();
            this.l.setCanceledOnTouchOutside(true);
        }
    }

    protected void b(SnapGroupChatActivity snapGroupChatActivity) {
        if (this.m == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(snapGroupChatActivity);
            builder.setNegativeButton(y.cancel, new l(this));
            builder.setPositiveButton(y.confirm, snapGroupChatActivity);
            builder.setTitle(snapGroupChatActivity.getString(y.snap_group_chat_change_confirm_tip));
            this.m = builder.create();
            this.m.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog T() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog U() {
        return this.m;
    }

    public NumCountDownView V() {
        return this.p;
    }

    public ProgressCountDownView W() {
        return this.o;
    }

    public TextView X() {
        return this.q;
    }

    @Override // com.baidu.tieba.im.chat.g
    protected int n() {
        return 0;
    }
}
