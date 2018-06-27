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
    private View bHc;
    private View cSh;
    private RecentlyVisitedForumModel cSi;
    private Vibrator cSj;
    private ImageView cSk;
    private TextView cSl;
    private RecyclerView cSm;
    private com.baidu.tieba.enterForum.a.d cSn;
    private ViewEventCenter cSp;
    private com.baidu.tieba.enterForum.home.c cSq;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean cSo = true;
    private boolean cPg = false;
    private CustomMessageListener cSr = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.bG(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.cSi = recentlyVisitedForumModel;
        this.cSp = viewEventCenter;
        this.cSj = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.cSq = new com.baidu.tieba.enterForum.home.c(tbPageContext);
        initData();
        initView();
    }

    private void initData() {
        this.cSo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_layout, (ViewGroup) null);
        this.cSh = this.mRootView.findViewById(d.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.cSk = (ImageView) this.mRootView.findViewById(d.g.extend_image);
        this.cSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.aoW();
            }
        });
        this.cSl = (TextView) this.mRootView.findViewById(d.g.done);
        this.cSl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cx(false);
            }
        });
        this.bHc = this.mRootView.findViewById(d.g.divider);
        this.cSm = (RecyclerView) this.mRootView.findViewById(d.g.list);
        this.cSn = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.cSm.setAdapter(this.cSn);
        this.cSm.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.cSm.setItemAnimator(new DefaultItemAnimator());
        this.cSm.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds27);
            }
        });
        this.cSn.l(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.cPg && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new an("c13002").ah(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cSn.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.cx(true);
                return true;
            }
        });
        this.cSn.m(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cSi != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.cSi.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").ah(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.cSi.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void jx(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void aow() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
                if (!z && d.this.cSq != null) {
                    d.this.cSq.d(linkedList, d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds678) + d.this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.cSr);
    }

    public boolean anQ() {
        if (this.cPg) {
            cx(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (this.cPg != z && this.cSn != null) {
            this.cPg = z;
            if (this.cPg) {
                this.cSl.setVisibility(0);
                this.cSk.setVisibility(8);
                if (this.cSj != null) {
                    this.cSj.vibrate(10L);
                }
                if (this.cSp != null) {
                    this.cSp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.cSl.setVisibility(8);
                this.cSk.setVisibility(0);
                if (this.cSp != null) {
                    this.cSp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.cSn.cx(this.cPg);
        }
    }

    public void aoW() {
        this.cSo = !this.cSo;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.cSo);
        if (this.cSo) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        aoX();
    }

    private void aoX() {
        if (this.cSo) {
            this.cSm.setVisibility(0);
            this.bHc.setVisibility(0);
            am.c(this.cSk, d.f.icon_ba_show);
            return;
        }
        this.cSm.setVisibility(8);
        this.bHc.setVisibility(8);
        am.c(this.cSk, d.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.cSh.setVisibility(0);
            aoX();
            return;
        }
        this.cSh.setVisibility(8);
        this.cSm.setVisibility(8);
        this.bHc.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.cSn != null && linkedList != null) {
            aoX();
            this.cSn.k(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aoY() {
        if (this.cSi != null) {
            this.cSi.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.cSn != null) {
            this.cSn.notifyDataSetChanged();
            if (this.cSn.getItemCount() > 0) {
                bG(true);
            } else {
                bG(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.cSn != null) {
            this.cSn.notifyItemRemoved(i);
            if (this.cSn.getItemCount() == 0) {
                cx(false);
                bG(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.mTitle, d.C0142d.cp_cont_d);
            am.j(this.bHc, d.C0142d.cp_bg_line_e);
            am.h(this.cSl, d.C0142d.cp_link_tip_a);
            aoX();
            notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cSq != null) {
            this.cSq.onDestroy();
        }
    }
}
