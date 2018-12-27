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
    private View dtr;
    private RecentlyVisitedForumModel dts;
    private ImageView dtt;
    private TextView dtu;
    private RecyclerView dtv;
    private com.baidu.tieba.enterForum.a.d dtw;
    private ViewEventCenter dty;
    private View mDivider;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean dtx = true;
    private boolean dqy = false;
    private CustomMessageListener dtz = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.d.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.this.cs(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public d(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.dts = recentlyVisitedForumModel;
        this.dty = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        initData();
        initView();
    }

    private void initData() {
        this.dtx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_layout, (ViewGroup) null);
        this.dtr = this.mRootView.findViewById(e.g.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.title);
        this.dtt = (ImageView) this.mRootView.findViewById(e.g.extend_image);
        this.dtt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.awG();
            }
        });
        this.dtu = (TextView) this.mRootView.findViewById(e.g.done);
        this.dtu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dq(false);
            }
        });
        this.mDivider = this.mRootView.findViewById(e.g.divider);
        this.dtv = (RecyclerView) this.mRootView.findViewById(e.g.list);
        this.dtw = new com.baidu.tieba.enterForum.a.d(this.mPageContext);
        this.dtv.setAdapter(this.dtw);
        this.dtv.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.dtv.setItemAnimator(new DefaultItemAnimator());
        this.dtv.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.enterForum.view.d.3
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = d.this.mPageContext.getResources().getDimensionPixelOffset(e.C0210e.tbds27);
            }
        });
        this.dtw.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.dqy && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4)));
                    TiebaStatic.log(new am("c13002").aA(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dtw.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.d.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                d.this.dq(true);
                return true;
            }
        });
        this.dtw.o(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dts != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    d.this.dts.d(visitedForumData);
                    TiebaStatic.log(new am("c13005").aA(ImageViewerConfig.FORUM_ID, visitedForumData.getForumId()));
                }
            }
        });
        this.dts.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.d.7
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void lA(int i) {
                d.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                d.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                d.this.m(linkedList);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.dtz);
    }

    public boolean avB() {
        if (this.dqy) {
            dq(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.dqy != z && this.dtw != null) {
            this.dqy = z;
            if (this.dqy) {
                this.dtu.setVisibility(0);
                this.dtt.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.dty != null) {
                    this.dty.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.dtu.setVisibility(8);
                this.dtt.setVisibility(0);
                if (this.dty != null) {
                    this.dty.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.dtw.dq(this.dqy);
        }
    }

    public void awG() {
        this.dtx = !this.dtx;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_recently_visited_forum_extend_state", this.dtx);
        if (this.dtx) {
            TiebaStatic.log(new am("c13003"));
        } else {
            TiebaStatic.log(new am("c13004"));
        }
        awH();
    }

    private void awH() {
        if (this.dtx) {
            this.dtv.setVisibility(0);
            this.mDivider.setVisibility(0);
            al.c(this.dtt, e.f.icon_ba_show);
            return;
        }
        this.dtv.setVisibility(8);
        this.mDivider.setVisibility(8);
        al.c(this.dtt, e.f.icon_ba_hide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.dtr.setVisibility(0);
            awH();
            return;
        }
        this.dtr.setVisibility(8);
        this.dtv.setVisibility(8);
        this.mDivider.setVisibility(8);
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        if (this.dtw != null && linkedList != null) {
            awH();
            this.dtw.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void awI() {
        if (this.dts != null) {
            this.dts.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.dtw != null) {
            this.dtw.notifyDataSetChanged();
            if (this.dtw.getItemCount() > 0) {
                cs(true);
            } else {
                cs(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.dtw != null) {
            this.dtw.notifyItemRemoved(i);
            if (this.dtw.getItemCount() == 0) {
                dq(false);
                cs(false);
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
            al.h(this.dtu, e.d.cp_link_tip_a);
            awH();
            notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dtz.setTag(bdUniqueId);
    }
}
