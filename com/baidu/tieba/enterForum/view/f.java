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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private Vibrator aXs;
    private com.baidu.tieba.enterForum.data.b eQt;
    private RecentlyVisitedForumModel eXi;
    private ImageView eXj;
    private TextView eXk;
    private RecyclerView eXl;
    private com.baidu.tieba.enterForum.a.b eXm;
    private ViewEventCenter eXn;
    private com.baidu.tieba.enterForum.home.e eXo;
    private k eXp;
    private a eXq;
    private View eug;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean eWo = true;
    private boolean eQG = false;
    private CustomMessageListener eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.eXp == null) {
                        f.this.eXp = new k(new i());
                    }
                    f.this.eXp.a(f.this.eXl, 1);
                } else if (f.this.eXp != null) {
                    f.this.eXp.oa();
                }
            }
        }
    };
    private CustomMessageListener cSh = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.enterForum.view.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bcZ();
            }
        }
    };
    private CustomMessageListener eXs = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.ff(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bdb();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.eXi = recentlyVisitedForumModel;
        this.eXn = viewEventCenter;
        this.aXs = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.eXo = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.eXr);
        MessageManager.getInstance().registerListener(this.cSh);
        initData();
        initView();
    }

    private void initData() {
        this.eWo = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.eug = this.mRootView.findViewById(R.id.title_container);
        this.eug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(f.this.mPageContext.getUniqueId(), f.this.mPageContext.getPageActivity());
            }
        });
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.eXj = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.eXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.beX();
            }
        });
        this.eXk = (TextView) this.mRootView.findViewById(R.id.done);
        this.eXk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gg(false);
            }
        });
        this.eXl = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.eXm = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.eXl.setAdapter(this.eXm);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXp = new k(new i());
            this.eXp.a(this.eXl, 1);
        }
        this.eXl.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.eXl.setItemAnimator(new DefaultItemAnimator());
        this.eXl.addItemDecoration(new b(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.eXm.a(new b.InterfaceC0298b() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0298b
            public void a(b.a aVar) {
                if (!f.this.eQG && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aqE());
                    f.this.mPageContext.sendMessage(new CustomMessage(2003000, callFrom));
                    TiebaStatic.log(new am("c13002").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.eXm.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gg(true);
                return true;
            }
        });
        this.eXm.r(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eXi != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.eXi.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.eXi.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.10
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void qi(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.n(linkedList);
                if (!z && f.this.eXo != null) {
                    f.this.eXo.d(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.eXs);
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
            BarImageView barImageView = aVar.eQL;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.caU;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eQN;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eQP.getUrl());
        }
    }

    public boolean bcZ() {
        if (this.eQG) {
            gg(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(boolean z) {
        if (this.eQG != z && this.eXm != null) {
            this.eQG = z;
            if (this.eQG) {
                this.eXk.setVisibility(0);
                this.eXj.setVisibility(8);
                if (this.aXs != null) {
                    this.aXs.vibrate(10L);
                }
                if (this.eXn != null) {
                    this.eXn.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.eXk.setVisibility(8);
                this.eXj.setVisibility(0);
                if (this.eXn != null) {
                    this.eXn.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.eXm.gg(this.eQG);
        }
    }

    public boolean beW() {
        return this.eQG;
    }

    public void beX() {
        this.eWo = !this.eWo;
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_recently_visited_forum_extend_state", this.eWo);
        if (this.eWo) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        beZ();
    }

    public boolean beY() {
        return this.eWo;
    }

    private void beZ() {
        if (this.eWo) {
            this.eXl.setVisibility(0);
            if (this.eQt != null && this.eQt.eQV) {
                al.c(this.eXj, (int) R.drawable.icon_ba_show_white);
            } else {
                al.c(this.eXj, (int) R.drawable.icon_ba_show_black);
            }
        } else {
            this.eXl.setVisibility(8);
            if (this.eQt != null && this.eQt.eQV) {
                al.c(this.eXj, (int) R.drawable.icon_ba_hide_white);
            } else {
                al.c(this.eXj, (int) R.drawable.icon_ba_hide_black);
            }
        }
        if (this.eXq != null) {
            this.eXq.bdb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.eug.setVisibility(0);
            beZ();
        } else {
            this.eug.setVisibility(8);
            this.eXl.setVisibility(8);
        }
        if (this.eXq != null) {
            this.eXq.bdb();
        }
    }

    public boolean isShow() {
        return this.eug.getVisibility() == 0;
    }

    public void n(LinkedList<VisitedForumData> linkedList) {
        if (this.eXm != null && linkedList != null) {
            beZ();
            this.eXm.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bfa() {
        if (this.eXi != null) {
            this.eXi.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eXm != null) {
            this.eXm.notifyDataSetChanged();
            if (this.eXm.getItemCount() > 0) {
                ff(true);
            } else {
                ff(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.eXm != null) {
            this.eXm.notifyItemRemoved(i);
            if (this.eXm.getItemCount() == 0) {
                gg(false);
                ff(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQt = bVar;
        bfb();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bfb();
        }
    }

    private void bfb() {
        if (this.eQt != null && this.eQt.eQV) {
            al.j(this.mTitle, R.color.cp_btn_a);
            this.mRootView.setBackgroundColor(0);
            al.i(this.eXk, R.color.cp_cont_b, R.color.cp_cont_d_alpha50);
            al.k(this.eXk, R.drawable.enter_forum_recent_edit_done_bg);
        } else {
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.mRootView, R.color.cp_bg_line_f);
            al.j(this.eXk, R.color.cp_link_tip_a);
            this.eXk.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        beZ();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eXs.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXr);
        MessageManager.getInstance().unRegisterListener(this.cSh);
        if (this.eXo != null) {
            this.eXo.onDestroy();
        }
    }

    public void a(a aVar) {
        this.eXq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int eXu;
        private int eXv;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.eXu = i;
            this.eXv = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.eXu;
                } else {
                    rect.top = this.eXv;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.eXu;
            } else {
                rect.left = this.eXv;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bfc() {
        return this.eQt;
    }
}
