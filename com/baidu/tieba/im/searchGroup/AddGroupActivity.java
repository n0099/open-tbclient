package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.im.model.SearchGroupModel;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    private b bmi = null;
    private SearchGroupModel bmj = null;
    private e bmk = new a(this, 103007);

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
        if (view == this.bmi.Th()) {
            finish();
        } else if (view == this.bmi.Tg()) {
            k.A(getPageContext().getContext(), "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                gO((String) view.getTag());
            }
        } else if (view == this.bmi.OT()) {
            this.bmi.Tj();
        } else if (view == this.bmi.Ti()) {
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

    public void gO(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.bmi.cK(true);
                this.bmj.sendMessage(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bmi.cK(false);
                showToast(y.groupid_error);
                return;
            }
        }
        showToast(y.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        showToast(y.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, int i) {
        if (i < 0) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        } else {
            showToast(getResources().getString(y.neterror));
        }
    }
}
