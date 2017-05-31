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
    com.baidu.tbadk.core.view.a aIy;
    private NavigationBar mNavigationBar = null;
    private TextView aIo = null;
    private View aIp = null;
    private BdGridView aIq = null;
    private LinearLayout ame = null;
    private h aIr = null;
    private ArrayList<i> aIs = null;
    private int aIt = -1;
    private a aIu = null;
    private com.baidu.adp.widget.a.a aIv = null;
    private String aIw = null;
    private boolean aIx = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIz = new com.baidu.tbadk.system.portrait.a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.ame = (LinearLayout) findViewById(w.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.aIp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aIp.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(w.l.choose_system_photo);
        this.aIo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIo.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.aIo.setLayoutParams(layoutParams);
        bZ(false);
        aq.j(this.aIo, w.g.s_navbar_button_bg);
        aq.c(this.aIo, w.e.navbar_btn_color, 1);
        this.aIo.setOnClickListener(new c(this));
        this.aIq = (BdGridView) findViewById(w.h.recommend_photos_list);
        this.aIr = new h(getPageContext());
        this.aIq.setAdapter((ListAdapter) this.aIr);
        this.aIq.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.aIx = getIntent().getBooleanExtra("need_upload", true);
        this.aIs = new ArrayList<>();
        FZ();
    }

    private void FZ() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.getUrl())) {
            this.aIw = iVar.getUrl();
            com.baidu.adp.lib.f.c.fM().a(iVar.getUrl(), 10, this.aIz, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bZ(boolean z) {
        this.aIo.setEnabled(z);
        aq.j(this.aIo, w.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(w.l.enter_forum_cancel_change_tip);
        aVar.b(w.l.alert_no_button, new f(this));
        aVar.a(w.l.confirm, new g(this));
        aVar.b(getPageContext()).tc();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aIt != -1) {
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
        getLayoutMode().t(this.ame);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aq.j(this.aIo, w.g.s_navbar_button_bg);
        aq.c(this.aIo, w.e.navbar_btn_color, 1);
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
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aIv.kU());
                str = this.mNetwork.uk();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.uF().vB().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aIu = null;
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aIy != null) {
                    ChangeSystemPhotoActivity.this.aIy.aH(false);
                }
                if (this.mNetwork.uF().vB().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.h().c(ChangeSystemPhotoActivity.this.getResources().getString(w.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aIw);
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
