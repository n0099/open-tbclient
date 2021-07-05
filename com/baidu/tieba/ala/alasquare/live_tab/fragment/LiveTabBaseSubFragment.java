package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
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
import d.a.c.e.p.k;
import d.a.r0.d0.h;
/* loaded from: classes5.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13932e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13933f;

    /* renamed from: g  reason: collision with root package name */
    public h f13934g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13935h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13936i;
    public int j;
    public String k;
    public String l;
    public CustomMessageListener m;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabBaseSubFragment f13937a;

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
            this.f13937a = liveTabBaseSubFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.f13937a.f13936i = false;
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
        this.f13935h = false;
        this.f13936i = false;
        this.m = new a(this, 2921442);
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13933f.setVisibility(8);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
            this.f13936i = true;
        }
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (k.isEmpty(this.k) || k.isEmpty(this.l)) ? false : true : invokeV.booleanValue;
    }

    public abstract void J0();

    public void K0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.k = str;
            this.l = str2;
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13933f.setVisibility(0);
            if (this.f13934g == null) {
                this.f13934g = new h(this.f13932e, null);
            }
            this.f13934g.e();
            this.f13934g.i(R.drawable.new_pic_emotion_03);
            this.f13934g.n(this.f13932e.getResources().getString(R.string.no_data_common_txt));
            this.f13934g.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f13934g.b() == null || this.f13934g.b().getParent() != null) {
                return;
            }
            this.f13933f.addView(this.f13934g.b(), layoutParams);
        }
    }

    public abstract void loadData();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f13934g;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public abstract void p();
}
