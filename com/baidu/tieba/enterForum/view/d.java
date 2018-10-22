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
    private View diV;
    private RecentlyVisitedForumModel diW;
    private ImageView diX;
    private TextView diY;
    private RecyclerView diZ;
    private com.baidu.tieba.enterForum.a.d dja;
    private ViewEventCenter djc;
    private com.baidu.tieba.enterForum.home.c djd;
    private View mDivider;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean djb = true;
    private boolean dfU = false;
    private CustomMessageListener dje = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.ca(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.diW = recentlyVisitedForumModel;
        this.djc = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.djd = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.djb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_layout, (ViewGroup) null);
        this.diV = this.mRootView.findViewById(e.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.title);
        this.diX = (ImageView) this.mRootView.findViewById(e.g.extend_image);
        this.diX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.auI();
            }
        });
        this.diY = (TextView) this.mRootView.findViewById(e.g.done);
        this.diY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cY(false);
            }
        });
        this.mDivider = this.mRootView.findViewById(e.g.divider);
        this.diZ = (RecyclerView) this.mRootView.findViewById(e.g.list);
        this.dja = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.diZ.setAdapter(this.dja);
        this.diZ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.diZ.setItemAnimator(new DefaultItemAnimator());
        this.diZ.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(e.C0175e.tbds27);
            }
        });
        this.dja.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dfU && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new am("c13002").ax(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dja.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.cY(true);
                return true;
            }
        });
        this.dja.m(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.diW != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.diW.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").ax(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.diW.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void kF(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void aui() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.djd != null) {
                    d.this.djd.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.dje);
    }

    public boolean atB() {
        if (this.dfU) {
            cY(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(boolean z) {
        if (this.dfU != z && this.dja != null) {
            this.dfU = z;
            if (this.dfU) {
                this.diY.setVisibility(0);
                this.diX.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.djc != null) {
                    this.djc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.diY.setVisibility(8);
                this.diX.setVisibility(0);
                if (this.djc != null) {
                    this.djc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.dja.cY(this.dfU);
        }
    }

    public void auI() {
        this.djb = !this.djb;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.djb);
        if (this.djb) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        auJ();
    }

    private void auJ() {
        if (this.djb) {
            this.diZ.setVisibility(0);
            this.mDivider.setVisibility(0);
            al.c(this.diX, e.f.icon_ba_show);
            return;
        }
        this.diZ.setVisibility(8);
        this.mDivider.setVisibility(8);
        al.c(this.diX, e.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.diV.setVisibility(0);
            auJ();
            return;
        }
        this.diV.setVisibility(8);
        this.diZ.setVisibility(8);
        this.mDivider.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.dja != null && linkedList != null) {
            auJ();
            this.dja.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void auK() {
        if (this.diW != null) {
            this.diW.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.dja != null) {
            this.dja.notifyDataSetChanged();
            if (this.dja.getItemCount() > 0) {
                ca(true);
            } else {
                ca(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.dja != null) {
            this.dja.notifyItemRemoved(i);
            if (this.dja.getItemCount() == 0) {
                cY(false);
                ca(false);
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
            al.h(this.diY, e.d.cp_link_tip_a);
            auJ();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dje.setTag(bdUniqueId);
    }

    public void onDestroy() {
        if (this.djd != null) {
            this.djd.onDestroy();
        }
    }
}
