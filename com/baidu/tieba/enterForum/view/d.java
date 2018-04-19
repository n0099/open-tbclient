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
    private View cJU;
    private RecentlyVisitedForumModel cJV;
    private Vibrator cJW;
    private ImageView cJX;
    private TextView cJY;
    private RecyclerView cJZ;
    private com.baidu.tieba.enterForum.a.d cKa;
    private ViewEventCenter cKc;
    private com.baidu.tieba.enterForum.home.c cKd;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cKb = true;
    private boolean cGY = false;

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cJV = recentlyVisitedForumModel;
        this.cKc = viewEventCenter;
        this.cJW = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cKd = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initView();
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_layout, (ViewGroup) null);
        this.cJU = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cJX = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.alw();
            }
        });
        this.cJY = (TextView) this.mRootView.findViewById(d.g.done);
        this.cJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.co(false);
            }
        });
        this.bwn = this.mRootView.findViewById(d.g.divider);
        this.cJZ = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cKa = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cJZ.setAdapter(this.cKa);
        this.cJZ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cJZ.setItemAnimator(new DefaultItemAnimator());
        this.cJZ.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds56);
            }
        });
        this.cKa.k(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!d.this.cGY && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED)));
                    TiebaStatic.log(new al("c13002").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cKa.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                d.this.co(true);
                return true;
            }
        });
        this.cKa.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.cJV != null && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.cJV.d(visitedForumData);
                    TiebaStatic.log(new al("c13005").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cJV.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
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
                if (!z && d.this.cKd != null) {
                    d.this.cKd.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean akq() {
        if (this.cGY) {
            co(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (this.cGY != z && this.cKa != null) {
            this.cGY = z;
            if (this.cGY) {
                this.cJY.setVisibility(0);
                this.cJX.setVisibility(8);
                if (this.cJW != null) {
                    this.cJW.vibrate(10L);
                }
                if (this.cKc != null) {
                    this.cKc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cJY.setVisibility(8);
                this.cJX.setVisibility(0);
                if (this.cKc != null) {
                    this.cKc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cKa.co(this.cGY);
        }
    }

    public void alw() {
        this.cKb = !this.cKb;
        if (this.cKb) {
            TiebaStatic.log(new al("c13003"));
        } else {
            TiebaStatic.log(new al("c13004"));
        }
        alx();
    }

    private void alx() {
        if (this.cKb) {
            this.cJZ.setVisibility(0);
            this.bwn.setVisibility(0);
            ak.c(this.cJX, d.f.icon_ba_show);
            return;
        }
        this.cJZ.setVisibility(8);
        this.bwn.setVisibility(8);
        ak.c(this.cJX, d.f.icon_ba_hide);
    }

    private void bz(boolean z) {
        if (z) {
            this.cJU.setVisibility(0);
            alx();
            return;
        }
        this.cJU.setVisibility(8);
        this.cJZ.setVisibility(8);
        this.bwn.setVisibility(8);
    }

    public void o(LinkedList<VisitedForumData> linkedList) {
        if (this.cKa != null && linkedList != null) {
            alx();
            this.cKa.m(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aly() {
        if (this.cJV != null) {
            this.cJV.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cKa != null) {
            this.cKa.notifyDataSetChanged();
            if (this.cKa.getItemCount() > 0) {
                bz(true);
            } else {
                bz(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cKa != null) {
            this.cKa.notifyItemRemoved(i);
            if (this.cKa.getItemCount() == 0) {
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
            ak.h(this.cJY, d.C0126d.cp_link_tip_a);
            alx();
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cKd != null) {
            this.cKd.onDestroy();
        }
    }
}
