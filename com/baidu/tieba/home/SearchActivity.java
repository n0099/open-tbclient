package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.e {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private Button f = null;
    private LinearLayout g = null;
    private LinearLayout h = null;
    private FrameLayout i = null;
    private FrameLayout j = null;
    private ListView k = null;
    private au l = null;
    private ListView m = null;
    private au n = null;
    private aw o = null;
    private ProgressBar p = null;
    private Button q = null;
    private View r = null;
    private TextView s = null;
    private com.baidu.tieba.b.x t = null;
    private com.baidu.tieba.a.ar u = null;
    private at v = null;
    private as w = null;
    private String x = null;
    private AlertDialog y = null;
    private View z = null;
    private az A = null;
    private ImageView B = null;
    private ListView C = null;
    private int D = 0;
    private Handler E = new Handler();
    private Runnable F = new ae(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        j();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.y != null) {
            this.y.dismiss();
        }
        if (this.D == 0) {
            TiebaApplication.b().b(true);
        } else {
            TiebaApplication.b().b(false);
        }
        k();
        i();
    }

    public void i() {
        this.E.removeCallbacks(this.F);
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
    }

    public void j() {
        this.r = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.s = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new ah(this));
        this.g = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.h = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.i = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new ai(this));
        aj ajVar = new aj(this);
        this.f = (Button) findViewById(R.id.home_bt_search_sel);
        this.f.setOnClickListener(new ak(this));
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(ajVar);
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new am(this));
        this.c.addTextChangedListener(new an(this));
        this.j = (FrameLayout) findViewById(R.id.home_search_list);
        this.k = (ListView) findViewById(R.id.home_lv_search);
        this.q = (Button) this.r.findViewById(R.id.home_bt_search_footer);
        this.q.setOnClickListener(new ao(this));
        this.k.addFooterView(this.r, null, true);
        this.l = new au(this, null);
        this.k.setAdapter((ListAdapter) this.l);
        this.k.setOnItemClickListener(new ar(this));
        this.m = (ListView) findViewById(R.id.home_lv_suggest);
        this.n = new au(this, null);
        this.o = new aw(this);
        this.m.setAdapter((ListAdapter) this.n);
        this.m.setOnItemClickListener(new af(this));
        ag agVar = new ag(this);
        this.m.setOnScrollListener(agVar);
        this.k.setOnScrollListener(agVar);
        this.p = (ProgressBar) findViewById(R.id.home_progress_search);
        this.p.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        n();
        a(this.c, WebChromeClient.STRING_DLG_BTN_SET);
        if (TiebaApplication.b().k()) {
            c(0);
        } else {
            c(1);
        }
    }

    public void k() {
        if (this.p != null) {
            this.p.setVisibility(8);
        }
        if (this.o != null) {
            this.o.a();
        }
    }

    public void c(int i) {
        switch (i) {
            case 0:
                if (this.D != 0) {
                    this.D = 0;
                    this.f.setText(getString(R.string.enter_forum));
                    this.c.setHint(R.string.search_bar);
                    i();
                    if (this.x.trim().length() > 0) {
                        o();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                return;
            case 1:
                if (this.D != 1) {
                    this.D = 1;
                    this.f.setText(getString(R.string.search_post));
                    this.c.setHint(R.string.search_post_hint);
                    i();
                    if (this.x.trim().length() > 0) {
                        this.m.setVisibility(8);
                        a(1, this.x);
                        return;
                    }
                    p();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void l() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            m();
        }
    }

    public void m() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.m.setVisibility(8);
        ArrayList n = com.baidu.tieba.c.k.n();
        if (n != null && n.size() > 0) {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.m.setVisibility(8);
            this.s.setVisibility(8);
            this.l.a(n);
            this.l.a(true);
            this.l.notifyDataSetInvalidated();
            return;
        }
        this.j.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.j.setVisibility(8);
        this.E.removeCallbacks(this.F);
        this.E.postDelayed(this.F, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.k.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append("http://c.tieba.baidu.com/");
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    i();
                    this.w = new as(this, stringBuffer.toString(), arrayList);
                    this.w.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.m.setVisibility(8);
        ArrayList o = com.baidu.tieba.c.k.o();
        if (o != null && o.size() > 0) {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.m.setVisibility(8);
            this.s.setVisibility(8);
            this.l.a(o);
            this.l.a(false);
            this.l.notifyDataSetInvalidated();
            return;
        }
        this.j.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (this.D == 0) {
                if (this.t != null) {
                    ArrayList a = this.t.a();
                    if (a != null && a.size() > 0) {
                        this.j.setVisibility(0);
                        this.k.setVisibility(8);
                        this.m.setVisibility(0);
                        this.m.setAdapter((ListAdapter) this.n);
                        this.n.a(a);
                        this.n.notifyDataSetInvalidated();
                    } else {
                        this.j.setVisibility(8);
                        this.s.setVisibility(0);
                        this.s.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.u != null) {
                ArrayList a2 = this.u.a();
                if (a2 != null && a2.size() > 0) {
                    this.j.setVisibility(0);
                    this.k.setVisibility(8);
                    this.m.setVisibility(0);
                    this.m.setAdapter((ListAdapter) this.o);
                    this.o.a(this.u);
                    this.o.notifyDataSetInvalidated();
                    if (this.u.c()) {
                        this.m.setSelection(1);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.s.setVisibility(0);
                    this.s.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.e
    protected void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.b(this.k, i);
        com.baidu.tieba.c.ae.b(this.m, i);
        com.baidu.tieba.c.ae.a(this.i, i);
        com.baidu.tieba.c.ae.a(this.r, i);
        if (i == 1) {
            this.c.setTextColor(getResources().getColor(R.color.skin_1_common_bg));
            this.e.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.q.setTextColor(getResources().getColor(R.color.search_text_content_night));
            com.baidu.tieba.c.ae.h(this.h, R.drawable.search_tap_1);
            com.baidu.tieba.c.ae.h(this.e, R.drawable.search_tap_go_dr_1);
            com.baidu.tieba.c.ae.h(this.q, R.drawable.search_tap_go_dr_1);
            com.baidu.tieba.c.ae.h(this.g, R.drawable.search_tap_text_1);
            com.baidu.tieba.c.ae.h(this.f, R.drawable.search_tap_sel_dr_1);
            return;
        }
        this.c.setTextColor(getResources().getColor(R.color.search_text_content));
        this.e.setTextColor(getResources().getColor(R.color.reg_font_color));
        this.q.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.c.ae.h(this.q, R.drawable.search_tap_go_dr);
        com.baidu.tieba.c.ae.h(this.g, R.drawable.search_tap_text);
        com.baidu.tieba.c.ae.h(this.h, R.drawable.search_tap);
        com.baidu.tieba.c.ae.h(this.e, R.drawable.search_tap_go_dr);
        com.baidu.tieba.c.ae.h(this.f, R.drawable.search_tap_sel_dr);
    }
}
