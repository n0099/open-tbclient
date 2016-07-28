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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b aBp;
    private NavigationBar mNavigationBar = null;
    private TextView aBe = null;
    private View aBf = null;
    private BdGridView aBg = null;
    private LinearLayout aBh = null;
    private h aBi = null;
    private ArrayList<i> aBj = null;
    private int aBk = -1;
    private a aBl = null;
    private com.baidu.adp.widget.a.a aBm = null;
    private String aBn = null;
    private boolean aBo = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBq = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aBh = (LinearLayout) findViewById(u.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aBf.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(u.j.choose_system_photo);
        this.aBe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBe.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), u.e.ds16);
        this.aBe.setLayoutParams(layoutParams);
        bV(false);
        av.k(this.aBe, u.f.s_navbar_button_bg);
        av.c(this.aBe, u.d.navbar_btn_color, 1);
        this.aBe.setOnClickListener(new c(this));
        this.aBg = (BdGridView) findViewById(u.g.recommend_photos_list);
        this.aBi = new h(getPageContext());
        this.aBg.setAdapter((ListAdapter) this.aBi);
        this.aBg.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aBo = getIntent().getBooleanExtra("need_upload", true);
        this.aBj = new ArrayList<>();
        Fs();
    }

    private void Fs() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aBn = iVar.getUrl();
            com.baidu.adp.lib.g.c.dF().a(iVar.getUrl(), 10, this.aBq, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bV(boolean z) {
        this.aBe.setEnabled(z);
        av.k(this.aBe, u.f.s_navbar_button_bg);
    }

    public void Ft() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.enter_forum_cancel_change_tip);
        aVar.b(u.j.alert_no_button, new f(this));
        aVar.a(u.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).rS();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aBk != -1) {
                Ft();
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
        getLayoutMode().w(this.aBh);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.aBe, u.f.s_navbar_button_bg);
        av.c(this.aBe, u.d.navbar_btn_color, 1);
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
        private ab afX;

        private a() {
            this.afX = null;
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
            this.afX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afX.d("pic", ChangeSystemPhotoActivity.this.aBm.jd());
                str = this.afX.tc();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afX.tx().uv().nJ()) {
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
            ChangeSystemPhotoActivity.this.aBl = null;
            if (this.afX != null) {
                this.afX.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            if (this.afX != null) {
                if (ChangeSystemPhotoActivity.this.aBp != null) {
                    ChangeSystemPhotoActivity.this.aBp.aE(false);
                }
                if (this.afX.tx().uv().nJ()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(u.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aBn);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.h().d(ChangeSystemPhotoActivity.this.getResources().getString(u.j.bubble_setdefualt_error));
            }
        }
    }
}
