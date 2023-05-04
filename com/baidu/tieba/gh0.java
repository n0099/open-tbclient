package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class gh0 extends nk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ng0 f;

    /* loaded from: classes4.dex */
    public static final class a extends ul0<ng0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gh0 gh0Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh0Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gh0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ul0
        public void onEvent(ng0 it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.b.e == null || (!Intrinsics.areEqual(it.a, "2"))) {
                    return;
                }
                this.b.f = it;
                if (it.h) {
                    tk0 tk0Var = (tk0) this.b.e.get();
                    if (tk0Var != null) {
                        Context b = li0.b();
                        Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                        tk0Var.update(b.getResources().getString(R.string.nad_download_open), this.b.a);
                        return;
                    }
                    return;
                }
                this.b.u();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh0(ak0 data, tk0<?> view2) {
        super(data, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ak0) objArr2[0], (tk0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ql0.a().b(this, new a(this, ng0.class));
        }
    }

    @Override // com.baidu.tieba.nk0
    public void u() {
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        String str4;
        boolean z4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ng0 ng0Var = this.f;
            if (ng0Var == null) {
                super.u();
            } else if (this.e == null) {
            } else {
                String str12 = null;
                if (ng0Var != null) {
                    str = ng0Var.c;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    ng0 ng0Var2 = this.f;
                    if (ng0Var2 != null) {
                        str2 = ng0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        Context b = li0.b();
                        Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                        Resources resources = b.getResources();
                        String string = resources.getString(R.string.nad_download_start);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.nad_download_start)");
                        AdDownloadStatus adDownloadStatus = this.a.c;
                        if (adDownloadStatus != null) {
                            switch (fh0.$EnumSwitchMapping$0[adDownloadStatus.ordinal()]) {
                                case 1:
                                    Object[] objArr = new Object[2];
                                    ng0 ng0Var3 = this.f;
                                    if (ng0Var3 != null) {
                                        str6 = ng0Var3.b;
                                    } else {
                                        str6 = null;
                                    }
                                    objArr[0] = str6;
                                    ng0 ng0Var4 = this.f;
                                    if (ng0Var4 != null) {
                                        str7 = ng0Var4.c;
                                    } else {
                                        str7 = null;
                                    }
                                    objArr[1] = str7;
                                    string = resources.getString(R.string.nad_reward_download_task_init, objArr);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 2:
                                    string = new DecimalFormat("#.#%").format(this.a.i);
                                    Intrinsics.checkNotNullExpressionValue(string, "format.format(mData.progress.toDouble())");
                                    break;
                                case 3:
                                    string = resources.getString(R.string.nad_download_continue);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.nad_download_continue)");
                                    break;
                                case 4:
                                    Object[] objArr2 = new Object[2];
                                    ng0 ng0Var5 = this.f;
                                    if (ng0Var5 != null) {
                                        str8 = ng0Var5.b;
                                    } else {
                                        str8 = null;
                                    }
                                    objArr2[0] = str8;
                                    ng0 ng0Var6 = this.f;
                                    if (ng0Var6 != null) {
                                        str9 = ng0Var6.c;
                                    } else {
                                        str9 = null;
                                    }
                                    objArr2[1] = str9;
                                    string = resources.getString(R.string.nad_reward_download_task_install, objArr2);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 5:
                                    Object[] objArr3 = new Object[2];
                                    ng0 ng0Var7 = this.f;
                                    if (ng0Var7 != null) {
                                        str10 = ng0Var7.b;
                                    } else {
                                        str10 = null;
                                    }
                                    objArr3[0] = str10;
                                    ng0 ng0Var8 = this.f;
                                    if (ng0Var8 != null) {
                                        str11 = ng0Var8.c;
                                    } else {
                                        str11 = null;
                                    }
                                    objArr3[1] = str11;
                                    string = resources.getString(R.string.nad_reward_download_task_open, objArr3);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 6:
                                    string = resources.getString(R.string.nad_download_failed_retry);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ad_download_failed_retry)");
                                    break;
                            }
                        }
                        ng0 ng0Var9 = this.f;
                        if (ng0Var9 != null) {
                            str3 = ng0Var9.d;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null && str3.length() != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            ng0 ng0Var10 = this.f;
                            if (ng0Var10 != null) {
                                str4 = ng0Var10.e;
                            } else {
                                str4 = null;
                            }
                            if (str4 != null && str4.length() != 0) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (!z4 && (this.e.get() instanceof NadMiniVideoDownloadView)) {
                                tk0<?> tk0Var = this.e.get();
                                if (tk0Var != null) {
                                    Drawable background = ((NadMiniVideoDownloadView) tk0Var).getBackground();
                                    if (background != null) {
                                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                        int[] iArr = new int[2];
                                        ng0 ng0Var11 = this.f;
                                        if (ng0Var11 != null) {
                                            str5 = ng0Var11.d;
                                        } else {
                                            str5 = null;
                                        }
                                        iArr[0] = z31.a(str5, R.color.nad_reward_full_tail_btn_color);
                                        ng0 ng0Var12 = this.f;
                                        if (ng0Var12 != null) {
                                            str12 = ng0Var12.e;
                                        }
                                        iArr[1] = z31.a(str12, R.color.nad_reward_full_tail_btn_color);
                                        gradientDrawable.setColors(iArr);
                                        tk0<?> tk0Var2 = this.e.get();
                                        if (tk0Var2 != null) {
                                            ((NadMiniVideoDownloadView) tk0Var2).setBackground(gradientDrawable);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView");
                                }
                            }
                        }
                        tk0<?> tk0Var3 = this.e.get();
                        if (tk0Var3 != null) {
                            tk0Var3.update(string, this.a);
                        }
                    }
                }
            }
        }
    }
}
