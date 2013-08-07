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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.bz;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private EditText f1108a = null;
    private Button b = null;
    private Button c = null;
    private LinearLayout d = null;
    private LinearLayout e = null;
    private FrameLayout f = null;
    private LinearLayout g = null;
    private RadioButton j = null;
    private RadioButton k = null;
    private Button l = null;
    private FrameLayout m = null;
    private ListView n = null;
    private az o = null;
    private ListView p = null;
    private az q = null;
    private bb r = null;
    private ProgressBar s = null;
    private Button t = null;
    private View u = null;
    private TextView v = null;
    private bz w = null;
    private com.baidu.tieba.data.bd x = null;
    private ay y = null;
    private ax z = null;
    private String A = null;
    private int B = 0;
    private Handler C = new Handler();
    private Runnable D = new ai(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        c();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.B == 0) {
            TiebaApplication.f().b(true);
        } else {
            TiebaApplication.f().b(false);
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
        this.f1108a = (EditText) findViewById(R.id.home_et_search);
        this.f1108a.setOnFocusChangeListener(new ap(this));
        this.d = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.e = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.f = (FrameLayout) findViewById(R.id.frame_layout);
        this.f1108a.setOnEditorActionListener(new aq(this));
        ar arVar = new ar(this);
        this.c = (Button) findViewById(R.id.home_bt_search_s);
        this.c.setOnClickListener(arVar);
        this.b = (Button) findViewById(R.id.home_bt_search_del);
        this.b.setOnClickListener(new as(this));
        this.f1108a.addTextChangedListener(new at(this));
        this.g = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.j = (RadioButton) findViewById(R.id.search_forum_btn);
        this.k = (RadioButton) findViewById(R.id.search_post_btn);
        this.l = (Button) findViewById(R.id.search_in_baidu_btn);
        this.j.setOnCheckedChangeListener(new au(this));
        this.k.setOnCheckedChangeListener(new av(this));
        this.l.setOnClickListener(new aw(this));
        this.m = (FrameLayout) findViewById(R.id.home_search_list);
        this.n = (ListView) findViewById(R.id.home_lv_search);
        this.t = (Button) this.u.findViewById(R.id.home_bt_search_footer);
        this.t.setOnClickListener(new aj(this));
        this.n.addFooterView(this.u, null, true);
        this.o = new az(this, null);
        this.n.setAdapter((ListAdapter) this.o);
        this.n.setOnItemClickListener(new am(this));
        this.p = (ListView) findViewById(R.id.home_lv_suggest);
        this.q = new az(this, null);
        this.r = new bb(this);
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOnItemClickListener(new an(this));
        ao aoVar = new ao(this);
        this.p.setOnScrollListener(aoVar);
        this.n.setOnScrollListener(aoVar);
        this.s = (ProgressBar) findViewById(R.id.home_progress_search);
        this.s.setVisibility(8);
        this.f1108a.setText("");
        this.f1108a.requestFocus();
        m();
        a(this.f1108a, WebChromeClient.STRING_DLG_BTN_SET);
        if (TiebaApplication.f().s()) {
            this.j.setChecked(true);
            b(0);
            return;
        }
        this.k.setChecked(true);
        b(1);
    }

    public void d() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
        if (this.r != null) {
            this.r.a();
        }
    }

    public void b(int i) {
        switch (i) {
            case 0:
                if (this.B != 0) {
                    this.B = 0;
                    this.f1108a.setHint(R.string.search_bar);
                    b();
                    if (this.A.trim().length() > 0) {
                        n();
                        return;
                    } else {
                        m();
                        return;
                    }
                }
                return;
            case 1:
                if (this.B != 1) {
                    this.B = 1;
                    this.f1108a.setHint(R.string.search_post_hint);
                    b();
                    if (this.A.trim().length() > 0) {
                        this.p.setVisibility(8);
                        a(1, this.A);
                        return;
                    }
                    o();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void k() {
        String trim = this.f1108a.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            l();
        }
    }

    public void l() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.p.setVisibility(8);
        ArrayList q = DatabaseService.q();
        if (q != null && q.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.v.setVisibility(8);
            this.o.a(q);
            this.o.a(true);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.v.setVisibility(0);
        this.v.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
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
                    stringBuffer.append(com.baidu.tieba.data.g.f1011a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.z = new ax(this, stringBuffer.toString(), arrayList);
                    this.z.setPriority(3);
                    this.z.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.p.setVisibility(8);
        ArrayList r = DatabaseService.r();
        if (r != null && r.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.v.setVisibility(8);
            this.o.a(r);
            this.o.a(false);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.v.setVisibility(0);
        this.v.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.B == 0) {
                if (this.w != null) {
                    ArrayList a2 = this.w.a();
                    if (a2 != null && a2.size() > 0) {
                        this.m.setVisibility(0);
                        this.n.setVisibility(8);
                        this.p.setVisibility(0);
                        this.p.setAdapter((ListAdapter) this.q);
                        this.q.a(a2);
                        this.q.notifyDataSetInvalidated();
                    } else {
                        this.m.setVisibility(8);
                        this.v.setVisibility(0);
                        this.v.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.x != null) {
                ArrayList a3 = this.x.a();
                if (a3 != null && a3.size() > 0) {
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
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.g
    protected void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.n, i);
        com.baidu.tieba.util.ah.a(this.p, i);
        com.baidu.tieba.util.ah.a(this.f, i);
        if (i == 1) {
            this.f1108a.setTextColor(-8682095);
            this.f1108a.setHintTextColor(-11446171);
            this.c.setTextColor(-5454368);
            this.t.setTextColor(getResources().getColor(R.color.search_text_content_night));
            com.baidu.tieba.util.ah.h(this.e, (int) R.drawable.inputbox_topbg_1);
            com.baidu.tieba.util.ah.h((View) this.c, (int) R.drawable.search_tap_go_dr_1);
            com.baidu.tieba.util.ah.h((View) this.t, (int) R.drawable.btn_w_square_1);
            com.baidu.tieba.util.ah.h(this.d, (int) R.drawable.inputbox_top_1);
            com.baidu.tieba.util.ah.h(this.g, (int) R.drawable.tabbar_bj_tab_1);
            com.baidu.tieba.util.ah.h((View) this.l, (int) R.drawable.search_baidu_btn_drawable_1);
            com.baidu.tieba.util.ah.h((View) this.j, (int) R.drawable.search_forum_btn_drawable_1);
            com.baidu.tieba.util.ah.h((View) this.k, (int) R.drawable.search_post_btn_drawable_1);
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.v.setTextColor(-11446171);
            this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_blank_page_search_1, 0, 0);
            return;
        }
        this.f1108a.setTextColor(getResources().getColor(R.color.search_text_content));
        this.f1108a.setHintTextColor(-5921112);
        this.c.setTextColor(-1);
        this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.ah.h((View) this.t, (int) R.drawable.btn_w_square);
        com.baidu.tieba.util.ah.h(this.d, (int) R.drawable.inputbox_top);
        com.baidu.tieba.util.ah.h(this.e, (int) R.drawable.inputbox_topbg);
        com.baidu.tieba.util.ah.h((View) this.c, (int) R.drawable.search_tap_go_dr);
        com.baidu.tieba.util.ah.h(this.g, (int) R.drawable.tabbar_bj_tab);
        com.baidu.tieba.util.ah.h((View) this.l, (int) R.drawable.search_baidu_btn_drawable);
        com.baidu.tieba.util.ah.h((View) this.j, (int) R.drawable.search_forum_btn_drawable);
        com.baidu.tieba.util.ah.h((View) this.k, (int) R.drawable.search_post_btn_drawable);
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.v.setTextColor(-3618616);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_blank_page_search, 0, 0);
    }

    @Override // com.baidu.tieba.g
    protected void i() {
        super.i();
        d(-1);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
