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
    com.baidu.tbadk.core.view.b aAi;
    private NavigationBar mNavigationBar = null;
    private TextView azY = null;
    private View azZ = null;
    private BdGridView aAa = null;
    private LinearLayout mRootView = null;
    private h aAb = null;
    private ArrayList<i> aAc = null;
    private int aAd = -1;
    private a aAe = null;
    private com.baidu.adp.widget.a.a aAf = null;
    private String aAg = null;
    private boolean aAh = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAj = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mRootView = (LinearLayout) findViewById(n.f.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.azZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.azZ.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(n.i.choose_system_photo);
        this.azY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azY.getLayoutParams();
        layoutParams.rightMargin = k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.azY.setLayoutParams(layoutParams);
        bE(false);
        as.i((View) this.azY, n.e.s_navbar_button_bg);
        this.azY.setOnClickListener(new c(this));
        this.aAa = (BdGridView) findViewById(n.f.recommend_photos_list);
        this.aAb = new h(getPageContext());
        this.aAa.setAdapter((ListAdapter) this.aAb);
        this.aAa.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aAh = getIntent().getBooleanExtra("need_upload", true);
        this.aAc = new ArrayList<>();
        Fj();
    }

    private void Fj() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aAg = iVar.getUrl();
            com.baidu.adp.lib.g.c.hd().a(iVar.getUrl(), 10, this.aAj, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bE(boolean z) {
        this.azY.setEnabled(z);
        as.i((View) this.azY, n.e.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bN(n.i.enter_forum_cancel_change_tip);
        aVar.b(n.i.alert_no_button, new f(this));
        aVar.a(n.i.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).tv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aAd != -1) {
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
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        as.i((View) this.azY, n.e.s_navbar_button_bg);
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
        private ab agS;

        private a() {
            this.agS = null;
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
            this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.agS.d("pic", ChangeSystemPhotoActivity.this.aAf.nj());
                str = this.agS.uo();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.agS.uM().vG().rf()) {
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
            ChangeSystemPhotoActivity.this.aAe = null;
            if (this.agS != null) {
                this.agS.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.agS != null) {
                if (ChangeSystemPhotoActivity.this.aAi != null) {
                    ChangeSystemPhotoActivity.this.aAi.ay(false);
                }
                if (this.agS.uM().vG().rf()) {
                    new com.baidu.tbadk.core.view.g(ChangeSystemPhotoActivity.this.getPageContext()).d(ChangeSystemPhotoActivity.this.getResources().getString(n.i.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aAg);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.g(ChangeSystemPhotoActivity.this.getPageContext()).e(ChangeSystemPhotoActivity.this.getResources().getString(n.i.bubble_setdefualt_error));
            }
        }
    }
}
