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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a fxS;
    private NavigationBar mNavigationBar = null;
    private TextView fxI = null;
    private View fxJ = null;
    private BdGridView fxK = null;
    private LinearLayout mRootView = null;
    private com.baidu.tbadk.system.portrait.a fxL = null;
    private ArrayList<b> fxM = null;
    private int fxN = -1;
    private a fxO = null;
    private com.baidu.adp.widget.ImageView.a fxP = null;
    private String fxQ = null;
    private boolean fxR = true;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eKQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.fxS == null) {
                    ChangeSystemPhotoActivity.this.fxS = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.fxS.setCancelListener(null);
                }
                ChangeSystemPhotoActivity.this.fxS.setDialogVisiable(true);
                if (ChangeSystemPhotoActivity.this.fxR) {
                    ChangeSystemPhotoActivity.this.fxP = aVar;
                    if (ChangeSystemPhotoActivity.this.fxO != null) {
                        ChangeSystemPhotoActivity.this.fxO.cancel();
                    }
                    ChangeSystemPhotoActivity.this.fxO = new a();
                    ChangeSystemPhotoActivity.this.fxO.execute(new String[0]);
                    return;
                }
                Bitmap rawBitmap = aVar.getRawBitmap();
                if (rawBitmap != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, rawBitmap)) {
                        if (ChangeSystemPhotoActivity.this.fxS != null) {
                            ChangeSystemPhotoActivity.this.fxS.setDialogVisiable(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.fxS != null) {
                        ChangeSystemPhotoActivity.this.fxS.setDialogVisiable(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.fxS != null) {
                    ChangeSystemPhotoActivity.this.fxS.setDialogVisiable(false);
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
        this.mRootView = (LinearLayout) findViewById(R.id.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.fxN != -1) {
                    ChangeSystemPhotoActivity.this.Qj();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(R.string.choose_system_photo);
        this.fxI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxI.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fxI.setLayoutParams(layoutParams);
        int dimens = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds27);
        this.fxI.setPadding(dimens, 0, dimens, 0);
        kC(false);
        ap.setBackgroundResource(this.fxI, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fxI, R.color.navbar_btn_color, 1);
        this.fxI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.fxN != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.fxM.get(ChangeSystemPhotoActivity.this.fxN));
                }
            }
        });
        this.fxK = (BdGridView) findViewById(R.id.recommend_photos_list);
        this.fxL = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.fxK.setAdapter((ListAdapter) this.fxL);
        this.fxK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.fxM != null && ChangeSystemPhotoActivity.this.fxM.size() > 0 && ChangeSystemPhotoActivity.this.fxM.size() > i && ChangeSystemPhotoActivity.this.fxM.get(i) != null) {
                    ChangeSystemPhotoActivity.this.fxN = i;
                    ChangeSystemPhotoActivity.this.kC(true);
                    ChangeSystemPhotoActivity.this.fxL.rQ(i);
                    ChangeSystemPhotoActivity.this.fxL.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.fxR = getIntent().getBooleanExtra("need_upload", true);
        this.fxM = new ArrayList<>();
        bCZ();
    }

    private void bCZ() {
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
                                bVar.rR(popularPortraitsInfo.myItem);
                                bVar.Es(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.fxM.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.fxL.O(ChangeSystemPhotoActivity.this.fxM);
                        ChangeSystemPhotoActivity.this.fxL.notifyDataSetChanged();
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
            this.fxQ = bVar.getUrl();
            c.mS().a(bVar.getUrl(), 10, this.eKQ, 0, 0, getUniqueId(), new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.fxQ));
        }
    }

    public void kC(boolean z) {
        this.fxI.setEnabled(z);
        ap.setBackgroundResource(this.fxI, R.drawable.s_navbar_button_bg);
    }

    public void Qj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ow(R.string.enter_forum_cancel_change_tip);
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
        aVar.b(getPageContext()).bpc();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fxN != -1) {
                Qj();
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
        getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.fxI, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fxI, R.color.navbar_btn_color, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            n.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private aa mNetwork;

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
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.addPostData(UgcUBCUtils.UGC_TYPE_PIC_BTN, ChangeSystemPhotoActivity.this.fxP.getImageByte());
                str = this.mNetwork.postMultiNetData();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.fxO = null;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (ChangeSystemPhotoActivity.this.fxS != null) {
                    ChangeSystemPhotoActivity.this.fxS.setDialogVisiable(false);
                }
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().showSuccessToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.fxQ);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    if ("flutter".equals(ChangeSystemPhotoActivity.this.getIntent().getStringExtra("from"))) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, ChangeSystemPhotoActivity.this.fxQ));
                        return;
                    }
                    return;
                }
                new com.baidu.tbadk.core.view.c().showFailToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.setdefualt_error));
            }
        }
    }
}
