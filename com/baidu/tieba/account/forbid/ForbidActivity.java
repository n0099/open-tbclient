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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForbidActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private NavigationBar f1079a;
    private RadioGroup b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private TextView h;
    private BdListView i;
    private e j;
    private View.OnClickListener k = new c(this);

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForbidActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("thread_id", str3);
        intent.putExtra("bar_manager_user_id", str4);
        intent.putExtra("user_name", str5);
        context.startActivity(intent);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_forbid_activity);
        String B = TiebaApplication.B();
        if (B == null || B.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11018);
            return;
        }
        this.f1079a = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f1079a.a(getString(R.string.forbid_page_title));
        this.f1079a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f1079a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.forbid_btn_txt), this.k);
        this.h = (TextView) findViewById(R.id.forbid_id);
        this.i = (BdListView) findViewById(R.id.listview_forbid_reason);
        this.b = (RadioGroup) findViewById(R.id.forbid_days);
        this.b.setOnCheckedChangeListener(new a(this));
        a();
    }

    private void a() {
        Intent intent = getIntent();
        this.c = intent.getStringExtra("forum_id");
        this.d = intent.getStringExtra("forum_name");
        this.e = intent.getStringExtra("thread_id");
        this.f = intent.getStringExtra("bar_manager_user_id");
        this.g = intent.getStringExtra("user_name");
        l.a(this.c, this.f, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        boolean z = TiebaApplication.h().an() == 1;
        int i2 = !z ? R.drawable.btn_prohibit_day_n : R.drawable.btn_prohibit_day_n_1;
        int i3 = !z ? R.color.appeal_com_text : R.color.appeal_com_text_1;
        int i4 = !z ? R.drawable.btn_prohibit_day_s : R.drawable.btn_prohibit_day_s_1;
        int i5 = !z ? R.color.forbid_time_selected : R.color.forbid_time_selected_1;
        for (int i6 = 0; i6 < 3; i6++) {
            RadioButton radioButton = (RadioButton) this.b.getChildAt(i6);
            if (radioButton.getId() == i) {
                ba.e((View) radioButton, i4);
                radioButton.setTextColor(getResources().getColor(i5));
            } else {
                ba.e((View) radioButton, i2);
                radioButton.setTextColor(getResources().getColor(i3));
            }
        }
    }

    @Override // com.baidu.tieba.j
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(R.id.root);
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById);
        this.f1079a.c(i);
        this.i.setDivider(getResources().getDrawable(z ? R.drawable.forbid_list_divider_1 : R.drawable.forbid_list_divider));
        this.i.setDividerHeight(com.baidu.adp.lib.h.g.a((Context) this, 1.0f));
    }
}
