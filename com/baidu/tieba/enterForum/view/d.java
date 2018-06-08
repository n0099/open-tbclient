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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private View bFh;
    private View cUg;
    private RecentlyVisitedForumModel cUh;
    private Vibrator cUi;
    private ImageView cUj;
    private TextView cUk;
    private RecyclerView cUl;
    private com.baidu.tieba.enterForum.a.d cUm;
    private ViewEventCenter cUo;
    private com.baidu.tieba.enterForum.home.c cUp;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cUn = true;
    private boolean cRl = false;

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cUh = recentlyVisitedForumModel;
        this.cUo = viewEventCenter;
        this.cUi = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cUp = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.cUn = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_layout, (ViewGroup) null);
        this.cUg = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cUj = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cUj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.apC();
            }
        });
        this.cUk = (TextView) this.mRootView.findViewById(d.g.done);
        this.cUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ct(false);
            }
        });
        this.bFh = this.mRootView.findViewById(d.g.divider);
        this.cUl = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cUm = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cUl.setAdapter(this.cUm);
        this.cUl.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cUl.setItemAnimator(new DefaultItemAnimator());
        this.cUl.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds27);
            }
        });
        this.cUm.k(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cRl && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED)));
                    TiebaStatic.log(new am("c13002").ah(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cUm.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.ct(true);
                return true;
            }
        });
        this.cUm.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cUh != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.cUh.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").ah(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cUh.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jz(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void apb() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.o(linkedList);
                if (!z && d.this.cUp != null) {
                    d.this.cUp.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aow() {
        if (this.cRl) {
            ct(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(boolean z) {
        if (this.cRl != z && this.cUm != null) {
            this.cRl = z;
            if (this.cRl) {
                this.cUk.setVisibility(0);
                this.cUj.setVisibility(8);
                if (this.cUi != null) {
                    this.cUi.vibrate(10L);
                }
                if (this.cUo != null) {
                    this.cUo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cUk.setVisibility(8);
                this.cUj.setVisibility(0);
                if (this.cUo != null) {
                    this.cUo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cUm.ct(this.cRl);
        }
    }

    public void apC() {
        this.cUn = !this.cUn;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.cUn);
        if (this.cUn) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        apD();
    }

    private void apD() {
        if (this.cUn) {
            this.cUl.setVisibility(0);
            this.bFh.setVisibility(0);
            al.c(this.cUj, d.f.icon_ba_show);
            return;
        }
        this.cUl.setVisibility(8);
        this.bFh.setVisibility(8);
        al.c(this.cUj, d.f.icon_ba_hide);
    }

    private void bD(boolean z) {
        if (z) {
            this.cUg.setVisibility(0);
            apD();
            return;
        }
        this.cUg.setVisibility(8);
        this.cUl.setVisibility(8);
        this.bFh.setVisibility(8);
    }

    public void o(LinkedList<VisitedForumData> linkedList) {
        if (this.cUm != null && linkedList != null) {
            apD();
            this.cUm.m(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void apE() {
        if (this.cUh != null) {
            this.cUh.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cUm != null) {
            this.cUm.notifyDataSetChanged();
            if (this.cUm.getItemCount() > 0) {
                bD(true);
            } else {
                bD(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cUm != null) {
            this.cUm.notifyItemRemoved(i);
            if (this.cUm.getItemCount() == 0) {
                ct(false);
                bD(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.mTitle, d.C0141d.cp_cont_d);
            al.j(this.bFh, d.C0141d.cp_bg_line_e);
            al.h(this.cUk, d.C0141d.cp_link_tip_a);
            apD();
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cUp != null) {
            this.cUp.onDestroy();
        }
    }
}
