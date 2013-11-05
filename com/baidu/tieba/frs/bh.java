package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private BdSwitchView f1277a;
    private View c;
    private LinearLayout d;
    private LinearLayout e;
    private Button f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private TextView m;
    private LinearLayout n;
    private AlertDialog o;
    private View.OnClickListener p;
    private boolean q;
    private final DialogInterface.OnClickListener r;

    public bh(Context context) {
        super(context);
        this.f1277a = null;
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
        this.r = new bi(this);
        k();
    }

    public View a() {
        return this.c;
    }

    public void e() {
        i();
        j();
    }

    private void k() {
        this.c = LayoutInflater.from(this.b).inflate(R.layout.frs_sidebar, (ViewGroup) null);
        this.m = (TextView) this.c.findViewById(R.id.abstract_state_tip);
        this.n = (LinearLayout) this.c.findViewById(R.id.abstract_selection);
        this.f1277a = (BdSwitchView) this.c.findViewById(R.id.eyeshield_mode_switch);
        this.f1277a.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.b);
        this.f1277a.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.f = (Button) this.c.findViewById(R.id.message_btn);
        this.d = (LinearLayout) this.c.findViewById(R.id.message_layout);
        this.g = (LinearLayout) this.c.findViewById(R.id.like_forum_layout);
        this.e = (LinearLayout) this.c.findViewById(R.id.inform_title_layout);
        this.h = (LinearLayout) this.c.findViewById(R.id.add_to_window_layout);
        this.j = (LinearLayout) this.c.findViewById(R.id.show_all);
        this.k = (LinearLayout) this.c.findViewById(R.id.show_good);
        this.l = (LinearLayout) this.c.findViewById(R.id.show_image);
    }

    public void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public void a(int i) {
        this.i = (LinearLayout) this.c.findViewById(i);
        if (this.i != null) {
            if (this.i == this.j) {
                this.j.setSelected(true);
                this.k.setSelected(false);
                this.l.setSelected(false);
            } else if (this.i == this.k) {
                this.j.setSelected(false);
                this.k.setSelected(true);
                this.l.setSelected(false);
            } else if (this.i == this.l) {
                this.j.setSelected(false);
                this.k.setSelected(false);
                this.l.setSelected(true);
            }
        }
    }

    public BdSwitchView f() {
        return this.f1277a;
    }

    public void g() {
        l();
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
        this.q = false;
    }

    private void l() {
        if (this.o == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.b.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.b.getString(R.string.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.b.getString(R.string.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.b.getString(R.string.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
            this.o = new AlertDialog.Builder(this.b).setTitle(R.string.flow_mode_title).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3}, this.r).create();
        }
    }

    public boolean h() {
        return this.q;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public void i() {
        switch (TiebaApplication.g().aq()) {
            case 0:
                this.m.setText(this.b.getString(R.string.is_2g3gopen));
                return;
            case 1:
                this.m.setText(this.b.getString(R.string.is_close));
                return;
            case 2:
                this.m.setText(this.b.getString(R.string.is_alwaysopen));
                return;
            default:
                return;
        }
    }

    public void j() {
        if (TiebaApplication.g().as() == 1) {
            this.f1277a.a();
        } else {
            this.f1277a.b();
        }
    }

    public void a(com.baidu.tieba.model.ap apVar) {
        long a2 = apVar.a() + apVar.b();
        if (a2 > 0) {
            this.f.setVisibility(0);
            this.f.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.f.setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.p = onClickListener;
        this.n.setOnClickListener(this.p);
        this.d.setOnClickListener(this.p);
        this.h.setOnClickListener(this.p);
        this.j.setOnClickListener(this.p);
        this.k.setOnClickListener(this.p);
        this.l.setOnClickListener(this.p);
    }

    public void a(boolean z, String str) {
    }

    public void a(com.baidu.tieba.data.u uVar) {
        if (uVar != null) {
            this.g.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.b);
            ArrayList<com.baidu.tieba.data.t> c = uVar.c();
            int size = c.size();
            int i = size > 10 ? 10 : size;
            int as = TiebaApplication.g().as();
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.frs_sidebar_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.like_forum_name);
                ((com.baidu.tieba.j) this.b).m().a(as == 1);
                ((com.baidu.tieba.j) this.b).m().a(linearLayout);
                String a2 = c.get(i2).a();
                textView.setText(a2);
                textView.setTag(a2);
                textView.setOnClickListener(this.p);
                this.g.addView(linearLayout);
            }
        }
    }

    public void b(int i) {
        ((com.baidu.tieba.j) this.b).m().a(i == 1);
        ((com.baidu.tieba.j) this.b).m().a(this.c);
    }
}
