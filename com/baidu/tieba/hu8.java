package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.b66;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.zv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class hu8 extends zv4 {
    public static /* synthetic */ Interceptable $ic;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public final zr8 c;
    public final MainTabActivity d;
    public final String e;
    public String f;
    @NonNull
    public z56 g;

    /* loaded from: classes4.dex */
    public class a implements b66.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu8 a;

        public a(hu8 hu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hu8Var;
        }

        @Override // com.baidu.tieba.b66.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hu8 b;

        public b(hu8 hu8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hu8Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    if (!StringUtils.isNull(this.a)) {
                        if ("source_from_virtual_image".equals(this.b.e)) {
                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                            if (skinType == 4) {
                                str = "&skin=dart";
                            } else if (skinType == 1) {
                                str = "&skin=night";
                            } else {
                                str = "";
                            }
                            UrlManager.getInstance().dealOneLink(this.b.d.getPageContext(), new String[]{this.a + str + "&from=2"});
                        } else if ("source_from_theme".equals(this.b.e)) {
                            UrlManager.getInstance().dealOneLink(this.b.d.getPageContext(), new String[]{this.a});
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_DRESS_UP_BUNDLE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.b.f));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu8(@NonNull MainTabActivity mainTabActivity, @NonNull zr8 zr8Var, @NonNull String str) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, zr8Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = zr8Var;
        this.d = mainTabActivity;
        this.e = str;
    }

    public static HashMap<String, String> i(String str) {
        InterceptResult invokeL;
        char c;
        String string;
        r25 r25Var;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            int hashCode = str.hashCode();
            if (hashCode != -867211368) {
                if (hashCode != 525854610) {
                    if (hashCode == 1522674166 && str.equals("source_from_virtual_image")) {
                        c = 1;
                    }
                    c = 65535;
                } else {
                    if (str.equals("source_from_help")) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("source_from_theme")) {
                    c = 2;
                }
                c = 65535;
            }
            String str5 = "";
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        string = "";
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1170);
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1173);
                }
            } else {
                string = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1159);
            }
            q25 mainTabPopConfig = TbSingleton.getInstance().getMainTabPopConfig();
            if (mainTabPopConfig != null) {
                r25Var = mainTabPopConfig.b(str);
            } else {
                r25Var = null;
            }
            if (r25Var == null) {
                return null;
            }
            if (!StringUtils.isNull(r25Var.d())) {
                string = r25Var.d();
            }
            if (StringUtils.isNull(r25Var.b())) {
                str2 = "";
            } else {
                str2 = r25Var.b();
            }
            if (!StringUtils.isNull(r25Var.a())) {
                str5 = r25Var.a();
            }
            if (!StringUtils.isNull(r25Var.e())) {
                str3 = r25Var.e();
            } else {
                str3 = "3000";
            }
            if (!StringUtils.isNull(r25Var.c())) {
                str4 = r25Var.c();
            } else {
                str4 = "1";
            }
            hashMap.put("pop_params_key_text", string);
            hashMap.put("pop_params_key_link", str2);
            hashMap.put("pop_params_key_img", str5);
            hashMap.put("pop_params_key_time", str3);
            hashMap.put("pop_params_key_max", str4);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zv4
    public void b() {
        z56 z56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z56Var = this.g) != null) {
            z56Var.h();
        }
    }

    @Override // com.baidu.tieba.zv4
    public void d(zv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            zr8 zr8Var = this.c;
            if (zr8Var != null && zr8Var.B() != null) {
                FragmentTabWidget fragmentTabWidget = this.c.B().getFragmentTabWidget();
                if ("source_from_help".equals(this.e)) {
                    j(aVar, i(this.e), fragmentTabWidget);
                    return;
                } else if ("source_from_virtual_image".equals(this.e) || "source_from_theme".equals(this.e)) {
                    k(aVar, i(this.e), fragmentTabWidget);
                    return;
                } else {
                    return;
                }
            }
            aVar.a(false);
        }
    }

    @Override // com.baidu.tieba.zv4
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z56 z56Var = this.g;
            if (z56Var == null) {
                c();
                return;
            }
            z56Var.z(new a(this));
            this.g.V(this.f, h, true, false);
            if ("source_from_theme".equals(this.e)) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_DRESS_UP_BUNDLE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.f));
            }
        }
    }

    public void j(zv4.a aVar, HashMap<String, String> hashMap, FragmentTabWidget fragmentTabWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, aVar, hashMap, fragmentTabWidget) == null) {
            h = "SendHelpTipTask";
            if (hashMap == null) {
                aVar.a(false);
                return;
            }
            if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() > 2) {
                z56 z56Var = new z56(this.d.getPageContext(), fragmentTabWidget.getChildAt(2), this.e, hashMap);
                this.g = z56Var;
                z56Var.s(false);
                this.g.t(true);
                this.g.L(R.drawable.obfuscated_res_0x7f0802f0);
                this.g.l(2);
                this.g.o(32);
                this.g.M(true);
                this.g.Q(-yi.g(this.b, R.dimen.tbds10));
                this.g.P(-yi.g(this.b, R.dimen.tbds60));
                this.g.C(R.color.CAM_X0101);
                this.g.J(R.dimen.T_X09);
                this.g.w(Integer.valueOf(hashMap.get("pop_params_key_max")).intValue());
                this.g.n(Integer.valueOf(hashMap.get("pop_params_key_time")).intValue());
                this.g.q(R.dimen.tbds90);
                this.f = hashMap.get("pop_params_key_text");
                int g = yi.g(this.b, R.dimen.obfuscated_res_0x7f070279);
                this.g.E(g, 0, g, yi.g(this.b, R.dimen.obfuscated_res_0x7f0702f6));
                this.g.A(h);
            }
            z56 z56Var2 = this.g;
            if (z56Var2 == null) {
                aVar.a(false);
            } else if (!z56Var2.d()) {
                aVar.a(false);
            } else {
                this.g.c(this.f, h, true, false, aVar);
            }
        }
    }

    public void k(zv4.a aVar, HashMap<String, String> hashMap, FragmentTabWidget fragmentTabWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, aVar, hashMap, fragmentTabWidget) == null) {
            if ("source_from_virtual_image".equals(this.e)) {
                h = "setVirtualImage";
            } else {
                h = "setThemeSuit";
            }
            if (hashMap == null) {
                aVar.a(false);
            } else if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() >= 4) {
                if (!ProfileVirtualImageInfo.getInstance().isNetDataRespond() && "source_from_virtual_image".equals(this.e)) {
                    aVar.a(false);
                    return;
                }
                z56 z56Var = new z56(this.d.getPageContext(), fragmentTabWidget.getChildAt(4), this.e, hashMap);
                this.g = z56Var;
                z56Var.L(R.drawable.obfuscated_res_0x7f0802f1);
                this.g.l(2);
                this.g.o(48);
                this.g.s(false);
                boolean z = true;
                this.g.M(true);
                this.g.P(-yi.g(this.b, R.dimen.tbds62));
                this.g.C(R.color.CAM_X0101);
                this.g.J(R.dimen.T_X09);
                this.g.w(Integer.valueOf(hashMap.get("pop_params_key_max")).intValue());
                this.g.n(Integer.valueOf(hashMap.get("pop_params_key_time")).intValue());
                this.g.A(h);
                this.f = hashMap.get("pop_params_key_text");
                if (StringUtils.isNull(hashMap.get("pop_params_key_img"))) {
                    this.g.q(R.dimen.tbds90);
                    int g = yi.g(this.b, R.dimen.obfuscated_res_0x7f070279);
                    this.g.E(g, 0, g, yi.g(this.b, R.dimen.obfuscated_res_0x7f0702f6));
                }
                this.g.m(new b(this, hashMap.get("pop_params_key_link")));
                if ("source_from_virtual_image".equals(this.e)) {
                    if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1) {
                        z = false;
                    }
                    boolean d = this.g.d();
                    if (!z || !d) {
                        aVar.a(false);
                        return;
                    }
                }
                this.g.c(this.f, h, true, false, aVar);
            } else {
                aVar.a(false);
            }
        }
    }
}
