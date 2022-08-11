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
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz5;
import com.repackage.ft5;
import com.repackage.pi;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class ConcernTabLiveItemView extends bz5<ft5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder i;
    public TbPageContext j;
    public int k;
    public String l;
    public String m;

    /* loaded from: classes3.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConcernTabLiveItemView a;
        public View b;
        public TbImageView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public View i;
        public View.OnClickListener j;
        public final /* synthetic */ ConcernTabLiveItemView k;

        /* loaded from: classes3.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090a10 && (view2.getTag() instanceof UserData)) {
                    if (!qi.D()) {
                        this.a.k.j.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                        return;
                    }
                    UserData userData = (UserData) view2.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    this.a.k.i.g.setVisibility(8);
                    this.a.k.i.h.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView, ConcernTabLiveItemView concernTabLiveItemView2) {
            super(concernTabLiveItemView2.h());
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
            View h = concernTabLiveItemView2.h();
            this.b = h;
            TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f091a96);
            this.c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.c.setIsRound(true);
            this.c.setAutoChangeStyle(false);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0913aa);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0913ba);
            this.i = this.b.findViewById(R.id.obfuscated_res_0x7f090798);
            Drawable drawable = SkinManager.getDrawable(concernTabLiveItemView.c.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, concernTabLiveItemView.c.getResources().getDimensionPixelOffset(R.dimen.tbds8), concernTabLiveItemView.c.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092450);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a10);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a1b);
            this.g.setOnClickListener(this.j);
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

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d07ba : invokeV.intValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.i.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i.h, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i.g, (int) R.color.common_color_10140);
            SkinManager.setViewTextColor(this.i.e, (int) R.color.CAM_X0109);
            SkinManager.getDrawable(this.c.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.c.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.i.e.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.c.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setBackgroundColor(this.i.i, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: t */
    public void i(ft5 ft5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ft5Var) == null) {
            UserData userData = ft5Var.a;
            if (userData != null) {
                if (!StringUtils.isNull(userData.getPortrait())) {
                    this.i.c.K(ft5Var.a.getPortrait(), 12, false);
                }
                if (!StringUtils.isNull(ft5Var.a.getName_show())) {
                    this.i.d.setText(ft5Var.a.getName_show());
                }
                if (ft5Var.c) {
                    if (ft5Var.a.hadConcerned()) {
                        this.i.g.setVisibility(8);
                        this.i.h.setVisibility(0);
                    } else {
                        this.i.g.setVisibility(0);
                        this.i.h.setVisibility(8);
                    }
                } else {
                    this.i.g.setVisibility(8);
                    this.i.h.setVisibility(8);
                }
                this.i.g.setTag(ft5Var.a);
            }
            AlaInfoData alaInfoData = ft5Var.b;
            if (alaInfoData != null) {
                this.i.b.setTag(alaInfoData);
                if (!StringUtils.isNull(ft5Var.b.description)) {
                    String str = ft5Var.b.description;
                    int i = this.k;
                    if (ft5Var.c) {
                        i -= 9;
                    }
                    if (pi.byteLength(str) > i) {
                        str = StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
                    }
                    this.i.f.setText(str);
                }
            }
            if (ft5Var.c) {
                TiebaStatic.log(new StatisticItem("c12895"));
            } else {
                StatisticItem statisticItem = new StatisticItem("c12893");
                statisticItem.addParam("fid", this.l);
                statisticItem.addParam("fname", this.m);
                AlaInfoData alaInfoData2 = ft5Var.b;
                if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                    AlaInfoData alaInfoData3 = ft5Var.b;
                    int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData3);
                    String str2 = StringUtils.isNull(alaInfoData3.appId) ? null : alaInfoData3.appId;
                    if (alaInfoData3.mYyExtData != null) {
                        str2 = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.addParam("obj_param1", calculateLiveType);
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
                    YYLiveUtil.calculateLiveType(ft5Var.b);
                    TiebaStaticHelper.addYYParam(statisticItem, ft5Var.b.mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            this.i.g.setTag(ft5Var.a);
            j(g(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }
}
