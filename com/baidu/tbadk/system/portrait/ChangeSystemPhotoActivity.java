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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aCT;
    private NavigationBar mNavigationBar = null;
    private TextView aCI = null;
    private View aCJ = null;
    private BdGridView aCK = null;
    private LinearLayout aCL = null;
    private h aCM = null;
    private ArrayList<i> aCN = null;
    private int aCO = -1;
    private a aCP = null;
    private com.baidu.adp.widget.a.a aCQ = null;
    private String aCR = null;
    private boolean aCS = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCU = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aCL = (LinearLayout) findViewById(r.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.aCJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aCJ.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(r.l.choose_system_photo);
        this.aCI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aCI.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.f.ds16);
        this.aCI.setLayoutParams(layoutParams);
        ca(false);
        ap.j((View) this.aCI, r.g.s_navbar_button_bg);
        ap.c(this.aCI, r.e.navbar_btn_color, 1);
        this.aCI.setOnClickListener(new c(this));
        this.aCK = (BdGridView) findViewById(r.h.recommend_photos_list);
        this.aCM = new h(getPageContext());
        this.aCK.setAdapter((ListAdapter) this.aCM);
        this.aCK.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aCS = getIntent().getBooleanExtra("need_upload", true);
        this.aCN = new ArrayList<>();
        Gd();
    }

    private void Gd() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aCR = iVar.getUrl();
            com.baidu.adp.lib.f.c.ey().a(iVar.getUrl(), 10, this.aCU, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void ca(boolean z) {
        this.aCI.setEnabled(z);
        ap.j((View) this.aCI, r.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(r.l.enter_forum_cancel_change_tip);
        aVar.b(r.l.alert_no_button, new f(this));
        aVar.a(r.l.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).sV();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aCO != -1) {
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
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.aCL);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.j((View) this.aCI, r.g.s_navbar_button_bg);
        ap.c(this.aCI, r.e.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            l.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private y mNetwork;

        private a() {
            this.mNetwork = null;
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
            this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aCQ.jW());
                str = this.mNetwork.ug();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.uC().vw().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aCP = null;
            if (this.mNetwork != null) {
                this.mNetwork.ee();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aCT != null) {
                    ChangeSystemPhotoActivity.this.aCT.aJ(false);
                }
                if (this.mNetwork.uC().vw().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(r.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aCR);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h().d(ChangeSystemPhotoActivity.this.getResources().getString(r.l.bubble_setdefualt_error));
            }
        }
    }
}
