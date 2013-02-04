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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SearchActivity extends com.baidu.tieba.e {
    private EditText b = null;
    private Button c = null;
    private Button d = null;
    private Button e = null;
    private View.OnClickListener f = null;
    private FrameLayout g = null;
    private ListView h = null;
    private ao i = null;
    private ListView j = null;
    private ao k = null;
    private ProgressBar l = null;
    private Button m = null;
    private View n = null;
    private TextView o = null;
    private com.baidu.tieba.b.s p = null;
    private an q = null;
    private String r = null;
    private Handler s = new Handler();
    private Runnable t = new aa(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.setVisibility(8);
        ArrayList m = com.baidu.tieba.c.k.m();
        if (m == null || m.size() <= 0) {
            this.g.setVisibility(8);
            this.o.setVisibility(0);
            this.o.setText(R.string.text_no_search_record);
            return;
        }
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.j.setVisibility(8);
        this.o.setVisibility(8);
        this.i.a(m);
        this.i.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.g.setVisibility(8);
        this.s.removeCallbacks(this.t);
        this.s.postDelayed(this.t, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            if (this.p != null) {
                ArrayList a = this.p.a();
                if (a == null || a.size() <= 0) {
                    this.g.setVisibility(8);
                    this.o.setVisibility(0);
                    this.o.setText(R.string.text_no_suggest);
                } else {
                    this.g.setVisibility(0);
                    this.h.setVisibility(8);
                    this.j.setVisibility(0);
                    this.k.a(a);
                    this.k.notifyDataSetInvalidated();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    public void g() {
        this.s.removeCallbacks(this.t);
        if (this.q != null) {
            this.q.a();
            this.q = null;
        }
    }

    public void h() {
        this.f = new ad(this);
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(this.f);
        this.n = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.o = (TextView) findViewById(R.id.text_no_data);
        this.b = (EditText) findViewById(R.id.home_et_search);
        this.b.setOnFocusChangeListener(new ae(this));
        this.b.setOnEditorActionListener(new af(this));
        ag agVar = new ag(this);
        this.d = (Button) findViewById(R.id.home_bt_search_s);
        this.d.setOnClickListener(agVar);
        this.d.setEnabled(false);
        this.d.setTextColor(getResources().getColor(R.color.gray));
        this.c = (Button) findViewById(R.id.home_bt_search_del);
        this.c.setOnClickListener(new ah(this));
        this.b.addTextChangedListener(new ai(this));
        this.g = (FrameLayout) findViewById(R.id.home_search_list);
        this.h = (ListView) findViewById(R.id.home_lv_search);
        this.m = (Button) this.n.findViewById(R.id.home_bt_search_footer);
        this.m.setOnClickListener(new aj(this));
        this.h.addFooterView(this.n, null, true);
        this.i = new ao(this, null);
        this.h.setAdapter((ListAdapter) this.i);
        this.h.setOnItemClickListener(new am(this));
        this.j = (ListView) findViewById(R.id.home_lv_suggest);
        this.k = new ao(this, null);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnItemClickListener(new ab(this));
        ac acVar = new ac(this);
        this.j.setOnScrollListener(acVar);
        this.h.setOnScrollListener(acVar);
        this.l = (ProgressBar) findViewById(R.id.home_progress_search);
        this.l.setVisibility(8);
        this.b.setText("");
        this.b.requestFocus();
        k();
        a(this.b, 150);
    }

    public void i() {
        if (this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void j() {
        String editable = this.b.getText().toString();
        FrsActivity.a(this, editable, "tb_searchlist", 1);
        if (editable == null || editable.length() == 0) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i();
        g();
    }
}
