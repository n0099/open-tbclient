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
import b.a.e.f.p.l;
import b.a.q0.n.f;
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
/* loaded from: classes9.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f50656a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f50657b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f50658c;

    /* renamed from: d  reason: collision with root package name */
    public int f50659d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f50660e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50661f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f50662g;

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
            this.f50662g = homePageTabFeedCollegeSecondListAdapter;
            this.f50660e = specialColumnItemData;
            this.f50661f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50662g.f50658c == null) {
                return;
            }
            f fVar = this.f50662g.f50658c;
            SpecialColumnItemData specialColumnItemData = this.f50660e;
            int i2 = this.f50661f;
            fVar.a(view, specialColumnItemData, i2, i2);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50663a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50664b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f50665c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f50666d;

        /* renamed from: e  reason: collision with root package name */
        public View f50667e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f50668f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f50669g;

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
            this.f50669g = homePageTabFeedCollegeSecondListAdapter;
            this.f50665c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f50666d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f50663a = (TextView) view.findViewById(R.id.text_tv);
            this.f50664b = (TextView) view.findViewById(R.id.tv_content);
            this.f50667e = view.findViewById(R.id.gradient_cover);
            this.f50668f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f50664b.setText(specialColumnItemData.title);
            this.f50665c.setConrers(15);
            this.f50665c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f50665c.setDrawCorner(true);
            this.f50665c.setPlaceHolder(2);
            this.f50665c.startLoad(specialColumnItemData.image, 10, false);
            this.f50663a.setText(specialColumnItemData.text);
            this.f50666d.setVisibility(0);
            this.f50669g.f50659d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f50667e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f50669g.f50656a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f50667e);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50670a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50671b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50672c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50673d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f50674e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f50675f;

        /* renamed from: g  reason: collision with root package name */
        public View f50676g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f50677h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f50678i;

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
            this.f50678i = homePageTabFeedCollegeSecondListAdapter;
            this.f50670a = (TextView) view.findViewById(R.id.tv_title);
            this.f50674e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f50671b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f50672c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f50675f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f50673d = (TextView) view.findViewById(R.id.text_tv);
            this.f50676g = view.findViewById(R.id.gradient_cover);
            this.f50677h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f50670a.setText(specialColumnItemData.title);
            this.f50674e.setConrers(15);
            this.f50674e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f50674e.setDrawCorner(true);
            this.f50674e.setPlaceHolder(2);
            this.f50674e.startLoad(specialColumnItemData.image, 10, false);
            this.f50674e.setGifIconSupport(false);
            this.f50672c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f50673d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f50675f.setVisibility(0);
                this.f50676g.setVisibility(0);
                this.f50676g.setAlpha(0.5f);
                this.f50673d.setVisibility(0);
                this.f50678i.f50659d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f50671b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(this.f50678i.f50656a, R.dimen.tbds10)).into(this.f50676g);
                return;
            }
            this.f50676g.setVisibility(8);
            this.f50675f.setVisibility(8);
            this.f50673d.setVisibility(8);
            this.f50678i.f50659d = 0;
            this.f50671b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
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
        this.f50658c = null;
        this.f50656a = context;
        this.f50657b = list;
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.f50670a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f50671b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f50672c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f50673d, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f50675f, this.f50659d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f50677h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f50664b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f50663a, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f50666d, this.f50659d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f50668f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public final SpecialColumnItemData e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f50657b, i2) : (SpecialColumnItemData) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f50657b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f50657b.get(i2).specialType;
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i2) == null) {
            SpecialColumnItemData e2 = e(i2);
            if (viewHolder instanceof c) {
                ((c) viewHolder).a(e2);
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).a(e2);
            }
            viewHolder.itemView.setOnClickListener(new a(this, e2, i2));
            d(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            if (i2 == 1 || i2 == 2) {
                return new c(this, LayoutInflater.from(this.f50656a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
            }
            if (i2 == 3 || i2 == 4) {
                return new b(this, LayoutInflater.from(this.f50656a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setContentOnClickListener(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f50658c = fVar;
        }
    }

    public void setSpecialColumnItemDataArrayList(List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f50657b = list;
            notifyDataSetChanged();
        }
    }
}
