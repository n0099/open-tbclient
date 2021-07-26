package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
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
    public static BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f15440a;

    /* renamed from: b  reason: collision with root package name */
    public View f15441b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15442c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15443d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15444e;

    /* renamed from: f  reason: collision with root package name */
    public int f15445f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f15446g;

    /* renamed from: h  reason: collision with root package name */
    public int f15447h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15448i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNoListItemViewHolder f15449a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsNoListItemViewHolder frsNoListItemViewHolder, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNoListItemViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15449a = frsNoListItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f15449a.d(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNoListItemViewHolder f15450e;

        public b(FrsNoListItemViewHolder frsNoListItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNoListItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15450e = frsNoListItemViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) && this.f15450e.f(view)) {
                this.f15450e.d(Integer.MAX_VALUE);
            }
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
        j = BdUniqueId.gen();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, viewGroup};
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
        this.f15446g = new Rect();
        this.f15448i = new a(this, 2921397);
        this.f15441b = view;
        this.f15440a = viewGroup;
        this.f15442c = (LinearLayout) view.findViewById(R.id.container);
        this.f15444e = (ImageView) view.findViewById(R.id.emotion_view);
        this.f15443d = (TextView) view.findViewById(R.id.no_data_tips);
        SkinManager.setImageResource(this.f15444e, R.drawable.new_pic_emotion_06);
        this.f15448i.setTag(j);
        MessageManager.getInstance().registerListener(this.f15448i);
        e();
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f15441b == null || this.f15440a == null) {
            return;
        }
        if (this.f15445f <= 0) {
            this.f15445f = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i2 == Integer.MAX_VALUE && this.f15447h == Integer.MAX_VALUE) {
            return;
        }
        this.f15447h = i2;
        if (this.f15440a.getLocalVisibleRect(this.f15446g)) {
            int i3 = this.f15446g.bottom;
            int abs = Math.abs(this.f15442c.getTop());
            int abs2 = i3 - Math.abs(this.f15442c.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f15442c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f15445f;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f15442c.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f15442c.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f15442c.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public final void e() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f15441b) == null) {
            return;
        }
        view.addOnLayoutChangeListener(new b(this));
    }

    public final boolean f(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return view.getGlobalVisibleRect(this.f15446g);
        }
        return invokeL.booleanValue;
    }
}
