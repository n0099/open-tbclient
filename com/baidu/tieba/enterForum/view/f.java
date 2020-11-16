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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.c.a;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class f {
    private View hVf;
    private com.baidu.tieba.enterForum.data.c iiG;
    private RecentlyVisitedForumModel isQ;
    private ImageView isR;
    private TextView isS;
    private RecyclerView isT;
    private View isU;
    private com.baidu.tieba.enterForum.a.b isV;
    private ViewEventCenter isW;
    private com.baidu.tieba.enterForum.home.e isX;
    private n isY;
    private a isZ;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean irH = true;
    private boolean iiR = false;
    private CustomMessageListener ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.isY == null) {
                        f.this.isY = new n(new l());
                    }
                    f.this.isY.a(f.this.isT, 1);
                } else if (f.this.isY != null) {
                    f.this.isY.rh();
                }
            }
        }
    };
    private CustomMessageListener itb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cqp();
            }
        }
    };
    private CustomMessageListener itc = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.ke(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void cqr();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.isQ = recentlyVisitedForumModel;
        this.isW = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.isX = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.ita);
        MessageManager.getInstance().registerListener(this.itb);
        initData();
        initView();
    }

    private void initData() {
        this.irH = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hVf = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.isR = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.isR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ctj();
            }
        });
        this.isS = (TextView) this.mRootView.findViewById(R.id.done);
        this.isS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.lk(false);
            }
        });
        this.isU = this.mRootView.findViewById(R.id.gap);
        this.isT = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.isV = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.isT.setAdapter(this.isV);
        this.isT.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isY = new n(new l());
            this.isY.a(this.isT, 1);
        }
        this.isT.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.isT.setItemAnimator(new DefaultItemAnimator());
        this.isT.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.isV.a(new b.InterfaceC0715b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0715b
            public void a(b.a aVar) {
                if (!f.this.iiR && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.byu());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.isV.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.lk(true);
                return true;
            }
        });
        this.isV.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.isQ != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.isQ.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.isQ.a(new a.InterfaceC0716a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0716a
            public void yf(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0716a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0716a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.isX != null) {
                    f.this.isX.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.itc);
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
            BarImageView barImageView = aVar.iiX;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.eWc;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.iiZ;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cqp() {
        if (this.iiR) {
            lk(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lk(boolean z) {
        if (this.iiR != z && this.isV != null) {
            this.iiR = z;
            if (this.iiR) {
                this.isS.setVisibility(0);
                this.isR.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.isW != null) {
                    this.isW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.isS.setVisibility(8);
                this.isR.setVisibility(0);
                if (this.isW != null) {
                    this.isW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.isV.lk(this.iiR);
        }
    }

    public boolean cti() {
        return this.iiR;
    }

    public void ctj() {
        this.irH = !this.irH;
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_recently_visited_forum_extend_state", this.irH);
        if (this.irH) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        ctl();
    }

    public boolean ctk() {
        return this.irH;
    }

    private void ctl() {
        int i;
        int i2;
        if (this.irH) {
            this.isT.setVisibility(0);
            this.isU.setVisibility(8);
            if (this.iiG != null && this.iiG.iji) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bqB().a(this.isR, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.isT.setVisibility(8);
            this.isU.setVisibility(0);
            if (this.iiG != null && this.iiG.iji) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bqB().a(this.isR, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.isZ != null) {
            this.isZ.cqr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hVf.setVisibility(0);
            ctl();
        } else {
            this.hVf.setVisibility(8);
            this.isT.setVisibility(8);
            this.isU.setVisibility(8);
        }
        if (this.isZ != null) {
            this.isZ.cqr();
        }
    }

    public boolean isShow() {
        return this.hVf.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.isV != null && linkedList != null) {
            ctl();
            this.isV.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ctm() {
        if (this.isQ != null) {
            this.isQ.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.isV != null) {
            this.isV.notifyDataSetChanged();
            if (this.isV.getItemCount() > 0) {
                ke(true);
            } else {
                ke(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.isV != null) {
            this.isV.notifyItemRemoved(i);
            if (this.isV.getItemCount() == 0) {
                lk(false);
                ke(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iiG = cVar;
        ctn();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ctn();
        }
    }

    private void ctn() {
        if (this.iiG != null && this.iiG.iji) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.isS, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.isS.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.isS, R.color.CAM_X0302);
            this.isS.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        ctl();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.itc.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ita);
        MessageManager.getInstance().unRegisterListener(this.itb);
        if (this.isX != null) {
            this.isX.onDestroy();
        }
    }

    public void a(a aVar) {
        this.isZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Xp;
        private int Xq;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Xp = i;
            this.Xq = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Xp;
                } else {
                    rect.top = this.Xq;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Xp;
            } else {
                rect.left = this.Xq;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cto() {
        return this.iiG;
    }
}
