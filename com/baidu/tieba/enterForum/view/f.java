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
    private Vibrator aYc;
    private com.baidu.tieba.enterForum.data.b eVt;
    private View ezf;
    private RecentlyVisitedForumModel fcj;
    private ImageView fck;
    private TextView fcl;
    private RecyclerView fcm;
    private com.baidu.tieba.enterForum.a.b fcn;
    private ViewEventCenter fco;
    private com.baidu.tieba.enterForum.home.e fcp;
    private k fcq;
    private a fcr;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean fbp = true;
    private boolean eVG = false;
    private CustomMessageListener fcs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.fcq == null) {
                        f.this.fcq = new k(new i());
                    }
                    f.this.fcq.a(f.this.fcm, 1);
                } else if (f.this.fcq != null) {
                    f.this.fcq.ow();
                }
            }
        }
    };
    private CustomMessageListener cTD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.enterForum.view.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bfb();
            }
        }
    };
    private CustomMessageListener fct = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.fj(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bfd();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fcj = recentlyVisitedForumModel;
        this.fco = viewEventCenter;
        this.aYc = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.fcp = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.fcs);
        MessageManager.getInstance().registerListener(this.cTD);
        initData();
        initView();
    }

    private void initData() {
        this.fbp = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.ezf = this.mRootView.findViewById(R.id.title_container);
        this.ezf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(f.this.mPageContext.getUniqueId(), f.this.mPageContext.getPageActivity());
            }
        });
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.fck = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.fck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bha();
            }
        });
        this.fcl = (TextView) this.mRootView.findViewById(R.id.done);
        this.fcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gk(false);
            }
        });
        this.fcm = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.fcn = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.fcm.setAdapter(this.fcn);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcq = new k(new i());
            this.fcq.a(this.fcm, 1);
        }
        this.fcm.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.fcm.setItemAnimator(new DefaultItemAnimator());
        this.fcm.addItemDecoration(new b(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.fcn.a(new b.InterfaceC0295b() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0295b
            public void a(b.a aVar) {
                if (!f.this.eVG && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.arK());
                    f.this.mPageContext.sendMessage(new CustomMessage(2003000, callFrom));
                    TiebaStatic.log(new an("c13002").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fcn.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gk(true);
                return true;
            }
        });
        this.fcn.r(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fcj != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fcj.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fcj.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.10
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void qA(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.n(linkedList);
                if (!z && f.this.fcp != null) {
                    f.this.fcp.d(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.fct);
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
            BarImageView barImageView = aVar.eVL;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.cbW;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eVN;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eVP.getUrl());
        }
    }

    public boolean bfb() {
        if (this.eVG) {
            gk(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(boolean z) {
        if (this.eVG != z && this.fcn != null) {
            this.eVG = z;
            if (this.eVG) {
                this.fcl.setVisibility(0);
                this.fck.setVisibility(8);
                if (this.aYc != null) {
                    this.aYc.vibrate(10L);
                }
                if (this.fco != null) {
                    this.fco.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.fcl.setVisibility(8);
                this.fck.setVisibility(0);
                if (this.fco != null) {
                    this.fco.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.fcn.gk(this.eVG);
        }
    }

    public boolean bgZ() {
        return this.eVG;
    }

    public void bha() {
        this.fbp = !this.fbp;
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_recently_visited_forum_extend_state", this.fbp);
        if (this.fbp) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bhc();
    }

    public boolean bhb() {
        return this.fbp;
    }

    private void bhc() {
        if (this.fbp) {
            this.fcm.setVisibility(0);
            if (this.eVt != null && this.eVt.eVV) {
                am.c(this.fck, (int) R.drawable.icon_ba_show_white);
            } else {
                am.c(this.fck, (int) R.drawable.icon_ba_show_black);
            }
        } else {
            this.fcm.setVisibility(8);
            if (this.eVt != null && this.eVt.eVV) {
                am.c(this.fck, (int) R.drawable.icon_ba_hide_white);
            } else {
                am.c(this.fck, (int) R.drawable.icon_ba_hide_black);
            }
        }
        if (this.fcr != null) {
            this.fcr.bfd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.ezf.setVisibility(0);
            bhc();
        } else {
            this.ezf.setVisibility(8);
            this.fcm.setVisibility(8);
        }
        if (this.fcr != null) {
            this.fcr.bfd();
        }
    }

    public boolean isShow() {
        return this.ezf.getVisibility() == 0;
    }

    public void n(LinkedList<VisitedForumData> linkedList) {
        if (this.fcn != null && linkedList != null) {
            bhc();
            this.fcn.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bhd() {
        if (this.fcj != null) {
            this.fcj.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fcn != null) {
            this.fcn.notifyDataSetChanged();
            if (this.fcn.getItemCount() > 0) {
                fj(true);
            } else {
                fj(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.fcn != null) {
            this.fcn.notifyItemRemoved(i);
            if (this.fcn.getItemCount() == 0) {
                gk(false);
                fj(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVt = bVar;
        bhe();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bhe();
        }
    }

    private void bhe() {
        if (this.eVt != null && this.eVt.eVV) {
            am.j(this.mTitle, R.color.cp_btn_a);
            this.mRootView.setBackgroundColor(0);
            am.i(this.fcl, R.color.cp_cont_b, R.color.cp_cont_d_alpha50);
            am.k(this.fcl, R.drawable.enter_forum_recent_edit_done_bg);
        } else {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.mRootView, R.color.cp_bg_line_f);
            am.j(this.fcl, R.color.cp_link_tip_a);
            this.fcl.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bhc();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fct.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcs);
        MessageManager.getInstance().unRegisterListener(this.cTD);
        if (this.fcp != null) {
            this.fcp.onDestroy();
        }
    }

    public void a(a aVar) {
        this.fcr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int fcv;
        private int fcw;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.fcv = i;
            this.fcw = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.fcv;
                } else {
                    rect.top = this.fcw;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.fcv;
            } else {
                rect.left = this.fcw;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bhf() {
        return this.eVt;
    }
}
