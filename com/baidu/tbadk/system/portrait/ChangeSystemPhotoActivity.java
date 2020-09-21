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
/* loaded from: classes20.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    com.baidu.tbadk.core.view.a eXp;
    private NavigationBar mNavigationBar = null;
    private TextView eXf = null;
    private View eXg = null;
    private BdGridView eXh = null;
    private LinearLayout mRootView = null;
    private com.baidu.tbadk.system.portrait.a eXi = null;
    private ArrayList<b> eXj = null;
    private int eXk = -1;
    private a eXl = null;
    private com.baidu.adp.widget.ImageView.a eXm = null;
    private String eXn = null;
    private boolean eXo = true;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eku = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (ChangeSystemPhotoActivity.this.eXp == null) {
                    ChangeSystemPhotoActivity.this.eXp = new com.baidu.tbadk.core.view.a(ChangeSystemPhotoActivity.this.getPageContext());
                    ChangeSystemPhotoActivity.this.eXp.setCancelListener(null);
                }
                ChangeSystemPhotoActivity.this.eXp.setDialogVisiable(true);
                if (ChangeSystemPhotoActivity.this.eXo) {
                    ChangeSystemPhotoActivity.this.eXm = aVar;
                    if (ChangeSystemPhotoActivity.this.eXl != null) {
                        ChangeSystemPhotoActivity.this.eXl.cancel();
                    }
                    ChangeSystemPhotoActivity.this.eXl = new a();
                    ChangeSystemPhotoActivity.this.eXl.execute(new String[0]);
                    return;
                }
                Bitmap rawBitmap = aVar.getRawBitmap();
                if (rawBitmap != null) {
                    if (!ChangeSystemPhotoActivity.this.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, rawBitmap)) {
                        if (ChangeSystemPhotoActivity.this.eXp != null) {
                            ChangeSystemPhotoActivity.this.eXp.setDialogVisiable(false);
                            return;
                        }
                        return;
                    }
                    if (ChangeSystemPhotoActivity.this.eXp != null) {
                        ChangeSystemPhotoActivity.this.eXp.setDialogVisiable(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                } else if (ChangeSystemPhotoActivity.this.eXp != null) {
                    ChangeSystemPhotoActivity.this.eXp.setDialogVisiable(false);
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
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.eXk != -1) {
                    ChangeSystemPhotoActivity.this.NY();
                    return;
                }
                ChangeSystemPhotoActivity.this.setResult(0);
                ChangeSystemPhotoActivity.this.finish();
            }
        });
        this.mNavigationBar.setTitleText(R.string.choose_system_photo);
        this.eXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eXf.setLayoutParams(layoutParams);
        int dimens = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds27);
        this.eXf.setPadding(dimens, 0, dimens, 0);
        jI(false);
        ap.setBackgroundResource(this.eXf, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.eXf, R.color.navbar_btn_color, 1);
        this.eXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChangeSystemPhotoActivity.this.eXk != -1) {
                    ChangeSystemPhotoActivity.this.a((b) ChangeSystemPhotoActivity.this.eXj.get(ChangeSystemPhotoActivity.this.eXk));
                }
            }
        });
        this.eXh = (BdGridView) findViewById(R.id.recommend_photos_list);
        this.eXi = new com.baidu.tbadk.system.portrait.a(getPageContext());
        this.eXh.setAdapter((ListAdapter) this.eXi);
        this.eXh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChangeSystemPhotoActivity.this.eXj != null && ChangeSystemPhotoActivity.this.eXj.size() > 0 && ChangeSystemPhotoActivity.this.eXj.size() > i && ChangeSystemPhotoActivity.this.eXj.get(i) != null) {
                    ChangeSystemPhotoActivity.this.eXk = i;
                    ChangeSystemPhotoActivity.this.jI(true);
                    ChangeSystemPhotoActivity.this.eXi.qX(i);
                    ChangeSystemPhotoActivity.this.eXi.notifyDataSetChanged();
                }
            }
        });
    }

    public void initData() {
        this.eXo = getIntent().getBooleanExtra("need_upload", true);
        this.eXj = new ArrayList<>();
        bvX();
    }

    private void bvX() {
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
                                bVar.qY(popularPortraitsInfo.myItem);
                                bVar.CZ(popularPortraitsInfo.series);
                                ChangeSystemPhotoActivity.this.eXj.add(bVar);
                            }
                        }
                        ChangeSystemPhotoActivity.this.eXi.O(ChangeSystemPhotoActivity.this.eXj);
                        ChangeSystemPhotoActivity.this.eXi.notifyDataSetChanged();
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
            this.eXn = bVar.getUrl();
            c.mR().a(bVar.getUrl(), 10, this.eku, 0, 0, getUniqueId(), new Object[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.eXn));
        }
    }

    public void jI(boolean z) {
        this.eXf.setEnabled(z);
        ap.setBackgroundResource(this.eXf, R.drawable.s_navbar_button_bg);
    }

    public void NY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nE(R.string.enter_forum_cancel_change_tip);
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
        aVar.b(getPageContext()).bia();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eXk != -1) {
                NY();
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
        ap.setBackgroundResource(this.eXf, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.eXf, R.color.navbar_btn_color, 1);
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
    /* loaded from: classes20.dex */
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
                this.mNetwork.addPostData(UgcUBCUtils.UGC_TYPE_PIC_BTN, ChangeSystemPhotoActivity.this.eXm.getImageByte());
                str = this.mNetwork.postMultiNetData();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
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
            ChangeSystemPhotoActivity.this.eXl = null;
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
                if (ChangeSystemPhotoActivity.this.eXp != null) {
                    ChangeSystemPhotoActivity.this.eXp.setDialogVisiable(false);
                }
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    new com.baidu.tbadk.core.view.c().showSuccessToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.eXn);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    if ("flutter".equals(ChangeSystemPhotoActivity.this.getIntent().getStringExtra("from"))) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, ChangeSystemPhotoActivity.this.eXn));
                        return;
                    }
                    return;
                }
                new com.baidu.tbadk.core.view.c().showFailToast(ChangeSystemPhotoActivity.this.getResources().getString(R.string.setdefualt_error));
            }
        }
    }
}
