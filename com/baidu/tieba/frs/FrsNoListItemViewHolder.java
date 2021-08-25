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
/* loaded from: classes7.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId SCROLL_LISTENER_TAG;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f50722a;

    /* renamed from: b  reason: collision with root package name */
    public View f50723b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f50724c;

    /* renamed from: d  reason: collision with root package name */
    public int f50725d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f50726e;

    /* renamed from: f  reason: collision with root package name */
    public int f50727f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f50728g;
    public ImageView mEmotionView;
    public TextView mNodataTextView;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNoListItemViewHolder f50729a;

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
            this.f50729a = frsNoListItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f50729a.c(num.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNoListItemViewHolder f50730e;

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
            this.f50730e = frsNoListItemViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) && this.f50730e.e(view)) {
                this.f50730e.c(Integer.MAX_VALUE);
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
        SCROLL_LISTENER_TAG = BdUniqueId.gen();
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
        this.f50726e = new Rect();
        this.f50728g = new a(this, 2921397);
        this.f50723b = view;
        this.f50722a = viewGroup;
        this.f50724c = (LinearLayout) view.findViewById(R.id.container);
        this.mEmotionView = (ImageView) view.findViewById(R.id.emotion_view);
        this.mNodataTextView = (TextView) view.findViewById(R.id.no_data_tips);
        SkinManager.setImageResource(this.mEmotionView, R.drawable.new_pic_emotion_06);
        this.f50728g.setTag(SCROLL_LISTENER_TAG);
        MessageManager.getInstance().registerListener(this.f50728g);
        d();
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f50723b == null || this.f50722a == null) {
            return;
        }
        if (this.f50725d <= 0) {
            this.f50725d = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i2 == Integer.MAX_VALUE && this.f50727f == Integer.MAX_VALUE) {
            return;
        }
        this.f50727f = i2;
        if (this.f50722a.getLocalVisibleRect(this.f50726e)) {
            int i3 = this.f50726e.bottom;
            int abs = Math.abs(this.f50724c.getTop());
            int abs2 = i3 - Math.abs(this.f50724c.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f50724c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f50725d;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f50724c.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f50724c.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f50724c.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public final void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f50723b) == null) {
            return;
        }
        view.addOnLayoutChangeListener(new b(this));
    }

    public final boolean e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return view.getGlobalVisibleRect(this.f50726e);
        }
        return invokeL.booleanValue;
    }
}
