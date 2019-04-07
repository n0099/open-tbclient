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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {
    private Vibrator aUv;
    private View eGV;
    private RecentlyVisitedForumModel eGW;
    private ImageView eGX;
    private TextView eGY;
    private RecyclerView eGZ;
    private com.baidu.tieba.enterForum.a.b eHa;
    private ViewEventCenter eHc;
    private com.baidu.tieba.enterForum.home.e eHd;
    private k eHe;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean eHb = true;
    private boolean eAZ = false;
    private CustomMessageListener eHf = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (e.this.eHe == null) {
                        e.this.eHe = new k(new i());
                    }
                    e.this.eHe.a(e.this.eGZ, 1);
                } else if (e.this.eHe != null) {
                    e.this.eHe.pg();
                }
            }
        }
    };
    private CustomMessageListener cJV = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.enterForum.view.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                e.this.aVU();
            }
        }
    };
    private CustomMessageListener eHg = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                e.this.eJ(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.eGW = recentlyVisitedForumModel;
        this.eHc = viewEventCenter;
        this.aUv = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.eHd = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.eHf);
        MessageManager.getInstance().registerListener(this.cJV);
        initData();
        initView();
    }

    private void initData() {
        this.eHb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_layout, (ViewGroup) null);
        this.eGV = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.eGX = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.eGX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aXD();
            }
        });
        this.eGY = (TextView) this.mRootView.findViewById(d.g.done);
        this.eGY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.fJ(false);
            }
        });
        this.eGZ = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.eHa = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.eGZ.setAdapter(this.eHa);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eHe = new k(new i());
            this.eHe.a(this.eGZ, 1);
        }
        this.eGZ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.eGZ.setItemAnimator(new DefaultItemAnimator());
        this.eGZ.addItemDecoration(new a(l.h(this.mPageContext.getPageActivity(), d.e.tbds35), l.h(this.mPageContext.getPageActivity(), d.e.tbds1), l.h(this.mPageContext.getPageActivity(), d.e.tbds44)));
        this.eHa.a(new b.InterfaceC0280b() { // from class: com.baidu.tieba.enterForum.view.e.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0280b
            public void a(b.a aVar) {
                if (!e.this.eAZ && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(e.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    e.this.a(aVar, callFrom.getIntent(), visitedForumData.alB());
                    e.this.mPageContext.sendMessage(new CustomMessage(2003000, callFrom));
                    TiebaStatic.log(new am("c13002").bJ(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.eHa.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.e.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                e.this.fJ(true);
                return true;
            }
        });
        this.eHa.p(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eGW != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    e.this.eGW.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").bJ(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.eGW.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.e.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void pd(int i) {
                e.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                e.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                e.this.n(linkedList);
                if (!z && e.this.eHd != null) {
                    e.this.eHd.d(linkedList, e.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678) + e.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.eHg);
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
            BarImageView barImageView = aVar.eBe;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.bTa;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eBg;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eBi.getUrl());
        }
    }

    public boolean aVU() {
        if (this.eAZ) {
            fJ(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ(boolean z) {
        if (this.eAZ != z && this.eHa != null) {
            this.eAZ = z;
            if (this.eAZ) {
                this.eGY.setVisibility(0);
                this.eGX.setVisibility(8);
                if (this.aUv != null) {
                    this.aUv.vibrate(10L);
                }
                if (this.eHc != null) {
                    this.eHc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.eGY.setVisibility(8);
                this.eGX.setVisibility(0);
                if (this.eHc != null) {
                    this.eHc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.eHa.fJ(this.eAZ);
        }
    }

    public boolean aXC() {
        return this.eAZ;
    }

    public void aXD() {
        this.eHb = !this.eHb;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.eHb);
        if (this.eHb) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        aXE();
    }

    private void aXE() {
        if (this.eHb) {
            this.eGZ.setVisibility(0);
            al.c(this.eGX, d.f.icon_ba_show);
            return;
        }
        this.eGZ.setVisibility(8);
        al.c(this.eGX, d.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.eGV.setVisibility(0);
            aXE();
            return;
        }
        this.eGV.setVisibility(8);
        this.eGZ.setVisibility(8);
    }

    public void n(LinkedList<VisitedForumData> linkedList) {
        if (this.eHa != null && linkedList != null) {
            aXE();
            this.eHa.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aXF() {
        if (this.eGW != null) {
            this.eGW.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eHa != null) {
            this.eHa.notifyDataSetChanged();
            if (this.eHa.getItemCount() > 0) {
                eJ(true);
            } else {
                eJ(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.eHa != null) {
            this.eHa.notifyItemRemoved(i);
            if (this.eHa.getItemCount() == 0) {
                fJ(false);
                eJ(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.j(this.eGY, d.C0277d.cp_link_tip_a);
            al.l(this.mRootView, d.C0277d.cp_bg_line_f);
            aXE();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eHg.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHf);
        MessageManager.getInstance().unRegisterListener(this.cJV);
        if (this.eHd != null) {
            this.eHd.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int eHi;
        private int eHj;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.eHi = i;
            this.eHj = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.eHi;
                } else {
                    rect.top = this.eHj;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.eHi;
            } else {
                rect.left = this.eHj;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
