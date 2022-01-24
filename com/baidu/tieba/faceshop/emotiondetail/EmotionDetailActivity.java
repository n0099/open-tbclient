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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.z0.t;
import c.a.t0.z0.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class EmotionDetailActivity extends BaseActivity<EmotionDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String SHARE_URL;
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
    public c.a.d.a.e mLoadDataCallBack;
    public PopupWindow mManageEmotionPopupWindow;
    public NavigationBar mNavigationBar;
    public final CustomMessageListener mNetworkChangedMessageListener;
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

    /* loaded from: classes12.dex */
    public class a implements c.a.t0.o2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public a(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // c.a.t0.o2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.N(this.a.getPageContext().getPageActivity(), str);
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.getPageContext().getPageActivity(), R.string.save_success);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionDetailActivity emotionDetailActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, Integer.valueOf(i2)};
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
            this.a = emotionDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.z() && this.a.mNoDataView != null && this.a.mNoDataView.getVisibility() == 0) {
                this.a.mNoDataView.setVisibility(8);
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.showLoadingView(emotionDetailActivity.mRootView, false, n.f(this.a, R.dimen.ds400));
                this.a.mEmotionDetailModel.y(this.a.pic_id, this.a.pck_id);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailActivity f42950e;

        public c(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42950e = emotionDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42950e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailActivity f42951e;

        public d(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42951e = emotionDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42951e.mIsFromEmotionPackage) {
                return;
            }
            this.f42951e.navigateToEmotionPackagePage();
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailActivity f42953f;

        public e(EmotionDetailActivity emotionDetailActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42953f = emotionDetailActivity;
            this.f42952e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int top = this.f42952e.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.f42953f.mManageEmotionPopupWindow.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public f(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.hideLoadingView(emotionDetailActivity.mRootView);
                this.a.mNoDataView.setVisibility(8);
                this.a.mBottomContainer.setVisibility(0);
                this.a.mTopContainer.setVisibility(0);
                this.a.mEmotionDetailImageView.setVisibility(0);
                if (obj != null) {
                    this.a.mEmotionDetailData = (EmotionDetailData) obj;
                    if (this.a.mEmotionDetailData.pic_info != null && !TextUtils.isEmpty(this.a.mEmotionDetailData.pic_info.pic_url)) {
                        this.a.mEmotionDetailImageView.loadImage(this.a.mEmotionDetailData, 33, this.a.isGif);
                    }
                    if (this.a.mEmotionDetailData.pck_info == null || TextUtils.isEmpty(this.a.mEmotionDetailData.pck_info.cover)) {
                        this.a.mTopContainer.setVisibility(8);
                    } else {
                        this.a.mCoverImage.startLoad(this.a.mEmotionDetailData.pck_info.cover, 10, false);
                        if (this.a.mEmotionDetailData.pck_info.forum_name != null) {
                            TextView textView = this.a.mForumAndDownloadNum;
                            String string = this.a.getString(R.string.forum_and_download_num);
                            textView.setText(String.format(string, this.a.mEmotionDetailData.pck_info.forum_name + this.a.getString(R.string.forum), StringHelper.numFormatOverWan(c.a.d.f.m.b.g(this.a.mEmotionDetailData.pck_info.download, 0L))));
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append((CharSequence) this.a.getString(R.string.emotion_center_single_bar_top)).append((CharSequence) " ").append((CharSequence) this.a.mEmotionDetailData.pck_info.pck_name);
                            spannableStringBuilder.setSpan(new c.a.d.n.b(this.a.getPageContext().getPageActivity(), R.drawable.emotion_pic_single_bar), 0, 2, 17);
                            this.a.mEmotionPackageName.setText(spannableStringBuilder);
                        } else {
                            this.a.mEmotionPackageName.setText(this.a.mEmotionDetailData.pck_info.pck_name);
                            this.a.mForumAndDownloadNum.setText(String.format(this.a.getString(R.string.forum_and_download_num), this.a.mEmotionDetailData.pck_info.owner.user_name, StringHelper.numFormatOverWan(c.a.d.f.m.b.g(this.a.mEmotionDetailData.pck_info.download, 0L))));
                        }
                    }
                    c.a.t0.z0.a c2 = c.a.t0.z0.a.c();
                    if (c2.e("" + this.a.pck_id)) {
                        this.a.mEmotionPackageControlTv.setText(R.string.already_downloaded);
                        SkinManager.setViewTextColor(this.a.mEmotionPackageControlTv, R.color.CAM_X0109);
                        this.a.mEmotionPackageControlTv.setEnabled(false);
                        SkinManager.setBackgroundColor(this.a.mEmotionPackageControlTv, R.color.transparent);
                    } else {
                        this.a.mEmotionPackageControlTv.setText(R.string.download);
                        SkinManager.setViewTextColor(this.a.mEmotionPackageControlTv, R.color.CAM_X0302);
                        SkinManager.setBackgroundResource(this.a.mEmotionPackageControlTv, R.drawable.bg_emotion_download);
                    }
                    if (u.e().f(StringUtils.string(Long.valueOf(this.a.mEmotionDetailData.pic_info.pic_id)))) {
                        SkinManager.setImageResource(this.a.mAddImage, R.drawable.icon_bar_collectioned);
                        this.a.mAddText.setText(R.string.emotion_detail_collectioned);
                        SkinManager.setViewTextColor(this.a.mAddText, R.color.CAM_X0302);
                        return;
                    }
                    SkinManager.setImageResource(this.a.mAddImage, R.drawable.icon_bar_collection_emotion);
                    SkinManager.setViewTextColor(this.a.mAddText, R.color.CAM_X0302);
                    return;
                }
                n.N(this.a.getActivity(), this.a.getResources().getString(R.string.package_detail_load_failed));
                this.a.mNoDataView.setVisibility(0);
                this.a.mBottomContainer.setVisibility(8);
                this.a.mTopContainer.setVisibility(8);
                this.a.mEmotionDetailImageView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f42954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailActivity f42955f;

        public g(EmotionDetailActivity emotionDetailActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42955f = emotionDetailActivity;
            this.f42954e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f42954e.t);
                n.N(this.f42955f.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements c.a.t0.o2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public h(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // c.a.t0.o2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.M(this.a.getActivity(), R.string.download_error);
                this.a.mEmotionPackageControlTv.setEnabled(true);
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    n.K(this.a.getActivity(), this.a.getString(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    n.J(this.a.getActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.getActivity(), R.string.down_state_success);
                this.a.mEmotionPackageControlTv.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.a.mEmotionPackageControlTv, R.color.CAM_X0109);
                this.a.mEmotionPackageControlTv.setEnabled(false);
                SkinManager.setBackgroundColor(this.a.mEmotionPackageControlTv, R.color.transparent);
                TextView textView = this.a.mForumAndDownloadNum;
                String string = this.a.getString(R.string.forum_and_download_num);
                textView.setText(String.format(string, this.a.mEmotionDetailData.pck_info.owner.user_name, StringHelper.numberUniform(c.a.d.f.m.b.g(this.a.mEmotionDetailData.pck_info.download + 1, 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921063));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* loaded from: classes12.dex */
        public class a implements t.l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f42956e;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42956e = iVar;
            }

            @Override // c.a.t0.z0.t.l
            public void onResult(int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                    if (i3 > 0 && i2 == 1) {
                        SkinManager.setImageResource(this.f42956e.a.mAddImage, R.drawable.icon_bar_collection_emotion);
                        this.f42956e.a.mAddText.setText(R.string.emotion_detail_collection);
                        n.M(TbadkCoreApplication.getInst(), R.string.delete_success);
                        return;
                    }
                    n.M(TbadkCoreApplication.getInst(), R.string.delete_fail);
                }
            }
        }

        public i(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = c.a.t0.z0.g.k().n(TbadkCoreApplication.getCurrentAccount());
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
                    if (!c.a.s0.c0.d.f12417d.equals(next.sharpText) && !TextUtils.isEmpty(next.pid)) {
                        String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + c.a.s0.c0.d.b() + "/" + next.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0 && next.pid.equals(StringUtils.string(Long.valueOf(this.a.pic_id)))) {
                            imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                            next.imageFileInfo = imageFileInfo;
                            arrayList.add(next);
                            break;
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() == 0) {
                return;
            }
            t.s().l(list, true, new a(this));
        }
    }

    /* loaded from: classes12.dex */
    public class j implements t.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailActivity f42957e;

        public j(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42957e = emotionDetailActivity;
        }

        @Override // c.a.t0.z0.t.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) && i2 == 4) {
                if (i3 == 1) {
                    SkinManager.setImageResource(this.f42957e.mAddImage, R.drawable.icon_bar_collectioned);
                    this.f42957e.mAddText.setText(R.string.emotion_detail_collectioned);
                    n.M(TbadkCoreApplication.getInst(), R.string.add_success);
                    return;
                }
                n.M(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            }
        }
    }

    public EmotionDetailActivity() {
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
        this.SHARE_URL = "http://tieba.baidu.com/n/interact/emoticon/";
        this.mNetworkChangedMessageListener = new b(this, 2000994);
        this.mLoadDataCallBack = new f(this);
    }

    private void collectionEmotion() {
        EmotionDetailData.PicInfo picInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (picInfo = this.mEmotionDetailData.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 25031)));
        } else if (u.e().f(StringUtils.string(Long.valueOf(this.mEmotionDetailData.pic_info.pic_id)))) {
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
            c.a.s0.d0.c cVar = new c.a.s0.d0.c();
            cVar.f12452d = str;
            cVar.f12454f = StringUtils.string(Integer.valueOf(i2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            t.s().h(arrayList, true, new j(this));
        }
    }

    private void deleteCollection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            new i(this).execute(new Void[0]);
        }
    }

    private void downloadEmotion() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && this.pck_id >= 0) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mEmotionPackageControlTv.setEnabled(false);
            this.mFaceGroupDownloadModel.w(StringUtils.string(Integer.valueOf(this.pck_id)), Boolean.TRUE, new h(this));
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.mEmotionDetailModel == null) {
                this.mEmotionDetailModel = new EmotionDetailModel();
            }
            this.mEmotionDetailModel.setLoadDataCallBack(this.mLoadDataCallBack);
            this.mEmotionDetailModel.y(this.pic_id, this.pck_id);
        }
    }

    private void initPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
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
            this.mManageEmotionPopupWindow.setHeight(n.i(getPageContext().getPageActivity()) - c.a.d.f.p.c.b(getPageContext().getPageActivity()));
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
            inflate.setOnTouchListener(new e(this, inflate));
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.mRootView = findViewById(R.id.emotion_detail_container);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this, R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_face_detail_tip), null);
            this.mNoDataView = a2;
            a2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.emotion_detail)), R.color.CAM_X0105);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.mNoNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
            if (l.A()) {
                this.mNoNetworkView.setVisibility(8);
            } else {
                this.mNoNetworkView.setVisibility(0);
            }
            this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.shareImage = new ImageView(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.shareImage.setPadding(0, n.f(this, R.dimen.ds20), n.f(this, R.dimen.ds31), n.f(this, R.dimen.ds20));
            this.shareImage.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.shareImage, this);
            this.mEmotionDetailImageView = (EmotionDetailImageView) findViewById(R.id.emotion_detail_image_view);
            View findViewById = findViewById(R.id.emotion_detail_top_container);
            this.mTopContainer = findViewById;
            findViewById.setOnClickListener(new d(this));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToEmotionPackagePage() {
        EmotionDetailData emotionDetailData;
        EmotionDetailData.PckInfo pckInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (emotionDetailData = this.mEmotionDetailData) == null || (pckInfo = emotionDetailData.pck_info) == null || (i2 = pckInfo.pck_id) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this, i2, 25024)));
    }

    private void saveEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            String str = this.mEmotionDetailData.pic_info.pic_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.t0.o2.c.i().d(str, new a(this));
        }
    }

    private void shareEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
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
            shareItem.b0 = 2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new g(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.changeSkinType(i2);
            this.mSkinType = i2;
            this.mNoDataView.onChangeSkinType(getPageContext(), i2);
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i2);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setResult(-1);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) && i3 == -1 && i2 == 25031) {
            collectionEmotion();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (l.z()) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
            showLoadingView(this.mRootView, false, n.f(this, R.dimen.ds400));
            initData();
            registerListener(this.mNetworkChangedMessageListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
}
