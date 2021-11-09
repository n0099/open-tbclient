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
    public Context f49744a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f49745b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f49746c;

    /* renamed from: d  reason: collision with root package name */
    public int f49747d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f49748e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49749f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49750g;

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
            this.f49750g = homePageTabFeedCollegeSecondListAdapter;
            this.f49748e = specialColumnItemData;
            this.f49749f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49750g.f49746c == null) {
                return;
            }
            f fVar = this.f49750g.f49746c;
            SpecialColumnItemData specialColumnItemData = this.f49748e;
            int i2 = this.f49749f;
            fVar.a(view, specialColumnItemData, i2, i2);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f49751a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49752b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f49753c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f49754d;

        /* renamed from: e  reason: collision with root package name */
        public View f49755e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f49756f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49757g;

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
            this.f49757g = homePageTabFeedCollegeSecondListAdapter;
            this.f49753c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f49754d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f49751a = (TextView) view.findViewById(R.id.text_tv);
            this.f49752b = (TextView) view.findViewById(R.id.tv_content);
            this.f49755e = view.findViewById(R.id.gradient_cover);
            this.f49756f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f49752b.setText(specialColumnItemData.title);
            this.f49753c.setConrers(15);
            this.f49753c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f49753c.setDrawCorner(true);
            this.f49753c.setPlaceHolder(2);
            this.f49753c.startLoad(specialColumnItemData.image, 10, false);
            this.f49751a.setText(specialColumnItemData.text);
            this.f49754d.setVisibility(0);
            this.f49757g.f49747d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f49755e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f49757g.f49744a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f49755e);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f49758a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49759b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49760c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49761d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f49762e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f49763f;

        /* renamed from: g  reason: collision with root package name */
        public View f49764g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f49765h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f49766i;

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
            this.f49766i = homePageTabFeedCollegeSecondListAdapter;
            this.f49758a = (TextView) view.findViewById(R.id.tv_title);
            this.f49762e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f49759b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f49760c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f49763f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f49761d = (TextView) view.findViewById(R.id.text_tv);
            this.f49764g = view.findViewById(R.id.gradient_cover);
            this.f49765h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f49758a.setText(specialColumnItemData.title);
            this.f49762e.setConrers(15);
            this.f49762e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f49762e.setDrawCorner(true);
            this.f49762e.setPlaceHolder(2);
            this.f49762e.startLoad(specialColumnItemData.image, 10, false);
            this.f49762e.setGifIconSupport(false);
            this.f49760c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f49761d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f49763f.setVisibility(0);
                this.f49764g.setVisibility(0);
                this.f49764g.setAlpha(0.5f);
                this.f49761d.setVisibility(0);
                this.f49766i.f49747d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f49759b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(this.f49766i.f49744a, R.dimen.tbds10)).into(this.f49764g);
                return;
            }
            this.f49764g.setVisibility(8);
            this.f49763f.setVisibility(8);
            this.f49761d.setVisibility(8);
            this.f49766i.f49747d = 0;
            this.f49759b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
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
        this.f49746c = null;
        this.f49744a = context;
        this.f49745b = list;
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.f49758a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f49759b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f49760c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f49761d, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f49763f, this.f49747d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f49765h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f49752b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f49751a, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f49754d, this.f49747d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f49756f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public final SpecialColumnItemData e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f49745b, i2) : (SpecialColumnItemData) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f49745b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f49745b.get(i2).specialType;
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
                return new c(this, LayoutInflater.from(this.f49744a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
            }
            if (i2 == 3 || i2 == 4) {
                return new b(this, LayoutInflater.from(this.f49744a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setContentOnClickListener(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f49746c = fVar;
        }
    }

    public void setSpecialColumnItemDataArrayList(List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f49745b = list;
            notifyDataSetChanged();
        }
    }
}
