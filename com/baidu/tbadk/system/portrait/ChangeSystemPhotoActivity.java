package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b aDD;
    private NavigationBar mNavigationBar = null;
    private TextView aDs = null;
    private View aDt = null;
    private BdGridView aDu = null;
    private LinearLayout aDv = null;
    private h aDw = null;
    private ArrayList<i> aDx = null;
    private int aDy = -1;
    private a aDz = null;
    private com.baidu.adp.widget.a.a aDA = null;
    private String aDB = null;
    private boolean aDC = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDE = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.change_system_photo_layout);
        pU();
        initData();
    }

    public void pU() {
        this.aDv = (LinearLayout) findViewById(t.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.aDt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aDt.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(t.j.choose_system_photo);
        this.aDs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDs.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.aDs.setLayoutParams(layoutParams);
        bN(false);
        at.k(this.aDs, t.f.s_navbar_button_bg);
        this.aDs.setOnClickListener(new c(this));
        this.aDu = (BdGridView) findViewById(t.g.recommend_photos_list);
        this.aDw = new h(getPageContext());
        this.aDu.setAdapter((ListAdapter) this.aDw);
        this.aDu.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aDC = getIntent().getBooleanExtra("need_upload", true);
        this.aDx = new ArrayList<>();
        Hk();
    }

    private void Hk() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aDB = iVar.getUrl();
            com.baidu.adp.lib.g.c.hr().a(iVar.getUrl(), 10, this.aDE, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bN(boolean z) {
        this.aDs.setEnabled(z);
        at.k(this.aDs, t.f.s_navbar_button_bg);
    }

    public void Hl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(t.j.enter_forum_cancel_change_tip);
        aVar.b(t.j.alert_no_button, new f(this));
        aVar.a(t.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).up();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aDy != -1) {
                Hl();
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
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.aDv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        at.k(this.aDs, t.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            m.b(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private ab aiW;

        private a() {
            this.aiW = null;
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
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.aiW.c("pic", ChangeSystemPhotoActivity.this.aDA.mN());
                str = this.aiW.vz();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiW.vU().wP().qC()) {
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
            ChangeSystemPhotoActivity.this.aDz = null;
            if (this.aiW != null) {
                this.aiW.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            if (this.aiW != null) {
                if (ChangeSystemPhotoActivity.this.aDD != null) {
                    ChangeSystemPhotoActivity.this.aDD.ay(false);
                }
                if (this.aiW.vU().wP().qC()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(t.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aDB);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h().d(ChangeSystemPhotoActivity.this.getResources().getString(t.j.bubble_setdefualt_error));
            }
        }
    }
}
