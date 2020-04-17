package com.baidu.tieba.enterForum.view;

import android.content.Intent;
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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.c;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class f {
    private RecentlyVisitedForumModel gJf;
    private ImageView gJg;
    private TextView gJh;
    private RecyclerView gJi;
    private View gJj;
    private com.baidu.tieba.enterForum.a.c gJk;
    private ViewEventCenter gJl;
    private com.baidu.tieba.enterForum.home.e gJm;
    private k gJn;
    private a gJo;
    private View glW;
    private com.baidu.tieba.enterForum.data.d gyT;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean gIb = true;
    private boolean gzn = false;
    private CustomMessageListener gJp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gJn == null) {
                        f.this.gJn = new k(new i());
                    }
                    f.this.gJn.a(f.this.gJi, 1);
                } else if (f.this.gJn != null) {
                    f.this.gJn.pf();
                }
            }
        }
    };
    private CustomMessageListener evS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bHv();
            }
        }
    };
    private CustomMessageListener gJq = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.hC(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bHx();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gJf = recentlyVisitedForumModel;
        this.gJl = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gJm = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gJp);
        MessageManager.getInstance().registerListener(this.evS);
        initData();
        initView();
    }

    private void initData() {
        this.gIb = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.glW = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gJg = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gJg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bKg();
            }
        });
        this.gJh = (TextView) this.mRootView.findViewById(R.id.done);
        this.gJh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.iB(false);
            }
        });
        this.gJj = this.mRootView.findViewById(R.id.gap);
        this.gJi = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gJk = new com.baidu.tieba.enterForum.a.c(this.mPageContext);
        this.gJi.setAdapter(this.gJk);
        this.gJi.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJn = new k(new i());
            this.gJn.a(this.gJi, 1);
        }
        this.gJi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.gJi.setItemAnimator(new DefaultItemAnimator());
        this.gJi.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gJk.a(new c.b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.c.b
            public void a(c.a aVar) {
                if (!f.this.gzn && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aWC());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cI("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gJk.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.iB(true);
                return true;
            }
        });
        this.gJk.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gJf != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gJf.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cI("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gJf.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void sm(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.gJm != null) {
                    f.this.gJm.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gJq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.gzt;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.dIy;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.gzv;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bHv() {
        if (this.gzn) {
            iB(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (this.gzn != z && this.gJk != null) {
            this.gzn = z;
            if (this.gzn) {
                this.gJh.setVisibility(0);
                this.gJg.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gJl != null) {
                    this.gJl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gJh.setVisibility(8);
                this.gJg.setVisibility(0);
                if (this.gJl != null) {
                    this.gJl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gJk.iB(this.gzn);
        }
    }

    public boolean bKf() {
        return this.gzn;
    }

    public void bKg() {
        this.gIb = !this.gIb;
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_recently_visited_forum_extend_state", this.gIb);
        if (this.gIb) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bKi();
    }

    public boolean bKh() {
        return this.gIb;
    }

    private void bKi() {
        int i = R.color.white_alpha100;
        if (this.gIb) {
            this.gJi.setVisibility(0);
            this.gJj.setVisibility(8);
            if (this.gyT == null || !this.gyT.gzE) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aOU().a(this.gJg, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.gJi.setVisibility(8);
            this.gJj.setVisibility(0);
            if (this.gyT == null || !this.gyT.gzE) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aOU().a(this.gJg, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gJo != null) {
            this.gJo.bHx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.glW.setVisibility(0);
            bKi();
        } else {
            this.glW.setVisibility(8);
            this.gJi.setVisibility(8);
            this.gJj.setVisibility(8);
        }
        if (this.gJo != null) {
            this.gJo.bHx();
        }
    }

    public boolean isShow() {
        return this.glW.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gJk != null && linkedList != null) {
            bKi();
            this.gJk.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bKj() {
        if (this.gJf != null) {
            this.gJf.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gJk != null) {
            this.gJk.notifyDataSetChanged();
            if (this.gJk.getItemCount() > 0) {
                hC(true);
            } else {
                hC(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gJk != null) {
            this.gJk.notifyItemRemoved(i);
            if (this.gJk.getItemCount() == 0) {
                iB(false);
                hC(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyT = dVar;
        bKk();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bKk();
        }
    }

    private void bKk() {
        if (this.gyT != null && this.gyT.gzE) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gJh, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gJh.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gJh, (int) R.color.cp_link_tip_a);
            this.gJh.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bKi();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gJq.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJp);
        MessageManager.getInstance().unRegisterListener(this.evS);
        if (this.gJm != null) {
            this.gJm.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gJo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gJs;
        private int gJt;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gJs = i;
            this.gJt = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gJs;
                } else {
                    rect.top = this.gJt;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gJs;
            } else {
                rect.left = this.gJt;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.d bKl() {
        return this.gyT;
    }
}
