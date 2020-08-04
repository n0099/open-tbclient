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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class SpecialTopicLayout extends LinearLayout implements n<SpecialColumnListData>, o {
    private FrameLayout aiZ;
    private View aja;
    private ImageView ajb;
    private boolean ajg;
    private PullLeftRefreshLayout.a ajj;
    private RefreshView iDS;
    private PullLeftRefreshLayout iDT;
    private a iDU;
    private SpecialColumnListData iDV;
    private f<SpecialColumnItemData> iwT;
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
        this.ajg = false;
        this.mTitleColorId = R.color.cp_cont_c;
        this.ajj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.1
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bog() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.iDV)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SpecialTopicLayout.this.aja) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.iDV)));
                    b.b("c13755", true, 0);
                }
            }
        };
        this.iwT = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.3
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
        this.aiZ = (FrameLayout) findViewById(R.id.title_layout);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.ajb = (ImageView) findViewById(R.id.iv_into);
        this.aja = findViewById(R.id.layout_into);
        this.iDT = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.iDU = new a(this.mPageContext);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new ac(dimens, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds11), dimens2));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.iDU);
        this.mRecyclerView.setClipChildren(false);
        this.iDS = new RefreshView(getContext());
        this.iDT.setRefreshViewAndListener(this.iDS);
        this.iDT.setCallback(this.ajj);
        this.iDU.setOnItemCoverListener(this.iwT);
        this.ajb.setClickable(false);
        this.aja.setOnClickListener(this.mOnClickListener);
    }

    public void setShowMore(boolean z) {
        this.ajg = z;
        if (this.iDT != null) {
            this.iDT.setEnablePull(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData != null) {
            this.mTitle.setText(specialColumnListData.title);
            this.iDU.setData(specialColumnListData.cnZ());
            this.iDV = specialColumnListData;
            com.baidu.tbadk.a.b.a.a(this.mBottomLine, specialColumnListData);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.mTitle, this.mTitleColorId);
        ao.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aU(this.mBottomLine);
        SvgManager.baR().a(this.ajb, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.iDS.onChangeSkinType();
        this.iDU.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.Adapter<View$OnClickListenerC0649a> {
        private ArrayList<SpecialColumnItemData> agL = new ArrayList<>();
        private f<SpecialColumnItemData> agN;
        private TbPageContext<?> mPageContext;

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            this.agN = fVar;
        }

        public a(TbPageContext<?> tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list != null) {
                this.agL.clear();
                this.agL.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: A */
        public View$OnClickListenerC0649a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new View$OnClickListenerC0649a(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull View$OnClickListenerC0649a view$OnClickListenerC0649a, int i) {
            view$OnClickListenerC0649a.a((SpecialColumnItemData) x.getItem(this.agL, i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.agL == null) {
                return 0;
            }
            return this.agL.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC0649a extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TbImageView eeU;
            private TextView iDX;
            private SpecialColumnItemData iDY;
            private ImageView ixr;
            private int mIconResId;
            private View mMaskView;
            private int mSkinType;
            private TextView mTitleView;

            public View$OnClickListenerC0649a(View view) {
                super(view);
                this.mSkinType = 3;
                this.ixr = (ImageView) view.findViewById(R.id.video_play_iv);
                this.iDX = (TextView) view.findViewById(R.id.text_tv);
                this.mTitleView = (TextView) view.findViewById(R.id.tv_content);
                this.eeU = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.eeU.setConrers(15);
                this.eeU.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.eeU.setDrawCorner(true);
                this.eeU.setPlaceHolder(2);
                this.eeU.setGifIconSupport(false);
                this.mMaskView = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null) {
                    this.iDY = specialColumnItemData;
                    this.eeU.startLoad(specialColumnItemData.image, 10, false);
                    this.iDX.setText(specialColumnItemData.text);
                    this.mTitleView.setText(specialColumnItemData.title);
                    b(this.iDY);
                    if (a.this.agN != null) {
                        a.this.agN.b(this.itemView, this.iDY, getAdapterPosition(), getItemId());
                    }
                    xJ(TbadkCoreApplication.getInst().getSkinType());
                }
            }

            private void b(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.ixr.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.baR().a(this.ixr, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4)) {
                    this.ixr.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.baR().a(this.ixr, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.ixr.setVisibility(8);
                    this.mIconResId = 0;
                }
            }

            private void xJ(int i) {
                if (this.mSkinType != i) {
                    ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
                    ao.setViewTextColor(this.iDX, R.color.cp_cont_a);
                    ao.g(this.itemView, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                    SvgManager.baR().a(this.ixr, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                    com.baidu.tbadk.core.util.e.a.bbr().ma(0).aJ(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).mf(l.getDimens(a.this.mPageContext.getPageActivity(), R.dimen.tbds10)).aX(this.mMaskView);
                }
                this.mSkinType = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (a.this.agN != null) {
                    a.this.agN.a(this.itemView, this.iDY, adapterPosition, itemId);
                }
            }
        }
    }
}
