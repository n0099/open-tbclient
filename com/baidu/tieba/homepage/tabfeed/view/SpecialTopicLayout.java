package com.baidu.tieba.homepage.tabfeed.view;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
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
/* loaded from: classes2.dex */
public class SpecialTopicLayout extends LinearLayout implements p<SpecialColumnListData>, q {
    private FrameLayout alO;
    private View alP;
    private ImageView alQ;
    private boolean alV;
    private int alX;
    private PullLeftRefreshLayout.a alZ;
    private f<SpecialColumnItemData> kgp;
    private RefreshView koq;
    private PullLeftRefreshLayout kor;
    private HorizontalAdapter kos;
    private SpecialColumnListData kot;
    private View mBottomLine;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private View mTopLine;

    public SpecialTopicLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public SpecialTopicLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.alV = false;
        this.alX = R.color.CAM_X0108;
        this.alZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.1
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bGW() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.kot)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SpecialTopicLayout.this.alP) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.mPageContext.getPageActivity(), SpecialTopicLayout.this.kot)));
                    b.c("c13755", true, 0);
                }
            }
        };
        this.kgp = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout.3
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
        this.alO = (FrameLayout) findViewById(R.id.title_layout);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.alQ = (ImageView) findViewById(R.id.iv_into);
        this.alP = findViewById(R.id.layout_into);
        this.kor = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mTopLine = findViewById(R.id.divider_line_top);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.kos = new HorizontalAdapter(this.mPageContext);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new SpaceItemDecoration(dimens, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds11), dimens2));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.kos);
        this.mRecyclerView.setClipChildren(false);
        this.koq = new RefreshView(getContext());
        this.kor.setRefreshViewAndListener(this.koq);
        this.kor.setCallback(this.alZ);
        this.kos.setOnItemCoverListener(this.kgp);
        this.alQ.setClickable(false);
        this.alP.setOnClickListener(this.mOnClickListener);
    }

    public void setShowMore(boolean z) {
        this.alV = z;
        if (this.kor != null) {
            this.kor.setEnablePull(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData != null) {
            this.mTitle.setText(specialColumnListData.title);
            this.kos.setData(specialColumnListData.cSi());
            this.kot = specialColumnListData;
            this.mTopLine.setVisibility(0);
            this.mBottomLine.setVisibility(8);
            com.baidu.tbadk.a.b.b.bl(this.mTopLine);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0205);
        ap.setViewTextColor(this.mTitle, this.alX);
        SvgManager.bsR().a(this.alQ, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.a.b.b.bm(this.mTopLine);
        this.koq.onChangeSkinType();
        this.kos.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    /* loaded from: classes2.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        private ArrayList<SpecialColumnItemData> ajo = new ArrayList<>();
        private f<SpecialColumnItemData> ajq;
        private TbPageContext<?> mPageContext;

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            this.ajq = fVar;
        }

        public HorizontalAdapter(TbPageContext<?> tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list != null) {
                this.ajo.clear();
                this.ajo.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: J */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new a(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            aVar.a((SpecialColumnItemData) y.getItem(this.ajo, i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.ajo == null) {
                return 0;
            }
            return this.ajo.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TbImageView feK;
            private ImageView khh;
            private TextView kov;
            private SpecialColumnItemData kow;
            private int mIconResId;
            private View mMaskView;
            private int mSkinType;
            private TextView mTitleView;

            public a(View view) {
                super(view);
                this.mSkinType = 3;
                this.khh = (ImageView) view.findViewById(R.id.video_play_iv);
                this.kov = (TextView) view.findViewById(R.id.text_tv);
                this.mTitleView = (TextView) view.findViewById(R.id.tv_content);
                this.feK = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.feK.setConrers(15);
                this.feK.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.feK.setDrawCorner(true);
                this.feK.setPlaceHolder(2);
                this.feK.setGifIconSupport(false);
                this.mMaskView = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null) {
                    this.kow = specialColumnItemData;
                    this.feK.startLoad(specialColumnItemData.image, 10, false);
                    this.kov.setText(specialColumnItemData.text);
                    this.mTitleView.setText(specialColumnItemData.title);
                    b(this.kow);
                    if (HorizontalAdapter.this.ajq != null) {
                        HorizontalAdapter.this.ajq.b(this.itemView, this.kow, getAdapterPosition(), getItemId());
                    }
                    Cc(TbadkCoreApplication.getInst().getSkinType());
                }
            }

            private void b(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.khh.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.bsR().a(this.khh, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4)) {
                    this.khh.setVisibility(0);
                    this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.bsR().a(this.khh, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.khh.setVisibility(8);
                    this.mIconResId = 0;
                }
            }

            private void Cc(int i) {
                if (this.mSkinType != i) {
                    ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
                    ap.setViewTextColor(this.kov, R.color.CAM_X0101);
                    ap.l(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                    SvgManager.bsR().a(this.khh, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    com.baidu.tbadk.core.util.f.a.btv().oO(0).aO(R.color.CAM_X0601, R.color.CAM_X0607).oV(l.getDimens(HorizontalAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10)).bv(this.mMaskView);
                }
                this.mSkinType = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (HorizontalAdapter.this.ajq != null) {
                    HorizontalAdapter.this.ajq.a(this.itemView, this.kow, adapterPosition, itemId);
                }
            }
        }
    }
}
