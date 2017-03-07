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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aIq;
    private NavigationBar mNavigationBar = null;
    private TextView aIf = null;
    private View aIg = null;
    private BdGridView aIh = null;
    private LinearLayout aIi = null;
    private h aIj = null;
    private ArrayList<i> aIk = null;
    private int aIl = -1;
    private a aIm = null;
    private com.baidu.adp.widget.a.a aIn = null;
    private String aIo = null;
    private boolean aIp = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIr = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aIi = (LinearLayout) findViewById(w.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aIg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aIg.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(w.l.choose_system_photo);
        this.aIf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIf.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.aIf.setLayoutParams(layoutParams);
        bZ(false);
        aq.j(this.aIf, w.g.s_navbar_button_bg);
        aq.c(this.aIf, w.e.navbar_btn_color, 1);
        this.aIf.setOnClickListener(new c(this));
        this.aIh = (BdGridView) findViewById(w.h.recommend_photos_list);
        this.aIj = new h(getPageContext());
        this.aIh.setAdapter((ListAdapter) this.aIj);
        this.aIh.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aIp = getIntent().getBooleanExtra("need_upload", true);
        this.aIk = new ArrayList<>();
        GC();
    }

    private void GC() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aIo = iVar.getUrl();
            com.baidu.adp.lib.f.c.fG().a(iVar.getUrl(), 10, this.aIr, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bZ(boolean z) {
        this.aIf.setEnabled(z);
        aq.j(this.aIf, w.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bW(w.l.enter_forum_cancel_change_tip);
        aVar.b(w.l.alert_no_button, new f(this));
        aVar.a(w.l.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).ts();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aIl != -1) {
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
        getLayoutMode().t(this.aIi);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aq.j(this.aIf, w.g.s_navbar_button_bg);
        aq.c(this.aIf, w.e.navbar_btn_color, 1);
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
        private z mNetwork;

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
            this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aIn.kQ());
                str = this.mNetwork.uE();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.uZ().vT().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aIm = null;
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aIq != null) {
                    ChangeSystemPhotoActivity.this.aIq.aI(false);
                }
                if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(w.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aIo);
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
