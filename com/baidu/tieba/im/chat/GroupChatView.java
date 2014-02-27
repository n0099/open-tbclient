package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupChatView extends a {
    private TextView k;

    public GroupChatView(MsglistActivity msglistActivity, boolean z, int i) {
        super(msglistActivity, z, i);
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public final void a(cy cyVar, boolean z) {
        String str;
        super.a(cyVar, z);
        if (this.j == 0) {
            str = cyVar.getString(R.string.msglist_groupinfo);
        } else if (this.j != 1) {
            str = null;
        } else {
            str = cyVar.getString(R.string.msglist_personInfo);
        }
        if (str != null) {
            String stringExtra = cyVar.getIntent().getStringExtra("group_author_id");
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, cyVar);
            this.k = (TextView) this.c.findViewById(R.id.group_info_btn_txt);
            this.k.setText(str);
            this.d = (ImageView) this.c.findViewById(R.id.red_dot);
            this.d.setVisibility(8);
            if (TiebaApplication.v().equals(stringExtra) && !com.baidu.tieba.sharedPref.b.a().a("has_shown_group_btn_dot", false)) {
                this.d.setVisibility(0);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimension = (int) cyVar.getResources().getDimension(R.dimen.navi_btn_margin_right);
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, dimension, dimension, 0);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public final void P() {
        this.d.setVisibility(8);
        com.baidu.tieba.sharedPref.b.a().b("has_shown_group_btn_dot", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public final void a(cy cyVar) {
        super.a(cyVar);
        if (this.j == 0) {
            this.e.setFrom(3);
        } else {
            this.e.setFrom(2);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void b(cy cyVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {cyVar.getString(R.string.operate_copy), cyVar.getString(R.string.msg_at), cyVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {cyVar.getString(R.string.operate_copy), cyVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
            builder.setTitle(cyVar.getString(R.string.operation));
            if (this.j == 0) {
                builder.setItems(charSequenceArr, cyVar);
            } else {
                builder.setItems(charSequenceArr2, cyVar);
            }
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void c(cy cyVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {cyVar.getString(R.string.msg_at), cyVar.getString(R.string.msg_img_save), cyVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {cyVar.getString(R.string.msg_img_save), cyVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
            builder.setTitle(cyVar.getString(R.string.operation));
            if (this.j == 0) {
                builder.setItems(charSequenceArr, cyVar);
            } else {
                builder.setItems(charSequenceArr2, cyVar);
            }
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void d(cy cyVar) {
        if (this.h != null) {
            this.h = null;
        }
        boolean ab = TiebaApplication.g().ab();
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = ab ? cyVar.getString(R.string.group_close_receiver) : cyVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = cyVar.getString(R.string.msg_at);
        charSequenceArr[2] = cyVar.getString(R.string.msg_delete);
        CharSequence[] charSequenceArr2 = new CharSequence[2];
        charSequenceArr2[0] = ab ? cyVar.getString(R.string.group_close_receiver) : cyVar.getString(R.string.group_open_receiver);
        charSequenceArr2[1] = cyVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
        builder.setTitle(cyVar.getString(R.string.operation));
        if (this.j == 0) {
            builder.setItems(charSequenceArr, cyVar);
        } else {
            builder.setItems(charSequenceArr2, cyVar);
        }
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    @Override // com.baidu.tieba.im.chat.a
    protected final void e(cy cyVar) {
        if (this.i == null) {
            CharSequence[] charSequenceArr = {cyVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cyVar);
            builder.setTitle(cyVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, cyVar);
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }
}
