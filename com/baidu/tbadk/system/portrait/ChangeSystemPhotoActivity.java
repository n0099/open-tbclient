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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.b cAX;
    private NavigationBar mNavigationBar = null;
    private TextView cAN = null;
    private View cAO = null;
    private BdGridView cAP = null;
    private LinearLayout bNa = null;
    private com.baidu.tbadk.system.portrait.a cAQ = null;
    private ArrayList<b> cAR = null;
    private int cAS = -1;
    private a cAT = null;
    private com.baidu.adp.widget.ImageView.a cAU = null;
    private String cAV = null;
    private boolean cAW = true;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.cAX == null) {
                    ChangeSystemPhotoActivity.this.cAX = new com.baidu.tbadk.core.view.b(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.cAX.e(null);
                }
                ChangeSystemPhotoActivity.this.cAX.ef(true);
                if (ChangeSystemPhotoActivity.this.cAW) {
                    ChangeSystemPhotoActivity.this.cAU = aVar;
                    if (ChangeSystemPhotoActivity.this.cAT != null) {
                        ChangeSystemPhotoActivity.this.cAT.cancel();
                    }
                    ChangeSystemPhotoActivity.this.cAT = new a();
                    ChangeSystemPhotoActivity.this.cAT.execute(new String[0]);
                    return;
                }
                Bitmap ns = aVar.ns();
                if (ns != null) {
                    if (!ChangeSystemPhotoActivity.this.f(TbConfig.PERSON_USER_PIC_TEMP_FILE, ns)) {
                        if (ChangeSystemPhotoActivity.this.cAX != null) {
                            ChangeSystemPhotoActivity.this.cAX.ef(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.cAX != null) {
                        ChangeSystemPhotoActivity.this.cAX.ef(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.cAX != null) {
                    ChangeSystemPhotoActivity.this.cAX.ef(false);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.bNa = (LinearLayout) findViewById(R.id.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.cAS != -1) {
                    ChangeSystemPhotoActivity.this.showDialog();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(R.string.choose_system_photo);
        this.cAN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAN.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cAN.setLayoutParams(layoutParams);
        fF(false);
        al.k(this.cAN, R.drawable.s_navbar_button_bg);
        al.f(this.cAN, R.color.navbar_btn_color, 1);
        this.cAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.cAS != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.cAR.get(ChangeSystemPhotoActivity.this.cAS));
                }
            }
        });
        this.cAP = (BdGridView) findViewById(R.id.recommend_photos_list);
        this.cAQ = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.cAP.setAdapter((ListAdapter) this.cAQ);
        this.cAP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.cAR != null && ChangeSystemPhotoActivity.this.cAR.size() > 0 && ChangeSystemPhotoActivity.this.cAR.size() > i && ChangeSystemPhotoActivity.this.cAR.get(i) != null) {
                    ChangeSystemPhotoActivity.this.cAS = i;
                    ChangeSystemPhotoActivity.this.fF(true);
                    ChangeSystemPhotoActivity.this.cAQ.kQ(i);
                    ChangeSystemPhotoActivity.this.cAQ.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.cAW = getIntent().getBooleanExtra("need_upload", true);
        this.cAR = new ArrayList<>();
        auK();
    }

    private void auK() {
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
                                bVar.kR(popularPortraitsInfo.myItem);
                                bVar.qH(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.cAR.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.cAQ.A(ChangeSystemPhotoActivity.this.cAR);
                        ChangeSystemPhotoActivity.this.cAQ.notifyDataSetChanged();
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
            this.cAV = bVar.getUrl();
            c.iv().a(bVar.getUrl(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.cAV));
        }
    }

    public void fF(boolean z) {
        this.cAN.setEnabled(z);
        al.k(this.cAN, R.drawable.s_navbar_button_bg);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.enter_forum_cancel_change_tip);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).afG();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cAS != -1) {
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
        getLayoutMode().onModeChanged(this.bNa);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.cAN, R.drawable.s_navbar_button_bg);
        al.f(this.cAN, R.color.navbar_btn_color, 1);
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
                this.mNetwork.d("pic", ChangeSystemPhotoActivity.this.cAU.nv());
                str = this.mNetwork.ahh();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.cAT = null;
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.cAX != null) {
                    ChangeSystemPhotoActivity.this.cAX.ef(false);
                }
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                    new e().i(ChangeSystemPhotoActivity.this.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.cAV);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    return;
                }
                new e().j(ChangeSystemPhotoActivity.this.getResources().getString(R.string.setdefualt_error));
            }
        }
    }
}
