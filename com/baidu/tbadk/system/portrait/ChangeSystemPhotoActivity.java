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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    private NavigationBar mNavigationBar = null;
    private TextView azg = null;
    private View azh = null;
    private BdGridView azi = null;
    private LinearLayout mRootView = null;
    private h azj = null;
    private ArrayList<i> azk = null;
    private int azl = -1;
    private a azm = null;
    private com.baidu.adp.widget.a.a azn = null;
    private String azo = null;
    private boolean azp = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azq = new com.baidu.tbadk.system.portrait.a(this);

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
        this.azh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.azh.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(i.h.choose_system_photo);
        this.azg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azg.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.azg.setLayoutParams(layoutParams);
        bs(false);
        an.i((View) this.azg, i.e.s_navbar_button_bg);
        this.azg.setOnClickListener(new c(this));
        this.azi = (BdGridView) findViewById(i.f.recommend_photos_list);
        this.azj = new h(getPageContext());
        this.azi.setAdapter((ListAdapter) this.azj);
        this.azi.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.azp = getIntent().getBooleanExtra("need_upload", true);
        this.azk = new ArrayList<>();
        Eo();
    }

    private void Eo() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.azo = iVar.getUrl();
            if (this.azp) {
                com.baidu.adp.lib.f.c.ha().a(iVar.getUrl(), 10, this.azq, 0, 0, getUniqueId(), new Object[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.azo);
            setResult(-1, intent);
            finish();
        }
    }

    public void bs(boolean z) {
        this.azg.setEnabled(z);
        an.i((View) this.azg, i.e.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.enter_forum_cancel_change_tip);
        aVar.b(i.h.alert_no_button, new f(this));
        aVar.a(i.h.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sO();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.azl != -1) {
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
        an.i((View) this.azg, i.e.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private w afh;

        private a() {
            this.afh = null;
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
            this.afh = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afh.d("pic", ChangeSystemPhotoActivity.this.azn.nd());
                str = this.afh.tG();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afh.ue().uW().qS()) {
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
            ChangeSystemPhotoActivity.this.azm = null;
            if (this.afh != null) {
                this.afh.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.afh != null) {
                if (this.afh.ue().uW().qS()) {
                    new com.baidu.tbadk.core.view.f(ChangeSystemPhotoActivity.this.getPageContext()).dA(ChangeSystemPhotoActivity.this.getResources().getString(i.h.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.azo);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.f(ChangeSystemPhotoActivity.this.getPageContext()).dB(ChangeSystemPhotoActivity.this.getResources().getString(i.h.bubble_setdefualt_error));
            }
        }
    }
}
