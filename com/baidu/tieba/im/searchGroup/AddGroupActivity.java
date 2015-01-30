package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.i;
import com.baidu.tieba.im.model.SearchGroupModel;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    private b bnF = null;
    private SearchGroupModel bnG = null;
    private e bnH = new a(this, 103007);

    static {
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bnF = new b(this);
        this.bnG = new SearchGroupModel(this);
        registerListener(this.bnH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bnF.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bnF.SO()) {
            finish();
        } else if (view == this.bnF.Td()) {
            i.A(getPageContext().getContext(), "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                hj((String) view.getTag());
            }
        } else if (view == this.bnF.LZ()) {
            this.bnF.Tf();
        } else if (view == this.bnF.Te()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902030, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        if (this.bnG != null) {
            this.bnG.cancelLoadData();
        }
    }

    public void hj(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.bnF.cW(true);
                this.bnG.sendMessage(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bnF.cW(false);
                showToast(z.groupid_error);
                return;
            }
        }
        showToast(z.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tc() {
        showToast(z.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i) {
        if (i < 0) {
            showToast(z.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }
}
