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
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
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
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class f {
    private View fHo;
    private com.baidu.tieba.enterForum.data.b fUl;
    private RecentlyVisitedForumModel gaY;
    private ImageView gaZ;
    private TextView gba;
    private View gbb;
    private com.baidu.tieba.enterForum.a.b gbc;
    private ViewEventCenter gbd;
    private com.baidu.tieba.enterForum.home.e gbe;
    private k gbf;
    private a gbg;
    private RecyclerView mListView;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean fZS = true;
    private boolean fUy = false;
    private CustomMessageListener gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gbf == null) {
                        f.this.gbf = new k(new i());
                    }
                    f.this.gbf.a(f.this.mListView, 1);
                } else if (f.this.gbf != null) {
                    f.this.gbf.kB();
                }
            }
        }
    };
    private CustomMessageListener dVT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bxJ();
            }
        }
    };
    private CustomMessageListener gbi = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.gE(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bxL();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gaY = recentlyVisitedForumModel;
        this.gbd = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gbe = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gbh);
        MessageManager.getInstance().registerListener(this.dVT);
        initData();
        initView();
    }

    private void initData() {
        this.fZS = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.fHo = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gaZ = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gaZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bzQ();
            }
        });
        this.gba = (TextView) this.mRootView.findViewById(R.id.done);
        this.gba.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.hD(false);
            }
        });
        this.gbb = this.mRootView.findViewById(R.id.gap);
        this.mListView = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gbc = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.mListView.setAdapter(this.gbc);
        this.mListView.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gbf = new k(new i());
            this.gbf.a(this.mListView, 1);
        }
        this.mListView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mListView.setItemAnimator(new DefaultItemAnimator());
        this.mListView.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gbc.a(new b.InterfaceC0494b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0494b
            public void a(b.a aVar) {
                if (!f.this.fUy && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aOl());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cx("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gbc.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.hD(true);
                return true;
            }
        });
        this.gbc.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gaY != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gaY.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cx("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gaY.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void rU(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.gbe != null) {
                    f.this.gbe.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gbi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.fUE;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.diF;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.fUG;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bxJ() {
        if (this.fUy) {
            hD(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(boolean z) {
        if (this.fUy != z && this.gbc != null) {
            this.fUy = z;
            if (this.fUy) {
                this.gba.setVisibility(0);
                this.gaZ.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gbd != null) {
                    this.gbd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gba.setVisibility(8);
                this.gaZ.setVisibility(0);
                if (this.gbd != null) {
                    this.gbd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gbc.hD(this.fUy);
        }
    }

    public boolean bzP() {
        return this.fUy;
    }

    public void bzQ() {
        this.fZS = !this.fZS;
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_recently_visited_forum_extend_state", this.fZS);
        if (this.fZS) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bzS();
    }

    public boolean bzR() {
        return this.fZS;
    }

    private void bzS() {
        int i = R.color.white_alpha100;
        if (this.fZS) {
            this.mListView.setVisibility(0);
            this.gbb.setVisibility(8);
            if (this.fUl == null || !this.fUl.fUP) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGG().a(this.gaZ, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.mListView.setVisibility(8);
            this.gbb.setVisibility(0);
            if (this.fUl == null || !this.fUl.fUP) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGG().a(this.gaZ, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gbg != null) {
            this.gbg.bxL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.fHo.setVisibility(0);
            bzS();
        } else {
            this.fHo.setVisibility(8);
            this.mListView.setVisibility(8);
            this.gbb.setVisibility(8);
        }
        if (this.gbg != null) {
            this.gbg.bxL();
        }
    }

    public boolean isShow() {
        return this.fHo.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gbc != null && linkedList != null) {
            bzS();
            this.gbc.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bzT() {
        if (this.gaY != null) {
            this.gaY.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gbc != null) {
            this.gbc.notifyDataSetChanged();
            if (this.gbc.getItemCount() > 0) {
                gE(true);
            } else {
                gE(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gbc != null) {
            this.gbc.notifyItemRemoved(i);
            if (this.gbc.getItemCount() == 0) {
                hD(false);
                gE(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fUl = bVar;
        bzU();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bzU();
        }
    }

    private void bzU() {
        if (this.fUl != null && this.fUl.fUP) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gba, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gba.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gba, (int) R.color.cp_link_tip_a);
            this.gba.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bzS();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gbi.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gbh);
        MessageManager.getInstance().unRegisterListener(this.dVT);
        if (this.gbe != null) {
            this.gbe.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gbg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gbk;
        private int gbl;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gbk = i;
            this.gbl = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gbk;
                } else {
                    rect.top = this.gbl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gbk;
            } else {
                rect.left = this.gbl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bzV() {
        return this.fUl;
    }
}
