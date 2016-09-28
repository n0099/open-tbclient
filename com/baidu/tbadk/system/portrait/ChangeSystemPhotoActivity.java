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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aDU;
    private NavigationBar mNavigationBar = null;
    private TextView aDJ = null;
    private View aDK = null;
    private BdGridView aDL = null;
    private LinearLayout aDM = null;
    private h aDN = null;
    private ArrayList<i> aDO = null;
    private int aDP = -1;
    private a aDQ = null;
    private com.baidu.adp.widget.a.a aDR = null;
    private String aDS = null;
    private boolean aDT = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDV = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aDM = (LinearLayout) findViewById(r.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.aDK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aDK.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(r.j.choose_system_photo);
        this.aDJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDJ.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.e.ds16);
        this.aDJ.setLayoutParams(layoutParams);
        bW(false);
        av.k(this.aDJ, r.f.s_navbar_button_bg);
        av.c(this.aDJ, r.d.navbar_btn_color, 1);
        this.aDJ.setOnClickListener(new c(this));
        this.aDL = (BdGridView) findViewById(r.g.recommend_photos_list);
        this.aDN = new h(getPageContext());
        this.aDL.setAdapter((ListAdapter) this.aDN);
        this.aDL.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aDT = getIntent().getBooleanExtra("need_upload", true);
        this.aDO = new ArrayList<>();
        GL();
    }

    private void GL() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aDS = iVar.getUrl();
            com.baidu.adp.lib.g.c.eA().a(iVar.getUrl(), 10, this.aDV, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bW(boolean z) {
        this.aDJ.setEnabled(z);
        av.k(this.aDJ, r.f.s_navbar_button_bg);
    }

    public void GM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(r.j.enter_forum_cancel_change_tip);
        aVar.b(r.j.alert_no_button, new f(this));
        aVar.a(r.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).tm();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aDP != -1) {
                GM();
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
        getLayoutMode().x(this.aDM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.aDJ, r.f.s_navbar_button_bg);
        av.c(this.aDJ, r.d.navbar_btn_color, 1);
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
        private ab aiu;

        private a() {
            this.aiu = null;
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
            this.aiu = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.aiu.d("pic", ChangeSystemPhotoActivity.this.aDR.jY());
                str = this.aiu.ux();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiu.uS().vO().oF()) {
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
            ChangeSystemPhotoActivity.this.aDQ = null;
            if (this.aiu != null) {
                this.aiu.eg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ex */
        public void onPostExecute(String str) {
            if (this.aiu != null) {
                if (ChangeSystemPhotoActivity.this.aDU != null) {
                    ChangeSystemPhotoActivity.this.aDU.aF(false);
                }
                if (this.aiu.uS().vO().oF()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(r.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aDS);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h().d(ChangeSystemPhotoActivity.this.getResources().getString(r.j.bubble_setdefualt_error));
            }
        }
    }
}
