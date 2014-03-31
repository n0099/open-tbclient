package com.baidu.tieba.account.forbid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
public class ForbidActivity extends com.baidu.tbadk.a {
    private NavigationBar a;
    private RadioGroup b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private TextView h;
    private BdListView i;
    private e j;
    private View.OnClickListener k = new a(this);

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForbidActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("thread_id", str3);
        intent.putExtra("bar_manager_user_id", str4);
        intent.putExtra("user_name", str5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_forbid_activity);
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11018);
            return;
        }
        this.a = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.a.a(getString(com.baidu.tieba.a.k.forbid_page_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.forbid_btn_txt), this.k);
        this.h = (TextView) findViewById(com.baidu.tieba.a.h.forbid_id);
        this.i = (BdListView) findViewById(com.baidu.tieba.a.h.listview_forbid_reason);
        this.b = (RadioGroup) findViewById(com.baidu.tieba.a.h.forbid_days);
        this.b.setOnCheckedChangeListener(new c(this));
        Intent intent = getIntent();
        this.c = intent.getStringExtra("forum_id");
        this.d = intent.getStringExtra("forum_name");
        this.e = intent.getStringExtra("thread_id");
        this.f = intent.getStringExtra("bar_manager_user_id");
        this.g = intent.getStringExtra("user_name");
        l.a(this.c, this.f, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ForbidActivity forbidActivity, int i) {
        boolean z = TbadkApplication.j().l() == 1;
        int i2 = !z ? com.baidu.tieba.a.g.btn_prohibit_day_n : com.baidu.tieba.a.g.btn_prohibit_day_n_1;
        int i3 = !z ? com.baidu.tieba.a.e.appeal_com_text : com.baidu.tieba.a.e.appeal_com_text_1;
        int i4 = !z ? com.baidu.tieba.a.g.btn_prohibit_day_s : com.baidu.tieba.a.g.btn_prohibit_day_s_1;
        int i5 = !z ? com.baidu.tieba.a.e.forbid_time_selected : com.baidu.tieba.a.e.forbid_time_selected_1;
        for (int i6 = 0; i6 < 3; i6++) {
            RadioButton radioButton = (RadioButton) forbidActivity.b.getChildAt(i6);
            if (radioButton.getId() == i) {
                ba.e((View) radioButton, i4);
                radioButton.setTextColor(forbidActivity.getResources().getColor(i5));
            } else {
                ba.e((View) radioButton, i2);
                radioButton.setTextColor(forbidActivity.getResources().getColor(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(com.baidu.tieba.a.h.root);
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById);
        this.a.b(i);
        this.i.setDivider(getResources().getDrawable(z ? com.baidu.tieba.a.g.forbid_list_divider_1 : com.baidu.tieba.a.g.forbid_list_divider));
        this.i.setDividerHeight(com.baidu.adp.lib.util.i.a((Context) this, 1.0f));
    }
}
