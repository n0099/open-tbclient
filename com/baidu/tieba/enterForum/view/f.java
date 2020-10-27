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
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.c.a;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class f {
    private View hOI;
    private com.baidu.tieba.enterForum.data.c ibR;
    private RecentlyVisitedForumModel imd;
    private ImageView ime;
    private TextView imf;
    private RecyclerView imh;
    private View imi;
    private com.baidu.tieba.enterForum.a.b imj;
    private ViewEventCenter imk;
    private com.baidu.tieba.enterForum.home.e iml;
    private n imm;
    private a imn;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean ikV = true;
    private boolean icc = false;
    private CustomMessageListener imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.imm == null) {
                        f.this.imm = new n(new l());
                    }
                    f.this.imm.a(f.this.imh, 1);
                } else if (f.this.imm != null) {
                    f.this.imm.rh();
                }
            }
        }
    };
    private CustomMessageListener imp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.col();
            }
        }
    };
    private CustomMessageListener imq = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.jU(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void con();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.imd = recentlyVisitedForumModel;
        this.imk = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iml = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.imo);
        MessageManager.getInstance().registerListener(this.imp);
        initData();
        initView();
    }

    private void initData() {
        this.ikV = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hOI = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.ime = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.ime.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.crf();
            }
        });
        this.imf = (TextView) this.mRootView.findViewById(R.id.done);
        this.imf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.la(false);
            }
        });
        this.imi = this.mRootView.findViewById(R.id.gap);
        this.imh = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.imj = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.imh.setAdapter(this.imj);
        this.imh.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.imm = new n(new l());
            this.imm.a(this.imh, 1);
        }
        this.imh.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.imh.setItemAnimator(new DefaultItemAnimator());
        this.imh.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.imj.a(new b.InterfaceC0698b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0698b
            public void a(b.a aVar) {
                if (!f.this.icc && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bwF());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.imj.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.la(true);
                return true;
            }
        });
        this.imj.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.imd != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.imd.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.imd.a(new a.InterfaceC0699a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0699a
            public void xu(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0699a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0699a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iml != null) {
                    f.this.iml.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.imq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.ici;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.eRg;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.ick;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean col() {
        if (this.icc) {
            la(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (this.icc != z && this.imj != null) {
            this.icc = z;
            if (this.icc) {
                this.imf.setVisibility(0);
                this.ime.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.imk != null) {
                    this.imk.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.imf.setVisibility(8);
                this.ime.setVisibility(0);
                if (this.imk != null) {
                    this.imk.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.imj.la(this.icc);
        }
    }

    public boolean cre() {
        return this.icc;
    }

    public void crf() {
        this.ikV = !this.ikV;
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_recently_visited_forum_extend_state", this.ikV);
        if (this.ikV) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        crh();
    }

    public boolean crg() {
        return this.ikV;
    }

    private void crh() {
        int i;
        int i2;
        if (this.ikV) {
            this.imh.setVisibility(0);
            this.imi.setVisibility(8);
            if (this.ibR != null && this.ibR.ict) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.boN().a(this.ime, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.imh.setVisibility(8);
            this.imi.setVisibility(0);
            if (this.ibR != null && this.ibR.ict) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.boN().a(this.ime, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.imn != null) {
            this.imn.con();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hOI.setVisibility(0);
            crh();
        } else {
            this.hOI.setVisibility(8);
            this.imh.setVisibility(8);
            this.imi.setVisibility(8);
        }
        if (this.imn != null) {
            this.imn.con();
        }
    }

    public boolean isShow() {
        return this.hOI.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.imj != null && linkedList != null) {
            crh();
            this.imj.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cri() {
        if (this.imd != null) {
            this.imd.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.imj != null) {
            this.imj.notifyDataSetChanged();
            if (this.imj.getItemCount() > 0) {
                jU(true);
            } else {
                jU(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.imj != null) {
            this.imj.notifyItemRemoved(i);
            if (this.imj.getItemCount() == 0) {
                la(false);
                jU(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ibR = cVar;
        crj();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            crj();
        }
    }

    private void crj() {
        if (this.ibR != null && this.ibR.ict) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.imf, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.imf.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.imf, R.color.cp_link_tip_a);
            this.imf.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        crh();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.imq.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.imo);
        MessageManager.getInstance().unRegisterListener(this.imp);
        if (this.iml != null) {
            this.iml.onDestroy();
        }
    }

    public void a(a aVar) {
        this.imn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Xl;
        private int Xm;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Xl = i;
            this.Xm = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Xl;
                } else {
                    rect.top = this.Xm;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Xl;
            } else {
                rect.left = this.Xm;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c crk() {
        return this.ibR;
    }
}
