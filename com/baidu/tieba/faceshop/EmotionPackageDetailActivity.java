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
import b.a.e.f.p.l;
import b.a.q0.s.s.a;
import b.a.r0.m3.x;
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
/* loaded from: classes9.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String PACKAGE_DETAIL_LINK;
    public final String SHARE_URL;
    public PackageDetailListView bdListView;
    public View controllerDivider;
    public b.a.e.a.e dataCallBack;
    public View emationSingleBarIcon;
    public k mAdapter;
    public View mControllerLayout;
    public TbImageView mCoverImage;
    public ImageView mDeletImg;
    public b.a.q0.s.s.a mDeleteDialog;
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
    public b.a.q0.s.s.a mUnFollowDialog;
    public HeadImageView mUserAvatar;
    public TextView mUserName;
    public View mVoteContainer;
    public ImageView mVoteImg;
    public TextView mVoteMsg;
    public TextView mVoteTxt;
    public b.a.r0.s0.z.b previewController;
    public int voteSum;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f48700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48701f;

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
            this.f48701f = emotionPackageDetailActivity;
            this.f48700e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.p.a.a(this.f48700e.t);
                l.M(this.f48701f.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48702a;

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
            this.f48702a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && b.a.e.f.p.j.z() && this.f48702a.mModel != null && this.f48702a.mNoDataView != null && this.f48702a.mNoDataView.getVisibility() == 0) {
                this.f48702a.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.f48702a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.mRootView, false, l.g(this.f48702a, R.dimen.ds400));
                this.f48702a.mModel.C(this.f48702a.mPckId);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48703a;

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
            this.f48703a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage.getCmd() != 2921063 || this.f48703a.mPageData == null || this.f48703a.mLeftTxt == null || this.f48703a.mLeftContainer == null || this.f48703a.mDownloadNum == null) {
                return;
            }
            SkinManager.setImageResource(this.f48703a.mLeftImg, R.drawable.icon_bar_downloaded);
            this.f48703a.mLeftTxt.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(this.f48703a.mLeftTxt, R.color.CAM_X0109);
            this.f48703a.mLeftContainer.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            this.f48703a.mPageData.download++;
            this.f48703a.mDownloadNum.setText(String.format(this.f48703a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.f48703a.mPageData.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.f48703a.mPageData));
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48704e;

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
            this.f48704e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48704e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48705e;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f48706e;

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
                this.f48706e = eVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f48706e.f48705e.deleteEmotion();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
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
            this.f48705e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && b.a.e.f.p.j.z()) {
                if (this.f48705e.mDeleteDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.f48705e;
                    emotionPackageDetailActivity.mDeleteDialog = new b.a.q0.s.s.a(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    this.f48705e.mDeleteDialog.setMessageId(R.string.package_delete_confirm_tip);
                    this.f48705e.mDeleteDialog.setPositiveButton(R.string.package_delete_positive_tip, new a(this));
                    this.f48705e.mDeleteDialog.setNegativeButton(R.string.dialog_cancel, new b(this));
                    this.f48705e.mDeleteDialog.setCancelable(true);
                    this.f48705e.mDeleteDialog.create(this.f48705e.getPageContext());
                }
                this.f48705e.mDeleteDialog.show();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48707a;

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
            this.f48707a = emotionPackageDetailActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.f48707a;
                emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.mRootView);
                this.f48707a.mVoteMsg.setVisibility(8);
                this.f48707a.mNoDataView.setVisibility(8);
                this.f48707a.mControllerLayout.setVisibility(0);
                this.f48707a.bdListView.setVisibility(0);
                if (obj != null && (obj instanceof EmotionPackageData)) {
                    this.f48707a.mPageData = (EmotionPackageData) obj;
                    this.f48707a.mAdapter.e(this.f48707a.mPageData.pics);
                    this.f48707a.mCoverImage.setGifIconSupport(false);
                    if (this.f48707a.mPageData.forum_id > 0) {
                        this.f48707a.emationSingleBarIcon.setVisibility(0);
                        this.f48707a.mUserAvatar.startLoad(this.f48707a.mPageData.forum_avatar, 10, false);
                        this.f48707a.mUserName.setText(this.f48707a.mPageData.forum_name);
                    } else {
                        this.f48707a.mUserAvatar.startLoad(this.f48707a.mPageData.avatar, 10, false);
                        this.f48707a.mUserName.setText(this.f48707a.mPageData.author);
                    }
                    this.f48707a.mCoverImage.startLoad(this.f48707a.mPageData.cover, 10, false);
                    this.f48707a.mImageNum.setText(String.format(this.f48707a.getString(R.string.package_detail_num), Integer.valueOf(this.f48707a.mPageData.num)));
                    this.f48707a.mDownloadNum.setText(String.format(this.f48707a.getString(R.string.package_detail_download_num), StringHelper.numFormatOverWan(this.f48707a.mPageData.download)));
                    this.f48707a.mShareNum.setText(String.format(this.f48707a.getString(R.string.package_detail_share_num), StringHelper.numFormatOverWan(this.f48707a.mPageData.share)));
                    this.f48707a.mPackageName.setText(this.f48707a.mPageData.name);
                    if (this.f48707a.mPageData.owner == null || !this.f48707a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.f48707a.mDeletImg.setVisibility(8);
                    } else {
                        this.f48707a.mDeletImg.setVisibility(0);
                        if (this.f48707a.mPageData.status == 4 || this.f48707a.mPageData.status == 2) {
                            this.f48707a.mDeletImg.setEnabled(false);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f48707a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                        } else {
                            this.f48707a.mDeletImg.setEnabled(true);
                        }
                    }
                    if (this.f48707a.mPageData.status == 5 && this.f48707a.mPageData.forum_id > 0) {
                        this.f48707a.mVoteContainer.setVisibility(0);
                        this.f48707a.mControllerLayout.setVisibility(8);
                        this.f48707a.mDownloadNum.setVisibility(8);
                        this.f48707a.mShareNum.setVisibility(8);
                        int top = this.f48707a.mUserAvatar.getTop();
                        float bottom = (this.f48707a.mDownloadNum.getBottom() - this.f48707a.mPackageName.getBottom()) + l.g(this.f48707a.getPageContext().getPageActivity(), R.dimen.ds32) + this.f48707a.mUserAvatar.getHeight();
                        this.f48707a.mUserAvatar.setY(bottom);
                        this.f48707a.mUserName.setY(bottom);
                        if (this.f48707a.mPageData.owner == null || !this.f48707a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                            this.f48707a.mVoteMsg.setVisibility(0);
                            TextView textView = this.f48707a.mVoteMsg;
                            EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.f48707a;
                            textView.setText(emotionPackageDetailActivity2.getVoteNumber(emotionPackageDetailActivity2.mPageData.vote_num));
                            this.f48707a.mVoteMsg.setY(top);
                            if (this.f48707a.mPageData.has_vote == 1) {
                                this.f48707a.changeVoteViewState();
                            } else {
                                SkinManager.setBackgroundColor(this.f48707a.mDivider2, R.color.CAM_X0204);
                            }
                        } else {
                            this.f48707a.mVoteTxt.setText(R.string.package_detail_hits);
                            this.f48707a.mVoteImg.setVisibility(8);
                            this.f48707a.mDeletImg.setVisibility(8);
                            this.f48707a.mVoteMsg.setVisibility(8);
                            SkinManager.setViewTextColor(this.f48707a.mVoteTxt, R.color.CAM_X0109);
                            this.f48707a.mVoteContainer.setEnabled(false);
                        }
                    }
                    if (b.a.r0.s0.a.c().e("" + this.f48707a.mPckId)) {
                        this.f48707a.mLeftTxt.setText(R.string.already_downloaded);
                        SkinManager.setViewTextColor(this.f48707a.mLeftTxt, R.color.CAM_X0109);
                        SkinManager.setImageResource(this.f48707a.mLeftImg, R.drawable.icon_bar_downloaded);
                        this.f48707a.mLeftContainer.setEnabled(false);
                        return;
                    }
                    int i2 = this.f48707a.mPageData.status;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.f48707a.mLeftContainer.setVisibility(0);
                            this.f48707a.mLeftTxt.setText(R.string.download);
                            SkinManager.setViewTextColor(this.f48707a.mLeftTxt, R.color.CAM_X0302);
                            SkinManager.setImageResource(this.f48707a.mLeftImg, R.drawable.icon_bar_download);
                            this.f48707a.mLeftContainer.setEnabled(true);
                            return;
                        } else if (i2 == 2) {
                            this.f48707a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.f48707a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.f48707a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f48707a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.f48707a.mLeftTxt.setText(R.string.face_package_not_ok);
                            this.f48707a.mLeftContainer.setEnabled(false);
                            return;
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                this.f48707a.mLeftContainer.setVisibility(8);
                                return;
                            }
                            this.f48707a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.f48707a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.f48707a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f48707a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.f48707a.mLeftTxt.setText(R.string.face_package_has_delete);
                            this.f48707a.mLeftContainer.setEnabled(false);
                            return;
                        }
                    }
                    this.f48707a.mLeftContainer.setVisibility(0);
                    this.f48707a.mLeftTxt.setText(R.string.download);
                    SkinManager.setViewTextColor(this.f48707a.mLeftTxt, R.color.CAM_X0302);
                    SkinManager.setImageResource(this.f48707a.mLeftImg, R.drawable.icon_bar_download);
                    this.f48707a.mLeftContainer.setEnabled(true);
                    return;
                }
                l.M(this.f48707a.getActivity(), this.f48707a.getResources().getString(R.string.package_detail_load_failed));
                this.f48707a.mNoDataView.setVisibility(0);
                this.f48707a.mControllerLayout.setVisibility(8);
                this.f48707a.bdListView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements EmotionPackageDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48708a;

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
            this.f48708a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.d
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    SkinManager.setViewTextColor(this.f48708a.mLeftTxt, R.color.CAM_X0205);
                    this.f48708a.mLeftTxt.setText(R.string.package_already_delete);
                    SkinManager.setImageResource(this.f48708a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.f48708a.mLeftContainer.setEnabled(false);
                    l.L(this.f48708a.getActivity(), R.string.delete_success);
                    this.f48708a.setResult(-1);
                    this.f48708a.finish();
                    return;
                }
                l.L(this.f48708a.getActivity(), R.string.delete_fail);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48709a;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f48710e;

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
                this.f48710e = hVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48710e.f48709a.mVoteContainer.setEnabled(true);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f48711e;

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
                this.f48711e = hVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f48711e.f48709a.mPageData == null || TextUtils.isEmpty(this.f48711e.f48709a.mPageData.forum_name)) {
                    return;
                }
                this.f48711e.f48709a.doLike();
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
            this.f48709a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.e
        public void a(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, this.f48709a.mPageData));
                this.f48709a.changeVoteViewState();
                if (this.f48709a.mVoteMsg != null && this.f48709a.mVoteMsg.isShown()) {
                    TextView textView = this.f48709a.mVoteMsg;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.f48709a;
                    textView.setText(emotionPackageDetailActivity.getVoteNumber(emotionPackageDetailActivity.voteSum + 1));
                }
                l.L(this.f48709a.getActivity(), R.string.package_vote_success);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.f48709a.mUnFollowDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.f48709a;
                    emotionPackageDetailActivity2.mUnFollowDialog = new b.a.q0.s.s.a(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.f48709a.mUnFollowDialog.setMessageId(R.string.package_cant_vote_tips);
                    this.f48709a.mUnFollowDialog.setNegativeButton(R.string.package_cant_vote_negative, new a(this));
                    this.f48709a.mUnFollowDialog.setPositiveButton(R.string.package_cant_vote_positive, new b(this));
                    this.f48709a.mUnFollowDialog.create(this.f48709a.getPageContext());
                    this.f48709a.mUnFollowDialog.setCancelable(true);
                }
                this.f48709a.mUnFollowDialog.show();
            } else {
                this.f48709a.mVoteContainer.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.f48709a.getString(R.string.package_vote_fail);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                l.M(this.f48709a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48712a;

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
            this.f48712a = emotionPackageDetailActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f48712a.mLikeModel.getErrorCode() != 22) {
                    if (AntiHelper.m(this.f48712a.mLikeModel.getErrorCode(), this.f48712a.mLikeModel.getErrorString())) {
                        AntiHelper.u(this.f48712a.getPageContext().getPageActivity(), this.f48712a.mLikeModel.getErrorString());
                    } else if (this.f48712a.mLikeModel.getErrorCode() != 0) {
                        l.M(this.f48712a.getActivity(), this.f48712a.mLikeModel.getErrorString());
                        EmotionPackageDetailActivity emotionPackageDetailActivity = this.f48712a;
                        emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.mLikeModel.getErrorString());
                    } else {
                        x xVar = (x) obj;
                        if (xVar != null) {
                            l.L(this.f48712a.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(this.f48712a.mPageData.forum_name);
                            xVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                        } else {
                            l.L(this.f48712a.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    l.L(this.f48712a.getActivity(), R.string.had_liked_forum);
                }
                this.f48712a.mVoteContainer.setEnabled(true);
                this.f48712a.mUnFollowDialog.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48713a;

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
            this.f48713a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.s0.z.a)) {
                b.a.r0.s0.z.a aVar = (b.a.r0.s0.z.a) customResponsedMessage.getData();
                int i2 = aVar.f24820a;
                if (i2 == 0) {
                    l.L(this.f48713a.getActivity(), R.string.down_state_success);
                    SkinManager.setImageResource(this.f48713a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.f48713a.mLeftTxt.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(this.f48713a.mLeftTxt, R.color.CAM_X0109);
                    this.f48713a.mLeftContainer.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.f48713a.mPageData.download++;
                    this.f48713a.mDownloadNum.setText(String.format(this.f48713a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.f48713a.mPageData.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.f48713a.mPageData));
                } else if (i2 == 1) {
                    l.L(this.f48713a.getActivity(), R.string.download_error);
                    this.f48713a.mLeftContainer.setEnabled(true);
                } else if (i2 == 2) {
                    int i3 = aVar.f24821b;
                    if (i3 > 0 && i3 < 100) {
                        l.J(this.f48713a.getActivity(), this.f48713a.getString(R.string.package_downloading_progress));
                    } else if (i3 >= 100) {
                        l.I(this.f48713a.getActivity(), R.string.down_state_success);
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
            if (b.a.e.f.p.j.A()) {
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
            this.previewController = new b.a.r0.s0.z.b(this);
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
            b.a.r0.s0.z.b bVar = this.previewController;
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
            if (b.a.e.f.p.j.z()) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(b.a.e.f.m.b.g(this.mPageData.owner, 0L), this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
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
            b.a.r0.s0.z.b bVar = this.previewController;
            if (bVar != null) {
                bVar.s();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f48714e;

        /* renamed from: f  reason: collision with root package name */
        public int f48715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f48716g;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48717e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TbImageView f48718f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f48719g;

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
                this.f48719g = kVar;
                this.f48717e = i2;
                this.f48718f = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageData.SingleEmotionData singleEmotionData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.f48719g.f48714e.get(this.f48717e)) == null || singleEmotionData.id < 0 || this.f48719g.f48716g.mPckId < 0 || !b.a.e.f.p.j.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.f48719g.f48716g.getPageContext().getPageActivity(), this.f48719g.f48716g.mPckId, singleEmotionData.id, this.f48718f.isGif());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.f48719g.f48716g.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes9.dex */
        public class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f48720a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f48721b;

            /* renamed from: c  reason: collision with root package name */
            public TbImageView f48722c;

            /* renamed from: d  reason: collision with root package name */
            public TbImageView f48723d;

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
                                return this.f48723d;
                            }
                            return this.f48722c;
                        }
                        return this.f48721b;
                    }
                    return this.f48720a;
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
            this.f48716g = emotionPackageDetailActivity;
            this.f48714e = new ArrayList();
            this.f48715f = (l.k(TbadkCoreApplication.getInst()) - l.g(this.f48716g.getActivity(), R.dimen.ds230)) / 4;
        }

        public final void c(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) {
                for (int i3 = 0; i3 < 4; i3++) {
                    TbImageView a2 = bVar.a(i3);
                    if (a2 != null) {
                        int i4 = (i2 * 4) + i3;
                        if (i4 < this.f48714e.size() && i4 >= 0) {
                            a2.setVisibility(0);
                            a2.setTag(null);
                            a2.setDefaultResource(R.drawable.img_default_100);
                            a2.startLoad(this.f48714e.get(i4).thumbnail, 10, false);
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
                for (int size = this.f48714e.size() / 4; size < (this.f48714e.size() / 4) + 4; size++) {
                    if (size > 0 && size < this.f48714e.size()) {
                        arrayList.add(this.f48714e.get(size));
                    }
                }
                return this.f48714e;
            }
            return (List) invokeI.objValue;
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
                return;
            }
            this.f48714e.clear();
            this.f48714e.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.f48714e.size() / 4;
                return this.f48714e.size() % 4 > 0 ? size + 1 : size;
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
                    bVar.f48720a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.f48715f;
                    bVar.f48720a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.f48720a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.package_item_image2);
                    bVar.f48721b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.f48715f;
                    bVar.f48721b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.f48721b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.package_item_image3);
                    bVar.f48722c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.f48715f;
                    bVar.f48722c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.f48722c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.package_item_image4);
                    bVar.f48723d = tbImageView4;
                    ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                    layoutParams4.height = this.f48715f;
                    bVar.f48723d.setLayoutParams(layoutParams4);
                    SkinManager.setBackgroundColor(bVar.f48723d, R.color.CAM_X0201);
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
