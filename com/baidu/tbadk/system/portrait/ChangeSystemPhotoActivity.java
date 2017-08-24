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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aMm;
    private NavigationBar mNavigationBar = null;
    private TextView aMb = null;
    private View aMc = null;
    private BdGridView aMd = null;
    private LinearLayout aMe = null;
    private com.baidu.tbadk.system.portrait.a aMf = null;
    private ArrayList<b> aMg = null;
    private int aMh = -1;
    private a aMi = null;
    private com.baidu.adp.widget.a.a aMj = null;
    private String aMk = null;
    private boolean aMl = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.aMm == null) {
                    ChangeSystemPhotoActivity.this.aMm = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.aMm.c(null);
                }
                ChangeSystemPhotoActivity.this.aMm.aH(true);
                if (ChangeSystemPhotoActivity.this.aMl) {
                    ChangeSystemPhotoActivity.this.aMj = aVar;
                    if (ChangeSystemPhotoActivity.this.aMi != null) {
                        ChangeSystemPhotoActivity.this.aMi.cancel();
                    }
                    ChangeSystemPhotoActivity.this.aMi = new a();
                    ChangeSystemPhotoActivity.this.aMi.execute(new String[0]);
                    return;
                }
                Bitmap kW = aVar.kW();
                if (kW != null) {
                    if (!ChangeSystemPhotoActivity.this.e(TbConfig.PERSON_USER_PIC_TEMP_FILE, kW)) {
                        if (ChangeSystemPhotoActivity.this.aMm != null) {
                            ChangeSystemPhotoActivity.this.aMm.aH(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.aMm != null) {
                        ChangeSystemPhotoActivity.this.aMm.aH(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.aMm != null) {
                    ChangeSystemPhotoActivity.this.aMm.aH(false);
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
        this.aMe = (LinearLayout) findViewById(d.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aMc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aMh != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.l.choose_system_photo);
        this.aMb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMb.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.aMb.setLayoutParams(layoutParams);
        ce(false);
        ai.j(this.aMb, d.g.s_navbar_button_bg);
        ai.c(this.aMb, d.e.navbar_btn_color, 1);
        this.aMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aMh != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.aMg.get(ChangeSystemPhotoActivity.this.aMh));
                }
            }
        });
        this.aMd = (BdGridView) findViewById(d.h.recommend_photos_list);
        this.aMf = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.aMd.setAdapter((ListAdapter) this.aMf);
        this.aMd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.aMg != null && ChangeSystemPhotoActivity.this.aMg.size() > 0 && ChangeSystemPhotoActivity.this.aMg.size() > i && ChangeSystemPhotoActivity.this.aMg.get(i) != null) {
                    ChangeSystemPhotoActivity.this.aMh = i;
                    ChangeSystemPhotoActivity.this.ce(true);
                    ChangeSystemPhotoActivity.this.aMf.fm(i);
                    ChangeSystemPhotoActivity.this.aMf.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.aMl = getIntent().getBooleanExtra("need_upload", true);
        this.aMg = new ArrayList<>();
        GU();
    }

    private void GU() {
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
                                bVar.gH(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.aMg.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.aMf.s(ChangeSystemPhotoActivity.this.aMg);
                        ChangeSystemPhotoActivity.this.aMf.notifyDataSetChanged();
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
            this.aMk = bVar.getUrl();
            c.fU().a(bVar.getUrl(), 10, this.aMn, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void ce(boolean z) {
        this.aMb.setEnabled(z);
        ai.j(this.aMb, d.g.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.enter_forum_cancel_change_tip);
        aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.5
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
        aVar.b(getPageContext()).ts();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aMh != -1) {
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
        getLayoutMode().t(this.aMe);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.j(this.aMb, d.g.s_navbar_button_bg);
        ai.c(this.aMb, d.e.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, Bitmap bitmap) {
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
        private w mNetwork;

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
            this.mNetwork = new w(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aMj.kZ());
                str = this.mNetwork.uR();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vm().wj().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aMi = null;
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aMm != null) {
                    ChangeSystemPhotoActivity.this.aMm.aH(false);
                }
                if (this.mNetwork.vm().wj().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().c(ChangeSystemPhotoActivity.this.getResources().getString(d.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aMk);
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
