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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bx;
import com.repackage.cx;
import com.repackage.kl4;
import com.repackage.li;
import com.repackage.vx6;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpecialTopicLayout extends LinearLayout implements cx, bx<SpecialColumnListData> {
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
    public int k;
    public kl4<SpecialColumnItemData> l;

    /* loaded from: classes3.dex */
    public static class HorizontalAdapter extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public ArrayList<SpecialColumnItemData> b;
        public kl4<SpecialColumnItemData> c;

        /* loaded from: classes3.dex */
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
                this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09233a);
                this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f3d);
                this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09217a);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fa4);
                this.b = tbImageView;
                tbImageView.setConrers(15);
                this.b.setRadius(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.b.setDrawCorner(true);
                this.b.setPlaceHolder(2);
                this.b.setGifIconSupport(false);
                this.c = view2.findViewById(R.id.obfuscated_res_0x7f090c99);
                this.itemView.setOnClickListener(this);
            }

            public void a(SpecialColumnItemData specialColumnItemData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                    return;
                }
                this.g = specialColumnItemData;
                this.b.K(specialColumnItemData.image, 10, false);
                this.f.setText(specialColumnItemData.text);
                this.d.setText(specialColumnItemData.title);
                c(this.g);
                if (this.i.c != null) {
                    this.i.c.c(this.itemView, this.g, getAdapterPosition(), getItemId());
                }
                b(TbadkCoreApplication.getInst().getSkinType());
            }

            public final void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    if (this.a != i) {
                        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
                        SkinManager.setBackgroundResourceSelector(this.itemView, R.color.CAM_X0205, R.color.CAM_X0204);
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, this.h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        TBSelector.makeDrawableSelector().setShape(0).gradient(R.color.CAM_X0601, R.color.CAM_X0607).cornerRadius(li.f(this.i.a.getPageActivity(), R.dimen.tbds10)).into(this.c);
                    }
                    this.a = i;
                }
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
                        this.h = R.drawable.obfuscated_res_0x7f0805eb;
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, this.h, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        this.e.setVisibility(8);
                        this.h = 0;
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
                    int adapterPosition = getAdapterPosition();
                    long itemId = getItemId();
                    if (this.i.c != null) {
                        this.i.c.a(this.itemView, this.g, adapterPosition, itemId);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) {
                aVar.a((SpecialColumnItemData) ListUtils.getItem(this.b, i));
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
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0774, (ViewGroup) null);
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
                ArrayList<SpecialColumnItemData> arrayList = this.b;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
            return invokeV.intValue;
        }

        public void h(kl4<SpecialColumnItemData> kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kl4Var) == null) {
                this.c = kl4Var;
            }
        }

        public void setData(List<SpecialColumnItemData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null) {
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements kl4<SpecialColumnItemData> {
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
        @Override // com.repackage.kl4
        /* renamed from: b */
        public void c(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            vx6.b("c13754", specialColumnItemData, i + 1, this.a.j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            if (r8 != 4) goto L14;
         */
        @Override // com.repackage.kl4
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.a.a.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                }
                vx6.a("c13754", specialColumnItemData, i + 1, this.a.j);
            }
            this.a.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getContext()).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
            vx6.a("c13754", specialColumnItemData, i + 1, this.a.j);
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d037f, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092030);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0921ff);
            this.c = (PullLeftRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091a22);
            this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a1b);
            this.h = findViewById(R.id.obfuscated_res_0x7f0907e3);
            this.i = findViewById(R.id.obfuscated_res_0x7f0907dd);
            this.e = new HorizontalAdapter(this.a);
            int f = li.f(this.a.getPageActivity(), R.dimen.tbds44);
            int f2 = li.f(this.a.getPageActivity(), R.dimen.tbds44);
            this.d.addItemDecoration(new SpaceItemDecoration(f, li.f(this.a.getPageActivity(), R.dimen.tbds11), f2));
            this.d.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            RefreshView refreshView = new RefreshView(getContext());
            this.b = refreshView;
            this.c.setRefreshViewAndListener(refreshView);
            this.e.h(this.l);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: e */
    public void a(SpecialColumnListData specialColumnListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumnListData) == null) || specialColumnListData == null) {
            return;
        }
        this.g.setText(specialColumnListData.title);
        this.e.setData(specialColumnListData.getListData());
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        HomeGroupUbsUIHelper.handleLine(this.h);
        onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, this.k);
            HomeGroupUbsUIHelper.handleLineColor(this.h);
            this.b.d();
            this.e.notifyDataSetChanged();
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (pullLeftRefreshLayout = this.c) == null) {
            return;
        }
        pullLeftRefreshLayout.setEnablePull(z);
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
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
        this.k = R.color.CAM_X0108;
        this.l = new a(this);
        this.a = tbPageContext;
        d();
    }
}
