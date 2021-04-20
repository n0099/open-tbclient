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
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.HomePageTabFeedCollegeSecondActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import d.b.c.e.p.l;
import d.b.h0.m.f;
import d.b.i.p;
import d.b.i.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialTopicLayout extends LinearLayout implements q, p<SpecialColumnListData> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17034e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f17035f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f17036g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f17037h;
    public HorizontalAdapter i;
    public FrameLayout j;
    public TextView k;
    public View l;
    public ImageView m;
    public View n;
    public View o;
    public SpecialColumnListData p;
    public int q;
    public PullLeftRefreshLayout.f r;
    public View.OnClickListener s;
    public f<SpecialColumnItemData> t;

    /* loaded from: classes4.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext<?> f17038a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<SpecialColumnItemData> f17039b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public f<SpecialColumnItemData> f17040c;

        /* loaded from: classes4.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public int f17041e;

            /* renamed from: f  reason: collision with root package name */
            public TbImageView f17042f;

            /* renamed from: g  reason: collision with root package name */
            public View f17043g;

            /* renamed from: h  reason: collision with root package name */
            public TextView f17044h;
            public ImageView i;
            public TextView j;
            public SpecialColumnItemData k;
            public int l;

            public a(View view) {
                super(view);
                this.f17041e = 3;
                this.i = (ImageView) view.findViewById(R.id.video_play_iv);
                this.j = (TextView) view.findViewById(R.id.text_tv);
                this.f17044h = (TextView) view.findViewById(R.id.tv_content);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.f17042f = tbImageView;
                tbImageView.setConrers(15);
                this.f17042f.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.f17042f.setDrawCorner(true);
                this.f17042f.setPlaceHolder(2);
                this.f17042f.setGifIconSupport(false);
                this.f17043g = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData == null) {
                    return;
                }
                this.k = specialColumnItemData;
                this.f17042f.W(specialColumnItemData.image, 10, false);
                this.j.setText(specialColumnItemData.text);
                this.f17044h.setText(specialColumnItemData.title);
                c(this.k);
                if (HorizontalAdapter.this.f17040c != null) {
                    HorizontalAdapter.this.f17040c.c(this.itemView, this.k, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i) {
                if (this.f17041e != i) {
                    SkinManager.setViewTextColor(this.f17044h, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
                    SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(l.g(HorizontalAdapter.this.f17038a.getPageActivity(), R.dimen.tbds10)).into(this.f17043g);
                }
                this.f17041e = i;
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i;
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.i.setVisibility(0);
                    this.l = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && ((i = specialColumnItemData.specialType) == 3 || i == 4)) {
                    this.i.setVisibility(0);
                    this.l = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.i.setVisibility(8);
                    this.l = 0;
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (HorizontalAdapter.this.f17040c != null) {
                    HorizontalAdapter.this.f17040c.a(this.itemView, this.k, adapterPosition, itemId);
                }
            }
        }

        public HorizontalAdapter(TbPageContext<?> tbPageContext) {
            this.f17038a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            aVar.a((SpecialColumnItemData) ListUtils.getItem(this.f17039b, i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: f */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.f17038a.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new a(inflate);
        }

        public void g(f<SpecialColumnItemData> fVar) {
            this.f17040c = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<SpecialColumnItemData> arrayList = this.f17039b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list == null) {
                return;
            }
            this.f17039b.clear();
            this.f17039b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements PullLeftRefreshLayout.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.f17034e.getPageActivity(), SpecialTopicLayout.this.p)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == SpecialTopicLayout.this.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.f17034e.getPageActivity(), SpecialTopicLayout.this.p)));
                d.b.i0.a1.i.b.a("c13755", Boolean.TRUE, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<SpecialColumnItemData> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData == null) {
                return;
            }
            d.b.i0.a1.i.b.c("c13754", specialColumnItemData, i + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x000f, code lost:
            if (r8 != 4) goto L12;
         */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    SpecialTopicLayout.this.f17034e.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(SpecialTopicLayout.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                d.b.i0.a1.i.b.a("c13754", specialColumnItemData, i + 1);
            }
            SpecialTopicLayout.this.f17034e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(SpecialTopicLayout.this.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            d.b.i0.a1.i.b.a("c13754", specialColumnItemData, i + 1);
        }
    }

    public SpecialTopicLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.group_title_pullleft_refresh_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.j = (FrameLayout) findViewById(R.id.title_layout);
        this.k = (TextView) findViewById(R.id.tv_title);
        this.m = (ImageView) findViewById(R.id.iv_into);
        this.l = findViewById(R.id.layout_into);
        this.f17036g = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.f17037h = (RecyclerView) findViewById(R.id.recycler_view);
        this.n = findViewById(R.id.divider_line_top);
        this.o = findViewById(R.id.divider_line_bottom);
        this.i = new HorizontalAdapter(this.f17034e);
        int g2 = l.g(this.f17034e.getPageActivity(), R.dimen.tbds44);
        int g3 = l.g(this.f17034e.getPageActivity(), R.dimen.tbds44);
        this.f17037h.addItemDecoration(new SpaceItemDecoration(g2, l.g(this.f17034e.getPageActivity(), R.dimen.tbds11), g3));
        this.f17037h.setLayoutManager(new LinearLayoutManager(this.f17034e.getPageActivity(), 0, false));
        this.f17037h.setAdapter(this.i);
        this.f17037h.setClipChildren(false);
        RefreshView refreshView = new RefreshView(getContext());
        this.f17035f = refreshView;
        this.f17036g.setRefreshViewAndListener(refreshView);
        this.f17036g.setCallback(this.r);
        this.i.g(this.t);
        this.m.setClickable(false);
        this.l.setOnClickListener(this.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: f */
    public void a(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData == null) {
            return;
        }
        this.k.setText(specialColumnListData.title);
        this.i.setData(specialColumnListData.z());
        this.p = specialColumnListData;
        this.n.setVisibility(0);
        this.o.setVisibility(8);
        d.b.h0.b.g.b.g(this.n);
        onChangeSkinType(this.f17034e, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.k, this.q);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        d.b.h0.b.g.b.h(this.n);
        this.f17035f.d();
        this.i.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout = this.f17036g;
        if (pullLeftRefreshLayout != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public SpecialTopicLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.q = R.color.CAM_X0108;
        this.r = new a();
        this.s = new b();
        this.t = new c();
        this.f17034e = tbPageContext;
        e();
    }
}
