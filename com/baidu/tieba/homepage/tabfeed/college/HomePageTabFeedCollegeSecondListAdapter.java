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
import c.a.e.e.p.l;
import c.a.q0.n.f;
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
/* loaded from: classes7.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52451a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f52452b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f52453c;

    /* renamed from: d  reason: collision with root package name */
    public int f52454d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f52455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f52457g;

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
            this.f52457g = homePageTabFeedCollegeSecondListAdapter;
            this.f52455e = specialColumnItemData;
            this.f52456f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52457g.f52453c == null) {
                return;
            }
            f fVar = this.f52457g.f52453c;
            SpecialColumnItemData specialColumnItemData = this.f52455e;
            int i2 = this.f52456f;
            fVar.a(view, specialColumnItemData, i2, i2);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f52458a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52459b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f52460c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f52461d;

        /* renamed from: e  reason: collision with root package name */
        public View f52462e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f52463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f52464g;

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
            this.f52464g = homePageTabFeedCollegeSecondListAdapter;
            this.f52460c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f52461d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f52458a = (TextView) view.findViewById(R.id.text_tv);
            this.f52459b = (TextView) view.findViewById(R.id.tv_content);
            this.f52462e = view.findViewById(R.id.gradient_cover);
            this.f52463f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f52459b.setText(specialColumnItemData.title);
            this.f52460c.setConrers(15);
            this.f52460c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f52460c.setDrawCorner(true);
            this.f52460c.setPlaceHolder(2);
            this.f52460c.startLoad(specialColumnItemData.image, 10, false);
            this.f52458a.setText(specialColumnItemData.text);
            this.f52461d.setVisibility(0);
            this.f52464g.f52454d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f52462e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f52464g.f52451a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f52462e);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f52465a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52466b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52467c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f52468d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f52469e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f52470f;

        /* renamed from: g  reason: collision with root package name */
        public View f52471g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f52472h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondListAdapter f52473i;

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
            this.f52473i = homePageTabFeedCollegeSecondListAdapter;
            this.f52465a = (TextView) view.findViewById(R.id.tv_title);
            this.f52469e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f52466b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f52467c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f52470f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f52468d = (TextView) view.findViewById(R.id.text_tv);
            this.f52471g = view.findViewById(R.id.gradient_cover);
            this.f52472h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, specialColumnItemData) == null) || specialColumnItemData == null) {
                return;
            }
            this.f52465a.setText(specialColumnItemData.title);
            this.f52469e.setConrers(15);
            this.f52469e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f52469e.setDrawCorner(true);
            this.f52469e.setPlaceHolder(2);
            this.f52469e.startLoad(specialColumnItemData.image, 10, false);
            this.f52469e.setGifIconSupport(false);
            this.f52467c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f52468d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f52470f.setVisibility(0);
                this.f52471g.setVisibility(0);
                this.f52471g.setAlpha(0.5f);
                this.f52468d.setVisibility(0);
                this.f52473i.f52454d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f52466b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(this.f52473i.f52451a, R.dimen.tbds10)).into(this.f52471g);
                return;
            }
            this.f52471g.setVisibility(8);
            this.f52470f.setVisibility(8);
            this.f52468d.setVisibility(8);
            this.f52473i.f52454d = 0;
            this.f52466b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
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
        this.f52453c = null;
        this.f52451a = context;
        this.f52452b = list;
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                SkinManager.setViewTextColor(cVar.f52465a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(cVar.f52466b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f52467c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(cVar.f52468d, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f52470f, this.f52454d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(cVar.f52472h, R.color.CAM_X0205, R.color.CAM_X0204);
            } else if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                SkinManager.setViewTextColor(bVar.f52459b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f52458a, R.color.CAM_X0101);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f52461d, this.f52454d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                TBSelector.setViewBackgroundColorWithPressedState(bVar.f52463f, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public final SpecialColumnItemData e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (SpecialColumnItemData) ListUtils.getItem(this.f52452b, i2) : (SpecialColumnItemData) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f52452b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f52452b.get(i2).specialType;
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
                return new c(this, LayoutInflater.from(this.f52451a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
            }
            if (i2 == 3 || i2 == 4) {
                return new b(this, LayoutInflater.from(this.f52451a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setContentOnClickListener(f<SpecialColumnItemData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f52453c = fVar;
        }
    }

    public void setSpecialColumnItemDataArrayList(List<SpecialColumnItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f52452b = list;
            notifyDataSetChanged();
        }
    }
}
