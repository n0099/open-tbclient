package com.baidu.tieba.enterForum.view;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class d {
    private View dua;
    private RecentlyVisitedForumModel dub;
    private ImageView duc;
    private TextView dud;
    private RecyclerView due;
    private com.baidu.tieba.enterForum.a.d duf;
    private ViewEventCenter duh;
    private View mDivider;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean dug = true;
    private boolean drk = false;
    private CustomMessageListener dui = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.cv(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.dub = recentlyVisitedForumModel;
        this.duh = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        initData();
        initView();
    }

    private void initData() {
        this.dug = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_layout, (ViewGroup) null);
        this.dua = this.mRootView.findViewById(e.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.title);
        this.duc = (ImageView) this.mRootView.findViewById(e.g.extend_image);
        this.duc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.axd();
            }
        });
        this.dud = (TextView) this.mRootView.findViewById(e.g.done);
        this.dud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dt(false);
            }
        });
        this.mDivider = this.mRootView.findViewById(e.g.divider);
        this.due = (RecyclerView) this.mRootView.findViewById(e.g.list);
        this.duf = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.due.setAdapter(this.duf);
        this.due.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.due.setItemAnimator(new DefaultItemAnimator());
        this.due.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(e.C0210e.tbds27);
            }
        });
        this.duf.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.drk && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new am("c13002").aB(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.duf.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.dt(true);
                return true;
            }
        });
        this.duf.o(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dub != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.dub.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").aB(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dub.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void lB(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.dui);
    }

    public boolean avZ() {
        if (this.drk) {
            dt(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(boolean z) {
        if (this.drk != z && this.duf != null) {
            this.drk = z;
            if (this.drk) {
                this.dud.setVisibility(0);
                this.duc.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.duh != null) {
                    this.duh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.dud.setVisibility(8);
                this.duc.setVisibility(0);
                if (this.duh != null) {
                    this.duh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.duf.dt(this.drk);
        }
    }

    public void axd() {
        this.dug = !this.dug;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.dug);
        if (this.dug) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        axe();
    }

    private void axe() {
        if (this.dug) {
            this.due.setVisibility(0);
            this.mDivider.setVisibility(0);
            al.c(this.duc, e.f.icon_ba_show);
            return;
        }
        this.due.setVisibility(8);
        this.mDivider.setVisibility(8);
        al.c(this.duc, e.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.dua.setVisibility(0);
            axe();
            return;
        }
        this.dua.setVisibility(8);
        this.due.setVisibility(8);
        this.mDivider.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.duf != null && linkedList != null) {
            axe();
            this.duf.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void axf() {
        if (this.dub != null) {
            this.dub.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.duf != null) {
            this.duf.notifyDataSetChanged();
            if (this.duf.getItemCount() > 0) {
                cv(true);
            } else {
                cv(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.duf != null) {
            this.duf.notifyItemRemoved(i);
            if (this.duf.getItemCount() == 0) {
                dt(false);
                cv(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.mTitle, e.d.cp_cont_d);
            al.j(this.mDivider, e.d.cp_bg_line_e);
            al.h(this.dud, e.d.cp_link_tip_a);
            axe();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dui.setTag(bdUniqueId);
    }
}
