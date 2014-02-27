package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class g {
    public BdListView a;
    private SearchGroupActivity b;
    private View c;
    private NavigationBar d;
    private EditText e;
    private Button f;
    private Button g;
    private TextView h;
    private ProgressBar i;
    private e j;

    public final e a() {
        return this.j;
    }

    public g(SearchGroupActivity searchGroupActivity) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = searchGroupActivity;
        searchGroupActivity.setContentView(R.layout.search_group_activity);
        this.c = this.b.findViewById(R.id.mparent);
        this.d = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getResources().getString(R.string.search_group_text));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = (TextView) this.b.findViewById(R.id.text_no_data);
        this.h.setText(R.string.text_no_search_record_ground);
        this.e = (EditText) this.b.findViewById(R.id.home_et_search);
        this.e.setHint(R.string.search_group_by_id);
        this.e.setOnFocusChangeListener(new h(this));
        this.g = (Button) this.b.findViewById(R.id.home_bt_search_s);
        this.g.setOnClickListener(this.b);
        this.f = (Button) this.b.findViewById(R.id.home_bt_search_del);
        this.f.setOnClickListener(new i(this));
        this.e.addTextChangedListener(new j(this));
        this.a = (BdListView) this.b.findViewById(R.id.home_lv_search);
        this.a.a(new k(this), 300L);
        this.j = new e(this.b);
        this.a.setOnItemClickListener(this.b);
        this.a.setAdapter((ListAdapter) this.j);
        this.i = (ProgressBar) this.b.findViewById(R.id.home_progress_search);
        this.i.setVisibility(8);
        this.e.setText("");
        this.e.setInputType(2);
        this.e.requestFocus();
        this.e.setOnEditorActionListener(new l(this));
        this.b.ShowSoftKeyPadDelay(this.e, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    public final void b() {
        this.b.getLayoutMode().a(false);
        this.b.getLayoutMode().a(this.c);
        bq.a(this.c, 0);
        this.d.b(0);
        this.h.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    public final void c() {
        this.i.setVisibility(8);
    }

    public final void d() {
        if (this.j.getCount() == 0) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public final void a(ct ctVar) {
        List<BaseGroupData> linkedList = new LinkedList<>();
        if (ctVar != null && ctVar.a() != null) {
            linkedList = ctVar.a();
        }
        this.j.a(linkedList);
    }

    public final void e() {
        this.i.setVisibility(0);
    }
}
