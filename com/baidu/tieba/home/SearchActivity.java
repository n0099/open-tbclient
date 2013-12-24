package com.baidu.tieba.home;

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
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.cg;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.j {
    private NavigationBar l;
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private FrameLayout g = null;
    ImageView a = null;
    private LinearLayout h = null;
    private RadioButton i = null;
    private RadioButton j = null;
    private Button k = null;
    private FrameLayout m = null;
    private ListView n = null;
    private av o = null;
    private ListView p = null;
    private av q = null;
    private ay r = null;
    private ProgressBar s = null;
    private Button t = null;
    private View u = null;
    private TextView v = null;
    private cg w = null;
    private SearchPostModel x = null;
    private au y = null;
    private at z = null;
    private String A = null;
    private int B = 0;
    final View.OnClickListener b = new ae(this);
    private Handler C = new Handler();
    private Runnable D = new al(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.B == 0) {
            TiebaApplication.h().b(true);
        } else {
            TiebaApplication.h().b(false);
        }
        c();
        a();
    }

    public void a() {
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

    public void b() {
        this.l = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        View a = this.l.a(R.layout.nb_item_search_dialog, (View.OnClickListener) null);
        this.u = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.v = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new am(this));
        this.a = (ImageView) findViewById(R.id.search_bar_icon);
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new an(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new ao(this));
        this.c.addTextChangedListener(new ap(this));
        this.h = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.i = (RadioButton) a.findViewById(R.id.search_forum_btn);
        this.j = (RadioButton) a.findViewById(R.id.search_post_btn);
        this.k = (Button) a.findViewById(R.id.search_in_baidu_btn);
        this.i.setOnCheckedChangeListener(new aq(this));
        this.j.setOnCheckedChangeListener(new ar(this));
        this.k.setOnClickListener(new as(this));
        this.m = (FrameLayout) findViewById(R.id.home_search_list);
        this.n = (ListView) findViewById(R.id.home_lv_search);
        this.t = (Button) this.u.findViewById(R.id.home_bt_search_footer);
        this.t.setOnClickListener(new af(this));
        this.n.addFooterView(this.u, null, true);
        this.o = new av(this, null);
        this.n.setAdapter((ListAdapter) this.o);
        this.n.setOnItemClickListener(new ai(this));
        this.p = (ListView) findViewById(R.id.home_lv_suggest);
        this.q = new av(this, null);
        this.r = new ay(this);
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOnItemClickListener(new aj(this));
        ak akVar = new ak(this);
        this.p.setOnScrollListener(akVar);
        this.n.setOnScrollListener(akVar);
        this.s = (ProgressBar) findViewById(R.id.home_progress_search);
        this.s.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        f();
        ShowSoftKeyPadDelay(this.c, 150);
        if (TiebaApplication.h().s()) {
            this.i.setChecked(true);
            a(0);
            return;
        }
        this.j.setChecked(true);
        a(1);
    }

    public void c() {
        if (this.s != null) {
            this.s.setVisibility(8);
        }
        if (this.r != null) {
            this.r.a();
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.B != 0) {
                    this.B = 0;
                    this.c.setHint(R.string.search_bar);
                    a();
                    if (this.A.trim().length() > 0) {
                        g();
                        return;
                    } else {
                        f();
                        return;
                    }
                }
                return;
            case 1:
                if (this.B != 1) {
                    this.B = 1;
                    this.c.setHint(R.string.search_post_hint);
                    a();
                    if (this.A.trim().length() > 0) {
                        this.p.setVisibility(8);
                        a(1, this.A);
                        return;
                    }
                    h();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void d() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            e();
        }
    }

    public void e() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.p.setVisibility(8);
        ArrayList<String> o = DatabaseService.o();
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
    public void g() {
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
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    a();
                    this.z = new at(this, stringBuffer.toString(), arrayList);
                    this.z.setPriority(3);
                    this.z.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.p.setVisibility(8);
        ArrayList<String> p = DatabaseService.p();
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
    public void i() {
        try {
            if (this.B == 0) {
                if (this.w != null) {
                    ArrayList<String> a = this.w.a();
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
                ArrayList<com.baidu.tieba.data.au> data = this.x.getData();
                if (data != null && data.size() > 0) {
                    this.m.setVisibility(0);
                    this.n.setVisibility(8);
                    this.p.setVisibility(0);
                    this.p.setAdapter((ListAdapter) this.r);
                    this.r.a(this.x);
                    this.r.notifyDataSetInvalidated();
                    if (this.x.hasPre()) {
                        this.p.setSelection(1);
                    }
                } else {
                    this.m.setVisibility(8);
                    this.v.setVisibility(0);
                    this.v.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.l.c(i);
        com.baidu.tieba.util.bb.a(this.n, i);
        com.baidu.tieba.util.bb.a(this.p, i);
        com.baidu.tieba.util.bb.a(this.g, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.t.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.a.setImageResource(R.drawable.icon_head_bar_search_1);
            com.baidu.tieba.util.bb.e((View) this.t, (int) R.drawable.btn_w_square_1);
            com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.inputbox_top_1);
            this.h.setBackgroundColor(getResources().getColor(R.color.navi_bg_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.i.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.search_baidu_btn_drawable_1);
            com.baidu.tieba.util.bb.e((View) this.i, (int) R.drawable.search_forum_btn_drawable_1);
            com.baidu.tieba.util.bb.e((View) this.j, (int) R.drawable.search_post_btn_drawable_1);
            this.v.setTextColor(-11446171);
            this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            com.baidu.tieba.util.bb.e((View) this.d, (int) R.drawable.search_delete_button_1);
            return;
        }
        com.baidu.tieba.util.bb.e((View) this.d, (int) R.drawable.search_delete_button);
        this.a.setImageResource(R.drawable.icon_head_bar_search);
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.i.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.bb.e((View) this.t, (int) R.drawable.btn_w_square);
        com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.inputbox_top);
        this.h.setBackgroundColor(getResources().getColor(R.color.navi_bg));
        com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.search_baidu_btn_drawable);
        com.baidu.tieba.util.bb.e((View) this.i, (int) R.drawable.search_forum_btn_drawable);
        com.baidu.tieba.util.bb.e((View) this.j, (int) R.drawable.search_post_btn_drawable);
        this.v.setTextColor(-3618616);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.v.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
