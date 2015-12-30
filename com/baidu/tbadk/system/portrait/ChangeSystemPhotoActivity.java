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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b aBP;
    private NavigationBar mNavigationBar = null;
    private TextView aBF = null;
    private View aBG = null;
    private BdGridView aBH = null;
    private LinearLayout mRootView = null;
    private h aBI = null;
    private ArrayList<i> aBJ = null;
    private int aBK = -1;
    private a aBL = null;
    private com.baidu.adp.widget.a.a aBM = null;
    private String aBN = null;
    private boolean aBO = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBQ = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mRootView = (LinearLayout) findViewById(n.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.aBG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aBG.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(n.j.choose_system_photo);
        this.aBF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBF.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.aBF.setLayoutParams(layoutParams);
        bE(false);
        as.i((View) this.aBF, n.f.s_navbar_button_bg);
        this.aBF.setOnClickListener(new c(this));
        this.aBH = (BdGridView) findViewById(n.g.recommend_photos_list);
        this.aBI = new h(getPageContext());
        this.aBH.setAdapter((ListAdapter) this.aBI);
        this.aBH.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aBO = getIntent().getBooleanExtra("need_upload", true);
        this.aBJ = new ArrayList<>();
        EX();
    }

    private void EX() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aBN = iVar.getUrl();
            com.baidu.adp.lib.g.c.hd().a(iVar.getUrl(), 10, this.aBQ, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bE(boolean z) {
        this.aBF.setEnabled(z);
        as.i((View) this.aBF, n.f.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bG(n.j.enter_forum_cancel_change_tip);
        aVar.b(n.j.alert_no_button, new f(this));
        aVar.a(n.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).tf();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aBK != -1) {
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
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        as.i((View) this.aBF, n.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.n.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private ab ahV;

        private a() {
            this.ahV = null;
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
            this.ahV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.ahV.d("pic", ChangeSystemPhotoActivity.this.aBM.mH());
                str = this.ahV.tY();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.ahV.uw().vq().qO()) {
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
            ChangeSystemPhotoActivity.this.aBL = null;
            if (this.ahV != null) {
                this.ahV.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.ahV != null) {
                if (ChangeSystemPhotoActivity.this.aBP != null) {
                    ChangeSystemPhotoActivity.this.aBP.av(false);
                }
                if (this.ahV.uw().vq().qO()) {
                    new com.baidu.tbadk.core.view.h(ChangeSystemPhotoActivity.this.getPageContext()).c(ChangeSystemPhotoActivity.this.getResources().getString(n.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aBN);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h(ChangeSystemPhotoActivity.this.getPageContext()).d(ChangeSystemPhotoActivity.this.getResources().getString(n.j.bubble_setdefualt_error));
            }
        }
    }
}
