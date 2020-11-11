package com.baidu.tieba;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
/* loaded from: classes22.dex */
public class SelectForumActivity extends SuspendedActivity {
    private CustomMessageListener fPC = new CustomMessageListener(2921503) { // from class: com.baidu.tieba.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                SelectForumActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fPD = new CustomMessageListener(2921507) { // from class: com.baidu.tieba.SelectForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                Toast.makeText(SelectForumActivity.this, (String) customResponsedMessage.getData(), 1).show();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fPC);
        registerListener(this.fPD);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        return new f(getPageContext(), linearLayout, navigationBar);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bCX() {
    }
}
