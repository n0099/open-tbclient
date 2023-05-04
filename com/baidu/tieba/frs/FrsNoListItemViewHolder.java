package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId i;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public View b;
    public LinearLayout c;
    public NoDataView d;
    public int e;
    public Rect f;
    public int g;
    public CustomMessageListener h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNoListItemViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsNoListItemViewHolder frsNoListItemViewHolder, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNoListItemViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNoListItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            this.a.c(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNoListItemViewHolder a;

        public b(FrsNoListItemViewHolder frsNoListItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNoListItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNoListItemViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) != null) || !this.a.e(view2)) {
                return;
            }
            this.a.c(Integer.MAX_VALUE);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-8873337, "Lcom/baidu/tieba/frs/FrsNoListItemViewHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-8873337, "Lcom/baidu/tieba/frs/FrsNoListItemViewHolder;");
                return;
            }
        }
        i = BdUniqueId.gen();
    }

    public final void d() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (view2 = this.b) == null) {
            return;
        }
        view2.addOnLayoutChangeListener(new b(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNoListItemViewHolder(View view2, ViewGroup viewGroup) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new Rect();
        this.h = new a(this, 2921397);
        this.b = view2;
        this.a = viewGroup;
        NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 0);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090775);
        NoDataView a2 = NoDataViewFactory.a(view2.getContext(), this.c, b2, null, null);
        this.d = a2;
        a2.setVisibility(0);
        this.h.setTag(i);
        MessageManager.getInstance().registerListener(this.h);
        d();
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i2) != null) || this.b == null || this.a == null) {
            return;
        }
        if (this.e <= 0) {
            this.e = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i2 == Integer.MAX_VALUE && this.g == Integer.MAX_VALUE) {
            return;
        }
        this.g = i2;
        if (!this.a.getLocalVisibleRect(this.f)) {
            return;
        }
        int i3 = this.f.bottom;
        int abs = Math.abs(this.c.getTop());
        int abs2 = i3 - Math.abs(this.c.getBottom());
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i4 = this.e;
        if (abs < i4) {
            marginLayoutParams.topMargin = i4;
            this.c.setLayoutParams(marginLayoutParams);
        } else if (abs == i4) {
            if (abs2 > i4) {
                marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                this.c.setLayoutParams(marginLayoutParams);
            }
        } else if (abs > i4) {
            if (abs2 < i4) {
                marginLayoutParams.topMargin = i4;
            } else if (abs2 == i4) {
                marginLayoutParams.topMargin = i4;
            } else if (abs2 > i4) {
                marginLayoutParams.topMargin = (abs + abs2) / 2;
            }
            this.c.setLayoutParams(marginLayoutParams);
        }
    }

    public final boolean e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            return view2.getGlobalVisibleRect(this.f);
        }
        return invokeL.booleanValue;
    }
}
