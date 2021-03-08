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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes8.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    private View dCC;
    private View dCT;
    private TextView eKp;
    private LikeModel foW;
    private NoNetworkView gCe;
    private HeadImageView gEO;
    private EmotionPackageDetailModel iVE;
    private PackageDetailListView iVF;
    private TbImageView iVG;
    private TextView iVH;
    private TextView iVI;
    private TextView iVJ;
    private TextView iVK;
    private a iVL;
    private View iVM;
    private View iVN;
    private View iVO;
    private TextView iVP;
    private TextView iVQ;
    private ImageView iVR;
    private TextView iVS;
    private View iVT;
    private View iVU;
    private EmotionPackageData iVV;
    private int iVW;
    private com.baidu.tbadk.core.dialog.a iVX;
    private com.baidu.tbadk.core.dialog.a iVY;
    private ImageView iVZ;
    private NewFaceGroupDownloadModel iWa;
    private NewFaceGroupShareModel iWb;
    private String iWc;
    private View iWd;
    private com.baidu.tieba.faceshop.packagedetail.b iWe;
    private int iWf;
    private View mHeaderView;
    private ImageView mLeftImg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mRootView;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    private final String iVD = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable() && EmotionPackageDetailActivity.this.iVE != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity.this.showLoadingView(EmotionPackageDetailActivity.this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.iVE.loadData(EmotionPackageDetailActivity.this.iVW);
            }
        }
    };
    final CustomMessageListener iWg = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921063 && EmotionPackageDetailActivity.this.iVV != null && EmotionPackageDetailActivity.this.iVP != null && EmotionPackageDetailActivity.this.iVO != null && EmotionPackageDetailActivity.this.iVJ != null) {
                ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.iVP.setText(R.string.already_downloaded);
                ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                EmotionPackageDetailActivity.this.iVV.download++;
                EmotionPackageDetailActivity.this.iVJ.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iVV.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iVV));
            }
        }
    };
    private com.baidu.adp.base.e iWh = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionPackageDetailActivity.this.hideLoadingView(EmotionPackageDetailActivity.this.mRootView);
            EmotionPackageDetailActivity.this.iVQ.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.iVM.setVisibility(0);
            EmotionPackageDetailActivity.this.iVF.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.iVV = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.iVL.bn(EmotionPackageDetailActivity.this.iVV.pics);
                EmotionPackageDetailActivity.this.iVG.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.iVV.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iWd.setVisibility(0);
                    EmotionPackageDetailActivity.this.gEO.startLoad(EmotionPackageDetailActivity.this.iVV.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.eKp.setText(EmotionPackageDetailActivity.this.iVV.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.gEO.startLoad(EmotionPackageDetailActivity.this.iVV.avatar, 10, false);
                    EmotionPackageDetailActivity.this.eKp.setText(EmotionPackageDetailActivity.this.iVV.author);
                }
                EmotionPackageDetailActivity.this.iVG.startLoad(EmotionPackageDetailActivity.this.iVV.cover, 10, false);
                EmotionPackageDetailActivity.this.iVH.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.iVV.num)));
                EmotionPackageDetailActivity.this.iVJ.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iVV.download)));
                EmotionPackageDetailActivity.this.iVK.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iVV.share)));
                EmotionPackageDetailActivity.this.iVI.setText(EmotionPackageDetailActivity.this.iVV.name);
                if (EmotionPackageDetailActivity.this.iVV.owner == null || !EmotionPackageDetailActivity.this.iVV.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.iVZ.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.iVZ.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.iVV.status == 4 || EmotionPackageDetailActivity.this.iVV.status == 2) {
                        EmotionPackageDetailActivity.this.iVZ.setEnabled(false);
                        SvgManager.bsU().a(EmotionPackageDetailActivity.this.iVZ, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                    } else {
                        EmotionPackageDetailActivity.this.iVZ.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.iVV.status == 5 && EmotionPackageDetailActivity.this.iVV.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iVN.setVisibility(0);
                    EmotionPackageDetailActivity.this.iVM.setVisibility(8);
                    EmotionPackageDetailActivity.this.iVJ.setVisibility(8);
                    EmotionPackageDetailActivity.this.iVK.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.gEO.getTop();
                    int bottom = (EmotionPackageDetailActivity.this.iVJ.getBottom() - EmotionPackageDetailActivity.this.iVI.getBottom()) + com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.gEO.getHeight();
                    EmotionPackageDetailActivity.this.gEO.setY(bottom);
                    EmotionPackageDetailActivity.this.eKp.setY(bottom);
                    if (EmotionPackageDetailActivity.this.iVV.owner == null || !EmotionPackageDetailActivity.this.iVV.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.iVQ.setVisibility(0);
                        EmotionPackageDetailActivity.this.iVQ.setText(EmotionPackageDetailActivity.this.JL(EmotionPackageDetailActivity.this.iVV.vote_num));
                        EmotionPackageDetailActivity.this.iVQ.setY(top);
                        if (EmotionPackageDetailActivity.this.iVV.has_vote == 1) {
                            EmotionPackageDetailActivity.this.cyN();
                        } else {
                            ap.setBackgroundColor(EmotionPackageDetailActivity.this.dCT, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.iVS.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.iVR.setVisibility(8);
                        EmotionPackageDetailActivity.this.iVZ.setVisibility(8);
                        EmotionPackageDetailActivity.this.iVQ.setVisibility(8);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iVS, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.iVN.setEnabled(false);
                    }
                }
                if (com.baidu.tieba.faceshop.a.cyB().JF("" + EmotionPackageDetailActivity.this.iVW)) {
                    EmotionPackageDetailActivity.this.iVP.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0109);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                    return;
                }
                switch (EmotionPackageDetailActivity.this.iVV.status) {
                    case 0:
                    case 3:
                        EmotionPackageDetailActivity.this.iVO.setVisibility(0);
                        EmotionPackageDetailActivity.this.iVP.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iVO.setEnabled(true);
                        return;
                    case 1:
                        EmotionPackageDetailActivity.this.iVO.setVisibility(0);
                        EmotionPackageDetailActivity.this.iVP.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iVO.setEnabled(true);
                        return;
                    case 2:
                        EmotionPackageDetailActivity.this.iVO.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0109);
                        SvgManager.bsU().a(EmotionPackageDetailActivity.this.iVZ, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iVP.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                        return;
                    case 4:
                        EmotionPackageDetailActivity.this.iVO.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0109);
                        SvgManager.bsU().a(EmotionPackageDetailActivity.this.iVZ, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iVP.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                        return;
                    default:
                        EmotionPackageDetailActivity.this.iVO.setVisibility(8);
                        return;
                }
            }
            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.iVM.setVisibility(8);
            EmotionPackageDetailActivity.this.iVF.setVisibility(8);
        }
    };
    private CustomMessageListener iWi = new CustomMessageListener(2921375) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.faceshop.packagedetail.a)) {
                com.baidu.tieba.faceshop.packagedetail.a aVar = (com.baidu.tieba.faceshop.packagedetail.a) customResponsedMessage.getData();
                if (aVar.resultCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iVP.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0109);
                    EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    EmotionPackageDetailActivity.this.iVV.download++;
                    EmotionPackageDetailActivity.this.iVJ.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iVV.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iVV));
                } else if (aVar.resultCode == 1) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionPackageDetailActivity.this.iVO.setEnabled(true);
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
        this.iVW = getIntent().getIntExtra("pck_id", -1);
        if (this.iVW < 0) {
            finish();
            return;
        }
        setContentView(R.layout.emotion_package_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iWg);
        registerListener(this.iWi);
        TiebaStatic.log("c12330");
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pA(R.string.no_face_detail_tip), null);
        ap.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageDetailActivity.this.finish();
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iVZ = new ImageView(getPageContext().getPageActivity());
        SvgManager.bsU().a(this.iVZ, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.iVZ.setPadding(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds31), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20));
        this.iVZ.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iVZ, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (EmotionPackageDetailActivity.this.iVX == null) {
                        EmotionPackageDetailActivity.this.iVX = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                        EmotionPackageDetailActivity.this.iVX.ny(R.string.package_delete_confirm_tip);
                        EmotionPackageDetailActivity.this.iVX.a(R.string.package_delete_positive_tip, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                EmotionPackageDetailActivity.this.cyM();
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iVX.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iVX.jF(true);
                        EmotionPackageDetailActivity.this.iVX.b(EmotionPackageDetailActivity.this.getPageContext());
                    }
                    EmotionPackageDetailActivity.this.iVX.bqz();
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
        this.iVF = (PackageDetailListView) findViewById(R.id.package_image_gridview);
        this.iVL = new a();
        this.mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
        this.iVF.addHeaderView(this.mHeaderView);
        this.iVG = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
        this.iWd = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
        this.dCC = this.mHeaderView.findViewById(R.id.divider_line);
        this.iVH = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
        this.iVI = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
        this.iVJ = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
        this.iVK = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
        this.iVQ = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
        this.gEO = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
        this.gEO.setIsRound(true);
        this.gEO.setOnClickListener(this);
        this.eKp = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
        this.eKp.setOnClickListener(this);
        this.iVF.setAdapter((ListAdapter) this.iVL);
        this.dCT = findViewById(R.id.above_controller_divider);
        this.iVM = findViewById(R.id.package_controller_layout);
        this.iVU = findViewById(R.id.controller_divider);
        this.iVO = findViewById(R.id.left_function_container);
        this.iVO.setOnClickListener(this);
        this.mLeftImg = (ImageView) findViewById(R.id.left_img);
        this.iVP = (TextView) findViewById(R.id.left_txt);
        this.iVT = findViewById(R.id.right_function_container);
        this.iVT.setOnClickListener(this);
        this.iVN = findViewById(R.id.package_vote_container);
        this.iVN.setOnClickListener(this);
        this.iVR = (ImageView) findViewById(R.id.vote_img);
        this.iVS = (TextView) findViewById(R.id.vote_text);
        this.iWe = new com.baidu.tieba.faceshop.packagedetail.b(this);
    }

    public PackageDetailListView cyL() {
        return this.iVF;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (view == this.iVO) {
                cyO();
            } else if (view == this.iVT) {
                cyP();
            } else if (view == this.gEO || view == this.eKp) {
                if (this.iVV != null && !TextUtils.isEmpty(this.iVV.owner)) {
                    if (this.iVV.forum_id > 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iVV.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iVV.owner, 0L), this.iVV.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            } else if (view == this.iVN) {
                xW(this.iVW);
            }
        }
    }

    private void initData() {
        if (this.iVE == null) {
            this.iVE = new EmotionPackageDetailModel();
        }
        this.iVE.setLoadDataCallBack(this.iWh);
        this.iVE.loadData(this.iVW);
        this.iWf = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JL(String str) {
        try {
            this.iWf = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xV(int i) {
        this.iWf = i;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.iVF, R.color.CAM_X0201);
        ap.setBackgroundColor(this.dCC, R.color.CAM_X0205);
        ap.setViewTextColor(this.iVJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVK, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVI, R.color.CAM_X0105);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0304);
        ap.setViewTextColor(this.iVQ, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVH, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.iVM, R.color.common_color_10311, i);
            ap.setBackgroundColor(this.iVN, R.color.CAM_X0201_1, i);
        } else {
            ap.setBackgroundColor(this.iVM, R.color.white_alpha100, i);
        }
        ap.setBackgroundColor(this.iVU, R.color.CAM_X0205);
        ap.setBackgroundColor(this.dCT, R.color.CAM_X0205);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.iWe != null) {
            this.iWe.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyM() {
        this.iVE.a(this.iVW, new EmotionPackageDetailModel.a() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.7
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.a
            public void onResult(boolean z) {
                if (z) {
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iVP, R.color.CAM_X0205);
                    EmotionPackageDetailActivity.this.iVP.setText(R.string.package_already_delete);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iVO.setEnabled(false);
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_success);
                    EmotionPackageDetailActivity.this.setResult(-1);
                    EmotionPackageDetailActivity.this.finish();
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_fail);
            }
        });
    }

    private void xW(int i) {
        this.iVN.setEnabled(false);
        this.iVE.a(i, new EmotionPackageDetailModel.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.b
            public void c(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS, EmotionPackageDetailActivity.this.iVV));
                        EmotionPackageDetailActivity.this.cyN();
                        if (EmotionPackageDetailActivity.this.iVQ != null && EmotionPackageDetailActivity.this.iVQ.isShown()) {
                            EmotionPackageDetailActivity.this.iVQ.setText(EmotionPackageDetailActivity.this.xV(EmotionPackageDetailActivity.this.iWf + 1));
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
                    } else if (httpResponsedMessage.getError() == 170003) {
                        if (EmotionPackageDetailActivity.this.iVY == null) {
                            EmotionPackageDetailActivity.this.iVY = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                            EmotionPackageDetailActivity.this.iVY.ny(R.string.package_cant_vote_tips);
                            EmotionPackageDetailActivity.this.iVY.b(R.string.package_cant_vote_negative, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    EmotionPackageDetailActivity.this.iVN.setEnabled(true);
                                }
                            });
                            EmotionPackageDetailActivity.this.iVY.a(R.string.package_cant_vote_positive, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (EmotionPackageDetailActivity.this.iVV != null && !TextUtils.isEmpty(EmotionPackageDetailActivity.this.iVV.forum_name)) {
                                        EmotionPackageDetailActivity.this.cyi();
                                    }
                                }
                            });
                            EmotionPackageDetailActivity.this.iVY.b(EmotionPackageDetailActivity.this.getPageContext());
                            EmotionPackageDetailActivity.this.iVY.jF(true);
                        }
                        EmotionPackageDetailActivity.this.iVY.bqz();
                    } else {
                        EmotionPackageDetailActivity.this.iVN.setEnabled(true);
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
    public void cyN() {
        this.iVS.setText(R.string.package_detail_voted);
        ap.setImageResource(this.iVR, R.drawable.icon_bar_voted);
        ap.setViewTextColor(this.iVS, R.color.CAM_X0109);
        this.iVN.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        if (this.foW == null) {
            this.foW = new LikeModel(getPageContext());
        }
        this.foW.setFrom("emotion_vote_follow");
        this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (EmotionPackageDetailActivity.this.foW.getErrorCode() != 22) {
                    if (AntiHelper.bX(EmotionPackageDetailActivity.this.foW.getErrorCode(), EmotionPackageDetailActivity.this.foW.getErrorString())) {
                        AntiHelper.bq(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.foW.getErrorString());
                    } else if (EmotionPackageDetailActivity.this.foW.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.foW.getErrorString());
                        EmotionPackageDetailActivity.this.showToast(EmotionPackageDetailActivity.this.foW.getErrorString());
                    } else {
                        com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) obj;
                        if (wVar != null) {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.iVV.forum_name);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                        } else {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
                }
                EmotionPackageDetailActivity.this.iVN.setEnabled(true);
                EmotionPackageDetailActivity.this.iVY.dismiss();
            }
        });
        this.foW.gy(this.iVV.forum_name, String.valueOf(this.iVV.forum_id));
    }

    private void cyO() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iVW >= 0) {
                if (this.iWa == null) {
                    this.iWa = new NewFaceGroupDownloadModel();
                }
                this.iVO.setEnabled(false);
                this.iWa.a(Integer.toString(this.iVW), true, null);
            }
        }
    }

    private void cyP() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.iVV != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.iVV.name;
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.iVW;
            shareItem.imageUri = Uri.parse(this.iVV.cover);
            this.iWc = shareItem.linkUrl;
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

    public SwipeBackLayout cyQ() {
        return this.mSwipeBackLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iWe != null) {
            this.iWe.cAJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVE != null) {
            this.iVE.cancelLoadData();
        }
        if (this.iWa != null) {
            this.iWa.cancelLoadData();
        }
        if (this.iWb != null) {
            this.iWb.cancelLoadData();
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
                    if (!TextUtils.isEmpty(this.iWc) && this.iWc.contains("emoticonpackage") && (split = this.iWc.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                        String str = split[split.length - 1];
                        if (this.iWb == null) {
                            this.iWb = new NewFaceGroupShareModel();
                        }
                        this.iWb.OV(str);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BaseAdapter {
        private List<EmotionPackageData.SingleEmotionData> dataList;
        int dlK;

        private a() {
            this.dataList = new ArrayList();
            this.dlK = (com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getActivity(), R.dimen.ds230)) / 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bn(List<EmotionPackageData.SingleEmotionData> list) {
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
        /* renamed from: xX */
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
            C0719a c0719a;
            if (view == null) {
                C0719a c0719a2 = new C0719a();
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                c0719a2.iWo = (TbImageView) view.findViewById(R.id.package_item_image1);
                ViewGroup.LayoutParams layoutParams = c0719a2.iWo.getLayoutParams();
                layoutParams.height = this.dlK;
                c0719a2.iWo.setLayoutParams(layoutParams);
                ap.setBackgroundColor(c0719a2.iWo, R.color.CAM_X0201);
                c0719a2.iWp = (TbImageView) view.findViewById(R.id.package_item_image2);
                ViewGroup.LayoutParams layoutParams2 = c0719a2.iWp.getLayoutParams();
                layoutParams2.height = this.dlK;
                c0719a2.iWp.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(c0719a2.iWp, R.color.CAM_X0201);
                c0719a2.iWq = (TbImageView) view.findViewById(R.id.package_item_image3);
                ViewGroup.LayoutParams layoutParams3 = c0719a2.iWq.getLayoutParams();
                layoutParams3.height = this.dlK;
                c0719a2.iWq.setLayoutParams(layoutParams3);
                ap.setBackgroundColor(c0719a2.iWq, R.color.CAM_X0201);
                c0719a2.iWr = (TbImageView) view.findViewById(R.id.package_item_image4);
                ViewGroup.LayoutParams layoutParams4 = c0719a2.iWr.getLayoutParams();
                layoutParams4.height = this.dlK;
                c0719a2.iWr.setLayoutParams(layoutParams4);
                ap.setBackgroundColor(c0719a2.iWr, R.color.CAM_X0201);
                view.setTag(c0719a2);
                c0719a = c0719a2;
            } else {
                c0719a = (C0719a) view.getTag();
            }
            a(i, c0719a);
            return view;
        }

        private void a(int i, C0719a c0719a) {
            for (int i2 = 0; i2 < 4; i2++) {
                final TbImageView xY = c0719a.xY(i2);
                if (xY != null) {
                    final int i3 = (i * 4) + i2;
                    if (i3 >= this.dataList.size() || i3 < 0) {
                        xY.setVisibility(4);
                    } else {
                        xY.setVisibility(0);
                        xY.setTag(null);
                        xY.setDefaultResource(R.drawable.img_default_100);
                        xY.startLoad(this.dataList.get(i3).thumbnail, 10, false);
                        xY.invalidate();
                        xY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EmotionPackageData.SingleEmotionData singleEmotionData = (EmotionPackageData.SingleEmotionData) a.this.dataList.get(i3);
                                if (singleEmotionData != null && singleEmotionData.id >= 0 && EmotionPackageDetailActivity.this.iVW >= 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.iVW, singleEmotionData.id, xY.isGif());
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
        /* loaded from: classes8.dex */
        public class C0719a {
            TbImageView iWo;
            TbImageView iWp;
            TbImageView iWq;
            TbImageView iWr;

            private C0719a() {
            }

            public TbImageView xY(int i) {
                switch (i) {
                    case 0:
                        return this.iWo;
                    case 1:
                        return this.iWp;
                    case 2:
                        return this.iWq;
                    case 3:
                        return this.iWr;
                    default:
                        return null;
                }
            }
        }
    }
}
