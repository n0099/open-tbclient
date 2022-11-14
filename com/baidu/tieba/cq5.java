package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
/* loaded from: classes3.dex */
public class cq5 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public f B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public boolean E;
    public boolean F;
    public View.OnClickListener G;
    public Context a;
    public VersionData b;
    public CombineDownload c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public String l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public ImageView r;
    public TextView s;
    public TextView t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes3.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void stopService();
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq5 a;

        public a(cq5 cq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.a.f = true;
                if (this.a.e) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.a.m.setCompoundDrawables(drawable, null, null, null);
                }
                this.a.B.a(this.a.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq5 a;

        public b(cq5 cq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.a.s.setEnabled(false);
                this.a.B.b(this.a.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq5 a;

        public c(cq5 cq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq5 a;

        public d(cq5 cq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f) {
                return;
            }
            if (this.a.e) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.m.setCompoundDrawables(drawable, null, null, null);
                this.a.d = false;
                this.a.e = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.a.m.setCompoundDrawables(drawable2, null, null, null);
            this.a.d = true;
            this.a.e = true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq5 a;

        public e(cq5 cq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.o.getId()) {
                    this.a.B.c();
                    cq5 cq5Var = this.a;
                    cq5Var.n(cq5Var.a);
                } else if (view2.getId() == this.a.r.getId()) {
                    this.a.B.c();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq5(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = false;
        this.g = false;
        this.E = true;
        this.F = true;
        this.G = new e(this);
        this.a = context;
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p.setEnabled(z);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
            if (tbPageContext != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                tbPageContext.getLayoutMode().l(z);
                tbPageContext.getLayoutMode().k(findViewById(R.id.obfuscated_res_0x7f0902a9));
            }
            SkinManager.setImageResource(this.r, R.drawable.write_close_selector);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + context.getPackageName()));
            try {
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.p.setVisibility(8);
            this.u.setVisibility(8);
            this.n.setVisibility(8);
            this.q.setVisibility(8);
            this.f = true;
            this.A.setVisibility(0);
            this.k.setVisibility(0);
            TextView textView = this.k;
            textView.setText(this.l + i + "%");
            this.r.setVisibility(8);
            this.o.setVisibility(8);
        }
    }

    public final void o() {
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.v.setVisibility(8);
            this.h.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            if (this.f) {
                this.B.stopService();
                this.h.setVisibility(8);
                if (this.g) {
                    this.w.setText(getContext().getString(R.string.obfuscated_res_0x7f0f051a));
                }
                this.v.setVisibility(0);
                return;
            }
            this.B.d();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0122);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0902ac);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0902b8);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a7);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090c4f);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b4);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090477);
            this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f08);
            this.o.setOnClickListener(this.G);
            this.r.setOnClickListener(this.G);
            this.q = findViewById(R.id.divider_line);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f090858);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f090f50);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f091738);
            this.u = findViewById(R.id.obfuscated_res_0x7f090f51);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f0917aa);
            this.z = findViewById(R.id.obfuscated_res_0x7f090839);
            this.A = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904b2);
            this.l = this.k.getText().toString();
            this.v = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904b3);
            this.x = (TextView) findViewById(R.id.obfuscated_res_0x7f09200d);
            this.y = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b0);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b9);
            this.x.setOnClickListener(this.C);
            this.y.setOnClickListener(this.D);
            if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
                this.E = true;
            } else {
                this.E = false;
            }
            String size = this.b.getSize();
            String newVersion = this.b.getNewVersion();
            String newVersionDesc = this.b.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0c8b));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(xg.d(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.i.setText(sb.toString());
            this.j.setText(newVersionDesc);
            if (this.b.forceUpdate()) {
                this.g = true;
                this.n.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0fc7));
                this.o.setVisibility(8);
                this.r.setVisibility(8);
            } else {
                this.n.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1522));
                this.o.setVisibility(8);
                this.r.setVisibility(8);
            }
            CombineDownload combineDownload = this.c;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.c.getApkMD5RSA())) {
                this.m.setText(this.c.getAppName());
                if (!po8.b(this.a, this.c.getAppProc()) && !TextUtils.isEmpty(this.c.getAppUrl())) {
                    this.m.setVisibility(0);
                    Drawable drawable = this.a.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.m.setCompoundDrawables(drawable, null, null, null);
                } else {
                    this.m.setVisibility(8);
                }
            } else {
                this.m.setVisibility(8);
            }
            s(this.E);
            this.p.setOnClickListener(new a(this));
            this.s.setOnClickListener(new b(this));
            this.n.setOnClickListener(new c(this));
            this.m.setOnClickListener(new d(this));
            o();
        }
    }

    public void q(VersionData versionData, CombineDownload combineDownload, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, versionData, combineDownload, fVar) == null) {
            this.b = versionData;
            this.c = combineDownload;
            this.B = fVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                VersionData versionData = this.b;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.b.getNewVersionCode() >= 0) {
                    this.u.setVisibility(0);
                    this.s.setText(R.string.obfuscated_res_0x7f0f0915);
                    SkinManager.setBackgroundResource(this.s, R.drawable.dialog_single_button_bg_selector);
                    this.z.setVisibility(8);
                    this.A.setVisibility(8);
                    this.F = true;
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                    return;
                }
                this.u.setVisibility(0);
                this.s.setText(R.string.obfuscated_res_0x7f0f127c);
                SkinManager.setBackgroundResource(this.s, R.drawable.dialog_middle_item_bg_selector);
                this.A.setVisibility(0);
                this.F = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            VersionData versionData2 = this.b;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.b.getNewVersionCode() >= 0) {
                this.u.setVisibility(0);
                SkinManager.setBackgroundResource(this.s, R.drawable.dialog_middle_item_bg_selector);
                this.s.setText(R.string.obfuscated_res_0x7f0f0915);
                this.A.setVisibility(0);
                this.F = true;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.u.setVisibility(8);
            this.A.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }
}
