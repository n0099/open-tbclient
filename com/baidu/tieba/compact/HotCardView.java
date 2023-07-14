package com.baidu.tieba.compact;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.fc7;
import com.baidu.tieba.j18;
import com.baidu.tieba.t18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/compact/HotCardView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "recommendHotCardLayout", "Lcom/baidu/tieba/homepage/concern/view/RecommendHotCardLayout;", "onChangeSkin", "", "setData", "data", "Lcom/baidu/tieba/homepage/concern/data/RecommendHotCardData;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HotCardView extends FrameLayout implements fc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t18 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotCardView(Context context) {
        super(context);
        TbPageContext<BaseFragmentActivity> tbPageContext;
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
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        } else {
            tbPageContext = null;
        }
        t18 t18Var = new t18(tbPageContext);
        this.a = t18Var;
        addView(t18Var.h(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.tieba.fc7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void setData(j18 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a.l(data);
        }
    }
}
