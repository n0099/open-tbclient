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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
import com.baidu.tieba.ht;
import com.baidu.tieba.it;
import com.baidu.tieba.vu4;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SpecialTopicLayout extends LinearLayout implements it, ht<SpecialColumnListData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public RefreshView b;
    public PullLeftRefreshLayout c;
    public RecyclerView d;
    public HorizontalAdapter e;
    public FrameLayout f;
    public TextView g;
    public View h;
    public View i;
    public String j;
    public SpecialColumnListData k;
    public int l;
    public vu4<SpecialColumnItemData> m;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public ArrayList<SpecialColumnItemData> b;
        public vu4<SpecialColumnItemData> c;

        /* loaded from: classes6.dex */
        public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public TbImageView b;
            public View c;
            public TextView d;
            public ImageView e;
            public TextView f;
            public SpecialColumnItemData g;
            public int h;
            public final /* synthetic */ HorizontalAdapter i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(HorizontalAdapter horizontalAdapter, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {horizontalAdapter, view2};
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
                this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09296b);
                this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092531);
                this.d = (TextView) view2.findViewById(R.id.tv_content);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091273);
                this.b = tbImageView;
                tbImageView.setConrers(15);
                this.b.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.b.setDrawCorner(true);
                this.b.setPlaceHolder(2);
                this.b.setGifIconSupport(false);
                this.c = view2.findViewById(R.id.obfuscated_res_0x7f090ec3);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, specialColumnItemData) != null) || specialColumnItemData == null) {
                    return;
                }
                this.g = specialColumnItemData;
                this.b.startLoad(specialColumnItemData.image, 10, false);
                this.f.setText(specialColumnItemData.text);
                this.d.setText(specialColumnItemData.title);
                c(this.g);
                if (this.i.c != null) {
                    this.i.c.d(this.itemView, this.g, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void c(SpecialColumnItemData specialColumnItemData) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnItemData) == null) {
                    if (specialColumnItemData != null && specialColumnItemData.specialType == 2) {
                        this.e.setVisibility(0);
                        this.h = R.drawable.ic_icon_pure_video_play12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, this.h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else if (specialColumnItemData != null && ((i = specialColumnItemData.specialType) == 3 || i == 4)) {
                        this.e.setVisibility(0);
                        this.h = R.drawable.ic_icon_pure_common_live12_svg;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, this.h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        this.e.setVisibility(8);
                        this.h = 0;
                    }
                }
            }

            public final void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
                        SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, this.h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(BdUtilHelper.getDimens(this.i.a.getPageActivity(), R.dimen.tbds10)).into(this.c);
                    }
                    this.a = i;
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
                    int adapterPosition = getAdapterPosition();
                    long itemId = getItemId();
                    if (this.i.c != null) {
                        this.i.c.b(this.itemView, this.g, adapterPosition, itemId);
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
            this.b = new ArrayList<>();
            this.a = tbPageContext;
        }

        public void p(vu4<SpecialColumnItemData> vu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, vu4Var) == null) {
                this.c = vu4Var;
            }
        }

        public void setData(List<SpecialColumnItemData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || list == null) {
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList<SpecialColumnItemData> arrayList = this.b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) {
                aVar.a((SpecialColumnItemData) ListUtils.getItem(this.b, i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: o */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08f9, (ViewGroup) null);
                inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
                return new a(this, inflate);
            }
            return (a) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements vu4<SpecialColumnItemData> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vu4
        /* renamed from: a */
        public void d(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) != null) || specialColumnItemData == null) {
                return;
            }
            zf8.b("c13754", specialColumnItemData, i + 1, this.a.j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            if (r8 != 4) goto L14;
         */
        @Override // com.baidu.tieba.vu4
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) != null) || specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.a.a.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                zf8.a("c13754", specialColumnItemData, i + 1, this.a.j);
            }
            this.a.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            zf8.a("c13754", specialColumnItemData, i + 1, this.a.j);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ht
    /* renamed from: d */
    public void onBindDataToView(SpecialColumnListData specialColumnListData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, specialColumnListData) != null) || specialColumnListData == null) {
            return;
        }
        this.g.setText(specialColumnListData.title);
        this.e.setData(specialColumnListData.getListData());
        this.k = specialColumnListData;
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        HomeGroupUbsUIHelper.handleLine(this.h);
        onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
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
        this.l = R.color.CAM_X0108;
        this.m = new a(this);
        this.a = tbPageContext;
        c();
    }

    public void setShowMore(boolean z) {
        PullLeftRefreshLayout pullLeftRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (pullLeftRefreshLayout = this.c) != null) {
            pullLeftRefreshLayout.setEnablePull(z);
        }
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0403, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f = (FrameLayout) findViewById(R.id.title_layout);
            this.g = (TextView) findViewById(R.id.tv_title);
            this.c = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
            this.d = (RecyclerView) findViewById(R.id.recycler_view);
            this.h = findViewById(R.id.divider_line_top);
            this.i = findViewById(R.id.divider_line_bottom);
            this.e = new HorizontalAdapter(this.a);
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds44);
            int dimens2 = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds44);
            this.d.addItemDecoration(new SpaceItemDecoration(dimens, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds11), dimens2));
            this.d.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.b = refreshView;
            this.c.setRefreshViewAndListener(refreshView);
            this.e.p(this.m);
        }
    }

    @Override // com.baidu.tieba.it
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, this.l);
            HomeGroupUbsUIHelper.handleLineColor(this.h);
            this.b.d();
            this.e.notifyDataSetChanged();
        }
    }
}
