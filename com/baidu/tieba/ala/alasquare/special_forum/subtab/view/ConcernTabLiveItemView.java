package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.c0.f.g.c.f;
import c.a.p0.h0.b;
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
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ConcernTabLiveItemView extends b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder i;
    public TbPageContext j;
    public int k;
    public String l;
    public String m;

    /* loaded from: classes5.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConcernTabLiveItemView a;

        /* renamed from: b  reason: collision with root package name */
        public View f31383b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f31384c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f31385d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f31386e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f31387f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f31388g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f31389h;
        public View i;
        public View.OnClickListener j;
        public final /* synthetic */ ConcernTabLiveItemView k;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {viewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.obfuscated_res_0x7f0909fb && (view.getTag() instanceof UserData)) {
                    if (!n.C()) {
                        this.a.k.j.showToast(R.string.obfuscated_res_0x7f0f0c15);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    this.a.k.i.f31388g.setVisibility(8);
                    this.a.k.i.f31389h.setVisibility(0);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = concernTabLiveItemView;
            this.j = new a(this);
            this.a = concernTabLiveItemView2;
            View k = concernTabLiveItemView2.k();
            this.f31383b = k;
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09194b);
            this.f31384c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.f31384c.setIsRound(true);
            this.f31384c.setAutoChangeStyle(false);
            this.f31384c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f31385d = (TextView) this.f31383b.findViewById(R.id.obfuscated_res_0x7f0912d7);
            this.f31386e = (TextView) this.f31383b.findViewById(R.id.obfuscated_res_0x7f0912db);
            this.i = this.f31383b.findViewById(R.id.obfuscated_res_0x7f090790);
            Drawable drawable = SkinManager.getDrawable(concernTabLiveItemView.f15305c.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, concernTabLiveItemView.f15305c.getResources().getDimensionPixelOffset(R.dimen.tbds8), concernTabLiveItemView.f15305c.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f31386e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f31387f = (TextView) this.f31383b.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f31388g = (TextView) this.f31383b.findViewById(R.id.obfuscated_res_0x7f0909fb);
            this.f31389h = (TextView) this.f31383b.findViewById(R.id.obfuscated_res_0x7f090a05);
            this.f31388g.setOnClickListener(this.j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 28;
        this.l = "";
        this.m = "";
        this.j = tbPageContext;
        this.i = new ViewHolder(this, this);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.m = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0789 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.i.f31385d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i.f31387f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i.f31389h, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i.f31388g, (int) R.color.common_color_10140);
            SkinManager.setViewTextColor(this.i.f31386e, (int) R.color.CAM_X0109);
            SkinManager.getDrawable(this.f15305c.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f15305c.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f15305c.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.i.f31386e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f15305c.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setBackgroundColor(this.i.i, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: t */
    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            UserData userData = fVar.a;
            if (userData != null) {
                if (!StringUtils.isNull(userData.getPortrait())) {
                    this.i.f31384c.J(fVar.a.getPortrait(), 12, false);
                }
                if (!StringUtils.isNull(fVar.a.getName_show())) {
                    this.i.f31385d.setText(fVar.a.getName_show());
                }
                if (fVar.f13079c) {
                    if (fVar.a.hadConcerned()) {
                        this.i.f31388g.setVisibility(8);
                        this.i.f31389h.setVisibility(0);
                    } else {
                        this.i.f31388g.setVisibility(0);
                        this.i.f31389h.setVisibility(8);
                    }
                } else {
                    this.i.f31388g.setVisibility(8);
                    this.i.f31389h.setVisibility(8);
                }
                this.i.f31388g.setTag(fVar.a);
            }
            AlaInfoData alaInfoData = fVar.f13078b;
            if (alaInfoData != null) {
                this.i.f31383b.setTag(alaInfoData);
                if (!StringUtils.isNull(fVar.f13078b.description)) {
                    String str = fVar.f13078b.description;
                    int i = this.k;
                    if (fVar.f13079c) {
                        i -= 9;
                    }
                    if (m.byteLength(str) > i) {
                        str = StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
                    }
                    this.i.f31387f.setText(str);
                }
            }
            if (fVar.f13079c) {
                TiebaStatic.log(new StatisticItem("c12895"));
            } else {
                StatisticItem statisticItem = new StatisticItem("c12893");
                statisticItem.addParam("fid", this.l);
                statisticItem.addParam("fname", this.m);
                AlaInfoData alaInfoData2 = fVar.f13078b;
                if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                    AlaInfoData alaInfoData3 = fVar.f13078b;
                    int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData3);
                    String str2 = StringUtils.isNull(alaInfoData3.appId) ? null : alaInfoData3.appId;
                    if (alaInfoData3.mYyExtData != null) {
                        str2 = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.addParam("obj_param1", calculateLiveType);
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
                    YYLiveUtil.calculateLiveType(fVar.f13078b);
                    TiebaStaticHelper.addYYParam(statisticItem, fVar.f13078b.mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            this.i.f31388g.setTag(fVar.a);
            m(j(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }
}
