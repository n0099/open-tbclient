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
    private NoNetworkView gAv;
    private HeadImageView gDf;
    private EmotionPackageDetailModel iTV;
    private PackageDetailListView iTW;
    private TbImageView iTX;
    private TextView iTY;
    private TextView iTZ;
    private TextView iUa;
    private TextView iUb;
    private a iUc;
    private View iUd;
    private View iUe;
    private View iUf;
    private TextView iUg;
    private TextView iUh;
    private ImageView iUi;
    private TextView iUj;
    private View iUk;
    private View iUl;
    private EmotionPackageData iUm;
    private int iUn;
    private com.baidu.tbadk.core.dialog.a iUo;
    private com.baidu.tbadk.core.dialog.a iUp;
    private ImageView iUq;
    private NewFaceGroupDownloadModel iUr;
    private NewFaceGroupShareModel iUs;
    private String iUt;
    private View iUu;
    private com.baidu.tieba.faceshop.packagedetail.b iUv;
    private int iUw;
    private View mHeaderView;
    private ImageView mLeftImg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private RelativeLayout mRootView;
    private final String SHARE_URL = "http://tieba.baidu.com/n/interact/emoticonpackage/";
    private final String iTU = "http://tieba.baidu.com/n/interact/emoticon/";
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.j.isNetWorkAvailable() && EmotionPackageDetailActivity.this.iTV != null && EmotionPackageDetailActivity.this.mNoDataView != null && EmotionPackageDetailActivity.this.mNoDataView.getVisibility() == 0) {
                EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
                EmotionPackageDetailActivity.this.showLoadingView(EmotionPackageDetailActivity.this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this, R.dimen.ds400));
                EmotionPackageDetailActivity.this.iTV.loadData(EmotionPackageDetailActivity.this.iUn);
            }
        }
    };
    final CustomMessageListener iUx = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_EMOTION_PACKAGE_DETAIL) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921063 && EmotionPackageDetailActivity.this.iUm != null && EmotionPackageDetailActivity.this.iUg != null && EmotionPackageDetailActivity.this.iUf != null && EmotionPackageDetailActivity.this.iUa != null) {
                ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                EmotionPackageDetailActivity.this.iUg.setText(R.string.already_downloaded);
                ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0109);
                EmotionPackageDetailActivity.this.iUf.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                EmotionPackageDetailActivity.this.iUm.download++;
                EmotionPackageDetailActivity.this.iUa.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iUm.download)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iUm));
            }
        }
    };
    private com.baidu.adp.base.e iUy = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.6
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            EmotionPackageDetailActivity.this.hideLoadingView(EmotionPackageDetailActivity.this.mRootView);
            EmotionPackageDetailActivity.this.iUh.setVisibility(8);
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(8);
            EmotionPackageDetailActivity.this.iUd.setVisibility(0);
            EmotionPackageDetailActivity.this.iTW.setVisibility(0);
            if (obj != null && (obj instanceof EmotionPackageData)) {
                EmotionPackageDetailActivity.this.iUm = (EmotionPackageData) obj;
                EmotionPackageDetailActivity.this.iUc.bn(EmotionPackageDetailActivity.this.iUm.pics);
                EmotionPackageDetailActivity.this.iTX.setGifIconSupport(false);
                if (EmotionPackageDetailActivity.this.iUm.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iUu.setVisibility(0);
                    EmotionPackageDetailActivity.this.gDf.startLoad(EmotionPackageDetailActivity.this.iUm.forum_avatar, 10, false);
                    EmotionPackageDetailActivity.this.eIO.setText(EmotionPackageDetailActivity.this.iUm.forum_name);
                } else {
                    EmotionPackageDetailActivity.this.gDf.startLoad(EmotionPackageDetailActivity.this.iUm.avatar, 10, false);
                    EmotionPackageDetailActivity.this.eIO.setText(EmotionPackageDetailActivity.this.iUm.author);
                }
                EmotionPackageDetailActivity.this.iTX.startLoad(EmotionPackageDetailActivity.this.iUm.cover, 10, false);
                EmotionPackageDetailActivity.this.iTY.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_num), Integer.valueOf(EmotionPackageDetailActivity.this.iUm.num)));
                EmotionPackageDetailActivity.this.iUa.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iUm.download)));
                EmotionPackageDetailActivity.this.iUb.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_share_num), au.numFormatOverWan(EmotionPackageDetailActivity.this.iUm.share)));
                EmotionPackageDetailActivity.this.iTZ.setText(EmotionPackageDetailActivity.this.iUm.name);
                if (EmotionPackageDetailActivity.this.iUm.owner == null || !EmotionPackageDetailActivity.this.iUm.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                    EmotionPackageDetailActivity.this.iUq.setVisibility(8);
                } else {
                    EmotionPackageDetailActivity.this.iUq.setVisibility(0);
                    if (EmotionPackageDetailActivity.this.iUm.status == 4 || EmotionPackageDetailActivity.this.iUm.status == 2) {
                        EmotionPackageDetailActivity.this.iUq.setEnabled(false);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUq, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                    } else {
                        EmotionPackageDetailActivity.this.iUq.setEnabled(true);
                    }
                }
                if (EmotionPackageDetailActivity.this.iUm.status == 5 && EmotionPackageDetailActivity.this.iUm.forum_id > 0) {
                    EmotionPackageDetailActivity.this.iUe.setVisibility(0);
                    EmotionPackageDetailActivity.this.iUd.setVisibility(8);
                    EmotionPackageDetailActivity.this.iUa.setVisibility(8);
                    EmotionPackageDetailActivity.this.iUb.setVisibility(8);
                    int top = EmotionPackageDetailActivity.this.gDf.getTop();
                    int bottom = (EmotionPackageDetailActivity.this.iUa.getBottom() - EmotionPackageDetailActivity.this.iTZ.getBottom()) + com.baidu.adp.lib.util.l.getDimens(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), R.dimen.ds32) + EmotionPackageDetailActivity.this.gDf.getHeight();
                    EmotionPackageDetailActivity.this.gDf.setY(bottom);
                    EmotionPackageDetailActivity.this.eIO.setY(bottom);
                    if (EmotionPackageDetailActivity.this.iUm.owner == null || !EmotionPackageDetailActivity.this.iUm.owner.equals(TbadkCoreApplication.getCurrentAccount())) {
                        EmotionPackageDetailActivity.this.iUh.setVisibility(0);
                        EmotionPackageDetailActivity.this.iUh.setText(EmotionPackageDetailActivity.this.JC(EmotionPackageDetailActivity.this.iUm.vote_num));
                        EmotionPackageDetailActivity.this.iUh.setY(top);
                        if (EmotionPackageDetailActivity.this.iUm.has_vote == 1) {
                            EmotionPackageDetailActivity.this.cyH();
                        } else {
                            ap.setBackgroundColor(EmotionPackageDetailActivity.this.dBs, R.color.CAM_X0204);
                        }
                    } else {
                        EmotionPackageDetailActivity.this.iUj.setText(R.string.package_detail_hits);
                        EmotionPackageDetailActivity.this.iUi.setVisibility(8);
                        EmotionPackageDetailActivity.this.iUq.setVisibility(8);
                        EmotionPackageDetailActivity.this.iUh.setVisibility(8);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iUj, R.color.CAM_X0109);
                        EmotionPackageDetailActivity.this.iUe.setEnabled(false);
                    }
                }
                if (com.baidu.tieba.faceshop.a.cyv().Jw("" + EmotionPackageDetailActivity.this.iUn)) {
                    EmotionPackageDetailActivity.this.iUg.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0109);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iUf.setEnabled(false);
                    return;
                }
                switch (EmotionPackageDetailActivity.this.iUm.status) {
                    case 0:
                    case 3:
                        EmotionPackageDetailActivity.this.iUf.setVisibility(0);
                        EmotionPackageDetailActivity.this.iUg.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iUf.setEnabled(true);
                        return;
                    case 1:
                        EmotionPackageDetailActivity.this.iUf.setVisibility(0);
                        EmotionPackageDetailActivity.this.iUg.setText(R.string.download);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0302);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_download);
                        EmotionPackageDetailActivity.this.iUf.setEnabled(true);
                        return;
                    case 2:
                        EmotionPackageDetailActivity.this.iUf.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0109);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUq, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iUg.setText(R.string.face_package_not_ok);
                        EmotionPackageDetailActivity.this.iUf.setEnabled(false);
                        return;
                    case 4:
                        EmotionPackageDetailActivity.this.iUf.setVisibility(0);
                        ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_illegal_off);
                        ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0109);
                        SvgManager.bsR().a(EmotionPackageDetailActivity.this.iUq, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
                        EmotionPackageDetailActivity.this.iUg.setText(R.string.face_package_has_delete);
                        EmotionPackageDetailActivity.this.iUf.setEnabled(false);
                        return;
                    default:
                        EmotionPackageDetailActivity.this.iUf.setVisibility(8);
                        return;
                }
            }
            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.getResources().getString(R.string.package_detail_load_failed));
            EmotionPackageDetailActivity.this.mNoDataView.setVisibility(0);
            EmotionPackageDetailActivity.this.iUd.setVisibility(8);
            EmotionPackageDetailActivity.this.iTW.setVisibility(8);
        }
    };
    private CustomMessageListener iUz = new CustomMessageListener(2921375) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.faceshop.packagedetail.a)) {
                com.baidu.tieba.faceshop.packagedetail.a aVar = (com.baidu.tieba.faceshop.packagedetail.a) customResponsedMessage.getData();
                if (aVar.resultCode == 0) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.down_state_success);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iUg.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0109);
                    EmotionPackageDetailActivity.this.iUf.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    EmotionPackageDetailActivity.this.iUm.download++;
                    EmotionPackageDetailActivity.this.iUa.setText(String.format(EmotionPackageDetailActivity.this.getString(R.string.package_detail_download_num), au.numberUniform(EmotionPackageDetailActivity.this.iUm.download)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER, EmotionPackageDetailActivity.this.iUm));
                } else if (aVar.resultCode == 1) {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.download_error);
                    EmotionPackageDetailActivity.this.iUf.setEnabled(true);
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
        this.iUn = getIntent().getIntExtra("pck_id", -1);
        if (this.iUn < 0) {
            finish();
            return;
        }
        setContentView(R.layout.emotion_package_detail_activity);
        initUI();
        showLoadingView(this.mRootView, false, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds400));
        initData();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iUx);
        registerListener(this.iUz);
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
        this.iUq = new ImageView(getPageContext().getPageActivity());
        SvgManager.bsR().a(this.iUq, R.drawable.icon_pure_topbar_delete44_svg, R.color.white_alpha100, (SvgManager.SvgResourceStateType) null);
        this.iUq.setPadding(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds31), com.baidu.adp.lib.util.l.getDimens(this, R.dimen.ds20));
        this.iUq.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iUq, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (EmotionPackageDetailActivity.this.iUo == null) {
                        EmotionPackageDetailActivity.this.iUo = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                        EmotionPackageDetailActivity.this.iUo.nx(R.string.package_delete_confirm_tip);
                        EmotionPackageDetailActivity.this.iUo.a(R.string.package_delete_positive_tip, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                EmotionPackageDetailActivity.this.cyG();
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iUo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.5.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        EmotionPackageDetailActivity.this.iUo.jF(true);
                        EmotionPackageDetailActivity.this.iUo.b(EmotionPackageDetailActivity.this.getPageContext());
                    }
                    EmotionPackageDetailActivity.this.iUo.bqx();
                }
            }
        });
        this.gAv = (NoNetworkView) findViewById(R.id.no_network_view);
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.gAv.setVisibility(8);
        } else {
            this.gAv.setVisibility(0);
        }
        this.gAv.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iTW = (PackageDetailListView) findViewById(R.id.package_image_gridview);
        this.iUc = new a();
        this.mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.emotion_package_info, (ViewGroup) null);
        this.iTW.addHeaderView(this.mHeaderView);
        this.iTX = (TbImageView) this.mHeaderView.findViewById(R.id.emotion_package_cover);
        this.iUu = this.mHeaderView.findViewById(R.id.emotion_package_single_bar_icon);
        this.dBb = this.mHeaderView.findViewById(R.id.divider_line);
        this.iTY = (TextView) this.mHeaderView.findViewById(R.id.emotion_count);
        this.iTZ = (TextView) this.mHeaderView.findViewById(R.id.emotion_package_name);
        this.iUa = (TextView) this.mHeaderView.findViewById(R.id.package_donwload_num);
        this.iUb = (TextView) this.mHeaderView.findViewById(R.id.package_share_num);
        this.iUh = (TextView) this.mHeaderView.findViewById(R.id.emotion_detail_owner_and_vote_num);
        this.gDf = (HeadImageView) this.mHeaderView.findViewById(R.id.package_author_avatar);
        this.gDf.setIsRound(true);
        this.gDf.setOnClickListener(this);
        this.eIO = (TextView) this.mHeaderView.findViewById(R.id.package_author_name);
        this.eIO.setOnClickListener(this);
        this.iTW.setAdapter((ListAdapter) this.iUc);
        this.dBs = findViewById(R.id.above_controller_divider);
        this.iUd = findViewById(R.id.package_controller_layout);
        this.iUl = findViewById(R.id.controller_divider);
        this.iUf = findViewById(R.id.left_function_container);
        this.iUf.setOnClickListener(this);
        this.mLeftImg = (ImageView) findViewById(R.id.left_img);
        this.iUg = (TextView) findViewById(R.id.left_txt);
        this.iUk = findViewById(R.id.right_function_container);
        this.iUk.setOnClickListener(this);
        this.iUe = findViewById(R.id.package_vote_container);
        this.iUe.setOnClickListener(this);
        this.iUi = (ImageView) findViewById(R.id.vote_img);
        this.iUj = (TextView) findViewById(R.id.vote_text);
        this.iUv = new com.baidu.tieba.faceshop.packagedetail.b(this);
    }

    public PackageDetailListView cyF() {
        return this.iTW;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (view == this.iUf) {
                cyI();
            } else if (view == this.iUk) {
                cyJ();
            } else if (view == this.gDf || view == this.eIO) {
                if (this.iUm != null && !TextUtils.isEmpty(this.iUm.owner)) {
                    if (this.iUm.forum_id > 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iUm.forum_name, null)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iUm.owner, 0L), this.iUm.owner.equals(TbadkCoreApplication.getCurrentAccount()), false)));
                }
            } else if (view == this.iUe) {
                xV(this.iUn);
            }
        }
    }

    private void initData() {
        if (this.iTV == null) {
            this.iTV = new EmotionPackageDetailModel();
        }
        this.iTV.setLoadDataCallBack(this.iUy);
        this.iTV.loadData(this.iUn);
        this.iUw = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JC(String str) {
        try {
            this.iUw = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format(getResources().getString(R.string.emotion_vote_message), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xU(int i) {
        this.iUw = i;
        return String.format(getResources().getString(R.string.emotion_vote_message), String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.iTW, R.color.CAM_X0201);
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0205);
        ap.setViewTextColor(this.iUa, R.color.CAM_X0109);
        ap.setViewTextColor(this.iUb, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0304);
        ap.setViewTextColor(this.iUh, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTY, R.color.CAM_X0109);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.iUd, R.color.common_color_10311, i);
            ap.setBackgroundColor(this.iUe, R.color.CAM_X0201_1, i);
        } else {
            ap.setBackgroundColor(this.iUd, R.color.white_alpha100, i);
        }
        ap.setBackgroundColor(this.iUl, R.color.CAM_X0205);
        ap.setBackgroundColor(this.dBs, R.color.CAM_X0205);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.iUv != null) {
            this.iUv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        this.iTV.a(this.iUn, new EmotionPackageDetailModel.a() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.7
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.a
            public void onResult(boolean z) {
                if (z) {
                    ap.setViewTextColor(EmotionPackageDetailActivity.this.iUg, R.color.CAM_X0205);
                    EmotionPackageDetailActivity.this.iUg.setText(R.string.package_already_delete);
                    ap.setImageResource(EmotionPackageDetailActivity.this.mLeftImg, R.drawable.icon_bar_downloaded);
                    EmotionPackageDetailActivity.this.iUf.setEnabled(false);
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
        this.iUe.setEnabled(false);
        this.iTV.a(i, new EmotionPackageDetailModel.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8
            @Override // com.baidu.tieba.faceshop.EmotionPackageDetailModel.b
            public void c(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS, EmotionPackageDetailActivity.this.iUm));
                        EmotionPackageDetailActivity.this.cyH();
                        if (EmotionPackageDetailActivity.this.iUh != null && EmotionPackageDetailActivity.this.iUh.isShown()) {
                            EmotionPackageDetailActivity.this.iUh.setText(EmotionPackageDetailActivity.this.xU(EmotionPackageDetailActivity.this.iUw + 1));
                        }
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.package_vote_success);
                    } else if (httpResponsedMessage.getError() == 170003) {
                        if (EmotionPackageDetailActivity.this.iUp == null) {
                            EmotionPackageDetailActivity.this.iUp = new com.baidu.tbadk.core.dialog.a(EmotionPackageDetailActivity.this.getPageContext().getPageActivity());
                            EmotionPackageDetailActivity.this.iUp.nx(R.string.package_cant_vote_tips);
                            EmotionPackageDetailActivity.this.iUp.b(R.string.package_cant_vote_negative, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    EmotionPackageDetailActivity.this.iUe.setEnabled(true);
                                }
                            });
                            EmotionPackageDetailActivity.this.iUp.a(R.string.package_cant_vote_positive, new a.b() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.8.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (EmotionPackageDetailActivity.this.iUm != null && !TextUtils.isEmpty(EmotionPackageDetailActivity.this.iUm.forum_name)) {
                                        EmotionPackageDetailActivity.this.cyc();
                                    }
                                }
                            });
                            EmotionPackageDetailActivity.this.iUp.b(EmotionPackageDetailActivity.this.getPageContext());
                            EmotionPackageDetailActivity.this.iUp.jF(true);
                        }
                        EmotionPackageDetailActivity.this.iUp.bqx();
                    } else {
                        EmotionPackageDetailActivity.this.iUe.setEnabled(true);
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
    public void cyH() {
        this.iUj.setText(R.string.package_detail_voted);
        ap.setImageResource(this.iUi, R.drawable.icon_bar_voted);
        ap.setViewTextColor(this.iUj, R.color.CAM_X0109);
        this.iUe.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyc() {
        if (this.fnw == null) {
            this.fnw = new LikeModel(getPageContext());
        }
        this.fnw.setFrom("emotion_vote_follow");
        this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (EmotionPackageDetailActivity.this.fnw.getErrorCode() != 22) {
                    if (AntiHelper.bX(EmotionPackageDetailActivity.this.fnw.getErrorCode(), EmotionPackageDetailActivity.this.fnw.getErrorString())) {
                        AntiHelper.bq(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.fnw.getErrorString());
                    } else if (EmotionPackageDetailActivity.this.fnw.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), EmotionPackageDetailActivity.this.fnw.getErrorString());
                        EmotionPackageDetailActivity.this.showToast(EmotionPackageDetailActivity.this.fnw.getErrorString());
                    } else {
                        com.baidu.tieba.tbadkCore.w wVar = (com.baidu.tieba.tbadkCore.w) obj;
                        if (wVar != null) {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.attention_success);
                            TbadkApplication.getInst().addLikeForum(EmotionPackageDetailActivity.this.iUm.forum_name);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                        } else {
                            com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.neterror);
                        }
                    }
                } else {
                    com.baidu.adp.lib.util.l.showToast(EmotionPackageDetailActivity.this.getActivity(), R.string.had_liked_forum);
                }
                EmotionPackageDetailActivity.this.iUe.setEnabled(true);
                EmotionPackageDetailActivity.this.iUp.dismiss();
            }
        });
        this.fnw.gy(this.iUm.forum_name, String.valueOf(this.iUm.forum_id));
    }

    private void cyI() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.iUn >= 0) {
                if (this.iUr == null) {
                    this.iUr = new NewFaceGroupDownloadModel();
                }
                this.iUf.setEnabled(false);
                this.iUr.a(Integer.toString(this.iUn), true, null);
            }
        }
    }

    private void cyJ() {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        if (this.iUm != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.iUm.name;
            shareItem.content = getString(R.string.package_share_content);
            shareItem.linkUrl = "http://tieba.baidu.com/n/interact/emoticonpackage/" + this.iUn;
            shareItem.imageUri = Uri.parse(this.iUm.cover);
            this.iUt = shareItem.linkUrl;
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

    public SwipeBackLayout cyK() {
        return this.mSwipeBackLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iUv != null) {
            this.iUv.cAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTV != null) {
            this.iTV.cancelLoadData();
        }
        if (this.iUr != null) {
            this.iUr.cancelLoadData();
        }
        if (this.iUs != null) {
            this.iUs.cancelLoadData();
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
                    if (!TextUtils.isEmpty(this.iUt) && this.iUt.contains("emoticonpackage") && (split = this.iUt.split("/")) != null && split.length > 0 && intent.getIntExtra("extra_share_status", 2) == 1) {
                        String str = split[split.length - 1];
                        if (this.iUs == null) {
                            this.iUs = new NewFaceGroupShareModel();
                        }
                        this.iUs.OP(str);
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
            C0713a c0713a;
            if (view == null) {
                C0713a c0713a2 = new C0713a();
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.package_detail_item, viewGroup, false);
                c0713a2.iUF = (TbImageView) view.findViewById(R.id.package_item_image1);
                ViewGroup.LayoutParams layoutParams = c0713a2.iUF.getLayoutParams();
                layoutParams.height = this.dkj;
                c0713a2.iUF.setLayoutParams(layoutParams);
                ap.setBackgroundColor(c0713a2.iUF, R.color.CAM_X0201);
                c0713a2.iUG = (TbImageView) view.findViewById(R.id.package_item_image2);
                ViewGroup.LayoutParams layoutParams2 = c0713a2.iUG.getLayoutParams();
                layoutParams2.height = this.dkj;
                c0713a2.iUG.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(c0713a2.iUG, R.color.CAM_X0201);
                c0713a2.iUH = (TbImageView) view.findViewById(R.id.package_item_image3);
                ViewGroup.LayoutParams layoutParams3 = c0713a2.iUH.getLayoutParams();
                layoutParams3.height = this.dkj;
                c0713a2.iUH.setLayoutParams(layoutParams3);
                ap.setBackgroundColor(c0713a2.iUH, R.color.CAM_X0201);
                c0713a2.iUI = (TbImageView) view.findViewById(R.id.package_item_image4);
                ViewGroup.LayoutParams layoutParams4 = c0713a2.iUI.getLayoutParams();
                layoutParams4.height = this.dkj;
                c0713a2.iUI.setLayoutParams(layoutParams4);
                ap.setBackgroundColor(c0713a2.iUI, R.color.CAM_X0201);
                view.setTag(c0713a2);
                c0713a = c0713a2;
            } else {
                c0713a = (C0713a) view.getTag();
            }
            a(i, c0713a);
            return view;
        }

        private void a(int i, C0713a c0713a) {
            for (int i2 = 0; i2 < 4; i2++) {
                final TbImageView xX = c0713a.xX(i2);
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
                                if (singleEmotionData != null && singleEmotionData.id >= 0 && EmotionPackageDetailActivity.this.iUn >= 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    EmotionDetailActivityConfig emotionDetailActivityConfig = new EmotionDetailActivityConfig(EmotionPackageDetailActivity.this.getPageContext().getPageActivity(), EmotionPackageDetailActivity.this.iUn, singleEmotionData.id, xX.isGif());
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
        public class C0713a {
            TbImageView iUF;
            TbImageView iUG;
            TbImageView iUH;
            TbImageView iUI;

            private C0713a() {
            }

            public TbImageView xX(int i) {
                switch (i) {
                    case 0:
                        return this.iUF;
                    case 1:
                        return this.iUG;
                    case 2:
                        return this.iUH;
                    case 3:
                        return this.iUI;
                    default:
                        return null;
                }
            }
        }
    }
}
