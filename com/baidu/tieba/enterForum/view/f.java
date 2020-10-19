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
    private View hCm;
    private com.baidu.tieba.enterForum.data.c hPu;
    private RecentlyVisitedForumModel hZD;
    private ImageView hZE;
    private TextView hZF;
    private RecyclerView hZG;
    private View hZH;
    private com.baidu.tieba.enterForum.a.b hZI;
    private ViewEventCenter hZJ;
    private com.baidu.tieba.enterForum.home.e hZK;
    private n hZL;
    private a hZM;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hYv = true;
    private boolean hPF = false;
    private CustomMessageListener hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hZL == null) {
                        f.this.hZL = new n(new l());
                    }
                    f.this.hZL.a(f.this.hZG, 1);
                } else if (f.this.hZL != null) {
                    f.this.hZL.rh();
                }
            }
        }
    };
    private CustomMessageListener hZO = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cle();
            }
        }
    };
    private CustomMessageListener hZP = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.jH(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void clg();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hZD = recentlyVisitedForumModel;
        this.hZJ = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hZK = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hZN);
        MessageManager.getInstance().registerListener(this.hZO);
        initData();
        initView();
    }

    private void initData() {
        this.hYv = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hCm = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hZE = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cnY();
            }
        });
        this.hZF = (TextView) this.mRootView.findViewById(R.id.done);
        this.hZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.kN(false);
            }
        });
        this.hZH = this.mRootView.findViewById(R.id.gap);
        this.hZG = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hZI = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hZG.setAdapter(this.hZI);
        this.hZG.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hZL = new n(new l());
            this.hZL.a(this.hZG, 1);
        }
        this.hZG.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hZG.setItemAnimator(new DefaultItemAnimator());
        this.hZG.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hZI.a(new b.InterfaceC0682b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0682b
            public void a(b.a aVar) {
                if (!f.this.hPF && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.buM());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dK("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hZI.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.kN(true);
                return true;
            }
        });
        this.hZI.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hZD != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hZD.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dK("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hZD.a(new a.InterfaceC0683a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0683a
            public void xb(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0683a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0683a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.hZK != null) {
                    f.this.hZK.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hZP);
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
            BarImageView barImageView = aVar.hPL;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.eIK;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.hPN;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cle() {
        if (this.hPF) {
            kN(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(boolean z) {
        if (this.hPF != z && this.hZI != null) {
            this.hPF = z;
            if (this.hPF) {
                this.hZF.setVisibility(0);
                this.hZE.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hZJ != null) {
                    this.hZJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hZF.setVisibility(8);
                this.hZE.setVisibility(0);
                if (this.hZJ != null) {
                    this.hZJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hZI.kN(this.hPF);
        }
    }

    public boolean cnX() {
        return this.hPF;
    }

    public void cnY() {
        this.hYv = !this.hYv;
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_recently_visited_forum_extend_state", this.hYv);
        if (this.hYv) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        coa();
    }

    public boolean cnZ() {
        return this.hYv;
    }

    private void coa() {
        int i;
        int i2;
        if (this.hYv) {
            this.hZG.setVisibility(0);
            this.hZH.setVisibility(8);
            if (this.hPu != null && this.hPu.hPW) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.bmU().a(this.hZE, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hZG.setVisibility(8);
            this.hZH.setVisibility(0);
            if (this.hPu != null && this.hPu.hPW) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.bmU().a(this.hZE, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hZM != null) {
            this.hZM.clg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jH(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hCm.setVisibility(0);
            coa();
        } else {
            this.hCm.setVisibility(8);
            this.hZG.setVisibility(8);
            this.hZH.setVisibility(8);
        }
        if (this.hZM != null) {
            this.hZM.clg();
        }
    }

    public boolean isShow() {
        return this.hCm.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hZI != null && linkedList != null) {
            coa();
            this.hZI.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cob() {
        if (this.hZD != null) {
            this.hZD.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hZI != null) {
            this.hZI.notifyDataSetChanged();
            if (this.hZI.getItemCount() > 0) {
                jH(true);
            } else {
                jH(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hZI != null) {
            this.hZI.notifyItemRemoved(i);
            if (this.hZI.getItemCount() == 0) {
                kN(false);
                jH(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hPu = cVar;
        coc();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            coc();
        }
    }

    private void coc() {
        if (this.hPu != null && this.hPu.hPW) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.hZF, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.hZF.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hZF, R.color.cp_link_tip_a);
            this.hZF.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        coa();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hZP.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hZN);
        MessageManager.getInstance().unRegisterListener(this.hZO);
        if (this.hZK != null) {
            this.hZK.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hZM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Xk;
        private int Xl;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Xk = i;
            this.Xl = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Xk;
                } else {
                    rect.top = this.Xl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Xk;
            } else {
                rect.left = this.Xl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cod() {
        return this.hPu;
    }
}
