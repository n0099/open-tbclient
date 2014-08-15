package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity {
    private com.baidu.tieba.addresslist.c.b a;
    private View b;
    private NavigationBar c;
    private EditText d;
    private TextView e;
    private View f;
    private ListView g;
    private m h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.quick_search_activity);
        this.a = new com.baidu.tieba.addresslist.c.b(this);
        this.a.setUniqueId(getUniqueId());
        a();
    }

    private void a() {
        this.b = findViewById(u.quick_search_parent);
        b();
        this.g = (ListView) findViewById(u.quick_search_result);
        this.h = new m(this, null);
        this.g.setAdapter((ListAdapter) this.h);
        this.g.setOnItemClickListener(this);
        this.f = findViewById(u.quick_search_empty_result);
    }

    private void b() {
        this.c = (NavigationBar) findViewById(u.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        View a = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, v.quick_search_navigation, (View.OnClickListener) null);
        this.d = (EditText) a.findViewById(u.quick_search_input);
        this.d.addTextChangedListener(new l(this, null));
        this.d.setOnFocusChangeListener(new j(this));
        this.e = (TextView) a.findViewById(u.quick_search_delete_button);
        com.baidu.adp.lib.util.j.a(this, this.e, 10, 10, 10, 10);
        this.e.setOnClickListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.j.a(this, this.d);
        this.a = null;
    }

    public void a(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.b> a = this.a.a(str);
        if (a.size() > 0) {
            a(true);
            this.h.a(a);
            this.h.notifyDataSetChanged();
            return;
        }
        a(false);
    }

    private void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        this.f.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.h.getItem(i);
        if (item != null && item.c() > 0) {
            sendMessage(new CustomMessage(2002003, new bg(TbadkApplication.m252getInst().getApplicationContext(), String.valueOf(item.c()), item.b())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.setBackgroundResource(i == 1 ? r.cp_bg_line_d_1 : r.cp_bg_line_d);
        this.c.c(i);
        this.h.notifyDataSetChanged();
    }
}
