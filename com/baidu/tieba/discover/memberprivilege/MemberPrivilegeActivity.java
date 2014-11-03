package com.baidu.tieba.discover.memberprivilege;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import java.util.Map;
/* loaded from: classes.dex */
public class MemberPrivilegeActivity extends BaseActivity {
    private n apF;
    private HttpMessageListener apG = new g(this, CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
    private final CustomMessageListener mMemListener = new h(this, 2001200);
    private final CustomMessageListener Ux = new i(this, 2001233);

    static {
        TbadkApplication.m251getInst().RegisterIntent(MemberPrivilegeActivityConfig.class, MemberPrivilegeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AY();
        registerListener(this.mMemListener);
        registerListener(this.Ux);
        registerListener(this.apG);
        initUI();
        AZ();
    }

    private void initUI() {
        this.apF = new n(this);
    }

    private void AY() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PRIVILEGE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MEMBER_PRIVILEGE);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void AZ() {
        showLoadingDialog(getString(y.flist_loading));
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
        httpMessage.addParam("st_type", "shop");
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.apF.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0 && 1 != this.apF.Ba().getItemViewType(i)) {
            String str = ((b) this.apF.Ba().getItem(i)).abu;
            String str2 = ((b) this.apF.Ba().getItem(i)).mTitle;
            if (!az.aA(str)) {
                if (eE(str)) {
                    sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(this)));
                } else {
                    TbWebViewActivity.startActivity(this, str2, str, true, false, true, true, null);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (v.left_button == view.getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this, 0, "pay")));
        } else if (v.right_button == view.getId()) {
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(this, 0)));
        }
    }

    private boolean eE(String str) {
        Map<String, String> bT;
        return (TextUtils.isEmpty(str) || (bT = bg.bT(bg.bU(str))) == null || !"1".equals(bT.get("type"))) ? false : true;
    }
}
