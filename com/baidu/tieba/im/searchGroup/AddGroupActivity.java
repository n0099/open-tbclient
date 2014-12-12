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
    private b bmi = null;
    private SearchGroupModel bmj = null;
    private e bmk = new a(this, 103007);

    static {
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bmi = new b(this);
        this.bmj = new SearchGroupModel(this);
        registerListener(this.bmk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bmi.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bmi.Ss()) {
            finish();
        } else if (view == this.bmi.SH()) {
            i.B(getPageContext().getContext(), "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                he((String) view.getTag());
            }
        } else if (view == this.bmi.LE()) {
            this.bmi.SJ();
        } else if (view == this.bmi.SI()) {
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
        if (this.bmj != null) {
            this.bmj.cancelLoadData();
        }
    }

    public void he(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.bmi.cR(true);
                this.bmj.sendMessage(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bmi.cR(false);
                showToast(z.groupid_error);
                return;
            }
        }
        showToast(z.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
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
