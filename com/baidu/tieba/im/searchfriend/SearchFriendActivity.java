package com.baidu.tieba.im.searchfriend;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.message.ResponseSearchFriendMessage;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity {
    private InputMethodManager a;
    private View b;
    private NavigationBar c;
    private EditText d;
    private TextView e;
    private TextView f;
    private View g;
    private HttpMessageListener h = new a(this, 1001521);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bj.class, SearchFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_search_friend);
        this.a = (InputMethodManager) getSystemService("input_method");
        a();
        b();
        com.baidu.tbadk.core.f.b(TbadkApplication.m252getInst().getApplicationContext(), "add_new");
    }

    private void a() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001521, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.h);
    }

    private void b() {
        this.b = findViewById(v.search_friend_parent);
        this.b.setOnClickListener(new b(this));
        this.c = (NavigationBar) findViewById(v.search_friend_navigation_bar);
        this.c.a(getString(y.add_new_friends));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (TextView) findViewById(v.search_friend_tip);
        this.d = (EditText) findViewById(v.search_friend_input);
        this.d.setOnFocusChangeListener(new c(this));
        this.d.addTextChangedListener(new d(this));
        this.d.requestFocus();
        this.e = (TextView) findViewById(v.search_friend_btn);
        this.e.setOnClickListener(new e(this));
        this.g = findViewById(v.search_friend_delete_button);
        this.g.setOnClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        HttpMessage httpMessage = new HttpMessage(1001521);
        httpMessage.setTag(1001521);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ShowSoftKeyPad(this.a, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        getLayoutMode().a(this.b);
        this.f.setTextColor(getResources().getColor(i == 1 ? s.cp_cont_c_1 : s.cp_cont_c));
    }
}
