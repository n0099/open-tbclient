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
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.i.q;
import d.a.m0.m.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialTopicLayout extends LinearLayout implements q, p<SpecialColumnListData> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16547e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f16548f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f16549g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f16550h;

    /* renamed from: i  reason: collision with root package name */
    public HorizontalAdapter f16551i;
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
        public TbPageContext<?> f16552a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<SpecialColumnItemData> f16553b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public f<SpecialColumnItemData> f16554c;

        /* loaded from: classes4.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public int f16555e;

            /* renamed from: f  reason: collision with root package name */
            public TbImageView f16556f;

            /* renamed from: g  reason: collision with root package name */
            public View f16557g;

            /* renamed from: h  reason: collision with root package name */
            public TextView f16558h;

            /* renamed from: i  reason: collision with root package name */
            public ImageView f16559i;
            public TextView j;
            public SpecialColumnItemData k;
            public int l;

            public a(View view) {
                super(view);
                this.f16555e = 3;
                this.f16559i = (ImageView) view.findViewById(R.id.video_play_iv);
                this.j = (TextView) view.findViewById(R.id.text_tv);
                this.f16558h = (TextView) view.findViewById(R.id.tv_content);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.f16556f = tbImageView;
                tbImageView.setConrers(15);
                this.f16556f.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.f16556f.setDrawCorner(true);
                this.f16556f.setPlaceHolder(2);
                this.f16556f.setGifIconSupport(false);
                this.f16557g = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                if (specialColumnItemData == null) {
                    return;
                }
                this.k = specialColumnItemData;
                this.f16556f.V(specialColumnItemData.image, 10, false);
                this.j.setText(specialColumnItemData.text);
                this.f16558h.setText(specialColumnItemData.title);
                c(this.k);
                if (HorizontalAdapter.this.f16554c != null) {
                    HorizontalAdapter.this.f16554c.c(this.itemView, this.k, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i2) {
                if (this.f16555e != i2) {
                    SkinManager.setViewTextColor(this.f16558h, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
                    SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16559i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(l.g(HorizontalAdapter.this.f16552a.getPageActivity(), R.dimen.tbds10)).into(this.f16557g);
                }
                this.f16555e = i2;
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i2;
                if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                    this.f16559i.setVisibility(0);
                    this.l = R.drawable.ic_icon_pure_video_play12_svg;
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16559i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else if (specialColumnItemData != null && ((i2 = specialColumnItemData.specialType) == 3 || i2 == 4)) {
                    this.f16559i.setVisibility(0);
                    this.l = R.drawable.ic_icon_pure_common_live12_svg;
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16559i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    this.f16559i.setVisibility(8);
                    this.l = 0;
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                long itemId = getItemId();
                if (HorizontalAdapter.this.f16554c != null) {
                    HorizontalAdapter.this.f16554c.a(this.itemView, this.k, adapterPosition, itemId);
                }
            }
        }

        public HorizontalAdapter(TbPageContext<?> tbPageContext) {
            this.f16552a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            aVar.a((SpecialColumnItemData) ListUtils.getItem(this.f16553b, i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: f */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(this.f16552a.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new a(inflate);
        }

        public void g(f<SpecialColumnItemData> fVar) {
            this.f16554c = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<SpecialColumnItemData> arrayList = this.f16553b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public void setData(List<SpecialColumnItemData> list) {
            if (list == null) {
                return;
            }
            this.f16553b.clear();
            this.f16553b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements PullLeftRefreshLayout.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.f16547e.getPageActivity(), SpecialTopicLayout.this.p)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == SpecialTopicLayout.this.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(SpecialTopicLayout.this.f16547e.getPageActivity(), SpecialTopicLayout.this.p)));
                d.a.n0.b1.i.b.a("c13755", Boolean.TRUE, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<SpecialColumnItemData> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i2, long j) {
            if (specialColumnItemData == null) {
                return;
            }
            d.a.n0.b1.i.b.c("c13754", specialColumnItemData, i2 + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x000f, code lost:
            if (r8 != 4) goto L12;
         */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i2, long j) {
            if (specialColumnItemData == null) {
                return;
            }
            int i3 = specialColumnItemData.specialType;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    SpecialTopicLayout.this.f16547e.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(SpecialTopicLayout.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                d.a.n0.b1.i.b.a("c13754", specialColumnItemData, i2 + 1);
            }
            SpecialTopicLayout.this.f16547e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(SpecialTopicLayout.this.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            d.a.n0.b1.i.b.a("c13754", specialColumnItemData, i2 + 1);
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
        this.f16549g = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.f16550h = (RecyclerView) findViewById(R.id.recycler_view);
        this.n = findViewById(R.id.divider_line_top);
        this.o = findViewById(R.id.divider_line_bottom);
        this.f16551i = new HorizontalAdapter(this.f16547e);
        int g2 = l.g(this.f16547e.getPageActivity(), R.dimen.tbds44);
        int g3 = l.g(this.f16547e.getPageActivity(), R.dimen.tbds44);
        this.f16550h.addItemDecoration(new SpaceItemDecoration(g2, l.g(this.f16547e.getPageActivity(), R.dimen.tbds11), g3));
        this.f16550h.setLayoutManager(new LinearLayoutManager(this.f16547e.getPageActivity(), 0, false));
        this.f16550h.setAdapter(this.f16551i);
        this.f16550h.setClipChildren(false);
        RefreshView refreshView = new RefreshView(getContext());
        this.f16548f = refreshView;
        this.f16549g.setRefreshViewAndListener(refreshView);
        this.f16549g.setCallback(this.r);
        this.f16551i.g(this.t);
        this.m.setClickable(false);
        this.l.setOnClickListener(this.s);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: f */
    public void a(SpecialColumnListData specialColumnListData) {
        if (specialColumnListData == null) {
            return;
        }
        this.k.setText(specialColumnListData.title);
        this.f16551i.setData(specialColumnListData.z());
        this.p = specialColumnListData;
        this.n.setVisibility(0);
        this.o.setVisibility(8);
        d.a.m0.b.g.b.g(this.n);
        onChangeSkinType(this.f16547e, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.k, this.q);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        d.a.m0.b.g.b.h(this.n);
        this.f16548f.d();
        this.f16551i.notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout = this.f16549g;
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
        this.f16547e = tbPageContext;
        e();
    }
}
