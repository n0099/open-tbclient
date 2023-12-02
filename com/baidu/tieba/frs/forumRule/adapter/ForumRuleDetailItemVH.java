package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.py5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public EMTextView c;
    public TbRichTextView d;
    public boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailItemVH(Context context, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
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
        this.a = context;
        this.b = view2;
        a(view2);
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.c = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c69);
            TbRichTextView tbRichTextView = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c68);
            this.d = tbRichTextView;
            tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
            py5 layoutStrategy = this.d.getLayoutStrategy();
            layoutStrategy.p(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
            this.d.setLayoutStrategy(layoutStrategy);
            onChangeSkinType();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.e = z;
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.e) {
                EMManager.from(this.c).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0301);
                this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                return;
            }
            EMManager.from(this.c).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
