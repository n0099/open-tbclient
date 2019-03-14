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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b csK;
    private NavigationBar mNavigationBar = null;
    private TextView csA = null;
    private View csB = null;
    private BdGridView csC = null;
    private LinearLayout bFw = null;
    private com.baidu.tbadk.system.portrait.a csD = null;
    private ArrayList<b> csE = null;
    private int csF = -1;
    private a csG = null;
    private com.baidu.adp.widget.ImageView.a csH = null;
    private String csI = null;
    private boolean csJ = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.csK == null) {
                    ChangeSystemPhotoActivity.this.csK = new com.baidu.tbadk.core.view.b(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.csK.e(null);
                }
                ChangeSystemPhotoActivity.this.csK.dJ(true);
                if (ChangeSystemPhotoActivity.this.csJ) {
                    ChangeSystemPhotoActivity.this.csH = aVar;
                    if (ChangeSystemPhotoActivity.this.csG != null) {
                        ChangeSystemPhotoActivity.this.csG.cancel();
                    }
                    ChangeSystemPhotoActivity.this.csG = new a();
                    ChangeSystemPhotoActivity.this.csG.execute(new String[0]);
                    return;
                }
                Bitmap oy = aVar.oy();
                if (oy != null) {
                    if (!ChangeSystemPhotoActivity.this.f(TbConfig.PERSON_USER_PIC_TEMP_FILE, oy)) {
                        if (ChangeSystemPhotoActivity.this.csK != null) {
                            ChangeSystemPhotoActivity.this.csK.dJ(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.csK != null) {
                        ChangeSystemPhotoActivity.this.csK.dJ(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.csK != null) {
                    ChangeSystemPhotoActivity.this.csK.dJ(false);
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
        this.bFw = (LinearLayout) findViewById(d.g.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.csF != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(d.j.choose_system_photo);
        this.csA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csA.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.csA.setLayoutParams(layoutParams);
        fj(false);
        al.k(this.csA, d.f.s_navbar_button_bg);
        al.d(this.csA, d.C0277d.navbar_btn_color, 1);
        this.csA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.csF != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.csE.get(ChangeSystemPhotoActivity.this.csF));
                }
            }
        });
        this.csC = (BdGridView) findViewById(d.g.recommend_photos_list);
        this.csD = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.csC.setAdapter((ListAdapter) this.csD);
        this.csC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.csE != null && ChangeSystemPhotoActivity.this.csE.size() > 0 && ChangeSystemPhotoActivity.this.csE.size() > i && ChangeSystemPhotoActivity.this.csE.get(i) != null) {
                    ChangeSystemPhotoActivity.this.csF = i;
                    ChangeSystemPhotoActivity.this.fj(true);
                    ChangeSystemPhotoActivity.this.csD.kc(i);
                    ChangeSystemPhotoActivity.this.csD.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.csJ = getIntent().getBooleanExtra("need_upload", true);
        this.csE = new ArrayList<>();
        apJ();
    }

    private void apJ() {
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
                                bVar.kd(popularPortraitsInfo.myItem);
                                bVar.py(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.csE.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.csD.x(ChangeSystemPhotoActivity.this.csE);
                        ChangeSystemPhotoActivity.this.csD.notifyDataSetChanged();
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
            this.csI = bVar.getUrl();
            c.jB().a(bVar.getUrl(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.csI));
        }
    }

    public void fj(boolean z) {
        this.csA.setEnabled(z);
        al.k(this.csA, d.f.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.enter_forum_cancel_change_tip);
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
        aVar.b(getPageContext()).aaZ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.csF != -1) {
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
        getLayoutMode().onModeChanged(this.bFw);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.csA, d.f.s_navbar_button_bg);
        al.d(this.csA, d.C0277d.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, Bitmap bitmap) {
        try {
            m.a((String) null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.csH.oB());
                str = this.mNetwork.acm();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.csG = null;
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.csK != null) {
                    ChangeSystemPhotoActivity.this.csK.dJ(false);
                }
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
                    new e().i(ChangeSystemPhotoActivity.this.getResources().getString(d.j.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.csI);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new e().j(ChangeSystemPhotoActivity.this.getResources().getString(d.j.setdefualt_error));
            }
        }
    }
}
