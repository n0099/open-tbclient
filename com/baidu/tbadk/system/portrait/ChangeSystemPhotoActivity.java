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
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    private NavigationBar mNavigationBar = null;
    private TextView aAu = null;
    private View aAv = null;
    private BdGridView aAw = null;
    private LinearLayout mRootView = null;
    private h aAx = null;
    private ArrayList<i> aAy = null;
    private int aAz = -1;
    private a aAA = null;
    private com.baidu.adp.widget.a.a aAB = null;
    private String aAC = null;
    private boolean aAD = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aAE = new com.baidu.tbadk.system.portrait.a(this);

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
        this.aAv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aAv.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(i.h.choose_system_photo);
        this.aAu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.done));
        bu(false);
        this.aAu.setOnClickListener(new c(this));
        this.aAw = (BdGridView) findViewById(i.f.recommend_photos_list);
        this.aAx = new h(getPageContext());
        this.aAw.setAdapter((ListAdapter) this.aAx);
        this.aAw.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aAD = getIntent().getBooleanExtra("need_upload", true);
        this.aAy = new ArrayList<>();
        EE();
    }

    private void EE() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aAC = iVar.getUrl();
            if (this.aAD) {
                com.baidu.adp.lib.f.c.gZ().a(iVar.getUrl(), 10, this.aAE, 0, 0, getUniqueId(), new Object[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.aAC);
            setResult(-1, intent);
            finish();
        }
    }

    public void bu(boolean z) {
        if (z) {
            this.aAu.setClickable(true);
            al.h((View) this.aAu, i.e.blue_btn_down_selector);
            al.b(this.aAu, i.c.cp_cont_i, 1);
            return;
        }
        this.aAu.setClickable(false);
        al.h((View) this.aAu, i.e.btn_app_download_d);
        al.b(this.aAu, i.c.white_alpha40, 1);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.b(i.h.alert_no_button, new f(this));
        aVar.a(i.h.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aAz != -1) {
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
        al.h((View) this.aAu, i.e.btn_app_download_d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private v afT;

        private a() {
            this.afT = null;
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
            this.afT = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afT.d("pic", ChangeSystemPhotoActivity.this.aAB.nc());
                str = this.afT.tL();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afT.uj().va().qZ()) {
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
            ChangeSystemPhotoActivity.this.aAA = null;
            if (this.afT != null) {
                this.afT.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.afT != null) {
                if (this.afT.uj().va().qZ()) {
                    new n(ChangeSystemPhotoActivity.this.getPageContext()).dw(ChangeSystemPhotoActivity.this.getResources().getString(i.h.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aAC);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new n(ChangeSystemPhotoActivity.this.getPageContext()).dx(ChangeSystemPhotoActivity.this.getResources().getString(i.h.bubble_setdefualt_error));
            }
        }
    }
}
