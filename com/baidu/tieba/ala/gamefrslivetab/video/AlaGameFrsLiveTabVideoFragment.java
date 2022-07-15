package com.baidu.tieba.ala.gamefrslivetab.video;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.je6;
import com.repackage.kt5;
import com.repackage.ng;
import com.repackage.xt4;
import java.net.URL;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveTabVideoFragment extends BaseFragment implements je6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;
    public kt5 d;
    public CustomMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabVideoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsGameLive".equals(split[0]) && 8 == ng.e(split[1], 0)) {
                if (this.a.d != null) {
                    this.a.d.i();
                }
            } else if ("FrsGameLiveLive".equals(split[0]) && 3 == ng.e(split[1], 0) && this.a.d != null) {
                this.a.d.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabVideoFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.u1().contains(str) || str.contains(this.a.u1())) {
                    this.a.d.l();
                }
            }
        }
    }

    public AlaGameFrsLiveTabVideoFragment() {
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
        this.a = false;
        this.c = true;
        this.e = new a(this, 0);
        this.f = new b(this, 2921023);
    }

    @Override // com.repackage.je6
    public NavigationBar N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d.j() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.d.o(this);
            registerListener(this.f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.c) {
                return;
            }
            if (i == 1) {
                this.d.y(t1(u1()));
            } else {
                this.d.y(u1());
            }
            this.d.A(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.e, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            kt5 kt5Var = new kt5(this.a);
            this.d = kt5Var;
            return kt5Var.B(layoutInflater, viewGroup);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            kt5 kt5Var = this.d;
            if (kt5Var != null) {
                kt5Var.C();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (this.c || StringUtils.isNull(this.d.k().getUrl())) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.d.y(t1(u1()));
                } else {
                    this.d.y(u1());
                }
                this.c = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }

    public final String t1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            try {
                if (StringUtils.isNull(new URL(str).getQuery())) {
                    return str + "?isNightModel=1";
                }
                return str + "&isNightModel=1";
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public String u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String q = xt4.k().q("ala_game_frs_live_tab_video_url", "https://tieba.baidu.com/n/interact/video/game?");
            if (q != null) {
                StringBuilder sb = new StringBuilder(q);
                if (q.endsWith("?")) {
                    sb.append("fid=");
                    sb.append(this.b);
                } else {
                    sb.append("?fid=");
                    sb.append(this.b);
                }
                return sb.toString();
            }
            return "http://tieba.baidu.com/n/interact/video/game";
        }
        return (String) invokeV.objValue;
    }

    public void v1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
        }
    }

    public void w1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.a = z;
        }
    }
}
