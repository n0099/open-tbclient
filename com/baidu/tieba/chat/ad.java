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
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.am;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.tieba.view.aq;
import com.baidu.tieba.view.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.a.d {
    private ChatActivity b;
    private ImageView c;
    private Button d;
    private Button e;
    private TextView f;
    private BdListView g;
    private ProgressBar h;
    private ClickableLayout4Frame i;
    private EditText j;
    private Dialog k;
    private Dialog l;
    private j m;
    private bb n;
    private KeyboardEventLayout o;
    private LinearLayout p;
    private Button q;
    private TextWatcher r;

    public ad(Context context) {
        super(context);
        this.b = null;
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
        this.r = new ae(this);
        if (context instanceof ChatActivity) {
            this.b = (ChatActivity) context;
            this.o = (KeyboardEventLayout) LayoutInflater.from(this.b).inflate(R.layout.chat_activity, (ViewGroup) null);
            this.b.addContentView(this.o, new FrameLayout.LayoutParams(-2, -2));
            this.p = (LinearLayout) this.o.findViewById(R.id.title);
            this.c = (ImageView) this.o.findViewById(R.id.back);
            this.f = (TextView) this.o.findViewById(R.id.name);
            this.e = (Button) this.o.findViewById(R.id.more);
            this.g = (BdListView) this.o.findViewById(R.id.chat_list);
            this.h = (ProgressBar) this.o.findViewById(R.id.progress);
            this.i = (ClickableLayout4Frame) this.o.findViewById(R.id.chat_center);
            this.d = (Button) this.o.findViewById(R.id.chat_post);
            this.j = (EditText) this.o.findViewById(R.id.reply_content);
            this.j.setHint("");
            this.c.setOnClickListener(this.b);
            this.f.setOnClickListener(this.b);
            this.e.setOnClickListener(this.b);
            this.d.setOnClickListener(this.b);
            this.j.addTextChangedListener(this.r);
            this.n = new bb(this.b);
            this.g.setPullRefresh(this.n);
            this.m = new j(this.b);
            this.g.setAdapter((ListAdapter) this.m);
            this.i.setOnkeyUpListener(new af(this));
        }
    }

    public View b() {
        return this.c;
    }

    public View c() {
        return this.e;
    }

    public View d() {
        return this.d;
    }

    public int e() {
        return R.id.photo;
    }

    public View f() {
        return this.q;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.n.a(bVar);
    }

    public void g() {
        this.j.setText("");
    }

    public void h() {
        int count = this.g.getAdapter().getCount();
        this.m.notifyDataSetChanged();
        this.g.setSelection(count - 1);
    }

    public void i() {
        this.j.clearFocus();
    }

    public boolean j() {
        return this.g.getLastVisiblePosition() >= this.g.getAdapter().getCount() + (-1);
    }

    public String k() {
        if (this.j.getText() != null) {
            return this.j.getText().toString();
        }
        return null;
    }

    public void l() {
        this.h.setVisibility(0);
    }

    public void m() {
        this.h.setVisibility(8);
        this.g.a();
    }

    public void a(com.baidu.tieba.data.a.c cVar) {
        String g;
        this.h.setVisibility(8);
        this.g.a();
        if (cVar != null && (g = cVar.g()) != null) {
            this.f.setText(g);
        }
        this.m.a(cVar);
        this.m.notifyDataSetChanged();
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setTitle(R.string.operation);
            builder.setItems(new String[]{this.b.getString(R.string.copy)}, onClickListener);
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        this.k.show();
    }

    public void n() {
        if (this.l == null) {
            this.l = new Dialog(this.b, R.style.common_alert_dialog);
            this.l.setCanceledOnTouchOutside(true);
            this.l.setCancelable(true);
            View inflate = this.b.getLayoutInflater().inflate(R.layout.chat_more_layout, (ViewGroup) null);
            this.l.setContentView(inflate);
            this.q = (Button) inflate.findViewById(R.id.delete_chat);
            this.q.setOnClickListener(this.b);
            WindowManager.LayoutParams attributes = this.l.getWindow().getAttributes();
            attributes.width = (int) (am.a((Context) this.b) * 0.9d);
            this.l.getWindow().setAttributes(attributes);
        }
        this.l.show();
    }

    public void o() {
        this.l.dismiss();
    }

    public void p() {
        am.a(this.b, this.j);
    }

    public void a(int i) {
        ah.a(this.c, i);
        ah.g((TextView) this.e, i);
        ah.d(this.p, i);
        this.m.a(i);
        this.m.notifyDataSetChanged();
        this.n.a(i);
        if (i == 1) {
            this.i.setBackgroundResource(R.drawable.chat_bg_1);
            ah.h((View) this.d, (int) R.drawable.btn_post_dl_selector_1);
            this.d.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color_1));
            return;
        }
        this.i.setBackgroundResource(R.drawable.chat_bg);
        ah.h((View) this.d, (int) R.drawable.btn_post_dl_selector);
        this.d.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    public void q() {
        if (this.k != null) {
            this.k.dismiss();
        }
        if (this.l != null) {
            this.l.dismiss();
        }
        r();
    }

    public void b(int i) {
        this.g.setSelection(i - ((com.baidu.adp.widget.ListView.e) this.g.getAdapter()).c());
    }

    public void a(aq aqVar) {
        this.o.setOnKeyStateChangedListener(aqVar);
    }

    public void a(String str, String str2) {
        com.baidu.tieba.util.a a2 = this.m.a();
        a(a2, str);
        a(a2, str2);
    }

    private void a(com.baidu.tieba.util.a aVar, String str) {
        if (aVar != null && str != null) {
            aVar.b(str, new ag(this));
        }
    }

    public void r() {
    }

    public ListView s() {
        return this.g;
    }

    public int t() {
        return R.id.text;
    }
}
