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
/* loaded from: classes21.dex */
public class SpecialTopicLayout extends LinearLayout implements p<SpecialColumnListData>, q {
    private FrameLayout akP;
    private View akQ;
    private ImageView akR;
    private boolean akW;
    private PullLeftRefreshLayout.a akZ;
    private f<SpecialColumnItemData> iTW;
    private RefreshView jbC;
    private PullLeftRefreshLayout jbD;
    private a jbE;
    private SpecialColumnListData jbF;
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
        this.akW = false;
        this.mTitleColorId = R.color.cp_cont_c;
        this.akZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.1
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void byd() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.jbF)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SpecialTopicLayout.this.akQ) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.jbF)));
                    b.c("c13755", true, 0);
                }
            }
        };
        this.iTW = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.3
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
        this.akP = (FrameLayout) findViewById(R.id.title_layout);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.akR = (ImageView) findViewById(R.id.iv_into);
        this.akQ = findViewById(R.id.layout_into);
        this.jbD = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.jbE = new a(this.mPageContext);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new ae(dimens, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds11), dimens2));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.jbE);
        this.mRecyclerView.setClipChildren(false);
        this.jbC = new RefreshView(getContext());
        this.jbD.setRefreshViewAndListener(this.jbC);
        this.jbD.setCallback(this.akZ);
        this.jbE.setOnItemCoverListener(this.iTW);
        this.akR.setClickable(false);
        this.akQ.setOnClickListener(this.mOnClickListener);
    }

    public void setShowMore(boolean z) {
        this.akW = z;
        if (this.jbD != null) {
            this.jbD.setEnablePull(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData != null) {
            this.mTitle.setText(specialColumnListData.title);
            this.jbE.setData(specialColumnListData.cCA());
            this.jbF = specialColumnListData;
            com.baidu.tbadk.a.b.a.a(this.mBottomLine, specialColumnListData);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aY(this.mBottomLine);
        SvgManager.bkl().a(this.akR, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.jbC.onChangeSkinType();
        this.jbE.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.Adapter<View$OnClickListenerC0697a> {
        private ArrayList<SpecialColumnItemData> air = new ArrayList<>();
        private f<SpecialColumnItemData> ait;
        private TbPageContext<?> mPageContext;

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            this.ait = fVar;
        }

        public a(TbPageContext<?> tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list != null) {
                this.air.clear();
                this.air.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: C */
        public View$OnClickListenerC0697a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new View$OnClickListenerC0697a(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull View$OnClickListenerC0697a view$OnClickListenerC0697a, int i) {
            view$OnClickListenerC0697a.a((SpecialColumnItemData) y.getItem(this.air, i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.air == null) {
                return 0;
            }
            return this.air.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class View$OnClickListenerC0697a extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TbImageView eqP;
            private ImageView iUO;
            private TextView jbH;
            private SpecialColumnItemData jbI;
            private int mIconResId;
            private View mMaskView;
            private int mSkinType;
            private TextView mTitleView;

            public View$OnClickListenerC0697a(View view) {
                super(view);
                this.mSkinType = 3;
                this.iUO = (ImageView) view.findViewById(R.id.video_play_iv);
                this.jbH = (TextView) view.findViewById(R.id.text_tv);
                this.mTitleView = (TextView) view.findViewById(R.id.tv_content);
                this.eqP = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.eqP.setConrers(15);
                this.eqP.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.eqP.setDrawCorner(true);
                this.eqP.setPlaceHolder(2);
                this.eqP.setGifIconSupport(false);
                this.mMaskView = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null) {
                    this.jbI = specialColumnItemData;
                    this.eqP.startLoad(specialColumnItemData.image, 10, false);
                    this.jbH.setText(specialColumnItemData.text);
                    this.mTitleView.setText(specialColumnItemData.title);
                    b(this.jbI);
                    if (a.this.ait != null) {
                        a.this.ait.b(this.itemView, this.jbI, getAdapterPosition(), getItemId());
                    }
                    AE(TbadkCoreApplication.getInst().getSkinType());
                }
            }

            private void b(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.iUO.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.bkl().a(this.iUO, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4)) {
                    this.iUO.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.bkl().a(this.iUO, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.iUO.setVisibility(8);
                    this.mIconResId = 0;
                }
            }

            private void AE(int i) {
                if (this.mSkinType != i) {
                    ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
                    ap.setViewTextColor(this.jbH, R.color.cp_cont_a);
                    ap.f(this.itemView, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                    SvgManager.bkl().a(this.iUO, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                    com.baidu.tbadk.core.util.e.a.bkL().oq(0).aR(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).ov(l.getDimens(a.this.mPageContext.getPageActivity(), R.dimen.tbds10)).bb(this.mMaskView);
                }
                this.mSkinType = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (a.this.ait != null) {
                    a.this.ait.a(this.itemView, this.jbI, adapterPosition, itemId);
                }
            }
        }
    }
}
