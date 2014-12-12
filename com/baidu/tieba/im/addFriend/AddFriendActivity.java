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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class AddFriendActivity extends BaseActivity<AddFriendActivity> {
    private String Et;
    private InputMethodManager aPJ;
    private EditText aPK;
    private TextView aPL;
    private TextView aPM;
    private ImageView aPN;
    private boolean aPO;
    private View aoi;
    private NavigationBar mNavigationBar;
    private String name;
    private String portrait;
    private String st_type;
    private String userId;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_add_friend);
        this.aPJ = (InputMethodManager) getPageContext().getPageActivity().getSystemService("input_method");
        initViews();
        initData(bundle);
        JJ();
    }

    private void JJ() {
        registerListener(new a(this, 304100));
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.userId = intent.getStringExtra("user_id");
                this.Et = intent.getStringExtra(AddFriendActivityConfig.DEFAULT_MESSAGE);
                if (this.aPK != null) {
                    if (!StringUtils.isNull(this.Et)) {
                        this.aPK.setText(this.Et);
                    } else {
                        String stringExtra = intent.getStringExtra("from");
                        if (StringUtils.isNull(stringExtra)) {
                            this.aPK.setText(String.valueOf(getPageContext().getString(z.my_name_is)) + TbadkCoreApplication.getCurrentAccountName());
                        } else {
                            this.aPK.setText(String.valueOf(getPageContext().getString(z.i_am_come_from)) + stringExtra + getPageContext().getString(z.and_name_is) + TbadkCoreApplication.getCurrentAccountName());
                        }
                    }
                    this.aPK.requestFocus();
                }
                this.portrait = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.name = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.aPO = intent.getBooleanExtra(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
                this.st_type = intent.getStringExtra("st_type");
                return;
            }
            return;
        }
        this.userId = bundle.getString("user_id");
        this.Et = bundle.getString(AddFriendActivityConfig.DEFAULT_MESSAGE);
        if (this.aPK != null) {
            if (!StringUtils.isNull(this.Et)) {
                this.aPK.setText(this.Et);
            } else {
                String string = bundle.getString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(string)) {
                    this.aPK.setText(string);
                }
            }
        }
        this.portrait = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.name = bundle.getString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.aPO = bundle.getBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, false);
        this.st_type = bundle.getString("st_type");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("user_id", this.userId);
            if (this.aPK != null && !TextUtils.isEmpty(this.aPK.getText().toString())) {
                bundle.putString(AddFriendActivityConfig.MSG, this.aPK.getText().toString());
            }
            bundle.putBoolean(AddFriendActivityConfig.IS_USER_CLIENT_LOWER, this.aPO);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, this.name);
            bundle.putString("st_type", this.st_type);
            bundle.putString(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Et);
        }
    }

    private void initViews() {
        this.aoi = getPageContext().getPageActivity().findViewById(w.search_friend_parent);
        this.aoi.setOnClickListener(new b(this));
        this.aPN = (ImageView) getPageContext().getPageActivity().findViewById(w.cancle);
        this.aPN.setOnClickListener(new c(this));
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(w.search_friend_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getPageActivity().getString(z.apply_new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aPL = this.mNavigationBar.addRightButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(z.group_apply_send));
        ViewGroup.LayoutParams layoutParams = this.aPL.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(u.ds94);
        this.aPL.setLayoutParams(layoutParams);
        this.aPL.setBackgroundResource(v.btn_titlebar_finish);
        this.aPL.setOnClickListener(new d(this));
        this.aPM = (TextView) getPageContext().getPageActivity().findViewById(w.search_friend_tip);
        this.aPK = (EditText) getPageContext().getPageActivity().findViewById(w.search_friend_input);
        this.aPK.setOnFocusChangeListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.portrait)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestNewFriendActionLocalMessage(com.baidu.adp.lib.g.c.a(this.userId, 0L), this.name, this.portrait, TextUtils.isEmpty(str) ? String.valueOf(getPageContext().getPageActivity().getString(z.my_name_is)) + TbadkCoreApplication.getCurrentAccountName() : str, this.st_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.aPJ, this.aPK);
        this.aPK.setSelection(this.aPK.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HidenSoftKeyPad(this.aPJ, this.aPK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().h(this.aoi);
        this.aPM.setTextColor(ax.getColor(t.cp_cont_c));
        this.aPL.setTextColor(ax.getColor(t.cp_cont_i));
        ax.i((View) this.aPL, v.btn_titlebar_finish);
    }
}
