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
import b.a.e.e.p.l;
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
    public Context f49745a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f49746b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f49747c;

    /* renamed from: d  reason: collision with root package name */
    public int f49748d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f49749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49751g;

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
            this.f49751g = homePageTabFeedCollegeSecondListAdapter;
            this.f49749e = specialColumnItemData;
            this.f49750f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49751g.f49747c == null) {
                return;
            }
            f fVar = this.f49751g.f49747c;
            SpecialColumnItemData specialColumnItemData = this.f49749e;
            int i2 = this.f49750f;
            fVar.a(view, specialColumnItemData, i2, i2);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f49752a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49753b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f49754c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f49755d;

        /* renamed from: e  reason: collision with root package name */
        public View f49756e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f49757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49758g;

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
            this.f49758g = homePageTabFeedCollegeSecondListAdapter;
            this.f49754c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f49755d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f49752a = (TextView) view.findViewById(R.id.text_tv);
            this.f49753b = (TextView) view.findViewById(R.id.tv_content);
            this.f49756e = view.findViewById(R.id.gradient_cover);
            this.f49757f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f49753b.setText(specialColumnItemData.title);
            this.f49754c.setConrers(15);
            this.f49754c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f49754c.setDrawCorner(true);
            this.f49754c.setPlaceHolder(2);
            this.f49754c.startLoad(specialColumnItemData.image, 10, false);
            this.f49752a.setText(specialColumnItemData.text);
            this.f49755d.setVisibility(0);
            this.f49758g.f49748d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f49756e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f49758g.f49745a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f49756e);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f49759a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49760b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49761c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49762d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f49763e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f49764f;

        /* renamed from: g  reason: collision with root package name */
        public View f49765g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f49766h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49767i;

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
            this.f49767i = homePageTabFeedCollegeSecondListAdapter;
            this.f49759a = (TextView) view.findViewById(R.id.tv_title);
            this.f49763e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f49760b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f49761c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f49764f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f49762d = (TextView) view.findViewById(R.id.text_tv);
            this.f49765g = view.findViewById(R.id.gradient_cover);
            this.f49766h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f49759a.setText(specialColumnItemData.title);
            this.f49763e.setConrers(15);
            this.f49763e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f49763e.setDrawCorner(true);
            this.f49763e.setPlaceHolder(2);
            this.f49763e.startLoad(specialColumnItemData.image, 10, false);
            this.f49763e.setGifIconSupport(false);
            this.f49761c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f49762d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f49764f.setVisibility(0);
                this.f49765g.setVisibility(0);
                this.f49765g.setAlpha(0.5f);
                this.f49762d.setVisibility(0);
                this.f49767i.f49748d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f49760b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(this.f49767i.f49745a, R.dimen.tbds10)).into(this.f49765g);
                return;
            }
            this.f49765g.setVisibility(8);
            this.f49764f.setVisibility(8);
            this.f49762d.setVisibility(8);
            this.f49767i.f49748d = 0;
            this.f49760b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
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
        this.f49747c = null;
        this.f49745a = context;
        this.f49746b = list;
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.f49759a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f49760b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f49761c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f49762d, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f49764f, this.f49748d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f49766h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f49753b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f49752a, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f49755d, this.f49748d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f49757f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public final SpecialColumnItemData e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f49746b, i2) : (SpecialColumnItemData) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f49746b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f49746b.get(i2).specialType;
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
                return new c(this, LayoutInflater.from(this.f49745a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
            }
            if (i2 == 3 || i2 == 4) {
                return new b(this, LayoutInflater.from(this.f49745a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setContentOnClickListener(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f49747c = fVar;
        }
    }

    public void setSpecialColumnItemDataArrayList(List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f49746b = list;
            notifyDataSetChanged();
        }
    }
}
