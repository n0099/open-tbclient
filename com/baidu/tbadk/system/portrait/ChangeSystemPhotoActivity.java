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
    com.baidu.tbadk.core.view.b aAz;
    private NavigationBar mNavigationBar = null;
    private TextView aAo = null;
    private View aAp = null;
    private BdGridView aAq = null;
    private LinearLayout aAr = null;
    private h aAs = null;
    private ArrayList<i> aAt = null;
    private int aAu = -1;
    private a aAv = null;
    private com.baidu.adp.widget.a.a aAw = null;
    private String aAx = null;
    private boolean aAy = true;
    private com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAA = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.change_system_photo_layout);
        nl();
        initData();
    }

    public void nl() {
        this.aAr = (LinearLayout) findViewById(u.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.aAp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aAp.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(u.j.choose_system_photo);
        this.aAo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAo.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), u.e.ds16);
        this.aAo.setLayoutParams(layoutParams);
        bS(false);
        av.k(this.aAo, u.f.s_navbar_button_bg);
        av.c(this.aAo, u.d.navbar_btn_color, 1);
        this.aAo.setOnClickListener(new c(this));
        this.aAq = (BdGridView) findViewById(u.g.recommend_photos_list);
        this.aAs = new h(getPageContext());
        this.aAq.setAdapter((ListAdapter) this.aAs);
        this.aAq.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aAy = getIntent().getBooleanExtra("need_upload", true);
        this.aAt = new ArrayList<>();
        Fr();
    }

    private void Fr() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aAx = iVar.getUrl();
            com.baidu.adp.lib.g.c.dG().a(iVar.getUrl(), 10, this.aAA, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bS(boolean z) {
        this.aAo.setEnabled(z);
        av.k(this.aAo, u.f.s_navbar_button_bg);
    }

    public void Fs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.enter_forum_cancel_change_tip);
        aVar.b(u.j.alert_no_button, new f(this));
        aVar.a(u.j.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).rT();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aAu != -1) {
                Fs();
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
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.aAr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.aAo, u.f.s_navbar_button_bg);
        av.c(this.aAo, u.d.navbar_btn_color, 1);
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
        private ab afj;

        private a() {
            this.afj = null;
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
            this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.afj.d("pic", ChangeSystemPhotoActivity.this.aAw.je());
                str = this.afj.td();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afj.ty().uv().nU()) {
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
            ChangeSystemPhotoActivity.this.aAv = null;
            if (this.afj != null) {
                this.afj.dm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            if (this.afj != null) {
                if (ChangeSystemPhotoActivity.this.aAz != null) {
                    ChangeSystemPhotoActivity.this.aAz.aB(false);
                }
                if (this.afj.ty().uv().nU()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(u.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aAx);
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
