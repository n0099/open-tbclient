package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.listener.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.z;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.f;
import com.baidu.tieba.im.model.az;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class AddGroupActivity extends BaseActivity {
    private b a = null;
    private az b = null;
    private d c = new a(this, 103007);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AddGroupActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new b(this);
        this.b = new az(this);
        registerListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.c()) {
            finish();
        } else if (view == this.a.b()) {
            f.a(this, "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                a((String) view.getTag());
            }
        } else if (view == this.a.a()) {
            this.a.d();
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
        if (this.b != null) {
            this.b.cancelLoadData();
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.a.a(true);
                this.b.a(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.a.a(false);
                showToast(x.groupid_error);
                return;
            }
        }
        showToast(x.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        showToast(x.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new z(this, baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(x.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }
}
