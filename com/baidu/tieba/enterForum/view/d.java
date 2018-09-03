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
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private View bHR;
    private View cUQ;
    private RecentlyVisitedForumModel cUR;
    private Vibrator cUS;
    private ImageView cUT;
    private TextView cUU;
    private RecyclerView cUV;
    private com.baidu.tieba.enterForum.a.d cUW;
    private ViewEventCenter cUY;
    private com.baidu.tieba.enterForum.home.c cUZ;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cUX = true;
    private boolean cRM = false;
    private CustomMessageListener cVa = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.bF(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cUR = recentlyVisitedForumModel;
        this.cUY = viewEventCenter;
        this.cUS = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cUZ = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.cUX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.recently_visited_forum_layout, (ViewGroup) null);
        this.cUQ = this.mRootView.findViewById(f.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(f.g.title);
        this.cUT = (ImageView) this.mRootView.findViewById(f.g.extend_image);
        this.cUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.apx();
            }
        });
        this.cUU = (TextView) this.mRootView.findViewById(f.g.done);
        this.cUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cy(false);
            }
        });
        this.bHR = this.mRootView.findViewById(f.g.divider);
        this.cUV = (RecyclerView) this.mRootView.findViewById(f.g.list);
        this.cUW = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cUV.setAdapter(this.cUW);
        this.cUV.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cUV.setItemAnimator(new DefaultItemAnimator());
        this.cUV.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(f.e.tbds27);
            }
        });
        this.cUW.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cRM && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new an("c13002").ae(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cUW.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.cy(true);
                return true;
            }
        });
        this.cUW.m(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cUR != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.cUR.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").ae(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cUR.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jI(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void aoW() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.cUZ != null) {
                    d.this.cUZ.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(f.e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(f.e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.cVa);
    }

    public boolean aop() {
        if (this.cRM) {
            cy(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.cRM != z && this.cUW != null) {
            this.cRM = z;
            if (this.cRM) {
                this.cUU.setVisibility(0);
                this.cUT.setVisibility(8);
                if (this.cUS != null) {
                    this.cUS.vibrate(10L);
                }
                if (this.cUY != null) {
                    this.cUY.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cUU.setVisibility(8);
                this.cUT.setVisibility(0);
                if (this.cUY != null) {
                    this.cUY.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cUW.cy(this.cRM);
        }
    }

    public void apx() {
        this.cUX = !this.cUX;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.cUX);
        if (this.cUX) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        apy();
    }

    private void apy() {
        if (this.cUX) {
            this.cUV.setVisibility(0);
            this.bHR.setVisibility(0);
            am.c(this.cUT, f.C0146f.icon_ba_show);
            return;
        }
        this.cUV.setVisibility(8);
        this.bHR.setVisibility(8);
        am.c(this.cUT, f.C0146f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.cUQ.setVisibility(0);
            apy();
            return;
        }
        this.cUQ.setVisibility(8);
        this.cUV.setVisibility(8);
        this.bHR.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.cUW != null && linkedList != null) {
            apy();
            this.cUW.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void apz() {
        if (this.cUR != null) {
            this.cUR.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cUW != null) {
            this.cUW.notifyDataSetChanged();
            if (this.cUW.getItemCount() > 0) {
                bF(true);
            } else {
                bF(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cUW != null) {
            this.cUW.notifyItemRemoved(i);
            if (this.cUW.getItemCount() == 0) {
                cy(false);
                bF(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.mTitle, f.d.cp_cont_d);
            am.j(this.bHR, f.d.cp_bg_line_e);
            am.h(this.cUU, f.d.cp_link_tip_a);
            apy();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cVa.setTag(bdUniqueId);
    }

    public void onDestroy() {
        if (this.cUZ != null) {
            this.cUZ.onDestroy();
        }
    }
}
