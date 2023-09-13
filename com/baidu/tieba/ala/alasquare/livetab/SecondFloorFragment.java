package com.baidu.tieba.ala.alasquare.livetab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.tieba.cp5;
import com.baidu.tieba.pp6;
import com.baidu.tieba.qp6;
import com.baidu.tieba.x85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes5.dex */
public class SecondFloorFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public PollingModel b;
    @Nullable
    public List<AlaLiveInfo> c;
    public final Runnable d;
    public boolean e;
    public String f;
    @Nullable
    public cp5.a g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorFragment a;

        public a(SecondFloorFragment secondFloorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.b2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorFragment a;

        public b(SecondFloorFragment secondFloorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.c2();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorFragment a;

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public /* synthetic */ void onFail() {
            x85.a(this);
        }

        public c(SecondFloorFragment secondFloorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorFragment;
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null || list.isEmpty()) {
                return;
            }
            this.a.c = list;
            this.a.j2(list);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public AlaRecommendLayout b;
        public ViewGroup c;
        public TextView d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static d a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                d dVar = new d();
                dVar.a = view2;
                dVar.b = (AlaRecommendLayout) view2.findViewById(R.id.recommend_layout);
                dVar.c = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091ec2);
                dVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ec4);
                return dVar;
            }
            return (d) invokeL.objValue;
        }
    }

    public SecondFloorFragment() {
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
        this.d = new a(this);
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.d);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.b == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.b = pollingModel;
                pollingModel.setLivePicSecondFloorCallback(new c(this));
            }
            this.b.getData("live_pic_second_floor,live_follow_second_floor");
        }
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.c == null) {
            return;
        }
        this.a.c.setVisibility(8);
        this.a.b.setVisibility(8);
        cp5.a aVar = this.g;
        if (aVar != null) {
            aVar.a(false, this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroyView();
            PollingModel pollingModel = this.b;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            a2();
        }
    }

    public void g2(@Nullable cp5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void h2(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            d2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.a = d.a(view2);
            f2();
            j2(this.c);
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c != null && this.e) {
            this.e = false;
            this.a.c.setVisibility(0);
            this.a.b.setVisibility(8);
            cp5.a aVar = this.g;
            if (aVar != null) {
                aVar.b(false);
            }
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = true;
            this.a.c.setVisibility(8);
            this.a.b.setVisibility(0);
            TiebaStatic.log(pp6.c("c13620", 7));
            cp5.a aVar = this.g;
            if (aVar != null) {
                aVar.b(true);
            }
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.b.setDarkMode(true);
            this.a.b.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a9));
            this.a.c.setOnClickListener(new b(this));
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.c == null) {
            return;
        }
        if (this.e) {
            this.a.b.setVisibility(0);
        } else {
            this.a.c.setVisibility(0);
        }
        cp5.a aVar = this.g;
        if (aVar != null) {
            aVar.a(true, this.e);
        }
    }

    public final void j2(@Nullable List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && list != null && !list.isEmpty()) {
            this.a.d.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f121a), Integer.valueOf(list.size())));
            this.a.b.setData(new qp6(getUniqueId(), list, this.f));
            TbSingleton tbSingleton = TbSingleton.getInstance();
            if (tbSingleton.isFirstEnterBigPicPage()) {
                tbSingleton.setFirstEnterBigPicPage(false);
                c2();
                SafeHandler.getInst().postDelayed(this.d, 3000L);
                return;
            }
            this.a.c.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a.b.d(i);
            EMManager.from(this.a.c).setAlpha(R.string.A_X05).setCorner(R.string.J_X01).setBackGroundRealColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0106));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00fb, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }
}
