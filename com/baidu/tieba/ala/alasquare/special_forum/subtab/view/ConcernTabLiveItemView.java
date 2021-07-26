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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.a0.b;
import d.a.q0.v.d.f.c.f;
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
        public ConcernTabLiveItemView f14189a;

        /* renamed from: b  reason: collision with root package name */
        public View f14190b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14191c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14192d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14193e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14194f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14195g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14196h;

        /* renamed from: i  reason: collision with root package name */
        public View f14197i;
        public View.OnClickListener j;
        public final /* synthetic */ ConcernTabLiveItemView k;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewHolder f14198e;

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
                this.f14198e = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                    if (!l.D()) {
                        this.f14198e.k.n.showToast(R.string.neterror);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    this.f14198e.k.m.f14195g.setVisibility(8);
                    this.f14198e.k.m.f14196h.setVisibility(0);
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
            this.f14189a = concernTabLiveItemView2;
            View k = concernTabLiveItemView2.k();
            this.f14190b = k;
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.protrait);
            this.f14191c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f14191c.setIsRound(true);
            this.f14191c.setAutoChangeStyle(false);
            this.f14191c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14192d = (TextView) this.f14190b.findViewById(R.id.live_title);
            this.f14193e = (TextView) this.f14190b.findViewById(R.id.living_tag);
            this.f14197i = this.f14190b.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(concernTabLiveItemView.f54321g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, concernTabLiveItemView.f54321g.getResources().getDimensionPixelOffset(R.dimen.tbds8), concernTabLiveItemView.f54321g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f14193e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14194f = (TextView) this.f14190b.findViewById(R.id.user_name);
            this.f14195g = (TextView) this.f14190b.findViewById(R.id.follow_btn);
            this.f14196h = (TextView) this.f14190b.findViewById(R.id.followed_btn);
            this.f14195g.setOnClickListener(this.j);
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

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.special_bar_concern_live_item : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.m.f14192d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m.f14194f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.f14196h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.f14195g, R.color.common_color_10140);
            SkinManager.setViewTextColor(this.m.f14193e, R.color.CAM_X0109);
            SkinManager.getDrawable(this.f54321g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f54321g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f54321g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.m.f14193e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f54321g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setBackgroundColor(this.m.f14197i, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: t */
    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            UserData userData = fVar.f65170e;
            if (userData != null) {
                if (!StringUtils.isNull(userData.getPortrait())) {
                    this.m.f14191c.M(fVar.f65170e.getPortrait(), 12, false);
                }
                if (!StringUtils.isNull(fVar.f65170e.getName_show())) {
                    this.m.f14192d.setText(fVar.f65170e.getName_show());
                }
                if (fVar.f65172g) {
                    if (fVar.f65170e.hadConcerned()) {
                        this.m.f14195g.setVisibility(8);
                        this.m.f14196h.setVisibility(0);
                    } else {
                        this.m.f14195g.setVisibility(0);
                        this.m.f14196h.setVisibility(8);
                    }
                } else {
                    this.m.f14195g.setVisibility(8);
                    this.m.f14196h.setVisibility(8);
                }
                this.m.f14195g.setTag(fVar.f65170e);
            }
            AlaInfoData alaInfoData = fVar.f65171f;
            if (alaInfoData != null) {
                this.m.f14190b.setTag(alaInfoData);
                if (!StringUtils.isNull(fVar.f65171f.description)) {
                    String str = fVar.f65171f.description;
                    int i2 = this.o;
                    if (fVar.f65172g) {
                        i2 -= 9;
                    }
                    if (k.byteLength(str) > i2) {
                        str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
                    }
                    this.m.f14194f.setText(str);
                }
            }
            if (fVar.f65172g) {
                TiebaStatic.log(new StatisticItem("c12895"));
            } else {
                StatisticItem statisticItem = new StatisticItem("c12893");
                AlaInfoData alaInfoData2 = fVar.f65171f;
                if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(statisticItem, fVar.f65171f.mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            this.m.f14195g.setTag(fVar.f65170e);
            m(j(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
