package com.baidu.tieba.homepage.topic.local;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.EllipsizeTagTitleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hv4;
import com.baidu.tieba.u47;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LocalChannelTopicHolder extends TypeAdapter.ViewHolder implements xx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintLayout a;
    public TbImageView b;
    public EllipsizeTagTitleView c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalChannelTopicHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922fa);
        this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922d8);
        this.c = (EllipsizeTagTitleView) view2.findViewById(R.id.obfuscated_res_0x7f092314);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922c5);
    }

    public void a(u47 u47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u47Var) == null) {
            this.b.setConrers(15);
            this.b.setPlaceHolder(1);
            this.b.K(u47Var.d, 10, false);
            this.c.setTitleAndTag(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0a5f, u47Var.a), u47Var.c);
            if (!TextUtils.isEmpty(u47Var.b)) {
                this.d.setText(u47Var.b);
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.c;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i);
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            hv4.d(this.a).i(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}
