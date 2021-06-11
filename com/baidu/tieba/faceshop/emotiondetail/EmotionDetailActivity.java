package com.baidu.tieba.faceshop.emotiondetail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel;
import com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.n0.m0.u;
import d.a.n0.m0.v;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionDetailActivity extends BaseActivity<EmotionDetailActivity> {
    public View divider;
    public View divider2;
    public View dividerVertical;
    public boolean isGif;
    public ImageView mAddImage;
    public TextView mAddText;
    public View mBottomContainer;
    public View mBottomLeftContainer;
    public View mBottomRightContainer;
    public TbImageView mCoverImage;
    public EmotionDetailData mEmotionDetailData;
    public EmotionDetailImageView mEmotionDetailImageView;
    public EmotionDetailModel mEmotionDetailModel;
    public TextView mEmotionPackageControlTv;
    public TextView mEmotionPackageName;
    public NewFaceGroupDownloadModel mFaceGroupDownloadModel;
    public TextView mForumAndDownloadNum;
    public boolean mIsFromEmotionPackage;
    public PopupWindow mManageEmotionPopupWindow;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public NoNetworkView mNoNetworkView;
    public PermissionJudgePolicy mPermissionJudgement;
    public LinearLayout mPopBottomLayout;
    public TextView mPopCancelTv;
    public TextView mPopDeleteEmotionTipsTv;
    public TextView mPopDeleteEmotionTv;
    public View mPopLine1;
    public View mPopLine2;
    public View mRootView;
    public ImageView mSaveLocalImage;
    public TextView mSaveLocalText;
    public View mTopContainer;
    public int pck_id;
    public long pic_id;
    public ImageView shareImage;
    public final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticon/";
    public final CustomMessageListener mNetworkChangedMessageListener = new b(2000994);
    public d.a.c.a.e mLoadDataCallBack = new f();

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.z1.e.b {
        public a() {
        }

        @Override // d.a.n0.z1.e.b
        public void onFail(String str) {
            l.M(EmotionDetailActivity.this.getPageContext().getPageActivity(), str);
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            l.L(EmotionDetailActivity.this.getPageContext().getPageActivity(), R.string.save_success);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.j.z() && EmotionDetailActivity.this.mNoDataView != null && EmotionDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionDetailActivity emotionDetailActivity = EmotionDetailActivity.this;
                emotionDetailActivity.showLoadingView(emotionDetailActivity.mRootView, false, l.g(EmotionDetailActivity.this, R.dimen.ds400));
                EmotionDetailActivity.this.mEmotionDetailModel.y(EmotionDetailActivity.this.pic_id, EmotionDetailActivity.this.pck_id);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmotionDetailActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EmotionDetailActivity.this.mIsFromEmotionPackage) {
                return;
            }
            EmotionDetailActivity.this.navigateToEmotionPackagePage();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f14903e;

        public e(View view) {
            this.f14903e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int top = this.f14903e.findViewById(R.id.id_pop_layout).getTop();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 1 && y < top) {
                EmotionDetailActivity.this.mManageEmotionPopupWindow.dismiss();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.a.e {
        public f() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            EmotionDetailActivity emotionDetailActivity = EmotionDetailActivity.this;
            emotionDetailActivity.hideLoadingView(emotionDetailActivity.mRootView);
            EmotionDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionDetailActivity.this.mBottomContainer.setVisibility(0);
            EmotionDetailActivity.this.mTopContainer.setVisibility(0);
            EmotionDetailActivity.this.mEmotionDetailImageView.setVisibility(0);
            if (obj != null) {
                EmotionDetailActivity.this.mEmotionDetailData = (EmotionDetailData) obj;
                if (EmotionDetailActivity.this.mEmotionDetailData.pic_info != null && !TextUtils.isEmpty(EmotionDetailActivity.this.mEmotionDetailData.pic_info.pic_url)) {
                    EmotionDetailActivity.this.mEmotionDetailImageView.f(EmotionDetailActivity.this.mEmotionDetailData, 33, EmotionDetailActivity.this.isGif);
                }
                if (EmotionDetailActivity.this.mEmotionDetailData.pck_info == null || TextUtils.isEmpty(EmotionDetailActivity.this.mEmotionDetailData.pck_info.cover)) {
                    EmotionDetailActivity.this.mTopContainer.setVisibility(8);
                } else {
                    EmotionDetailActivity.this.mCoverImage.U(EmotionDetailActivity.this.mEmotionDetailData.pck_info.cover, 10, false);
                    if (EmotionDetailActivity.this.mEmotionDetailData.pck_info.forum_name != null) {
                        TextView textView = EmotionDetailActivity.this.mForumAndDownloadNum;
                        String string = EmotionDetailActivity.this.getString(R.string.forum_and_download_num);
                        textView.setText(String.format(string, EmotionDetailActivity.this.mEmotionDetailData.pck_info.forum_name + EmotionDetailActivity.this.getString(R.string.forum), StringHelper.numFormatOverWan(d.a.c.e.m.b.f(EmotionDetailActivity.this.mEmotionDetailData.pck_info.download, 0L))));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) EmotionDetailActivity.this.getString(R.string.emotion_center_single_bar_top)).append((CharSequence) " ").append((CharSequence) EmotionDetailActivity.this.mEmotionDetailData.pck_info.pck_name);
                        spannableStringBuilder.setSpan(new d.a.c.k.b(EmotionDetailActivity.this.getPageContext().getPageActivity(), R.drawable.emotion_pic_single_bar), 0, 2, 17);
                        EmotionDetailActivity.this.mEmotionPackageName.setText(spannableStringBuilder);
                    } else {
                        EmotionDetailActivity.this.mEmotionPackageName.setText(EmotionDetailActivity.this.mEmotionDetailData.pck_info.pck_name);
                        EmotionDetailActivity.this.mForumAndDownloadNum.setText(String.format(EmotionDetailActivity.this.getString(R.string.forum_and_download_num), EmotionDetailActivity.this.mEmotionDetailData.pck_info.owner.user_name, StringHelper.numFormatOverWan(d.a.c.e.m.b.f(EmotionDetailActivity.this.mEmotionDetailData.pck_info.download, 0L))));
                    }
                }
                d.a.n0.m0.a c2 = d.a.n0.m0.a.c();
                if (c2.e("" + EmotionDetailActivity.this.pck_id)) {
                    EmotionDetailActivity.this.mEmotionPackageControlTv.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(EmotionDetailActivity.this.mEmotionPackageControlTv, R.color.CAM_X0109);
                    EmotionDetailActivity.this.mEmotionPackageControlTv.setEnabled(false);
                    SkinManager.setBackgroundColor(EmotionDetailActivity.this.mEmotionPackageControlTv, R.color.transparent);
                } else {
                    EmotionDetailActivity.this.mEmotionPackageControlTv.setText(R.string.download);
                    SkinManager.setViewTextColor(EmotionDetailActivity.this.mEmotionPackageControlTv, R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(EmotionDetailActivity.this.mEmotionPackageControlTv, R.drawable.bg_emotion_download);
                }
                if (v.e().f(StringUtils.string(Long.valueOf(EmotionDetailActivity.this.mEmotionDetailData.pic_info.pic_id)))) {
                    SkinManager.setImageResource(EmotionDetailActivity.this.mAddImage, R.drawable.icon_bar_collectioned);
                    EmotionDetailActivity.this.mAddText.setText(R.string.emotion_detail_collectioned);
                    SkinManager.setViewTextColor(EmotionDetailActivity.this.mAddText, R.color.CAM_X0302);
                    return;
                }
                SkinManager.setImageResource(EmotionDetailActivity.this.mAddImage, R.drawable.icon_bar_collection_emotion);
                SkinManager.setViewTextColor(EmotionDetailActivity.this.mAddText, R.color.CAM_X0302);
                return;
            }
            l.M(EmotionDetailActivity.this.getActivity(), EmotionDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionDetailActivity.this.mBottomContainer.setVisibility(8);
            EmotionDetailActivity.this.mTopContainer.setVisibility(8);
            EmotionDetailActivity.this.mEmotionDetailImageView.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f14906e;

        public g(ShareItem shareItem) {
            this.f14906e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f14906e.t);
            l.M(EmotionDetailActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.n0.z1.e.b {
        public h() {
        }

        @Override // d.a.n0.z1.e.b
        public void onFail(String str) {
            l.L(EmotionDetailActivity.this.getActivity(), R.string.download_error);
            EmotionDetailActivity.this.mEmotionPackageControlTv.setEnabled(true);
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(EmotionDetailActivity.this.getActivity(), EmotionDetailActivity.this.getString(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(EmotionDetailActivity.this.getActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            l.L(EmotionDetailActivity.this.getActivity(), R.string.down_state_success);
            EmotionDetailActivity.this.mEmotionPackageControlTv.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(EmotionDetailActivity.this.mEmotionPackageControlTv, R.color.CAM_X0109);
            EmotionDetailActivity.this.mEmotionPackageControlTv.setEnabled(false);
            SkinManager.setBackgroundColor(EmotionDetailActivity.this.mEmotionPackageControlTv, R.color.transparent);
            TextView textView = EmotionDetailActivity.this.mForumAndDownloadNum;
            String string = EmotionDetailActivity.this.getString(R.string.forum_and_download_num);
            textView.setText(String.format(string, EmotionDetailActivity.this.mEmotionDetailData.pck_info.owner.user_name, StringHelper.numberUniform(d.a.c.e.m.b.f(EmotionDetailActivity.this.mEmotionDetailData.pck_info.download + 1, 0L))));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921063));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {

        /* loaded from: classes4.dex */
        public class a implements u.l {
            public a() {
            }

            @Override // d.a.n0.m0.u.l
            public void onResult(int i2, int i3, int i4) {
                if (i3 > 0 && i2 == 1) {
                    SkinManager.setImageResource(EmotionDetailActivity.this.mAddImage, R.drawable.icon_bar_collection_emotion);
                    EmotionDetailActivity.this.mAddText.setText(R.string.emotion_detail_collection);
                    l.L(TbadkCoreApplication.getInst(), R.string.delete_success);
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.delete_fail);
            }
        }

        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            List<CollectEmotionData> n = d.a.n0.m0.g.k().n(TbadkCoreApplication.getCurrentAccount());
            if (n == null || n.size() < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<CollectEmotionData> it = n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CollectEmotionData next = it.next();
                if (!d.a.m0.a0.d.f52490d.equals(next.sharpText) && !TextUtils.isEmpty(next.pid)) {
                    String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + d.a.m0.a0.d.b() + "/" + next.pid + "_s.jpg";
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(str);
                    File file = new File(str);
                    if (file.exists() && file.length() > 0 && next.pid.equals(StringUtils.string(Long.valueOf(EmotionDetailActivity.this.pic_id)))) {
                        imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                        next.imageFileInfo = imageFileInfo;
                        arrayList.add(next);
                        break;
                    }
                }
            }
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            u.s().l(list, true, new a());
        }
    }

    /* loaded from: classes4.dex */
    public class j implements u.l {
        public j() {
        }

        @Override // d.a.n0.m0.u.l
        public void onResult(int i2, int i3, int i4) {
            if (i2 == 4) {
                if (i3 == 1) {
                    SkinManager.setImageResource(EmotionDetailActivity.this.mAddImage, R.drawable.icon_bar_collectioned);
                    EmotionDetailActivity.this.mAddText.setText(R.string.emotion_detail_collectioned);
                    l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            }
        }
    }

    private void collectionEmotion() {
        EmotionDetailData.PicInfo picInfo = this.mEmotionDetailData.pic_info;
        if (picInfo == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 25031)));
        } else if (v.e().f(StringUtils.string(Long.valueOf(this.mEmotionDetailData.pic_info.pic_id)))) {
            if (this.mManageEmotionPopupWindow != null) {
                Rect rect = new Rect();
                getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.mManageEmotionPopupWindow.showAtLocation(this.mRootView, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            }
        } else {
            EmotionDetailData emotionDetailData = this.mEmotionDetailData;
            String str = emotionDetailData.pic_info.pic_url;
            EmotionDetailData.PckInfo pckInfo = emotionDetailData.pck_info;
            int i2 = pckInfo == null ? 0 : pckInfo.pck_id;
            d.a.m0.b0.c cVar = new d.a.m0.b0.c();
            cVar.f52587d = str;
            cVar.f52589f = StringUtils.string(Integer.valueOf(i2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            u.s().h(arrayList, true, new j());
        }
    }

    private void deleteCollection() {
        new i().execute(new Void[0]);
    }

    private void downloadEmotion() {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && this.pck_id >= 0) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mEmotionPackageControlTv.setEnabled(false);
            this.mFaceGroupDownloadModel.w(StringUtils.string(Integer.valueOf(this.pck_id)), Boolean.TRUE, new h());
        }
    }

    private void initData() {
        if (this.mEmotionDetailModel == null) {
            this.mEmotionDetailModel = new EmotionDetailModel();
        }
        this.mEmotionDetailModel.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mEmotionDetailModel.y(this.pic_id, this.pck_id);
    }

    private void initPopupWindow() {
        this.mManageEmotionPopupWindow = new PopupWindow(getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_detail_popuwindow_layout, (ViewGroup) null);
        this.mPopBottomLayout = (LinearLayout) inflate.findViewById(R.id.id_pop_layout);
        this.mPopLine1 = inflate.findViewById(R.id.line1);
        this.mPopLine2 = inflate.findViewById(R.id.line2);
        this.mPopDeleteEmotionTipsTv = (TextView) inflate.findViewById(R.id.tv_delete_emotion_tips);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_delete_my_emotion);
        this.mPopDeleteEmotionTv = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.mPopCancelTv = textView2;
        textView2.setOnClickListener(this);
        this.mManageEmotionPopupWindow.setContentView(inflate);
        this.mManageEmotionPopupWindow.setWidth(-1);
        this.mManageEmotionPopupWindow.setHeight(l.i(getPageContext().getPageActivity()) - d.a.c.e.p.a.b(getPageContext().getPageActivity()));
        this.mManageEmotionPopupWindow.setFocusable(true);
        this.mManageEmotionPopupWindow.setBackgroundDrawable(new ColorDrawable(this.mManageEmotionPopupWindow.getContentView().getResources().getColor(R.color.black_alpha50)));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                declaredField.setAccessible(true);
                declaredField.set(this.mManageEmotionPopupWindow, Boolean.TRUE);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
        inflate.setOnTouchListener(new e(inflate));
    }

    private void initUI() {
        this.mRootView = findViewById(R.id.emotion_detail_container);
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this, R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_face_detail_tip), null);
        this.mNoDataView = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.emotion_detail)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        this.mNoNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
        if (d.a.c.e.p.j.A()) {
            this.mNoNetworkView.setVisibility(8);
        } else {
            this.mNoNetworkView.setVisibility(0);
        }
        this.mNoNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.shareImage = new ImageView(getPageContext().getPageActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.shareImage.setPadding(0, l.g(this, R.dimen.ds20), l.g(this, R.dimen.ds31), l.g(this, R.dimen.ds20));
        this.shareImage.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.shareImage, this);
        this.mEmotionDetailImageView = (EmotionDetailImageView) findViewById(R.id.emotion_detail_image_view);
        View findViewById = findViewById(R.id.emotion_detail_top_container);
        this.mTopContainer = findViewById;
        findViewById.setOnClickListener(new d());
        this.mBottomContainer = findViewById(R.id.emotion_detail_bottom_container);
        this.divider = findViewById(R.id.divider);
        this.divider2 = findViewById(R.id.divider2);
        this.dividerVertical = findViewById(R.id.controller_divider);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.emotion_package_cover);
        this.mCoverImage = tbImageView;
        tbImageView.setGifIconSupport(false);
        this.mBottomRightContainer = findViewById(R.id.right_function_container);
        View findViewById2 = findViewById(R.id.left_function_container);
        this.mBottomLeftContainer = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mBottomRightContainer.setOnClickListener(this);
        this.mAddImage = (ImageView) findViewById(R.id.add_emotion_img);
        this.mAddText = (TextView) findViewById(R.id.add_emotion_txt);
        this.mSaveLocalImage = (ImageView) findViewById(R.id.save_to_local_img);
        this.mSaveLocalText = (TextView) findViewById(R.id.save_to_local_txt);
        TextView textView = (TextView) findViewById(R.id.emotion_detail_owner_and_download_num);
        this.mForumAndDownloadNum = textView;
        textView.setOnClickListener(null);
        this.mEmotionPackageName = (TextView) findViewById(R.id.emotion_package_name);
        TextView textView2 = (TextView) findViewById(R.id.emotion_download_tv);
        this.mEmotionPackageControlTv = textView2;
        textView2.setOnClickListener(this);
        initPopupWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToEmotionPackagePage() {
        EmotionDetailData.PckInfo pckInfo;
        int i2;
        EmotionDetailData emotionDetailData = this.mEmotionDetailData;
        if (emotionDetailData == null || (pckInfo = emotionDetailData.pck_info) == null || (i2 = pckInfo.pck_id) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this, i2, 25024)));
    }

    private void saveEmotion() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return;
        }
        String str = this.mEmotionDetailData.pic_info.pic_url;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.z1.c.i().d(str, new a());
    }

    private void shareEmotion() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.mEmotionDetailData == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        EmotionDetailData.PicInfo picInfo = this.mEmotionDetailData.pic_info;
        if (picInfo != null && !StringUtils.isNull(picInfo.pic_url)) {
            shareItem.v = Uri.parse(this.mEmotionDetailData.pic_info.pic_url);
        }
        EmotionDetailData.PckInfo pckInfo = this.mEmotionDetailData.pck_info;
        if (pckInfo != null && !StringUtils.isNull(pckInfo.pck_name)) {
            shareItem.r = this.mEmotionDetailData.pck_info.pck_name;
        } else {
            shareItem.r = getString(R.string.tieba_emotion_share);
        }
        shareItem.s = getString(R.string.package_share_content);
        shareItem.t = "http://tieba.baidu.com/n/interact/emoticon/" + this.pck_id + "/" + this.mEmotionDetailData.pic_info.pic_id;
        shareItem.W = 2;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new g(shareItem));
        sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        super.changeSkinType(i2);
        this.mSkinType = i2;
        this.mNoDataView.f(getPageContext(), i2);
        this.mNoNetworkView.c(getPageContext(), i2);
        SkinManager.setImageResource(this.mSaveLocalImage, R.drawable.icon_bar_download);
        SkinManager.setViewTextColor(this.mSaveLocalText, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.divider2, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.divider, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mForumAndDownloadNum, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.mEmotionPackageName, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.dividerVertical, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.mPopBottomLayout, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.mPopLine1, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.mPopLine2, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mPopDeleteEmotionTv, R.color.cp_cont_r);
        SkinManager.setViewTextColor(this.mPopCancelTv, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.mPopDeleteEmotionTipsTv, R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.shareImage, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, null);
        if (i2 != 1 && i2 != 4) {
            SkinManager.setBackgroundColor(this.mBottomContainer, R.color.white_alpha100, i2);
        } else {
            SkinManager.setBackgroundColor(this.mBottomContainer, R.color.common_color_10311, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 25031) {
            collectionEmotion();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (d.a.c.e.p.j.z()) {
            if (view == this.mBottomRightContainer) {
                saveEmotion();
            } else if (view == this.mBottomLeftContainer) {
                collectionEmotion();
            } else if (view == this.mEmotionPackageControlTv) {
                downloadEmotion();
            } else if (view == this.mPopCancelTv) {
                this.mManageEmotionPopupWindow.dismiss();
            } else if (view == this.mPopDeleteEmotionTv) {
                deleteCollection();
                this.mManageEmotionPopupWindow.dismiss();
            } else if (view == this.shareImage) {
                shareEmotion();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pic_id = getIntent().getLongExtra(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, -1L);
        this.pck_id = getIntent().getIntExtra("pck_id", -1);
        this.isGif = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_IS_GIF_KEY, false);
        this.mIsFromEmotionPackage = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, false);
        if (this.pic_id < 0 && this.pck_id < 0) {
            finish();
        }
        setContentView(R.layout.emotion_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, l.g(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EmotionDetailModel emotionDetailModel = this.mEmotionDetailModel;
        if (emotionDetailModel != null) {
            emotionDetailModel.cancelLoadData();
        }
        NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.mFaceGroupDownloadModel;
        if (newFaceGroupDownloadModel != null) {
            newFaceGroupDownloadModel.cancelLoadData();
        }
    }
}
