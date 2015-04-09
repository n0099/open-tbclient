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
    private b bmy = null;
    private SearchGroupModel bmz = null;
    private e bmA = new a(this, 103007);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bmy = new b(this);
        this.bmz = new SearchGroupModel(this);
        registerListener(this.bmA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bmy.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bmy.Tu()) {
            finish();
        } else if (view == this.bmy.Tt()) {
            k.A(getPageContext().getContext(), "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                gR((String) view.getTag());
            }
        } else if (view == this.bmy.Pg()) {
            this.bmy.Tw();
        } else if (view == this.bmy.Tv()) {
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
        if (this.bmz != null) {
            this.bmz.cancelLoadData();
        }
    }

    public void gR(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.bmy.cI(true);
                this.bmz.sendMessage(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bmy.cI(false);
                showToast(y.groupid_error);
                return;
            }
        }
        showToast(y.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
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
