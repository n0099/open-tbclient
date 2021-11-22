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
import b.a.e.f.p.l;
import b.a.l.p;
import b.a.l.q;
import b.a.q0.n.f;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class SpecialTopicLayout extends LinearLayout implements q, p<SpecialColumnListData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f50718e;

    /* renamed from: f  reason: collision with root package name */
    public RefreshView f50719f;

    /* renamed from: g  reason: collision with root package name */
    public PullLeftRefreshLayout f50720g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f50721h;

    /* renamed from: i  reason: collision with root package name */
    public HorizontalAdapter f50722i;
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

    /* loaded from: classes9.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext<?> f50723a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<SpecialColumnItemData> f50724b;

        /* renamed from: c  reason: collision with root package name */
        public f<SpecialColumnItemData> f50725c;

        /* loaded from: classes9.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public int f50726e;

            /* renamed from: f  reason: collision with root package name */
            public TbImageView f50727f;

            /* renamed from: g  reason: collision with root package name */
            public View f50728g;

            /* renamed from: h  reason: collision with root package name */
            public TextView f50729h;

            /* renamed from: i  reason: collision with root package name */
            public ImageView f50730i;
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
                this.f50726e = 3;
                this.f50730i = (ImageView) view.findViewById(R.id.video_play_iv);
                this.j = (TextView) view.findViewById(R.id.text_tv);
                this.f50729h = (TextView) view.findViewById(R.id.tv_content);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_imageView);
                this.f50727f = tbImageView;
                tbImageView.setConrers(15);
                this.f50727f.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.f50727f.setDrawCorner(true);
                this.f50727f.setPlaceHolder(2);
                this.f50727f.setGifIconSupport(false);
                this.f50728g = view.findViewById(R.id.gradient_cover);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                    return;
                }
                this.k = specialColumnItemData;
                this.f50727f.startLoad(specialColumnItemData.image, 10, false);
                this.j.setText(specialColumnItemData.text);
                this.f50729h.setText(specialColumnItemData.title);
                c(this.k);
                if (this.m.f50725c != null) {
                    this.m.f50725c.c(this.itemView, this.k, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    if (this.f50726e != i2) {
                        SkinManager.setViewTextColor(this.f50729h, R.color.CAM_X0105);
                        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
                        SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50730i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(l.g(this.m.f50723a.getPageActivity(), R.dimen.tbds10)).into(this.f50728g);
                    }
                    this.f50726e = i2;
                }
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnItemData) == null) {
                    if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                        this.f50730i.setVisibility(0);
                        this.l = R.drawable.ic_icon_pure_video_play12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50730i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else if (specialColumnItemData != null && ((i2 = specialColumnItemData.specialType) == 3 || i2 == 4)) {
                        this.f50730i.setVisibility(0);
                        this.l = R.drawable.ic_icon_pure_common_live12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50730i, this.l, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        this.f50730i.setVisibility(8);
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
                    if (this.m.f50725c != null) {
                        this.m.f50725c.a(this.itemView, this.k, adapterPosition, itemId);
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
            this.f50724b = new ArrayList<>();
            this.f50723a = tbPageContext;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<SpecialColumnItemData> arrayList = this.f50724b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void setData(List<SpecialColumnItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
                return;
            }
            this.f50724b.clear();
            this.f50724b.addAll(list);
            notifyDataSetChanged();
        }

        public void setOnItemCoverListener(f<SpecialColumnItemData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
                this.f50725c = fVar;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) {
                aVar.a((SpecialColumnItemData) ListUtils.getItem(this.f50724b, i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
                View inflate = LayoutInflater.from(this.f50723a.getPageActivity()).inflate(R.layout.special_topic_item_view, (ViewGroup) null);
                inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
                return new a(this, inflate);
            }
            return (a) invokeLI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class a implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f50731a;

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
            this.f50731a = specialTopicLayout;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.f50731a.f50718e.getPageActivity(), this.f50731a.q)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f50732e;

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
            this.f50732e = specialTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view == this.f50732e.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HomePageTabFeedCollegeSecondActivityConfig(this.f50732e.f50718e.getPageActivity(), this.f50732e.q)));
                b.a.r0.h1.j.c.a("c13755", Boolean.TRUE, 0, this.f50732e.p);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f<SpecialColumnItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialTopicLayout f50733e;

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
            this.f50733e = specialTopicLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i2), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            b.a.r0.h1.j.c.b("c13754", specialColumnItemData, i2 + 1, this.f50733e.p);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            if (r8 != 4) goto L14;
         */
        @Override // b.a.q0.n.f
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
                    this.f50733e.f50718e.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f50733e.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                b.a.r0.h1.j.c.a("c13754", specialColumnItemData, i2 + 1, this.f50733e.p);
            }
            this.f50733e.f50718e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f50733e.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            b.a.r0.h1.j.c.a("c13754", specialColumnItemData, i2 + 1, this.f50733e.p);
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_pullleft_refresh_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j = (FrameLayout) findViewById(R.id.title_layout);
            this.k = (TextView) findViewById(R.id.tv_title);
            this.m = (ImageView) findViewById(R.id.iv_into);
            this.l = findViewById(R.id.layout_into);
            this.f50720g = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.f50721h = (RecyclerView) findViewById(R.id.recycler_view);
            this.n = findViewById(R.id.divider_line_top);
            this.o = findViewById(R.id.divider_line_bottom);
            this.f50722i = new HorizontalAdapter(this.f50718e);
            int g2 = l.g(this.f50718e.getPageActivity(), R.dimen.tbds44);
            int g3 = l.g(this.f50718e.getPageActivity(), R.dimen.tbds44);
            this.f50721h.addItemDecoration(new SpaceItemDecoration(g2, l.g(this.f50718e.getPageActivity(), R.dimen.tbds11), g3));
            this.f50721h.setLayoutManager(new LinearLayoutManager(this.f50718e.getPageActivity(), 0, false));
            this.f50721h.setAdapter(this.f50722i);
            this.f50721h.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.f50719f = refreshView;
            this.f50720g.setRefreshViewAndListener(refreshView);
            this.f50720g.setCallback(this.s);
            this.f50722i.setOnItemCoverListener(this.u);
            this.m.setClickable(false);
            this.l.setOnClickListener(this.t);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k, this.r);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            b.a.q0.b.g.b.j(this.n);
            this.f50719f.onChangeSkinType();
            this.f50722i.notifyDataSetChanged();
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.f50720g) == null) {
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
        this.f50718e = tbPageContext;
        e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(SpecialColumnListData specialColumnListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, specialColumnListData) == null) || specialColumnListData == null) {
            return;
        }
        this.k.setText(specialColumnListData.title);
        this.f50722i.setData(specialColumnListData.getListData());
        this.q = specialColumnListData;
        this.n.setVisibility(0);
        this.o.setVisibility(8);
        b.a.q0.b.g.b.i(this.n);
        onChangeSkinType(this.f50718e, TbadkCoreApplication.getInst().getSkinType());
    }
}
