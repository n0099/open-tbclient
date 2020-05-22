package com.baidu.tieba.enterForum.view;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.c;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class f {
    private View gAS;
    private com.baidu.tieba.enterForum.data.d gNJ;
    private RecentlyVisitedForumModel gXX;
    private ImageView gXY;
    private TextView gXZ;
    private RecyclerView gYa;
    private View gYb;
    private com.baidu.tieba.enterForum.a.c gYc;
    private ViewEventCenter gYd;
    private com.baidu.tieba.enterForum.home.e gYe;
    private m gYf;
    private a gYg;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean gWS = true;
    private boolean gOd = false;
    private CustomMessageListener gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gYf == null) {
                        f.this.gYf = new m(new k());
                    }
                    f.this.gYf.a(f.this.gYa, 1);
                } else if (f.this.gYf != null) {
                    f.this.gYf.pl();
                }
            }
        }
    };
    private CustomMessageListener eKz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bNN();
            }
        }
    };
    private CustomMessageListener gYi = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.hY(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bNP();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gXX = recentlyVisitedForumModel;
        this.gYd = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gYe = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gYh);
        MessageManager.getInstance().registerListener(this.eKz);
        initData();
        initView();
    }

    private void initData() {
        this.gWS = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.gAS = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gXY = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gXY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bQA();
            }
        });
        this.gXZ = (TextView) this.mRootView.findViewById(R.id.done);
        this.gXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.iY(false);
            }
        });
        this.gYb = this.mRootView.findViewById(R.id.gap);
        this.gYa = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gYc = new com.baidu.tieba.enterForum.a.c(this.mPageContext);
        this.gYa.setAdapter(this.gYc);
        this.gYa.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYf = new m(new k());
            this.gYf.a(this.gYa, 1);
        }
        this.gYa.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.gYa.setItemAnimator(new DefaultItemAnimator());
        this.gYa.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gYc.a(new c.b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.c.b
            public void a(c.a aVar) {
                if (!f.this.gOd && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bcJ());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").dh("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gYc.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.iY(true);
                return true;
            }
        });
        this.gYc.u(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gXX != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gXX.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").dh("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gXX.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void sR(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.gYe != null) {
                    f.this.gYe.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gYi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.gOj;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.dWR;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.gOl;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bNN() {
        if (this.gOd) {
            iY(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(boolean z) {
        if (this.gOd != z && this.gYc != null) {
            this.gOd = z;
            if (this.gOd) {
                this.gXZ.setVisibility(0);
                this.gXY.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gYd != null) {
                    this.gYd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gXZ.setVisibility(8);
                this.gXY.setVisibility(0);
                if (this.gYd != null) {
                    this.gYd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gYc.iY(this.gOd);
        }
    }

    public boolean bQz() {
        return this.gOd;
    }

    public void bQA() {
        this.gWS = !this.gWS;
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_recently_visited_forum_extend_state", this.gWS);
        if (this.gWS) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bQC();
    }

    public boolean bQB() {
        return this.gWS;
    }

    private void bQC() {
        int i = R.color.white_alpha100;
        if (this.gWS) {
            this.gYa.setVisibility(0);
            this.gYb.setVisibility(8);
            if (this.gNJ == null || !this.gNJ.gOu) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aUV().a(this.gXY, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.gYa.setVisibility(8);
            this.gYb.setVisibility(0);
            if (this.gNJ == null || !this.gNJ.gOu) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aUV().a(this.gXY, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gYg != null) {
            this.gYg.bNP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.gAS.setVisibility(0);
            bQC();
        } else {
            this.gAS.setVisibility(8);
            this.gYa.setVisibility(8);
            this.gYb.setVisibility(8);
        }
        if (this.gYg != null) {
            this.gYg.bNP();
        }
    }

    public boolean isShow() {
        return this.gAS.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gYc != null && linkedList != null) {
            bQC();
            this.gYc.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bQD() {
        if (this.gXX != null) {
            this.gXX.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gYc != null) {
            this.gYc.notifyDataSetChanged();
            if (this.gYc.getItemCount() > 0) {
                hY(true);
            } else {
                hY(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gYc != null) {
            this.gYc.notifyItemRemoved(i);
            if (this.gYc.getItemCount() == 0) {
                iY(false);
                hY(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNJ = dVar;
        bQE();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bQE();
        }
    }

    private void bQE() {
        if (this.gNJ != null && this.gNJ.gOu) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gXZ, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gXZ.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gXZ, (int) R.color.cp_link_tip_a);
            this.gXZ.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bQC();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gYi.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYh);
        MessageManager.getInstance().unRegisterListener(this.eKz);
        if (this.gYe != null) {
            this.gYe.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gYg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gYk;
        private int gYl;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gYk = i;
            this.gYl = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gYk;
                } else {
                    rect.top = this.gYl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gYk;
            } else {
                rect.left = this.gYl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.d bQF() {
        return this.gNJ;
    }
}
