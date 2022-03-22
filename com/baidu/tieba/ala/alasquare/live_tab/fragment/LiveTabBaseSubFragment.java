package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.f0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f31270b;

    /* renamed from: c  reason: collision with root package name */
    public h f31271c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31272d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31273e;

    /* renamed from: f  reason: collision with root package name */
    public int f31274f;

    /* renamed from: g  reason: collision with root package name */
    public String f31275g;

    /* renamed from: h  reason: collision with root package name */
    public String f31276h;
    public CustomMessageListener i;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabBaseSubFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LiveTabBaseSubFragment liveTabBaseSubFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabBaseSubFragment, Integer.valueOf(i)};
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
            this.a = liveTabBaseSubFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.a.f31273e = false;
            }
        }
    }

    public LiveTabBaseSubFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31272d = false;
        this.f31273e = false;
        this.i = new a(this, 2921442);
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31270b.setVisibility(8);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
            this.f31273e = true;
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (m.isEmpty(this.f31275g) || m.isEmpty(this.f31276h)) ? false : true : invokeV.booleanValue;
    }

    public abstract void F0();

    public void G0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f31275g = str;
            this.f31276h = str2;
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31270b.setVisibility(0);
            if (this.f31271c == null) {
                this.f31271c = new h(this.a, null);
            }
            this.f31271c.e();
            this.f31271c.i(R.drawable.new_pic_emotion_03);
            this.f31271c.o(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2c));
            this.f31271c.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f31271c.b() == null || this.f31271c.b().getParent() != null) {
                return;
            }
            this.f31270b.addView(this.f31271c.b(), layoutParams);
        }
    }

    public abstract void loadData();

    public abstract void n();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            h hVar = this.f31271c;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }
}
