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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private View bwn;
    private View cJR;
    private RecentlyVisitedForumModel cJS;
    private Vibrator cJT;
    private ImageView cJU;
    private TextView cJV;
    private RecyclerView cJW;
    private com.baidu.tieba.enterForum.a.d cJX;
    private ViewEventCenter cJZ;
    private com.baidu.tieba.enterForum.home.c cKa;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cJY = true;
    private boolean cGV = false;

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cJS = recentlyVisitedForumModel;
        this.cJZ = viewEventCenter;
        this.cJT = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cKa = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initView();
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_layout, (ViewGroup) null);
        this.cJR = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cJU = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cJU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.alw();
            }
        });
        this.cJV = (TextView) this.mRootView.findViewById(d.g.done);
        this.cJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.co(false);
            }
        });
        this.bwn = this.mRootView.findViewById(d.g.divider);
        this.cJW = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cJX = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cJW.setAdapter(this.cJX);
        this.cJW.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cJW.setItemAnimator(new DefaultItemAnimator());
        this.cJW.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds56);
            }
        });
        this.cJX.k(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!d.this.cGV && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED)));
                    TiebaStatic.log(new al("c13002").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cJX.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                d.this.co(true);
                return true;
            }
        });
        this.cJX.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.cJS != null && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.cJS.d(visitedForumData);
                    TiebaStatic.log(new al("c13005").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cJS.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jx(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void akV() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.o(linkedList);
                if (!z && d.this.cKa != null) {
                    d.this.cKa.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean akq() {
        if (this.cGV) {
            co(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (this.cGV != z && this.cJX != null) {
            this.cGV = z;
            if (this.cGV) {
                this.cJV.setVisibility(0);
                this.cJU.setVisibility(8);
                if (this.cJT != null) {
                    this.cJT.vibrate(10L);
                }
                if (this.cJZ != null) {
                    this.cJZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cJV.setVisibility(8);
                this.cJU.setVisibility(0);
                if (this.cJZ != null) {
                    this.cJZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cJX.co(this.cGV);
        }
    }

    public void alw() {
        this.cJY = !this.cJY;
        if (this.cJY) {
            TiebaStatic.log(new al("c13003"));
        } else {
            TiebaStatic.log(new al("c13004"));
        }
        alx();
    }

    private void alx() {
        if (this.cJY) {
            this.cJW.setVisibility(0);
            this.bwn.setVisibility(0);
            ak.c(this.cJU, d.f.icon_ba_show);
            return;
        }
        this.cJW.setVisibility(8);
        this.bwn.setVisibility(8);
        ak.c(this.cJU, d.f.icon_ba_hide);
    }

    private void bz(boolean z) {
        if (z) {
            this.cJR.setVisibility(0);
            alx();
            return;
        }
        this.cJR.setVisibility(8);
        this.cJW.setVisibility(8);
        this.bwn.setVisibility(8);
    }

    public void o(LinkedList<VisitedForumData> linkedList) {
        if (this.cJX != null && linkedList != null) {
            alx();
            this.cJX.m(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aly() {
        if (this.cJS != null) {
            this.cJS.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cJX != null) {
            this.cJX.notifyDataSetChanged();
            if (this.cJX.getItemCount() > 0) {
                bz(true);
            } else {
                bz(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cJX != null) {
            this.cJX.notifyItemRemoved(i);
            if (this.cJX.getItemCount() == 0) {
                co(false);
                bz(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.h(this.mTitle, d.C0126d.cp_cont_d);
            ak.j(this.bwn, d.C0126d.cp_bg_line_e);
            ak.h(this.cJV, d.C0126d.cp_link_tip_a);
            alx();
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cKa != null) {
            this.cKa.onDestroy();
        }
    }
}
