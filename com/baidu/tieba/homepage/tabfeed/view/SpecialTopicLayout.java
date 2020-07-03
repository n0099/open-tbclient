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
import com.baidu.adp.widget.ListView.ac;
import com.baidu.card.n;
import com.baidu.card.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.HomePageTabFeedCollegeSecondActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class SpecialTopicLayout extends LinearLayout implements n<SpecialColumnListData>, o {
    private FrameLayout aje;
    private View ajf;
    private ImageView ajg;
    private boolean ajl;
    private PullLeftRefreshLayout.a ajo;
    private f<SpecialColumnItemData> iqN;
    private RefreshView ixM;
    private PullLeftRefreshLayout ixN;
    private a ixO;
    private SpecialColumnListData ixP;
    private View mBottomLine;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;

    public SpecialTopicLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public SpecialTopicLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.ajl = false;
        this.mTitleColorId = R.color.cp_cont_c;
        this.ajo = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.1
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bkm() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.ixP)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SpecialTopicLayout.this.ajf) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.ixP)));
                    b.b("c13755", true, 0);
                }
            }
        };
        this.iqN = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.3
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
                    b.b("c13754", specialColumnItemData, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
                if (specialColumnItemData != null) {
                    b.c("c13754", specialColumnItemData, i + 1);
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
        this.aje = (FrameLayout) findViewById(R.id.title_layout);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.ajg = (ImageView) findViewById(R.id.iv_into);
        this.ajf = findViewById(R.id.layout_into);
        this.ixN = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.ixO = new a(this.mPageContext);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new ac(dimens, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds11), dimens2));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.ixO);
        this.mRecyclerView.setClipChildren(false);
        this.ixM = new RefreshView(getContext());
        this.ixN.setRefreshViewAndListener(this.ixM);
        this.ixN.setCallback(this.ajo);
        this.ixO.setOnItemCoverListener(this.iqN);
        this.ajg.setClickable(false);
        this.ajf.setOnClickListener(this.mOnClickListener);
    }

    public void setShowMore(boolean z) {
        this.ajl = z;
        if (this.ixN != null) {
            this.ixN.setEnablePull(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData != null) {
            this.mTitle.setText(specialColumnListData.title);
            this.ixO.setData(specialColumnListData.cky());
            this.ixP = specialColumnListData;
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        an.setBackgroundColor(this, R.color.cp_bg_line_e);
        an.setViewTextColor(this.mTitle, this.mTitleColorId);
        an.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.aWQ().a(this.ajg, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.ixM.onChangeSkinType();
        this.ixO.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.Adapter<View$OnClickListenerC0639a> {
        private ArrayList<SpecialColumnItemData> agU = new ArrayList<>();
        private f<SpecialColumnItemData> agW;
        private TbPageContext<?> mPageContext;

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            this.agW = fVar;
        }

        public a(TbPageContext<?> tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list != null) {
                this.agU.clear();
                this.agU.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: A */
        public View$OnClickListenerC0639a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new View$OnClickListenerC0639a(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull View$OnClickListenerC0639a view$OnClickListenerC0639a, int i) {
            view$OnClickListenerC0639a.a((SpecialColumnItemData) w.getItem(this.agU, i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.agU == null) {
                return 0;
            }
            return this.agU.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC0639a extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TbImageView dYH;
            private ImageView irl;
            private TextView ixR;
            private SpecialColumnItemData ixS;
            private int mIconResId;
            private View mMaskView;
            private int mSkinType;
            private TextView mTitleView;

            public View$OnClickListenerC0639a(View view) {
                super(view);
                this.mSkinType = 3;
                this.irl = (ImageView) view.findViewById(R.id.video_play_iv);
                this.ixR = (TextView) view.findViewById(R.id.text_tv);
                this.mTitleView = (TextView) view.findViewById(R.id.tv_content);
                this.dYH = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.dYH.setConrers(15);
                this.dYH.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.dYH.setDrawCorner(true);
                this.dYH.setPlaceHolder(2);
                this.dYH.setGifIconSupport(false);
                this.mMaskView = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null) {
                    this.ixS = specialColumnItemData;
                    this.dYH.startLoad(specialColumnItemData.image, 10, false);
                    this.ixR.setText(specialColumnItemData.text);
                    this.mTitleView.setText(specialColumnItemData.title);
                    b(this.ixS);
                    if (a.this.agW != null) {
                        a.this.agW.b(this.itemView, this.ixS, getAdapterPosition(), getItemId());
                    }
                    xr(TbadkCoreApplication.getInst().getSkinType());
                }
            }

            private void b(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.irl.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.aWQ().a(this.irl, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4)) {
                    this.irl.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.aWQ().a(this.irl, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.irl.setVisibility(8);
                    this.mIconResId = 0;
                }
            }

            private void xr(int i) {
                if (this.mSkinType != i) {
                    an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
                    an.setViewTextColor(this.ixR, (int) R.color.cp_cont_a);
                    an.e(this.itemView, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                    SvgManager.aWQ().a(this.irl, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                    com.baidu.tbadk.core.util.e.a.aXq().lG(0).aI(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).lL(l.getDimens(a.this.mPageContext.getPageActivity(), R.dimen.tbds10)).aR(this.mMaskView);
                }
                this.mSkinType = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (a.this.agW != null) {
                    a.this.agW.a(this.itemView, this.ixS, adapterPosition, itemId);
                }
            }
        }
    }
}
