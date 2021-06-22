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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    public d.a.n0.r.f0.a mLoadingDialog;
    public NavigationBar mNavigationBar = null;
    public TextView mDoneButton = null;
    public View mBackButton = null;
    public BdGridView mGridView = null;
    public LinearLayout mRootView = null;
    public d.a.n0.u0.a.a mAdapter = null;
    public ArrayList<d.a.n0.u0.a.b> recommendPhotos = null;
    public int currentChoosedID = -1;
    public h mResetTask = null;
    public d.a.c.k.d.a mPhotoData = null;
    public String currentUrl = null;
    public boolean needUpload = true;
    public d.a.c.e.l.c<d.a.c.k.d.a> mCallback = new g();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChangeSystemPhotoActivity.this.currentChoosedID != -1) {
                ChangeSystemPhotoActivity.this.showDialog();
                return;
            }
            ChangeSystemPhotoActivity.this.setResult(0);
            ChangeSystemPhotoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChangeSystemPhotoActivity.this.currentChoosedID != -1) {
                ChangeSystemPhotoActivity changeSystemPhotoActivity = ChangeSystemPhotoActivity.this;
                changeSystemPhotoActivity.resetUserPortraits((d.a.n0.u0.a.b) changeSystemPhotoActivity.recommendPhotos.get(ChangeSystemPhotoActivity.this.currentChoosedID));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (ChangeSystemPhotoActivity.this.recommendPhotos == null || ChangeSystemPhotoActivity.this.recommendPhotos.size() <= 0 || ChangeSystemPhotoActivity.this.recommendPhotos.size() <= i2 || ChangeSystemPhotoActivity.this.recommendPhotos.get(i2) == null) {
                return;
            }
            ChangeSystemPhotoActivity.this.currentChoosedID = i2;
            ChangeSystemPhotoActivity.this.changeDoneButtonState(true);
            ChangeSystemPhotoActivity.this.mAdapter.b(i2);
            ChangeSystemPhotoActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GetPopularPortraitsCallback {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            List<GetPopularPortraitsInfoResult.PopularPortraitsInfo> list;
            if (getPopularPortraitsInfoResult == null || (list = getPopularPortraitsInfoResult.popularPortraitsInfoList) == null || list.size() <= 0) {
                return;
            }
            for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                    d.a.n0.u0.a.b bVar = new d.a.n0.u0.a.b();
                    bVar.d(popularPortraitsInfo.url);
                    bVar.c(popularPortraitsInfo.num);
                    bVar.b(popularPortraitsInfo.myItem);
                    ChangeSystemPhotoActivity.this.recommendPhotos.add(bVar);
                }
            }
            ChangeSystemPhotoActivity.this.mAdapter.c(ChangeSystemPhotoActivity.this.recommendPhotos);
            ChangeSystemPhotoActivity.this.mAdapter.notifyDataSetChanged();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            ChangeSystemPhotoActivity.this.setResult(0);
            ChangeSystemPhotoActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((g) aVar, str, i2);
            if (aVar == null) {
                return;
            }
            ChangeSystemPhotoActivity changeSystemPhotoActivity = ChangeSystemPhotoActivity.this;
            if (changeSystemPhotoActivity.mLoadingDialog == null) {
                changeSystemPhotoActivity.mLoadingDialog = new d.a.n0.r.f0.a(changeSystemPhotoActivity.getPageContext());
                ChangeSystemPhotoActivity.this.mLoadingDialog.e(null);
            }
            ChangeSystemPhotoActivity.this.mLoadingDialog.h(true);
            if (ChangeSystemPhotoActivity.this.needUpload) {
                ChangeSystemPhotoActivity.this.mPhotoData = aVar;
                if (ChangeSystemPhotoActivity.this.mResetTask != null) {
                    ChangeSystemPhotoActivity.this.mResetTask.cancel();
                }
                ChangeSystemPhotoActivity.this.mResetTask = new h(ChangeSystemPhotoActivity.this, null);
                ChangeSystemPhotoActivity.this.mResetTask.execute(new String[0]);
                return;
            }
            Bitmap p = aVar.p();
            if (p != null) {
                if (!ChangeSystemPhotoActivity.this.saveFile(TbConfig.PERSON_USER_PIC_TEMP_FILE, p)) {
                    d.a.n0.r.f0.a aVar2 = ChangeSystemPhotoActivity.this.mLoadingDialog;
                    if (aVar2 != null) {
                        aVar2.h(false);
                        return;
                    }
                    return;
                }
                d.a.n0.r.f0.a aVar3 = ChangeSystemPhotoActivity.this.mLoadingDialog;
                if (aVar3 != null) {
                    aVar3.h(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                ChangeSystemPhotoActivity.this.setResult(-1, intent);
                ChangeSystemPhotoActivity.this.finish();
                return;
            }
            d.a.n0.r.f0.a aVar4 = ChangeSystemPhotoActivity.this.mLoadingDialog;
            if (aVar4 != null) {
                aVar4.h(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f13088a;

        public h() {
            this.f13088a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ChangeSystemPhotoActivity.this.mResetTask = null;
            NetWork netWork = this.f13088a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Exception e2;
            String str;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            this.f13088a = netWork;
            try {
                netWork.addPostData("pic", ChangeSystemPhotoActivity.this.mPhotoData.n());
                str = this.f13088a.postMultiNetData();
            } catch (Exception e3) {
                e2 = e3;
                str = null;
            }
            try {
            } catch (Exception e4) {
                e2 = e4;
                BdLog.e(e2.getMessage());
                return str;
            }
            if (this.f13088a.getNetContext().getResponse().isRequestSuccess()) {
                return str;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.f13088a != null) {
                d.a.n0.r.f0.a aVar = ChangeSystemPhotoActivity.this.mLoadingDialog;
                if (aVar != null) {
                    aVar.h(false);
                }
                if (this.f13088a.getNetContext().getResponse().isRequestSuccess()) {
                    new d.a.n0.r.f0.c().c(ChangeSystemPhotoActivity.this.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, ChangeSystemPhotoActivity.this.currentUrl);
                    intent.putExtra("upload_image_type", 1);
                    ChangeSystemPhotoActivity.this.setResult(-1, intent);
                    ChangeSystemPhotoActivity.this.finish();
                    if ("flutter".equals(ChangeSystemPhotoActivity.this.getIntent().getStringExtra("from"))) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, ChangeSystemPhotoActivity.this.currentUrl));
                        return;
                    }
                    return;
                }
                new d.a.n0.r.f0.c().b(ChangeSystemPhotoActivity.this.getResources().getString(R.string.setdefualt_error));
            }
        }

        public /* synthetic */ h(ChangeSystemPhotoActivity changeSystemPhotoActivity, a aVar) {
            this();
        }
    }

    private void getPopularPortraits() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            return;
        }
        SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new d(), session.bduss);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str, Bitmap bitmap) {
        try {
            FileHelper.SaveFile(null, str, bitmap, 80);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return false;
        }
    }

    public void changeDoneButtonState(boolean z) {
        this.mDoneButton.setEnabled(z);
        SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
    }

    public void initData() {
        this.needUpload = getIntent().getBooleanExtra("need_upload", true);
        this.recommendPhotos = new ArrayList<>();
        getPopularPortraits();
    }

    public void initUI() {
        this.mRootView = (LinearLayout) findViewById(R.id.change_system_photo_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBackButton = addSystemImageButton;
        addSystemImageButton.setOnClickListener(new a());
        this.mNavigationBar.setTitleText(R.string.choose_system_photo);
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
        this.mDoneButton = addTextButton;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.mDoneButton.setLayoutParams(layoutParams);
        int g2 = l.g(getPageContext().getPageActivity(), R.dimen.tbds27);
        this.mDoneButton.setPadding(g2, 0, g2, 0);
        changeDoneButtonState(false);
        SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
        this.mDoneButton.setOnClickListener(new b());
        this.mGridView = (BdGridView) findViewById(R.id.recommend_photos_list);
        d.a.n0.u0.a.a aVar = new d.a.n0.u0.a.a(getPageContext());
        this.mAdapter = aVar;
        this.mGridView.setAdapter((ListAdapter) aVar);
        this.mGridView.setOnItemClickListener(new c());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.change_system_photo_layout);
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.currentChoosedID != -1) {
                showDialog();
                return true;
            }
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void resetUserPortraits(d.a.n0.u0.a.b bVar) {
        if (bVar == null || StringUtils.isNull(bVar.a())) {
            return;
        }
        this.currentUrl = bVar.a();
        d.a.c.e.l.d.h().k(bVar.a(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.currentUrl));
    }

    public void showDialog() {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessageId(R.string.enter_forum_cancel_change_tip);
        aVar.setNegativeButton(R.string.cancel, new e());
        aVar.setPositiveButton(R.string.confirm, new f());
        aVar.create(getPageContext()).show();
    }
}
