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
/* loaded from: classes4.dex */
public class f {
    private Vibrator brC;
    private View eJD;
    private com.baidu.tieba.enterForum.data.b eZS;
    private RecentlyVisitedForumModel fhf;
    private ImageView fhg;
    private TextView fhh;
    private RecyclerView fhi;
    private View fhj;
    private com.baidu.tieba.enterForum.a.b fhk;
    private ViewEventCenter fhl;
    private com.baidu.tieba.enterForum.home.e fhm;
    private k fhn;
    private a fho;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean ffY = true;
    private boolean faf = false;
    private CustomMessageListener fhp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.fhn == null) {
                        f.this.fhn = new k(new i());
                    }
                    f.this.fhn.a(f.this.fhi, 1);
                } else if (f.this.fhn != null) {
                    f.this.fhn.jU();
                }
            }
        }
    };
    private CustomMessageListener ddY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bdB();
            }
        }
    };
    private CustomMessageListener fhq = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.fg(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bdD();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fhf = recentlyVisitedForumModel;
        this.fhl = viewEventCenter;
        this.brC = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.fhm = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.fhp);
        MessageManager.getInstance().registerListener(this.ddY);
        initData();
        initView();
    }

    private void initData() {
        this.ffY = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.eJD = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.fhg = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.fhg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bfK();
            }
        });
        this.fhh = (TextView) this.mRootView.findViewById(R.id.done);
        this.fhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gc(false);
            }
        });
        this.fhj = this.mRootView.findViewById(R.id.gap);
        this.fhi = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.fhk = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.fhi.setAdapter(this.fhk);
        this.fhi.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fhn = new k(new i());
            this.fhn.a(this.fhi, 1);
        }
        this.fhi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.fhi.setItemAnimator(new DefaultItemAnimator());
        this.fhi.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.fhk.a(new b.InterfaceC0399b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0399b
            public void a(b.a aVar) {
                if (!f.this.faf && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.atM());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").bS("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fhk.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gc(true);
                return true;
            }
        });
        this.fhk.t(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fhf != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fhf.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").bS("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fhf.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void pB(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.fhm != null) {
                    f.this.fhm.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.fhq);
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
            BarImageView barImageView = aVar.fal;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.crl;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.fan;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.fap.getUrl());
        }
    }

    public boolean bdB() {
        if (this.faf) {
            gc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(boolean z) {
        if (this.faf != z && this.fhk != null) {
            this.faf = z;
            if (this.faf) {
                this.fhh.setVisibility(0);
                this.fhg.setVisibility(8);
                if (this.brC != null) {
                    this.brC.vibrate(10L);
                }
                if (this.fhl != null) {
                    this.fhl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.fhh.setVisibility(8);
                this.fhg.setVisibility(0);
                if (this.fhl != null) {
                    this.fhl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.fhk.gc(this.faf);
        }
    }

    public boolean bfJ() {
        return this.faf;
    }

    public void bfK() {
        this.ffY = !this.ffY;
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_recently_visited_forum_extend_state", this.ffY);
        if (this.ffY) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bfM();
    }

    public boolean bfL() {
        return this.ffY;
    }

    private void bfM() {
        int i = R.color.white_alpha100;
        if (this.ffY) {
            this.fhi.setVisibility(0);
            this.fhj.setVisibility(8);
            if (this.eZS == null || !this.eZS.fax) {
                i = R.color.cp_cont_j;
            }
            SvgManager.amN().a(this.fhg, R.drawable.icon_pure_ba_show_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.fhi.setVisibility(8);
            this.fhj.setVisibility(0);
            if (this.eZS == null || !this.eZS.fax) {
                i = R.color.cp_cont_j;
            }
            SvgManager.amN().a(this.fhg, R.drawable.icon_pure_ba_hide_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fho != null) {
            this.fho.bdD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.eJD.setVisibility(0);
            bfM();
        } else {
            this.eJD.setVisibility(8);
            this.fhi.setVisibility(8);
            this.fhj.setVisibility(8);
        }
        if (this.fho != null) {
            this.fho.bdD();
        }
    }

    public boolean isShow() {
        return this.eJD.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.fhk != null && linkedList != null) {
            bfM();
            this.fhk.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bfN() {
        if (this.fhf != null) {
            this.fhf.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fhk != null) {
            this.fhk.notifyDataSetChanged();
            if (this.fhk.getItemCount() > 0) {
                fg(true);
            } else {
                fg(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.fhk != null) {
            this.fhk.notifyItemRemoved(i);
            if (this.fhk.getItemCount() == 0) {
                gc(false);
                fg(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZS = bVar;
        bfO();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bfO();
        }
    }

    private void bfO() {
        if (this.eZS != null && this.eZS.fax) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.c(this.fhh, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.fhh.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fhh, (int) R.color.cp_link_tip_a);
            this.fhh.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bfM();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fhq.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fhp);
        MessageManager.getInstance().unRegisterListener(this.ddY);
        if (this.fhm != null) {
            this.fhm.onDestroy();
        }
    }

    public void a(a aVar) {
        this.fho = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int fhs;
        private int fht;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.fhs = i;
            this.fht = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.fhs;
                } else {
                    rect.top = this.fht;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.fhs;
            } else {
                rect.left = this.fht;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bfP() {
        return this.eZS;
    }
}
