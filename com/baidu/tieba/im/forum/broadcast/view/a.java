package com.baidu.tieba.im.forum.broadcast.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.b;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private PbListView gCf;
    private boolean hasMore;
    private String jxF;
    private String jxG;
    private final com.baidu.tieba.im.forum.broadcast.a kIc;
    private BdRecyclerView kIh;
    private FroumBroadMajorHistoryAdapter kIi;
    private ImageView kIk;
    private LinearLayout kIl;
    private TextView kIm;
    private TextView kIn;
    private RelativeLayout kIo;
    private boolean kIp;
    private ScreenTopToast kIq;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kIj = new ArrayList();
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kIh != null) {
                a.this.kIh.stopScroll();
            }
            a.this.Xa();
        }
    };
    private f<b> kIr = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.jxF).v("tid", bVar.cWp() != null ? bVar.cWp().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.kIp) {
                            a.this.cWt();
                            return;
                        }
                        p pVar = new p(a.this.mPageContext.getPageActivity());
                        pVar.b(bVar.cWn() + "", a.this.jxG, a.this.jxF, bVar.cWp() != null ? bVar.cWp().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        pVar.start();
                    }
                } else if (bVar.cWp() == null || bVar.cWp().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).zm(false).Vg(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aR((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cWp().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kIs = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cWu();
        }
    };
    private View.OnClickListener kIt = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                p pVar = new p(a.this.mPageContext.getPageActivity());
                pVar.ap(a.this.jxF, a.this.jxG, "2");
                pVar.start();
                TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kIu = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cWt();
            }
        }
    };
    private View.OnClickListener iRh = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kIh != null) {
                a.this.kIh.stopScroll();
            }
            if (a.this.gCf != null && a.this.kIc != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.kIc.bRp();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kIc = aVar;
        this.jxF = str;
        this.jxG = str2;
        i(view, str3);
        TiebaStatic.log(new ar("c13872").v("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cWt() {
        if (this.kIq == null || !this.kIq.isShow()) {
            this.kIq = new ScreenTopToast(this.mPageContext.getPageActivity()).Vl(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Vn(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ao(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jxF);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kIq.aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kIo = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kIk = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kIl = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kIl.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.kIk, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kIn = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kIk.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kIn.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kIk.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kIn.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kIk.setLayoutParams(layoutParams2);
        this.kIk.setVisibility(0);
        this.kIk.setOnClickListener(this.kIs);
        this.kIh = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kIh.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kIh.setOverScrollMode(2);
        this.kIh.setOnSrollToBottomListener(this.gXO);
        ap.setBackgroundColor(this.kIh, R.color.CAM_X0204);
        this.kIi = new FroumBroadMajorHistoryAdapter(this.mPageContext.getPageActivity());
        this.kIi.a(this.kIr);
        this.kIh.setAdapter(this.kIi);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bug();
        this.gCf.setOnClickListener(this.iRh);
        if ("broadcast_publish_success".equals(str)) {
            cWv();
            int size = com.baidu.adp.base.b.kB().getSize();
            Activity aa = com.baidu.adp.base.b.kB().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.b.kB().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void Xa() {
        if (this.gCf != null && this.kIc != null) {
            if (j.isNetWorkAvailable()) {
                this.kIh.setNextPage(this.gCf);
                this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gCf.setOnClickListener(null);
                if (this.hasMore) {
                    this.gCf.showLoading();
                    this.kIc.bRp();
                    return;
                }
                this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gCf.endLoadData();
                return;
            }
            this.kIh.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cWh() != null) {
            if (!y.isEmpty(aVar.cWh()) && StringUtils.isEmpty(this.jxF)) {
                b bVar = aVar.cWh().get(0);
                if (bVar.cWo() != null) {
                    this.jxF = bVar.cWo().forum_id + "";
                }
            }
            this.hasMore = aVar.cWg();
            if (aVar.bJN()) {
                if (!y.isEmpty(aVar.cWh())) {
                    this.kIj.clear();
                    this.kIj.addAll(aVar.cWh());
                }
            } else if (!y.isEmpty(aVar.cWh())) {
                this.kIj.addAll(aVar.cWh());
            }
            this.kIi.ey(this.kIj);
            if (aVar.bJN() && this.kIh != null && this.kIh.getChildCount() > 0) {
                this.kIh.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kIm == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kIm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kIt);
                ap.a((View) this.kIm, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cWq() >= forumBroadcastMajorResidueData.cWr()) {
                this.kIp = true;
                this.kIm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kIu);
                ap.a((View) this.kIm, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.kIm.setAlpha(0.33f);
            } else {
                this.kIm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kIt);
                ap.a((View) this.kIm, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.kIh, R.color.CAM_X0204);
        this.gCf.changeSkin(i);
        this.kIi.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kIc != null) {
                            a.this.Xc();
                            a.this.kIc.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kIo, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kIo);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWu() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nB(2);
        aVar.jG(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bn(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bqz();
    }

    public void cWv() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).zm(true).Vg(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kIj = null;
        this.kIq = null;
    }
}
