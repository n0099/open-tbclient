package com.baidu.tieba.discover.memberprivilege;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class MemberPrivilegeActivity extends BaseActivity {
    private f a;
    private HttpMessageListener b = new a(this, CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
    private final CustomMessageListener c = new b(this, 2001200);

    static {
        TbadkApplication.m252getInst().RegisterIntent(au.class, MemberPrivilegeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        registerListener(this.c);
        registerListener(this.b);
        a();
    }

    private void b() {
        this.a = new f(this);
    }

    private void c() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PRIVILEGE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MEMBER_PRIVILEGE);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a() {
        showLoadingDialog(getString(x.flist_loading));
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "shop");
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0) {
            String str = ((i) this.a.a().getItem(i)).d;
            String str2 = ((i) this.a.a().getItem(i)).b;
            if (!ba.c(str)) {
                if (str.contains("type=1")) {
                    sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.f(this)));
                } else {
                    TbWebViewActivity.startActivity(this, str2, str, true, false, true, true, null);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        sendMessage(new CustomMessage(2002001, new at(this, 0, "pay")));
    }
}
