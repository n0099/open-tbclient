package com.baidu.tieba.homepage.topic.local;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.EllipsizeTagTitleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.jt;
import com.baidu.tieba.lk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LocalChannelTopicHolder extends TypeAdapter.ViewHolder implements jt {
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
        this.a = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f092778);
        this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092755);
        this.c = (EllipsizeTagTitleView) view2.findViewById(R.id.obfuscated_res_0x7f09278b);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09274c);
    }

    public void a(lk8 lk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lk8Var) == null) {
            this.b.setConrers(15);
            this.b.setPlaceHolder(1);
            this.b.startLoad(lk8Var.d, 10, false);
            this.c.setTitleAndTag(this.itemView.getContext().getString(R.string.local_channel_topic_wrap, lk8Var.a), lk8Var.c);
            if (!TextUtils.isEmpty(lk8Var.b)) {
                this.d.setText(lk8Var.b);
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.c;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i);
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            EMManager.from(this.a).setBackGroundSelectorColor(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}
