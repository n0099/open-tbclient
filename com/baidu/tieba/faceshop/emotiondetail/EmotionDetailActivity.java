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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.a;
import com.baidu.tieba.faceshop.ab;
import com.baidu.tieba.faceshop.ac;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel;
import com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView;
import com.baidu.tieba.faceshop.i;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class EmotionDetailActivity extends BaseActivity<EmotionDetailActivity> {
    private View bUO;
    private NoNetworkView gCe;
    private View iJd;
    private TbImageView iVG;
    private NewFaceGroupDownloadModel iWa;
    private boolean isGif;
    private TextView jbA;
    private TextView jbB;
    private LinearLayout jbC;
    private boolean jbD;
    private View jbg;
    private View jbh;
    private EmotionDetailImageView jbi;
    private TextView jbj;
    private TextView jbk;
    private TextView jbl;
    private ImageView jbm;
    private ImageView jbn;
    private TextView jbo;
    private TextView jbp;
    private ImageView jbq;
    private View jbr;
    private View jbs;
    private View jbt;
    private EmotionDetailModel jbu;
    private EmotionDetailData jbv;
    private PopupWindow jbw;
    private View jbx;
    private View jby;
    private TextView jbz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mRootView;
    private int pck_id;
    private long pic_id;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && EmotionDetailActivity.this.mNoDataView != null && EmotionDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionDetailActivity.this.showLoadingView(EmotionDetailActivity.this.mRootView, false, l.getDimens(EmotionDetailActivity.this, R.dimen.ds400));
                EmotionDetailActivity.this.jbu.z(EmotionDetailActivity.this.pic_id, EmotionDetailActivity.this.pck_id);
            }
        }
    };
    private e mLoadDataCallBack = new e() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionDetailActivity.this.hideLoadingView(EmotionDetailActivity.this.mRootView);
            EmotionDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionDetailActivity.this.jbr.setVisibility(0);
            EmotionDetailActivity.this.iJd.setVisibility(0);
            EmotionDetailActivity.this.jbi.setVisibility(0);
            if (obj != null) {
                EmotionDetailActivity.this.jbv = (EmotionDetailData) obj;
                if (EmotionDetailActivity.this.jbv.pic_info != null && !TextUtils.isEmpty(EmotionDetailActivity.this.jbv.pic_info.pic_url)) {
                    EmotionDetailActivity.this.jbi.a(EmotionDetailActivity.this.jbv, 33, EmotionDetailActivity.this.isGif);
                }
                if (EmotionDetailActivity.this.jbv.pck_info == null || TextUtils.isEmpty(EmotionDetailActivity.this.jbv.pck_info.cover)) {
                    EmotionDetailActivity.this.iJd.setVisibility(8);
                } else {
                    EmotionDetailActivity.this.iVG.startLoad(EmotionDetailActivity.this.jbv.pck_info.cover, 10, false);
                    if (EmotionDetailActivity.this.jbv.pck_info.forum_name == null) {
                        EmotionDetailActivity.this.jbj.setText(EmotionDetailActivity.this.jbv.pck_info.pck_name);
                        EmotionDetailActivity.this.jbk.setText(String.format(EmotionDetailActivity.this.getString(R.string.forum_and_download_num), EmotionDetailActivity.this.jbv.pck_info.owner.user_name, au.numFormatOverWan(b.toLong(EmotionDetailActivity.this.jbv.pck_info.download, 0L))));
                    } else {
                        EmotionDetailActivity.this.jbk.setText(String.format(EmotionDetailActivity.this.getString(R.string.forum_and_download_num), EmotionDetailActivity.this.jbv.pck_info.forum_name + EmotionDetailActivity.this.getString(R.string.forum), au.numFormatOverWan(b.toLong(EmotionDetailActivity.this.jbv.pck_info.download, 0L))));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) EmotionDetailActivity.this.getString(R.string.emotion_center_single_bar_top)).append((CharSequence) " ").append((CharSequence) EmotionDetailActivity.this.jbv.pck_info.pck_name);
                        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(EmotionDetailActivity.this.getPageContext().getPageActivity(), R.drawable.emotion_pic_single_bar), 0, 2, 17);
                        EmotionDetailActivity.this.jbj.setText(spannableStringBuilder);
                    }
                }
                if (a.cyB().JF("" + EmotionDetailActivity.this.pck_id)) {
                    EmotionDetailActivity.this.jbl.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionDetailActivity.this.jbl, R.color.CAM_X0109);
                    EmotionDetailActivity.this.jbl.setEnabled(false);
                    ap.setBackgroundColor(EmotionDetailActivity.this.jbl, R.color.transparent);
                } else {
                    EmotionDetailActivity.this.jbl.setText(R.string.download);
                    ap.setViewTextColor(EmotionDetailActivity.this.jbl, R.color.CAM_X0302);
                    ap.setBackgroundResource(EmotionDetailActivity.this.jbl, R.drawable.bg_emotion_download);
                }
                if (ac.czW().Ka(StringUtils.string(Long.valueOf(EmotionDetailActivity.this.jbv.pic_info.pic_id)))) {
                    ap.setImageResource(EmotionDetailActivity.this.jbm, R.drawable.icon_bar_collectioned);
                    EmotionDetailActivity.this.jbo.setText(R.string.emotion_detail_collectioned);
                    ap.setViewTextColor(EmotionDetailActivity.this.jbo, R.color.CAM_X0302);
                    return;
                }
                ap.setImageResource(EmotionDetailActivity.this.jbm, R.drawable.icon_bar_collection_emotion);
                ap.setViewTextColor(EmotionDetailActivity.this.jbo, R.color.CAM_X0302);
                return;
            }
            l.showToast(EmotionDetailActivity.this.getActivity(), EmotionDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionDetailActivity.this.jbr.setVisibility(8);
            EmotionDetailActivity.this.iJd.setVisibility(8);
            EmotionDetailActivity.this.jbi.setVisibility(8);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pic_id = getIntent().getLongExtra(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, -1L);
        this.pck_id = getIntent().getIntExtra("pck_id", -1);
        this.isGif = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_IS_GIF_KEY, false);
        this.jbD = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, false);
        if (this.pic_id < 0 && this.pck_id < 0) {
            finish();
        }
        setContentView(R.layout.emotion_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
    }

    private void initData() {
        if (this.jbu == null) {
            this.jbu = new EmotionDetailModel();
        }
        this.jbu.setLoadDataCallBack(this.mLoadDataCallBack);
        this.jbu.z(this.pic_id, this.pck_id);
    }

    private void initUI() {
        this.mRootView = findViewById(R.id.emotion_detail_container);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this, R.dimen.ds200)), NoDataViewFactory.d.pA(R.string.no_face_detail_tip), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        ap.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.emotion_detail)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionDetailActivity.this.finish();
            }
        });
        this.gCe = (NoNetworkView) findViewById(R.id.no_network_view);
        if (j.isNetworkAvailableForImmediately()) {
            this.gCe.setVisibility(8);
        } else {
            this.gCe.setVisibility(0);
        }
        this.gCe.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jbq = new ImageView(getPageContext().getPageActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.jbq.setPadding(0, l.getDimens(this, R.dimen.ds20), l.getDimens(this, R.dimen.ds31), l.getDimens(this, R.dimen.ds20));
        this.jbq.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jbq, this);
        this.jbi = (EmotionDetailImageView) findViewById(R.id.emotion_detail_image_view);
        this.iJd = findViewById(R.id.emotion_detail_top_container);
        this.iJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EmotionDetailActivity.this.jbD) {
                    EmotionDetailActivity.this.cAt();
                }
            }
        });
        this.jbr = findViewById(R.id.emotion_detail_bottom_container);
        this.bUO = findViewById(R.id.divider);
        this.jbg = findViewById(R.id.divider2);
        this.jbh = findViewById(R.id.controller_divider);
        this.iVG = (TbImageView) findViewById(R.id.emotion_package_cover);
        this.iVG.setGifIconSupport(false);
        this.jbs = findViewById(R.id.right_function_container);
        this.jbt = findViewById(R.id.left_function_container);
        this.jbt.setOnClickListener(this);
        this.jbs.setOnClickListener(this);
        this.jbm = (ImageView) findViewById(R.id.add_emotion_img);
        this.jbo = (TextView) findViewById(R.id.add_emotion_txt);
        this.jbn = (ImageView) findViewById(R.id.save_to_local_img);
        this.jbp = (TextView) findViewById(R.id.save_to_local_txt);
        this.jbk = (TextView) findViewById(R.id.emotion_detail_owner_and_download_num);
        this.jbk.setOnClickListener(null);
        this.jbj = (TextView) findViewById(R.id.emotion_package_name);
        this.jbl = (TextView) findViewById(R.id.emotion_download_tv);
        this.jbl.setOnClickListener(this);
        cAs();
    }

    private void cAs() {
        this.jbw = new PopupWindow(getPageContext().getPageActivity());
        final View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_detail_popuwindow_layout, (ViewGroup) null);
        this.jbC = (LinearLayout) inflate.findViewById(R.id.id_pop_layout);
        this.jbx = inflate.findViewById(R.id.line1);
        this.jby = inflate.findViewById(R.id.line2);
        this.jbz = (TextView) inflate.findViewById(R.id.tv_delete_emotion_tips);
        this.jbA = (TextView) inflate.findViewById(R.id.tv_delete_my_emotion);
        this.jbA.setOnClickListener(this);
        this.jbB = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.jbB.setOnClickListener(this);
        this.jbw.setContentView(inflate);
        this.jbw.setWidth(-1);
        this.jbw.setHeight(l.getEquipmentHeight(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.a.getNavigationBarHeight(getPageContext().getPageActivity()));
        this.jbw.setFocusable(true);
        this.jbw.setBackgroundDrawable(new ColorDrawable(this.jbw.getContentView().getResources().getColor(R.color.black_alpha50)));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                declaredField.setAccessible(true);
                declaredField.set(this.jbw, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = inflate.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    EmotionDetailActivity.this.jbw.dismiss();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        EmotionDetailData emotionDetailData = this.jbv;
        if (emotionDetailData != null && emotionDetailData.pck_info != null && emotionDetailData.pck_info.pck_id > 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this, emotionDetailData.pck_info.pck_id, RequestResponseCode.REQUEST_EMOTION_DETAIL)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.mSkinType = i;
        this.mNoDataView.onChangeSkinType(getPageContext(), i);
        this.gCe.onChangeSkinType(getPageContext(), i);
        ap.setImageResource(this.jbn, R.drawable.icon_bar_download);
        ap.setViewTextColor(this.jbp, R.color.CAM_X0302);
        ap.setBackgroundColor(this.jbg, R.color.CAM_X0204);
        ap.setBackgroundColor(this.bUO, R.color.CAM_X0204);
        ap.setViewTextColor(this.jbk, R.color.CAM_X0109);
        ap.setViewTextColor(this.jbj, R.color.CAM_X0105);
        ap.setBackgroundColor(this.jbh, R.color.CAM_X0204);
        ap.setBackgroundResource(this.jbC, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jbx, R.color.CAM_X0204);
        ap.setBackgroundResource(this.jby, R.color.CAM_X0204);
        ap.setViewTextColor(this.jbA, R.color.cp_cont_r);
        ap.setViewTextColor(this.jbB, R.color.CAM_X0107);
        ap.setViewTextColor(this.jbz, R.color.CAM_X0109);
        SvgManager.bsU().a(this.jbq, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.jbr, R.color.common_color_10311, i);
        } else {
            ap.setBackgroundColor(this.jbr, R.color.white_alpha100, i);
        }
    }

    private void cyP() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.jbv != null) {
            final ShareItem shareItem = new ShareItem();
            if (this.jbv.pic_info != null && !StringUtils.isNull(this.jbv.pic_info.pic_url)) {
                shareItem.imageUri = Uri.parse(this.jbv.pic_info.pic_url);
            }
            if (this.jbv.pck_info != null && !StringUtils.isNull(this.jbv.pck_info.pck_name)) {
                shareItem.title = this.jbv.pck_info.pck_name;
            } else {
                shareItem.title = getString(R.string.tieba_emotion_share);
            }
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticon/" + this.pck_id + "/" + this.jbv.pic_info.pic_id;
            shareItem.shareType = 2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(EmotionDetailActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void cyO() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity()) && this.pck_id >= 0) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iWa == null) {
                this.iWa = new NewFaceGroupDownloadModel();
            }
            this.jbl.setEnabled(false);
            this.iWa.a(StringUtils.string(Integer.valueOf(this.pck_id)), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.8
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionDetailActivity.this.getActivity(), R.string.down_state_success);
                    EmotionDetailActivity.this.jbl.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionDetailActivity.this.jbl, R.color.CAM_X0109);
                    EmotionDetailActivity.this.jbl.setEnabled(false);
                    ap.setBackgroundColor(EmotionDetailActivity.this.jbl, R.color.transparent);
                    EmotionDetailActivity.this.jbk.setText(String.format(EmotionDetailActivity.this.getString(R.string.forum_and_download_num), EmotionDetailActivity.this.jbv.pck_info.owner.user_name, au.numberUniform(b.toLong(EmotionDetailActivity.this.jbv.pck_info.download + 1, 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL));
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                    if (i > 0 && i < 100) {
                        l.showLongToast(EmotionDetailActivity.this.getActivity(), EmotionDetailActivity.this.getString(R.string.package_downloading_progress));
                    } else if (i >= 100) {
                        l.showLongToast(EmotionDetailActivity.this.getActivity(), R.string.down_state_success);
                    }
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    l.showToast(EmotionDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionDetailActivity.this.jbl.setEnabled(true);
                }
            });
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (j.isNetWorkAvailable()) {
            if (view == this.jbs) {
                cAw();
            } else if (view == this.jbt) {
                cAv();
            } else if (view == this.jbl) {
                cyO();
            } else if (view == this.jbB) {
                this.jbw.dismiss();
            } else if (view == this.jbA) {
                cAu();
                this.jbw.dismiss();
            } else if (view == this.jbq) {
                cyP();
            }
        }
    }

    private void cAu() {
        new BdAsyncTask<Void, Void, List<CollectEmotionData>>() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<CollectEmotionData> doInBackground(Void... voidArr) {
                List<CollectEmotionData> JP = i.cyR().JP(TbadkCoreApplication.getCurrentAccount());
                if (JP == null || JP.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<CollectEmotionData> it = JP.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CollectEmotionData next = it.next();
                    if (!d.SETTING_SHARP_TEXT.equals(next.sharpText) && !TextUtils.isEmpty(next.pid)) {
                        String str = o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + d.getSaveDir() + "/" + next.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0 && next.pid.equals(StringUtils.string(Long.valueOf(EmotionDetailActivity.this.pic_id)))) {
                            imageFileInfo.setModifyTime(au.getChineseFormatTimeString(file.lastModified()));
                            next.imageFileInfo = imageFileInfo;
                            arrayList.add(next);
                            break;
                        }
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<CollectEmotionData> list) {
                if (list != null && list.size() != 0) {
                    ab.czT().d(list, true, new ab.c() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.9.1
                        @Override // com.baidu.tieba.faceshop.ab.c
                        public void S(int i, int i2, int i3) {
                            if (i2 > 0 && i == 1) {
                                ap.setImageResource(EmotionDetailActivity.this.jbm, R.drawable.icon_bar_collection_emotion);
                                EmotionDetailActivity.this.jbo.setText(R.string.emotion_detail_collection);
                                l.showToast(TbadkCoreApplication.getInst(), R.string.delete_success);
                                return;
                            }
                            l.showToast(TbadkCoreApplication.getInst(), R.string.delete_fail);
                        }
                    });
                }
            }
        }.execute(new Void[0]);
    }

    private void cAv() {
        if (this.jbv.pic_info != null && !TextUtils.isEmpty(this.jbv.pic_info.pic_url)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.COLLECT_EMOTION_DETAIL)));
            } else if (ac.czW().Ka(StringUtils.string(Long.valueOf(this.jbv.pic_info.pic_id)))) {
                if (this.jbw != null) {
                    Rect rect = new Rect();
                    getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.jbw.showAtLocation(this.mRootView, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                }
            } else {
                String str = this.jbv.pic_info.pic_url;
                int i = this.jbv.pck_info == null ? 0 : this.jbv.pck_info.pck_id;
                c cVar = new c();
                cVar.picUrl = str;
                cVar.pkgId = StringUtils.string(Integer.valueOf(i));
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar);
                ab.czT().a((List<c>) arrayList, true, new ab.c() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.10
                    @Override // com.baidu.tieba.faceshop.ab.c
                    public void S(int i2, int i3, int i4) {
                        if (i2 == 4) {
                            if (i3 == 1) {
                                ap.setImageResource(EmotionDetailActivity.this.jbm, R.drawable.icon_bar_collectioned);
                                EmotionDetailActivity.this.jbo.setText(R.string.emotion_detail_collectioned);
                                l.showToast(TbadkCoreApplication.getInst(), R.string.add_success);
                                return;
                            }
                            l.showToast(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                        }
                    }
                });
            }
        }
    }

    private void cAw() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            String str = this.jbv.pic_info.pic_url;
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tieba.newfaceshop.c.diB().a(str, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.faceshop.emotiondetail.EmotionDetailActivity.2
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str2) {
                        l.showToast(EmotionDetailActivity.this.getPageContext().getPageActivity(), R.string.save_success);
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str2) {
                        l.showToast(EmotionDetailActivity.this.getPageContext().getPageActivity(), str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25031) {
            cAv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jbu != null) {
            this.jbu.cancelLoadData();
        }
        if (this.iWa != null) {
            this.iWa.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }
}
