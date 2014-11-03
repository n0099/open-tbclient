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
    private boolean aNA;
    private InputMethodManager aNv;
    private EditText aNw;
    private TextView aNx;
    private TextView aNy;
    private ImageView aNz;
    private View agS;
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
        this.aNv = (InputMethodManager) getSystemService("input_method");
        sa();
        d(bundle);
        HN();
    }

    private void HN() {
        registerListener(new a(this, 304100));
    }

    private void d(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                this.Ai = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.aNw != null) {
                    if (!StringUtils.isNull(this.Ai)) {
                        this.aNw.setText(this.Ai);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.aNw.setText(String.valueOf(getString(y.my_name_is)) + TbadkApplication.getCurrentAccountName());
                        } else {
                            this.aNw.setText(String.valueOf(getString(y.i_am_come_from)) + stringExtra + getString(y.and_name_is) + TbadkApplication.getCurrentAccountName());
                        }
                    }
                    this.aNw.requestFocus();
                }
                this.portrait = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.name = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.aNA = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        this.Ai = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.aNw != null) {
            if (!StringUtils.isNull(this.Ai)) {
                this.aNw.setText(this.Ai);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.aNw.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.name = bundle.getString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.aNA = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.userId);
            if (this.aNw != null && !TextUtils.isEmpty(this.aNw.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.aNw.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.aNA);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ai);
        }
    }

    private void sa() {
        this.agS = findViewById(v.search_friend_parent);
        this.agS.setOnClickListener(new b(this));
        this.aNz = (ImageView) findViewById(v.cancle);
        this.aNz.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) findViewById(v.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getString(y.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNx = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(y.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.aNx.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(t.ds94);
        this.aNx.setLayoutParams(layoutParams);
        this.aNx.setBackgroundResource(u.btn_titlebar_finish);
        this.aNx.setOnClickListener(new d(this));
        this.aNy = (TextView) findViewById(v.search_friend_tip);
        this.aNw = (EditText) findViewById(v.search_friend_input);
        this.aNw.setOnFocusChangeListener(new e(this));
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
        ShowSoftKeyPad(this.aNv, this.aNw);
        this.aNw.setSelection(this.aNw.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.aNv, this.aNw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        getLayoutMode().h(this.agS);
        this.aNy.setTextColor(aw.getColor(s.cp_cont_c));
        this.aNx.setTextColor(aw.getColor(s.cp_cont_i));
        aw.h((View) this.aNx, u.btn_titlebar_finish);
    }
}
