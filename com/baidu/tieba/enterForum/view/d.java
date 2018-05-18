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
    private View bxe;
    private View cLa;
    private RecentlyVisitedForumModel cLb;
    private Vibrator cLc;
    private ImageView cLd;
    private TextView cLe;
    private RecyclerView cLf;
    private com.baidu.tieba.enterForum.a.d cLg;
    private ViewEventCenter cLi;
    private com.baidu.tieba.enterForum.home.c cLj;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cLh = true;
    private boolean cIe = false;

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cLb = recentlyVisitedForumModel;
        this.cLi = viewEventCenter;
        this.cLc = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cLj = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initView();
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_layout, (ViewGroup) null);
        this.cLa = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cLd = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.alw();
            }
        });
        this.cLe = (TextView) this.mRootView.findViewById(d.g.done);
        this.cLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.co(false);
            }
        });
        this.bxe = this.mRootView.findViewById(d.g.divider);
        this.cLf = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cLg = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cLf.setAdapter(this.cLg);
        this.cLf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cLf.setItemAnimator(new DefaultItemAnimator());
        this.cLf.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds56);
            }
        });
        this.cLg.k(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!d.this.cIe && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED)));
                    TiebaStatic.log(new al("c13002").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cLg.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                d.this.co(true);
                return true;
            }
        });
        this.cLg.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.cLb != null && view2.getTag() != null && (view2.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
                    d.this.cLb.d(visitedForumData);
                    TiebaStatic.log(new al("c13005").ac(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cLb.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jw(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void akV() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.o(linkedList);
                if (!z && d.this.cLj != null) {
                    d.this.cLj.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean akq() {
        if (this.cIe) {
            co(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (this.cIe != z && this.cLg != null) {
            this.cIe = z;
            if (this.cIe) {
                this.cLe.setVisibility(0);
                this.cLd.setVisibility(8);
                if (this.cLc != null) {
                    this.cLc.vibrate(10L);
                }
                if (this.cLi != null) {
                    this.cLi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cLe.setVisibility(8);
                this.cLd.setVisibility(0);
                if (this.cLi != null) {
                    this.cLi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cLg.co(this.cIe);
        }
    }

    public void alw() {
        this.cLh = !this.cLh;
        if (this.cLh) {
            TiebaStatic.log(new al("c13003"));
        } else {
            TiebaStatic.log(new al("c13004"));
        }
        alx();
    }

    private void alx() {
        if (this.cLh) {
            this.cLf.setVisibility(0);
            this.bxe.setVisibility(0);
            ak.c(this.cLd, d.f.icon_ba_show);
            return;
        }
        this.cLf.setVisibility(8);
        this.bxe.setVisibility(8);
        ak.c(this.cLd, d.f.icon_ba_hide);
    }

    private void bz(boolean z) {
        if (z) {
            this.cLa.setVisibility(0);
            alx();
            return;
        }
        this.cLa.setVisibility(8);
        this.cLf.setVisibility(8);
        this.bxe.setVisibility(8);
    }

    public void o(LinkedList<VisitedForumData> linkedList) {
        if (this.cLg != null && linkedList != null) {
            alx();
            this.cLg.m(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aly() {
        if (this.cLb != null) {
            this.cLb.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cLg != null) {
            this.cLg.notifyDataSetChanged();
            if (this.cLg.getItemCount() > 0) {
                bz(true);
            } else {
                bz(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cLg != null) {
            this.cLg.notifyItemRemoved(i);
            if (this.cLg.getItemCount() == 0) {
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
            ak.j(this.bxe, d.C0126d.cp_bg_line_e);
            ak.h(this.cLe, d.C0126d.cp_link_tip_a);
            alx();
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cLj != null) {
            this.cLj.onDestroy();
        }
    }
}
