package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    private NavigationBar mNavigationBar = null;
    private TextView ayV = null;
    private View ayW = null;
    private BdGridView ayX = null;
    private LinearLayout mRootView = null;
    private h ayY = null;
    private ArrayList<i> ayZ = null;
    private int aza = -1;
    private a azb = null;
    private com.baidu.adp.widget.a.a azc = null;
    private String azd = null;
    private boolean aze = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azf = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mRootView = (LinearLayout) findViewById(i.f.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.ayW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ayW.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(i.h.choose_system_photo);
        this.ayV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayV.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.ayV.setLayoutParams(layoutParams);
        bs(false);
        am.i((View) this.ayV, i.e.s_navbar_button_bg);
        this.ayV.setOnClickListener(new c(this));
        this.ayX = (BdGridView) findViewById(i.f.recommend_photos_list);
        this.ayY = new h(getPageContext());
        this.ayX.setAdapter((ListAdapter) this.ayY);
        this.ayX.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aze = getIntent().getBooleanExtra("need_upload", true);
        this.ayZ = new ArrayList<>();
        Es();
    }

    private void Es() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.azd = iVar.getUrl();
            if (this.aze) {
                com.baidu.adp.lib.f.c.ha().a(iVar.getUrl(), 10, this.azf, 0, 0, getUniqueId(), new Object[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.azd);
            setResult(-1, intent);
            finish();
        }
    }

    public void bs(boolean z) {
        this.ayV.setEnabled(z);
        am.i((View) this.ayV, i.e.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.b(i.h.alert_no_button, new f(this));
        aVar.a(i.h.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sR();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aza != -1) {
                showDialog();
            } else {
                setResult(0);
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.i((View) this.ayV, i.e.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private w afg;

        private a() {
            this.afg = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ChangeSystemPhotoActivity changeSystemPhotoActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.afg = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afg.d("pic", ChangeSystemPhotoActivity.this.azc.nd());
                str = this.afg.tJ();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afg.uh().uY().qV()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ChangeSystemPhotoActivity.this.azb = null;
            if (this.afg != null) {
                this.afg.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.afg != null) {
                if (this.afg.uh().uY().qV()) {
                    new com.baidu.tbadk.core.view.f(ChangeSystemPhotoActivity.this.getPageContext()).dA(ChangeSystemPhotoActivity.this.getResources().getString(i.h.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.azd);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.f(ChangeSystemPhotoActivity.this.getPageContext()).dB(ChangeSystemPhotoActivity.this.getResources().getString(i.h.bubble_setdefualt_error));
            }
        }
    }
}
