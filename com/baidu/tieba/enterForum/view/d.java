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
/* loaded from: classes2.dex */
public class d {
    private View bNG;
    private View daJ;
    private RecentlyVisitedForumModel daK;
    private Vibrator daL;
    private ImageView daM;
    private TextView daN;
    private RecyclerView daO;
    private com.baidu.tieba.enterForum.a.d daP;
    private ViewEventCenter daR;
    private com.baidu.tieba.enterForum.home.c daS;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean daQ = true;
    private boolean cXD = false;
    private CustomMessageListener daT = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.bR(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.daK = recentlyVisitedForumModel;
        this.daR = viewEventCenter;
        this.daL = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.daS = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.daQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_layout, (ViewGroup) null);
        this.daJ = this.mRootView.findViewById(e.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.title);
        this.daM = (ImageView) this.mRootView.findViewById(e.g.extend_image);
        this.daM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.arl();
            }
        });
        this.daN = (TextView) this.mRootView.findViewById(e.g.done);
        this.daN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cP(false);
            }
        });
        this.bNG = this.mRootView.findViewById(e.g.divider);
        this.daO = (RecyclerView) this.mRootView.findViewById(e.g.list);
        this.daP = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.daO.setAdapter(this.daP);
        this.daO.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.daO.setItemAnimator(new DefaultItemAnimator());
        this.daO.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(e.C0141e.tbds27);
            }
        });
        this.daP.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cXD && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new am("c13002").al(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.daP.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.cP(true);
                return true;
            }
        });
        this.daP.m(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.daK != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.daK.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").al(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.daK.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void kh(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void aqL() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.daS != null) {
                    d.this.daS.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.daT);
    }

    public boolean aqe() {
        if (this.cXD) {
            cP(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(boolean z) {
        if (this.cXD != z && this.daP != null) {
            this.cXD = z;
            if (this.cXD) {
                this.daN.setVisibility(0);
                this.daM.setVisibility(8);
                if (this.daL != null) {
                    this.daL.vibrate(10L);
                }
                if (this.daR != null) {
                    this.daR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.daN.setVisibility(8);
                this.daM.setVisibility(0);
                if (this.daR != null) {
                    this.daR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.daP.cP(this.cXD);
        }
    }

    public void arl() {
        this.daQ = !this.daQ;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.daQ);
        if (this.daQ) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        arm();
    }

    private void arm() {
        if (this.daQ) {
            this.daO.setVisibility(0);
            this.bNG.setVisibility(0);
            al.c(this.daM, e.f.icon_ba_show);
            return;
        }
        this.daO.setVisibility(8);
        this.bNG.setVisibility(8);
        al.c(this.daM, e.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.daJ.setVisibility(0);
            arm();
            return;
        }
        this.daJ.setVisibility(8);
        this.daO.setVisibility(8);
        this.bNG.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.daP != null && linkedList != null) {
            arm();
            this.daP.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void arn() {
        if (this.daK != null) {
            this.daK.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.daP != null) {
            this.daP.notifyDataSetChanged();
            if (this.daP.getItemCount() > 0) {
                bR(true);
            } else {
                bR(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.daP != null) {
            this.daP.notifyItemRemoved(i);
            if (this.daP.getItemCount() == 0) {
                cP(false);
                bR(false);
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
            al.j(this.bNG, e.d.cp_bg_line_e);
            al.h(this.daN, e.d.cp_link_tip_a);
            arm();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.daT.setTag(bdUniqueId);
    }

    public void onDestroy() {
        if (this.daS != null) {
            this.daS.onDestroy();
        }
    }
}
