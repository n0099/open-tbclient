package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import b.a.q0.e1.n.a;
import b.a.q0.s.u.c;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49373a;

    /* renamed from: b  reason: collision with root package name */
    public View f49374b;
    public TbRichTextView mContent;
    public boolean mCurrentStatus;
    public EMTextView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.f49373a = context;
        this.f49374b = view;
        initView(view);
    }

    public boolean getCurrentStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrentStatus : invokeV.booleanValue;
    }

    public final void initView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.mTitle = (EMTextView) view.findViewById(f1.forum_rule_item_title);
            TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(f1.forum_rule_item_content);
            this.mContent = tbRichTextView;
            tbRichTextView.setTextSize(TbadkApplication.getInst().getResources().getDimension(d1.T_X07));
            a layoutStrategy = this.mContent.getLayoutStrategy();
            layoutStrategy.o(TbadkApplication.getInst().getResources().getDimension(d1.tbds28), 1.0f);
            this.mContent.setLayoutStrategy(layoutStrategy);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mCurrentStatus) {
                c d2 = c.d(this.mTitle);
                d2.A(i1.F_X02);
                d2.v(c1.CAM_X0301);
                this.mContent.setTextColor(SkinManager.getColor(c1.CAM_X0301));
                return;
            }
            c d3 = c.d(this.mTitle);
            d3.A(i1.F_X02);
            d3.v(c1.CAM_X0105);
            this.mContent.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        }
    }

    public void setCurrentStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mCurrentStatus = z;
            onChangeSkinType();
        }
    }
}
