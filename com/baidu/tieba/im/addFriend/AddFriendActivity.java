package com.baidu.tieba.im.addFriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity {
    private InputMethodManager a;
    private View b;
    private NavigationBar c;
    private EditText d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private String h;
    private String i;
    private String j;
    private boolean k;
    private String l;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.a.class, AddFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.activity_add_friend);
        this.a = (InputMethodManager) getSystemService("input_method");
        b();
        a(bundle);
        a();
    }

    private void a() {
        registerListener(new a(this, 304100));
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.h = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                String stringExtra = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
                if (this.d != null) {
                    if (TextUtils.isEmpty(stringExtra)) {
                        this.d.setText(String.valueOf(getString(x.my_name_is)) + TbadkApplication.getCurrentAccountName());
                    } else {
                        this.d.setText(String.valueOf(getString(x.i_am_come_from)) + stringExtra + getString(x.and_name_is) + TbadkApplication.getCurrentAccountName());
                    }
                    this.d.requestFocus();
                }
                this.i = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.j = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.k = intent.getBooleanExtra("is_user_client_lower", false);
                this.l = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
                return;
            }
            return;
        }
        this.h = bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        String string = bundle.getString("msg");
        if (!TextUtils.isEmpty(string) && this.d != null) {
            this.d.setText(string);
        }
        this.i = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.j = bundle.getString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.k = bundle.getBoolean("is_user_client_lower", false);
        this.l = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.h);
            if (this.d != null && !TextUtils.isEmpty(this.d.getText().toString())) {
                bundle.putString("msg", this.d.getText().toString());
            }
            bundle.putBoolean("is_user_client_lower", this.k);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.i);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, this.j);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.l);
        }
    }

    private void b() {
        this.b = findViewById(u.search_friend_parent);
        this.b.setOnClickListener(new b(this));
        this.g = (ImageView) findViewById(u.cancle);
        this.g.setOnClickListener(new c(this));
        this.c = (NavigationBar) findViewById(u.search_friend_navigation_bar);
        this.c.a(getString(x.apply_new_friends));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.c.b(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(x.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(s.ds94);
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundResource(t.btn_titlebar_finish);
        this.e.setOnClickListener(new d(this));
        this.f = (TextView) findViewById(u.search_friend_tip);
        this.d = (EditText) findViewById(u.search_friend_input);
        this.d.setOnFocusChangeListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.i)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.e.b.a(this.h, 0L), this.j, this.i, TextUtils.isEmpty(str) ? String.valueOf(getString(x.my_name_is)) + TbadkApplication.getCurrentAccountName() : str, this.l));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.a, this.d);
        this.d.setSelection(this.d.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.a, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        getLayoutMode().a(this.b);
        this.f.setTextColor(getResources().getColor(i == 1 ? r.cp_cont_c_1 : r.cp_cont_c));
        this.e.setTextColor(getResources().getColor(i == 1 ? r.cp_cont_i_1 : r.cp_cont_i));
        this.e.setBackgroundResource(i == 1 ? t.btn_titlebar_finish_1 : t.btn_titlebar_finish);
    }
}
