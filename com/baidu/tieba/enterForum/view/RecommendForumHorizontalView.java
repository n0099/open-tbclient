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
    private PullLeftRefreshLayout gJA;
    private com.baidu.tieba.enterForum.a.b gJB;
    private FrameLayout gJC;
    private ImageView gJD;
    private boolean gJE;
    private boolean gJF;
    private RefreshView gJG;
    View.OnClickListener gJH;
    private b.InterfaceC0550b gzj;
    private boolean gzk;
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
        this.gJE = true;
        this.gJF = false;
        this.mFrom = 0;
        this.gzj = new b.InterfaceC0550b() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.1
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0550b
            public void a(View view, k kVar) {
                if (kVar != null) {
                    String forumName = kVar.getForumName();
                    if (aq.isForumName(forumName)) {
                        RecommendForumHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RecommendForumHorizontalView.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        an anVar = new an("c13643");
                        anVar.t("uid", TbadkApplication.getCurrentAccountId());
                        anVar.t("fid", kVar.getForumId());
                        if (RecommendForumHorizontalView.this.mFrom != 0) {
                            if (RecommendForumHorizontalView.this.mFrom == 1) {
                                anVar.af("obj_locate", 2);
                                anVar.cI("resource_id", RecommendForumHorizontalView.this.tabName);
                            }
                        } else {
                            anVar.af("obj_locate", 1);
                            anVar.af("obj_type", RecommendForumHorizontalView.this.gzk ? 4 : 1);
                        }
                        TiebaStatic.log(anVar);
                    }
                }
            }

            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0550b
            public void bN(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gzk ? 5 : 1);
                anVar.af("obj_source", 5);
                TiebaStatic.log(anVar);
            }
        };
        this.gJH = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gzk ? 5 : 1);
                anVar.af("obj_source", 2);
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
        this.gJC = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.gJD = (ImageView) findViewById(R.id.iv_into);
        this.gJA = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.gJB = new com.baidu.tieba.enterForum.a.b(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.gJB.setHasLikeForum(this.gzk);
        } else if (this.mFrom == 1) {
            this.gJB.setTabName(this.tabName);
        }
        this.gJB.a(this.gzj);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.gJB);
        this.mRecyclerView.setClipChildren(false);
        this.gJB.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.gJD.setOnClickListener(this.gJH);
        this.gJG = new RefreshView(getContext());
        this.gJA.setRefreshViewAndListener(this.gJG);
        this.gJA.setCallback(new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.3
            @Override // com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.a
            public void bKk() {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gzk ? 5 : 1);
                anVar.af("obj_source", 4);
                TiebaStatic.log(anVar);
            }
        });
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.gJE = z;
    }

    public void setShowMore(boolean z) {
        this.gJF = z;
        if (this.gJA != null) {
            this.gJA.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void b(l lVar) {
        if (lVar != null && lVar.bHW() != null && lVar.bHW().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<k> bHW = lVar.bHW();
            if (this.gJE) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
                if (bHW != null) {
                    arrayList.addAll(bHW);
                }
            } else {
                if (bHW != null) {
                    arrayList.addAll(bHW);
                }
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
            }
            this.gJB.setData(arrayList);
        }
        if (this.mFrom == 0) {
            if (this.gJC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gJC.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.gJC.requestLayout();
            }
        } else if (this.gJC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gJC.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
            this.gJC.requestLayout();
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        SvgManager.aOR().a(this.gJD, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.gJG.onChangeSkinType();
        this.gJB.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.gzk = z;
    }
}
