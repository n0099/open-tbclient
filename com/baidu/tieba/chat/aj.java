package com.baidu.tieba.chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.ap;
import com.baidu.tieba.view.bk;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private ChatActivity f1178a;
    private ImageView c;
    private Button d;
    private TextView e;
    private TextView f;
    private BdListView g;
    private ProgressBar h;
    private ClickableLayout4Frame i;
    private EditText j;
    private Dialog k;
    private Dialog l;
    private j m;
    private bk n;
    private KeyboardEventLayout o;
    private LinearLayout p;
    private Button q;
    private NavigationBar r;
    private TextWatcher s;

    public aj(Context context) {
        super(context);
        this.f1178a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = new al(this);
        if (context instanceof ChatActivity) {
            this.f1178a = (ChatActivity) context;
            this.o = (KeyboardEventLayout) LayoutInflater.from(this.f1178a).inflate(R.layout.chat_activity, (ViewGroup) null);
            this.f1178a.addContentView(this.o, new FrameLayout.LayoutParams(-1, -1));
            this.r = (NavigationBar) this.o.findViewById(R.id.navigation_bar);
            this.c = this.r.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.f1178a);
            this.f = this.r.a("");
            this.e = this.r.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f1178a.getString(R.string.more), this.f1178a);
            this.g = (BdListView) this.o.findViewById(R.id.chat_list);
            this.h = (ProgressBar) this.o.findViewById(R.id.progress);
            this.i = (ClickableLayout4Frame) this.o.findViewById(R.id.chat_center);
            this.d = (Button) this.o.findViewById(R.id.chat_post);
            this.j = (EditText) this.o.findViewById(R.id.reply_content);
            this.j.setHint("");
            this.f.setOnClickListener(this.f1178a);
            this.e.setOnClickListener(this.f1178a);
            this.d.setOnClickListener(this.f1178a);
            this.j.addTextChangedListener(this.s);
            this.n = new bk(this.f1178a);
            this.g.setPullRefresh(this.n);
            this.m = new j(this.f1178a);
            this.g.setAdapter((ListAdapter) this.m);
            this.i.setOnkeyUpListener(new ak(this));
        }
    }

    public View a() {
        return this.c;
    }

    public View e() {
        return this.e;
    }

    public View f() {
        return this.d;
    }

    public int g() {
        return R.id.photo;
    }

    public View h() {
        return this.q;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.n.a(bVar);
    }

    public void i() {
        this.j.setText("");
    }

    public void j() {
        int count = this.g.getAdapter().getCount();
        this.m.notifyDataSetChanged();
        this.g.setSelection(count - 1);
    }

    public void k() {
        this.j.clearFocus();
    }

    public boolean l() {
        return this.g.getLastVisiblePosition() >= this.g.getAdapter().getCount() + (-1);
    }

    public String m() {
        if (this.j.getText() != null) {
            return this.j.getText().toString();
        }
        return null;
    }

    public void n() {
        this.h.setVisibility(0);
    }

    public void o() {
        this.h.setVisibility(8);
        this.g.a();
    }

    public void a(ChatData chatData) {
        String friendName;
        this.h.setVisibility(8);
        this.g.a();
        if (chatData != null && (friendName = chatData.getFriendName()) != null) {
            this.f.setText(friendName);
        }
        this.m.a(chatData);
        this.m.notifyDataSetChanged();
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1178a);
            builder.setTitle(R.string.operation);
            builder.setItems(new String[]{this.f1178a.getString(R.string.copy)}, onClickListener);
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        this.k.show();
    }

    public void p() {
        if (this.l == null) {
            this.l = new Dialog(this.f1178a, R.style.common_alert_dialog);
            this.l.setCanceledOnTouchOutside(true);
            this.l.setCancelable(true);
            View inflate = this.f1178a.getLayoutInflater().inflate(R.layout.chat_more_layout, (ViewGroup) null);
            this.l.setContentView(inflate);
            this.q = (Button) inflate.findViewById(R.id.delete_chat);
            this.q.setOnClickListener(this.f1178a);
            WindowManager.LayoutParams attributes = this.l.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.h.g.b(this.f1178a) * 0.9d);
            this.l.getWindow().setAttributes(attributes);
        }
        this.l.show();
    }

    public void q() {
        this.l.dismiss();
    }

    public void r() {
        com.baidu.adp.lib.h.g.a(this.f1178a, this.j);
    }

    public void a(int i) {
        ba.a(this.c, i);
        ba.f(this.e, i);
        ba.d(this.p, i);
        this.m.a(i);
        this.m.notifyDataSetChanged();
        this.n.a(i);
        if (i == 1) {
            this.i.setBackgroundResource(R.drawable.chat_bg_1);
            ba.e((View) this.d, (int) R.drawable.btn_post_dl_selector_1);
            this.d.setTextColor(this.f1178a.getResources().getColorStateList(R.color.post_image_btn_color_1));
        } else {
            this.i.setBackgroundResource(R.drawable.chat_bg);
            ba.e((View) this.d, (int) R.drawable.btn_post_dl_selector);
            this.d.setTextColor(this.f1178a.getResources().getColorStateList(R.color.post_image_btn_color));
        }
        this.r.c(i);
    }

    public void s() {
        if (this.k != null) {
            this.k.dismiss();
        }
        if (this.l != null) {
            this.l.dismiss();
        }
        t();
    }

    public void b(int i) {
        this.g.setSelection(i - ((com.baidu.adp.widget.ListView.e) this.g.getAdapter()).c());
    }

    public void a(ap apVar) {
        this.o.setOnKeyStateChangedListener(apVar);
    }

    public void a(String str, String str2) {
        com.baidu.tieba.util.i a2 = this.m.a();
        a(a2, str);
        a(a2, str2);
    }

    private void a(com.baidu.tieba.util.i iVar, String str) {
        if (iVar != null && str != null) {
            iVar.b(str, new am(this));
        }
    }

    public void t() {
    }

    public ListView u() {
        return this.g;
    }

    public int v() {
        return R.id.text;
    }
}
