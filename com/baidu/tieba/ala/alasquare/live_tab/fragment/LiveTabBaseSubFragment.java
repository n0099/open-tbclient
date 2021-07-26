package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.k;
import d.a.p0.f0.h;
/* loaded from: classes4.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14019e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14020f;

    /* renamed from: g  reason: collision with root package name */
    public h f14021g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14022h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14023i;
    public int j;
    public String k;
    public String l;
    public CustomMessageListener m;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabBaseSubFragment f14024a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LiveTabBaseSubFragment liveTabBaseSubFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabBaseSubFragment, Integer.valueOf(i2)};
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
            this.f14024a = liveTabBaseSubFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.f14024a.f14023i = false;
            }
        }
    }

    public LiveTabBaseSubFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14022h = false;
        this.f14023i = false;
        this.m = new a(this, 2921442);
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14020f.setVisibility(8);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
            this.f14023i = true;
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (k.isEmpty(this.k) || k.isEmpty(this.l)) ? false : true : invokeV.booleanValue;
    }

    public abstract void P0();

    public void Q0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.k = str;
            this.l = str2;
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14020f.setVisibility(0);
            if (this.f14021g == null) {
                this.f14021g = new h(this.f14019e, null);
            }
            this.f14021g.e();
            this.f14021g.i(R.drawable.new_pic_emotion_03);
            this.f14021g.n(this.f14019e.getResources().getString(R.string.no_data_common_txt));
            this.f14021g.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f14021g.b() == null || this.f14021g.b().getParent() != null) {
                return;
            }
            this.f14020f.addView(this.f14021g.b(), layoutParams);
        }
    }

    public abstract void loadData();

    public abstract void o();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f14021g;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }
}
