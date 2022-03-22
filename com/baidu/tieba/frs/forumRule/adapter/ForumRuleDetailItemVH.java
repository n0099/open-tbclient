package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import c.a.o0.e1.n.a;
import c.a.o0.r.v.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f32499b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f32500c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f32501d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32502e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.f32499b = view;
        c(view);
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f32500c = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a70);
            TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.obfuscated_res_0x7f090a6f);
            this.f32501d = tbRichTextView;
            tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
            a layoutStrategy = this.f32501d.getLayoutStrategy();
            layoutStrategy.o(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
            this.f32501d.setLayoutStrategy(layoutStrategy);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f32502e) {
                c d2 = c.d(this.f32500c);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0301);
                this.f32501d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                return;
            }
            c d3 = c.d(this.f32500c);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            this.f32501d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f32502e = z;
            d();
        }
    }
}
