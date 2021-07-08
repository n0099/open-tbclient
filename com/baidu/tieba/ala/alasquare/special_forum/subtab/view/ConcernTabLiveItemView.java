package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.p0.a0.b;
import d.a.p0.v.d.f.c.f;
/* loaded from: classes4.dex */
public class ConcernTabLiveItemView extends b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder m;
    public TbPageContext n;
    public int o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ConcernTabLiveItemView f14141a;

        /* renamed from: b  reason: collision with root package name */
        public View f14142b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14143c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14144d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14145e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14146f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14147g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14148h;

        /* renamed from: i  reason: collision with root package name */
        public View f14149i;
        public View.OnClickListener j;
        public final /* synthetic */ ConcernTabLiveItemView k;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewHolder f14150e;

            public a(ViewHolder viewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {viewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14150e = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                    if (!l.D()) {
                        this.f14150e.k.n.showToast(R.string.neterror);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    this.f14150e.k.m.f14147g.setVisibility(8);
                    this.f14150e.k.m.f14148h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView, ConcernTabLiveItemView concernTabLiveItemView2) {
            super(concernTabLiveItemView2.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabLiveItemView, concernTabLiveItemView2};
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
            this.k = concernTabLiveItemView;
            this.j = new a(this);
            this.f14141a = concernTabLiveItemView2;
            View k = concernTabLiveItemView2.k();
            this.f14142b = k;
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.protrait);
            this.f14143c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14143c.setIsRound(true);
            this.f14143c.setAutoChangeStyle(false);
            this.f14143c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14144d = (TextView) this.f14142b.findViewById(R.id.live_title);
            this.f14145e = (TextView) this.f14142b.findViewById(R.id.living_tag);
            this.f14149i = this.f14142b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(concernTabLiveItemView.f53778g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, concernTabLiveItemView.f53778g.getResources().getDimensionPixelOffset(R.dimen.tbds8), concernTabLiveItemView.f53778g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14145e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14146f = (TextView) this.f14142b.findViewById(R.id.user_name);
            this.f14147g = (TextView) this.f14142b.findViewById(R.id.follow_btn);
            this.f14148h = (TextView) this.f14142b.findViewById(R.id.followed_btn);
            this.f14147g.setOnClickListener(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 28;
        this.n = tbPageContext;
        this.m = new ViewHolder(this, this);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.special_bar_concern_live_item : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.m.f14144d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m.f14146f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.f14148h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.f14147g, R.color.common_color_10140);
            SkinManager.setViewTextColor(this.m.f14145e, R.color.CAM_X0109);
            SkinManager.getDrawable(this.f53778g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f53778g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f53778g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.m.f14145e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f53778g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setBackgroundColor(this.m.f14149i, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: t */
    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            UserData userData = fVar.f64525e;
            if (userData != null) {
                if (!StringUtils.isNull(userData.getPortrait())) {
                    this.m.f14143c.M(fVar.f64525e.getPortrait(), 12, false);
                }
                if (!StringUtils.isNull(fVar.f64525e.getName_show())) {
                    this.m.f14144d.setText(fVar.f64525e.getName_show());
                }
                if (fVar.f64527g) {
                    if (fVar.f64525e.hadConcerned()) {
                        this.m.f14147g.setVisibility(8);
                        this.m.f14148h.setVisibility(0);
                    } else {
                        this.m.f14147g.setVisibility(0);
                        this.m.f14148h.setVisibility(8);
                    }
                } else {
                    this.m.f14147g.setVisibility(8);
                    this.m.f14148h.setVisibility(8);
                }
                this.m.f14147g.setTag(fVar.f64525e);
            }
            AlaInfoData alaInfoData = fVar.f64526f;
            if (alaInfoData != null) {
                this.m.f14142b.setTag(alaInfoData);
                if (!StringUtils.isNull(fVar.f64526f.description)) {
                    String str = fVar.f64526f.description;
                    int i2 = this.o;
                    if (fVar.f64527g) {
                        i2 -= 9;
                    }
                    if (k.byteLength(str) > i2) {
                        str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                    }
                    this.m.f14146f.setText(str);
                }
            }
            if (fVar.f64527g) {
                TiebaStatic.log(new StatisticItem("c12895"));
            } else {
                StatisticItem statisticItem = new StatisticItem("c12893");
                AlaInfoData alaInfoData2 = fVar.f64526f;
                if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(statisticItem, fVar.f64526f.mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            this.m.f14147g.setTag(fVar.f64525e);
            m(j(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
