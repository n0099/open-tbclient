package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.e1;
import c.a.s0.d1.f1;
import c.a.s0.d1.g1;
import c.a.s0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.OriForumInfo;
/* loaded from: classes12.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44683e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44684f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44685g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44686h;

    /* renamed from: i  reason: collision with root package name */
    public int f44687i;

    /* renamed from: j  reason: collision with root package name */
    public int f44688j;

    /* renamed from: k  reason: collision with root package name */
    public OriForumInfo f44689k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationBarCellView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44683e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
            this.f44684f = (TbImageView) findViewById(f1.frs_brand_bar_cell_img);
            this.f44685g = (TextView) findViewById(f1.frs_brand_bar_cell_name);
            this.f44686h = (TextView) findViewById(f1.frs_brand_bar_cell_attention);
            this.f44684f.setDefaultResource(17170445);
            this.f44684f.setDefaultBgResource(c1.CAM_X0205);
            this.f44684f.setBorderColor(0);
            this.f44684f.setRadius(m.f(getContext(), d1.tbds20));
            this.f44684f.setConrers(5);
            this.f44687i = m.f(context, d1.tbds471);
            this.f44688j = m.f(context, d1.tbds164);
            setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f44683e) {
            return;
        }
        this.f44683e = skinType;
        SkinManager.setBackgroundResource(this, e1.cp_bg_line_d_e_selector);
        SkinManager.setViewTextColor(this.f44685g, c1.CAM_X0106);
        SkinManager.setViewTextColor(this.f44686h, c1.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c13110").param("obj_id", this.f44689k.ori_fid.longValue()));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.f44689k.ori_fname, "")));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f44687i, this.f44688j);
        }
    }

    public void setData(OriForumInfo oriForumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oriForumInfo) == null) {
            if (oriForumInfo == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f44689k = oriForumInfo;
            this.f44684f.startLoad(oriForumInfo.ori_avatar, 10, false);
            this.f44685g.setText(oriForumInfo.ori_fname);
            this.f44686h.setText(String.format(getContext().getString(i1.frs_brand_relation_bar_attention), StringHelper.numFormatOverWanNa(oriForumInfo.ori_member_num.longValue())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationBarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44683e = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationBarCellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44683e = 3;
        a(context);
    }
}
