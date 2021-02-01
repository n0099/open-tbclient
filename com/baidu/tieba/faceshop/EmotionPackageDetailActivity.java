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
/* loaded from: classes9.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    private View dBb;
    private View dBs;
    private TextView eIO;
    private LikeModel fnw;
    private NoNetworkView gAh;
    private HeadImageView gCR;
    private EmotionPackageDetailModel iTH;
    private PackageDetailListView iTI;
    private TbImageView iTJ;
    private TextView iTK;
    private TextView iTL;
    private TextView iTM;
    private TextView iTN;
    private a iTO;
    private View iTP;
    private View iTQ;
    private View iTR;
    private TextView iTS;
    private TextView iTT;
    private ImageView iTU;
    private TextView iTV;
    private View iTW;
    private View iTX;
    private EmotionPackageData iTY;
    private int iTZ;
    private com.baidu.tbadk.core.dialog.a iUa;
    private com.baidu.tbadk.core.dialog.a iUb;
    private ImageView iUc;
    private NewFaceGroupDownloadModel iUd;
    private NewFaceGroupShareModel iUe;
    private String iUf;
    private View iUg;
    private com.baidu.tieba.faceshop.packagedetail.b iUh;
    private int iUi;
    private View mHeaderView;
    private ImageView mLeftImg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mRootView;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    private final String iTG = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable() && EmotionPackageDetailActivity.this.iTH != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity.this.showLoadingView(EmotionPackageDetailActivity.this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.iTH.loadData(EmotionPackageDetailActivity.this.iTZ);
            }
        }
    };
    final CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921063 && EmotionPackageDetailActivity.this.iTY != null && EmotionPackageDetailActivity.this.iTS != null && EmotionPackageDetailActivity.this.iTR != null && EmotionPackageDetailActivity.this.iTM != null) {
                ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.iTS.setText(R.string.already_downloaded);
                ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                EmotionPackageDetailActivity.this.iTY.download++;
                EmotionPackageDetailActivity.this.iTM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iTY.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iTY));
            }
        }
    };
    private com.baidu.adp.base.e iUk = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionPackageDetailActivity.this.hideLoadingView(EmotionPackageDetailActivity.this.mRootView);
            EmotionPackageDetailActivity.this.iTT.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.iTP.setVisibility(0);
            EmotionPackageDetailActivity.this.iTI.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.iTY = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.iTO.bn(EmotionPackageDetailActivity.this.iTY.pics);
                EmotionPackageDetailActivity.this.iTJ.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.iTY.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iUg.setVisibility(0);
                    EmotionPackageDetailActivity.this.gCR.startLoad(EmotionPackageDetailActivity.this.iTY.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.eIO.setText(EmotionPackageDetailActivity.this.iTY.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.gCR.startLoad(EmotionPackageDetailActivity.this.iTY.avatar, 10, false);
                    EmotionPackageDetailActivity.this.eIO.setText(EmotionPackageDetailActivity.this.iTY.author);
                }
                EmotionPackageDetailActivity.this.iTJ.startLoad(EmotionPackageDetailActivity.this.iTY.cover, 10, false);
                EmotionPackageDetailActivity.this.iTK.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.iTY.num)));
                EmotionPackageDetailActivity.this.iTM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iTY.download)));
                EmotionPackageDetailActivity.this.iTN.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iTY.share)));
                EmotionPackageDetailActivity.this.iTL.setText(EmotionPackageDetailActivity.this.iTY.name);
                if (EmotionPackageDetailActivity.this.iTY.owner == null || !EmotionPackageDetailActivity.this.iTY.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.iUc.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.iUc.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.iTY.status == 4 || EmotionPackageDetailActivity.this.iTY.status == 2) {
                        EmotionPackageDetailActivity.this.iUc.setEnabled(false);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                    } else {
                        EmotionPackageDetailActivity.this.iUc.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.iTY.status == 5 && EmotionPackageDetailActivity.this.iTY.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iTQ.setVisibility(0);
                    EmotionPackageDetailActivity.this.iTP.setVisibility(8);
                    EmotionPackageDetailActivity.this.iTM.setVisibility(8);
                    EmotionPackageDetailActivity.this.iTN.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.gCR.getTop();
                    int bottom = (EmotionPackageDetailActivity.this.iTM.getBottom() - EmotionPackageDetailActivity.this.iTL.getBottom()) + com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.gCR.getHeight();
                    EmotionPackageDetailActivity.this.gCR.setY(bottom);
                    EmotionPackageDetailActivity.this.eIO.setY(bottom);
                    if (EmotionPackageDetailActivity.this.iTY.owner == null || !EmotionPackageDetailActivity.this.iTY.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.iTT.setVisibility(0);
                        EmotionPackageDetailActivity.this.iTT.setText(EmotionPackageDetailActivity.this.JB(EmotionPackageDetailActivity.this.iTY.vote_num));
                        EmotionPackageDetailActivity.this.iTT.setY(top);
                        if (EmotionPackageDetailActivity.this.iTY.has_vote == 1) {
                            EmotionPackageDetailActivity.this.cyA();
                        } else {
                            ap.setBackgroundColor(EmotionPackageDetailActivity.this.dBs, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.iTV.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.iTU.setVisibility(8);
                        EmotionPackageDetailActivity.this.iUc.setVisibility(8);
                        EmotionPackageDetailActivity.this.iTT.setVisibility(8);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iTV, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.iTQ.setEnabled(false);
                    }
                }
                if (com.baidu.tieba.faceshop.a.cyo().Jv("" + EmotionPackageDetailActivity.this.iTZ)) {
                    EmotionPackageDetailActivity.this.iTS.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0109);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                    return;
                }
                switch (EmotionPackageDetailActivity.this.iTY.status) {
                    case 0:
                    case 3:
                        EmotionPackageDetailActivity.this.iTR.setVisibility(0);
                        EmotionPackageDetailActivity.this.iTS.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iTR.setEnabled(true);
                        return;
                    case 1:
                        EmotionPackageDetailActivity.this.iTR.setVisibility(0);
                        EmotionPackageDetailActivity.this.iTS.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iTR.setEnabled(true);
                        return;
                    case 2:
                        EmotionPackageDetailActivity.this.iTR.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0109);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iTS.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                        return;
                    case 4:
                        EmotionPackageDetailActivity.this.iTR.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0109);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iTS.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                        return;
                    default:
                        EmotionPackageDetailActivity.this.iTR.setVisibility(8);
                        return;
                }
            }
            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.iTP.setVisibility(8);
            EmotionPackageDetailActivity.this.iTI.setVisibility(8);
        }
    };
    private CustomMessageListener iUl = new CustomMessageListener(2921375) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.faceshop.packagedetail.a)) {
                com.baidu.tieba.faceshop.packagedetail.a aVar = (com.baidu.tieba.faceshop.packagedetail.a) customResponsedMessage.getData();
                if (aVar.resultCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iTS.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0109);
                    EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    EmotionPackageDetailActivity.this.iTY.download++;
                    EmotionPackageDetailActivity.this.iTM.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iTY.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iTY));
                } else if (aVar.resultCode == 1) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionPackageDetailActivity.this.iTR.setEnabled(true);
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
        this.iTZ = getIntent().getIntExtra("pck_id", -1);
        if (this.iTZ < 0) {
            finish();
            return;
        }
        setContentView(R.layout.emotion_package_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iUj);
        registerListener(this.iUl);
        TiebaStatic.log("c12330");
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pz(R.string.no_face_detail_tip), null);
        ap.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageDetailActivity.this.finish();
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iUc = new ImageView(getPageContext().getPageActivity());
        SvgManager.bsR().a(this.iUc, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.iUc.setPadding(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds31), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20));
        this.iUc.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUc, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (EmotionPackageDetailActivity.this.iUa == null) {
                        EmotionPackageDetailActivity.this.iUa = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                        EmotionPackageDetailActivity.this.iUa.nx(R.string.package_delete_confirm_tip);
                        EmotionPackageDetailActivity.this.iUa.a(R.string.package_delete_positive_tip, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                EmotionPackageDetailActivity.this.cyz();
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iUa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iUa.jF(true);
                        EmotionPackageDetailActivity.this.iUa.b(EmotionPackageDetailActivity.this.getPageContext());
                    }
                    EmotionPackageDetailActivity.this.iUa.bqx();
                }
            }
        });
        this.gAh = (NoNetworkView) findViewById(R.id.no_network_view);
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.gAh.setVisibility(8);
        } else {
            this.gAh.setVisibility(0);
        }
        this.gAh.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iTI = (PackageDetailListView) findViewById(R.id.package_image_gridview);
        this.iTO = new a();
        this.mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
        this.iTI.addHeaderView(this.mHeaderView);
        this.iTJ = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
        this.iUg = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
        this.dBb = this.mHeaderView.findViewById(R.id.divider_line);
        this.iTK = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
        this.iTL = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
        this.iTM = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
        this.iTN = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
        this.iTT = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
        this.gCR = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
        this.gCR.setIsRound(true);
        this.gCR.setOnClickListener(this);
        this.eIO = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
        this.eIO.setOnClickListener(this);
        this.iTI.setAdapter((ListAdapter) this.iTO);
        this.dBs = findViewById(R.id.above_controller_divider);
        this.iTP = findViewById(R.id.package_controller_layout);
        this.iTX = findViewById(R.id.controller_divider);
        this.iTR = findViewById(R.id.left_function_container);
        this.iTR.setOnClickListener(this);
        this.mLeftImg = (ImageView) findViewById(R.id.left_img);
        this.iTS = (TextView) findViewById(R.id.left_txt);
        this.iTW = findViewById(R.id.right_function_container);
        this.iTW.setOnClickListener(this);
        this.iTQ = findViewById(R.id.package_vote_container);
        this.iTQ.setOnClickListener(this);
        this.iTU = (ImageView) findViewById(R.id.vote_img);
        this.iTV = (TextView) findViewById(R.id.vote_text);
        this.iUh = new com.baidu.tieba.faceshop.packagedetail.b(this);
    }

    public PackageDetailListView cyy() {
        return this.iTI;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (view == this.iTR) {
                cyB();
            } else if (view == this.iTW) {
                cyC();
            } else if (view == this.gCR || view == this.eIO) {
                if (this.iTY != null && !TextUtils.isEmpty(this.iTY.owner)) {
                    if (this.iTY.forum_id > 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iTY.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iTY.owner, 0L), this.iTY.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            } else if (view == this.iTQ) {
                xV(this.iTZ);
            }
        }
    }

    private void initData() {
        if (this.iTH == null) {
            this.iTH = new EmotionPackageDetailModel();
        }
        this.iTH.setLoadDataCallBack(this.iUk);
        this.iTH.loadData(this.iTZ);
        this.iUi = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JB(String str) {
        try {
            this.iUi = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xU(int i) {
        this.iUi = i;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.iTI, R.color.CAM_X0201);
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0205);
        ap.setViewTextColor(this.iTM, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTN, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTL, R.color.CAM_X0105);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0304);
        ap.setViewTextColor(this.iTT, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTK, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.iTP, R.color.common_color_10311, i);
            ap.setBackgroundColor(this.iTQ, R.color.CAM_X0201_1, i);
        } else {
            ap.setBackgroundColor(this.iTP, R.color.white_alpha100, i);
        }
        ap.setBackgroundColor(this.iTX, R.color.CAM_X0205);
        ap.setBackgroundColor(this.dBs, R.color.CAM_X0205);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.iUh != null) {
            this.iUh.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyz() {
        this.iTH.a(this.iTZ, new EmotionPackageDetailModel.a() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.7
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.a
            public void onResult(boolean z) {
                if (z) {
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iTS, R.color.CAM_X0205);
                    EmotionPackageDetailActivity.this.iTS.setText(R.string.package_already_delete);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iTR.setEnabled(false);
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_success);
                    EmotionPackageDetailActivity.this.setResult(-1);
                    EmotionPackageDetailActivity.this.finish();
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_fail);
            }
        });
    }

    private void xV(int i) {
        this.iTQ.setEnabled(false);
        this.iTH.a(i, new EmotionPackageDetailModel.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.b
            public void c(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS, EmotionPackageDetailActivity.this.iTY));
                        EmotionPackageDetailActivity.this.cyA();
                        if (EmotionPackageDetailActivity.this.iTT != null && EmotionPackageDetailActivity.this.iTT.isShown()) {
                            EmotionPackageDetailActivity.this.iTT.setText(EmotionPackageDetailActivity.this.xU(EmotionPackageDetailActivity.this.iUi + 1));
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
                    } else if (httpResponsedMessage.getError() == 170003) {
                        if (EmotionPackageDetailActivity.this.iUb == null) {
                            EmotionPackageDetailActivity.this.iUb = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                            EmotionPackageDetailActivity.this.iUb.nx(R.string.package_cant_vote_tips);
                            EmotionPackageDetailActivity.this.iUb.b(R.string.package_cant_vote_negative, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    EmotionPackageDetailActivity.this.iTQ.setEnabled(true);
                                }
                            });
                            EmotionPackageDetailActivity.this.iUb.a(R.string.package_cant_vote_positive, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (EmotionPackageDetailActivity.this.iTY != null && !TextUtils.isEmpty(EmotionPackageDetailActivity.this.iTY.forum_name)) {
                                        EmotionPackageDetailActivity.this.cxV();
                                    }
                                }
                            });
                            EmotionPackageDetailActivity.this.iUb.b(EmotionPackageDetailActivity.this.getPageContext());
                            EmotionPackageDetailActivity.this.iUb.jF(true);
                        }
                        EmotionPackageDetailActivity.this.iUb.bqx();
                    } else {
                        EmotionPackageDetailActivity.this.iTQ.setEnabled(true);
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
    public void cyA() {
        this.iTV.setText(R.string.package_detail_voted);
        ap.setImageResource(this.iTU, R.drawable.icon_bar_voted);
        ap.setViewTextColor(this.iTV, R.color.CAM_X0109);
        this.iTQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (this.fnw == null) {
            this.fnw = new LikeModel(getPageContext());
        }
        this.fnw.setFrom("emotion_vote_follow");
        this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (EmotionPackageDetailActivity.this.fnw.getErrorCode() != 22) {
                    if (AntiHelper.bX(EmotionPackageDetailActivity.this.fnw.getErrorCode(), EmotionPackageDetailActivity.this.fnw.getErrorString())) {
                        AntiHelper.br(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.fnw.getErrorString());
                    } else if (EmotionPackageDetailActivity.this.fnw.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.fnw.getErrorString());
                        EmotionPackageDetailActivity.this.showToast(EmotionPackageDetailActivity.this.fnw.getErrorString());
                    } else {
                        com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) obj;
                        if (wVar != null) {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.iTY.forum_name);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                        } else {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
                }
                EmotionPackageDetailActivity.this.iTQ.setEnabled(true);
                EmotionPackageDetailActivity.this.iUb.dismiss();
            }
        });
        this.fnw.gw(this.iTY.forum_name, String.valueOf(this.iTY.forum_id));
    }

    private void cyB() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iTZ >= 0) {
                if (this.iUd == null) {
                    this.iUd = new NewFaceGroupDownloadModel();
                }
                this.iTR.setEnabled(false);
                this.iUd.a(Integer.toString(this.iTZ), true, null);
            }
        }
    }

    private void cyC() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.iTY != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.iTY.name;
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.iTZ;
            shareItem.imageUri = Uri.parse(this.iTY.cover);
            this.iUf = shareItem.linkUrl;
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

    public SwipeBackLayout cyD() {
        return this.mSwipeBackLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iUh != null) {
            this.iUh.cAw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTH != null) {
            this.iTH.cancelLoadData();
        }
        if (this.iUd != null) {
            this.iUd.cancelLoadData();
        }
        if (this.iUe != null) {
            this.iUe.cancelLoadData();
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
                    if (!TextUtils.isEmpty(this.iUf) && this.iUf.contains("emoticonpackage") && (split = this.iUf.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                        String str = split[split.length - 1];
                        if (this.iUe == null) {
                            this.iUe = new NewFaceGroupShareModel();
                        }
                        this.iUe.OO(str);
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
        int dkj;

        private a() {
            this.dataList = new ArrayList();
            this.dkj = (com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getActivity(), R.dimen.ds230)) / 4;
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
        /* renamed from: xW */
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
            C0712a c0712a;
            if (view == null) {
                C0712a c0712a2 = new C0712a();
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                c0712a2.iUr = (TbImageView) view.findViewById(R.id.package_item_image1);
                ViewGroup.LayoutParams layoutParams = c0712a2.iUr.getLayoutParams();
                layoutParams.height = this.dkj;
                c0712a2.iUr.setLayoutParams(layoutParams);
                ap.setBackgroundColor(c0712a2.iUr, R.color.CAM_X0201);
                c0712a2.iUs = (TbImageView) view.findViewById(R.id.package_item_image2);
                ViewGroup.LayoutParams layoutParams2 = c0712a2.iUs.getLayoutParams();
                layoutParams2.height = this.dkj;
                c0712a2.iUs.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(c0712a2.iUs, R.color.CAM_X0201);
                c0712a2.iUt = (TbImageView) view.findViewById(R.id.package_item_image3);
                ViewGroup.LayoutParams layoutParams3 = c0712a2.iUt.getLayoutParams();
                layoutParams3.height = this.dkj;
                c0712a2.iUt.setLayoutParams(layoutParams3);
                ap.setBackgroundColor(c0712a2.iUt, R.color.CAM_X0201);
                c0712a2.iUu = (TbImageView) view.findViewById(R.id.package_item_image4);
                ViewGroup.LayoutParams layoutParams4 = c0712a2.iUu.getLayoutParams();
                layoutParams4.height = this.dkj;
                c0712a2.iUu.setLayoutParams(layoutParams4);
                ap.setBackgroundColor(c0712a2.iUu, R.color.CAM_X0201);
                view.setTag(c0712a2);
                c0712a = c0712a2;
            } else {
                c0712a = (C0712a) view.getTag();
            }
            a(i, c0712a);
            return view;
        }

        private void a(int i, C0712a c0712a) {
            for (int i2 = 0; i2 < 4; i2++) {
                final TbImageView xX = c0712a.xX(i2);
                if (xX != null) {
                    final int i3 = (i * 4) + i2;
                    if (i3 >= this.dataList.size() || i3 < 0) {
                        xX.setVisibility(4);
                    } else {
                        xX.setVisibility(0);
                        xX.setTag(null);
                        xX.setDefaultResource(R.drawable.img_default_100);
                        xX.startLoad(this.dataList.get(i3).thumbnail, 10, false);
                        xX.invalidate();
                        xX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EmotionPackageData.SingleEmotionData singleEmotionData = (EmotionPackageData.SingleEmotionData) a.this.dataList.get(i3);
                                if (singleEmotionData != null && singleEmotionData.id >= 0 && EmotionPackageDetailActivity.this.iTZ >= 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.iTZ, singleEmotionData.id, xX.isGif());
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
        public class C0712a {
            TbImageView iUr;
            TbImageView iUs;
            TbImageView iUt;
            TbImageView iUu;

            private C0712a() {
            }

            public TbImageView xX(int i) {
                switch (i) {
                    case 0:
                        return this.iUr;
                    case 1:
                        return this.iUs;
                    case 2:
                        return this.iUt;
                    case 3:
                        return this.iUu;
                    default:
                        return null;
                }
            }
        }
    }
}
