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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aEw;
    private NavigationBar mNavigationBar = null;
    private TextView aEl = null;
    private View aEm = null;
    private BdGridView aEn = null;
    private LinearLayout aEo = null;
    private h aEp = null;
    private ArrayList<i> aEq = null;
    private int aEr = -1;
    private a aEs = null;
    private com.baidu.adp.widget.a.a aEt = null;
    private String aEu = null;
    private boolean aEv = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEx = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aEo = (LinearLayout) findViewById(t.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.aEm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aEm.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(t.j.choose_system_photo);
        this.aEl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEl.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), t.e.ds16);
        this.aEl.setLayoutParams(layoutParams);
        bX(false);
        av.k(this.aEl, t.f.s_navbar_button_bg);
        av.c(this.aEl, t.d.navbar_btn_color, 1);
        this.aEl.setOnClickListener(new c(this));
        this.aEn = (BdGridView) findViewById(t.g.recommend_photos_list);
        this.aEp = new h(getPageContext());
        this.aEn.setAdapter((ListAdapter) this.aEp);
        this.aEn.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aEv = getIntent().getBooleanExtra("need_upload", true);
        this.aEq = new ArrayList<>();
        GM();
    }

    private void GM() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aEu = iVar.getUrl();
            com.baidu.adp.lib.g.c.eA().a(iVar.getUrl(), 10, this.aEx, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bX(boolean z) {
        this.aEl.setEnabled(z);
        av.k(this.aEl, t.f.s_navbar_button_bg);
    }

    public void GN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(t.j.enter_forum_cancel_change_tip);
        aVar.b(t.j.alert_no_button, new f(this));
        aVar.a(t.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aEr != -1) {
                GN();
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
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.aEo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.aEl, t.f.s_navbar_button_bg);
        av.c(this.aEl, t.d.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            m.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private ab aiS;

        private a() {
            this.aiS = null;
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.aiS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.aiS.d("pic", ChangeSystemPhotoActivity.this.aEt.jY());
                str = this.aiS.uh();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiS.uD().vA().oE()) {
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
            ChangeSystemPhotoActivity.this.aEs = null;
            if (this.aiS != null) {
                this.aiS.eg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eu */
        public void onPostExecute(String str) {
            if (this.aiS != null) {
                if (ChangeSystemPhotoActivity.this.aEw != null) {
                    ChangeSystemPhotoActivity.this.aEw.aF(false);
                }
                if (this.aiS.uD().vA().oE()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(t.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aEu);
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
