package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
import c.a.q0.i3.w;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailModel;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupShareModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String PACKAGE_DETAIL_LINK;
    public final String SHARE_URL;
    public PackageDetailListView bdListView;
    public View controllerDivider;
    public c.a.e.a.e dataCallBack;
    public View emationSingleBarIcon;
    public k mAdapter;
    public View mControllerLayout;
    public TbImageView mCoverImage;
    public ImageView mDeletImg;
    public c.a.p0.s.s.a mDeleteDialog;
    public View mDivider;
    public View mDivider2;
    public CustomMessageListener mDownloadCompleteListener;
    public TextView mDownloadNum;
    public NewFaceGroupDownloadModel mFaceGroupDownloadModel;
    public NewFaceGroupShareModel mFaceGroupShareModel;
    public View mHeaderView;
    public TextView mImageNum;
    public View mLeftContainer;
    public ImageView mLeftImg;
    public TextView mLeftTxt;
    public LikeModel mLikeModel;
    public EmotionPackageDetailModel mModel;
    public NavigationBar mNavigationBar;
    public final CustomMessageListener mNetworkChangedMessageListener;
    public NoDataView mNoDataView;
    public NoNetworkView mNoNetworkView;
    public TextView mPackageName;
    public EmotionPackageData mPageData;
    public int mPckId;
    public final CustomMessageListener mRefreshEmotionPackageDetailListener;
    public View mRightContainer;
    public RelativeLayout mRootView;
    public TextView mShareNum;
    public String mTempShareUrl;
    public c.a.p0.s.s.a mUnFollowDialog;
    public HeadImageView mUserAvatar;
    public TextView mUserName;
    public View mVoteContainer;
    public ImageView mVoteImg;
    public TextView mVoteMsg;
    public TextView mVoteTxt;
    public c.a.q0.q0.z.b previewController;
    public int voteSum;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f50248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50249f;

        public a(EmotionPackageDetailActivity emotionPackageDetailActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50249f = emotionPackageDetailActivity;
            this.f50248e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f50248e.t);
                l.M(this.f50249f.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50250a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionPackageDetailActivity emotionPackageDetailActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50250a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && c.a.e.e.p.j.z() && this.f50250a.mModel != null && this.f50250a.mNoDataView != null && this.f50250a.mNoDataView.getVisibility() == 0) {
                this.f50250a.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.f50250a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.mRootView, false, l.g(this.f50250a, R.dimen.ds400));
                this.f50250a.mModel.C(this.f50250a.mPckId);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50251a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionPackageDetailActivity emotionPackageDetailActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50251a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage.getCmd() != 2921063 || this.f50251a.mPageData == null || this.f50251a.mLeftTxt == null || this.f50251a.mLeftContainer == null || this.f50251a.mDownloadNum == null) {
                return;
            }
            SkinManager.setImageResource(this.f50251a.mLeftImg, R.drawable.icon_bar_downloaded);
            this.f50251a.mLeftTxt.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(this.f50251a.mLeftTxt, R.color.CAM_X0109);
            this.f50251a.mLeftContainer.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            this.f50251a.mPageData.download++;
            this.f50251a.mDownloadNum.setText(String.format(this.f50251a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.f50251a.mPageData.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.f50251a.mPageData));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50252e;

        public d(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50252e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50252e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50253e;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f50254e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50254e = eVar;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f50254e.f50253e.deleteEmotion();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public e(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50253e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.e.e.p.j.z()) {
                if (this.f50253e.mDeleteDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.f50253e;
                    emotionPackageDetailActivity.mDeleteDialog = new c.a.p0.s.s.a(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    this.f50253e.mDeleteDialog.setMessageId(R.string.package_delete_confirm_tip);
                    this.f50253e.mDeleteDialog.setPositiveButton(R.string.package_delete_positive_tip, new a(this));
                    this.f50253e.mDeleteDialog.setNegativeButton(R.string.dialog_cancel, new b(this));
                    this.f50253e.mDeleteDialog.setCancelable(true);
                    this.f50253e.mDeleteDialog.create(this.f50253e.getPageContext());
                }
                this.f50253e.mDeleteDialog.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50255a;

        public f(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50255a = emotionPackageDetailActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.f50255a;
                emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.mRootView);
                this.f50255a.mVoteMsg.setVisibility(8);
                this.f50255a.mNoDataView.setVisibility(8);
                this.f50255a.mControllerLayout.setVisibility(0);
                this.f50255a.bdListView.setVisibility(0);
                if (obj != null && (obj instanceof EmotionPackageData)) {
                    this.f50255a.mPageData = (EmotionPackageData) obj;
                    this.f50255a.mAdapter.e(this.f50255a.mPageData.pics);
                    this.f50255a.mCoverImage.setGifIconSupport(false);
                    if (this.f50255a.mPageData.forum_id > 0) {
                        this.f50255a.emationSingleBarIcon.setVisibility(0);
                        this.f50255a.mUserAvatar.startLoad(this.f50255a.mPageData.forum_avatar, 10, false);
                        this.f50255a.mUserName.setText(this.f50255a.mPageData.forum_name);
                    } else {
                        this.f50255a.mUserAvatar.startLoad(this.f50255a.mPageData.avatar, 10, false);
                        this.f50255a.mUserName.setText(this.f50255a.mPageData.author);
                    }
                    this.f50255a.mCoverImage.startLoad(this.f50255a.mPageData.cover, 10, false);
                    this.f50255a.mImageNum.setText(String.format(this.f50255a.getString(R.string.package_detail_num), Integer.valueOf(this.f50255a.mPageData.num)));
                    this.f50255a.mDownloadNum.setText(String.format(this.f50255a.getString(R.string.package_detail_download_num), StringHelper.numFormatOverWan(this.f50255a.mPageData.download)));
                    this.f50255a.mShareNum.setText(String.format(this.f50255a.getString(R.string.package_detail_share_num), StringHelper.numFormatOverWan(this.f50255a.mPageData.share)));
                    this.f50255a.mPackageName.setText(this.f50255a.mPageData.name);
                    if (this.f50255a.mPageData.owner == null || !this.f50255a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.f50255a.mDeletImg.setVisibility(8);
                    } else {
                        this.f50255a.mDeletImg.setVisibility(0);
                        if (this.f50255a.mPageData.status == 4 || this.f50255a.mPageData.status == 2) {
                            this.f50255a.mDeletImg.setEnabled(false);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50255a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                        } else {
                            this.f50255a.mDeletImg.setEnabled(true);
                        }
                    }
                    if (this.f50255a.mPageData.status == 5 && this.f50255a.mPageData.forum_id > 0) {
                        this.f50255a.mVoteContainer.setVisibility(0);
                        this.f50255a.mControllerLayout.setVisibility(8);
                        this.f50255a.mDownloadNum.setVisibility(8);
                        this.f50255a.mShareNum.setVisibility(8);
                        int top = this.f50255a.mUserAvatar.getTop();
                        float bottom = (this.f50255a.mDownloadNum.getBottom() - this.f50255a.mPackageName.getBottom()) + l.g(this.f50255a.getPageContext().getPageActivity(), R.dimen.ds32) + this.f50255a.mUserAvatar.getHeight();
                        this.f50255a.mUserAvatar.setY(bottom);
                        this.f50255a.mUserName.setY(bottom);
                        if (this.f50255a.mPageData.owner == null || !this.f50255a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                            this.f50255a.mVoteMsg.setVisibility(0);
                            TextView textView = this.f50255a.mVoteMsg;
                            EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.f50255a;
                            textView.setText(emotionPackageDetailActivity2.getVoteNumber(emotionPackageDetailActivity2.mPageData.vote_num));
                            this.f50255a.mVoteMsg.setY(top);
                            if (this.f50255a.mPageData.has_vote == 1) {
                                this.f50255a.changeVoteViewState();
                            } else {
                                SkinManager.setBackgroundColor(this.f50255a.mDivider2, R.color.CAM_X0204);
                            }
                        } else {
                            this.f50255a.mVoteTxt.setText(R.string.package_detail_hits);
                            this.f50255a.mVoteImg.setVisibility(8);
                            this.f50255a.mDeletImg.setVisibility(8);
                            this.f50255a.mVoteMsg.setVisibility(8);
                            SkinManager.setViewTextColor(this.f50255a.mVoteTxt, R.color.CAM_X0109);
                            this.f50255a.mVoteContainer.setEnabled(false);
                        }
                    }
                    if (c.a.q0.q0.a.c().e("" + this.f50255a.mPckId)) {
                        this.f50255a.mLeftTxt.setText(R.string.already_downloaded);
                        SkinManager.setViewTextColor(this.f50255a.mLeftTxt, R.color.CAM_X0109);
                        SkinManager.setImageResource(this.f50255a.mLeftImg, R.drawable.icon_bar_downloaded);
                        this.f50255a.mLeftContainer.setEnabled(false);
                        return;
                    }
                    int i2 = this.f50255a.mPageData.status;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.f50255a.mLeftContainer.setVisibility(0);
                            this.f50255a.mLeftTxt.setText(R.string.download);
                            SkinManager.setViewTextColor(this.f50255a.mLeftTxt, R.color.CAM_X0302);
                            SkinManager.setImageResource(this.f50255a.mLeftImg, R.drawable.icon_bar_download);
                            this.f50255a.mLeftContainer.setEnabled(true);
                            return;
                        } else if (i2 == 2) {
                            this.f50255a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.f50255a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.f50255a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50255a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.f50255a.mLeftTxt.setText(R.string.face_package_not_ok);
                            this.f50255a.mLeftContainer.setEnabled(false);
                            return;
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                this.f50255a.mLeftContainer.setVisibility(8);
                                return;
                            }
                            this.f50255a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.f50255a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.f50255a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50255a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.f50255a.mLeftTxt.setText(R.string.face_package_has_delete);
                            this.f50255a.mLeftContainer.setEnabled(false);
                            return;
                        }
                    }
                    this.f50255a.mLeftContainer.setVisibility(0);
                    this.f50255a.mLeftTxt.setText(R.string.download);
                    SkinManager.setViewTextColor(this.f50255a.mLeftTxt, R.color.CAM_X0302);
                    SkinManager.setImageResource(this.f50255a.mLeftImg, R.drawable.icon_bar_download);
                    this.f50255a.mLeftContainer.setEnabled(true);
                    return;
                }
                l.M(this.f50255a.getActivity(), this.f50255a.getResources().getString(R.string.package_detail_load_failed));
                this.f50255a.mNoDataView.setVisibility(0);
                this.f50255a.mControllerLayout.setVisibility(8);
                this.f50255a.bdListView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements EmotionPackageDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50256a;

        public g(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50256a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.d
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    SkinManager.setViewTextColor(this.f50256a.mLeftTxt, R.color.CAM_X0205);
                    this.f50256a.mLeftTxt.setText(R.string.package_already_delete);
                    SkinManager.setImageResource(this.f50256a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.f50256a.mLeftContainer.setEnabled(false);
                    l.L(this.f50256a.getActivity(), R.string.delete_success);
                    this.f50256a.setResult(-1);
                    this.f50256a.finish();
                    return;
                }
                l.L(this.f50256a.getActivity(), R.string.delete_fail);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50257a;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f50258e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50258e = hVar;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f50258e.f50257a.mVoteContainer.setEnabled(true);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f50259e;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50259e = hVar;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f50259e.f50257a.mPageData == null || TextUtils.isEmpty(this.f50259e.f50257a.mPageData.forum_name)) {
                    return;
                }
                this.f50259e.f50257a.doLike();
            }
        }

        public h(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50257a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.e
        public void a(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, this.f50257a.mPageData));
                this.f50257a.changeVoteViewState();
                if (this.f50257a.mVoteMsg != null && this.f50257a.mVoteMsg.isShown()) {
                    TextView textView = this.f50257a.mVoteMsg;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.f50257a;
                    textView.setText(emotionPackageDetailActivity.getVoteNumber(emotionPackageDetailActivity.voteSum + 1));
                }
                l.L(this.f50257a.getActivity(), R.string.package_vote_success);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.f50257a.mUnFollowDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.f50257a;
                    emotionPackageDetailActivity2.mUnFollowDialog = new c.a.p0.s.s.a(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.f50257a.mUnFollowDialog.setMessageId(R.string.package_cant_vote_tips);
                    this.f50257a.mUnFollowDialog.setNegativeButton(R.string.package_cant_vote_negative, new a(this));
                    this.f50257a.mUnFollowDialog.setPositiveButton(R.string.package_cant_vote_positive, new b(this));
                    this.f50257a.mUnFollowDialog.create(this.f50257a.getPageContext());
                    this.f50257a.mUnFollowDialog.setCancelable(true);
                }
                this.f50257a.mUnFollowDialog.show();
            } else {
                this.f50257a.mVoteContainer.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.f50257a.getString(R.string.package_vote_fail);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                l.M(this.f50257a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50260a;

        public i(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50260a = emotionPackageDetailActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f50260a.mLikeModel.getErrorCode() != 22) {
                    if (AntiHelper.m(this.f50260a.mLikeModel.getErrorCode(), this.f50260a.mLikeModel.getErrorString())) {
                        AntiHelper.u(this.f50260a.getPageContext().getPageActivity(), this.f50260a.mLikeModel.getErrorString());
                    } else if (this.f50260a.mLikeModel.getErrorCode() != 0) {
                        l.M(this.f50260a.getActivity(), this.f50260a.mLikeModel.getErrorString());
                        EmotionPackageDetailActivity emotionPackageDetailActivity = this.f50260a;
                        emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.mLikeModel.getErrorString());
                    } else {
                        w wVar = (w) obj;
                        if (wVar != null) {
                            l.L(this.f50260a.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(this.f50260a.mPageData.forum_name);
                            wVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                        } else {
                            l.L(this.f50260a.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    l.L(this.f50260a.getActivity(), R.string.had_liked_forum);
                }
                this.f50260a.mVoteContainer.setEnabled(true);
                this.f50260a.mUnFollowDialog.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50261a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(EmotionPackageDetailActivity emotionPackageDetailActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50261a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.q0.z.a)) {
                c.a.q0.q0.z.a aVar = (c.a.q0.q0.z.a) customResponsedMessage.getData();
                int i2 = aVar.f23874a;
                if (i2 == 0) {
                    l.L(this.f50261a.getActivity(), R.string.down_state_success);
                    SkinManager.setImageResource(this.f50261a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.f50261a.mLeftTxt.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(this.f50261a.mLeftTxt, R.color.CAM_X0109);
                    this.f50261a.mLeftContainer.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.f50261a.mPageData.download++;
                    this.f50261a.mDownloadNum.setText(String.format(this.f50261a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.f50261a.mPageData.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.f50261a.mPageData));
                } else if (i2 == 1) {
                    l.L(this.f50261a.getActivity(), R.string.download_error);
                    this.f50261a.mLeftContainer.setEnabled(true);
                } else if (i2 == 2) {
                    int i3 = aVar.f23875b;
                    if (i3 > 0 && i3 < 100) {
                        l.J(this.f50261a.getActivity(), this.f50261a.getString(R.string.package_downloading_progress));
                    } else if (i3 >= 100) {
                        l.I(this.f50261a.getActivity(), R.string.down_state_success);
                    }
                }
            }
        }
    }

    public EmotionPackageDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
        this.PACKAGE_DETAIL_LINK = "http://tieba.baidu.com/n/interact/emoticon/";
        this.mNetworkChangedMessageListener = new b(this, 2000994);
        this.mRefreshEmotionPackageDetailListener = new c(this, 2921063);
        this.dataCallBack = new f(this);
        this.mDownloadCompleteListener = new j(this, 2921375);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVoteViewState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mVoteTxt.setText(R.string.package_detail_voted);
            SkinManager.setImageResource(this.mVoteImg, R.drawable.icon_bar_voted);
            SkinManager.setViewTextColor(this.mVoteTxt, R.color.CAM_X0109);
            this.mVoteContainer.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.mModel.B(this.mPckId, new g(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLike() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            if (this.mLikeModel == null) {
                this.mLikeModel = new LikeModel(getPageContext());
            }
            this.mLikeModel.setFrom("emotion_vote_follow");
            this.mLikeModel.setLoadDataCallBack(new i(this));
            LikeModel likeModel = this.mLikeModel;
            EmotionPackageData emotionPackageData = this.mPageData;
            likeModel.L(emotionPackageData.forum_name, String.valueOf(emotionPackageData.forum_id));
        }
    }

    private void downloadEmotion() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65577, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.mPckId < 0) {
                return;
            }
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mLeftContainer.setEnabled(false);
            this.mFaceGroupDownloadModel.w(Integer.toString(this.mPckId), Boolean.TRUE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVoteNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, this, str)) == null) {
            try {
                this.voteSum = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return String.format(getResources().getString(R.string.emotion_vote_message), str);
        }
        return (String) invokeL.objValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            if (this.mModel == null) {
                this.mModel = new EmotionPackageDetailModel();
            }
            this.mModel.setLoadDataCallBack(this.dataCallBack);
            this.mModel.C(this.mPckId);
            this.voteSum = 0;
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_face_detail_tip), null);
            SkinManager.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.mDeletImg = new ImageView(getPageContext().getPageActivity());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
            this.mDeletImg.setPadding(0, l.g(this, R.dimen.ds20), l.g(this, R.dimen.ds31), l.g(this, R.dimen.ds20));
            this.mDeletImg.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mDeletImg, new e(this));
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
            if (c.a.e.e.p.j.A()) {
                this.mNoNetworkView.setVisibility(8);
            } else {
                this.mNoNetworkView.setVisibility(0);
            }
            this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.bdListView = (PackageDetailListView) findViewById(R.id.package_image_gridview);
            this.mAdapter = new k(this, null);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
            this.mHeaderView = inflate;
            this.bdListView.addHeaderView(inflate);
            this.mCoverImage = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
            this.emationSingleBarIcon = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
            this.mDivider = this.mHeaderView.findViewById(R.id.divider_line);
            this.mImageNum = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
            this.mPackageName = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
            this.mDownloadNum = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
            this.mShareNum = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
            this.mVoteMsg = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
            HeadImageView headImageView = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
            this.mUserAvatar = headImageView;
            headImageView.setIsRound(true);
            this.mUserAvatar.setOnClickListener(this);
            TextView textView = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
            this.mUserName = textView;
            textView.setOnClickListener(this);
            this.bdListView.setAdapter((ListAdapter) this.mAdapter);
            this.mDivider2 = findViewById(R.id.above_controller_divider);
            this.mControllerLayout = findViewById(R.id.package_controller_layout);
            this.controllerDivider = findViewById(R.id.controller_divider);
            View findViewById = findViewById(R.id.left_function_container);
            this.mLeftContainer = findViewById;
            findViewById.setOnClickListener(this);
            this.mLeftImg = (ImageView) findViewById(R.id.left_img);
            this.mLeftTxt = (TextView) findViewById(R.id.left_txt);
            View findViewById2 = findViewById(R.id.right_function_container);
            this.mRightContainer = findViewById2;
            findViewById2.setOnClickListener(this);
            View findViewById3 = findViewById(R.id.package_vote_container);
            this.mVoteContainer = findViewById3;
            findViewById3.setOnClickListener(this);
            this.mVoteImg = (ImageView) findViewById(R.id.vote_img);
            this.mVoteTxt = (TextView) findViewById(R.id.vote_text);
            this.previewController = new c.a.q0.q0.z.b(this);
        }
    }

    private void shareEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            if (this.mPageData == null) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.mPageData.name;
            shareItem.s = getString(R.string.package_share_content);
            shareItem.t = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.mPckId;
            shareItem.v = Uri.parse(this.mPageData.cover);
            this.mTempShareUrl = shareItem.t;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    private void voteEmotion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65583, this, i2) == null) {
            this.mVoteContainer.setEnabled(false);
            this.mModel.D(i2, new h(this));
        }
    }

    public PackageDetailListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bdListView : (PackageDetailListView) invokeV.objValue;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSwipeBackLayout : (SwipeBackLayout) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 24007 && !TextUtils.isEmpty(this.mTempShareUrl) && this.mTempShareUrl.contains("emoticonpackage") && (split = this.mTempShareUrl.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                String str = split[split.length - 1];
                if (this.mFaceGroupShareModel == null) {
                    this.mFaceGroupShareModel = new NewFaceGroupShareModel();
                }
                this.mFaceGroupShareModel.w(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mRootView);
            SkinManager.setBackgroundColor(this.bdListView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mDownloadNum, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mShareNum, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mPackageName, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0304);
            SkinManager.setViewTextColor(this.mVoteMsg, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mImageNum, R.color.CAM_X0109);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.mControllerLayout, R.color.white_alpha100, i2);
            } else {
                SkinManager.setBackgroundColor(this.mControllerLayout, R.color.common_color_10311, i2);
                SkinManager.setBackgroundColor(this.mVoteContainer, R.color.CAM_X0201_1, i2);
            }
            SkinManager.setBackgroundColor(this.controllerDivider, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.mDivider2, R.color.CAM_X0205);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            c.a.q0.q0.z.b bVar = this.previewController;
            if (bVar != null) {
                bVar.y(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (c.a.e.e.p.j.z()) {
                if (view == this.mLeftContainer) {
                    downloadEmotion();
                } else if (view == this.mRightContainer) {
                    shareEmotion();
                } else if (view != this.mUserAvatar && view != this.mUserName) {
                    if (view == this.mVoteContainer) {
                        voteEmotion(this.mPckId);
                    }
                } else {
                    EmotionPackageData emotionPackageData = this.mPageData;
                    if (emotionPackageData == null || TextUtils.isEmpty(emotionPackageData.owner)) {
                        return;
                    }
                    if (this.mPageData.forum_id > 0) {
                        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mPageData.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(c.a.e.e.m.b.f(this.mPageData.owner, 0L), this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra("pck_id", -1);
            this.mPckId = intExtra;
            if (intExtra < 0) {
                finish();
                return;
            }
            setContentView(R.layout.emotion_package_detail_activity);
            initUI();
            showLoadingView(this.mRootView, false, l.g(this, R.dimen.ds400));
            initData();
            registerListener(this.mNetworkChangedMessageListener);
            registerListener(this.mRefreshEmotionPackageDetailListener);
            registerListener(this.mDownloadCompleteListener);
            TiebaStatic.log("c12330");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            EmotionPackageDetailModel emotionPackageDetailModel = this.mModel;
            if (emotionPackageDetailModel != null) {
                emotionPackageDetailModel.cancelLoadData();
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.mFaceGroupDownloadModel;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.mFaceGroupShareModel;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            c.a.q0.q0.z.b bVar = this.previewController;
            if (bVar != null) {
                bVar.s();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f50262e;

        /* renamed from: f  reason: collision with root package name */
        public int f50263f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f50264g;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f50265e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TbImageView f50266f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f50267g;

            public a(k kVar, int i2, TbImageView tbImageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), tbImageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50267g = kVar;
                this.f50265e = i2;
                this.f50266f = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageData.SingleEmotionData singleEmotionData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.f50267g.f50262e.get(this.f50265e)) == null || singleEmotionData.id < 0 || this.f50267g.f50264g.mPckId < 0 || !c.a.e.e.p.j.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.f50267g.f50264g.getPageContext().getPageActivity(), this.f50267g.f50264g.mPckId, singleEmotionData.id, this.f50266f.isGif());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.f50267g.f50264g.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes7.dex */
        public class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f50268a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f50269b;

            /* renamed from: c  reason: collision with root package name */
            public TbImageView f50270c;

            /* renamed from: d  reason: collision with root package name */
            public TbImageView f50271d;

            public b(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public TbImageView a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return null;
                                }
                                return this.f50271d;
                            }
                            return this.f50270c;
                        }
                        return this.f50269b;
                    }
                    return this.f50268a;
                }
                return (TbImageView) invokeI.objValue;
            }

            public /* synthetic */ b(k kVar, b bVar) {
                this(kVar);
            }
        }

        public k(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50264g = emotionPackageDetailActivity;
            this.f50262e = new ArrayList();
            this.f50263f = (l.k(TbadkCoreApplication.getInst()) - l.g(this.f50264g.getActivity(), R.dimen.ds230)) / 4;
        }

        public final void c(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) {
                for (int i3 = 0; i3 < 4; i3++) {
                    TbImageView a2 = bVar.a(i3);
                    if (a2 != null) {
                        int i4 = (i2 * 4) + i3;
                        if (i4 < this.f50262e.size() && i4 >= 0) {
                            a2.setVisibility(0);
                            a2.setTag(null);
                            a2.setDefaultResource(R.drawable.img_default_100);
                            a2.startLoad(this.f50262e.get(i4).thumbnail, 10, false);
                            a2.invalidate();
                            a2.setOnClickListener(new a(this, i4, a2));
                        } else {
                            a2.setVisibility(4);
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: d */
        public List<EmotionPackageData.SingleEmotionData> getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                ArrayList arrayList = new ArrayList();
                for (int size = this.f50262e.size() / 4; size < (this.f50262e.size() / 4) + 4; size++) {
                    if (size > 0 && size < this.f50262e.size()) {
                        arrayList.add(this.f50262e.get(size));
                    }
                }
                return this.f50262e;
            }
            return (List) invokeI.objValue;
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
                return;
            }
            this.f50262e.clear();
            this.f50262e.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.f50262e.size() / 4;
                return this.f50262e.size() % 4 > 0 ? size + 1 : size;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View view2;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    bVar = new b(this, null);
                    view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                    TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.package_item_image1);
                    bVar.f50268a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.f50263f;
                    bVar.f50268a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.f50268a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.package_item_image2);
                    bVar.f50269b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.f50263f;
                    bVar.f50269b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.f50269b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.package_item_image3);
                    bVar.f50270c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.f50263f;
                    bVar.f50270c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.f50270c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.package_item_image4);
                    bVar.f50271d = tbImageView4;
                    ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                    layoutParams4.height = this.f50263f;
                    bVar.f50271d.setLayoutParams(layoutParams4);
                    SkinManager.setBackgroundColor(bVar.f50271d, R.color.CAM_X0201);
                    view2.setTag(bVar);
                } else {
                    view2 = view;
                    bVar = (b) view.getTag();
                }
                c(i2, bVar);
                return view2;
            }
            return (View) invokeILL.objValue;
        }

        public /* synthetic */ k(EmotionPackageDetailActivity emotionPackageDetailActivity, b bVar) {
            this(emotionPackageDetailActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVoteNumber(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65578, this, i2)) == null) {
            this.voteSum = i2;
            return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i2));
        }
        return (String) invokeI.objValue;
    }
}
