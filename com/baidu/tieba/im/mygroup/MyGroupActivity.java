package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.j;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MyGroupActivity extends BaseFragmentActivity implements View.OnClickListener, com.baidu.tieba.im.messageCenter.g {
    private i b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new i(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103008, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.b.a(i);
    }

    public static void a(Context context) {
        if (context != null) {
            if (!TiebaApplication.C()) {
                if (context instanceof j) {
                    ((j) context).showToast(R.string.not_login_text);
                    return;
                } else if (context instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) context).b(R.string.not_login_text);
                    return;
                } else {
                    return;
                }
            }
            context.startActivity(new Intent(context, MyGroupActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null && view.getId() == this.b.e()) {
            a((String) null);
            RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
            requestUserPermissionMessage.setForumId(0L);
            com.baidu.tieba.im.messageCenter.e.a().a(requestUserPermissionMessage);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message != null) {
            switch (message.getCmd()) {
                case 103008:
                    try {
                        if (message instanceof ResponseUserPermissionMessage) {
                            ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) message;
                            if (responseUserPermissionMessage.hasError()) {
                                b(responseUserPermissionMessage.getErrMsg());
                                return;
                            }
                            GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                            if (groupPermData != null) {
                                if (groupPermData.isCreatePersonal()) {
                                    CreateGroupStepActivity.a(this, 2, 0, 1012);
                                } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                                    b(groupPermData.getCreatePersonalTip());
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    } finally {
                        b();
                    }
                default:
                    return;
            }
        }
    }
}
