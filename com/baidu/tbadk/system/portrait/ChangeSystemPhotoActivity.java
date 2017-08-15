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
    com.baidu.tbadk.core.view.a aMl;
    private NavigationBar mNavigationBar = null;
    private TextView aMa = null;
    private View aMb = null;
    private BdGridView aMc = null;
    private LinearLayout aMd = null;
    private com.baidu.tbadk.system.portrait.a aMe = null;
    private ArrayList<b> aMf = null;
    private int aMg = -1;
    private a aMh = null;
    private com.baidu.adp.widget.a.a aMi = null;
    private String aMj = null;
    private boolean aMk = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.aMl == null) {
                    ChangeSystemPhotoActivity.this.aMl = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.aMl.c(null);
                }
                ChangeSystemPhotoActivity.this.aMl.aH(true);
                if (ChangeSystemPhotoActivity.this.aMk) {
                    ChangeSystemPhotoActivity.this.aMi = aVar;
                    if (ChangeSystemPhotoActivity.this.aMh != null) {
                        ChangeSystemPhotoActivity.this.aMh.cancel();
                    }
                    ChangeSystemPhotoActivity.this.aMh = new a();
                    ChangeSystemPhotoActivity.this.aMh.execute(new String[0]);
                    return;
                }
                Bitmap kX = aVar.kX();
                if (kX != null) {
                    if (!ChangeSystemPhotoActivity.this.e(TbConfig.PERSON_USER_PIC_TEMP_FILE, kX)) {
                        if (ChangeSystemPhotoActivity.this.aMl != null) {
                            ChangeSystemPhotoActivity.this.aMl.aH(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.aMl != null) {
                        ChangeSystemPhotoActivity.this.aMl.aH(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.aMl != null) {
                    ChangeSystemPhotoActivity.this.aMl.aH(false);
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
        this.aMd = (LinearLayout) findViewById(d.h.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.aMb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aMg != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.l.choose_system_photo);
        this.aMa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMa.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.aMa.setLayoutParams(layoutParams);
        ce(false);
        ai.j(this.aMa, d.g.s_navbar_button_bg);
        ai.c(this.aMa, d.e.navbar_btn_color, 1);
        this.aMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aMg != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.aMf.get(ChangeSystemPhotoActivity.this.aMg));
                }
            }
        });
        this.aMc = (BdGridView) findViewById(d.h.recommend_photos_list);
        this.aMe = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.aMc.setAdapter((ListAdapter) this.aMe);
        this.aMc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.aMf != null && ChangeSystemPhotoActivity.this.aMf.size() > 0 && ChangeSystemPhotoActivity.this.aMf.size() > i && ChangeSystemPhotoActivity.this.aMf.get(i) != null) {
                    ChangeSystemPhotoActivity.this.aMg = i;
                    ChangeSystemPhotoActivity.this.ce(true);
                    ChangeSystemPhotoActivity.this.aMe.fm(i);
                    ChangeSystemPhotoActivity.this.aMe.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.aMk = getIntent().getBooleanExtra("need_upload", true);
        this.aMf = new ArrayList<>();
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
                                bVar.gE(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.aMf.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.aMe.s(ChangeSystemPhotoActivity.this.aMf);
                        ChangeSystemPhotoActivity.this.aMe.notifyDataSetChanged();
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
            this.aMj = bVar.getUrl();
            c.fU().a(bVar.getUrl(), 10, this.aMm, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void ce(boolean z) {
        this.aMa.setEnabled(z);
        ai.j(this.aMa, d.g.s_navbar_button_bg);
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
        aVar.b(getPageContext()).tr();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aMg != -1) {
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
        getLayoutMode().t(this.aMd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.j(this.aMa, d.g.s_navbar_button_bg);
        ai.c(this.aMa, d.e.navbar_btn_color, 1);
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
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aMi.la());
                str = this.mNetwork.uQ();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aMh = null;
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
                if (ChangeSystemPhotoActivity.this.aMl != null) {
                    ChangeSystemPhotoActivity.this.aMl.aH(false);
                }
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().c(ChangeSystemPhotoActivity.this.getResources().getString(d.l.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aMj);
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
