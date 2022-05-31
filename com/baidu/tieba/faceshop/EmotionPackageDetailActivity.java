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
import com.repackage.a9;
import com.repackage.ag8;
import com.repackage.ai;
import com.repackage.dq4;
import com.repackage.i86;
import com.repackage.j86;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.li;
import com.repackage.t66;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String PACKAGE_DETAIL_LINK;
    public final String SHARE_URL;
    public PackageDetailListView bdListView;
    public View controllerDivider;
    public a9 dataCallBack;
    public View emationSingleBarIcon;
    public k mAdapter;
    public View mControllerLayout;
    public TbImageView mCoverImage;
    public ImageView mDeletImg;
    public dq4 mDeleteDialog;
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
    public dq4 mUnFollowDialog;
    public HeadImageView mUserAvatar;
    public TextView mUserName;
    public View mVoteContainer;
    public ImageView mVoteImg;
    public TextView mVoteMsg;
    public TextView mVoteTxt;
    public j86 previewController;
    public int voteSum;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ EmotionPackageDetailActivity b;

        public a(EmotionPackageDetailActivity emotionPackageDetailActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionPackageDetailActivity;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ai.a(this.a.w);
                li.O(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f044d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && ji.z() && this.a.mModel != null && this.a.mNoDataView != null && this.a.mNoDataView.getVisibility() == 0) {
                this.a.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.mRootView, false, li.f(this.a, R.dimen.obfuscated_res_0x7f0702be));
                this.a.mModel.E(this.a.mPckId);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f0273);
            SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0109);
            this.a.mLeftContainer.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            this.a.mPageData.download++;
            this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d17), StringHelper.numberUniform(this.a.mPageData.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.mPageData));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        public d(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    this.a.a.deleteEmotion();
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.z()) {
                if (this.a.mDeleteDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                    emotionPackageDetailActivity.mDeleteDialog = new dq4(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    this.a.mDeleteDialog.setMessageId(R.string.obfuscated_res_0x7f0f0d15);
                    this.a.mDeleteDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f0d16, new a(this));
                    this.a.mDeleteDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, new b(this));
                    this.a.mDeleteDialog.setCancelable(true);
                    this.a.mDeleteDialog.create(this.a.getPageContext());
                }
                this.a.mDeleteDialog.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends a9 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.repackage.a9
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
                        this.a.mUserAvatar.K(this.a.mPageData.forum_avatar, 10, false);
                        this.a.mUserName.setText(this.a.mPageData.forum_name);
                    } else {
                        this.a.mUserAvatar.K(this.a.mPageData.avatar, 10, false);
                        this.a.mUserName.setText(this.a.mPageData.author);
                    }
                    this.a.mCoverImage.K(this.a.mPageData.cover, 10, false);
                    this.a.mImageNum.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d1a), Integer.valueOf(this.a.mPageData.num)));
                    this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d17), StringHelper.numFormatOverWan(this.a.mPageData.download)));
                    this.a.mShareNum.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d1c), StringHelper.numFormatOverWan(this.a.mPageData.share)));
                    this.a.mPackageName.setText(this.a.mPageData.name);
                    if (this.a.mPageData.owner == null || !this.a.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.a.mDeletImg.setVisibility(8);
                    } else {
                        this.a.mDeletImg.setVisibility(0);
                        if (this.a.mPageData.status == 4 || this.a.mPageData.status == 2) {
                            this.a.mDeletImg.setEnabled(false);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.obfuscated_res_0x7f0809e1, R.color.white_alpha100, null);
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
                        float bottom = (this.a.mDownloadNum.getBottom() - this.a.mPackageName.getBottom()) + li.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070207) + this.a.mUserAvatar.getHeight();
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
                            this.a.mVoteTxt.setText(R.string.obfuscated_res_0x7f0f0d18);
                            this.a.mVoteImg.setVisibility(8);
                            this.a.mDeletImg.setVisibility(8);
                            this.a.mVoteMsg.setVisibility(8);
                            SkinManager.setViewTextColor(this.a.mVoteTxt, (int) R.color.CAM_X0109);
                            this.a.mVoteContainer.setEnabled(false);
                        }
                    }
                    if (t66.c().e("" + this.a.mPckId)) {
                        this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f0273);
                        SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0109);
                        SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                        this.a.mLeftContainer.setEnabled(false);
                        return;
                    }
                    int i = this.a.mPageData.status;
                    if (i != 0) {
                        if (i == 1) {
                            this.a.mLeftContainer.setVisibility(0);
                            this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f04f7);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0302);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_download);
                            this.a.mLeftContainer.setEnabled(true);
                            return;
                        } else if (i == 2) {
                            this.a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.obfuscated_res_0x7f0809e1, R.color.white_alpha100, null);
                            this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f05f1);
                            this.a.mLeftContainer.setEnabled(false);
                            return;
                        } else if (i != 3) {
                            if (i != 4) {
                                this.a.mLeftContainer.setVisibility(8);
                                return;
                            }
                            this.a.mLeftContainer.setVisibility(0);
                            SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_illegal_off);
                            SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0109);
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mDeletImg, R.drawable.obfuscated_res_0x7f0809e1, R.color.white_alpha100, null);
                            this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f05f0);
                            this.a.mLeftContainer.setEnabled(false);
                            return;
                        }
                    }
                    this.a.mLeftContainer.setVisibility(0);
                    this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f04f7);
                    SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0302);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_download);
                    this.a.mLeftContainer.setEnabled(true);
                    return;
                }
                li.O(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d19));
                this.a.mNoDataView.setVisibility(0);
                this.a.mControllerLayout.setVisibility(8);
                this.a.bdListView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0205);
                    this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f0d11);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.a.mLeftContainer.setEnabled(false);
                    li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04b2);
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04a9);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements EmotionPackageDetailModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                    this.a.a.mVoteContainer.setEnabled(true);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || this.a.a.mPageData == null || TextUtils.isEmpty(this.a.a.mPageData.forum_name)) {
                    return;
                }
                this.a.a.doLike();
            }
        }

        public h(EmotionPackageDetailActivity emotionPackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0d25);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (this.a.mUnFollowDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = this.a;
                    emotionPackageDetailActivity2.mUnFollowDialog = new dq4(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    this.a.mUnFollowDialog.setMessageId(R.string.obfuscated_res_0x7f0f0d14);
                    this.a.mUnFollowDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f0d12, new a(this));
                    this.a.mUnFollowDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
                    this.a.mUnFollowDialog.create(this.a.getPageContext());
                    this.a.mUnFollowDialog.setCancelable(true);
                }
                this.a.mUnFollowDialog.show();
            } else {
                this.a.mVoteContainer.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = this.a.getString(R.string.obfuscated_res_0x7f0f0d24);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                li.O(this.a.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends a9 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionPackageDetailActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.mLikeModel.getErrorCode() != 22) {
                    if (AntiHelper.m(this.a.mLikeModel.getErrorCode(), this.a.mLikeModel.getErrorString())) {
                        AntiHelper.u(this.a.getPageContext().getPageActivity(), this.a.mLikeModel.getErrorString());
                    } else if (this.a.mLikeModel.getErrorCode() != 0) {
                        li.O(this.a.getActivity(), this.a.mLikeModel.getErrorString());
                        EmotionPackageDetailActivity emotionPackageDetailActivity = this.a;
                        emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.mLikeModel.getErrorString());
                    } else {
                        ag8 ag8Var = (ag8) obj;
                        if (ag8Var != null) {
                            li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f02b3);
                            TbadkApplication.getInst().addLikeForum(this.a.mPageData.forum_name);
                            ag8Var.y(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ag8Var));
                        } else {
                            li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0c33);
                        }
                    }
                } else {
                    li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0811);
                }
                this.a.mVoteContainer.setEnabled(true);
                this.a.mUnFollowDialog.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionPackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(EmotionPackageDetailActivity emotionPackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPackageDetailActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i86)) {
                i86 i86Var = (i86) customResponsedMessage.getData();
                int i = i86Var.a;
                if (i == 0) {
                    li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04f6);
                    SkinManager.setImageResource(this.a.mLeftImg, R.drawable.icon_bar_downloaded);
                    this.a.mLeftTxt.setText(R.string.obfuscated_res_0x7f0f0273);
                    SkinManager.setViewTextColor(this.a.mLeftTxt, (int) R.color.CAM_X0109);
                    this.a.mLeftContainer.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                    this.a.mPageData.download++;
                    this.a.mDownloadNum.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d17), StringHelper.numberUniform(this.a.mPageData.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, this.a.mPageData));
                } else if (i == 1) {
                    li.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04fb);
                    this.a.mLeftContainer.setEnabled(true);
                } else if (i == 2) {
                    int i2 = i86Var.b;
                    if (i2 > 0 && i2 < 100) {
                        li.L(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0d20));
                    } else if (i2 >= 100) {
                        li.K(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04f6);
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
            this.mVoteTxt.setText(R.string.obfuscated_res_0x7f0f0d1f);
            SkinManager.setImageResource(this.mVoteImg, R.drawable.icon_bar_voted);
            SkinManager.setViewTextColor(this.mVoteTxt, (int) R.color.CAM_X0109);
            this.mVoteContainer.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.mModel.D(this.mPckId, new g(this));
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
            likeModel.P(emotionPackageData.forum_name, String.valueOf(emotionPackageData.forum_id));
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
            this.mFaceGroupDownloadModel.y(Integer.toString(this.mPckId), Boolean.TRUE, null);
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
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0567), str);
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
            this.mModel.E(this.mPckId);
            this.voteSum = 0;
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.mRootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09088d);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070270)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c55), null);
            SkinManager.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0d1d)), (int) R.color.CAM_X0105);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.mDeletImg = new ImageView(getPageContext().getPageActivity());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mDeletImg, R.drawable.obfuscated_res_0x7f0809e1, R.color.white_alpha100, null);
            this.mDeletImg.setPadding(0, li.f(this, R.dimen.obfuscated_res_0x7f0701d5), li.f(this, R.dimen.obfuscated_res_0x7f07029e), li.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.mDeletImg.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mDeletImg, new e(this));
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f09156c);
            if (ji.A()) {
                this.mNoNetworkView.setVisibility(8);
            } else {
                this.mNoNetworkView.setVisibility(0);
            }
            this.mNoNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.bdListView = (PackageDetailListView) findViewById(R.id.obfuscated_res_0x7f091612);
            this.mAdapter = new k(this, null);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d025d, (ViewGroup) null);
            this.mHeaderView = inflate;
            this.bdListView.addHeaderView(inflate);
            this.mCoverImage = (TbImageView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09088c);
            this.emationSingleBarIcon = this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09088f);
            this.mDivider = this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f0907d8);
            this.mImageNum = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09085b);
            this.mPackageName = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09088e);
            this.mDownloadNum = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f091611);
            this.mShareNum = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f091617);
            this.mVoteMsg = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f090862);
            HeadImageView headImageView = (HeadImageView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09160d);
            this.mUserAvatar = headImageView;
            headImageView.setIsRound(true);
            this.mUserAvatar.setOnClickListener(this);
            TextView textView = (TextView) this.mHeaderView.findViewById(R.id.obfuscated_res_0x7f09160e);
            this.mUserName = textView;
            textView.setOnClickListener(this);
            this.bdListView.setAdapter((ListAdapter) this.mAdapter);
            this.mDivider2 = findViewById(R.id.obfuscated_res_0x7f090023);
            this.mControllerLayout = findViewById(R.id.obfuscated_res_0x7f091610);
            this.controllerDivider = findViewById(R.id.obfuscated_res_0x7f0906d8);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0911e4);
            this.mLeftContainer = findViewById;
            findViewById.setOnClickListener(this);
            this.mLeftImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.mLeftTxt = (TextView) findViewById(R.id.obfuscated_res_0x7f0911f0);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091a9e);
            this.mRightContainer = findViewById2;
            findViewById2.setOnClickListener(this);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091618);
            this.mVoteContainer = findViewById3;
            findViewById3.setOnClickListener(this);
            this.mVoteImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f0923ef);
            this.mVoteTxt = (TextView) findViewById(R.id.obfuscated_res_0x7f092400);
            this.previewController = new j86(this);
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
            shareItem.u = this.mPageData.name;
            shareItem.v = getString(R.string.obfuscated_res_0x7f0f0d21);
            shareItem.w = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.mPckId;
            shareItem.y = Uri.parse(this.mPageData.cover);
            shareItem.o = true;
            this.mTempShareUrl = shareItem.w;
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
            this.mModel.F(i2, new h(this));
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
                this.mFaceGroupShareModel.y(str);
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
            SkinManager.setViewTextColor(this.mDownloadNum, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mShareNum, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mPackageName, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mUserName, (int) R.color.CAM_X0304);
            SkinManager.setViewTextColor(this.mVoteMsg, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mImageNum, (int) R.color.CAM_X0109);
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
                noDataView.f(getPageContext(), i2);
            }
            j86 j86Var = this.previewController;
            if (j86Var != null) {
                j86Var.y(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (ji.z()) {
                if (view2 == this.mLeftContainer) {
                    downloadEmotion();
                } else if (view2 == this.mRightContainer) {
                    shareEmotion();
                } else if (view2 != this.mUserAvatar && view2 != this.mUserName) {
                    if (view2 == this.mVoteContainer) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(jg.g(this.mPageData.owner, 0L), this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
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
            setContentView(R.layout.obfuscated_res_0x7f0d025c);
            initUI();
            showLoadingView(this.mRootView, false, li.f(this, R.dimen.obfuscated_res_0x7f0702be));
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
            j86 j86Var = this.previewController;
            if (j86Var != null) {
                j86Var.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public int b;
        public final /* synthetic */ EmotionPackageDetailActivity c;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ TbImageView b;
            public final /* synthetic */ k c;

            public a(k kVar, int i, TbImageView tbImageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i), tbImageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = kVar;
                this.a = i;
                this.b = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EmotionPackageData.SingleEmotionData singleEmotionData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (singleEmotionData = (EmotionPackageData.SingleEmotionData) this.c.a.get(this.a)) == null || singleEmotionData.id < 0 || this.c.c.mPckId < 0 || !ji.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(this.c.c.getPageContext().getPageActivity(), this.c.c.mPckId, singleEmotionData.id, this.b.x());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                this.c.c.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes3.dex */
        public class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TbImageView a;
            public TbImageView b;
            public TbImageView c;
            public TbImageView d;

            public b(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public TbImageView a(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return null;
                                }
                                return this.d;
                            }
                            return this.c;
                        }
                        return this.b;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = emotionPackageDetailActivity;
            this.a = new ArrayList();
            this.b = (li.k(TbadkCoreApplication.getInst()) - li.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070283)) / 4;
        }

        public final void c(int i, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bVar) == null) {
                for (int i2 = 0; i2 < 4; i2++) {
                    TbImageView a2 = bVar.a(i2);
                    if (a2 != null) {
                        int i3 = (i * 4) + i2;
                        if (i3 < this.a.size() && i3 >= 0) {
                            a2.setVisibility(0);
                            a2.setTag(null);
                            a2.setDefaultResource(R.drawable.obfuscated_res_0x7f080ba6);
                            a2.K(this.a.get(i3).thumbnail, 10, false);
                            a2.invalidate();
                            a2.setOnClickListener(new a(this, i3, a2));
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
        public List<EmotionPackageData.SingleEmotionData> getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                ArrayList arrayList = new ArrayList();
                for (int size = this.a.size() / 4; size < (this.a.size() / 4) + 4; size++) {
                    if (size > 0 && size < this.a.size()) {
                        arrayList.add(this.a.get(size));
                    }
                }
                return this.a;
            }
            return (List) invokeI.objValue;
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
                return;
            }
            this.a.clear();
            this.a.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.a.size() / 4;
                return this.a.size() % 4 > 0 ? size + 1 : size;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View view3;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    bVar = new b(this, null);
                    view3 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d063a, viewGroup, false);
                    TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091613);
                    bVar.a = tbImageView;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = this.b;
                    bVar.a.setLayoutParams(layoutParams);
                    SkinManager.setBackgroundColor(bVar.a, R.color.CAM_X0201);
                    TbImageView tbImageView2 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091614);
                    bVar.b = tbImageView2;
                    ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                    layoutParams2.height = this.b;
                    bVar.b.setLayoutParams(layoutParams2);
                    SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0201);
                    TbImageView tbImageView3 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091615);
                    bVar.c = tbImageView3;
                    ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                    layoutParams3.height = this.b;
                    bVar.c.setLayoutParams(layoutParams3);
                    SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0201);
                    TbImageView tbImageView4 = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091616);
                    bVar.d = tbImageView4;
                    ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                    layoutParams4.height = this.b;
                    bVar.d.setLayoutParams(layoutParams4);
                    SkinManager.setBackgroundColor(bVar.d, R.color.CAM_X0201);
                    view3.setTag(bVar);
                } else {
                    view3 = view2;
                    bVar = (b) view2.getTag();
                }
                c(i, bVar);
                return view3;
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
            return String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0567), String.valueOf(i2));
        }
        return (String) invokeI.objValue;
    }
}
