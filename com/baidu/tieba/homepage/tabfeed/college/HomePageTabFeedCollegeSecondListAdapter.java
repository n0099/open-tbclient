package com.baidu.tieba.homepage.tabfeed.college;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.o0.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f33433b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f33434c;

    /* renamed from: d  reason: collision with root package name */
    public int f33435d;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialColumnItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f33436b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f33437c;

        public a(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, SpecialColumnItemData specialColumnItemData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, specialColumnItemData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33437c = homePageTabFeedCollegeSecondListAdapter;
            this.a = specialColumnItemData;
            this.f33436b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33437c.f33434c == null) {
                return;
            }
            f fVar = this.f33437c.f33434c;
            SpecialColumnItemData specialColumnItemData = this.a;
            int i = this.f33436b;
            fVar.a(view, specialColumnItemData, i, i);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f33438b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f33439c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f33440d;

        /* renamed from: e  reason: collision with root package name */
        public View f33441e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f33442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f33443g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view};
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
            this.f33443g = homePageTabFeedCollegeSecondListAdapter;
            this.f33439c = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090fda);
            this.f33440d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092367);
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f52);
            this.f33438b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092198);
            this.f33441e = view.findViewById(R.id.obfuscated_res_0x7f090ce1);
            this.f33442f = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0912fd);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f33438b.setText(specialColumnItemData.title);
            this.f33439c.setConrers(15);
            this.f33439c.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f33439c.setDrawCorner(true);
            this.f33439c.setPlaceHolder(2);
            this.f33439c.J(specialColumnItemData.image, 10, false);
            this.a.setText(specialColumnItemData.text);
            this.f33440d.setVisibility(0);
            this.f33443g.f33435d = R.drawable.obfuscated_res_0x7f0805ff;
            this.f33441e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(this.f33443g.a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f33441e);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f33444b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33445c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33446d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f33447e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f33448f;

        /* renamed from: g  reason: collision with root package name */
        public View f33449g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f33450h;
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view};
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
            this.i = homePageTabFeedCollegeSecondListAdapter;
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f33447e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091efe);
            this.f33444b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921cb);
            this.f33445c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921ca);
            this.f33448f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092367);
            this.f33446d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f52);
            this.f33449g = view.findViewById(R.id.obfuscated_res_0x7f090ce1);
            this.f33450h = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ad4);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.a.setText(specialColumnItemData.title);
            this.f33447e.setConrers(15);
            this.f33447e.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f33447e.setDrawCorner(true);
            this.f33447e.setPlaceHolder(2);
            this.f33447e.J(specialColumnItemData.image, 10, false);
            this.f33447e.setGifIconSupport(false);
            this.f33445c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e31), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f33446d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f33448f.setVisibility(0);
                this.f33449g.setVisibility(0);
                this.f33449g.setAlpha(0.5f);
                this.f33446d.setVisibility(0);
                this.i.f33435d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f33444b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e20), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(n.f(this.i.a, R.dimen.tbds10)).into(this.f33449g);
                return;
            }
            this.f33449g.setVisibility(8);
            this.f33448f.setVisibility(8);
            this.f33446d.setVisibility(8);
            this.i.f33435d = 0;
            this.f33444b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e32), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33434c = null;
        this.a = context;
        this.f33433b = list;
    }

    public final void g(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.a, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f33444b, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f33445c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f33446d, (int) R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f33448f, this.f33435d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f33450h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f33438b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f33440d, this.f33435d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f33442f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f33433b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int i2 = this.f33433b.get(i).specialType;
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            if (i2 == 3) {
                return 3;
            }
            if (i2 == 4) {
                return 4;
            }
            return super.getItemViewType(i);
        }
        return invokeI.intValue;
    }

    public final SpecialColumnItemData h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f33433b, i) : (SpecialColumnItemData) invokeI.objValue;
    }

    public void i(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f33434c = fVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) {
            SpecialColumnItemData h2 = h(i);
            if (viewHolder instanceof c) {
                ((c) viewHolder).a(h2);
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).a(h2);
            }
            viewHolder.itemView.setOnClickListener(new a(this, h2, i));
            g(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            if (i == 1 || i == 2) {
                return new c(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d049d, (ViewGroup) null));
            }
            if (i == 3 || i == 4) {
                return new b(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d049c, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
