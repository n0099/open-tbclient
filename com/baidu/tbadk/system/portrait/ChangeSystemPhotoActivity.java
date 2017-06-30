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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aJN;
    private NavigationBar mNavigationBar = null;
    private TextView aJC = null;
    private View aJD = null;
    private BdGridView aJE = null;
    private LinearLayout aJF = null;
    private h aJG = null;
    private ArrayList<i> aJH = null;
    private int aJI = -1;
    private a aJJ = null;
    private com.baidu.adp.widget.a.a aJK = null;
    private String aJL = null;
    private boolean aJM = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aJO = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aJF = (LinearLayout) findViewById(w.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aJD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aJD.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(w.l.choose_system_photo);
        this.aJC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJC.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.aJC.setLayoutParams(layoutParams);
        cb(false);
        as.j(this.aJC, w.g.s_navbar_button_bg);
        as.c(this.aJC, w.e.navbar_btn_color, 1);
        this.aJC.setOnClickListener(new c(this));
        this.aJE = (BdGridView) findViewById(w.h.recommend_photos_list);
        this.aJG = new h(getPageContext());
        this.aJE.setAdapter((ListAdapter) this.aJG);
        this.aJE.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aJM = getIntent().getBooleanExtra("need_upload", true);
        this.aJH = new ArrayList<>();
        Gw();
    }

    private void Gw() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aJL = iVar.getUrl();
            com.baidu.adp.lib.f.c.fL().a(iVar.getUrl(), 10, this.aJO, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void cb(boolean z) {
        this.aJC.setEnabled(z);
        as.j(this.aJC, w.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.enter_forum_cancel_change_tip);
        aVar.b(w.l.alert_no_button, new f(this));
        aVar.a(w.l.confirm, new g(this));
        aVar.b(getPageContext()).ta();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aJI != -1) {
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
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aJF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        as.j(this.aJC, w.g.s_navbar_button_bg);
        as.c(this.aJC, w.e.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            n.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private ab mNetwork;

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
            this.mNetwork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aJK.kS());
                str = this.mNetwork.uA();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.uV().vS().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aJJ = null;
            if (this.mNetwork != null) {
                this.mNetwork.fr();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aJN != null) {
                    ChangeSystemPhotoActivity.this.aJN.aI(false);
                }
                if (this.mNetwork.uV().vS().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(w.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aJL);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h().d(ChangeSystemPhotoActivity.this.getResources().getString(w.l.bubble_setdefualt_error));
            }
        }
    }
}
