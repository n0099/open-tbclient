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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    private View dDI;
    private View dDZ;
    private TextView eLt;
    private LikeModel fpO;
    private NoNetworkView gCe;
    private HeadImageView gEO;
    private EmotionPackageDetailModel iSH;
    private PackageDetailListView iSI;
    private TbImageView iSJ;
    private TextView iSK;
    private TextView iSL;
    private TextView iSM;
    private TextView iSN;
    private a iSO;
    private View iSP;
    private View iSQ;
    private View iSR;
    private TextView iSS;
    private TextView iST;
    private ImageView iSU;
    private TextView iSV;
    private View iSW;
    private View iSX;
    private EmotionPackageData iSY;
    private int iSZ;
    private com.baidu.tbadk.core.dialog.a iTa;
    private com.baidu.tbadk.core.dialog.a iTb;
    private ImageView iTc;
    private NewFaceGroupDownloadModel iTd;
    private NewFaceGroupShareModel iTe;
    private String iTf;
    private View iTg;
    private com.baidu.tieba.faceshop.packagedetail.b iTh;
    private int iTi;
    private View mHeaderView;
    private ImageView mLeftImg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mRootView;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    private final String iSG = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable() && EmotionPackageDetailActivity.this.iSH != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity.this.showLoadingView(EmotionPackageDetailActivity.this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.iSH.loadData(EmotionPackageDetailActivity.this.iSZ);
            }
        }
    };
    final CustomMessageListener iTj = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921063 && EmotionPackageDetailActivity.this.iSY != null && EmotionPackageDetailActivity.this.iSS != null && EmotionPackageDetailActivity.this.iSR != null && EmotionPackageDetailActivity.this.iSM != null) {
                ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.iSS.setText(R.string.already_downloaded);
                ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                EmotionPackageDetailActivity.this.iSY.download++;
                EmotionPackageDetailActivity.this.iSM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numberUniform(EmotionPackageDetailActivity.this.iSY.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iSY));
            }
        }
    };
    private com.baidu.adp.base.e iTk = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionPackageDetailActivity.this.hideLoadingView(EmotionPackageDetailActivity.this.mRootView);
            EmotionPackageDetailActivity.this.iST.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.iSP.setVisibility(0);
            EmotionPackageDetailActivity.this.iSI.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.iSY = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.iSO.bs(EmotionPackageDetailActivity.this.iSY.pics);
                EmotionPackageDetailActivity.this.iSJ.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.iSY.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iTg.setVisibility(0);
                    EmotionPackageDetailActivity.this.gEO.startLoad(EmotionPackageDetailActivity.this.iSY.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.eLt.setText(EmotionPackageDetailActivity.this.iSY.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.gEO.startLoad(EmotionPackageDetailActivity.this.iSY.avatar, 10, false);
                    EmotionPackageDetailActivity.this.eLt.setText(EmotionPackageDetailActivity.this.iSY.author);
                }
                EmotionPackageDetailActivity.this.iSJ.startLoad(EmotionPackageDetailActivity.this.iSY.cover, 10, false);
                EmotionPackageDetailActivity.this.iSK.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.iSY.num)));
                EmotionPackageDetailActivity.this.iSM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numFormatOverWan(EmotionPackageDetailActivity.this.iSY.download)));
                EmotionPackageDetailActivity.this.iSN.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), at.numFormatOverWan(EmotionPackageDetailActivity.this.iSY.share)));
                EmotionPackageDetailActivity.this.iSL.setText(EmotionPackageDetailActivity.this.iSY.name);
                if (EmotionPackageDetailActivity.this.iSY.owner == null || !EmotionPackageDetailActivity.this.iSY.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.iTc.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.iTc.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.iSY.status == 4 || EmotionPackageDetailActivity.this.iSY.status == 2) {
                        EmotionPackageDetailActivity.this.iTc.setEnabled(false);
                        SvgManager.bwr().a(EmotionPackageDetailActivity.this.iTc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                    } else {
                        EmotionPackageDetailActivity.this.iTc.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.iSY.status == 5 && EmotionPackageDetailActivity.this.iSY.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iSQ.setVisibility(0);
                    EmotionPackageDetailActivity.this.iSP.setVisibility(8);
                    EmotionPackageDetailActivity.this.iSM.setVisibility(8);
                    EmotionPackageDetailActivity.this.iSN.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.gEO.getTop();
                    int bottom = (EmotionPackageDetailActivity.this.iSM.getBottom() - EmotionPackageDetailActivity.this.iSL.getBottom()) + com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.gEO.getHeight();
                    EmotionPackageDetailActivity.this.gEO.setY(bottom);
                    EmotionPackageDetailActivity.this.eLt.setY(bottom);
                    if (EmotionPackageDetailActivity.this.iSY.owner == null || !EmotionPackageDetailActivity.this.iSY.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.iST.setVisibility(0);
                        EmotionPackageDetailActivity.this.iST.setText(EmotionPackageDetailActivity.this.Kb(EmotionPackageDetailActivity.this.iSY.vote_num));
                        EmotionPackageDetailActivity.this.iST.setY(top);
                        if (EmotionPackageDetailActivity.this.iSY.has_vote == 1) {
                            EmotionPackageDetailActivity.this.cBh();
                        } else {
                            ao.setBackgroundColor(EmotionPackageDetailActivity.this.dDZ, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.iSV.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.iSU.setVisibility(8);
                        EmotionPackageDetailActivity.this.iTc.setVisibility(8);
                        EmotionPackageDetailActivity.this.iST.setVisibility(8);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iSV, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.iSQ.setEnabled(false);
                    }
                }
                if (com.baidu.tieba.faceshop.a.cAV().JV("" + EmotionPackageDetailActivity.this.iSZ)) {
                    EmotionPackageDetailActivity.this.iSS.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0109);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                    return;
                }
                switch (EmotionPackageDetailActivity.this.iSY.status) {
                    case 0:
                    case 3:
                        EmotionPackageDetailActivity.this.iSR.setVisibility(0);
                        EmotionPackageDetailActivity.this.iSS.setText(R.string.download);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0302);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iSR.setEnabled(true);
                        return;
                    case 1:
                        EmotionPackageDetailActivity.this.iSR.setVisibility(0);
                        EmotionPackageDetailActivity.this.iSS.setText(R.string.download);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0302);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iSR.setEnabled(true);
                        return;
                    case 2:
                        EmotionPackageDetailActivity.this.iSR.setVisibility(0);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0109);
                        SvgManager.bwr().a(EmotionPackageDetailActivity.this.iTc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iSS.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                        return;
                    case 4:
                        EmotionPackageDetailActivity.this.iSR.setVisibility(0);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0109);
                        SvgManager.bwr().a(EmotionPackageDetailActivity.this.iTc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iSS.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                        return;
                    default:
                        EmotionPackageDetailActivity.this.iSR.setVisibility(8);
                        return;
                }
            }
            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.iSP.setVisibility(8);
            EmotionPackageDetailActivity.this.iSI.setVisibility(8);
        }
    };
    private CustomMessageListener iTl = new CustomMessageListener(2921375) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.faceshop.packagedetail.a)) {
                com.baidu.tieba.faceshop.packagedetail.a aVar = (com.baidu.tieba.faceshop.packagedetail.a) customResponsedMessage.getData();
                if (aVar.resultCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iSS.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0109);
                    EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    EmotionPackageDetailActivity.this.iSY.download++;
                    EmotionPackageDetailActivity.this.iSM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numberUniform(EmotionPackageDetailActivity.this.iSY.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iSY));
                } else if (aVar.resultCode == 1) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionPackageDetailActivity.this.iSR.setEnabled(true);
                } else if (aVar.resultCode == 2) {
                    int i = aVar.progress;
                    if (i > 0 && i < 100) {
                        com.baidu.adp.lib.util.l.showLongToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getString(R.string.package_downloading_progress));
                    } else if (i >= 100) {
                        com.baidu.adp.lib.util.l.showLongToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iSZ = getIntent().getIntExtra("pck_id", -1);
        if (this.iSZ < 0) {
            finish();
            return;
        }
        setContentView(R.layout.emotion_package_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iTj);
        registerListener(this.iTl);
        TiebaStatic.log("c12330");
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.ra(R.string.no_face_detail_tip), null);
        ao.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageDetailActivity.this.finish();
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iTc = new ImageView(getPageContext().getPageActivity());
        SvgManager.bwr().a(this.iTc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.iTc.setPadding(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds31), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20));
        this.iTc.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iTc, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (EmotionPackageDetailActivity.this.iTa == null) {
                        EmotionPackageDetailActivity.this.iTa = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                        EmotionPackageDetailActivity.this.iTa.pa(R.string.package_delete_confirm_tip);
                        EmotionPackageDetailActivity.this.iTa.a(R.string.package_delete_positive_tip, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                EmotionPackageDetailActivity.this.cBg();
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iTa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iTa.jH(true);
                        EmotionPackageDetailActivity.this.iTa.b(EmotionPackageDetailActivity.this.getPageContext());
                    }
                    EmotionPackageDetailActivity.this.iTa.btY();
                }
            }
        });
        this.gCe = (NoNetworkView) findViewById(R.id.no_network_view);
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.gCe.setVisibility(8);
        } else {
            this.gCe.setVisibility(0);
        }
        this.gCe.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iSI = (PackageDetailListView) findViewById(R.id.package_image_gridview);
        this.iSO = new a();
        this.mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
        this.iSI.addHeaderView(this.mHeaderView);
        this.iSJ = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
        this.iTg = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
        this.dDI = this.mHeaderView.findViewById(R.id.divider_line);
        this.iSK = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
        this.iSL = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
        this.iSM = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
        this.iSN = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
        this.iST = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
        this.gEO = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
        this.gEO.setIsRound(true);
        this.gEO.setOnClickListener(this);
        this.eLt = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
        this.eLt.setOnClickListener(this);
        this.iSI.setAdapter((ListAdapter) this.iSO);
        this.dDZ = findViewById(R.id.above_controller_divider);
        this.iSP = findViewById(R.id.package_controller_layout);
        this.iSX = findViewById(R.id.controller_divider);
        this.iSR = findViewById(R.id.left_function_container);
        this.iSR.setOnClickListener(this);
        this.mLeftImg = (ImageView) findViewById(R.id.left_img);
        this.iSS = (TextView) findViewById(R.id.left_txt);
        this.iSW = findViewById(R.id.right_function_container);
        this.iSW.setOnClickListener(this);
        this.iSQ = findViewById(R.id.package_vote_container);
        this.iSQ.setOnClickListener(this);
        this.iSU = (ImageView) findViewById(R.id.vote_img);
        this.iSV = (TextView) findViewById(R.id.vote_text);
        this.iTh = new com.baidu.tieba.faceshop.packagedetail.b(this);
    }

    public PackageDetailListView cBf() {
        return this.iSI;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (view == this.iSR) {
                cBi();
            } else if (view == this.iSW) {
                cBj();
            } else if (view == this.gEO || view == this.eLt) {
                if (this.iSY != null && !TextUtils.isEmpty(this.iSY.owner)) {
                    if (this.iSY.forum_id > 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iSY.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iSY.owner, 0L), this.iSY.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            } else if (view == this.iSQ) {
                zr(this.iSZ);
            }
        }
    }

    private void initData() {
        if (this.iSH == null) {
            this.iSH = new EmotionPackageDetailModel();
        }
        this.iSH.setLoadDataCallBack(this.iTk);
        this.iSH.loadData(this.iSZ);
        this.iTi = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Kb(String str) {
        try {
            this.iTi = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zq(int i) {
        this.iTi = i;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRootView);
        ao.setBackgroundColor(this.iSI, R.color.CAM_X0201);
        ao.setBackgroundColor(this.dDI, R.color.CAM_X0205);
        ao.setViewTextColor(this.iSM, R.color.CAM_X0109);
        ao.setViewTextColor(this.iSN, R.color.CAM_X0109);
        ao.setViewTextColor(this.iSL, R.color.CAM_X0105);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0304);
        ao.setViewTextColor(this.iST, R.color.CAM_X0109);
        ao.setViewTextColor(this.iSK, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            ao.setBackgroundColor(this.iSP, R.color.common_color_10311, i);
            ao.setBackgroundColor(this.iSQ, R.color.CAM_X0201_1, i);
        } else {
            ao.setBackgroundColor(this.iSP, R.color.white_alpha100, i);
        }
        ao.setBackgroundColor(this.iSX, R.color.CAM_X0205);
        ao.setBackgroundColor(this.dDZ, R.color.CAM_X0205);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.iTh != null) {
            this.iTh.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBg() {
        this.iSH.a(this.iSZ, new EmotionPackageDetailModel.a() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.7
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.a
            public void onResult(boolean z) {
                if (z) {
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iSS, R.color.CAM_X0205);
                    EmotionPackageDetailActivity.this.iSS.setText(R.string.package_already_delete);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iSR.setEnabled(false);
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_success);
                    EmotionPackageDetailActivity.this.setResult(-1);
                    EmotionPackageDetailActivity.this.finish();
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_fail);
            }
        });
    }

    private void zr(int i) {
        this.iSQ.setEnabled(false);
        this.iSH.a(i, new EmotionPackageDetailModel.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.b
            public void c(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS, EmotionPackageDetailActivity.this.iSY));
                        EmotionPackageDetailActivity.this.cBh();
                        if (EmotionPackageDetailActivity.this.iST != null && EmotionPackageDetailActivity.this.iST.isShown()) {
                            EmotionPackageDetailActivity.this.iST.setText(EmotionPackageDetailActivity.this.zq(EmotionPackageDetailActivity.this.iTi + 1));
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
                    } else if (httpResponsedMessage.getError() == 170003) {
                        if (EmotionPackageDetailActivity.this.iTb == null) {
                            EmotionPackageDetailActivity.this.iTb = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                            EmotionPackageDetailActivity.this.iTb.pa(R.string.package_cant_vote_tips);
                            EmotionPackageDetailActivity.this.iTb.b(R.string.package_cant_vote_negative, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    EmotionPackageDetailActivity.this.iSQ.setEnabled(true);
                                }
                            });
                            EmotionPackageDetailActivity.this.iTb.a(R.string.package_cant_vote_positive, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (EmotionPackageDetailActivity.this.iSY != null && !TextUtils.isEmpty(EmotionPackageDetailActivity.this.iSY.forum_name)) {
                                        EmotionPackageDetailActivity.this.cAB();
                                    }
                                }
                            });
                            EmotionPackageDetailActivity.this.iTb.b(EmotionPackageDetailActivity.this.getPageContext());
                            EmotionPackageDetailActivity.this.iTb.jH(true);
                        }
                        EmotionPackageDetailActivity.this.iTb.btY();
                    } else {
                        EmotionPackageDetailActivity.this.iSQ.setEnabled(true);
                        if (httpResponsedMessage.getErrorString() == null) {
                            errorString = EmotionPackageDetailActivity.this.getString(R.string.package_vote_fail);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), errorString);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBh() {
        this.iSV.setText(R.string.package_detail_voted);
        ao.setImageResource(this.iSU, R.drawable.icon_bar_voted);
        ao.setViewTextColor(this.iSV, R.color.CAM_X0109);
        this.iSQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAB() {
        if (this.fpO == null) {
            this.fpO = new LikeModel(getPageContext());
        }
        this.fpO.setFrom("emotion_vote_follow");
        this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (EmotionPackageDetailActivity.this.fpO.getErrorCode() != 22) {
                    if (AntiHelper.bP(EmotionPackageDetailActivity.this.fpO.getErrorCode(), EmotionPackageDetailActivity.this.fpO.getErrorString())) {
                        AntiHelper.bs(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.fpO.getErrorString());
                    } else if (EmotionPackageDetailActivity.this.fpO.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.fpO.getErrorString());
                        EmotionPackageDetailActivity.this.showToast(EmotionPackageDetailActivity.this.fpO.getErrorString());
                    } else {
                        com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) obj;
                        if (wVar != null) {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.iSY.forum_name);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                        } else {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
                }
                EmotionPackageDetailActivity.this.iSQ.setEnabled(true);
                EmotionPackageDetailActivity.this.iTb.dismiss();
            }
        });
        this.fpO.gr(this.iSY.forum_name, String.valueOf(this.iSY.forum_id));
    }

    private void cBi() {
        if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iSZ >= 0) {
                if (this.iTd == null) {
                    this.iTd = new NewFaceGroupDownloadModel();
                }
                this.iSR.setEnabled(false);
                this.iTd.a(Integer.toString(this.iSZ), true, null);
            }
        }
    }

    private void cBj() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.iSY != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.iSY.name;
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.iSZ;
            shareItem.imageUri = Uri.parse(this.iSY.cover);
            this.iTf = shareItem.linkUrl;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public SwipeBackLayout cBk() {
        return this.mSwipeBackLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iTh != null) {
            this.iTh.cDd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSH != null) {
            this.iSH.cancelLoadData();
        }
        if (this.iTd != null) {
            this.iTd.cancelLoadData();
        }
        if (this.iTe != null) {
            this.iTe.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String[] split;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (!TextUtils.isEmpty(this.iTf) && this.iTf.contains("emoticonpackage") && (split = this.iTf.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                        String str = split[split.length - 1];
                        if (this.iTe == null) {
                            this.iTe = new NewFaceGroupShareModel();
                        }
                        this.iTe.Pg(str);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BaseAdapter {
        private List<EmotionPackageData.SingleEmotionData> dataList;
        int dmK;

        private a() {
            this.dataList = new ArrayList();
            this.dmK = (com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getActivity(), R.dimen.ds230)) / 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bs(List<EmotionPackageData.SingleEmotionData> list) {
            if (list != null) {
                this.dataList.clear();
                this.dataList.addAll(new ArrayList(list));
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = this.dataList.size() / 4;
            if (this.dataList.size() % 4 > 0) {
                return size + 1;
            }
            return size;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: zs */
        public List<EmotionPackageData.SingleEmotionData> getItem(int i) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.dataList.size() / 4; size < (this.dataList.size() / 4) + 4; size++) {
                if (size > 0 && size < this.dataList.size()) {
                    arrayList.add(this.dataList.get(size));
                }
            }
            return this.dataList;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0729a c0729a;
            if (view == null) {
                C0729a c0729a2 = new C0729a();
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                c0729a2.iTr = (TbImageView) view.findViewById(R.id.package_item_image1);
                ViewGroup.LayoutParams layoutParams = c0729a2.iTr.getLayoutParams();
                layoutParams.height = this.dmK;
                c0729a2.iTr.setLayoutParams(layoutParams);
                ao.setBackgroundColor(c0729a2.iTr, R.color.CAM_X0201);
                c0729a2.iTs = (TbImageView) view.findViewById(R.id.package_item_image2);
                ViewGroup.LayoutParams layoutParams2 = c0729a2.iTs.getLayoutParams();
                layoutParams2.height = this.dmK;
                c0729a2.iTs.setLayoutParams(layoutParams2);
                ao.setBackgroundColor(c0729a2.iTs, R.color.CAM_X0201);
                c0729a2.iTt = (TbImageView) view.findViewById(R.id.package_item_image3);
                ViewGroup.LayoutParams layoutParams3 = c0729a2.iTt.getLayoutParams();
                layoutParams3.height = this.dmK;
                c0729a2.iTt.setLayoutParams(layoutParams3);
                ao.setBackgroundColor(c0729a2.iTt, R.color.CAM_X0201);
                c0729a2.iTu = (TbImageView) view.findViewById(R.id.package_item_image4);
                ViewGroup.LayoutParams layoutParams4 = c0729a2.iTu.getLayoutParams();
                layoutParams4.height = this.dmK;
                c0729a2.iTu.setLayoutParams(layoutParams4);
                ao.setBackgroundColor(c0729a2.iTu, R.color.CAM_X0201);
                view.setTag(c0729a2);
                c0729a = c0729a2;
            } else {
                c0729a = (C0729a) view.getTag();
            }
            a(i, c0729a);
            return view;
        }

        private void a(int i, C0729a c0729a) {
            for (int i2 = 0; i2 < 4; i2++) {
                final TbImageView zt = c0729a.zt(i2);
                if (zt != null) {
                    final int i3 = (i * 4) + i2;
                    if (i3 >= this.dataList.size() || i3 < 0) {
                        zt.setVisibility(4);
                    } else {
                        zt.setVisibility(0);
                        zt.setTag(null);
                        zt.setDefaultResource(R.drawable.img_default_100);
                        zt.startLoad(this.dataList.get(i3).thumbnail, 10, false);
                        zt.invalidate();
                        zt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EmotionPackageData.SingleEmotionData singleEmotionData = (EmotionPackageData.SingleEmotionData) a.this.dataList.get(i3);
                                if (singleEmotionData != null && singleEmotionData.id >= 0 && EmotionPackageDetailActivity.this.iSZ >= 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.iSZ, singleEmotionData.id, zt.isGif());
                                    emotionDetailActivityConfig.setFromEmotionPackage(true);
                                    EmotionPackageDetailActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, emotionDetailActivityConfig));
                                }
                            }
                        });
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.tieba.faceshop.EmotionPackageDetailActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0729a {
            TbImageView iTr;
            TbImageView iTs;
            TbImageView iTt;
            TbImageView iTu;

            private C0729a() {
            }

            public TbImageView zt(int i) {
                switch (i) {
                    case 0:
                        return this.iTr;
                    case 1:
                        return this.iTs;
                    case 2:
                        return this.iTt;
                    case 3:
                        return this.iTu;
                    default:
                        return null;
                }
            }
        }
    }
}
