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
    private View hUF;
    private com.baidu.tieba.enterForum.data.c ihS;
    private RecentlyVisitedForumModel isc;
    private ImageView isd;
    private TextView ise;
    private RecyclerView isf;
    private View isg;
    private com.baidu.tieba.enterForum.a.b ish;
    private ViewEventCenter isi;
    private com.baidu.tieba.enterForum.home.e isj;
    private n isk;
    private a isl;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean iqU = true;
    private boolean iid = false;
    private CustomMessageListener ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.isk == null) {
                        f.this.isk = new n(new l());
                    }
                    f.this.isk.a(f.this.isf, 1);
                } else if (f.this.isk != null) {
                    f.this.isk.rh();
                }
            }
        }
    };
    private CustomMessageListener isn = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cqM();
            }
        }
    };
    private CustomMessageListener iso = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.kd(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void cqO();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.isc = recentlyVisitedForumModel;
        this.isi = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.isj = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.ism);
        MessageManager.getInstance().registerListener(this.isn);
        initData();
        initView();
    }

    private void initData() {
        this.iqU = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hUF = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.isd = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.isd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ctG();
            }
        });
        this.ise = (TextView) this.mRootView.findViewById(R.id.done);
        this.ise.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.lj(false);
            }
        });
        this.isg = this.mRootView.findViewById(R.id.gap);
        this.isf = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.ish = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.isf.setAdapter(this.ish);
        this.isf.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isk = new n(new l());
            this.isk.a(this.isf, 1);
        }
        this.isf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.isf.setItemAnimator(new DefaultItemAnimator());
        this.isf.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.ish.a(new b.InterfaceC0712b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0712b
            public void a(b.a aVar) {
                if (!f.this.iid && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bze());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.ish.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.lj(true);
                return true;
            }
        });
        this.ish.w(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.isc != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.isc.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.isc.a(new a.InterfaceC0713a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0713a
            public void xH(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0713a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0713a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.isj != null) {
                    f.this.isj.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iso);
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
            BarImageView barImageView = aVar.iij;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.eWV;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.iil;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cqM() {
        if (this.iid) {
            lj(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (this.iid != z && this.ish != null) {
            this.iid = z;
            if (this.iid) {
                this.ise.setVisibility(0);
                this.isd.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.isi != null) {
                    this.isi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.ise.setVisibility(8);
                this.isd.setVisibility(0);
                if (this.isi != null) {
                    this.isi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.ish.lj(this.iid);
        }
    }

    public boolean ctF() {
        return this.iid;
    }

    public void ctG() {
        this.iqU = !this.iqU;
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_recently_visited_forum_extend_state", this.iqU);
        if (this.iqU) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        ctI();
    }

    public boolean ctH() {
        return this.iqU;
    }

    private void ctI() {
        int i;
        int i2;
        if (this.iqU) {
            this.isf.setVisibility(0);
            this.isg.setVisibility(8);
            if (this.ihS != null && this.ihS.iiu) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.brn().a(this.isd, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.isf.setVisibility(8);
            this.isg.setVisibility(0);
            if (this.ihS != null && this.ihS.iiu) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.brn().a(this.isd, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.isl != null) {
            this.isl.cqO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hUF.setVisibility(0);
            ctI();
        } else {
            this.hUF.setVisibility(8);
            this.isf.setVisibility(8);
            this.isg.setVisibility(8);
        }
        if (this.isl != null) {
            this.isl.cqO();
        }
    }

    public boolean isShow() {
        return this.hUF.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.ish != null && linkedList != null) {
            ctI();
            this.ish.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ctJ() {
        if (this.isc != null) {
            this.isc.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.ish != null) {
            this.ish.notifyDataSetChanged();
            if (this.ish.getItemCount() > 0) {
                kd(true);
            } else {
                kd(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.ish != null) {
            this.ish.notifyItemRemoved(i);
            if (this.ish.getItemCount() == 0) {
                lj(false);
                kd(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ihS = cVar;
        ctK();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ctK();
        }
    }

    private void ctK() {
        if (this.ihS != null && this.ihS.iiu) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.ise, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.ise.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.ise, R.color.cp_link_tip_a);
            this.ise.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        ctI();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iso.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ism);
        MessageManager.getInstance().unRegisterListener(this.isn);
        if (this.isj != null) {
            this.isj.onDestroy();
        }
    }

    public void a(a aVar) {
        this.isl = aVar;
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

    public com.baidu.tieba.enterForum.data.c ctL() {
        return this.ihS;
    }
}
