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
/* loaded from: classes8.dex */
public class EmotionPackageDetailActivity extends BaseActivity<EmotionPackageDetailActivity> {
    private View dyW;
    private View dzn;
    private TextView eGI;
    private LikeModel fle;
    private HeadImageView gAh;
    private NoNetworkView gxx;
    private com.baidu.tieba.faceshop.packagedetail.b iOA;
    private int iOB;
    private EmotionPackageDetailModel iOa;
    private PackageDetailListView iOb;
    private TbImageView iOc;
    private TextView iOd;
    private TextView iOe;
    private TextView iOf;
    private TextView iOg;
    private a iOh;
    private View iOi;
    private View iOj;
    private View iOk;
    private TextView iOl;
    private TextView iOm;
    private ImageView iOn;
    private TextView iOo;
    private View iOp;
    private View iOq;
    private EmotionPackageData iOr;
    private int iOs;
    private com.baidu.tbadk.core.dialog.a iOt;
    private com.baidu.tbadk.core.dialog.a iOu;
    private ImageView iOv;
    private NewFaceGroupDownloadModel iOw;
    private NewFaceGroupShareModel iOx;
    private String iOy;
    private View iOz;
    private View mHeaderView;
    private ImageView mLeftImg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mRootView;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    private final String iNZ = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable() && EmotionPackageDetailActivity.this.iOa != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity.this.showLoadingView(EmotionPackageDetailActivity.this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.iOa.loadData(EmotionPackageDetailActivity.this.iOs);
            }
        }
    };
    final CustomMessageListener iOC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921063 && EmotionPackageDetailActivity.this.iOr != null && EmotionPackageDetailActivity.this.iOl != null && EmotionPackageDetailActivity.this.iOk != null && EmotionPackageDetailActivity.this.iOf != null) {
                ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.iOl.setText(R.string.already_downloaded);
                ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                EmotionPackageDetailActivity.this.iOr.download++;
                EmotionPackageDetailActivity.this.iOf.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numberUniform(EmotionPackageDetailActivity.this.iOr.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iOr));
            }
        }
    };
    private com.baidu.adp.base.e iOD = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionPackageDetailActivity.this.hideLoadingView(EmotionPackageDetailActivity.this.mRootView);
            EmotionPackageDetailActivity.this.iOm.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.iOi.setVisibility(0);
            EmotionPackageDetailActivity.this.iOb.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.iOr = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.iOh.bs(EmotionPackageDetailActivity.this.iOr.pics);
                EmotionPackageDetailActivity.this.iOc.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.iOr.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iOz.setVisibility(0);
                    EmotionPackageDetailActivity.this.gAh.startLoad(EmotionPackageDetailActivity.this.iOr.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.eGI.setText(EmotionPackageDetailActivity.this.iOr.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.gAh.startLoad(EmotionPackageDetailActivity.this.iOr.avatar, 10, false);
                    EmotionPackageDetailActivity.this.eGI.setText(EmotionPackageDetailActivity.this.iOr.author);
                }
                EmotionPackageDetailActivity.this.iOc.startLoad(EmotionPackageDetailActivity.this.iOr.cover, 10, false);
                EmotionPackageDetailActivity.this.iOd.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.iOr.num)));
                EmotionPackageDetailActivity.this.iOf.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numFormatOverWan(EmotionPackageDetailActivity.this.iOr.download)));
                EmotionPackageDetailActivity.this.iOg.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), at.numFormatOverWan(EmotionPackageDetailActivity.this.iOr.share)));
                EmotionPackageDetailActivity.this.iOe.setText(EmotionPackageDetailActivity.this.iOr.name);
                if (EmotionPackageDetailActivity.this.iOr.owner == null || !EmotionPackageDetailActivity.this.iOr.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.iOv.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.iOv.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.iOr.status == 4 || EmotionPackageDetailActivity.this.iOr.status == 2) {
                        EmotionPackageDetailActivity.this.iOv.setEnabled(false);
                        SvgManager.bsx().a(EmotionPackageDetailActivity.this.iOv, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                    } else {
                        EmotionPackageDetailActivity.this.iOv.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.iOr.status == 5 && EmotionPackageDetailActivity.this.iOr.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iOj.setVisibility(0);
                    EmotionPackageDetailActivity.this.iOi.setVisibility(8);
                    EmotionPackageDetailActivity.this.iOf.setVisibility(8);
                    EmotionPackageDetailActivity.this.iOg.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.gAh.getTop();
                    int bottom = (EmotionPackageDetailActivity.this.iOf.getBottom() - EmotionPackageDetailActivity.this.iOe.getBottom()) + com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.gAh.getHeight();
                    EmotionPackageDetailActivity.this.gAh.setY(bottom);
                    EmotionPackageDetailActivity.this.eGI.setY(bottom);
                    if (EmotionPackageDetailActivity.this.iOr.owner == null || !EmotionPackageDetailActivity.this.iOr.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.iOm.setVisibility(0);
                        EmotionPackageDetailActivity.this.iOm.setText(EmotionPackageDetailActivity.this.IQ(EmotionPackageDetailActivity.this.iOr.vote_num));
                        EmotionPackageDetailActivity.this.iOm.setY(top);
                        if (EmotionPackageDetailActivity.this.iOr.has_vote == 1) {
                            EmotionPackageDetailActivity.this.cxp();
                        } else {
                            ao.setBackgroundColor(EmotionPackageDetailActivity.this.dzn, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.iOo.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.iOn.setVisibility(8);
                        EmotionPackageDetailActivity.this.iOv.setVisibility(8);
                        EmotionPackageDetailActivity.this.iOm.setVisibility(8);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iOo, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.iOj.setEnabled(false);
                    }
                }
                if (com.baidu.tieba.faceshop.a.cxd().IK("" + EmotionPackageDetailActivity.this.iOs)) {
                    EmotionPackageDetailActivity.this.iOl.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0109);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                    return;
                }
                switch (EmotionPackageDetailActivity.this.iOr.status) {
                    case 0:
                    case 3:
                        EmotionPackageDetailActivity.this.iOk.setVisibility(0);
                        EmotionPackageDetailActivity.this.iOl.setText(R.string.download);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0302);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iOk.setEnabled(true);
                        return;
                    case 1:
                        EmotionPackageDetailActivity.this.iOk.setVisibility(0);
                        EmotionPackageDetailActivity.this.iOl.setText(R.string.download);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0302);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iOk.setEnabled(true);
                        return;
                    case 2:
                        EmotionPackageDetailActivity.this.iOk.setVisibility(0);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0109);
                        SvgManager.bsx().a(EmotionPackageDetailActivity.this.iOv, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iOl.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                        return;
                    case 4:
                        EmotionPackageDetailActivity.this.iOk.setVisibility(0);
                        ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0109);
                        SvgManager.bsx().a(EmotionPackageDetailActivity.this.iOv, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iOl.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                        return;
                    default:
                        EmotionPackageDetailActivity.this.iOk.setVisibility(8);
                        return;
                }
            }
            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.iOi.setVisibility(8);
            EmotionPackageDetailActivity.this.iOb.setVisibility(8);
        }
    };
    private CustomMessageListener iOE = new CustomMessageListener(2921375) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.faceshop.packagedetail.a)) {
                com.baidu.tieba.faceshop.packagedetail.a aVar = (com.baidu.tieba.faceshop.packagedetail.a) customResponsedMessage.getData();
                if (aVar.resultCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iOl.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0109);
                    EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    EmotionPackageDetailActivity.this.iOr.download++;
                    EmotionPackageDetailActivity.this.iOf.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), at.numberUniform(EmotionPackageDetailActivity.this.iOr.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iOr));
                } else if (aVar.resultCode == 1) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionPackageDetailActivity.this.iOk.setEnabled(true);
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
        this.iOs = getIntent().getIntExtra("pck_id", -1);
        if (this.iOs < 0) {
            finish();
            return;
        }
        setContentView(R.layout.emotion_package_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iOC);
        registerListener(this.iOE);
        TiebaStatic.log("c12330");
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) findViewById(R.id.emotion_package_detail_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pu(R.string.no_face_detail_tip), null);
        ao.setViewTextColor(this.mNavigationBar.setCenterTextTitle(getString(R.string.package_detail_title)), R.color.CAM_X0105);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionPackageDetailActivity.this.finish();
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.iOv = new ImageView(getPageContext().getPageActivity());
        SvgManager.bsx().a(this.iOv, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.iOv.setPadding(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds31), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20));
        this.iOv.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iOv, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (EmotionPackageDetailActivity.this.iOt == null) {
                        EmotionPackageDetailActivity.this.iOt = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                        EmotionPackageDetailActivity.this.iOt.nu(R.string.package_delete_confirm_tip);
                        EmotionPackageDetailActivity.this.iOt.a(R.string.package_delete_positive_tip, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                EmotionPackageDetailActivity.this.cxo();
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iOt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iOt.jD(true);
                        EmotionPackageDetailActivity.this.iOt.b(EmotionPackageDetailActivity.this.getPageContext());
                    }
                    EmotionPackageDetailActivity.this.iOt.bqe();
                }
            }
        });
        this.gxx = (NoNetworkView) findViewById(R.id.no_network_view);
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.gxx.setVisibility(8);
        } else {
            this.gxx.setVisibility(0);
        }
        this.gxx.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iOb = (PackageDetailListView) findViewById(R.id.package_image_gridview);
        this.iOh = new a();
        this.mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
        this.iOb.addHeaderView(this.mHeaderView);
        this.iOc = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
        this.iOz = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
        this.dyW = this.mHeaderView.findViewById(R.id.divider_line);
        this.iOd = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
        this.iOe = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
        this.iOf = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
        this.iOg = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
        this.iOm = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
        this.gAh = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
        this.gAh.setIsRound(true);
        this.gAh.setOnClickListener(this);
        this.eGI = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
        this.eGI.setOnClickListener(this);
        this.iOb.setAdapter((ListAdapter) this.iOh);
        this.dzn = findViewById(R.id.above_controller_divider);
        this.iOi = findViewById(R.id.package_controller_layout);
        this.iOq = findViewById(R.id.controller_divider);
        this.iOk = findViewById(R.id.left_function_container);
        this.iOk.setOnClickListener(this);
        this.mLeftImg = (ImageView) findViewById(R.id.left_img);
        this.iOl = (TextView) findViewById(R.id.left_txt);
        this.iOp = findViewById(R.id.right_function_container);
        this.iOp.setOnClickListener(this);
        this.iOj = findViewById(R.id.package_vote_container);
        this.iOj.setOnClickListener(this);
        this.iOn = (ImageView) findViewById(R.id.vote_img);
        this.iOo = (TextView) findViewById(R.id.vote_text);
        this.iOA = new com.baidu.tieba.faceshop.packagedetail.b(this);
    }

    public PackageDetailListView cxn() {
        return this.iOb;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (view == this.iOk) {
                cxq();
            } else if (view == this.iOp) {
                cxr();
            } else if (view == this.gAh || view == this.eGI) {
                if (this.iOr != null && !TextUtils.isEmpty(this.iOr.owner)) {
                    if (this.iOr.forum_id > 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iOr.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iOr.owner, 0L), this.iOr.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            } else if (view == this.iOj) {
                xL(this.iOs);
            }
        }
    }

    private void initData() {
        if (this.iOa == null) {
            this.iOa = new EmotionPackageDetailModel();
        }
        this.iOa.setLoadDataCallBack(this.iOD);
        this.iOa.loadData(this.iOs);
        this.iOB = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String IQ(String str) {
        try {
            this.iOB = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xK(int i) {
        this.iOB = i;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRootView);
        ao.setBackgroundColor(this.iOb, R.color.CAM_X0201);
        ao.setBackgroundColor(this.dyW, R.color.CAM_X0205);
        ao.setViewTextColor(this.iOf, R.color.CAM_X0109);
        ao.setViewTextColor(this.iOg, R.color.CAM_X0109);
        ao.setViewTextColor(this.iOe, R.color.CAM_X0105);
        ao.setViewTextColor(this.eGI, R.color.CAM_X0304);
        ao.setViewTextColor(this.iOm, R.color.CAM_X0109);
        ao.setViewTextColor(this.iOd, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            ao.setBackgroundColor(this.iOi, R.color.common_color_10311, i);
            ao.setBackgroundColor(this.iOj, R.color.CAM_X0201_1, i);
        } else {
            ao.setBackgroundColor(this.iOi, R.color.white_alpha100, i);
        }
        ao.setBackgroundColor(this.iOq, R.color.CAM_X0205);
        ao.setBackgroundColor(this.dzn, R.color.CAM_X0205);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.iOA != null) {
            this.iOA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxo() {
        this.iOa.a(this.iOs, new EmotionPackageDetailModel.a() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.7
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.a
            public void onResult(boolean z) {
                if (z) {
                    ao.setViewTextColor(EmotionPackageDetailActivity.this.iOl, R.color.CAM_X0205);
                    EmotionPackageDetailActivity.this.iOl.setText(R.string.package_already_delete);
                    ao.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iOk.setEnabled(false);
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_success);
                    EmotionPackageDetailActivity.this.setResult(-1);
                    EmotionPackageDetailActivity.this.finish();
                    return;
                }
                com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.delete_fail);
            }
        });
    }

    private void xL(int i) {
        this.iOj.setEnabled(false);
        this.iOa.a(i, new EmotionPackageDetailModel.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.b
            public void c(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS, EmotionPackageDetailActivity.this.iOr));
                        EmotionPackageDetailActivity.this.cxp();
                        if (EmotionPackageDetailActivity.this.iOm != null && EmotionPackageDetailActivity.this.iOm.isShown()) {
                            EmotionPackageDetailActivity.this.iOm.setText(EmotionPackageDetailActivity.this.xK(EmotionPackageDetailActivity.this.iOB + 1));
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
                    } else if (httpResponsedMessage.getError() == 170003) {
                        if (EmotionPackageDetailActivity.this.iOu == null) {
                            EmotionPackageDetailActivity.this.iOu = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                            EmotionPackageDetailActivity.this.iOu.nu(R.string.package_cant_vote_tips);
                            EmotionPackageDetailActivity.this.iOu.b(R.string.package_cant_vote_negative, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    EmotionPackageDetailActivity.this.iOj.setEnabled(true);
                                }
                            });
                            EmotionPackageDetailActivity.this.iOu.a(R.string.package_cant_vote_positive, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (EmotionPackageDetailActivity.this.iOr != null && !TextUtils.isEmpty(EmotionPackageDetailActivity.this.iOr.forum_name)) {
                                        EmotionPackageDetailActivity.this.cwJ();
                                    }
                                }
                            });
                            EmotionPackageDetailActivity.this.iOu.b(EmotionPackageDetailActivity.this.getPageContext());
                            EmotionPackageDetailActivity.this.iOu.jD(true);
                        }
                        EmotionPackageDetailActivity.this.iOu.bqe();
                    } else {
                        EmotionPackageDetailActivity.this.iOj.setEnabled(true);
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
    public void cxp() {
        this.iOo.setText(R.string.package_detail_voted);
        ao.setImageResource(this.iOn, R.drawable.icon_bar_voted);
        ao.setViewTextColor(this.iOo, R.color.CAM_X0109);
        this.iOj.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwJ() {
        if (this.fle == null) {
            this.fle = new LikeModel(getPageContext());
        }
        this.fle.setFrom("emotion_vote_follow");
        this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (EmotionPackageDetailActivity.this.fle.getErrorCode() != 22) {
                    if (AntiHelper.bQ(EmotionPackageDetailActivity.this.fle.getErrorCode(), EmotionPackageDetailActivity.this.fle.getErrorString())) {
                        AntiHelper.bs(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.fle.getErrorString());
                    } else if (EmotionPackageDetailActivity.this.fle.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.fle.getErrorString());
                        EmotionPackageDetailActivity.this.showToast(EmotionPackageDetailActivity.this.fle.getErrorString());
                    } else {
                        com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) obj;
                        if (wVar != null) {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.iOr.forum_name);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                        } else {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
                }
                EmotionPackageDetailActivity.this.iOj.setEnabled(true);
                EmotionPackageDetailActivity.this.iOu.dismiss();
            }
        });
        this.fle.gq(this.iOr.forum_name, String.valueOf(this.iOr.forum_id));
    }

    private void cxq() {
        if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iOs >= 0) {
                if (this.iOw == null) {
                    this.iOw = new NewFaceGroupDownloadModel();
                }
                this.iOk.setEnabled(false);
                this.iOw.a(Integer.toString(this.iOs), true, null);
            }
        }
    }

    private void cxr() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.iOr != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.iOr.name;
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.iOs;
            shareItem.imageUri = Uri.parse(this.iOr.cover);
            this.iOy = shareItem.linkUrl;
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

    public SwipeBackLayout cxs() {
        return this.mSwipeBackLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iOA != null) {
            this.iOA.czl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iOa != null) {
            this.iOa.cancelLoadData();
        }
        if (this.iOw != null) {
            this.iOw.cancelLoadData();
        }
        if (this.iOx != null) {
            this.iOx.cancelLoadData();
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
                    if (!TextUtils.isEmpty(this.iOy) && this.iOy.contains("emoticonpackage") && (split = this.iOy.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                        String str = split[split.length - 1];
                        if (this.iOx == null) {
                            this.iOx = new NewFaceGroupShareModel();
                        }
                        this.iOx.NZ(str);
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
        int dhV;

        private a() {
            this.dataList = new ArrayList();
            this.dhV = (com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getActivity(), R.dimen.ds230)) / 4;
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
        /* renamed from: xM */
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
                c0712a2.iOK = (TbImageView) view.findViewById(R.id.package_item_image1);
                ViewGroup.LayoutParams layoutParams = c0712a2.iOK.getLayoutParams();
                layoutParams.height = this.dhV;
                c0712a2.iOK.setLayoutParams(layoutParams);
                ao.setBackgroundColor(c0712a2.iOK, R.color.CAM_X0201);
                c0712a2.iOL = (TbImageView) view.findViewById(R.id.package_item_image2);
                ViewGroup.LayoutParams layoutParams2 = c0712a2.iOL.getLayoutParams();
                layoutParams2.height = this.dhV;
                c0712a2.iOL.setLayoutParams(layoutParams2);
                ao.setBackgroundColor(c0712a2.iOL, R.color.CAM_X0201);
                c0712a2.iOM = (TbImageView) view.findViewById(R.id.package_item_image3);
                ViewGroup.LayoutParams layoutParams3 = c0712a2.iOM.getLayoutParams();
                layoutParams3.height = this.dhV;
                c0712a2.iOM.setLayoutParams(layoutParams3);
                ao.setBackgroundColor(c0712a2.iOM, R.color.CAM_X0201);
                c0712a2.iON = (TbImageView) view.findViewById(R.id.package_item_image4);
                ViewGroup.LayoutParams layoutParams4 = c0712a2.iON.getLayoutParams();
                layoutParams4.height = this.dhV;
                c0712a2.iON.setLayoutParams(layoutParams4);
                ao.setBackgroundColor(c0712a2.iON, R.color.CAM_X0201);
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
                final TbImageView xN = c0712a.xN(i2);
                if (xN != null) {
                    final int i3 = (i * 4) + i2;
                    if (i3 >= this.dataList.size() || i3 < 0) {
                        xN.setVisibility(4);
                    } else {
                        xN.setVisibility(0);
                        xN.setTag(null);
                        xN.setDefaultResource(R.drawable.img_default_100);
                        xN.startLoad(this.dataList.get(i3).thumbnail, 10, false);
                        xN.invalidate();
                        xN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EmotionPackageData.SingleEmotionData singleEmotionData = (EmotionPackageData.SingleEmotionData) a.this.dataList.get(i3);
                                if (singleEmotionData != null && singleEmotionData.id >= 0 && EmotionPackageDetailActivity.this.iOs >= 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.iOs, singleEmotionData.id, xN.isGif());
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
        public class C0712a {
            TbImageView iOK;
            TbImageView iOL;
            TbImageView iOM;
            TbImageView iON;

            private C0712a() {
            }

            public TbImageView xN(int i) {
                switch (i) {
                    case 0:
                        return this.iOK;
                    case 1:
                        return this.iOL;
                    case 2:
                        return this.iOM;
                    case 3:
                        return this.iON;
                    default:
                        return null;
                }
            }
        }
    }
}
