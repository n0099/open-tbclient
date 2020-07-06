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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class f {
    private View gNO;
    private com.baidu.tieba.enterForum.data.c haQ;
    private RecentlyVisitedForumModel hkY;
    private ImageView hkZ;
    private TextView hla;
    private RecyclerView hlb;
    private View hlc;
    private com.baidu.tieba.enterForum.a.b hld;
    private ViewEventCenter hle;
    private com.baidu.tieba.enterForum.home.e hlf;
    private n hlg;
    private a hlh;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hjT = true;
    private boolean hbb = false;
    private CustomMessageListener hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hlg == null) {
                        f.this.hlg = new n(new l());
                    }
                    f.this.hlg.a(f.this.hlb, 1);
                } else if (f.this.hlg != null) {
                    f.this.hlg.pC();
                }
            }
        }
    };
    private CustomMessageListener eUW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bQV();
            }
        }
    };
    private CustomMessageListener hlj = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.ih(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bQX();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hkY = recentlyVisitedForumModel;
        this.hle = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hlf = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hli);
        MessageManager.getInstance().registerListener(this.eUW);
        initData();
        initView();
    }

    private void initData() {
        this.hjT = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.gNO = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hkZ = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hkZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bTG();
            }
        });
        this.hla = (TextView) this.mRootView.findViewById(R.id.done);
        this.hla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.jk(false);
            }
        });
        this.hlc = this.mRootView.findViewById(R.id.gap);
        this.hlb = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hld = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hlb.setAdapter(this.hld);
        this.hlb.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hlg = new n(new l());
            this.hlg.a(this.hlb, 1);
        }
        this.hlb.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hlb.setItemAnimator(new DefaultItemAnimator());
        this.hlb.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hld.a(new b.InterfaceC0608b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0608b
            public void a(b.a aVar) {
                if (!f.this.hbb && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.beM());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ao("c13002").dk("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hld.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.jk(true);
                return true;
            }
        });
        this.hld.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hkY != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hkY.d(visitedForumData);
                    TiebaStatic.log(new ao("c13005").dk("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hkY.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void tu(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.hlf != null) {
                    f.this.hlf.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hlj);
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
            BarImageView barImageView = aVar.hbh;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.een;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.hbj;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bQV() {
        if (this.hbb) {
            jk(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        if (this.hbb != z && this.hld != null) {
            this.hbb = z;
            if (this.hbb) {
                this.hla.setVisibility(0);
                this.hkZ.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hle != null) {
                    this.hle.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hla.setVisibility(8);
                this.hkZ.setVisibility(0);
                if (this.hle != null) {
                    this.hle.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hld.jk(this.hbb);
        }
    }

    public boolean bTF() {
        return this.hbb;
    }

    public void bTG() {
        this.hjT = !this.hjT;
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_recently_visited_forum_extend_state", this.hjT);
        if (this.hjT) {
            TiebaStatic.log(new ao("c13003"));
        } else {
            TiebaStatic.log(new ao("c13004"));
        }
        bTI();
    }

    public boolean bTH() {
        return this.hjT;
    }

    private void bTI() {
        int i = R.color.white_alpha100;
        if (this.hjT) {
            this.hlb.setVisibility(0);
            this.hlc.setVisibility(8);
            if (this.haQ == null || !this.haQ.hbs) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aWQ().a(this.hkZ, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hlb.setVisibility(8);
            this.hlc.setVisibility(0);
            if (this.haQ == null || !this.haQ.hbs) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aWQ().a(this.hkZ, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hlh != null) {
            this.hlh.bQX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.gNO.setVisibility(0);
            bTI();
        } else {
            this.gNO.setVisibility(8);
            this.hlb.setVisibility(8);
            this.hlc.setVisibility(8);
        }
        if (this.hlh != null) {
            this.hlh.bQX();
        }
    }

    public boolean isShow() {
        return this.gNO.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hld != null && linkedList != null) {
            bTI();
            this.hld.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bTJ() {
        if (this.hkY != null) {
            this.hkY.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hld != null) {
            this.hld.notifyDataSetChanged();
            if (this.hld.getItemCount() > 0) {
                ih(true);
            } else {
                ih(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hld != null) {
            this.hld.notifyItemRemoved(i);
            if (this.hld.getItemCount() == 0) {
                jk(false);
                ih(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.haQ = cVar;
        bTK();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bTK();
        }
    }

    private void bTK() {
        if (this.haQ != null && this.haQ.hbs) {
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            an.a((View) this.hla, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.hla.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            an.setViewTextColor(this.hla, (int) R.color.cp_link_tip_a);
            this.hla.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bTI();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hlj.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hli);
        MessageManager.getInstance().unRegisterListener(this.eUW);
        if (this.hlf != null) {
            this.hlf.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hlh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Wi;
        private int Wj;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Wi = i;
            this.Wj = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Wi;
                } else {
                    rect.top = this.Wj;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Wi;
            } else {
                rect.left = this.Wj;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c bTL() {
        return this.haQ;
    }
}
