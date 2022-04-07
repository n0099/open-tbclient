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
import com.repackage.lm4;
import com.repackage.oi;
import java.util.List;
/* loaded from: classes3.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<SpecialColumnItemData> b;
    public lm4<SpecialColumnItemData> c;
    public int d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialColumnItemData a;
        public final /* synthetic */ int b;
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter c;

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
            this.c = homePageTabFeedCollegeSecondListAdapter;
            this.a = specialColumnItemData;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.c == null) {
                return;
            }
            lm4 lm4Var = this.c.c;
            SpecialColumnItemData specialColumnItemData = this.a;
            int i = this.b;
            lm4Var.a(view2, specialColumnItemData, i, i);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TbImageView c;
        public ImageView d;
        public View e;
        public LinearLayout f;
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view2};
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
            this.g = homePageTabFeedCollegeSecondListAdapter;
            this.c = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fd4);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092344);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f3e);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09217c);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090ce8);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0912f0);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.b.setText(specialColumnItemData.title);
            this.c.setConrers(15);
            this.c.setRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.c.setDrawCorner(true);
            this.c.setPlaceHolder(2);
            this.c.K(specialColumnItemData.image, 10, false);
            this.a.setText(specialColumnItemData.text);
            this.d.setVisibility(0);
            this.g.d = R.drawable.obfuscated_res_0x7f0805fe;
            this.e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(oi.f(this.g.a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.e);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TbImageView e;
        public ImageView f;
        public View g;
        public RelativeLayout h;
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view2};
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092201);
            this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091eea);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ae);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ad);
            this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092344);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f3e);
            this.g = view2.findViewById(R.id.obfuscated_res_0x7f090ce8);
            this.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac4);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.a.setText(specialColumnItemData.title);
            this.e.setConrers(15);
            this.e.setRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.e.setDrawCorner(true);
            this.e.setPlaceHolder(2);
            this.e.K(specialColumnItemData.image, 10, false);
            this.e.setGifIconSupport(false);
            this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e35), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.g.setAlpha(0.5f);
                this.d.setVisibility(0);
                this.i.d = R.drawable.ic_icon_pure_video_play12_svg;
                this.b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e24), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(oi.f(this.i.a, R.dimen.tbds10)).into(this.g);
                return;
            }
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.d.setVisibility(8);
            this.i.d = 0;
            this.b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e36), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
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
        this.c = null;
        this.a = context;
        this.b = list;
    }

    public final void g(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.a, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.b, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.d, (int) R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f, this.d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.d, this.d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int i2 = this.b.get(i).specialType;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.b, i) : (SpecialColumnItemData) invokeI.objValue;
    }

    public void i(lm4<SpecialColumnItemData> lm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lm4Var) == null) {
            this.c = lm4Var;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) {
            SpecialColumnItemData h = h(i);
            if (viewHolder instanceof c) {
                ((c) viewHolder).a(h);
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).a(h);
            }
            viewHolder.itemView.setOnClickListener(new a(this, h, i));
            g(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            if (i == 1 || i == 2) {
                return new c(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0498, (ViewGroup) null));
            }
            if (i == 3 || i == 4) {
                return new b(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0497, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
