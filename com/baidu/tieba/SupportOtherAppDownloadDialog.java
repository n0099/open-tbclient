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
import c.a.e.e.p.l;
import c.a.r0.k3.a0;
import c.a.r0.o;
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
/* loaded from: classes6.dex */
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
    public Context f49114e;

    /* renamed from: f  reason: collision with root package name */
    public VersionData f49115f;

    /* renamed from: g  reason: collision with root package name */
    public CombineDownload f49116g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49117h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49118i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49119j;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f49120e;

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
            this.f49120e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.f49120e.f49119j = true;
                if (this.f49120e.f49118i) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f49120e.q.setCompoundDrawables(drawable, null, null, null);
                }
                this.f49120e.F.a(this.f49120e.f49118i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f49121e;

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
            this.f49121e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49121e.J) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.f49121e.w.setEnabled(false);
                this.f49121e.F.b(this.f49121e.f49118i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f49122e;

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
            this.f49122e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49122e.F.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f49123e;

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
            this.f49123e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49123e.f49119j) {
                return;
            }
            if (this.f49123e.f49118i) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f49123e.q.setCompoundDrawables(drawable, null, null, null);
                this.f49123e.f49117h = false;
                this.f49123e.f49118i = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f49123e.q.setCompoundDrawables(drawable2, null, null, null);
            this.f49123e.f49117h = true;
            this.f49123e.f49118i = true;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f49124e;

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
            this.f49124e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f49124e.s.getId()) {
                    this.f49124e.F.d();
                    SupportOtherAppDownloadDialog supportOtherAppDownloadDialog = this.f49124e;
                    supportOtherAppDownloadDialog.goToYingyongbao(supportOtherAppDownloadDialog.f49114e);
                } else if (view.getId() == this.f49124e.v.getId()) {
                    this.f49124e.F.d();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d();

        void e();
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
        this.f49118i = true;
        this.f49119j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f49114e = context;
    }

    public void changeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i2) == null) {
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(findViewById(R.id.app_download_dialog_layout));
            }
            SkinManager.setImageResource(this.v, R.drawable.write_close_selector);
        }
    }

    public void goToYingyongbao(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
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
            if (this.f49119j) {
                this.F.c();
                this.l.setVisibility(8);
                if (this.k) {
                    this.A.setText(getContext().getString(R.string.download_exit));
                }
                this.z.setVisibility(0);
                return;
            }
            this.F.e();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.app_download_dialog);
            this.l = (LinearLayout) findViewById(R.id.app_info);
            this.m = (TextView) findViewById(R.id.app_version_and_size);
            this.n = (TextView) findViewById(R.id.app_description);
            this.t = (TextView) findViewById(R.id.fullsize_download_button);
            this.r = (TextView) findViewById(R.id.cancel_download_button);
            this.s = (TextView) findViewById(R.id.btn_update_save_flow);
            this.v = (ImageView) findViewById(R.id.img_close);
            this.s.setOnClickListener(this.K);
            this.v.setOnClickListener(this.K);
            this.u = findViewById(R.id.divider_line);
            this.o = (TextView) findViewById(R.id.download_process);
            this.w = (TextView) findViewById(R.id.incremental_download_button);
            this.x = (TextView) findViewById(R.id.not_install_as_tip);
            this.y = findViewById(R.id.incremental_download_layout);
            this.q = (TextView) findViewById(R.id.other_app_recommend);
            this.D = findViewById(R.id.divider_under_button);
            this.E = (LinearLayout) findViewById(R.id.cancel_confirm_ll);
            this.p = this.o.getText().toString();
            this.z = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.B = (TextView) findViewById(R.id.sure_cancel);
            this.C = (TextView) findViewById(R.id.cancel_button);
            this.A = (TextView) findViewById(R.id.cancel_tip);
            this.B.setOnClickListener(this.G);
            this.C.setOnClickListener(this.H);
            if (SwitchManager.getInstance().findType(UpdateDialogStyleSyncSwitch.KEY) == 1) {
                this.I = true;
            } else {
                this.I = false;
            }
            String size = this.f49115f.getSize();
            String newVersion = this.f49115f.getNewVersion();
            String newVersionDesc = this.f49115f.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f49114e.getString(R.string.new_version_format));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(c.a.e.e.m.b.d(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.m.setText(sb.toString());
            this.n.setText(newVersionDesc);
            if (this.f49115f.forceUpdate()) {
                this.k = true;
                this.r.setText(this.f49114e.getString(R.string.quit));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            } else if (this.f49115f.isOfficialVersion() && l.w(this.f49114e, "com.tencent.android.qqdownloader")) {
                this.r.setVisibility(8);
            } else {
                this.r.setText(this.f49114e.getString(R.string.update_after));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            }
            CombineDownload combineDownload = this.f49116g;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f49116g.getApkMD5RSA())) {
                this.q.setText(this.f49116g.getAppName());
                if (!a0.b(this.f49114e, this.f49116g.getAppProc()) && !TextUtils.isEmpty(this.f49116g.getAppUrl())) {
                    this.q.setVisibility(0);
                    Drawable drawable = this.f49114e.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
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
            this.f49115f = versionData;
            this.f49116g = combineDownload;
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
            if (o.c(this.f49114e.getPackageManager())) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            if (z) {
                VersionData versionData = this.f49115f;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f49115f.getNewVersionCode() >= 0) {
                    this.y.setVisibility(0);
                    this.w.setText(R.string.incremental_update);
                    SkinManager.setBackgroundResource(this.w, R.drawable.dialog_single_button_bg_selector);
                    this.D.setVisibility(8);
                    this.E.setVisibility(8);
                    this.J = true;
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_SHOW);
                    return;
                }
                this.y.setVisibility(0);
                this.w.setText(R.string.super_update);
                SkinManager.setBackgroundResource(this.w, R.drawable.dialog_middle_item_bg_selector);
                this.E.setVisibility(0);
                this.J = false;
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_SHOW);
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_SHOW);
                return;
            }
            VersionData versionData2 = this.f49115f;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f49115f.getNewVersionCode() >= 0) {
                this.y.setVisibility(0);
                SkinManager.setBackgroundResource(this.w, R.drawable.dialog_middle_item_bg_selector);
                this.w.setText(R.string.incremental_update);
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
            this.f49119j = true;
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
        this.f49118i = true;
        this.f49119j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f49114e = context;
    }
}
