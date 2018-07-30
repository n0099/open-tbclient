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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private View bHR;
    private View cUU;
    private RecentlyVisitedForumModel cUV;
    private Vibrator cUW;
    private ImageView cUX;
    private TextView cUY;
    private RecyclerView cUZ;
    private com.baidu.tieba.enterForum.a.d cVa;
    private ViewEventCenter cVc;
    private com.baidu.tieba.enterForum.home.c cVd;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cVb = true;
    private boolean cRP = false;
    private CustomMessageListener cVe = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.bE(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cUV = recentlyVisitedForumModel;
        this.cVc = viewEventCenter;
        this.cUW = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cVd = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.cVb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_layout, (ViewGroup) null);
        this.cUU = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cUX = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.apx();
            }
        });
        this.cUY = (TextView) this.mRootView.findViewById(d.g.done);
        this.cUY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cx(false);
            }
        });
        this.bHR = this.mRootView.findViewById(d.g.divider);
        this.cUZ = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cVa = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cUZ.setAdapter(this.cVa);
        this.cUZ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cUZ.setItemAnimator(new DefaultItemAnimator());
        this.cUZ.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds27);
            }
        });
        this.cVa.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cRP && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new an("c13002").af(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cVa.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.cx(true);
                return true;
            }
        });
        this.cVa.m(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cUV != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.cUV.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").af(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cUV.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jJ(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void aoW() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.cVd != null) {
                    d.this.cVd.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.cVe);
    }

    public boolean aop() {
        if (this.cRP) {
            cx(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (this.cRP != z && this.cVa != null) {
            this.cRP = z;
            if (this.cRP) {
                this.cUY.setVisibility(0);
                this.cUX.setVisibility(8);
                if (this.cUW != null) {
                    this.cUW.vibrate(10L);
                }
                if (this.cVc != null) {
                    this.cVc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cUY.setVisibility(8);
                this.cUX.setVisibility(0);
                if (this.cVc != null) {
                    this.cVc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cVa.cx(this.cRP);
        }
    }

    public void apx() {
        this.cVb = !this.cVb;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.cVb);
        if (this.cVb) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        apy();
    }

    private void apy() {
        if (this.cVb) {
            this.cUZ.setVisibility(0);
            this.bHR.setVisibility(0);
            am.c(this.cUX, d.f.icon_ba_show);
            return;
        }
        this.cUZ.setVisibility(8);
        this.bHR.setVisibility(8);
        am.c(this.cUX, d.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.cUU.setVisibility(0);
            apy();
            return;
        }
        this.cUU.setVisibility(8);
        this.cUZ.setVisibility(8);
        this.bHR.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.cVa != null && linkedList != null) {
            apy();
            this.cVa.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void apz() {
        if (this.cUV != null) {
            this.cUV.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cVa != null) {
            this.cVa.notifyDataSetChanged();
            if (this.cVa.getItemCount() > 0) {
                bE(true);
            } else {
                bE(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cVa != null) {
            this.cVa.notifyItemRemoved(i);
            if (this.cVa.getItemCount() == 0) {
                cx(false);
                bE(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.mTitle, d.C0140d.cp_cont_d);
            am.j(this.bHR, d.C0140d.cp_bg_line_e);
            am.h(this.cUY, d.C0140d.cp_link_tip_a);
            apy();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cVe.setTag(bdUniqueId);
    }

    public void onDestroy() {
        if (this.cVd != null) {
            this.cVd.onDestroy();
        }
    }
}
