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
    com.baidu.tbadk.core.view.b azH;
    private NavigationBar mNavigationBar = null;
    private TextView azw = null;
    private View azx = null;
    private BdGridView azy = null;
    private LinearLayout azz = null;
    private h azA = null;
    private ArrayList<i> azB = null;
    private int azC = -1;
    private a azD = null;
    private com.baidu.adp.widget.a.a azE = null;
    private String azF = null;
    private boolean azG = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> azI = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.change_system_photo_layout);
        nq();
        initData();
    }

    public void nq() {
        this.azz = (LinearLayout) findViewById(t.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.azx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.azx.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(t.j.choose_system_photo);
        this.azw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azw.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.azw.setLayoutParams(layoutParams);
        bT(false);
        at.k(this.azw, t.f.s_navbar_button_bg);
        at.c(this.azw, t.d.navbar_btn_color, 1);
        this.azw.setOnClickListener(new c(this));
        this.azy = (BdGridView) findViewById(t.g.recommend_photos_list);
        this.azA = new h(getPageContext());
        this.azy.setAdapter((ListAdapter) this.azA);
        this.azy.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.azG = getIntent().getBooleanExtra("need_upload", true);
        this.azB = new ArrayList<>();
        Fh();
    }

    private void Fh() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.azF = iVar.getUrl();
            com.baidu.adp.lib.g.c.dF().a(iVar.getUrl(), 10, this.azI, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bT(boolean z) {
        this.azw.setEnabled(z);
        at.k(this.azw, t.f.s_navbar_button_bg);
    }

    public void Fi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(t.j.enter_forum_cancel_change_tip);
        aVar.b(t.j.alert_no_button, new f(this));
        aVar.a(t.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).rU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.azC != -1) {
                Fi();
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
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.azz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        at.k(this.azw, t.f.s_navbar_button_bg);
        at.c(this.azw, t.d.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
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
        private ab aeI;

        private a() {
            this.aeI = null;
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
            this.aeI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.aeI.c("pic", ChangeSystemPhotoActivity.this.azE.jb());
                str = this.aeI.tf();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aeI.tA().uv().nZ()) {
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
            ChangeSystemPhotoActivity.this.azD = null;
            if (this.aeI != null) {
                this.aeI.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eo */
        public void onPostExecute(String str) {
            if (this.aeI != null) {
                if (ChangeSystemPhotoActivity.this.azH != null) {
                    ChangeSystemPhotoActivity.this.azH.aD(false);
                }
                if (this.aeI.tA().uv().nZ()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(t.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.azF);
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
