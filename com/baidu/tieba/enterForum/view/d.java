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
    private View dka;
    private RecentlyVisitedForumModel dkb;
    private ImageView dkc;
    private TextView dkd;
    private RecyclerView dke;
    private com.baidu.tieba.enterForum.a.d dkf;
    private ViewEventCenter dkh;
    private com.baidu.tieba.enterForum.home.c dki;
    private View mDivider;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean dkg = true;
    private boolean dgZ = false;
    private CustomMessageListener dkj = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.cr(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.dkb = recentlyVisitedForumModel;
        this.dkh = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.dki = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.dkg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_layout, (ViewGroup) null);
        this.dka = this.mRootView.findViewById(e.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.title);
        this.dkc = (ImageView) this.mRootView.findViewById(e.g.extend_image);
        this.dkc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aug();
            }
        });
        this.dkd = (TextView) this.mRootView.findViewById(e.g.done);
        this.dkd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dp(false);
            }
        });
        this.mDivider = this.mRootView.findViewById(e.g.divider);
        this.dke = (RecyclerView) this.mRootView.findViewById(e.g.list);
        this.dkf = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.dke.setAdapter(this.dkf);
        this.dke.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.dke.setItemAnimator(new DefaultItemAnimator());
        this.dke.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(e.C0200e.tbds27);
            }
        });
        this.dkf.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dgZ && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new am("c13002").ax(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dkf.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.dp(true);
                return true;
            }
        });
        this.dkf.o(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dkb != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.dkb.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").ax(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dkb.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void kX(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.dki != null) {
                    d.this.dki.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.dkj);
    }

    public boolean ata() {
        if (this.dgZ) {
            dp(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(boolean z) {
        if (this.dgZ != z && this.dkf != null) {
            this.dgZ = z;
            if (this.dgZ) {
                this.dkd.setVisibility(0);
                this.dkc.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.dkh != null) {
                    this.dkh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.dkd.setVisibility(8);
                this.dkc.setVisibility(0);
                if (this.dkh != null) {
                    this.dkh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.dkf.dp(this.dgZ);
        }
    }

    public void aug() {
        this.dkg = !this.dkg;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.dkg);
        if (this.dkg) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        auh();
    }

    private void auh() {
        if (this.dkg) {
            this.dke.setVisibility(0);
            this.mDivider.setVisibility(0);
            al.c(this.dkc, e.f.icon_ba_show);
            return;
        }
        this.dke.setVisibility(8);
        this.mDivider.setVisibility(8);
        al.c(this.dkc, e.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.dka.setVisibility(0);
            auh();
            return;
        }
        this.dka.setVisibility(8);
        this.dke.setVisibility(8);
        this.mDivider.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.dkf != null && linkedList != null) {
            auh();
            this.dkf.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aui() {
        if (this.dkb != null) {
            this.dkb.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.dkf != null) {
            this.dkf.notifyDataSetChanged();
            if (this.dkf.getItemCount() > 0) {
                cr(true);
            } else {
                cr(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.dkf != null) {
            this.dkf.notifyItemRemoved(i);
            if (this.dkf.getItemCount() == 0) {
                dp(false);
                cr(false);
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
            al.h(this.dkd, e.d.cp_link_tip_a);
            auh();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dkj.setTag(bdUniqueId);
    }

    public void onDestroy() {
        if (this.dki != null) {
            this.dki.onDestroy();
        }
    }
}
