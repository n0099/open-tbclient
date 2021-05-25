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
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import d.a.n0.e3.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    public PackageDetailListView bdListView;
    public View controllerDivider;
    public View emationSingleBarIcon;
    public k mAdapter;
    public View mControllerLayout;
    public TbImageView mCoverImage;
    public ImageView mDeletImg;
    public d.a.m0.r.s.a mDeleteDialog;
    public View mDivider;
    public View mDivider2;
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
    public NoDataView mNoDataView;
    public NoNetworkView mNoNetworkView;
    public TextView mPackageName;
    public EmotionPackageData mPageData;
    public int mPckId;
    public View mRightContainer;
    public RelativeLayout mRootView;
    public TextView mShareNum;
    public String mTempShareUrl;
    public d.a.m0.r.s.a mUnFollowDialog;
    public HeadImageView mUserAvatar;
    public TextView mUserName;
    public View mVoteContainer;
    public ImageView mVoteImg;
    public TextView mVoteMsg;
    public TextView mVoteTxt;
    public d.a.n0.m0.a0.b previewController;
    public int voteSum;
    public final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    public final String PACKAGE_DETAIL_LINK = "http://tieba.baidu.com/n/interact/emoticon/";
    public final CustomMessageListener mNetworkChangedMessageListener = new b(2000994);
    public final CustomMessageListener mRefreshEmotionPackageDetailListener = new c(2921063);
    public d.a.c.a.e dataCallBack = new f();
    public CustomMessageListener mDownloadCompleteListener = new j(2921375);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f14627e;

        public a(ShareItem shareItem) {
            this.f14627e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f14627e.t);
            l.M(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.j.z() && EmotionPackageDetailActivity.this.mModel != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity emotionPackageDetailActivity = EmotionPackageDetailActivity.this;
                emotionPackageDetailActivity.showLoadingView(emotionPackageDetailActivity.mRootView, false, l.g(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.mModel.y(EmotionPackageDetailActivity.this.mPckId);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2921063 || EmotionPackageDetailActivity.this.mPageData == null || EmotionPackageDetailActivity.this.mLeftTxt == null || EmotionPackageDetailActivity.this.mLeftContainer == null || EmotionPackageDetailActivity.this.mDownloadNum == null) {
                return;
            }
            SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
            EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0109);
            EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            EmotionPackageDetailActivity.this.mPageData.download++;
            EmotionPackageDetailActivity.this.mDownloadNum.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), StringHelper.numberUniform(EmotionPackageDetailActivity.this.mPageData.download)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, EmotionPackageDetailActivity.this.mPageData));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmotionPackageDetailActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                EmotionPackageDetailActivity.this.deleteEmotion();
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(e eVar) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.z()) {
                if (EmotionPackageDetailActivity.this.mDeleteDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity = EmotionPackageDetailActivity.this;
                    emotionPackageDetailActivity.mDeleteDialog = new d.a.m0.r.s.a(emotionPackageDetailActivity.getPageContext().getPageActivity());
                    EmotionPackageDetailActivity.this.mDeleteDialog.setMessageId(R.string.package_delete_confirm_tip);
                    EmotionPackageDetailActivity.this.mDeleteDialog.setPositiveButton(R.string.package_delete_positive_tip, new a());
                    EmotionPackageDetailActivity.this.mDeleteDialog.setNegativeButton(R.string.dialog_cancel, new b(this));
                    EmotionPackageDetailActivity.this.mDeleteDialog.setCancelable(true);
                    EmotionPackageDetailActivity.this.mDeleteDialog.create(EmotionPackageDetailActivity.this.getPageContext());
                }
                EmotionPackageDetailActivity.this.mDeleteDialog.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.a.e {
        public f() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            EmotionPackageDetailActivity emotionPackageDetailActivity = EmotionPackageDetailActivity.this;
            emotionPackageDetailActivity.hideLoadingView(emotionPackageDetailActivity.mRootView);
            EmotionPackageDetailActivity.this.mVoteMsg.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.mControllerLayout.setVisibility(0);
            EmotionPackageDetailActivity.this.bdListView.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.mPageData = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.mAdapter.e(EmotionPackageDetailActivity.this.mPageData.pics);
                EmotionPackageDetailActivity.this.mCoverImage.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.mPageData.forum_id > 0) {
                    EmotionPackageDetailActivity.this.emationSingleBarIcon.setVisibility(0);
                    EmotionPackageDetailActivity.this.mUserAvatar.V(EmotionPackageDetailActivity.this.mPageData.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.mUserName.setText(EmotionPackageDetailActivity.this.mPageData.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.mUserAvatar.V(EmotionPackageDetailActivity.this.mPageData.avatar, 10, false);
                    EmotionPackageDetailActivity.this.mUserName.setText(EmotionPackageDetailActivity.this.mPageData.author);
                }
                EmotionPackageDetailActivity.this.mCoverImage.V(EmotionPackageDetailActivity.this.mPageData.cover, 10, false);
                EmotionPackageDetailActivity.this.mImageNum.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.mPageData.num)));
                EmotionPackageDetailActivity.this.mDownloadNum.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), StringHelper.numFormatOverWan(EmotionPackageDetailActivity.this.mPageData.download)));
                EmotionPackageDetailActivity.this.mShareNum.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), StringHelper.numFormatOverWan(EmotionPackageDetailActivity.this.mPageData.share)));
                EmotionPackageDetailActivity.this.mPackageName.setText(EmotionPackageDetailActivity.this.mPageData.name);
                if (EmotionPackageDetailActivity.this.mPageData.owner == null || !EmotionPackageDetailActivity.this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.mDeletImg.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.mDeletImg.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.mPageData.status == 4 || EmotionPackageDetailActivity.this.mPageData.status == 2) {
                        EmotionPackageDetailActivity.this.mDeletImg.setEnabled(false);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(EmotionPackageDetailActivity.this.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                    } else {
                        EmotionPackageDetailActivity.this.mDeletImg.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.mPageData.status == 5 && EmotionPackageDetailActivity.this.mPageData.forum_id > 0) {
                    EmotionPackageDetailActivity.this.mVoteContainer.setVisibility(0);
                    EmotionPackageDetailActivity.this.mControllerLayout.setVisibility(8);
                    EmotionPackageDetailActivity.this.mDownloadNum.setVisibility(8);
                    EmotionPackageDetailActivity.this.mShareNum.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.mUserAvatar.getTop();
                    float bottom = (EmotionPackageDetailActivity.this.mDownloadNum.getBottom() - EmotionPackageDetailActivity.this.mPackageName.getBottom()) + l.g(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.mUserAvatar.getHeight();
                    EmotionPackageDetailActivity.this.mUserAvatar.setY(bottom);
                    EmotionPackageDetailActivity.this.mUserName.setY(bottom);
                    if (EmotionPackageDetailActivity.this.mPageData.owner == null || !EmotionPackageDetailActivity.this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.mVoteMsg.setVisibility(0);
                        TextView textView = EmotionPackageDetailActivity.this.mVoteMsg;
                        EmotionPackageDetailActivity emotionPackageDetailActivity2 = EmotionPackageDetailActivity.this;
                        textView.setText(emotionPackageDetailActivity2.getVoteNumber(emotionPackageDetailActivity2.mPageData.vote_num));
                        EmotionPackageDetailActivity.this.mVoteMsg.setY(top);
                        if (EmotionPackageDetailActivity.this.mPageData.has_vote == 1) {
                            EmotionPackageDetailActivity.this.changeVoteViewState();
                        } else {
                            SkinManager.setBackgroundColor(EmotionPackageDetailActivity.this.mDivider2, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.mVoteTxt.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.mVoteImg.setVisibility(8);
                        EmotionPackageDetailActivity.this.mDeletImg.setVisibility(8);
                        EmotionPackageDetailActivity.this.mVoteMsg.setVisibility(8);
                        SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mVoteTxt, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.mVoteContainer.setEnabled(false);
                    }
                }
                if (d.a.n0.m0.a.c().e("" + EmotionPackageDetailActivity.this.mPckId)) {
                    EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.already_downloaded);
                    SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0109);
                    SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
                    return;
                }
                int i2 = EmotionPackageDetailActivity.this.mPageData.status;
                if (i2 != 0) {
                    if (i2 == 1) {
                        EmotionPackageDetailActivity.this.mLeftContainer.setVisibility(0);
                        EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.download);
                        SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0302);
                        SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(true);
                        return;
                    } else if (i2 == 2) {
                        EmotionPackageDetailActivity.this.mLeftContainer.setVisibility(0);
                        SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0109);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(EmotionPackageDetailActivity.this.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                        EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
                        return;
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                            EmotionPackageDetailActivity.this.mLeftContainer.setVisibility(8);
                            return;
                        }
                        EmotionPackageDetailActivity.this.mLeftContainer.setVisibility(0);
                        SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0109);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(EmotionPackageDetailActivity.this.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
                        EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
                        return;
                    }
                }
                EmotionPackageDetailActivity.this.mLeftContainer.setVisibility(0);
                EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.download);
                SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0302);
                SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(true);
                return;
            }
            l.M(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.mControllerLayout.setVisibility(8);
            EmotionPackageDetailActivity.this.bdListView.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements EmotionPackageDetailModel.d {
        public g() {
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.d
        public void onResult(boolean z) {
            if (z) {
                SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0205);
                EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.package_already_delete);
                SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
                l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_success);
                EmotionPackageDetailActivity.this.setResult(-1);
                EmotionPackageDetailActivity.this.finish();
                return;
            }
            l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_fail);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements EmotionPackageDetailModel.e {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
                EmotionPackageDetailActivity.this.mVoteContainer.setEnabled(true);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                if (EmotionPackageDetailActivity.this.mPageData == null || TextUtils.isEmpty(EmotionPackageDetailActivity.this.mPageData.forum_name)) {
                    return;
                }
                EmotionPackageDetailActivity.this.doLike();
            }
        }

        public h() {
        }

        @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.e
        public void a(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921062, EmotionPackageDetailActivity.this.mPageData));
                EmotionPackageDetailActivity.this.changeVoteViewState();
                if (EmotionPackageDetailActivity.this.mVoteMsg != null && EmotionPackageDetailActivity.this.mVoteMsg.isShown()) {
                    TextView textView = EmotionPackageDetailActivity.this.mVoteMsg;
                    EmotionPackageDetailActivity emotionPackageDetailActivity = EmotionPackageDetailActivity.this;
                    textView.setText(emotionPackageDetailActivity.getVoteNumber(emotionPackageDetailActivity.voteSum + 1));
                }
                l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
            } else if (httpResponsedMessage.getError() == 170003) {
                if (EmotionPackageDetailActivity.this.mUnFollowDialog == null) {
                    EmotionPackageDetailActivity emotionPackageDetailActivity2 = EmotionPackageDetailActivity.this;
                    emotionPackageDetailActivity2.mUnFollowDialog = new d.a.m0.r.s.a(emotionPackageDetailActivity2.getPageContext().getPageActivity());
                    EmotionPackageDetailActivity.this.mUnFollowDialog.setMessageId(R.string.package_cant_vote_tips);
                    EmotionPackageDetailActivity.this.mUnFollowDialog.setNegativeButton(R.string.package_cant_vote_negative, new a());
                    EmotionPackageDetailActivity.this.mUnFollowDialog.setPositiveButton(R.string.package_cant_vote_positive, new b());
                    EmotionPackageDetailActivity.this.mUnFollowDialog.create(EmotionPackageDetailActivity.this.getPageContext());
                    EmotionPackageDetailActivity.this.mUnFollowDialog.setCancelable(true);
                }
                EmotionPackageDetailActivity.this.mUnFollowDialog.show();
            } else {
                EmotionPackageDetailActivity.this.mVoteContainer.setEnabled(true);
                if (httpResponsedMessage.getErrorString() == null) {
                    errorString = EmotionPackageDetailActivity.this.getString(R.string.package_vote_fail);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                l.M(EmotionPackageDetailActivity.this.getActivity(), errorString);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends d.a.c.a.e {
        public i() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (EmotionPackageDetailActivity.this.mLikeModel.getErrorCode() != 22) {
                if (AntiHelper.m(EmotionPackageDetailActivity.this.mLikeModel.getErrorCode(), EmotionPackageDetailActivity.this.mLikeModel.getErrorString())) {
                    AntiHelper.u(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.mLikeModel.getErrorString());
                } else if (EmotionPackageDetailActivity.this.mLikeModel.getErrorCode() != 0) {
                    l.M(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.mLikeModel.getErrorString());
                    EmotionPackageDetailActivity emotionPackageDetailActivity = EmotionPackageDetailActivity.this;
                    emotionPackageDetailActivity.showToast(emotionPackageDetailActivity.mLikeModel.getErrorString());
                } else {
                    w wVar = (w) obj;
                    if (wVar != null) {
                        l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                        TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.mPageData.forum_name);
                        wVar.v(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    } else {
                        l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                    }
                }
            } else {
                l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
            }
            EmotionPackageDetailActivity.this.mVoteContainer.setEnabled(true);
            EmotionPackageDetailActivity.this.mUnFollowDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.m0.a0.a)) {
                return;
            }
            d.a.n0.m0.a0.a aVar = (d.a.n0.m0.a0.a) customResponsedMessage.getData();
            int i2 = aVar.f57202a;
            if (i2 == 0) {
                l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                SkinManager.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.mLeftTxt.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(EmotionPackageDetailActivity.this.mLeftTxt, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                EmotionPackageDetailActivity.this.mPageData.download++;
                EmotionPackageDetailActivity.this.mDownloadNum.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), StringHelper.numberUniform(EmotionPackageDetailActivity.this.mPageData.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921059, EmotionPackageDetailActivity.this.mPageData));
            } else if (i2 == 1) {
                l.L(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                EmotionPackageDetailActivity.this.mLeftContainer.setEnabled(true);
            } else if (i2 == 2) {
                int i3 = aVar.f57203b;
                if (i3 > 0 && i3 < 100) {
                    l.J(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getString(R.string.package_downloading_progress));
                } else if (i3 >= 100) {
                    l.I(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVoteViewState() {
        this.mVoteTxt.setText(R.string.package_detail_voted);
        SkinManager.setImageResource(this.mVoteImg, R.drawable.icon_bar_voted);
        SkinManager.setViewTextColor(this.mVoteTxt, R.color.CAM_X0109);
        this.mVoteContainer.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEmotion() {
        this.mModel.x(this.mPckId, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLike() {
        if (this.mLikeModel == null) {
            this.mLikeModel = new LikeModel(getPageContext());
        }
        this.mLikeModel.setFrom("emotion_vote_follow");
        this.mLikeModel.setLoadDataCallBack(new i());
        LikeModel likeModel = this.mLikeModel;
        EmotionPackageData emotionPackageData = this.mPageData;
        likeModel.H(emotionPackageData.forum_name, String.valueOf(emotionPackageData.forum_id));
    }

    private void downloadEmotion() {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.mPckId < 0) {
                return;
            }
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mLeftContainer.setEnabled(false);
            this.mFaceGroupDownloadModel.s(Integer.toString(this.mPckId), Boolean.TRUE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVoteNumber(String str) {
        try {
            this.voteSum = Integer.valueOf(str).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    private void initData() {
        if (this.mModel == null) {
            this.mModel = new EmotionPackageDetailModel();
        }
        this.mModel.setLoadDataCallBack(this.dataCallBack);
        this.mModel.y(this.mPckId);
        this.voteSum = 0;
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_face_detail_tip), null);
        SkinManager.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mDeletImg = new ImageView(getPageContext().getPageActivity());
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mDeletImg, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, null);
        this.mDeletImg.setPadding(0, l.g(this, R.dimen.ds20), l.g(this, R.dimen.ds31), l.g(this, R.dimen.ds20));
        this.mDeletImg.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mDeletImg, new e());
        this.mNoNetworkView = (NoNetworkView) findViewById(R.id.no_network_view);
        if (d.a.c.e.p.j.A()) {
            this.mNoNetworkView.setVisibility(8);
        } else {
            this.mNoNetworkView.setVisibility(0);
        }
        this.mNoNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
        this.previewController = new d.a.n0.m0.a0.b(this);
    }

    private void shareEmotion() {
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
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    private void voteEmotion(int i2) {
        this.mVoteContainer.setEnabled(false);
        this.mModel.z(i2, new h());
    }

    public PackageDetailListView getListView() {
        return this.bdListView;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] split;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 24007 && !TextUtils.isEmpty(this.mTempShareUrl) && this.mTempShareUrl.contains("emoticonpackage") && (split = this.mTempShareUrl.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
            String str = split[split.length - 1];
            if (this.mFaceGroupShareModel == null) {
                this.mFaceGroupShareModel = new NewFaceGroupShareModel();
            }
            this.mFaceGroupShareModel.s(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
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
            noDataView.f(getPageContext(), i2);
        }
        d.a.n0.m0.a0.b bVar = this.previewController;
        if (bVar != null) {
            bVar.y(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (d.a.c.e.p.j.z()) {
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.mPageData.owner, 0L), this.mPageData.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.a.n0.m0.a0.b bVar = this.previewController;
        if (bVar != null) {
            bVar.s();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f14641e;

        /* renamed from: f  reason: collision with root package name */
        public int f14642f;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f14644e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ TbImageView f14645f;

            public a(int i2, TbImageView tbImageView) {
                this.f14644e = i2;
                this.f14645f = tbImageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageData.SingleEmotionData singleEmotionData = (EmotionPackageData.SingleEmotionData) k.this.f14641e.get(this.f14644e);
                if (singleEmotionData == null || singleEmotionData.id < 0 || EmotionPackageDetailActivity.this.mPckId < 0 || !d.a.c.e.p.j.z()) {
                    return;
                }
                EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.mPckId, singleEmotionData.id, this.f14645f.H());
                emotionDetailActivityConfig.setFromEmotionPackage(true);
                EmotionPackageDetailActivity.this.sendMessage(new CustomMessage(2002001, emotionDetailActivityConfig));
            }
        }

        /* loaded from: classes4.dex */
        public class b {

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f14647a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f14648b;

            /* renamed from: c  reason: collision with root package name */
            public TbImageView f14649c;

            /* renamed from: d  reason: collision with root package name */
            public TbImageView f14650d;

            public b(k kVar) {
            }

            public TbImageView a(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                return null;
                            }
                            return this.f14650d;
                        }
                        return this.f14649c;
                    }
                    return this.f14648b;
                }
                return this.f14647a;
            }

            public /* synthetic */ b(k kVar, b bVar) {
                this(kVar);
            }
        }

        public k() {
            this.f14641e = new ArrayList();
            this.f14642f = (l.k(TbadkCoreApplication.getInst()) - l.g(EmotionPackageDetailActivity.this.getActivity(), R.dimen.ds230)) / 4;
        }

        public final void c(int i2, b bVar) {
            for (int i3 = 0; i3 < 4; i3++) {
                TbImageView a2 = bVar.a(i3);
                if (a2 != null) {
                    int i4 = (i2 * 4) + i3;
                    if (i4 < this.f14641e.size() && i4 >= 0) {
                        a2.setVisibility(0);
                        a2.setTag(null);
                        a2.setDefaultResource(R.drawable.img_default_100);
                        a2.V(this.f14641e.get(i4).thumbnail, 10, false);
                        a2.invalidate();
                        a2.setOnClickListener(new a(i4, a2));
                    } else {
                        a2.setVisibility(4);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: d */
        public List<EmotionPackageData.SingleEmotionData> getItem(int i2) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.f14641e.size() / 4; size < (this.f14641e.size() / 4) + 4; size++) {
                if (size > 0 && size < this.f14641e.size()) {
                    arrayList.add(this.f14641e.get(size));
                }
            }
            return this.f14641e;
        }

        public final void e(List<EmotionPackageData.SingleEmotionData> list) {
            if (list == null) {
                return;
            }
            this.f14641e.clear();
            this.f14641e.addAll(new ArrayList(list));
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = this.f14641e.size() / 4;
            return this.f14641e.size() % 4 > 0 ? size + 1 : size;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b(this, null);
                view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.package_item_image1);
                bVar.f14647a = tbImageView;
                ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                layoutParams.height = this.f14642f;
                bVar.f14647a.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(bVar.f14647a, R.color.CAM_X0201);
                TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.package_item_image2);
                bVar.f14648b = tbImageView2;
                ViewGroup.LayoutParams layoutParams2 = tbImageView2.getLayoutParams();
                layoutParams2.height = this.f14642f;
                bVar.f14648b.setLayoutParams(layoutParams2);
                SkinManager.setBackgroundColor(bVar.f14648b, R.color.CAM_X0201);
                TbImageView tbImageView3 = (TbImageView) view2.findViewById(R.id.package_item_image3);
                bVar.f14649c = tbImageView3;
                ViewGroup.LayoutParams layoutParams3 = tbImageView3.getLayoutParams();
                layoutParams3.height = this.f14642f;
                bVar.f14649c.setLayoutParams(layoutParams3);
                SkinManager.setBackgroundColor(bVar.f14649c, R.color.CAM_X0201);
                TbImageView tbImageView4 = (TbImageView) view2.findViewById(R.id.package_item_image4);
                bVar.f14650d = tbImageView4;
                ViewGroup.LayoutParams layoutParams4 = tbImageView4.getLayoutParams();
                layoutParams4.height = this.f14642f;
                bVar.f14650d.setLayoutParams(layoutParams4);
                SkinManager.setBackgroundColor(bVar.f14650d, R.color.CAM_X0201);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            c(i2, bVar);
            return view2;
        }

        public /* synthetic */ k(EmotionPackageDetailActivity emotionPackageDetailActivity, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVoteNumber(int i2) {
        this.voteSum = i2;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i2));
    }
}
