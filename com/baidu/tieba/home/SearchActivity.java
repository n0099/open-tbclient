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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.cb;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.g {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private FrameLayout j = null;

    /* renamed from: a  reason: collision with root package name */
    ImageView f1143a = null;
    private LinearLayout k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private Button n = null;
    private ImageView o = null;
    private FrameLayout p = null;
    private ListView q = null;
    private ba r = null;
    private ListView s = null;
    private ba t = null;
    private bc u = null;
    private ProgressBar v = null;
    private Button w = null;
    private View x = null;
    private TextView y = null;
    private cb z = null;
    private com.baidu.tieba.data.ay A = null;
    private az B = null;
    private ay C = null;
    private String D = null;
    private int E = 0;
    final View.OnClickListener b = new ai(this);
    private Handler F = new Handler();
    private Runnable G = new aq(this);

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
        this.c.setOnFocusChangeListener(new ar(this));
        this.f1143a = (ImageView) findViewById(R.id.search_bar_icon);
        this.o = (ImageView) findViewById(R.id.back);
        this.o.setOnClickListener(new as(this));
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.j = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new at(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new au(this));
        this.c.addTextChangedListener(new av(this));
        this.k = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.l = (RadioButton) findViewById(R.id.search_forum_btn);
        this.m = (RadioButton) findViewById(R.id.search_post_btn);
        this.n = (Button) findViewById(R.id.search_in_baidu_btn);
        this.l.setOnCheckedChangeListener(new aw(this));
        this.m.setOnCheckedChangeListener(new ax(this));
        this.n.setOnClickListener(new aj(this));
        this.p = (FrameLayout) findViewById(R.id.home_search_list);
        this.q = (ListView) findViewById(R.id.home_lv_search);
        this.w = (Button) this.x.findViewById(R.id.home_bt_search_footer);
        this.w.setOnClickListener(new ak(this));
        this.q.addFooterView(this.x, null, true);
        this.r = new ba(this, null);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new an(this));
        this.s = (ListView) findViewById(R.id.home_lv_suggest);
        this.t = new ba(this, null);
        this.u = new bc(this);
        this.s.setAdapter((ListAdapter) this.t);
        this.s.setOnItemClickListener(new ao(this));
        ap apVar = new ap(this);
        this.s.setOnScrollListener(apVar);
        this.q.setOnScrollListener(apVar);
        this.v = (ProgressBar) findViewById(R.id.home_progress_search);
        this.v.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        m();
        a(this.c, WebChromeClient.STRING_DLG_BTN_SET);
        if (TiebaApplication.g().t()) {
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
                        n();
                        return;
                    } else {
                        m();
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
                    o();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void k() {
        String trim = this.c.getText().toString().trim();
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
        this.s.setVisibility(8);
        ArrayList o = DatabaseService.o();
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
    public void n() {
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
                    stringBuffer.append(com.baidu.tieba.data.g.f1014a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.C = new ay(this, stringBuffer.toString(), arrayList);
                    this.C.setPriority(3);
                    this.C.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.s.setVisibility(8);
        ArrayList p = DatabaseService.p();
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
    public void p() {
        try {
            if (this.E == 0) {
                if (this.z != null) {
                    ArrayList a2 = this.z.a();
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
                ArrayList a3 = this.A.a();
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
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.g
    protected void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.a(this.o, i);
        com.baidu.tieba.util.ao.d(this.g, i);
        com.baidu.tieba.util.ao.a(this.q, i);
        com.baidu.tieba.util.ao.a(this.s, i);
        com.baidu.tieba.util.ao.a(this.j, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.w.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.f1143a.setImageResource(R.drawable.icon_head_bar_search_1);
            com.baidu.tieba.util.ao.g((View) this.w, (int) R.drawable.btn_w_square_1);
            com.baidu.tieba.util.ao.g(this.f, (int) R.drawable.inputbox_top_1);
            com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.inputbox_topbg_1);
            this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            com.baidu.tieba.util.ao.g((View) this.n, (int) R.drawable.search_baidu_btn_drawable_1);
            com.baidu.tieba.util.ao.g((View) this.l, (int) R.drawable.search_forum_btn_drawable_1);
            com.baidu.tieba.util.ao.g((View) this.m, (int) R.drawable.search_post_btn_drawable_1);
            this.y.setTextColor(-11446171);
            this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            com.baidu.tieba.util.ao.g((View) this.d, (int) R.drawable.search_delete_button_1);
            return;
        }
        com.baidu.tieba.util.ao.g((View) this.d, (int) R.drawable.search_delete_button);
        this.f1143a.setImageResource(R.drawable.icon_head_bar_search);
        this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.w.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.ao.g((View) this.w, (int) R.drawable.btn_w_square);
        com.baidu.tieba.util.ao.g(this.f, (int) R.drawable.inputbox_top);
        com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.inputbox_topbg);
        com.baidu.tieba.util.ao.g((View) this.n, (int) R.drawable.search_baidu_btn_drawable);
        com.baidu.tieba.util.ao.g((View) this.l, (int) R.drawable.search_forum_btn_drawable);
        com.baidu.tieba.util.ao.g((View) this.m, (int) R.drawable.search_post_btn_drawable);
        this.y.setTextColor(-3618616);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    @Override // com.baidu.tieba.g
    protected void i() {
        super.i();
        d(-1);
        this.y.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
