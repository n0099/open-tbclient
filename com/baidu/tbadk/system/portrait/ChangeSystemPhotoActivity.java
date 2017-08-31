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
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aLS;
    private NavigationBar mNavigationBar = null;
    private TextView aLH = null;
    private View aLI = null;
    private BdGridView aLJ = null;
    private LinearLayout aLK = null;
    private com.baidu.tbadk.system.portrait.a aLL = null;
    private ArrayList<b> aLM = null;
    private int aLN = -1;
    private a aLO = null;
    private com.baidu.adp.widget.a.a aLP = null;
    private String aLQ = null;
    private boolean aLR = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.aLS == null) {
                    ChangeSystemPhotoActivity.this.aLS = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.aLS.c(null);
                }
                ChangeSystemPhotoActivity.this.aLS.aH(true);
                if (ChangeSystemPhotoActivity.this.aLR) {
                    ChangeSystemPhotoActivity.this.aLP = aVar;
                    if (ChangeSystemPhotoActivity.this.aLO != null) {
                        ChangeSystemPhotoActivity.this.aLO.cancel();
                    }
                    ChangeSystemPhotoActivity.this.aLO = new a();
                    ChangeSystemPhotoActivity.this.aLO.execute(new String[0]);
                    return;
                }
                Bitmap kO = aVar.kO();
                if (kO != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kO)) {
                        if (ChangeSystemPhotoActivity.this.aLS != null) {
                            ChangeSystemPhotoActivity.this.aLS.aH(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.aLS != null) {
                        ChangeSystemPhotoActivity.this.aLS.aH(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.aLS != null) {
                    ChangeSystemPhotoActivity.this.aLS.aH(false);
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
        this.aLK = (LinearLayout) findViewById(d.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aLI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aLN != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.l.choose_system_photo);
        this.aLH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aLH.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.aLH.setLayoutParams(layoutParams);
        ce(false);
        aj.j(this.aLH, d.g.s_navbar_button_bg);
        aj.c(this.aLH, d.e.navbar_btn_color, 1);
        this.aLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aLN != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.aLM.get(ChangeSystemPhotoActivity.this.aLN));
                }
            }
        });
        this.aLJ = (BdGridView) findViewById(d.h.recommend_photos_list);
        this.aLL = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.aLJ.setAdapter((ListAdapter) this.aLL);
        this.aLJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.aLM != null && ChangeSystemPhotoActivity.this.aLM.size() > 0 && ChangeSystemPhotoActivity.this.aLM.size() > i && ChangeSystemPhotoActivity.this.aLM.get(i) != null) {
                    ChangeSystemPhotoActivity.this.aLN = i;
                    ChangeSystemPhotoActivity.this.ce(true);
                    ChangeSystemPhotoActivity.this.aLL.fm(i);
                    ChangeSystemPhotoActivity.this.aLL.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.aLR = getIntent().getBooleanExtra("need_upload", true);
        this.aLM = new ArrayList<>();
        GT();
    }

    private void GT() {
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
                                bVar.fn(popularPortraitsInfo.myItem);
                                bVar.gD(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.aLM.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.aLL.s(ChangeSystemPhotoActivity.this.aLM);
                        ChangeSystemPhotoActivity.this.aLL.notifyDataSetChanged();
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
            this.aLQ = bVar.getUrl();
            c.fK().a(bVar.getUrl(), 10, this.aLT, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void ce(boolean z) {
        this.aLH.setEnabled(z);
        aj.j(this.aLH, d.g.s_navbar_button_bg);
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
        aVar.b(getPageContext()).to();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aLN != -1) {
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
        getLayoutMode().t(this.aLK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.j(this.aLH, d.g.s_navbar_button_bg);
        aj.c(this.aLH, d.e.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.k.a(null, str, bitmap, 80);
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
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aLP.kR());
                str = this.mNetwork.uO();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aLO = null;
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aLS != null) {
                    ChangeSystemPhotoActivity.this.aLS.aH(false);
                }
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().c(ChangeSystemPhotoActivity.this.getResources().getString(d.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aLQ);
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
