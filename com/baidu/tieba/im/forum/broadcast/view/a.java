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
/* loaded from: classes8.dex */
public class a {
    private PbListView gAw;
    private boolean hasMore;
    private String jvW;
    private String jvX;
    private final com.baidu.tieba.im.forum.broadcast.a kGa;
    private BdRecyclerView kGf;
    private FroumBroadMajorHistoryAdapter kGg;
    private ImageView kGi;
    private LinearLayout kGj;
    private TextView kGk;
    private TextView kGl;
    private RelativeLayout kGm;
    private boolean kGn;
    private ScreenTopToast kGo;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kGh = new ArrayList();
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kGf != null) {
                a.this.kGf.stopScroll();
            }
            a.this.WX();
        }
    };
    private f<b> kGp = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.jvW).v("tid", bVar.cWi() != null ? bVar.cWi().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.kGn) {
                            a.this.cWm();
                            return;
                        }
                        p pVar = new p(a.this.mPageContext.getPageActivity());
                        pVar.b(bVar.cWg() + "", a.this.jvX, a.this.jvW, bVar.cWi() != null ? bVar.cWi().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        pVar.start();
                    }
                } else if (bVar.cWi() == null || bVar.cWi().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).zn(false).UZ(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aR((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cWi().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kGq = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cWn();
        }
    };
    private View.OnClickListener kGr = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                p pVar = new p(a.this.mPageContext.getPageActivity());
                pVar.ap(a.this.jvW, a.this.jvX, "2");
                pVar.start();
                TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kGs = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cWm();
            }
        }
    };
    private View.OnClickListener iPy = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kGf != null) {
                a.this.kGf.stopScroll();
            }
            if (a.this.gAw != null && a.this.kGa != null && j.isNetWorkAvailable()) {
                a.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAw.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAw.showLoading();
                    a.this.kGa.bRj();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kGa = aVar;
        this.jvW = str;
        this.jvX = str2;
        i(view, str3);
        TiebaStatic.log(new ar("c13872").v("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cWm() {
        if (this.kGo == null || !this.kGo.isShow()) {
            this.kGo = new ScreenTopToast(this.mPageContext.getPageActivity()).Ve(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Vg(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jvW);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kGo.aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kGm = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kGi = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kGj = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kGj.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.kGi, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kGl = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kGi.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kGi.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kGl.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kGi.setLayoutParams(layoutParams2);
        this.kGi.setVisibility(0);
        this.kGi.setOnClickListener(this.kGq);
        this.kGf = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kGf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kGf.setOverScrollMode(2);
        this.kGf.setOnSrollToBottomListener(this.gWf);
        ap.setBackgroundColor(this.kGf, R.color.CAM_X0204);
        this.kGg = new FroumBroadMajorHistoryAdapter(this.mPageContext.getPageActivity());
        this.kGg.a(this.kGp);
        this.kGf.setAdapter(this.kGg);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.bud();
        this.gAw.setOnClickListener(this.iPy);
        if ("broadcast_publish_success".equals(str)) {
            cWo();
            int size = com.baidu.adp.base.b.kB().getSize();
            Activity aa = com.baidu.adp.base.b.kB().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.b.kB().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void WX() {
        if (this.gAw != null && this.kGa != null) {
            if (j.isNetWorkAvailable()) {
                this.kGf.setNextPage(this.gAw);
                this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gAw.setOnClickListener(null);
                if (this.hasMore) {
                    this.gAw.showLoading();
                    this.kGa.bRj();
                    return;
                }
                this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gAw.endLoadData();
                return;
            }
            this.kGf.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cWa() != null) {
            if (!y.isEmpty(aVar.cWa()) && StringUtils.isEmpty(this.jvW)) {
                b bVar = aVar.cWa().get(0);
                if (bVar.cWh() != null) {
                    this.jvW = bVar.cWh().forum_id + "";
                }
            }
            this.hasMore = aVar.cVZ();
            if (aVar.bJJ()) {
                if (!y.isEmpty(aVar.cWa())) {
                    this.kGh.clear();
                    this.kGh.addAll(aVar.cWa());
                }
            } else if (!y.isEmpty(aVar.cWa())) {
                this.kGh.addAll(aVar.cWa());
            }
            this.kGg.ey(this.kGh);
            if (aVar.bJJ() && this.kGf != null && this.kGf.getChildCount() > 0) {
                this.kGf.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kGk == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kGk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGr);
                ap.a((View) this.kGk, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cWj() >= forumBroadcastMajorResidueData.cWk()) {
                this.kGn = true;
                this.kGk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGs);
                ap.a((View) this.kGk, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.kGk.setAlpha(0.33f);
            } else {
                this.kGk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGr);
                ap.a((View) this.kGk, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.kGf, R.color.CAM_X0204);
        this.gAw.changeSkin(i);
        this.kGg.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kGa != null) {
                            a.this.WZ();
                            a.this.kGa.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kGm, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kGm);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWn() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nA(2);
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
        aVar.b(this.mPageContext).bqx();
    }

    public void cWo() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).zn(true).UZ(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kGh = null;
        this.kGo = null;
    }
}
