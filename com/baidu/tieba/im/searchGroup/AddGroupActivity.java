package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.core.b.o;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tieba.im.model.bp;
/* loaded from: classes.dex */
public class AddGroupActivity extends com.baidu.tbadk.a {
    private b a = null;
    private bp b = null;
    private com.baidu.adp.framework.c.g c = new a(this, 103007);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AddGroupActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntent();
        this.a = new b(this);
        this.b = new bp();
        registerListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
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
            com.baidu.tbadk.core.g.a(this, "add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                    showToast(com.baidu.tieba.im.j.please_input_groupid);
                    return;
                }
                try {
                    this.a.a(true);
                    this.b.a(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    this.a.a(false);
                    showToast(com.baidu.tieba.im.j.groupid_error);
                }
            }
        } else if (view == this.a.a()) {
            this.a.f();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AddGroupActivity addGroupActivity, BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            addGroupActivity.sendMessage(new com.baidu.adp.framework.message.a(2008011, new o(addGroupActivity, baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AddGroupActivity addGroupActivity, String str, int i) {
        if (i < 0) {
            addGroupActivity.showToast(com.baidu.tieba.im.j.neterror);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            addGroupActivity.showToast(str);
        }
    }
}
