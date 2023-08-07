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
/* loaded from: classes6.dex */
public final class ii0 extends rl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ph0 g;

    /* loaded from: classes6.dex */
    public static final class a extends fn0<ph0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ii0 ii0Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii0Var, cls};
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
            this.b = ii0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fn0
        public void onEvent(ph0 it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.b.e != null && !(!Intrinsics.areEqual(it.a, "2"))) {
                    this.b.g = it;
                    if (it.h) {
                        xl0 xl0Var = (xl0) this.b.e.get();
                        if (xl0Var != null) {
                            Context b = pj0.b();
                            Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                            xl0Var.update(b.getResources().getString(R.string.nad_download_open), this.b.a);
                            return;
                        }
                        return;
                    }
                    this.b.t();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0(el0 data, xl0<?> view2) {
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
                super((el0) objArr2[0], (xl0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.tieba.rl0
    public void t() {
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
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ph0 ph0Var = this.g;
            if (ph0Var == null) {
                super.t();
            } else if (this.e == null) {
            } else {
                String str12 = null;
                if (ph0Var != null) {
                    str = ph0Var.c;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    ph0 ph0Var2 = this.g;
                    if (ph0Var2 != null) {
                        str2 = ph0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        Context b = pj0.b();
                        Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                        Resources resources = b.getResources();
                        String string = resources.getString(R.string.nad_download_start);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.nad_download_start)");
                        AdDownloadStatus adDownloadStatus = this.a.c;
                        if (adDownloadStatus != null) {
                            switch (hi0.$EnumSwitchMapping$0[adDownloadStatus.ordinal()]) {
                                case 1:
                                    Object[] objArr = new Object[2];
                                    ph0 ph0Var3 = this.g;
                                    if (ph0Var3 != null) {
                                        str6 = ph0Var3.b;
                                    } else {
                                        str6 = null;
                                    }
                                    objArr[0] = str6;
                                    ph0 ph0Var4 = this.g;
                                    if (ph0Var4 != null) {
                                        str7 = ph0Var4.c;
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
                                    ph0 ph0Var5 = this.g;
                                    if (ph0Var5 != null) {
                                        str8 = ph0Var5.b;
                                    } else {
                                        str8 = null;
                                    }
                                    objArr2[0] = str8;
                                    ph0 ph0Var6 = this.g;
                                    if (ph0Var6 != null) {
                                        str9 = ph0Var6.c;
                                    } else {
                                        str9 = null;
                                    }
                                    objArr2[1] = str9;
                                    string = resources.getString(R.string.nad_reward_download_task_install, objArr2);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 5:
                                    Object[] objArr3 = new Object[2];
                                    ph0 ph0Var7 = this.g;
                                    if (ph0Var7 != null) {
                                        str10 = ph0Var7.b;
                                    } else {
                                        str10 = null;
                                    }
                                    objArr3[0] = str10;
                                    ph0 ph0Var8 = this.g;
                                    if (ph0Var8 != null) {
                                        str11 = ph0Var8.c;
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
                        ph0 ph0Var9 = this.g;
                        if (ph0Var9 != null) {
                            str3 = ph0Var9.d;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null && str3.length() != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            ph0 ph0Var10 = this.g;
                            if (ph0Var10 != null) {
                                str4 = ph0Var10.e;
                            } else {
                                str4 = null;
                            }
                            if (str4 != null && str4.length() != 0) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (!z4 && (this.e.get() instanceof NadMiniVideoDownloadView)) {
                                xl0<?> xl0Var = this.e.get();
                                if (xl0Var != null) {
                                    Drawable background = ((NadMiniVideoDownloadView) xl0Var).getBackground();
                                    if (background != null) {
                                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                        int[] iArr = new int[2];
                                        ph0 ph0Var11 = this.g;
                                        if (ph0Var11 != null) {
                                            str5 = ph0Var11.d;
                                        } else {
                                            str5 = null;
                                        }
                                        iArr[0] = d61.a(str5, R.color.nad_reward_full_tail_btn_color);
                                        ph0 ph0Var12 = this.g;
                                        if (ph0Var12 != null) {
                                            str12 = ph0Var12.e;
                                        }
                                        iArr[1] = d61.a(str12, R.color.nad_reward_full_tail_btn_color);
                                        gradientDrawable.setColors(iArr);
                                        xl0<?> xl0Var2 = this.e.get();
                                        if (xl0Var2 != null) {
                                            ((NadMiniVideoDownloadView) xl0Var2).setBackground(gradientDrawable);
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
                        xl0<?> xl0Var3 = this.e.get();
                        if (xl0Var3 != null) {
                            xl0Var3.update(string, this.a);
                        }
                    }
                }
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bn0.a().b(this, new a(this, ph0.class));
        }
    }
}
