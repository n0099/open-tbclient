package com.baidu.tieba.enterForum.view;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.enterForum.view.horizontalpullview.RefreshView;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class RecommendForumHorizontalView extends LinearLayout {
    private b.InterfaceC0600b gNT;
    private boolean gNU;
    private PullLeftRefreshLayout gYm;
    private com.baidu.tieba.enterForum.a.b gYn;
    private FrameLayout gYo;
    private ImageView gYp;
    private boolean gYq;
    private boolean gYr;
    private RefreshView gYs;
    View.OnClickListener gYt;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private String tabName;

    public RecommendForumHorizontalView(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumHorizontalView(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.gYq = true;
        this.gYr = false;
        this.mFrom = 0;
        this.gNT = new b.InterfaceC0600b() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.1
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0600b
            public void a(View view, k kVar) {
                if (kVar != null) {
                    String forumName = kVar.getForumName();
                    if (aq.isForumName(forumName)) {
                        RecommendForumHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RecommendForumHorizontalView.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        an anVar = new an("c13643");
                        anVar.s("uid", TbadkApplication.getCurrentAccountId());
                        anVar.s("fid", kVar.getForumId());
                        if (RecommendForumHorizontalView.this.mFrom != 0) {
                            if (RecommendForumHorizontalView.this.mFrom == 1) {
                                anVar.ag("obj_locate", 2);
                                anVar.dh("resource_id", RecommendForumHorizontalView.this.tabName);
                            }
                        } else {
                            anVar.ag("obj_locate", 1);
                            anVar.ag("obj_type", RecommendForumHorizontalView.this.gNU ? 4 : 1);
                        }
                        TiebaStatic.log(anVar);
                    }
                }
            }

            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0600b
            public void bM(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", RecommendForumHorizontalView.this.gNU ? 5 : 1);
                anVar.ag("obj_source", 5);
                TiebaStatic.log(anVar);
            }
        };
        this.gYt = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", RecommendForumHorizontalView.this.gNU ? 5 : 1);
                anVar.ag("obj_source", 2);
                TiebaStatic.log(anVar);
            }
        };
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gYo = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.gYp = (ImageView) findViewById(R.id.iv_into);
        this.gYm = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.gYn = new com.baidu.tieba.enterForum.a.b(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.gYn.setHasLikeForum(this.gNU);
        } else if (this.mFrom == 1) {
            this.gYn.setTabName(this.tabName);
        }
        this.gYn.a(this.gNT);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.gYn);
        this.mRecyclerView.setClipChildren(false);
        this.gYn.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.gYp.setOnClickListener(this.gYt);
        this.gYs = new RefreshView(getContext());
        this.gYm.setRefreshViewAndListener(this.gYs);
        this.gYm.setCallback(new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.3
            @Override // com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.a
            public void bQG() {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", RecommendForumHorizontalView.this.gNU ? 5 : 1);
                anVar.ag("obj_source", 4);
                TiebaStatic.log(anVar);
            }
        });
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.gYq = z;
    }

    public void setShowMore(boolean z) {
        this.gYr = z;
        if (this.gYm != null) {
            this.gYm.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void b(l lVar) {
        if (lVar != null && lVar.bOq() != null && lVar.bOq().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<k> bOq = lVar.bOq();
            if (this.gYq) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
                if (bOq != null) {
                    arrayList.addAll(bOq);
                }
            } else {
                if (bOq != null) {
                    arrayList.addAll(bOq);
                }
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
            }
            this.gYn.setData(arrayList);
        }
        if (this.mFrom == 0) {
            if (this.gYo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gYo.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.gYo.requestLayout();
            }
        } else if (this.gYo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gYo.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
            this.gYo.requestLayout();
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        SvgManager.aUV().a(this.gYp, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.gYs.onChangeSkinType();
        this.gYn.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.gNU = z;
    }
}
