package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.s.a;
import c.a.p0.v.j.g.a;
import c.a.p0.v.j.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes7.dex */
public class AchievementMarkDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f49462e;

    /* renamed from: f  reason: collision with root package name */
    public View f49463f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f49464g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f49465h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49466i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f49467j;
    public TextView k;
    public TextView l;
    public MarkLevelGroup m;
    public TextView n;
    public c.a.p0.v.j.g.c.b.b o;
    public c.a.p0.v.j.g.c.b.d p;
    public AlaUpdateMarkStatusModel q;
    public i r;
    public LinearLayout s;
    public TextView t;
    public TextView u;
    public LinearLayout v;
    public TextView w;
    public c.a.p0.v.j.g.b x;
    public c.a.p0.v.j.g.a y;

    /* loaded from: classes7.dex */
    public class a implements AlaUpdateMarkStatusModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49468a;

        public a(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49468a = achievementMarkDialog;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.b
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.f49468a.n.setEnabled(true);
                if (z) {
                    if (this.f49468a.r != null) {
                        this.f49468a.r.a(true, this.f49468a.o);
                    }
                    this.f49468a.dismiss();
                    return;
                }
                if (StringUtils.isNull(str)) {
                    str = this.f49468a.getContext().getResources().getString(R.string.ala_achievement_ops_failed_tip);
                }
                this.f49468a.f49462e.showToast(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49469a;

        public b(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49469a = achievementMarkDialog;
        }

        @Override // c.a.p0.v.j.g.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f49469a.o.n <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                this.f49469a.w();
                this.f49469a.v();
                this.f49469a.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49470a;

        public c(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49470a = achievementMarkDialog;
        }

        @Override // c.a.p0.v.j.g.a.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f49470a.o != null) {
                        this.f49470a.f49462e.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (this.f49470a.r != null) {
                            this.f49470a.r.a(true, this.f49470a.o);
                        }
                        this.f49470a.o.q(2);
                        this.f49470a.w();
                        this.f49470a.v();
                        this.f49470a.t();
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.f49470a.f49462e.showToast(str);
                } else {
                    this.f49470a.f49462e.showToast(R.string.ala_achievement_tdou_buy_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49471e;

        public d(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49471e = achievementMarkDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49471e.r != null) {
                    this.f49471e.r.a(false, this.f49471e.o);
                }
                this.f49471e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements MarkLevelGroup.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49472a;

        public e(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49472a = achievementMarkDialog;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.b
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.f49472a.u(str, str2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49473e;

        public f(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49473e = achievementMarkDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49473e.o.j() == 0 || 3 == this.f49473e.o.j()) {
                    if (this.f49473e.o.m()) {
                        if (this.f49473e.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (this.f49473e.x != null) {
                                this.f49473e.x.c(this.f49473e.o.n);
                            }
                        } else if (this.f49473e.y != null) {
                            this.f49473e.y.c(this.f49473e.o.d(), this.f49473e.o.m, false);
                        }
                    } else if (this.f49473e.o.l()) {
                    } else {
                        this.f49473e.dismiss();
                    }
                } else if (!this.f49473e.o.k() || 2 != this.f49473e.o.j()) {
                    this.f49473e.r();
                } else {
                    this.f49473e.s();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49474e;

        public g(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49474e = achievementMarkDialog;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f49474e.n.setEnabled(false);
                this.f49474e.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AchievementMarkDialog f49475e;

        public h(AchievementMarkDialog achievementMarkDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {achievementMarkDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49475e = achievementMarkDialog;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a(boolean z, c.a.p0.v.j.g.c.b.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1451782310, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AchievementMarkDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1451782310, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AchievementMarkDialog;");
                return;
            }
        }
        z = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
        A = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AchievementMarkDialog(TbPageContext tbPageContext, i iVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49462e = tbPageContext;
        this.r = iVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
            this.p = null;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n();
            c.a.p0.v.j.g.c.b.d dVar = this.p;
            if (dVar == null) {
                dismiss();
                return;
            }
            u(dVar.b(), this.p.a());
            w();
            v();
            t();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = null;
            if (!ListUtils.isEmpty(this.o.c())) {
                for (c.a.p0.v.j.g.c.b.d dVar : this.o.c()) {
                    if (dVar != null && this.o.g() == dVar.c()) {
                        this.p = dVar;
                    }
                }
            }
            if (this.p == null) {
                c.a.p0.v.j.g.c.b.d dVar2 = new c.a.p0.v.j.g.c.b.d();
                this.p = dVar2;
                dVar2.g(this.o.f());
                this.p.f(this.o.e());
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(134217728);
            }
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            q();
            o();
            p();
        }
    }

    public void onDestroy() {
        AlaUpdateMarkStatusModel alaUpdateMarkStatusModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaUpdateMarkStatusModel = this.q) == null) {
            return;
        }
        alaUpdateMarkStatusModel.onDestroy();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaUpdateMarkStatusModel alaUpdateMarkStatusModel = new AlaUpdateMarkStatusModel(getContext());
            this.q = alaUpdateMarkStatusModel;
            alaUpdateMarkStatusModel.z(new a(this));
            c.a.p0.v.j.g.b bVar = new c.a.p0.v.j.g.b(this.f49462e);
            this.x = bVar;
            bVar.e(new b(this));
            this.y = new c.a.p0.v.j.g.a(this.f49462e, new c(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View inflate = getLayoutInflater().inflate(R.layout.ala_achievement_mark_mask_layout, (ViewGroup) null);
            this.f49463f = inflate;
            setContentView(inflate);
            this.f49463f.setOnClickListener(new d(this));
            TbImageView tbImageView = (TbImageView) this.f49463f.findViewById(R.id.mark_img);
            this.f49464g = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f49464g.setDefaultResource(R.drawable.pic_live_honor);
            this.f49465h = (FrameLayout) this.f49463f.findViewById(R.id.mark_img_layout);
            this.f49466i = (TextView) this.f49463f.findViewById(R.id.mark_title);
            this.f49467j = (RelativeLayout) this.f49463f.findViewById(R.id.mark_desc_layout);
            this.k = (TextView) this.f49463f.findViewById(R.id.mark_desc);
            this.l = (TextView) this.f49463f.findViewById(R.id.mark_upgrade_desc);
            MarkLevelGroup markLevelGroup = (MarkLevelGroup) this.f49463f.findViewById(R.id.mark_level_view);
            this.m = markLevelGroup;
            markLevelGroup.setCallback(new e(this));
            this.n = (TextView) this.f49463f.findViewById(R.id.mark_ops_btn);
            this.u = (TextView) this.f49463f.findViewById(R.id.mark_limit_time);
            this.s = (LinearLayout) findViewById(R.id.mark_tdou_layout);
            this.t = (TextView) findViewById(R.id.mark_tdou_price);
            this.v = (LinearLayout) findViewById(R.id.user_tdou_layout);
            this.w = (TextView) findViewById(R.id.user_tdou_price);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (1 == this.o.j()) {
                this.q.A(false, this.o.d());
            } else if (2 == this.o.j()) {
                this.q.A(true, this.o.d());
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f49462e.getPageActivity());
            aVar.setMessageShowCenter(true);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.ala_achievement_ops_alert_title);
            aVar.setMessageId(R.string.ala_achievement_ops_alert_content);
            aVar.setPositiveButton(R.string.dialog_ok, new g(this));
            aVar.setNegativeButton(R.string.dialog_cancel, new h(this));
            aVar.create(this.f49462e).show();
        }
    }

    public void show(c.a.p0.v.j.g.c.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        this.o = bVar;
        show();
        m();
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.setVisibility(4);
            this.l.setVisibility(4);
            this.s.setVisibility(4);
            this.m.setVisibility(4);
            this.v.setVisibility(8);
            if (this.o.m()) {
                this.s.setVisibility(0);
                this.v.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.t.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds8));
                this.t.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.t.setText(AlaStringHelper.formatLowercasekDou((float) this.o.n));
                this.w.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
                this.w.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.w.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                if (this.o.j() == 1) {
                    this.v.setVisibility(8);
                }
            } else if (this.o.l()) {
                this.k.setVisibility(0);
                this.k.setText(this.o.a());
            } else {
                this.m.setVisibility(0);
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                this.k.setText(this.o.a());
                this.l.setText(this.o.i());
                this.m.updateData(this.o);
            }
        }
    }

    public final void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            if (StringUtils.isNull(str)) {
                this.f49464g.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
            } else {
                this.f49464g.startLoad(str, 10, false);
            }
            this.f49466i.setText(str2);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.o.j() != 1 && this.o.j() != 2) {
                this.u.setVisibility(8);
                return;
            }
            this.u.setVisibility(0);
            this.u.setText(this.o.b());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int j2 = this.o.j();
            if (j2 != 0) {
                if (j2 != 1) {
                    if (j2 != 2) {
                        if (j2 == 3) {
                            if (this.o.m()) {
                                this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                                this.n.setTextSize(0, A);
                                this.n.setText(R.string.ala_enter_effect_tdou_buy);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                                if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                                    this.n.setText(R.string.ala_achievement_get_tdou_label);
                                }
                            } else if (this.o.l()) {
                                this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                                this.n.setTextSize(0, A);
                                this.n.setText(R.string.ala_nobility_open);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                            } else {
                                this.n.setBackgroundResource(R.drawable.transparent_bg);
                                this.n.setTextSize(0, z);
                                this.n.setText(R.string.ala_achievement_mark_status_expired);
                                this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                            }
                        }
                    } else if (this.o.m()) {
                        this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                        this.n.setTextSize(0, A);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    } else if (this.o.l()) {
                        this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                        this.n.setTextSize(0, A);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    } else {
                        this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                        this.n.setTextSize(0, A);
                        this.n.setText(R.string.ala_achievement_wear_mark);
                        this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    }
                } else if (this.o.m()) {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, A);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                } else if (this.o.l()) {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, A);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                } else {
                    this.n.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.n.setTextSize(0, A);
                    this.n.setText(R.string.ala_achievement_unwear_mark);
                    this.n.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                }
            } else if (this.o.m()) {
                this.n.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.n.setTextSize(0, A);
                this.n.setText(R.string.ala_enter_effect_tdou_buy);
                this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                if (this.o.n > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.n.setText(R.string.ala_achievement_get_tdou_label);
                }
            } else if (this.o.l()) {
                this.n.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                this.n.setTextSize(0, A);
                this.n.setText(R.string.ala_nobility_open);
                this.n.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
            } else {
                this.n.setBackgroundResource(R.drawable.transparent_bg);
                this.n.setTextSize(0, z);
                this.n.setText(R.string.ala_achievement_mark_status_unlock);
                this.n.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
            }
            this.n.setOnClickListener(new f(this));
        }
    }
}
