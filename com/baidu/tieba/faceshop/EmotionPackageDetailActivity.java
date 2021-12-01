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
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
import c.a.r0.t3.x;
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
/* loaded from: classes10.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String PACKAGE_DETAIL_LINK;
    public final String SHARE_URL;
    public PackageDetailListView bdListView;
    public View controllerDivider;
    public c.a.d.a.e dataCallBack;
    public View emationSingleBarIcon;
    public k mAdapter;
    public View mControllerLayout;
    public TbImageView mCoverImage;
    public ImageView mDeletImg;
    public c.a.q0.s.s.a mDeleteDialog;
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
    public c.a.q0.s.s.a mUnFollowDialog;
    public HeadImageView mUserAvatar;
    public TextView mUserName;
    public View mVoteContainer;
    public ImageView mVoteImg;
    public TextView mVoteMsg;
    public TextView mVoteTxt;
    public c.a.r0.y0.z.b previewController;
    public int voteSum;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f43699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f43700f;

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
            this.f43700f = emotionPackageDetailActivity;
            this.f43699e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.a.a(this.f43699e.t);
                l.M(this.f43700f.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && c.a.d.f.p.j.z() && this.a.mModel != null && this.a.mNoDataView != null && this.a.mNoDataView.getVisibility() == 0) {
                this.a.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.mRootView, false, l.f(this.a, R.dimen.ds400));
                this.a.mModel.C(this.a.mPckId);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage.getCmd() != 2921063 || this.a.mPageData == null || this.a.mLeftTxt == null || this.a.mLeftContainer == null || this.a.mDownloadNum == null) {
                return;
            }
            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
            this.a.mLeftTxt.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0109);
            this.a.mLeftContainer.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            this.a.mPageData.download++;
            this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.a.mPageData.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.mPageData));
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f43701e;

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
            this.f43701e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43701e.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f43702e;

        /* loaded from: classes10.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f43703e;

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
                this.f43703e = eVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f43703e.f43702e.deleteEmotion();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes10.dex */
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
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
            this.f43702e = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.d.f.p.j.z()) {
                if (this.f43702e.mDeleteDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.f43702e;
                    emotionPackageDetailActivity.mDeleteDialog = new c.a.q0.s.s.a(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    this.f43702e.mDeleteDialog.setMessageId(R.string.package_delete_confirm_tip);
                    this.f43702e.mDeleteDialog.setPositiveButton(R.string.package_delete_positive_tip, new a(this));
                    this.f43702e.mDeleteDialog.setNegativeButton(R.string.dialog_cancel, new b(this));
                    this.f43702e.mDeleteDialog.setCancelable(true);
                    this.f43702e.mDeleteDialog.create(this.f43702e.getPageContext());
                }
                this.f43702e.mDeleteDialog.show();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.mRootView);
                this.a.mVoteMsg.setVisibility(8);
                this.a.mNoDataView.setVisibility(8);
                this.a.mControllerLayout.setVisibility(0);
                this.a.bdListView.setVisibility(0);
                if (obj != null && (obj instanceof EmotionPackageData)) {
                    this.a.mPageData = (EmotionPackageData) obj;
                    this.a.mAdapter.e(this.a.mPageData.pics);
                    this.a.mCoverImage.setGifIconSupport(false);
                    if (this.a.mPageData.forum_id > 0) {
                        this.a.emationSingleBarIcon.setVisibility(0);
                        this.a.mUserAvatar.startLoad(this.a.mPageData.forum_avatar, 10, false);
                        this.a.mUserName.setText(this.a.mPageData.forum_name);
                    } else {
                        this.a.mUserAvatar.startLoad(this.a.mPageData.avatar, 10, false);
                        this.a.mUserName.setText(this.a.mPageData.author);
                    }
                    this.a.mCoverImage.startLoad(this.a.mPageData.cover, 10, false);
                    this.a.mImageNum.setText(String.format(this.a.getString(R.string.package_detail_num), Integer.valueOf(this.a.mPageData.num)));
                    this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.package_detail_download_num), StringHelper.numFormatOverWan(this.a.mPageData.download)));
                    this.a.mShareNum.setText(String.format(this.a.getString(R.string.package_detail_share_num), StringHelper.numFormatOverWan(this.a.mPageData.share)));
                    this.a.mPackageName.setText(this.a.mPageData.name);
                    if (this.a.mPageData.owner == null || !this.a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.a.mDeletImg.setVisibility(8);
                    } else {
                        this.a.mDeletImg.setVisibility(0);
                        if (this.a.mPageData.status == 4 || this.a.mPageData.status == 2) {
                            this.a.mDeletImg.setEnabled(false);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                        } else {
                            this.a.mDeletImg.setEnabled(true);
                        }
                    }
                    if (this.a.mPageData.status == 5 && this.a.mPageData.forum_id > 0) {
                        this.a.mVoteContainer.setVisibility(0);
                        this.a.mControllerLayout.setVisibility(8);
                        this.a.mDownloadNum.setVisibility(8);
                        this.a.mShareNum.setVisibility(8);
                        int top = this.a.mUserAvatar.getTop();
                        float bottom = (this.a.mDownloadNum.getBottom() - this.a.mPackageName.getBottom()) + l.f(this.a.getPageContext().getPageActivity(), R.dimen.ds32) + this.a.mUserAvatar.getHeight();
                        this.a.mUserAvatar.setY(bottom);
                        this.a.mUserName.setY(bottom);
                        if (this.a.mPageData.owner == null || !this.a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                            this.a.mVoteMsg.setVisibility(0);
                            TextView textView = this.a.mVoteMsg;
                            EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                            textView.setText(emotionPackageDetailActivity2.getVoteNumber(emotionPackageDetailActivity2.mPageData.vote_num));
                            this.a.mVoteMsg.setY(top);
                            if (this.a.mPageData.has_vote == 1) {
                                this.a.changeVoteViewState();
                            } else {
                                SkinManager.setBackgroundColor(this.a.mDivider2, R.color.CAM_X0204);
                            }
                        } else {
                            this.a.mVoteTxt.setText(R.string.package_detail_hits);
                            this.a.mVoteImg.setVisibility(8);
                            this.a.mDeletImg.setVisibility(8);
                            this.a.mVoteMsg.setVisibility(8);
                            SkinManager.setViewTextColor(this.a.mVoteTxt, R.color.CAM_X0109);
                            this.a.mVoteContainer.setEnabled(false);
                        }
                    }
                    if (c.a.r0.y0.a.c().e("" + this.a.mPckId)) {
                        this.a.mLeftTxt.setText(R.string.already_downloaded);
                        SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0109);
                        SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                        this.a.mLeftContainer.setEnabled(false);
                        return;
                    }
                    int i2 = this.a.mPageData.status;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.a.mLeftContainer.setVisibility(0);
                            this.a.mLeftTxt.setText(R.string.download);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0302);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_download);
                            this.a.mLeftContainer.setEnabled(true);
                            return;
                        } else if (i2 == 2) {
                            this.a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.a.mLeftTxt.setText(R.string.face_package_not_ok);
                            this.a.mLeftContainer.setEnabled(false);
                            return;
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                this.a.mLeftContainer.setVisibility(8);
                                return;
                            }
                            this.a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                            this.a.mLeftTxt.setText(R.string.face_package_has_delete);
                            this.a.mLeftContainer.setEnabled(false);
                            return;
                        }
                    }
                    this.a.mLeftContainer.setVisibility(0);
                    this.a.mLeftTxt.setText(R.string.download);
                    SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0302);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_download);
                    this.a.mLeftContainer.setEnabled(true);
                    return;
                }
                l.M(this.a.getActivity(), this.a.getResources().getString(R.string.package_detail_load_failed));
                this.a.mNoDataView.setVisibility(0);
                this.a.mControllerLayout.setVisibility(8);
                this.a.bdListView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements EmotionPackageDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.d
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0205);
                    this.a.mLeftTxt.setText(R.string.package_already_delete);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.a.mLeftContainer.setEnabled(false);
                    l.L(this.a.getActivity(), R.string.delete_success);
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                l.L(this.a.getActivity(), R.string.delete_fail);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes10.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f43704e;

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
                this.f43704e = hVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f43704e.a.mVoteContainer.setEnabled(true);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f43705e;

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
                this.f43705e = hVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f43705e.a.mPageData == null || TextUtils.isEmpty(this.f43705e.a.mPageData.forum_name)) {
                    return;
                }
                this.f43705e.a.doLike();
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
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.e
        public void a(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, this.a.mPageData));
                this.a.changeVoteViewState();
                if (this.a.mVoteMsg != null && this.a.mVoteMsg.isShown()) {
                    TextView textView = this.a.mVoteMsg;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    textView.setText(emotionPackageDetailActivity.getVoteNumber(emotionPackageDetailActivity.voteSum + 1));
                }
                l.L(this.a.getActivity(), R.string.package_vote_success);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.a.mUnFollowDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                    emotionPackageDetailActivity2.mUnFollowDialog = new c.a.q0.s.s.a(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.a.mUnFollowDialog.setMessageId(R.string.package_cant_vote_tips);
                    this.a.mUnFollowDialog.setNegativeButton(R.string.package_cant_vote_negative, new a(this));
                    this.a.mUnFollowDialog.setPositiveButton(R.string.package_cant_vote_positive, new b(this));
                    this.a.mUnFollowDialog.create(this.a.getPageContext());
                    this.a.mUnFollowDialog.setCancelable(true);
                }
                this.a.mUnFollowDialog.show();
            } else {
                this.a.mVoteContainer.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.a.getString(R.string.package_vote_fail);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                l.M(this.a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.mLikeModel.getErrorCode() != 22) {
                    if (AntiHelper.m(this.a.mLikeModel.getErrorCode(), this.a.mLikeModel.getErrorString())) {
                        AntiHelper.u(this.a.getPageContext().getPageActivity(), this.a.mLikeModel.getErrorString());
                    } else if (this.a.mLikeModel.getErrorCode() != 0) {
                        l.M(this.a.getActivity(), this.a.mLikeModel.getErrorString());
                        EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                        emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.mLikeModel.getErrorString());
                    } else {
                        x xVar = (x) obj;
                        if (xVar != null) {
                            l.L(this.a.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(this.a.mPageData.forum_name);
                            xVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                        } else {
                            l.L(this.a.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    l.L(this.a.getActivity(), R.string.had_liked_forum);
                }
                this.a.mVoteContainer.setEnabled(true);
                this.a.mUnFollowDialog.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

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
            this.a = emotionPackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.y0.z.a)) {
                c.a.r0.y0.z.a aVar = (c.a.r0.y0.z.a) customResponsedMessage.getData();
                int i2 = aVar.a;
                if (i2 == 0) {
                    l.L(this.a.getActivity(), R.string.down_state_success);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.a.mLeftTxt.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(this.a.mLeftTxt, R.color.CAM_X0109);
                    this.a.mLeftContainer.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.a.mPageData.download++;
                    this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.package_detail_download_num), StringHelper.numberUniform(this.a.mPageData.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.mPageData));
                } else if (i2 == 1) {
                    l.L(this.a.getActivity(), R.string.download_error);
                    this.a.mLeftContainer.setEnabled(true);
                } else if (i2 == 2) {
                    int i3 = aVar.f25735b;
                    if (i3 > 0 && i3 < 100) {
                        l.J(this.a.getActivity(), this.a.getString(R.string.package_downloading_progress));
                    } else if (i3 >= 100) {
                        l.I(this.a.getActivity(), R.string.down_state_success);
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
            this.mDeletImg.setPadding(0, l.f(this, R.dimen.ds20), l.f(this, R.dimen.ds31), l.f(this, R.dimen.ds20));
            this.mDeletImg.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mDeletImg, new e(this));
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
            if (c.a.d.f.p.j.A()) {
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
            this.previewController = new c.a.r0.y0.z.b(this);
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
            c.a.r0.y0.z.b bVar = this.previewController;
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
            if (c.a.d.f.p.j.z()) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.mPageData.owner, 0L), this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
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
            showLoadingView(this.mRootView, false, l.f(this, R.dimen.ds400));
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
            c.a.r0.y0.z.b bVar = this.previewController;
            if (bVar != null) {
                bVar.s();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f43706e;

        /* renamed from: f  reason: collision with root package name */
        public int f43707f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EmotionPackageDetailActivity f43708g;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43709e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TbImageView f43710f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f43711g;

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
                this.f43711g = kVar;
                this.f43709e = i2;
                this.f43710f = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageData.SingleEmotionData singleEmotionData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.f43711g.f43706e.get(this.f43709e)) == null || singleEmotionData.id < 0 || this.f43711g.f43708g.mPckId < 0 || !c.a.d.f.p.j.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.f43711g.f43708g.getPageContext().getPageActivity(), this.f43711g.f43708g.mPckId, singleEmotionData.id, this.f43710f.isGif());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.f43711g.f43708g.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes10.dex */
        public class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TbImageView a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f43712b;

            /* renamed from: c  reason: collision with root package name */
            public TbImageView f43713c;

            /* renamed from: d  reason: collision with root package name */
            public TbImageView f43714d;

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
                                return this.f43714d;
                            }
                            return this.f43713c;
                        }
                        return this.f43712b;
                    }
                    return this.a;
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
            this.f43708g = emotionPackageDetailActivity;
            this.f43706e = new ArrayList();
            this.f43707f = (l.k(TbadkCoreApplication.getInst()) - l.f(this.f43708g.getActivity(), R.dimen.ds230)) / 4;
        }

        public final void c(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) {
                for (int i3 = 0; i3 < 4; i3++) {
                    TbImageView a2 = bVar.a(i3);
                    if (a2 != null) {
                        int i4 = (i2 * 4) + i3;
                        if (i4 < this.f43706e.size() && i4 >= 0) {
                            a2.setVisibility(0);
                            a2.setTag(null);
                            a2.setDefaultResource(R.drawable.img_default_100);
                            a2.startLoad(this.f43706e.get(i4).thumbnail, 10, false);
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
                for (int size = this.f43706e.size() / 4; size < (this.f43706e.size() / 4) + 4; size++) {
                    if (size > 0 && size < this.f43706e.size()) {
                        arrayList.add(this.f43706e.get(size));
                    }
                }
                return this.f43706e;
            }
            return (List) invokeI.objValue;
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
                return;
            }
            this.f43706e.clear();
            this.f43706e.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.f43706e.size() / 4;
                return this.f43706e.size() % 4 > 0 ? size + 1 : size;
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
                    bVar.a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.f43707f;
                    bVar.a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.package_item_image2);
                    bVar.f43712b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.f43707f;
                    bVar.f43712b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.f43712b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.package_item_image3);
                    bVar.f43713c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.f43707f;
                    bVar.f43713c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.f43713c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.package_item_image4);
                    bVar.f43714d = tbImageView4;
                    ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                    layoutParams4.height = this.f43707f;
                    bVar.f43714d.setLayoutParams(layoutParams4);
                    SkinManager.setBackgroundColor(bVar.f43714d, R.color.CAM_X0201);
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
