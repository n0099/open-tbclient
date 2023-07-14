package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.du6;
import com.baidu.tieba.pf;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public of a;
    public final Activity b;
    public final ViewGroup c;
    public nf d;
    public final Handler e;
    public Runnable f;
    public String g;
    public String h;
    public View.OnClickListener i;
    public String j;
    public boolean k;
    public du6.e l;

    /* loaded from: classes6.dex */
    public class c implements nf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        @Override // com.baidu.tieba.nf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb5 a;
            public final /* synthetic */ FollowUserButton b;
            public final /* synthetic */ c c;

            public a(c cVar, gb5 gb5Var, FollowUserButton followUserButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, gb5Var, followUserButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = gb5Var;
                this.b = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.c.a.i != null) {
                        this.c.a.i.onClick(view2);
                    }
                    this.a.r(R.color.CAM_X0109);
                    this.a.j(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f075e));
                    this.b.setClickable(false);
                    if (this.c.a.f != null) {
                        this.c.a.e.removeCallbacks(this.c.a.f);
                        this.c.a.e.postDelayed(this.c.a.f, 1000L);
                    }
                }
            }
        }

        public c(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.baidu.tieba.nf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0360, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
                FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), (int) R.color.CAM_X0302);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f0320));
                barImageView.setStrokeWith(yi.g(this.a.b, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.a.j)) {
                    barImageView.N(this.a.j, 10, false);
                }
                gb5 gb5Var = new gb5();
                gb5Var.r(R.color.CAM_X0302);
                gb5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                gb5Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(gb5Var);
                followUserButton.setText(this.a.b.getString(R.string.obfuscated_res_0x7f0f02e8));
                followUserButton.setOnClickListener(new a(this, gb5Var, followUserButton));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(yi.g(this.a.b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(yi.g(this.a.b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(yi.g(this.a.b, R.dimen.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        @Override // com.baidu.tieba.nf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (MessageManager.getInstance().findTask(2002015) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_forumId", this.a.a.h);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                    }
                    if (this.a.a.f != null) {
                        this.a.a.e.removeCallbacks(this.a.a.f);
                        this.a.a.e.postDelayed(this.a.a.f, 1000L);
                    }
                }
            }
        }

        public f(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.baidu.tieba.nf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d035f, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090ca8);
                SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0302);
                eMTextView.setText(this.a.g);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f090ca7);
                hb5 hb5Var = new hb5();
                hb5Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(hb5Var);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f082c));
                tBSpecificationBtn.setOnClickListener(new a(this));
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public a(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.e(this.a.c);
                if (this.a.l != null) {
                    this.a.l.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public b(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.baidu.tieba.pf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a = null;
            this.a.e.removeCallbacks(this.a.f);
            this.a.k = false;
        }

        @Override // com.baidu.tieba.pf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.k = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public d(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.e(this.a.c);
                if (this.a.l != null) {
                    this.a.l.onDismiss();
                }
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements pf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        @Override // com.baidu.tieba.pf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.baidu.tieba.pf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a = null;
            this.a.e.removeCallbacks(this.a.f);
        }
    }

    public gp7(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Handler();
        this.b = activity;
        this.c = (ViewGroup) activity.findViewById(i);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.j = str;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g = str;
        }
    }

    public void t(du6.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.h = str;
        }
    }

    public final nf m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new c(this);
        }
        return (nf) invokeV.objValue;
    }

    public final nf n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new f(this);
        }
        return (nf) invokeV.objValue;
    }

    public void o() {
        of ofVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ofVar = this.a) != null) {
            ofVar.e(this.c);
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            du6.e eVar = this.l;
            if (eVar != null) {
                eVar.onDismiss();
            }
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        of ofVar = this.a;
        if (ofVar != null) {
            ofVar.e(this.c);
        }
        this.f = new d(this);
        pf pfVar = new pf();
        pfVar.d(true);
        pfVar.h(new e(this));
        if (this.d == null) {
            this.d = n();
        }
        pfVar.a(this.d);
        pfVar.e(R.anim.obfuscated_res_0x7f010093);
        pfVar.f(R.anim.obfuscated_res_0x7f010094);
        of b2 = pfVar.b();
        this.a = b2;
        b2.p(this.b, this.c, false);
        d85 d2 = d85.d(this.c);
        d2.o(R.string.J_X05);
        d2.w(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.e.postDelayed(this.f, 5000L);
    }

    public void w() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        of ofVar = this.a;
        if (ofVar != null) {
            ofVar.e(this.c);
        }
        this.e.removeCallbacks(this.f);
        this.f = new a(this);
        pf pfVar = new pf();
        pfVar.d(true);
        pfVar.h(new b(this));
        if (this.d == null) {
            this.d = m();
        }
        pfVar.a(this.d);
        pfVar.e(R.anim.obfuscated_res_0x7f010093);
        pfVar.f(R.anim.obfuscated_res_0x7f010094);
        of b2 = pfVar.b();
        this.a = b2;
        b2.p(this.b, this.c, false);
        this.e.postDelayed(this.f, 4000L);
    }
}
