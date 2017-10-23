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
    com.baidu.tbadk.core.view.a aLe;
    private NavigationBar mNavigationBar = null;
    private TextView aKT = null;
    private View aKU = null;
    private BdGridView aKV = null;
    private LinearLayout aKW = null;
    private com.baidu.tbadk.system.portrait.a aKX = null;
    private ArrayList<b> aKY = null;
    private int aKZ = -1;
    private a aLa = null;
    private com.baidu.adp.widget.ImageView.a aLb = null;
    private String aLc = null;
    private boolean aLd = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.aLe == null) {
                    ChangeSystemPhotoActivity.this.aLe = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.aLe.c(null);
                }
                ChangeSystemPhotoActivity.this.aLe.aG(true);
                if (ChangeSystemPhotoActivity.this.aLd) {
                    ChangeSystemPhotoActivity.this.aLb = aVar;
                    if (ChangeSystemPhotoActivity.this.aLa != null) {
                        ChangeSystemPhotoActivity.this.aLa.cancel();
                    }
                    ChangeSystemPhotoActivity.this.aLa = new a();
                    ChangeSystemPhotoActivity.this.aLa.execute(new String[0]);
                    return;
                }
                Bitmap kN = aVar.kN();
                if (kN != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kN)) {
                        if (ChangeSystemPhotoActivity.this.aLe != null) {
                            ChangeSystemPhotoActivity.this.aLe.aG(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.aLe != null) {
                        ChangeSystemPhotoActivity.this.aLe.aG(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.aLe != null) {
                    ChangeSystemPhotoActivity.this.aLe.aG(false);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aKW = (LinearLayout) findViewById(d.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aKU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aKZ != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.l.choose_system_photo);
        this.aKT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKT.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.f.ds16);
        this.aKT.setLayoutParams(layoutParams);
        cc(false);
        aj.j(this.aKT, d.g.s_navbar_button_bg);
        aj.c(this.aKT, d.e.navbar_btn_color, 1);
        this.aKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aKZ != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.aKY.get(ChangeSystemPhotoActivity.this.aKZ));
                }
            }
        });
        this.aKV = (BdGridView) findViewById(d.h.recommend_photos_list);
        this.aKX = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.aKV.setAdapter((ListAdapter) this.aKX);
        this.aKV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.aKY != null && ChangeSystemPhotoActivity.this.aKY.size() > 0 && ChangeSystemPhotoActivity.this.aKY.size() > i && ChangeSystemPhotoActivity.this.aKY.get(i) != null) {
                    ChangeSystemPhotoActivity.this.aKZ = i;
                    ChangeSystemPhotoActivity.this.cc(true);
                    ChangeSystemPhotoActivity.this.aKX.fw(i);
                    ChangeSystemPhotoActivity.this.aKX.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.aLd = getIntent().getBooleanExtra("need_upload", true);
        this.aKY = new ArrayList<>();
        Gs();
    }

    private void Gs() {
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
                                bVar.fx(popularPortraitsInfo.myItem);
                                bVar.gz(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.aKY.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.aKX.r(ChangeSystemPhotoActivity.this.aKY);
                        ChangeSystemPhotoActivity.this.aKX.notifyDataSetChanged();
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
            this.aLc = bVar.getUrl();
            c.fJ().a(bVar.getUrl(), 10, this.aLf, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void cc(boolean z) {
        this.aKT.setEnabled(z);
        aj.j(this.aKT, d.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).tb();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aKZ != -1) {
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
        getLayoutMode().t(this.aKW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.j(this.aKT, d.g.s_navbar_button_bg);
        aj.c(this.aKT, d.e.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
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
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aLb.kQ());
                str = this.mNetwork.ul();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.uG().vD().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aLa = null;
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aLe != null) {
                    ChangeSystemPhotoActivity.this.aLe.aG(false);
                }
                if (this.mNetwork.uG().vD().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().c(ChangeSystemPhotoActivity.this.getResources().getString(d.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aLc);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.c().d(ChangeSystemPhotoActivity.this.getResources().getString(d.l.bubble_setdefualt_error));
            }
        }
    }
}
