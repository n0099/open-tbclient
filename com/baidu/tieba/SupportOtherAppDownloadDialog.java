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
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import c.a.u0.z3.c0;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes12.dex */
public class SupportOtherAppDownloadDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public View D;
    public LinearLayout E;
    public f F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public boolean I;
    public boolean J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public Context f41895e;

    /* renamed from: f  reason: collision with root package name */
    public VersionData f41896f;

    /* renamed from: g  reason: collision with root package name */
    public CombineDownload f41897g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41898h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41899i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41900j;
    public boolean k;
    public LinearLayout l;
    public TextView m;
    public TextView n;
    public TextView o;
    public String p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public View y;
    public LinearLayout z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f41901e;

        public a(SupportOtherAppDownloadDialog supportOtherAppDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportOtherAppDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41901e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.f41901e.f41900j = true;
                if (this.f41901e.f41899i) {
                    Drawable drawable = SkinManager.getDrawable(c.a.u0.a4.f.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f41901e.q.setCompoundDrawables(drawable, null, null, null);
                }
                this.f41901e.F.a(this.f41901e.f41899i);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f41902e;

        public b(SupportOtherAppDownloadDialog supportOtherAppDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportOtherAppDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41902e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f41902e.J) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.f41902e.w.setEnabled(false);
                this.f41902e.F.b(this.f41902e.f41899i);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f41903e;

        public c(SupportOtherAppDownloadDialog supportOtherAppDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportOtherAppDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41903e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41903e.F.c();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f41904e;

        public d(SupportOtherAppDownloadDialog supportOtherAppDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportOtherAppDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41904e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41904e.f41900j) {
                return;
            }
            if (this.f41904e.f41899i) {
                Drawable drawable = SkinManager.getDrawable(c.a.u0.a4.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f41904e.q.setCompoundDrawables(drawable, null, null, null);
                this.f41904e.f41898h = false;
                this.f41904e.f41899i = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(c.a.u0.a4.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f41904e.q.setCompoundDrawables(drawable2, null, null, null);
            this.f41904e.f41898h = true;
            this.f41904e.f41899i = true;
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f41905e;

        public e(SupportOtherAppDownloadDialog supportOtherAppDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportOtherAppDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41905e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f41905e.s.getId()) {
                    this.f41905e.F.c();
                    SupportOtherAppDownloadDialog supportOtherAppDownloadDialog = this.f41905e;
                    supportOtherAppDownloadDialog.goToYingyongbao(supportOtherAppDownloadDialog.f41895e);
                } else if (view.getId() == this.f41905e.v.getId()) {
                    this.f41905e.F.c();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void stopService();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportOtherAppDownloadDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41899i = true;
        this.f41900j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f41895e = context;
    }

    public void changeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i2) == null) {
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(findViewById(g.app_download_dialog_layout));
            }
            SkinManager.setImageResource(this.v, c.a.u0.a4.f.write_close_selector);
        }
    }

    public void goToYingyongbao(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + context.getPackageName()));
            try {
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void m() {
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            if (this.f41900j) {
                this.F.stopService();
                this.l.setVisibility(8);
                if (this.k) {
                    this.A.setText(getContext().getString(j.download_exit));
                }
                this.z.setVisibility(0);
                return;
            }
            this.F.d();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(h.app_download_dialog);
            this.l = (LinearLayout) findViewById(g.app_info);
            this.m = (TextView) findViewById(g.app_version_and_size);
            this.n = (TextView) findViewById(g.app_description);
            this.t = (TextView) findViewById(g.fullsize_download_button);
            this.r = (TextView) findViewById(g.cancel_download_button);
            this.s = (TextView) findViewById(g.btn_update_save_flow);
            this.v = (ImageView) findViewById(g.img_close);
            this.s.setOnClickListener(this.K);
            this.v.setOnClickListener(this.K);
            this.u = findViewById(g.divider_line);
            this.o = (TextView) findViewById(g.download_process);
            this.w = (TextView) findViewById(g.incremental_download_button);
            this.x = (TextView) findViewById(g.not_install_as_tip);
            this.y = findViewById(g.incremental_download_layout);
            this.q = (TextView) findViewById(g.other_app_recommend);
            this.D = findViewById(g.divider_under_button);
            this.E = (LinearLayout) findViewById(g.cancel_confirm_ll);
            this.p = this.o.getText().toString();
            this.z = (LinearLayout) findViewById(g.cancel_dialog);
            this.B = (TextView) findViewById(g.sure_cancel);
            this.C = (TextView) findViewById(g.cancel_button);
            this.A = (TextView) findViewById(g.cancel_tip);
            this.B.setOnClickListener(this.G);
            this.C.setOnClickListener(this.H);
            if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
                this.I = true;
            } else {
                this.I = false;
            }
            String size = this.f41896f.getSize();
            String newVersion = this.f41896f.getNewVersion();
            String newVersionDesc = this.f41896f.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f41895e.getString(j.new_version_format));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(c.a.d.f.m.b.d(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.m.setText(sb.toString());
            this.n.setText(newVersionDesc);
            if (this.f41896f.forceUpdate()) {
                this.k = true;
                this.r.setText(this.f41895e.getString(j.quit));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            } else {
                this.r.setText(this.f41895e.getString(j.update_after));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            }
            CombineDownload combineDownload = this.f41897g;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f41897g.getApkMD5RSA())) {
                this.q.setText(this.f41897g.getAppName());
                if (!c0.b(this.f41895e, this.f41897g.getAppProc()) && !TextUtils.isEmpty(this.f41897g.getAppUrl())) {
                    this.q.setVisibility(0);
                    Drawable drawable = this.f41895e.getResources().getDrawable(c.a.u0.a4.f.btn_dailog_choose_s);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.q.setCompoundDrawables(drawable, null, null, null);
                } else {
                    this.q.setVisibility(8);
                }
            } else {
                this.q.setVisibility(8);
            }
            setFunctionLayout(this.I);
            this.t.setOnClickListener(new a(this));
            this.w.setOnClickListener(new b(this));
            this.r.setOnClickListener(new c(this));
            this.q.setOnClickListener(new d(this));
            m();
        }
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.G = onClickListener;
        }
    }

    public void setCancelDialogVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.setVisibility(8);
            this.z.setVisibility(0);
        }
    }

    public void setData(VersionData versionData, CombineDownload combineDownload, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, versionData, combineDownload, fVar) == null) {
            this.f41896f = versionData;
            this.f41897g = combineDownload;
            this.F = fVar;
        }
    }

    public void setDownDialogVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.z.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void setFunctionLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                VersionData versionData = this.f41896f;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f41896f.getNewVersionCode() >= 0) {
                    this.y.setVisibility(0);
                    this.w.setText(j.incremental_update);
                    SkinManager.setBackgroundResource(this.w, c.a.u0.a4.f.dialog_single_button_bg_selector);
                    this.D.setVisibility(8);
                    this.E.setVisibility(8);
                    this.J = true;
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                    return;
                }
                this.y.setVisibility(0);
                this.w.setText(j.super_update);
                SkinManager.setBackgroundResource(this.w, c.a.u0.a4.f.dialog_middle_item_bg_selector);
                this.E.setVisibility(0);
                this.J = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            VersionData versionData2 = this.f41896f;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f41896f.getNewVersionCode() >= 0) {
                this.y.setVisibility(0);
                SkinManager.setBackgroundResource(this.w, c.a.u0.a4.f.dialog_middle_item_bg_selector);
                this.w.setText(j.incremental_update);
                this.E.setVisibility(0);
                this.J = true;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            this.y.setVisibility(8);
            this.E.setVisibility(0);
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
        }
    }

    public void setUpdateButtonEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.t.setEnabled(z);
        }
    }

    public void setUpdateClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.H = onClickListener;
        }
    }

    public void updateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.t.setVisibility(8);
            this.y.setVisibility(8);
            this.r.setVisibility(8);
            this.u.setVisibility(8);
            this.f41900j = true;
            this.E.setVisibility(0);
            this.o.setVisibility(0);
            TextView textView = this.o;
            textView.setText(this.p + i2 + "%");
            this.v.setVisibility(8);
            this.s.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportOtherAppDownloadDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41899i = true;
        this.f41900j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f41895e = context;
    }
}
