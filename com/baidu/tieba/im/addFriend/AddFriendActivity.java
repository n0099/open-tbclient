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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity {
    private String Ai;
    private InputMethodManager aNh;
    private EditText aNi;
    private TextView aNj;
    private TextView aNk;
    private ImageView aNl;
    private boolean aNm;
    private View agJ;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    static {
        TbadkApplication.m251getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_add_friend);
        this.aNh = (InputMethodManager) getSystemService("input_method");
        rY();
        d(bundle);
        HJ();
    }

    private void HJ() {
        registerListener(new a(this, 304100));
    }

    private void d(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                this.Ai = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.aNi != null) {
                    if (!StringUtils.isNull(this.Ai)) {
                        this.aNi.setText(this.Ai);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.aNi.setText(String.valueOf(getString(y.my_name_is)) + TbadkApplication.getCurrentAccountName());
                        } else {
                            this.aNi.setText(String.valueOf(getString(y.i_am_come_from)) + stringExtra + getString(y.and_name_is) + TbadkApplication.getCurrentAccountName());
                        }
                    }
                    this.aNi.requestFocus();
                }
                this.portrait = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.name = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.aNm = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        this.Ai = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.aNi != null) {
            if (!StringUtils.isNull(this.Ai)) {
                this.aNi.setText(this.Ai);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.aNi.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.name = bundle.getString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.aNm = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.userId);
            if (this.aNi != null && !TextUtils.isEmpty(this.aNi.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.aNi.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.aNm);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ai);
        }
    }

    private void rY() {
        this.agJ = findViewById(v.search_friend_parent);
        this.agJ.setOnClickListener(new b(this));
        this.aNl = (ImageView) findViewById(v.cancle);
        this.aNl.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) findViewById(v.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getString(y.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNj = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(y.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.aNj.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(t.ds94);
        this.aNj.setLayoutParams(layoutParams);
        this.aNj.setBackgroundResource(u.btn_titlebar_finish);
        this.aNj.setOnClickListener(new d(this));
        this.aNk = (TextView) findViewById(v.search_friend_tip);
        this.aNi = (EditText) findViewById(v.search_friend_input);
        this.aNi.setOnFocusChangeListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.c.a(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getString(y.my_name_is)) + TbadkApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.aNh, this.aNi);
        this.aNi.setSelection(this.aNi.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.aNh, this.aNi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        getLayoutMode().h(this.agJ);
        this.aNk.setTextColor(aw.getColor(s.cp_cont_c));
        this.aNj.setTextColor(aw.getColor(s.cp_cont_i));
        aw.h((View) this.aNj, u.btn_titlebar_finish);
    }
}
