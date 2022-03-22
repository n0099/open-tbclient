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
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.l.q;
import c.a.o0.m.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SpecialTopicLayout extends LinearLayout implements q, p<SpecialColumnListData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public RefreshView f33499b;

    /* renamed from: c  reason: collision with root package name */
    public PullLeftRefreshLayout f33500c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33501d;

    /* renamed from: e  reason: collision with root package name */
    public HorizontalAdapter f33502e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f33503f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33504g;

    /* renamed from: h  reason: collision with root package name */
    public View f33505h;
    public ImageView i;
    public View j;
    public View k;
    public String l;
    public SpecialColumnListData m;
    public int n;
    public PullLeftRefreshLayout.f o;
    public View.OnClickListener p;
    public f<SpecialColumnItemData> q;

    /* loaded from: classes5.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<SpecialColumnItemData> f33506b;

        /* renamed from: c  reason: collision with root package name */
        public f<SpecialColumnItemData> f33507c;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f33508b;

            /* renamed from: c  reason: collision with root package name */
            public View f33509c;

            /* renamed from: d  reason: collision with root package name */
            public TextView f33510d;

            /* renamed from: e  reason: collision with root package name */
            public ImageView f33511e;

            /* renamed from: f  reason: collision with root package name */
            public TextView f33512f;

            /* renamed from: g  reason: collision with root package name */
            public SpecialColumnItemData f33513g;

            /* renamed from: h  reason: collision with root package name */
            public int f33514h;
            public final /* synthetic */ HorizontalAdapter i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.i = horizontalAdapter;
                this.a = 3;
                this.f33511e = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092367);
                this.f33512f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f52);
                this.f33510d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092198);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090fda);
                this.f33508b = tbImageView;
                tbImageView.setConrers(15);
                this.f33508b.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.f33508b.setDrawCorner(true);
                this.f33508b.setPlaceHolder(2);
                this.f33508b.setGifIconSupport(false);
                this.f33509c = view.findViewById(R.id.obfuscated_res_0x7f090ce1);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                    return;
                }
                this.f33513g = specialColumnItemData;
                this.f33508b.J(specialColumnItemData.image, 10, false);
                this.f33512f.setText(specialColumnItemData.text);
                this.f33510d.setText(specialColumnItemData.title);
                c(this.f33513g);
                if (this.i.f33507c != null) {
                    this.i.f33507c.c(this.itemView, this.f33513g, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setViewTextColor(this.f33510d, (int) R.color.CAM_X0105);
                        SkinManager.setViewTextColor(this.f33512f, (int) R.color.CAM_X0101);
                        SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33511e, this.f33514h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(n.f(this.i.a.getPageActivity(), R.dimen.tbds10)).into(this.f33509c);
                    }
                    this.a = i;
                }
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnItemData) == null) {
                    if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                        this.f33511e.setVisibility(0);
                        this.f33514h = R.drawable.ic_icon_pure_video_play12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33511e, this.f33514h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else if (specialColumnItemData != null && ((i = specialColumnItemData.specialType) == 3 || i == 4)) {
                        this.f33511e.setVisibility(0);
                        this.f33514h = R.drawable.obfuscated_res_0x7f0805ff;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33511e, this.f33514h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        this.f33511e.setVisibility(8);
                        this.f33514h = 0;
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                    int adapterPosition = getAdapterPosition();
                    long itemId = getItemId();
                    if (this.i.f33507c != null) {
                        this.i.f33507c.a(this.itemView, this.f33513g, adapterPosition, itemId);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33506b = new ArrayList<>();
            this.a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) {
                aVar.a((SpecialColumnItemData) ListUtils.getItem(this.f33506b, i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: g */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0792, (ViewGroup) null);
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
                ArrayList<SpecialColumnItemData> arrayList = this.f33506b;
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
                this.f33507c = fVar;
            }
        }

        public void setData(List<SpecialColumnItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null) {
                return;
            }
            this.f33506b.clear();
            this.f33506b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialTopicLayout a;

        public a(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialTopicLayout;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.a.a.getPageActivity(), this.a.m)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialTopicLayout a;

        public b(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view == this.a.f33505h) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.a.a.getPageActivity(), this.a.m)));
                c.a.p0.q1.k.c.a("c13755", Boolean.TRUE, 0, this.a.l);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f<SpecialColumnItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialTopicLayout a;

        public c(SpecialTopicLayout specialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialTopicLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            c.a.p0.q1.k.c.b("c13754", specialColumnItemData, i + 1, this.a.l);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            if (r8 != 4) goto L14;
         */
        @Override // c.a.o0.m.f
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.a.a.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                c.a.p0.q1.k.c.a("c13754", specialColumnItemData, i + 1, this.a.l);
            }
            this.a.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            c.a.p0.q1.k.c.a("c13754", specialColumnItemData, i + 1, this.a.l);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d038f, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f33503f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092047);
            this.f33504g = (TextView) findViewById(R.id.obfuscated_res_0x7f09221e);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdb);
            this.f33505h = findViewById(R.id.obfuscated_res_0x7f0911e2);
            this.f33500c = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091a2e);
            this.f33501d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a27);
            this.j = findViewById(R.id.obfuscated_res_0x7f0907ff);
            this.k = findViewById(R.id.obfuscated_res_0x7f0907f9);
            this.f33502e = new HorizontalAdapter(this.a);
            int f2 = n.f(this.a.getPageActivity(), R.dimen.tbds44);
            int f3 = n.f(this.a.getPageActivity(), R.dimen.tbds44);
            this.f33501d.addItemDecoration(new SpaceItemDecoration(f2, n.f(this.a.getPageActivity(), R.dimen.tbds11), f3));
            this.f33501d.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.f33501d.setAdapter(this.f33502e);
            this.f33501d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f33499b = refreshView;
            this.f33500c.setRefreshViewAndListener(refreshView);
            this.f33500c.setCallback(this.o);
            this.f33502e.h(this.q);
            this.i.setClickable(false);
            this.f33505h.setOnClickListener(this.p);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: g */
    public void a(SpecialColumnListData specialColumnListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnListData) == null) || specialColumnListData == null) {
            return;
        }
        this.f33504g.setText(specialColumnListData.title);
        this.f33502e.setData(specialColumnListData.getListData());
        this.m = specialColumnListData;
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        HomeGroupUbsUIHelper.handleLine(this.j);
        onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f33504g, this.n);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080915, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            HomeGroupUbsUIHelper.handleLineColor(this.j);
            this.f33499b.d();
            this.f33502e.notifyDataSetChanged();
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f33500c) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0108;
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = tbPageContext;
        f();
    }
}
