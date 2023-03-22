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
import com.baidu.tieba.hx;
import com.baidu.tieba.jk7;
import com.baidu.tieba.n15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LocalChannelTopicHolder extends TypeAdapter.ViewHolder implements hx {
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
        this.a = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924e8);
        this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924c5);
        this.c = (EllipsizeTagTitleView) view2.findViewById(R.id.obfuscated_res_0x7f092502);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b2);
    }

    public void a(jk7 jk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jk7Var) == null) {
            this.b.setConrers(15);
            this.b.setPlaceHolder(1);
            this.b.M(jk7Var.d, 10, false);
            this.c.setTitleAndTag(this.itemView.getContext().getString(R.string.local_channel_topic_wrap, jk7Var.a), jk7Var.c);
            if (!TextUtils.isEmpty(jk7Var.b)) {
                this.d.setText(jk7Var.b);
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.c;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i);
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            n15.d(this.a).j(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}
