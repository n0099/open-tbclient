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
    private TextView ayM = null;
    private View ayN = null;
    private BdGridView ayO = null;
    private LinearLayout mRootView = null;
    private h ayP = null;
    private ArrayList<i> ayQ = null;
    private int ayR = -1;
    private a ayS = null;
    private com.baidu.adp.widget.a.a ayT = null;
    private String ayU = null;
    private boolean ayV = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> ayW = new com.baidu.tbadk.system.portrait.a(this);

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
        this.ayN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ayN.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(i.C0057i.choose_system_photo);
        this.ayM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.done));
        bn(false);
        this.ayM.setOnClickListener(new c(this));
        this.ayO = (BdGridView) findViewById(i.f.recommend_photos_list);
        this.ayP = new h(getPageContext());
        this.ayO.setAdapter((ListAdapter) this.ayP);
        this.ayO.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.ayV = getIntent().getBooleanExtra("need_upload", true);
        this.ayQ = new ArrayList<>();
        Eu();
    }

    private void Eu() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.ayU = iVar.getUrl();
            if (this.ayV) {
                com.baidu.adp.lib.f.c.hc().a(iVar.getUrl(), 10, this.ayW, 0, 0, getUniqueId(), new Object[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.ayU);
            setResult(-1, intent);
            finish();
        }
    }

    public void bn(boolean z) {
        if (z) {
            this.ayM.setClickable(true);
            al.i((View) this.ayM, i.e.blue_btn_down_selector);
            al.b(this.ayM, i.c.cp_cont_i, 1);
            return;
        }
        this.ayM.setClickable(false);
        al.i((View) this.ayM, i.e.btn_app_download_d);
        al.b(this.ayM, i.c.white_alpha40, 1);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bC(i.C0057i.enter_forum_cancel_change_tip);
        aVar.b(i.C0057i.alert_no_button, new f(this));
        aVar.a(i.C0057i.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sP();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ayR != -1) {
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
        al.i((View) this.ayM, i.e.btn_app_download_d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private v afJ;

        private a() {
            this.afJ = null;
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
            this.afJ = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afJ.d("pic", ChangeSystemPhotoActivity.this.ayT.nf());
                str = this.afJ.tG();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afJ.ue().uW().rb()) {
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
            ChangeSystemPhotoActivity.this.ayS = null;
            if (this.afJ != null) {
                this.afJ.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.afJ != null) {
                if (this.afJ.ue().uW().rb()) {
                    new n(ChangeSystemPhotoActivity.this.getPageContext()).dp(ChangeSystemPhotoActivity.this.getResources().getString(i.C0057i.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.ayU);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new n(ChangeSystemPhotoActivity.this.getPageContext()).dq(ChangeSystemPhotoActivity.this.getResources().getString(i.C0057i.bubble_setdefualt_error));
            }
        }
    }
}
