package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tieba.ai;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.model.an;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AddGroupActivity extends com.baidu.tieba.f {
    private b a = null;
    private an b = null;
    private com.baidu.tieba.im.messageCenter.g c = new a(this);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AddGroupActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntent();
        this.a = new b(this);
        this.b = new an();
        com.baidu.tieba.im.messageCenter.d.a().a(103007, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.e()) {
            finish();
        } else if (view == this.a.d()) {
            ai.a(this, "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                    showToast(R.string.please_input_groupid);
                    return;
                }
                try {
                    this.a.a(true);
                    an anVar = this.b;
                    an.a(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    this.a.a(false);
                    showToast(R.string.groupid_error);
                }
            }
        } else if (view == this.a.a()) {
            this.a.f();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        com.baidu.tieba.im.messageCenter.d.a().a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AddGroupActivity addGroupActivity, BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            GroupInfoActivity.a(addGroupActivity, baseGroupData.getGroupId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AddGroupActivity addGroupActivity, String str, int i) {
        if (i < 0) {
            addGroupActivity.showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            addGroupActivity.showToast(str);
        }
    }
}
