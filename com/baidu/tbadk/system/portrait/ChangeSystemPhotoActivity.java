package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b bAr;
    private NavigationBar mNavigationBar = null;
    private TextView bAg = null;
    private View bAh = null;
    private BdGridView bAi = null;
    private LinearLayout bAj = null;
    private com.baidu.tbadk.system.portrait.a bAk = null;
    private ArrayList<b> bAl = null;
    private int bAm = -1;
    private a bAn = null;
    private com.baidu.adp.widget.a.a bAo = null;
    private String bAp = null;
    private boolean bAq = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.bAr == null) {
                    ChangeSystemPhotoActivity.this.bAr = new com.baidu.tbadk.core.view.b(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.bAr.c(null);
                }
                ChangeSystemPhotoActivity.this.bAr.bm(true);
                if (ChangeSystemPhotoActivity.this.bAq) {
                    ChangeSystemPhotoActivity.this.bAo = aVar;
                    if (ChangeSystemPhotoActivity.this.bAn != null) {
                        ChangeSystemPhotoActivity.this.bAn.cancel();
                    }
                    ChangeSystemPhotoActivity.this.bAn = new a();
                    ChangeSystemPhotoActivity.this.bAn.execute(new String[0]);
                    return;
                }
                Bitmap si = aVar.si();
                if (si != null) {
                    if (!ChangeSystemPhotoActivity.this.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, si)) {
                        if (ChangeSystemPhotoActivity.this.bAr != null) {
                            ChangeSystemPhotoActivity.this.bAr.bm(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.bAr != null) {
                        ChangeSystemPhotoActivity.this.bAr.bm(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.bAr != null) {
                    ChangeSystemPhotoActivity.this.bAr.bm(false);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.bAj = (LinearLayout) findViewById(d.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bAh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.bAm != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.j.choose_system_photo);
        this.bAg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bAg.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds16);
        this.bAg.setLayoutParams(layoutParams);
        cB(false);
        aj.s(this.bAg, d.f.s_navbar_button_bg);
        aj.e(this.bAg, d.C0108d.navbar_btn_color, 1);
        this.bAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.bAm != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.bAl.get(ChangeSystemPhotoActivity.this.bAm));
                }
            }
        });
        this.bAi = (BdGridView) findViewById(d.g.recommend_photos_list);
        this.bAk = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.bAi.setAdapter((ListAdapter) this.bAk);
        this.bAi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.bAl != null && ChangeSystemPhotoActivity.this.bAl.size() > 0 && ChangeSystemPhotoActivity.this.bAl.size() > i && ChangeSystemPhotoActivity.this.bAl.get(i) != null) {
                    ChangeSystemPhotoActivity.this.bAm = i;
                    ChangeSystemPhotoActivity.this.cB(true);
                    ChangeSystemPhotoActivity.this.bAk.iu(i);
                    ChangeSystemPhotoActivity.this.bAk.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.bAq = getIntent().getBooleanExtra("need_upload", true);
        this.bAl = new ArrayList<>();
        Ow();
    }

    private void Ow() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new GetPopularPortraitsCallback() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
                    if (getPopularPortraitsInfoResult != null && getPopularPortraitsInfoResult.popularPortraitsInfoList != null && getPopularPortraitsInfoResult.popularPortraitsInfoList.size() > 0) {
                        for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                            if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                                b bVar = new b();
                                bVar.setUrl(popularPortraitsInfo.url);
                                bVar.setNum(popularPortraitsInfo.num);
                                bVar.iv(popularPortraitsInfo.myItem);
                                bVar.gM(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.bAl.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.bAk.t(ChangeSystemPhotoActivity.this.bAl);
                        ChangeSystemPhotoActivity.this.bAk.notifyDataSetChanged();
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
                }
            }, session.bduss);
        }
    }

    public void a(b bVar) {
        if (bVar != null && !StringUtils.isNull(bVar.getUrl())) {
            this.bAp = bVar.getUrl();
            c.nl().a(bVar.getUrl(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void cB(boolean z) {
        this.bAg.setEnabled(z);
        aj.s(this.bAg, d.f.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fd(d.j.enter_forum_cancel_change_tip);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).AI();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bAm != -1) {
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
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.bAj);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.s(this.bAg, d.f.s_navbar_button_bg);
        aj.e(this.bAg, d.C0108d.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            k.a((String) null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

        private a() {
            this.mNetwork = null;
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
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.bAo.sl());
                str = this.mNetwork.BS();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.bAn = null;
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.bAr != null) {
                    ChangeSystemPhotoActivity.this.bAr.bm(false);
                }
                if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.d().q(ChangeSystemPhotoActivity.this.getResources().getString(d.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.bAp);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.d().r(ChangeSystemPhotoActivity.this.getResources().getString(d.j.setdefualt_error));
            }
        }
    }
}
