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
    private RecentlyVisitedForumModel iDI;
    private ImageView iDJ;
    private TextView iDK;
    private RecyclerView iDL;
    private View iDM;
    private com.baidu.tieba.enterForum.a.b iDN;
    private ViewEventCenter iDO;
    private com.baidu.tieba.enterForum.home.e iDP;
    private n iDQ;
    private a iDR;
    private View igc;
    private com.baidu.tieba.enterForum.data.c itz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean iCz = true;
    private boolean itK = false;
    private CustomMessageListener iDS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iDQ == null) {
                        f.this.iDQ = new n(new l());
                    }
                    f.this.iDQ.a(f.this.iDL, 1);
                } else if (f.this.iDQ != null) {
                    f.this.iDQ.rj();
                }
            }
        }
    };
    private CustomMessageListener iDT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cuD();
            }
        }
    };
    private CustomMessageListener iDU = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
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
        void cuF();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iDI = recentlyVisitedForumModel;
        this.iDO = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iDP = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iDS);
        MessageManager.getInstance().registerListener(this.iDT);
        initData();
        initView();
    }

    private void initData() {
        this.iCz = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.igc = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iDJ = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cxy();
            }
        });
        this.iDK = (TextView) this.mRootView.findViewById(R.id.done);
        this.iDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.lF(false);
            }
        });
        this.iDM = this.mRootView.findViewById(R.id.gap);
        this.iDL = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iDN = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.iDL.setAdapter(this.iDN);
        this.iDL.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDQ = new n(new l());
            this.iDQ.a(this.iDL, 1);
        }
        this.iDL.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iDL.setItemAnimator(new DefaultItemAnimator());
        this.iDL.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iDN.a(new b.InterfaceC0729b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0729b
            public void a(b.a aVar) {
                if (!f.this.itK && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bBU());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dY("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iDN.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.lF(true);
                return true;
            }
        });
        this.iDN.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iDI != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iDI.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dY("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iDI.a(new a.InterfaceC0730a() { // from class: com.baidu.tieba.enterForum.view.f.8
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
                if (!z && f.this.iDP != null) {
                    f.this.iDP.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iDU);
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
            BarImageView barImageView = aVar.itQ;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.fdz;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.itS;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cuD() {
        if (this.itK) {
            lF(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (this.itK != z && this.iDN != null) {
            this.itK = z;
            if (this.itK) {
                this.iDK.setVisibility(0);
                this.iDJ.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.iDO != null) {
                    this.iDO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iDK.setVisibility(8);
                this.iDJ.setVisibility(0);
                if (this.iDO != null) {
                    this.iDO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iDN.lF(this.itK);
        }
    }

    public boolean cxx() {
        return this.itK;
    }

    public void cxy() {
        this.iCz = !this.iCz;
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_recently_visited_forum_extend_state", this.iCz);
        if (this.iCz) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        cxA();
    }

    public boolean cxz() {
        return this.iCz;
    }

    private void cxA() {
        int i;
        int i2;
        if (this.iCz) {
            this.iDL.setVisibility(0);
            this.iDM.setVisibility(8);
            if (this.itz != null && this.itz.iub) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.btW().a(this.iDJ, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iDL.setVisibility(8);
            this.iDM.setVisibility(0);
            if (this.itz != null && this.itz.iub) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.btW().a(this.iDJ, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iDR != null) {
            this.iDR.cuF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.igc.setVisibility(0);
            cxA();
        } else {
            this.igc.setVisibility(8);
            this.iDL.setVisibility(8);
            this.iDM.setVisibility(8);
        }
        if (this.iDR != null) {
            this.iDR.cuF();
        }
    }

    public boolean isShow() {
        return this.igc.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iDN != null && linkedList != null) {
            cxA();
            this.iDN.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cxB() {
        if (this.iDI != null) {
            this.iDI.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iDN != null) {
            this.iDN.notifyDataSetChanged();
            if (this.iDN.getItemCount() > 0) {
                ku(true);
            } else {
                ku(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iDN != null) {
            this.iDN.notifyItemRemoved(i);
            if (this.iDN.getItemCount() == 0) {
                lF(false);
                ku(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itz = cVar;
        cxC();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cxC();
        }
    }

    private void cxC() {
        if (this.itz != null && this.itz.iub) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.iDK, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iDK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.iDK, R.color.CAM_X0302);
            this.iDK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cxA();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iDU.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDS);
        MessageManager.getInstance().unRegisterListener(this.iDT);
        if (this.iDP != null) {
            this.iDP.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iDR = aVar;
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

    public com.baidu.tieba.enterForum.data.c cxD() {
        return this.itz;
    }
}
