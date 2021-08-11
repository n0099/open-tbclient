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
import c.a.p0.i3.z;
import c.a.p0.n;
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
    public Context f48835e;

    /* renamed from: f  reason: collision with root package name */
    public VersionData f48836f;

    /* renamed from: g  reason: collision with root package name */
    public CombineDownload f48837g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48838h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48839i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48840j;
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
        public final /* synthetic */ SupportOtherAppDownloadDialog f48841e;

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
            this.f48841e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_IMMEDIATELY_CLICK);
                this.f48841e.f48840j = true;
                if (this.f48841e.f48839i) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f48841e.q.setCompoundDrawables(drawable, null, null, null);
                }
                this.f48841e.F.a(this.f48841e.f48839i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f48842e;

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
            this.f48842e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48842e.J) {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_INCREMENTAL_CLICK);
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUPER_SPEED_CLICK);
                }
                this.f48842e.w.setEnabled(false);
                this.f48842e.F.b(this.f48842e.f48839i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f48843e;

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
            this.f48843e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48843e.F.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f48844e;

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
            this.f48844e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48844e.f48840j) {
                return;
            }
            if (this.f48844e.f48839i) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f48844e.q.setCompoundDrawables(drawable, null, null, null);
                this.f48844e.f48838h = false;
                this.f48844e.f48839i = false;
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f48844e.q.setCompoundDrawables(drawable2, null, null, null);
            this.f48844e.f48838h = true;
            this.f48844e.f48839i = true;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupportOtherAppDownloadDialog f48845e;

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
            this.f48845e = supportOtherAppDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f48845e.s.getId()) {
                    this.f48845e.F.d();
                    SupportOtherAppDownloadDialog supportOtherAppDownloadDialog = this.f48845e;
                    supportOtherAppDownloadDialog.goToYingyongbao(supportOtherAppDownloadDialog.f48835e);
                } else if (view.getId() == this.f48845e.v.getId()) {
                    this.f48845e.F.d();
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
        this.f48839i = true;
        this.f48840j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f48835e = context;
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
            if (this.f48840j) {
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
            String size = this.f48836f.getSize();
            String newVersion = this.f48836f.getNewVersion();
            String newVersionDesc = this.f48836f.getNewVersionDesc();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f48835e.getString(R.string.new_version_format));
            if (!TextUtils.isEmpty(newVersion)) {
                sb.append(newVersion);
            }
            if (!TextUtils.isEmpty(size)) {
                sb.append(" / " + String.format("%.2f", Float.valueOf(c.a.e.e.m.b.c(size, 0.0f) / 1048576.0f)) + "MB");
            }
            this.m.setText(sb.toString());
            this.n.setText(newVersionDesc);
            if (this.f48836f.forceUpdate()) {
                this.k = true;
                this.r.setText(this.f48835e.getString(R.string.quit));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            } else if (this.f48836f.isOfficialVersion() && l.w(this.f48835e, "com.tencent.android.qqdownloader")) {
                this.r.setVisibility(8);
            } else {
                this.r.setText(this.f48835e.getString(R.string.update_after));
                this.s.setVisibility(8);
                this.v.setVisibility(8);
            }
            CombineDownload combineDownload = this.f48837g;
            if (combineDownload != null && combineDownload.showCombineDownload() && !TextUtils.isEmpty(this.f48837g.getApkMD5RSA())) {
                this.q.setText(this.f48837g.getAppName());
                if (!z.b(this.f48835e, this.f48837g.getAppProc()) && !TextUtils.isEmpty(this.f48837g.getAppUrl())) {
                    this.q.setVisibility(0);
                    Drawable drawable = this.f48835e.getResources().getDrawable(R.drawable.btn_dailog_choose_s);
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
            this.f48836f = versionData;
            this.f48837g = combineDownload;
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
            if (n.c(this.f48835e.getPackageManager())) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            if (z) {
                VersionData versionData = this.f48836f;
                if (versionData != null && !TextUtils.isEmpty(versionData.getPatch()) && this.f48836f.getNewVersionCode() >= 0) {
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
            VersionData versionData2 = this.f48836f;
            if (versionData2 != null && !TextUtils.isEmpty(versionData2.getPatch()) && this.f48836f.getNewVersionCode() >= 0) {
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
            this.f48840j = true;
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
        this.f48839i = true;
        this.f48840j = false;
        this.k = false;
        this.I = true;
        this.J = true;
        this.K = new e(this);
        this.f48835e = context;
    }
}
