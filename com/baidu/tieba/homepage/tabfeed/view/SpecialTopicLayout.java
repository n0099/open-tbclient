package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.k.p;
import d.a.k.q;
import d.a.p0.n.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialTopicLayout extends LinearLayout implements q, p<SpecialColumnListData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16936e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f16937f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f16938g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f16939h;

    /* renamed from: i  reason: collision with root package name */
    public HorizontalAdapter f16940i;
    public FrameLayout j;
    public TextView k;
    public View l;
    public ImageView m;
    public View n;
    public View o;
    public String p;
    public SpecialColumnListData q;
    public int r;
    public PullLeftRefreshLayout.f s;
    public View.OnClickListener t;
    public f<SpecialColumnItemData> u;

    /* loaded from: classes4.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext<?> f16941a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<SpecialColumnItemData> f16942b;

        /* renamed from: c  reason: collision with root package name */
        public f<SpecialColumnItemData> f16943c;

        /* loaded from: classes4.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public int f16944e;

            /* renamed from: f  reason: collision with root package name */
            public TbImageView f16945f;

            /* renamed from: g  reason: collision with root package name */
            public View f16946g;

            /* renamed from: h  reason: collision with root package name */
            public TextView f16947h;

            /* renamed from: i  reason: collision with root package name */
            public ImageView f16948i;
            public TextView j;
            public SpecialColumnItemData k;
            public int l;
            public final /* synthetic */ HorizontalAdapter m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.m = horizontalAdapter;
                this.f16944e = 3;
                this.f16948i = (ImageView) view.findViewById(R.id.video_play_iv);
                this.j = (TextView) view.findViewById(R.id.text_tv);
                this.f16947h = (TextView) view.findViewById(R.id.tv_content);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.f16945f = tbImageView;
                tbImageView.setConrers(15);
                this.f16945f.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.f16945f.setDrawCorner(true);
                this.f16945f.setPlaceHolder(2);
                this.f16945f.setGifIconSupport(false);
                this.f16946g = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                    return;
                }
                this.k = specialColumnItemData;
                this.f16945f.M(specialColumnItemData.image, 10, false);
                this.j.setText(specialColumnItemData.text);
                this.f16947h.setText(specialColumnItemData.title);
                c(this.k);
                if (this.m.f16943c != null) {
                    this.m.f16943c.c(this.itemView, this.k, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    if (this.f16944e != i2) {
                        SkinManager.setViewTextColor(this.f16947h, R.color.CAM_X0105);
                        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
                        SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16948i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(l.g(this.m.f16941a.getPageActivity(), R.dimen.tbds10)).into(this.f16946g);
                    }
                    this.f16944e = i2;
                }
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnItemData) == null) {
                    if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                        this.f16948i.setVisibility(0);
                        this.l = R.drawable.ic_icon_pure_video_play12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16948i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else if (specialColumnItemData != null && ((i2 = specialColumnItemData.specialType) == 3 || i2 == 4)) {
                        this.f16948i.setVisibility(0);
                        this.l = R.drawable.ic_icon_pure_common_live12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16948i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        this.f16948i.setVisibility(8);
                        this.l = 0;
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                    int adapterPosition = getAdapterPosition();
                    long itemId = getItemId();
                    if (this.m.f16943c != null) {
                        this.m.f16943c.a(this.itemView, this.k, adapterPosition, itemId);
                    }
                }
            }
        }

        public HorizontalAdapter(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16942b = new ArrayList<>();
            this.f16941a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) {
                aVar.a((SpecialColumnItemData) ListUtils.getItem(this.f16942b, i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: g */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                View inflate = LayoutInflater.from(this.f16941a.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
                inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
                return new a(this, inflate);
            }
            return (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList<SpecialColumnItemData> arrayList = this.f16942b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void h(f<SpecialColumnItemData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                this.f16943c = fVar;
            }
        }

        public void setData(List<SpecialColumnItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null) {
                return;
            }
            this.f16942b.clear();
            this.f16942b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f16949a;

        public a(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16949a = specialTopicLayout;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.f16949a.f16936e.getPageActivity(), this.f16949a.q)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f16950e;

        public b(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16950e = specialTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view == this.f16950e.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.f16950e.f16936e.getPageActivity(), this.f16950e.q)));
                d.a.q0.e1.j.c.a("c13755", Boolean.TRUE, 0, this.f16950e.p);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<SpecialColumnItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f16951e;

        public c(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16951e = specialTopicLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.n.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i2), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            d.a.q0.e1.j.c.b("c13754", specialColumnItemData, i2 + 1, this.f16951e.p);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            if (r8 != 4) goto L14;
         */
        @Override // d.a.p0.n.f
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i2), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            int i3 = specialColumnItemData.specialType;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.f16951e.f16936e.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f16951e.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                d.a.q0.e1.j.c.a("c13754", specialColumnItemData, i2 + 1, this.f16951e.p);
            }
            this.f16951e.f16936e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f16951e.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            d.a.q0.e1.j.c.a("c13754", specialColumnItemData, i2 + 1, this.f16951e.p);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpecialTopicLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_pullleft_refresh_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j = (FrameLayout) findViewById(R.id.title_layout);
            this.k = (TextView) findViewById(R.id.tv_title);
            this.m = (ImageView) findViewById(R.id.iv_into);
            this.l = findViewById(R.id.layout_into);
            this.f16938g = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.f16939h = (RecyclerView) findViewById(R.id.recycler_view);
            this.n = findViewById(R.id.divider_line_top);
            this.o = findViewById(R.id.divider_line_bottom);
            this.f16940i = new HorizontalAdapter(this.f16936e);
            int g2 = l.g(this.f16936e.getPageActivity(), R.dimen.tbds44);
            int g3 = l.g(this.f16936e.getPageActivity(), R.dimen.tbds44);
            this.f16939h.addItemDecoration(new SpaceItemDecoration(g2, l.g(this.f16936e.getPageActivity(), R.dimen.tbds11), g3));
            this.f16939h.setLayoutManager(new LinearLayoutManager(this.f16936e.getPageActivity(), 0, false));
            this.f16939h.setAdapter(this.f16940i);
            this.f16939h.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f16937f = refreshView;
            this.f16938g.setRefreshViewAndListener(refreshView);
            this.f16938g.setCallback(this.s);
            this.f16940i.h(this.u);
            this.m.setClickable(false);
            this.l.setOnClickListener(this.t);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: g */
    public void a(SpecialColumnListData specialColumnListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnListData) == null) || specialColumnListData == null) {
            return;
        }
        this.k.setText(specialColumnListData.title);
        this.f16940i.setData(specialColumnListData.getListData());
        this.q = specialColumnListData;
        this.n.setVisibility(0);
        this.o.setVisibility(8);
        d.a.p0.b.g.b.i(this.n);
        onChangeSkinType(this.f16936e, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k, this.r);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            d.a.p0.b.g.b.j(this.n);
            this.f16937f.d();
            this.f16940i.notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
        }
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f16938g) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialTopicLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = R.color.CAM_X0108;
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.f16936e = tbPageContext;
        f();
    }
}
