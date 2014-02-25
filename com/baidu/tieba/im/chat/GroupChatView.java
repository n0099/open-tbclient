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
    public void a(cz czVar, boolean z) {
        String str;
        super.a(czVar, z);
        if (this.j == 0) {
            str = czVar.getString(R.string.msglist_groupinfo);
        } else if (this.j != 1) {
            str = null;
        } else {
            str = czVar.getString(R.string.msglist_personInfo);
        }
        if (str != null) {
            String stringExtra = czVar.getIntent().getStringExtra("group_author_id");
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, czVar);
            this.k = (TextView) this.c.findViewById(R.id.group_info_btn_txt);
            this.k.setText(str);
            this.d = (ImageView) this.c.findViewById(R.id.red_dot);
            this.d.setVisibility(8);
            if (TiebaApplication.A().equals(stringExtra)) {
                R();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimension = (int) czVar.getResources().getDimension(R.dimen.navi_btn_margin_right);
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, dimension, dimension, 0);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void R() {
        if (!com.baidu.tieba.sharedPref.b.a().a("has_shown_group_btn_dot", false)) {
            this.d.setVisibility(0);
        }
    }

    public void S() {
        this.d.setVisibility(8);
        com.baidu.tieba.sharedPref.b.a().b("has_shown_group_btn_dot", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public void a(cz czVar) {
        super.a(czVar);
        if (this.j == 0) {
            this.e.setFrom(3);
        } else {
            this.e.setFrom(2);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void b(cz czVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {czVar.getString(R.string.operate_copy), czVar.getString(R.string.msg_at), czVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {czVar.getString(R.string.operate_copy), czVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
            builder.setTitle(czVar.getString(R.string.operation));
            if (this.j == 0) {
                builder.setItems(charSequenceArr, czVar);
            } else {
                builder.setItems(charSequenceArr2, czVar);
            }
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void c(cz czVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {czVar.getString(R.string.msg_at), czVar.getString(R.string.msg_img_save), czVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {czVar.getString(R.string.msg_img_save), czVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
            builder.setTitle(czVar.getString(R.string.operation));
            if (this.j == 0) {
                builder.setItems(charSequenceArr, czVar);
            } else {
                builder.setItems(charSequenceArr2, czVar);
            }
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void d(cz czVar) {
        if (this.h != null) {
            this.h = null;
        }
        boolean ai = TiebaApplication.g().ai();
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = ai ? czVar.getString(R.string.group_close_receiver) : czVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = czVar.getString(R.string.msg_at);
        charSequenceArr[2] = czVar.getString(R.string.msg_delete);
        CharSequence[] charSequenceArr2 = new CharSequence[2];
        charSequenceArr2[0] = ai ? czVar.getString(R.string.group_close_receiver) : czVar.getString(R.string.group_open_receiver);
        charSequenceArr2[1] = czVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
        builder.setTitle(czVar.getString(R.string.operation));
        if (this.j == 0) {
            builder.setItems(charSequenceArr, czVar);
        } else {
            builder.setItems(charSequenceArr2, czVar);
        }
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void e(cz czVar) {
        if (this.i == null) {
            CharSequence[] charSequenceArr = {czVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(czVar);
            builder.setTitle(czVar.getString(R.string.operation));
            builder.setItems(charSequenceArr, czVar);
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }
}
