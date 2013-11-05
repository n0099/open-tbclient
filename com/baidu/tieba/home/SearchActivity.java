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
import com.baidu.tieba.model.cn;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.j {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private FrameLayout j = null;

    /* renamed from: a  reason: collision with root package name */
    ImageView f1324a = null;
    private LinearLayout k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private Button n = null;
    private ImageView o = null;
    private FrameLayout p = null;
    private ListView q = null;
    private ar r = null;
    private ListView s = null;
    private ar t = null;
    private au u = null;
    private ProgressBar v = null;
    private Button w = null;
    private View x = null;
    private TextView y = null;
    private cn z = null;
    private SearchPostModel A = null;
    private aq B = null;
    private ap C = null;
    private String D = null;
    private int E = 0;
    final View.OnClickListener b = new z(this);
    private Handler F = new Handler();
    private Runnable G = new ah(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.E == 0) {
            TiebaApplication.g().b(true);
        } else {
            TiebaApplication.g().b(false);
        }
        d();
        b();
    }

    public void b() {
        this.F.removeCallbacks(this.G);
        if (this.B != null) {
            this.B.cancel();
            this.B = null;
        }
        if (this.C != null) {
            this.C.cancel();
            this.C = null;
        }
    }

    public void c() {
        this.x = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.y = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new ai(this));
        this.f1324a = (ImageView) findViewById(R.id.search_bar_icon);
        this.o = (ImageView) findViewById(R.id.back);
        this.o.setOnClickListener(new aj(this));
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.j = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new ak(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new al(this));
        this.c.addTextChangedListener(new am(this));
        this.k = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.l = (RadioButton) findViewById(R.id.search_forum_btn);
        this.m = (RadioButton) findViewById(R.id.search_post_btn);
        this.n = (Button) findViewById(R.id.search_in_baidu_btn);
        this.l.setOnCheckedChangeListener(new an(this));
        this.m.setOnCheckedChangeListener(new ao(this));
        this.n.setOnClickListener(new aa(this));
        this.p = (FrameLayout) findViewById(R.id.home_search_list);
        this.q = (ListView) findViewById(R.id.home_lv_search);
        this.w = (Button) this.x.findViewById(R.id.home_bt_search_footer);
        this.w.setOnClickListener(new ab(this));
        this.q.addFooterView(this.x, null, true);
        this.r = new ar(this, null);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new ae(this));
        this.s = (ListView) findViewById(R.id.home_lv_suggest);
        this.t = new ar(this, null);
        this.u = new au(this);
        this.s.setAdapter((ListAdapter) this.t);
        this.s.setOnItemClickListener(new af(this));
        ag agVar = new ag(this);
        this.s.setOnScrollListener(agVar);
        this.q.setOnScrollListener(agVar);
        this.v = (ProgressBar) findViewById(R.id.home_progress_search);
        this.v.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        n();
        a(this.c, 150);
        if (TiebaApplication.g().r()) {
            this.l.setChecked(true);
            d(0);
            return;
        }
        this.m.setChecked(true);
        d(1);
    }

    public void d() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    public void d(int i) {
        switch (i) {
            case 0:
                if (this.E != 0) {
                    this.E = 0;
                    this.c.setHint(R.string.search_bar);
                    b();
                    if (this.D.trim().length() > 0) {
                        o();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                return;
            case 1:
                if (this.E != 1) {
                    this.E = 1;
                    this.c.setHint(R.string.search_post_hint);
                    b();
                    if (this.D.trim().length() > 0) {
                        this.s.setVisibility(8);
                        a(1, this.D);
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

    public void e() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            f();
        }
    }

    public void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.s.setVisibility(8);
        ArrayList<String> o = DatabaseService.o();
        if (o != null && o.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.s.setVisibility(8);
            this.y.setVisibility(8);
            this.r.a(o);
            this.r.a(true);
            this.r.notifyDataSetInvalidated();
            return;
        }
        this.p.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.p.setVisibility(8);
        this.F.removeCallbacks(this.G);
        this.F.postDelayed(this.G, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.q.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1165a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.C = new ap(this, stringBuffer.toString(), arrayList);
                    this.C.setPriority(3);
                    this.C.execute(new Object[0]);
                }
            } catch (Exception e) {
                be.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.s.setVisibility(8);
        ArrayList<String> p = DatabaseService.p();
        if (p != null && p.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.s.setVisibility(8);
            this.y.setVisibility(8);
            this.r.a(p);
            this.r.a(false);
            this.r.notifyDataSetInvalidated();
            return;
        }
        this.p.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (this.E == 0) {
                if (this.z != null) {
                    ArrayList<String> a2 = this.z.a();
                    if (a2 != null && a2.size() > 0) {
                        this.p.setVisibility(0);
                        this.q.setVisibility(8);
                        this.s.setVisibility(0);
                        this.s.setAdapter((ListAdapter) this.t);
                        this.t.a(a2);
                        this.t.notifyDataSetInvalidated();
                    } else {
                        this.p.setVisibility(8);
                        this.y.setVisibility(0);
                        this.y.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.A != null) {
                ArrayList<com.baidu.tieba.data.ax> data = this.A.getData();
                if (data != null && data.size() > 0) {
                    this.p.setVisibility(0);
                    this.q.setVisibility(8);
                    this.s.setVisibility(0);
                    this.s.setAdapter((ListAdapter) this.u);
                    this.u.a(this.A);
                    this.u.notifyDataSetInvalidated();
                    if (this.A.hasPre()) {
                        this.s.setSelection(1);
                    }
                } else {
                    this.p.setVisibility(8);
                    this.y.setVisibility(0);
                    this.y.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        bb.a(this.o, i);
        bb.d(this.g, i);
        bb.a(this.q, i);
        bb.a(this.s, i);
        bb.a(this.j, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.w.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.f1324a.setImageResource(R.drawable.icon_head_bar_search_1);
            bb.e((View) this.w, (int) R.drawable.btn_w_square_1);
            bb.e(this.f, (int) R.drawable.inputbox_top_1);
            bb.e(this.k, (int) R.drawable.inputbox_topbg_1);
            this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            bb.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable_1);
            bb.e((View) this.l, (int) R.drawable.search_forum_btn_drawable_1);
            bb.e((View) this.m, (int) R.drawable.search_post_btn_drawable_1);
            this.y.setTextColor(-11446171);
            this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            bb.e((View) this.d, (int) R.drawable.search_delete_button_1);
            return;
        }
        bb.e((View) this.d, (int) R.drawable.search_delete_button);
        this.f1324a.setImageResource(R.drawable.icon_head_bar_search);
        this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.w.setTextColor(getResources().getColor(R.color.reg_font_color));
        bb.e((View) this.w, (int) R.drawable.btn_w_square);
        bb.e(this.f, (int) R.drawable.inputbox_top);
        bb.e(this.k, (int) R.drawable.inputbox_topbg);
        bb.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable);
        bb.e((View) this.l, (int) R.drawable.search_forum_btn_drawable);
        bb.e((View) this.m, (int) R.drawable.search_post_btn_drawable);
        this.y.setTextColor(-3618616);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void k() {
        super.k();
        c(-1);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
