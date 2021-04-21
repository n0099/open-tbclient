package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import d.b.c.e.p.l;
import d.b.j0.i;
/* loaded from: classes4.dex */
public class SelectForumActivity extends SuspendedActivity {
    public CustomMessageListener mCloseListener = new a(2921503);
    public CustomMessageListener mPermissionsListener = new b(2921507);
    public i selectForumView;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            SelectForumActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = SelectForumActivity.this.getString(R.string.activity_select_forum_error);
                }
                l.L(SelectForumActivity.this, str);
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.b.i0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        if (this.selectForumView == null) {
            this.selectForumView = new i(getPageContext(), linearLayout, navigationBar);
        }
        return this.selectForumView;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mCloseListener);
        registerListener(this.mPermissionsListener);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.selectForumView;
        if (iVar != null) {
            iVar.j();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }
}
