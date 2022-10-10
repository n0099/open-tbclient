package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.tieba.wf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class i35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vf a;
    public final Activity b;
    public final TbPageContext c;
    public ViewGroup d;
    public View.OnClickListener e;
    public uf f;
    public final Handler g;
    public Runnable h;
    public String i;
    public String j;
    public String k;
    public String l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public View p;
    public ImageView q;
    public TBSpecificationBtn r;
    public FrameLayout s;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public a(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.e(this.a.d);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements wf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public b(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // com.baidu.tieba.wf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.g.removeCallbacks(this.a.h);
            }
        }

        @Override // com.baidu.tieba.wf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements uf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public c(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // com.baidu.tieba.uf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) ? this.a.o(layoutInflater) : (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.uf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public d(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.onClick(view2);
                }
                String str = this.a.i;
                char c = 65535;
                if (str.hashCode() == -429621401 && str.equals("reply_pb")) {
                    c = 0;
                }
                if (c != 0) {
                    f35.d(this.a.b);
                } else {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.b).areNotificationsEnabled();
                    if (!k25.d().y()) {
                        new MsgRemindModel(this.a.c).E(1, true, null);
                    }
                    if (areNotificationsEnabled) {
                        j35.l(this.a.b);
                    } else {
                        f35.d(this.a.b);
                    }
                }
                this.a.r.setClickable(false);
                if (this.a.h != null) {
                    this.a.g.removeCallbacks(this.a.h);
                    this.a.g.postDelayed(this.a.h, 1000L);
                }
                this.a.d = null;
                i35.u(this.a.i, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public e(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
                this.a.d = null;
                i35.u(this.a.i, false);
            }
        }
    }

    public i35(TbPageContext<?> tbPageContext, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Handler();
        this.c = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.k = map.get("view_params_key_title");
        this.l = map.get("view_params_key_desc");
        this.i = map.get("view_params_key_source");
        this.j = map.get("view_params_key_style");
        this.d = r(this.b);
    }

    public static int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if ("reply_pb".equals(str)) {
                return 10;
            }
            if ("collect".equals(str)) {
                return 6;
            }
            if ("homepage".equals(str)) {
                return 7;
            }
            return "forum_follow".equals(str) ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static void u(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, null, str, z) == null) {
            TiebaStatic.log(new StatisticItem("c13673").param("obj_type", z ? 1 : 2).param("obj_source", s(str)));
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", s(str)));
        }
    }

    public final uf n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (uf) invokeV.objValue;
    }

    @NonNull
    public final View o(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d075d, (ViewGroup) null);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f090b41);
            if (TbSingleton.getInstance().isItemTabVisible && (this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) this.p.getLayoutParams()).bottomMargin = ej.f(this.b, R.dimen.tbds60);
            }
            this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b48);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b4a);
            this.o = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090b40);
            this.q = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090b42);
            this.r = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f090b43);
            this.s = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090b44);
            this.n.setText(this.k);
            this.m.setText(this.l);
            this.r.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f73));
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if ((layoutParams instanceof RelativeLayout.LayoutParams) && "short".equals(this.j)) {
                    layoutParams.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds156);
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds88);
                }
            }
            this.r.setOnClickListener(new d(this));
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setOnClickListener(new e(this));
            }
            w();
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = null;
        }
    }

    public void q() {
        vf vfVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (vfVar = this.a) == null || (viewGroup = this.d) == null) {
            return;
        }
        vfVar.e(viewGroup);
        this.d.setVisibility(8);
    }

    public final ViewGroup r(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
            char c2 = 65535;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds146) + UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            String str = this.i;
            switch (str.hashCode()) {
                case -2052508497:
                    if (str.equals("fan_message_bar")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3364:
                    if (str.equals("im")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 853245640:
                    if (str.equals("agree_message_bar")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1330578895:
                    if (str.equals("at_message_bar")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds128);
                if ("short".equals(this.j)) {
                    dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds200);
                    dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                }
            }
            layoutParams.bottomMargin = dimenPixelSize;
            layoutParams.leftMargin = dimenPixelSize2;
            layoutParams.rightMargin = dimenPixelSize3;
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout.addView(frameLayout2, layoutParams);
            return frameLayout2;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.a == null || (viewGroup = this.d) == null || viewGroup.getVisibility() != 0) ? false : true : invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            this.o.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080ace, (WebPManager.ResourceStateType) null));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(ej.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(ej.f(this.b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(ej.f(this.b, R.dimen.tbds5)).into(this.p);
            View view2 = this.p;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = -ej.f(this.b, R.dimen.tbds10);
                    layoutParams2.rightMargin = -ej.f(this.b, R.dimen.tbds10);
                }
            }
            my4 my4Var = new my4();
            my4Var.p(R.color.CAM_X0302);
            this.r.setConfig(my4Var);
            ImageView imageView = this.q;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            }
        }
    }

    public void x() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.d) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        vf vfVar = this.a;
        if (vfVar != null) {
            vfVar.e(this.d);
        }
        this.h = new a(this);
        wf wfVar = new wf();
        wfVar.d(true);
        wfVar.h(new b(this));
        if (this.f == null) {
            this.f = n();
        }
        wfVar.a(this.f);
        wfVar.e(R.anim.obfuscated_res_0x7f0100fe);
        wfVar.f(R.anim.obfuscated_res_0x7f0100ff);
        vf b2 = wfVar.b();
        this.a = b2;
        b2.q(this.b, this.d, false);
        v(this.i);
    }
}
