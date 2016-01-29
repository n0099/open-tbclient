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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b aCF;
    private NavigationBar mNavigationBar = null;
    private TextView aCu = null;
    private View aCv = null;
    private BdGridView aCw = null;
    private LinearLayout aCx = null;
    private h aCy = null;
    private ArrayList<i> aCz = null;
    private int aCA = -1;
    private a aCB = null;
    private com.baidu.adp.widget.a.a aCC = null;
    private String aCD = null;
    private boolean aCE = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aCG = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.change_system_photo_layout);
        qD();
        initData();
    }

    public void qD() {
        this.aCx = (LinearLayout) findViewById(t.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.aCv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aCv.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(t.j.choose_system_photo);
        this.aCu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aCu.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.aCu.setLayoutParams(layoutParams);
        bF(false);
        ar.k(this.aCu, t.f.s_navbar_button_bg);
        this.aCu.setOnClickListener(new c(this));
        this.aCw = (BdGridView) findViewById(t.g.recommend_photos_list);
        this.aCy = new h(getPageContext());
        this.aCw.setAdapter((ListAdapter) this.aCy);
        this.aCw.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aCE = getIntent().getBooleanExtra("need_upload", true);
        this.aCz = new ArrayList<>();
        Go();
    }

    private void Go() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aCD = iVar.getUrl();
            com.baidu.adp.lib.g.c.hl().a(iVar.getUrl(), 10, this.aCG, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bF(boolean z) {
        this.aCu.setEnabled(z);
        ar.k(this.aCu, t.f.s_navbar_button_bg);
    }

    public void Gp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(t.j.enter_forum_cancel_change_tip);
        aVar.b(t.j.alert_no_button, new f(this));
        aVar.a(t.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).uj();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aCA != -1) {
                Gp();
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
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.aCx);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ar.k(this.aCu, t.f.s_navbar_button_bg);
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
        private aa aiG;

        private a() {
            this.aiG = null;
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
            this.aiG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.aiG.d("pic", ChangeSystemPhotoActivity.this.aCC.mV());
                str = this.aiG.vc();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiG.vB().ww().rl()) {
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
            ChangeSystemPhotoActivity.this.aCB = null;
            if (this.aiG != null) {
                this.aiG.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            if (this.aiG != null) {
                if (ChangeSystemPhotoActivity.this.aCF != null) {
                    ChangeSystemPhotoActivity.this.aCF.aw(false);
                }
                if (this.aiG.vB().ww().rl()) {
                    new com.baidu.tbadk.core.view.h(ChangeSystemPhotoActivity.this.getPageContext()).c(ChangeSystemPhotoActivity.this.getResources().getString(t.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aCD);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h(ChangeSystemPhotoActivity.this.getPageContext()).d(ChangeSystemPhotoActivity.this.getResources().getString(t.j.bubble_setdefualt_error));
            }
        }
    }
}
