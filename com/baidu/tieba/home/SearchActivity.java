package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.c.bq;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.e {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private FrameLayout h = null;
    private LinearLayout i = null;
    private RadioButton j = null;
    private RadioButton k = null;
    private Button l = null;
    private FrameLayout m = null;
    private ListView n = null;
    private ap o = null;
    private ListView p = null;
    private ap q = null;
    private ar r = null;
    private ProgressBar s = null;
    private Button t = null;
    private View u = null;
    private TextView v = null;
    private bq w = null;
    private aw x = null;
    private ao y = null;
    private an z = null;
    private String A = null;
    private int B = 0;
    private Handler C = new Handler();
    private Runnable D = new y(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        c();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.B == 0) {
            TiebaApplication.d().b(true);
        } else {
            TiebaApplication.d().b(false);
        }
        d();
        b();
    }

    public void b() {
        this.C.removeCallbacks(this.D);
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        if (this.z != null) {
            this.z.cancel();
            this.z = null;
        }
    }

    public void c() {
        this.u = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.v = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new af(this));
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.h = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new ag(this));
        ah ahVar = new ah(this);
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(ahVar);
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new ai(this));
        this.c.addTextChangedListener(new aj(this));
        this.i = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.j = (RadioButton) findViewById(R.id.search_forum_btn);
        this.k = (RadioButton) findViewById(R.id.search_post_btn);
        this.l = (Button) findViewById(R.id.search_in_baidu_btn);
        this.j.setOnCheckedChangeListener(new ak(this));
        this.k.setOnCheckedChangeListener(new al(this));
        this.l.setOnClickListener(new am(this));
        this.m = (FrameLayout) findViewById(R.id.home_search_list);
        this.n = (ListView) findViewById(R.id.home_lv_search);
        this.t = (Button) this.u.findViewById(R.id.home_bt_search_footer);
        this.t.setOnClickListener(new z(this));
        this.n.addFooterView(this.u, null, true);
        this.o = new ap(this, null);
        this.n.setAdapter((ListAdapter) this.o);
        this.n.setOnItemClickListener(new ac(this));
        this.p = (ListView) findViewById(R.id.home_lv_suggest);
        this.q = new ap(this, null);
        this.r = new ar(this);
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOnItemClickListener(new ad(this));
        ae aeVar = new ae(this);
        this.p.setOnScrollListener(aeVar);
        this.n.setOnScrollListener(aeVar);
        this.s = (ProgressBar) findViewById(R.id.home_progress_search);
        this.s.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        o();
        a(this.c, WebChromeClient.STRING_DLG_BTN_SET);
        if (TiebaApplication.d().n()) {
            this.j.setChecked(true);
            c(0);
            return;
        }
        this.k.setChecked(true);
        c(1);
    }

    public void d() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
        if (this.r != null) {
            this.r.a();
        }
    }

    public void c(int i) {
        switch (i) {
            case 0:
                if (this.B != 0) {
                    this.B = 0;
                    this.c.setHint(R.string.search_bar);
                    b();
                    if (this.A.trim().length() > 0) {
                        p();
                        return;
                    } else {
                        o();
                        return;
                    }
                }
                return;
            case 1:
                if (this.B != 1) {
                    this.B = 1;
                    this.c.setHint(R.string.search_post_hint);
                    b();
                    if (this.A.trim().length() > 0) {
                        this.p.setVisibility(8);
                        a(1, this.A);
                        return;
                    }
                    q();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void m() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            n();
        }
    }

    public void n() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.p.setVisibility(8);
        ArrayList o = com.baidu.tieba.d.k.o();
        if (o != null && o.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.v.setVisibility(8);
            this.o.a(o);
            this.o.a(true);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.v.setVisibility(0);
        this.v.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.m.setVisibility(8);
        this.C.removeCallbacks(this.D);
        this.C.postDelayed(this.D, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.n.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.a.i.e);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.z = new an(this, stringBuffer.toString(), arrayList);
                    this.z.setPriority(3);
                    this.z.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.p.setVisibility(8);
        ArrayList p = com.baidu.tieba.d.k.p();
        if (p != null && p.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.v.setVisibility(8);
            this.o.a(p);
            this.o.a(false);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.v.setVisibility(0);
        this.v.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            if (this.B == 0) {
                if (this.w != null) {
                    ArrayList a = this.w.a();
                    if (a != null && a.size() > 0) {
                        this.m.setVisibility(0);
                        this.n.setVisibility(8);
                        this.p.setVisibility(0);
                        this.p.setAdapter((ListAdapter) this.q);
                        this.q.a(a);
                        this.q.notifyDataSetInvalidated();
                    } else {
                        this.m.setVisibility(8);
                        this.v.setVisibility(0);
                        this.v.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.x != null) {
                ArrayList a2 = this.x.a();
                if (a2 != null && a2.size() > 0) {
                    this.m.setVisibility(0);
                    this.n.setVisibility(8);
                    this.p.setVisibility(0);
                    this.p.setAdapter((ListAdapter) this.r);
                    this.r.a(this.x);
                    this.r.notifyDataSetInvalidated();
                    if (this.x.c()) {
                        this.p.setSelection(1);
                    }
                } else {
                    this.m.setVisibility(8);
                    this.v.setVisibility(0);
                    this.v.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.e
    protected void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.b(this.n, i);
        com.baidu.tieba.d.ac.b(this.p, i);
        com.baidu.tieba.d.ac.a(this.h, i);
        if (i == 1) {
            this.c.setTextColor(-8682095);
            this.c.setHintTextColor(-11446171);
            this.e.setTextColor(-5454368);
            this.t.setTextColor(getResources().getColor(R.color.search_text_content_night));
            com.baidu.tieba.d.ac.h(this.g, (int) R.drawable.inputbox_topbg_1);
            com.baidu.tieba.d.ac.h((View) this.e, (int) R.drawable.search_tap_go_dr_1);
            com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.btn_w_square_1);
            com.baidu.tieba.d.ac.h(this.f, (int) R.drawable.inputbox_top_1);
            com.baidu.tieba.d.ac.h(this.i, (int) R.drawable.tabbar_bj_tab_1);
            com.baidu.tieba.d.ac.h((View) this.l, (int) R.drawable.search_baidu_btn_drawable_1);
            com.baidu.tieba.d.ac.h((View) this.j, (int) R.drawable.search_forum_btn_drawable_1);
            com.baidu.tieba.d.ac.h((View) this.k, (int) R.drawable.search_post_btn_drawable_1);
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.v.setTextColor(-11446171);
            this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_blank_page_search_1, 0, 0);
            return;
        }
        this.c.setTextColor(getResources().getColor(R.color.search_text_content));
        this.c.setHintTextColor(-5921112);
        this.e.setTextColor(-1);
        this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.btn_w_square);
        com.baidu.tieba.d.ac.h(this.f, (int) R.drawable.inputbox_top);
        com.baidu.tieba.d.ac.h(this.g, (int) R.drawable.inputbox_topbg);
        com.baidu.tieba.d.ac.h((View) this.e, (int) R.drawable.search_tap_go_dr);
        com.baidu.tieba.d.ac.h(this.i, (int) R.drawable.tabbar_bj_tab);
        com.baidu.tieba.d.ac.h((View) this.l, (int) R.drawable.search_baidu_btn_drawable);
        com.baidu.tieba.d.ac.h((View) this.j, (int) R.drawable.search_forum_btn_drawable);
        com.baidu.tieba.d.ac.h((View) this.k, (int) R.drawable.search_post_btn_drawable);
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.v.setTextColor(-3618616);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_blank_page_search, 0, 0);
    }

    @Override // com.baidu.tieba.e
    protected void k() {
        super.k();
        a_(-1);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
