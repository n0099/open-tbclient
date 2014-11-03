package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.j;
import com.baidu.tieba.im.model.SearchGroupModel;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AddGroupActivity extends BaseActivity {
    private b bhG = null;
    private SearchGroupModel bhH = null;
    private e bhI = new a(this, 103007);

    public static void k(Activity activity) {
        activity.startActivity(new Intent(activity, AddGroupActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bhG = new b(this);
        this.bhH = new SearchGroupModel(this);
        registerListener(this.bhI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bhG.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bhG.Rv()) {
            finish();
        } else if (view == this.bhG.Ru()) {
            j.l(this, "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                gA((String) view.getTag());
            }
        } else if (view == this.bhG.LF()) {
            this.bhG.Rw();
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
        if (this.bhH != null) {
            this.bhH.cancelLoadData();
        }
    }

    public void gA(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.bhG.da(true);
                this.bhH.sendMessage(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bhG.da(false);
                showToast(y.groupid_error);
                return;
            }
        }
        showToast(y.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        showToast(y.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(this, baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, int i) {
        if (i < 0) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }
}
