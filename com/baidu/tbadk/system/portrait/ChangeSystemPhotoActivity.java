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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a aVb;
    private NavigationBar mNavigationBar = null;
    private TextView aUQ = null;
    private View aUR = null;
    private BdGridView aUS = null;
    private LinearLayout aUT = null;
    private com.baidu.tbadk.system.portrait.a aUU = null;
    private ArrayList<b> aUV = null;
    private int aUW = -1;
    private a aUX = null;
    private com.baidu.adp.widget.ImageView.a aUY = null;
    private String aUZ = null;
    private boolean aVa = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.aVb == null) {
                    ChangeSystemPhotoActivity.this.aVb = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.aVb.d(null);
                }
                ChangeSystemPhotoActivity.this.aVb.aM(true);
                if (ChangeSystemPhotoActivity.this.aVa) {
                    ChangeSystemPhotoActivity.this.aUY = aVar;
                    if (ChangeSystemPhotoActivity.this.aUX != null) {
                        ChangeSystemPhotoActivity.this.aUX.cancel();
                    }
                    ChangeSystemPhotoActivity.this.aUX = new a();
                    ChangeSystemPhotoActivity.this.aUX.execute(new String[0]);
                    return;
                }
                Bitmap mZ = aVar.mZ();
                if (mZ != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, mZ)) {
                        if (ChangeSystemPhotoActivity.this.aVb != null) {
                            ChangeSystemPhotoActivity.this.aVb.aM(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.aVb != null) {
                        ChangeSystemPhotoActivity.this.aVb.aM(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.aVb != null) {
                    ChangeSystemPhotoActivity.this.aVb.aM(false);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.aUT = (LinearLayout) findViewById(d.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aUW != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.k.choose_system_photo);
        this.aUQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUQ.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aUQ.setLayoutParams(layoutParams);
        cb(false);
        al.i(this.aUQ, d.f.s_navbar_button_bg);
        al.c(this.aUQ, d.C0141d.navbar_btn_color, 1);
        this.aUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.aUW != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.aUV.get(ChangeSystemPhotoActivity.this.aUW));
                }
            }
        });
        this.aUS = (BdGridView) findViewById(d.g.recommend_photos_list);
        this.aUU = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.aUS.setAdapter((ListAdapter) this.aUU);
        this.aUS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.aUV != null && ChangeSystemPhotoActivity.this.aUV.size() > 0 && ChangeSystemPhotoActivity.this.aUV.size() > i && ChangeSystemPhotoActivity.this.aUV.get(i) != null) {
                    ChangeSystemPhotoActivity.this.aUW = i;
                    ChangeSystemPhotoActivity.this.cb(true);
                    ChangeSystemPhotoActivity.this.aUU.fp(i);
                    ChangeSystemPhotoActivity.this.aUU.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.aVa = getIntent().getBooleanExtra("need_upload", true);
        this.aUV = new ArrayList<>();
        KM();
    }

    private void KM() {
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
                                bVar.fq(popularPortraitsInfo.myItem);
                                bVar.hr(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.aUV.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.aUU.r(ChangeSystemPhotoActivity.this.aUV);
                        ChangeSystemPhotoActivity.this.aUU.notifyDataSetChanged();
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
            this.aUZ = bVar.getUrl();
            c.ig().a(bVar.getUrl(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void cb(boolean z) {
        this.aUQ.setEnabled(z);
        al.i(this.aUQ, d.f.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.k.enter_forum_cancel_change_tip);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).xa();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aUW != -1) {
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
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.aUT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.aUQ, d.f.s_navbar_button_bg);
        al.c(this.aUQ, d.C0141d.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private y mNetwork;

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
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.aUY.nc());
                str = this.mNetwork.yo();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.aUX = null;
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.aVb != null) {
                    ChangeSystemPhotoActivity.this.aVb.aM(false);
                }
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().i(ChangeSystemPhotoActivity.this.getResources().getString(d.k.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.aUZ);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new com.baidu.tbadk.core.view.c().j(ChangeSystemPhotoActivity.this.getResources().getString(d.k.setdefualt_error));
            }
        }
    }
}
