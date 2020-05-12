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
    private RecentlyVisitedForumModel gJl;
    private ImageView gJm;
    private TextView gJn;
    private RecyclerView gJo;
    private View gJp;
    private com.baidu.tieba.enterForum.a.c gJq;
    private ViewEventCenter gJr;
    private com.baidu.tieba.enterForum.home.e gJs;
    private k gJt;
    private a gJu;
    private View gmc;
    private com.baidu.tieba.enterForum.data.d gyZ;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean gIh = true;
    private boolean gzt = false;
    private CustomMessageListener gJv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gJt == null) {
                        f.this.gJt = new k(new i());
                    }
                    f.this.gJt.a(f.this.gJo, 1);
                } else if (f.this.gJt != null) {
                    f.this.gJt.pf();
                }
            }
        }
    };
    private CustomMessageListener evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bHu();
            }
        }
    };
    private CustomMessageListener gJw = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
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
        void bHw();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gJl = recentlyVisitedForumModel;
        this.gJr = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gJs = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gJv);
        MessageManager.getInstance().registerListener(this.evX);
        initData();
        initView();
    }

    private void initData() {
        this.gIh = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.gmc = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gJm = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bKf();
            }
        });
        this.gJn = (TextView) this.mRootView.findViewById(R.id.done);
        this.gJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.iB(false);
            }
        });
        this.gJp = this.mRootView.findViewById(R.id.gap);
        this.gJo = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gJq = new com.baidu.tieba.enterForum.a.c(this.mPageContext);
        this.gJo.setAdapter(this.gJq);
        this.gJo.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJt = new k(new i());
            this.gJt.a(this.gJo, 1);
        }
        this.gJo.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.gJo.setItemAnimator(new DefaultItemAnimator());
        this.gJo.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gJq.a(new c.b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.c.b
            public void a(c.a aVar) {
                if (!f.this.gzt && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aWA());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cI("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gJq.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.iB(true);
                return true;
            }
        });
        this.gJq.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gJl != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gJl.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cI("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gJl.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
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
                if (!z && f.this.gJs != null) {
                    f.this.gJs.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gJw);
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
            BarImageView barImageView = aVar.gzz;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.dIC;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.gzB;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bHu() {
        if (this.gzt) {
            iB(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (this.gzt != z && this.gJq != null) {
            this.gzt = z;
            if (this.gzt) {
                this.gJn.setVisibility(0);
                this.gJm.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gJr != null) {
                    this.gJr.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gJn.setVisibility(8);
                this.gJm.setVisibility(0);
                if (this.gJr != null) {
                    this.gJr.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gJq.iB(this.gzt);
        }
    }

    public boolean bKe() {
        return this.gzt;
    }

    public void bKf() {
        this.gIh = !this.gIh;
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_recently_visited_forum_extend_state", this.gIh);
        if (this.gIh) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bKh();
    }

    public boolean bKg() {
        return this.gIh;
    }

    private void bKh() {
        int i = R.color.white_alpha100;
        if (this.gIh) {
            this.gJo.setVisibility(0);
            this.gJp.setVisibility(8);
            if (this.gyZ == null || !this.gyZ.gzK) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aOR().a(this.gJm, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.gJo.setVisibility(8);
            this.gJp.setVisibility(0);
            if (this.gyZ == null || !this.gyZ.gzK) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aOR().a(this.gJm, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gJu != null) {
            this.gJu.bHw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.gmc.setVisibility(0);
            bKh();
        } else {
            this.gmc.setVisibility(8);
            this.gJo.setVisibility(8);
            this.gJp.setVisibility(8);
        }
        if (this.gJu != null) {
            this.gJu.bHw();
        }
    }

    public boolean isShow() {
        return this.gmc.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gJq != null && linkedList != null) {
            bKh();
            this.gJq.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bKi() {
        if (this.gJl != null) {
            this.gJl.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gJq != null) {
            this.gJq.notifyDataSetChanged();
            if (this.gJq.getItemCount() > 0) {
                hC(true);
            } else {
                hC(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gJq != null) {
            this.gJq.notifyItemRemoved(i);
            if (this.gJq.getItemCount() == 0) {
                iB(false);
                hC(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyZ = dVar;
        bKj();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bKj();
        }
    }

    private void bKj() {
        if (this.gyZ != null && this.gyZ.gzK) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gJn, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gJn.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gJn, (int) R.color.cp_link_tip_a);
            this.gJn.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bKh();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gJw.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJv);
        MessageManager.getInstance().unRegisterListener(this.evX);
        if (this.gJs != null) {
            this.gJs.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gJu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gJy;
        private int gJz;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gJy = i;
            this.gJz = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gJy;
                } else {
                    rect.top = this.gJz;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gJy;
            } else {
                rect.left = this.gJz;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.d bKk() {
        return this.gyZ;
    }
}
