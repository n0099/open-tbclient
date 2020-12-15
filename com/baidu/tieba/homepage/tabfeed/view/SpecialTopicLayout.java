package com.baidu.tieba.homepage.tabfeed.view;

import android.support.annotation.NonNull;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ae;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.HomePageTabFeedCollegeSecondActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.b;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class SpecialTopicLayout extends LinearLayout implements p<SpecialColumnListData>, q {
    private FrameLayout amn;
    private View amo;
    private ImageView amp;
    private boolean amu;
    private PullLeftRefreshLayout.a amx;
    private f<SpecialColumnItemData> jPP;
    private RefreshView jXo;
    private PullLeftRefreshLayout jXp;
    private a jXq;
    private SpecialColumnListData jXr;
    private View mBottomLine;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private View mTopLine;

    public SpecialTopicLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public SpecialTopicLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.amu = false;
        this.mTitleColorId = R.color.CAM_X0108;
        this.amx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.1
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bHZ() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.jXr)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SpecialTopicLayout.this.amo) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.jXr)));
                    b.c("c13755", true, 0);
                }
            }
        };
        this.jPP = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
                if (specialColumnItemData != null) {
                    switch (specialColumnItemData.specialType) {
                        case 1:
                        case 2:
                        case 4:
                            SpecialTopicLayout.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(SpecialTopicLayout.this.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
                            break;
                        case 3:
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                            SpecialTopicLayout.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(SpecialTopicLayout.this.getContext(), alaLiveInfoCoreData, "active_view_jump_live_room", "", false, "")));
                            break;
                    }
                    b.c("c13754", specialColumnItemData, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
                if (specialColumnItemData != null) {
                    b.b("c13754", specialColumnItemData, i + 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.group_title_pullleft_refresh_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amn = (FrameLayout) findViewById(R.id.title_layout);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.amp = (ImageView) findViewById(R.id.iv_into);
        this.amo = findViewById(R.id.layout_into);
        this.jXp = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mTopLine = findViewById(R.id.divider_line_top);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.jXq = new a(this.mPageContext);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new ae(dimens, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds11), dimens2));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.jXq);
        this.mRecyclerView.setClipChildren(false);
        this.jXo = new RefreshView(getContext());
        this.jXp.setRefreshViewAndListener(this.jXo);
        this.jXp.setCallback(this.amx);
        this.jXq.setOnItemCoverListener(this.jPP);
        this.amp.setClickable(false);
        this.amo.setOnClickListener(this.mOnClickListener);
    }

    public void setShowMore(boolean z) {
        this.amu = z;
        if (this.jXp != null) {
            this.jXp.setEnablePull(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData != null) {
            this.mTitle.setText(specialColumnListData.title);
            this.jXq.setData(specialColumnListData.cQN());
            this.jXr = specialColumnListData;
            if (d.bkA()) {
                this.mTopLine.setVisibility(8);
                this.mBottomLine.setVisibility(0);
                com.baidu.tbadk.a.b.a.bg(this.mBottomLine);
            } else {
                this.mTopLine.setVisibility(0);
                this.mBottomLine.setVisibility(8);
                com.baidu.tbadk.a.b.a.bg(this.mTopLine);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0205);
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.btW().a(this.amp, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        if (d.bkA()) {
            com.baidu.tbadk.a.b.a.bh(this.mBottomLine);
        } else {
            com.baidu.tbadk.a.b.a.bh(this.mTopLine);
        }
        this.jXo.onChangeSkinType();
        this.jXq.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.Adapter<View$OnClickListenerC0764a> {
        private ArrayList<SpecialColumnItemData> ajO = new ArrayList<>();
        private f<SpecialColumnItemData> ajQ;
        private TbPageContext<?> mPageContext;

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            this.ajQ = fVar;
        }

        public a(TbPageContext<?> tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list != null) {
                this.ajO.clear();
                this.ajO.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: E */
        public View$OnClickListenerC0764a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new View$OnClickListenerC0764a(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull View$OnClickListenerC0764a view$OnClickListenerC0764a, int i) {
            view$OnClickListenerC0764a.a((SpecialColumnItemData) y.getItem(this.ajO, i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.ajO == null) {
                return 0;
            }
            return this.ajO.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public class View$OnClickListenerC0764a extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TbImageView eXC;
            private ImageView jQH;
            private TextView jXt;
            private SpecialColumnItemData jXu;
            private int mIconResId;
            private View mMaskView;
            private int mSkinType;
            private TextView mTitleView;

            public View$OnClickListenerC0764a(View view) {
                super(view);
                this.mSkinType = 3;
                this.jQH = (ImageView) view.findViewById(R.id.video_play_iv);
                this.jXt = (TextView) view.findViewById(R.id.text_tv);
                this.mTitleView = (TextView) view.findViewById(R.id.tv_content);
                this.eXC = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.eXC.setConrers(15);
                this.eXC.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.eXC.setDrawCorner(true);
                this.eXC.setPlaceHolder(2);
                this.eXC.setGifIconSupport(false);
                this.mMaskView = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null) {
                    this.jXu = specialColumnItemData;
                    this.eXC.startLoad(specialColumnItemData.image, 10, false);
                    this.jXt.setText(specialColumnItemData.text);
                    this.mTitleView.setText(specialColumnItemData.title);
                    b(this.jXu);
                    if (a.this.ajQ != null) {
                        a.this.ajQ.b(this.itemView, this.jXu, getAdapterPosition(), getItemId());
                    }
                    Dd(TbadkCoreApplication.getInst().getSkinType());
                }
            }

            private void b(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.jQH.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.btW().a(this.jQH, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4)) {
                    this.jQH.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.btW().a(this.jQH, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.jQH.setVisibility(8);
                    this.mIconResId = 0;
                }
            }

            private void Dd(int i) {
                if (this.mSkinType != i) {
                    ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
                    ap.setViewTextColor(this.jXt, R.color.CAM_X0101);
                    ap.f(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                    SvgManager.btW().a(this.jQH, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    com.baidu.tbadk.core.util.e.a.buz().qf(0).aT(R.color.CAM_X0601, R.color.CAM_X0607).qm(l.getDimens(a.this.mPageContext.getPageActivity(), R.dimen.tbds10)).bq(this.mMaskView);
                }
                this.mSkinType = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (a.this.ajQ != null) {
                    a.this.ajQ.a(this.itemView, this.jXu, adapterPosition, itemId);
                }
            }
        }
    }
}
