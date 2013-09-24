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
import com.baidu.tieba.data.ax;
import com.baidu.tieba.data.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.cd;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.av;
import com.baidu.zeus.WebChromeClient;
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
    ImageView f1189a = null;
    private LinearLayout k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private Button n = null;
    private ImageView o = null;
    private FrameLayout p = null;
    private ListView q = null;
    private am r = null;
    private ListView s = null;
    private am t = null;
    private ao u = null;
    private ProgressBar v = null;
    private Button w = null;
    private View x = null;
    private TextView y = null;
    private cd z = null;
    private ay A = null;
    private al B = null;
    private ak C = null;
    private String D = null;
    private int E = 0;
    final View.OnClickListener b = new u(this);
    private Handler F = new Handler();
    private Runnable G = new ac(this);

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        c();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    protected void onDestroy() {
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
        this.c.setOnFocusChangeListener(new ad(this));
        this.f1189a = (ImageView) findViewById(R.id.search_bar_icon);
        this.o = (ImageView) findViewById(R.id.back);
        this.o.setOnClickListener(new ae(this));
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.j = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new af(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new ag(this));
        this.c.addTextChangedListener(new ah(this));
        this.k = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.l = (RadioButton) findViewById(R.id.search_forum_btn);
        this.m = (RadioButton) findViewById(R.id.search_post_btn);
        this.n = (Button) findViewById(R.id.search_in_baidu_btn);
        this.l.setOnCheckedChangeListener(new ai(this));
        this.m.setOnCheckedChangeListener(new aj(this));
        this.n.setOnClickListener(new v(this));
        this.p = (FrameLayout) findViewById(R.id.home_search_list);
        this.q = (ListView) findViewById(R.id.home_lv_search);
        this.w = (Button) this.x.findViewById(R.id.home_bt_search_footer);
        this.w.setOnClickListener(new w(this));
        this.q.addFooterView(this.x, null, true);
        this.r = new am(this, null);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new z(this));
        this.s = (ListView) findViewById(R.id.home_lv_suggest);
        this.t = new am(this, null);
        this.u = new ao(this);
        this.s.setAdapter((ListAdapter) this.t);
        this.s.setOnItemClickListener(new aa(this));
        ab abVar = new ab(this);
        this.s.setOnScrollListener(abVar);
        this.q.setOnScrollListener(abVar);
        this.v = (ProgressBar) findViewById(R.id.home_progress_search);
        this.v.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        n();
        a(this.c, WebChromeClient.STRING_DLG_BTN_SET);
        if (TiebaApplication.g().r()) {
            this.l.setChecked(true);
            b(0);
            return;
        }
        this.m.setChecked(true);
        b(1);
    }

    public void d() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    public void b(int i) {
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
            m();
        }
    }

    public void m() {
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
                    stringBuffer.append(com.baidu.tieba.data.g.f1032a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.C = new ak(this, stringBuffer.toString(), arrayList);
                    this.C.setPriority(3);
                    this.C.execute(new Object[0]);
                }
            } catch (Exception e) {
                av.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
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
                ArrayList<ax> a3 = this.A.a();
                if (a3 != null && a3.size() > 0) {
                    this.p.setVisibility(0);
                    this.q.setVisibility(8);
                    this.s.setVisibility(0);
                    this.s.setAdapter((ListAdapter) this.u);
                    this.u.a(this.A);
                    this.u.notifyDataSetInvalidated();
                    if (this.A.c()) {
                        this.s.setSelection(1);
                    }
                } else {
                    this.p.setVisibility(8);
                    this.y.setVisibility(0);
                    this.y.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.j
    protected void a(int i) {
        super.a(i);
        com.baidu.tieba.util.as.a(this.o, i);
        com.baidu.tieba.util.as.d(this.g, i);
        com.baidu.tieba.util.as.a(this.q, i);
        com.baidu.tieba.util.as.a(this.s, i);
        com.baidu.tieba.util.as.a(this.j, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.w.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.f1189a.setImageResource(R.drawable.icon_head_bar_search_1);
            com.baidu.tieba.util.as.e((View) this.w, (int) R.drawable.btn_w_square_1);
            com.baidu.tieba.util.as.e(this.f, (int) R.drawable.inputbox_top_1);
            com.baidu.tieba.util.as.e(this.k, (int) R.drawable.inputbox_topbg_1);
            this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            com.baidu.tieba.util.as.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable_1);
            com.baidu.tieba.util.as.e((View) this.l, (int) R.drawable.search_forum_btn_drawable_1);
            com.baidu.tieba.util.as.e((View) this.m, (int) R.drawable.search_post_btn_drawable_1);
            this.y.setTextColor(-11446171);
            this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            com.baidu.tieba.util.as.e((View) this.d, (int) R.drawable.search_delete_button_1);
            return;
        }
        com.baidu.tieba.util.as.e((View) this.d, (int) R.drawable.search_delete_button);
        this.f1189a.setImageResource(R.drawable.icon_head_bar_search);
        this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.w.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.as.e((View) this.w, (int) R.drawable.btn_w_square);
        com.baidu.tieba.util.as.e(this.f, (int) R.drawable.inputbox_top);
        com.baidu.tieba.util.as.e(this.k, (int) R.drawable.inputbox_topbg);
        com.baidu.tieba.util.as.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable);
        com.baidu.tieba.util.as.e((View) this.l, (int) R.drawable.search_forum_btn_drawable);
        com.baidu.tieba.util.as.e((View) this.m, (int) R.drawable.search_post_btn_drawable);
        this.y.setTextColor(-3618616);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    @Override // com.baidu.tieba.j
    protected void j() {
        super.j();
        d(-1);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
