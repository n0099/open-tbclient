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
/* loaded from: classes22.dex */
public class f {
    private RecentlyVisitedForumModel iDK;
    private ImageView iDL;
    private TextView iDM;
    private RecyclerView iDN;
    private View iDO;
    private com.baidu.tieba.enterForum.a.b iDP;
    private ViewEventCenter iDQ;
    private com.baidu.tieba.enterForum.home.e iDR;
    private n iDS;
    private a iDT;
    private View ige;
    private com.baidu.tieba.enterForum.data.c itB;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean iCB = true;
    private boolean itM = false;
    private CustomMessageListener iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iDS == null) {
                        f.this.iDS = new n(new l());
                    }
                    f.this.iDS.a(f.this.iDN, 1);
                } else if (f.this.iDS != null) {
                    f.this.iDS.rj();
                }
            }
        }
    };
    private CustomMessageListener iDV = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cuE();
            }
        }
    };
    private CustomMessageListener iDW = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.ku(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void cuG();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iDK = recentlyVisitedForumModel;
        this.iDQ = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iDR = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iDU);
        MessageManager.getInstance().registerListener(this.iDV);
        initData();
        initView();
    }

    private void initData() {
        this.iCB = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.ige = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iDL = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cxz();
            }
        });
        this.iDM = (TextView) this.mRootView.findViewById(R.id.done);
        this.iDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.lF(false);
            }
        });
        this.iDO = this.mRootView.findViewById(R.id.gap);
        this.iDN = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iDP = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.iDN.setAdapter(this.iDP);
        this.iDN.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDS = new n(new l());
            this.iDS.a(this.iDN, 1);
        }
        this.iDN.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iDN.setItemAnimator(new DefaultItemAnimator());
        this.iDN.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iDP.a(new b.InterfaceC0729b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0729b
            public void a(b.a aVar) {
                if (!f.this.itM && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bBU());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dY("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iDP.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.lF(true);
                return true;
            }
        });
        this.iDP.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iDK != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iDK.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dY("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iDK.a(new a.InterfaceC0730a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0730a
            public void yK(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0730a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0730a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iDR != null) {
                    f.this.iDR.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iDW);
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
            BarImageView barImageView = aVar.itS;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.fdz;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.itU;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cuE() {
        if (this.itM) {
            lF(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (this.itM != z && this.iDP != null) {
            this.itM = z;
            if (this.itM) {
                this.iDM.setVisibility(0);
                this.iDL.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.iDQ != null) {
                    this.iDQ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iDM.setVisibility(8);
                this.iDL.setVisibility(0);
                if (this.iDQ != null) {
                    this.iDQ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iDP.lF(this.itM);
        }
    }

    public boolean cxy() {
        return this.itM;
    }

    public void cxz() {
        this.iCB = !this.iCB;
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_recently_visited_forum_extend_state", this.iCB);
        if (this.iCB) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        cxB();
    }

    public boolean cxA() {
        return this.iCB;
    }

    private void cxB() {
        int i;
        int i2;
        if (this.iCB) {
            this.iDN.setVisibility(0);
            this.iDO.setVisibility(8);
            if (this.itB != null && this.itB.iud) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.btW().a(this.iDL, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iDN.setVisibility(8);
            this.iDO.setVisibility(0);
            if (this.itB != null && this.itB.iud) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.btW().a(this.iDL, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iDT != null) {
            this.iDT.cuG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.ige.setVisibility(0);
            cxB();
        } else {
            this.ige.setVisibility(8);
            this.iDN.setVisibility(8);
            this.iDO.setVisibility(8);
        }
        if (this.iDT != null) {
            this.iDT.cuG();
        }
    }

    public boolean isShow() {
        return this.ige.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iDP != null && linkedList != null) {
            cxB();
            this.iDP.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cxC() {
        if (this.iDK != null) {
            this.iDK.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iDP != null) {
            this.iDP.notifyDataSetChanged();
            if (this.iDP.getItemCount() > 0) {
                ku(true);
            } else {
                ku(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iDP != null) {
            this.iDP.notifyItemRemoved(i);
            if (this.iDP.getItemCount() == 0) {
                lF(false);
                ku(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itB = cVar;
        cxD();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cxD();
        }
    }

    private void cxD() {
        if (this.itB != null && this.itB.iud) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.iDM, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iDM.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.iDM, R.color.CAM_X0302);
            this.iDM.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cxB();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iDW.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDU);
        MessageManager.getInstance().unRegisterListener(this.iDV);
        if (this.iDR != null) {
            this.iDR.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iDT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Ym;
        private int Yn;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Ym = i;
            this.Yn = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Ym;
                } else {
                    rect.top = this.Yn;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Ym;
            } else {
                rect.left = this.Yn;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cxE() {
        return this.itB;
    }
}
