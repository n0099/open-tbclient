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
    private RefreshView gJA;
    View.OnClickListener gJB;
    private PullLeftRefreshLayout gJu;
    private com.baidu.tieba.enterForum.a.b gJv;
    private FrameLayout gJw;
    private ImageView gJx;
    private boolean gJy;
    private boolean gJz;
    private b.InterfaceC0529b gzd;
    private boolean gze;
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
        this.gJy = true;
        this.gJz = false;
        this.mFrom = 0;
        this.gzd = new b.InterfaceC0529b() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.1
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0529b
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
                            anVar.af("obj_type", RecommendForumHorizontalView.this.gze ? 4 : 1);
                        }
                        TiebaStatic.log(anVar);
                    }
                }
            }

            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0529b
            public void bN(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gze ? 5 : 1);
                anVar.af("obj_source", 5);
                TiebaStatic.log(anVar);
            }
        };
        this.gJB = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gze ? 5 : 1);
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
        this.gJw = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.gJx = (ImageView) findViewById(R.id.iv_into);
        this.gJu = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.gJv = new com.baidu.tieba.enterForum.a.b(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.gJv.setHasLikeForum(this.gze);
        } else if (this.mFrom == 1) {
            this.gJv.setTabName(this.tabName);
        }
        this.gJv.a(this.gzd);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.gJv);
        this.mRecyclerView.setClipChildren(false);
        this.gJv.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.gJx.setOnClickListener(this.gJB);
        this.gJA = new RefreshView(getContext());
        this.gJu.setRefreshViewAndListener(this.gJA);
        this.gJu.setCallback(new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.view.RecommendForumHorizontalView.3
            @Override // com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.a
            public void bKm() {
                com.baidu.tieba.enterForum.b.b(RecommendForumHorizontalView.this.mPageContext, RecommendForumHorizontalView.this.tabName);
                an anVar = new an("c13645");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", RecommendForumHorizontalView.this.gze ? 5 : 1);
                anVar.af("obj_source", 4);
                TiebaStatic.log(anVar);
            }
        });
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.gJy = z;
    }

    public void setShowMore(boolean z) {
        this.gJz = z;
        if (this.gJu != null) {
            this.gJu.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void b(l lVar) {
        if (lVar != null && lVar.bHY() != null && lVar.bHY().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<k> bHY = lVar.bHY();
            if (this.gJy) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
                if (bHY != null) {
                    arrayList.addAll(bHY);
                }
            } else {
                if (bHY != null) {
                    arrayList.addAll(bHY);
                }
                arrayList.add(new com.baidu.tieba.enterForum.data.a());
            }
            this.gJv.setData(arrayList);
        }
        if (this.mFrom == 0) {
            if (this.gJw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gJw.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.gJw.requestLayout();
            }
        } else if (this.gJw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gJw.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
            this.gJw.requestLayout();
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        SvgManager.aOU().a(this.gJx, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.gJA.onChangeSkinType();
        this.gJv.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.gze = z;
    }
}
