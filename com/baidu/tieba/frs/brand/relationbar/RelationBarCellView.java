package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.OriForumInfo;
/* loaded from: classes5.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public int e;
    public int f;
    public OriForumInfo g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationBarCellView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationBarCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0350, (ViewGroup) this, true);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090c79);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090c7a);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090c78);
            this.b.setDefaultResource(17170445);
            this.b.setDefaultBgResource(R.color.CAM_X0205);
            this.b.setBorderColor(0);
            this.b.setRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds20));
            this.b.setConrers(5);
            this.e = BdUtilHelper.getDimens(context, R.dimen.tbds471);
            this.f = BdUtilHelper.getDimens(context, R.dimen.tbds164);
            setOnClickListener(this);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setBackgroundResource(this, R.drawable.cp_bg_line_d_e_selector);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13110").param("obj_id", this.g.ori_fid.longValue()));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.g.ori_fname, "")));
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
            this.g = oriForumInfo;
            this.b.startLoad(oriForumInfo.ori_avatar, 10, false);
            this.c.setText(oriForumInfo.ori_fname);
            this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f07fc), StringHelper.numFormatOverWanNa(oriForumInfo.ori_member_num.longValue())));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.e, this.f);
        }
    }
}
