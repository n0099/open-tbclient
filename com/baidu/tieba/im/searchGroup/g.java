package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class g {
    public BdListView a;
    private final SearchGroupActivity b;
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
        searchGroupActivity.setContentView(com.baidu.tieba.im.i.search_group_activity);
        this.c = this.b.findViewById(com.baidu.tieba.im.h.mparent);
        this.d = (NavigationBar) this.b.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(this.b.getResources().getString(com.baidu.tieba.im.j.search_group_text));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = (TextView) this.b.findViewById(com.baidu.tieba.im.h.text_no_data);
        this.h.setText(com.baidu.tieba.im.j.text_no_search_record_ground);
        this.e = (EditText) this.b.findViewById(com.baidu.tieba.im.h.home_et_search);
        this.e.setHint(com.baidu.tieba.im.j.search_group_by_id);
        this.e.setOnFocusChangeListener(new h(this));
        this.g = (Button) this.b.findViewById(com.baidu.tieba.im.h.home_bt_search_s);
        this.g.setOnClickListener(this.b);
        this.f = (Button) this.b.findViewById(com.baidu.tieba.im.h.home_bt_search_del);
        this.f.setOnClickListener(new i(this));
        this.e.addTextChangedListener(new j(this));
        this.a = (BdListView) this.b.findViewById(com.baidu.tieba.im.h.home_lv_search);
        this.a.a(new k(this), 300L);
        this.j = new e(this.b);
        this.a.setOnItemClickListener(this.b);
        this.a.setAdapter((ListAdapter) this.j);
        this.i = (ProgressBar) this.b.findViewById(com.baidu.tieba.im.h.home_progress_search);
        this.i.setVisibility(8);
        this.e.setText("");
        this.e.setInputType(2);
        this.e.requestFocus();
        this.e.setOnEditorActionListener(new l(this));
        this.b.ShowSoftKeyPadDelay(this.e, 150);
    }

    public final void b() {
        this.b.getLayoutMode().a(false);
        this.b.getLayoutMode().a(this.c);
        ba.a(this.c, 0);
        this.d.b(0);
        this.h.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.im.g.pic_search_fruitless, 0, 0);
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

    public final void a(ResponseSearchGroupMessage responseSearchGroupMessage) {
        List<BaseGroupData> linkedList = new LinkedList<>();
        if (responseSearchGroupMessage != null && responseSearchGroupMessage.d() != null) {
            linkedList = responseSearchGroupMessage.d();
        }
        this.j.a(linkedList);
    }

    public final void e() {
        this.i.setVisibility(0);
    }
}
