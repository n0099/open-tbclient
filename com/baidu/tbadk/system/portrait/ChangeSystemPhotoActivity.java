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
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a fOA;
    private NavigationBar mNavigationBar = null;
    private TextView fOr = null;
    private View fOs = null;
    private BdGridView fOt = null;
    private LinearLayout mRootView = null;
    private com.baidu.tbadk.system.portrait.a fOu = null;
    private ArrayList<b> fOv = null;
    private int fOw = -1;
    private a fOx = null;
    private com.baidu.adp.widget.ImageView.a fOy = null;
    private String currentUrl = null;
    private boolean fOz = true;
    private c<com.baidu.adp.widget.ImageView.a> fba = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.fOA == null) {
                    ChangeSystemPhotoActivity.this.fOA = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.fOA.setCancelListener(null);
                }
                ChangeSystemPhotoActivity.this.fOA.setDialogVisiable(true);
                if (ChangeSystemPhotoActivity.this.fOz) {
                    ChangeSystemPhotoActivity.this.fOy = aVar;
                    if (ChangeSystemPhotoActivity.this.fOx != null) {
                        ChangeSystemPhotoActivity.this.fOx.cancel();
                    }
                    ChangeSystemPhotoActivity.this.fOx = new a();
                    ChangeSystemPhotoActivity.this.fOx.execute(new String[0]);
                    return;
                }
                Bitmap rawBitmap = aVar.getRawBitmap();
                if (rawBitmap != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, rawBitmap)) {
                        if (ChangeSystemPhotoActivity.this.fOA != null) {
                            ChangeSystemPhotoActivity.this.fOA.setDialogVisiable(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.fOA != null) {
                        ChangeSystemPhotoActivity.this.fOA.setDialogVisiable(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.fOA != null) {
                    ChangeSystemPhotoActivity.this.fOA.setDialogVisiable(false);
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
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.fOw != -1) {
                    ChangeSystemPhotoActivity.this.SY();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(R.string.choose_system_photo);
        this.fOr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fOr.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fOr.setLayoutParams(layoutParams);
        int dimens = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds27);
        this.fOr.setPadding(dimens, 0, dimens, 0);
        ls(false);
        ao.setBackgroundResource(this.fOr, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.fOr, R.color.navbar_btn_color, 1);
        this.fOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.fOw != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.fOv.get(ChangeSystemPhotoActivity.this.fOw));
                }
            }
        });
        this.fOt = (BdGridView) findViewById(R.id.recommend_photos_list);
        this.fOu = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.fOt.setAdapter((ListAdapter) this.fOu);
        this.fOt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.fOv != null && ChangeSystemPhotoActivity.this.fOv.size() > 0 && ChangeSystemPhotoActivity.this.fOv.size() > i && ChangeSystemPhotoActivity.this.fOv.get(i) != null) {
                    ChangeSystemPhotoActivity.this.fOw = i;
                    ChangeSystemPhotoActivity.this.ls(true);
                    ChangeSystemPhotoActivity.this.fOu.ta(i);
                    ChangeSystemPhotoActivity.this.fOu.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.fOz = getIntent().getBooleanExtra("need_upload", true);
        this.fOv = new ArrayList<>();
        bIo();
    }

    private void bIo() {
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
                                bVar.tb(popularPortraitsInfo.myItem);
                                bVar.Ez(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.fOv.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.fOu.O(ChangeSystemPhotoActivity.this.fOv);
                        ChangeSystemPhotoActivity.this.fOu.notifyDataSetChanged();
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
            this.currentUrl = bVar.getUrl();
            d.mx().a(bVar.getUrl(), 10, this.fba, 0, 0, getUniqueId(), new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.currentUrl));
        }
    }

    public void ls(boolean z) {
        this.fOr.setEnabled(z);
        ao.setBackgroundResource(this.fOr, R.drawable.s_navbar_button_bg);
    }

    public void SY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.pa(R.string.enter_forum_cancel_change_tip);
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
        aVar.b(getPageContext()).btX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fOw != -1) {
                SY();
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
        ao.setBackgroundResource(this.fOr, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.fOr, R.color.navbar_btn_color, 1);
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
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private z mNetwork;

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
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.addPostData("pic", ChangeSystemPhotoActivity.this.fOy.getImageByte());
                str = this.mNetwork.postMultiNetData();
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ChangeSystemPhotoActivity.this.fOx = null;
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
                if (ChangeSystemPhotoActivity.this.fOA != null) {
                    ChangeSystemPhotoActivity.this.fOA.setDialogVisiable(false);
                }
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().showSuccessToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.currentUrl);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    if ("flutter".equals(ChangeSystemPhotoActivity.this.getIntent().getStringExtra("from"))) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, ChangeSystemPhotoActivity.this.currentUrl));
                        return;
                    }
                    return;
                }
                new com.baidu.tbadk.core.view.c().showFailToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.setdefualt_error));
            }
        }
    }
}
