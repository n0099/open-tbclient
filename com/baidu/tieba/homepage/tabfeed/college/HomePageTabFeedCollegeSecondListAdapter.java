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
import d.a.c.e.p.l;
import d.a.o0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16829a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f16830b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f16831c;

    /* renamed from: d  reason: collision with root package name */
    public int f16832d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f16833e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16834f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f16835g;

        public a(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, SpecialColumnItemData specialColumnItemData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, specialColumnItemData, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16835g = homePageTabFeedCollegeSecondListAdapter;
            this.f16833e = specialColumnItemData;
            this.f16834f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16835g.f16831c == null) {
                return;
            }
            f fVar = this.f16835g.f16831c;
            SpecialColumnItemData specialColumnItemData = this.f16833e;
            int i2 = this.f16834f;
            fVar.a(view, specialColumnItemData, i2, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f16836a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16837b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16838c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16839d;

        /* renamed from: e  reason: collision with root package name */
        public View f16840e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f16842g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view};
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
            this.f16842g = homePageTabFeedCollegeSecondListAdapter;
            this.f16838c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f16839d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16836a = (TextView) view.findViewById(R.id.text_tv);
            this.f16837b = (TextView) view.findViewById(R.id.tv_content);
            this.f16840e = view.findViewById(R.id.gradient_cover);
            this.f16841f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f16837b.setText(specialColumnItemData.title);
            this.f16838c.setConrers(15);
            this.f16838c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16838c.setDrawCorner(true);
            this.f16838c.setPlaceHolder(2);
            this.f16838c.M(specialColumnItemData.image, 10, false);
            this.f16836a.setText(specialColumnItemData.text);
            this.f16839d.setVisibility(0);
            this.f16842g.f16832d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f16840e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f16842g.f16829a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f16840e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f16843a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16844b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16845c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16846d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16847e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f16848f;

        /* renamed from: g  reason: collision with root package name */
        public View f16849g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f16850h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f16851i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedCollegeSecondListAdapter homePageTabFeedCollegeSecondListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondListAdapter, view};
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
            this.f16851i = homePageTabFeedCollegeSecondListAdapter;
            this.f16843a = (TextView) view.findViewById(R.id.tv_title);
            this.f16847e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f16844b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f16845c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f16848f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16846d = (TextView) view.findViewById(R.id.text_tv);
            this.f16849g = view.findViewById(R.id.gradient_cover);
            this.f16850h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f16843a.setText(specialColumnItemData.title);
            this.f16847e.setConrers(15);
            this.f16847e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16847e.setDrawCorner(true);
            this.f16847e.setPlaceHolder(2);
            this.f16847e.M(specialColumnItemData.image, 10, false);
            this.f16847e.setGifIconSupport(false);
            this.f16845c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f16846d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f16848f.setVisibility(0);
                this.f16849g.setVisibility(0);
                this.f16849g.setAlpha(0.5f);
                this.f16846d.setVisibility(0);
                this.f16851i.f16832d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f16844b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(this.f16851i.f16829a, R.dimen.tbds10)).into(this.f16849g);
                return;
            }
            this.f16849g.setVisibility(8);
            this.f16848f.setVisibility(8);
            this.f16846d.setVisibility(8);
            this.f16851i.f16832d = 0;
            this.f16844b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16831c = null;
        this.f16829a = context;
        this.f16830b = list;
    }

    public final void g(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.f16843a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f16844b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f16845c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f16846d, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f16848f, this.f16832d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f16850h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f16837b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f16836a, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16839d, this.f16832d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f16841f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f16830b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.f16830b.get(i2).specialType;
            if (i3 == 1) {
                return 1;
            }
            if (i3 == 2) {
                return 2;
            }
            if (i3 == 3) {
                return 3;
            }
            if (i3 == 4) {
                return 4;
            }
            return super.getItemViewType(i2);
        }
        return invokeI.intValue;
    }

    public final SpecialColumnItemData h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f16830b, i2) : (SpecialColumnItemData) invokeI.objValue;
    }

    public void i(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f16831c = fVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) {
            SpecialColumnItemData h2 = h(i2);
            if (viewHolder instanceof c) {
                ((c) viewHolder).a(h2);
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).a(h2);
            }
            viewHolder.itemView.setOnClickListener(new a(this, h2, i2));
            g(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == 1 || i2 == 2) {
                return new c(this, LayoutInflater.from(this.f16829a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
            }
            if (i2 == 3 || i2 == 4) {
                return new b(this, LayoutInflater.from(this.f16829a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
