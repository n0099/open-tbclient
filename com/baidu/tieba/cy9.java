package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.TagsInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public final class cy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final cy9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947691238, "Lcom/baidu/tieba/cy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947691238, "Lcom/baidu/tieba/cy9;");
                return;
            }
        }
        a = new cy9();
    }

    public cy9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean A(ds9 ds9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ds9Var)) == null) {
            if (ds9Var != null) {
                return ds9Var.j0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final String n(ThreadData threadData) {
        InterceptResult invokeL;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, threadData)) == null) {
            if (threadData == null || (l = Long.valueOf(threadData.getFid()).toString()) == null) {
                return "";
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String o(ds9 ds9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, ds9Var)) == null) {
            if (ds9Var != null) {
                str = ds9Var.l();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String p(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, threadData)) == null) {
            if (threadData != null) {
                str = threadData.getForum_name();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String q(ds9 ds9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, ds9Var)) == null) {
            if (ds9Var != null) {
                str = ds9Var.m();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final sy9 r(qu9<?> qu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, qu9Var)) == null) {
            if (qu9Var != null) {
                return qu9Var.h1();
            }
            return null;
        }
        return (sy9) invokeL.objValue;
    }

    @JvmStatic
    public static final sy9 s(g1a g1aVar) {
        InterceptResult invokeL;
        AbsPbActivity r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, g1aVar)) == null) {
            if (g1aVar != null && (r0 = g1aVar.r0()) != null) {
                return r0.c;
            }
            return null;
        }
        return (sy9) invokeL.objValue;
    }

    @JvmStatic
    public static final int t(ds9 ds9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, ds9Var)) == null) {
            if (ds9Var != null) {
                return ds9Var.W();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @JvmStatic
    public static final int u(qu9<?> qu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, qu9Var)) == null) {
            if (qu9Var != null) {
                return qu9Var.v0();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @JvmStatic
    public static final boolean v(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean w(ds9 ds9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, ds9Var)) == null) {
            if (ds9Var != null && (O = ds9Var.O()) != null) {
                return O.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean x(qu9<?> qu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, qu9Var)) == null) {
            if (qu9Var != null) {
                return qu9Var.Y0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean y(g1a g1aVar) {
        InterceptResult invokeL;
        AbsPbActivity r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, g1aVar)) == null) {
            if (g1aVar != null && (r0 = g1aVar.r0()) != null) {
                return r0.Y0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean z(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isUgcThreadType();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pbCommenFloorItemViewHolder, uraVar) == null) {
            boolean z = true;
            z = (uraVar == null || !uraVar.y0()) ? false : false;
            AgreeView agreeView = null;
            if (!z) {
                if (pbCommenFloorItemViewHolder != null) {
                    agreeView = pbCommenFloorItemViewHolder.d0;
                }
                if (agreeView != null) {
                    agreeView.setVisibility(0);
                    return;
                }
                return;
            }
            if (pbCommenFloorItemViewHolder != null) {
                agreeView = pbCommenFloorItemViewHolder.d0;
            }
            if (agreeView != null) {
                agreeView.setVisibility(8);
            }
        }
    }

    @JvmStatic
    public static final boolean b(ThreadData threadData, ura uraVar) {
        InterceptResult invokeLL;
        MetaData author;
        String userId;
        String str;
        MetaData t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, threadData, uraVar)) == null) {
            if (threadData != null && (author = threadData.getAuthor()) != null && (userId = author.getUserId()) != null) {
                if (uraVar != null && (t = uraVar.t()) != null) {
                    str = t.getUserId();
                } else {
                    str = null;
                }
                return userId.equals(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @JvmStatic
    public static final void C(TextView textView, ds9 ds9Var, String str) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView, ds9Var, str) == null) {
            if (textView != null) {
                obj = textView.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof ura)) {
                return;
            }
            E(textView, (ura) obj, str, A(ds9Var));
        }
    }

    @JvmStatic
    public static final void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar, ds9 ds9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, pbCommenFloorItemViewHolder, uraVar, ds9Var) == null) && uraVar != null && ds9Var != null) {
            if (pbCommenFloorItemViewHolder != null) {
                imageView = pbCommenFloorItemViewHolder.I;
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public static final void j(Context context, int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65553, null, context, i, view2) != null) || context == null) {
            return;
        }
        CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, i);
        BrowserHelper.startWebActivity(context, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
    }

    @JvmStatic
    public static final void D(TextView textView, ura uraVar, ds9 ds9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, textView, uraVar, ds9Var, str) == null) {
            E(textView, uraVar, str, A(ds9Var));
        }
    }

    @JvmStatic
    public static final void E(TextView textView, ura uraVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{textView, uraVar, str, Boolean.valueOf(z)}) == null) {
            F(textView, uraVar, str, z, null);
        }
    }

    @JvmStatic
    public static final void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar, ds9 ds9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65548, null, pbCommenFloorItemViewHolder, uraVar, ds9Var, i) == null) {
            d(pbCommenFloorItemViewHolder, uraVar, i, A(ds9Var));
        }
    }

    @JvmStatic
    public static final void F(TextView textView, ura uraVar, String str, boolean z, gu9 gu9Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{textView, uraVar, str, Boolean.valueOf(z), gu9Var}) == null) && textView != null && uraVar != null) {
            if (gu9Var != null) {
                gu9Var.setVisibility(8);
            }
            textView.setTag(uraVar);
            if (z) {
                uraVar.q1(Boolean.FALSE);
                uraVar.e1(0);
                textView.setTag(null);
            } else if (uraVar.t() != null) {
                MetaData t = uraVar.t();
                Intrinsics.checkNotNullExpressionValue(t, "postData.author");
                if (str != null && !Intrinsics.areEqual(str, "0") && Intrinsics.areEqual(str, t.getUserId())) {
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                    return;
                }
                boolean z3 = true;
                if (t.getIs_bawu() == 1 && uraVar.C0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("manager", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_content_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_manage_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    uraVar.q1(Boolean.TRUE);
                    uraVar.e1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    ArrayList<TagsInfo> tags = t.getTags();
                    if (tags != null && !tags.isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        uraVar.q1(Boolean.FALSE);
                        ThemeColorInfo info = t.getTags().get(0).img_info;
                        Intrinsics.checkNotNullExpressionValue(info, "info");
                        if (c1b.g(info).length() != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            uraVar.e1(0);
                            if (gu9Var != null) {
                                gu9Var.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        uraVar.e1(c1b.i(info));
                        if (gu9Var != null) {
                            f(gu9Var, info);
                            return;
                        }
                        return;
                    }
                    uraVar.q1(Boolean.FALSE);
                    uraVar.e1(0);
                }
            } else {
                uraVar.q1(Boolean.FALSE);
                uraVar.e1(0);
            }
        }
    }

    @JvmStatic
    public static final void a(ura uraVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sy9 sy9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65544, null, uraVar, pbCommenFloorItemViewHolder, sy9Var, i) == null) {
            if (pbCommenFloorItemViewHolder.H != null && uraVar.t() != null) {
                pbCommenFloorItemViewHolder.H.setTag(R.id.tag_user_id, uraVar.t().getUserId());
                if (sy9Var != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(sy9Var.c);
                }
                ArrayList<IconData> iconInfo = uraVar.t().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, i, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            Boolean g0 = uraVar.g0();
            Intrinsics.checkNotNullExpressionValue(g0, "postData.showIdentify");
            if (g0.booleanValue() && !uraVar.S()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar, int i, boolean z) {
        boolean z2;
        String str;
        boolean z3;
        sc5 Z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{pbCommenFloorItemViewHolder, uraVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && uraVar != null) {
            boolean z4 = true;
            if (uraVar.J() > 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b51);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.is_floor)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(uraVar.J())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z2 = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z2 = false;
            }
            String str2 = null;
            if (uraVar.t() != null) {
                str = uraVar.t().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z3 = true;
                    Z = uraVar.Z();
                    if (Z != null) {
                        str2 = Z.b();
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    z4 = (Z != null || StringUtils.isNull(str2) || z) ? false : false;
                    if (!z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i2 = i;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i2 = 0;
                    }
                    if (z4 && !z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        i3 = i;
                    }
                    pbCommenFloorItemViewHolder.l.setPadding(i2, 0, i3, 0);
                    if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(uraVar.q0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(uraVar.q0()));
                    } else {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(uraVar.q0()));
                    }
                    if (!z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setText(str);
                    } else if (z4) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(i, 0, 0, 0);
                        if (uraVar.e0) {
                            pbCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(str2, 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.o.setText(str2);
                        }
                    } else {
                        pbCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            } else {
                str = null;
            }
            z3 = false;
            Z = uraVar.Z();
            if (Z != null) {
            }
            if (str2 == null) {
            }
            if (Z != null) {
            }
            if (!z2) {
            }
            if (z4) {
            }
            pbCommenFloorItemViewHolder.n.setVisibility(0);
            i3 = i;
            pbCommenFloorItemViewHolder.l.setPadding(i2, 0, i3, 0);
            if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(uraVar.q0()), "yyyy"))) {
            }
            if (!z3) {
            }
            pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    @JvmStatic
    public static final void f(gu9 identityImageView, ThemeColorInfo imgInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, identityImageView, imgInfo) == null) {
            Intrinsics.checkNotNullParameter(identityImageView, "identityImageView");
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            String g = c1b.g(imgInfo);
            if (g.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                identityImageView.setVisibility(8);
                return;
            }
            int h = c1b.h(imgInfo);
            int i = c1b.i(imgInfo);
            identityImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams layoutParams = identityImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = h;
            }
            if (layoutParams != null) {
                layoutParams.width = i;
            }
            identityImageView.setVisibility(0);
            identityImageView.startLoad(g);
        }
    }

    @JvmStatic
    public static final void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar, View rootView, int i, ThreadData threadData, String str, sy9 sy9Var, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{pbCommenFloorItemViewHolder, uraVar, rootView, Integer.valueOf(i), threadData, str, sy9Var, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            i(pbCommenFloorItemViewHolder, uraVar, rootView, threadData, i, str, sy9Var, i2, statisticItem, context, n(threadData), p(threadData), z, z2, i3, z(threadData));
        }
    }

    @JvmStatic
    public static final void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar, View rootView, int i, ds9 ds9Var, String str, sy9 sy9Var, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{pbCommenFloorItemViewHolder, uraVar, rootView, Integer.valueOf(i), ds9Var, str, sy9Var, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            if (ds9Var != null) {
                threadData = ds9Var.O();
            } else {
                threadData = null;
            }
            ThreadData threadData2 = threadData;
            i(pbCommenFloorItemViewHolder, uraVar, rootView, threadData2, i, str, sy9Var, i2, statisticItem, context, o(ds9Var), q(ds9Var), z, z2, i3, z(threadData2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x05e6, code lost:
        if (r9.length() != 0) goto L183;
     */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0733  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void i(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final ura uraVar, View view2, ThreadData threadData, int i, String str, sy9 sy9Var, int i2, StatisticItem statisticItem, final Context context, String str2, String str3, boolean z, boolean z2, int i3, boolean z3) {
        String str4;
        Object obj;
        String str5;
        int i4;
        final String str6;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String userId;
        boolean z11;
        boolean z12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{pbCommenFloorItemViewHolder, uraVar, view2, threadData, Integer.valueOf(i), str, sy9Var, Integer.valueOf(i2), statisticItem, context, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) && pbCommenFloorItemViewHolder != null && uraVar != null && threadData != null) {
            if (uraVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.q.setTargetScheme("");
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme("");
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            if (uraVar.t() == null) {
                str4 = "";
                obj = "0";
            } else {
                if (str != null && !Intrinsics.areEqual("0", str) && Intrinsics.areEqual(str, uraVar.t().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = uraVar.t().getIconInfo();
                ArrayList<IconData> tShowInfoNew = uraVar.t().getTShowInfoNew();
                str4 = "";
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                obj = "0";
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                if (iconInfo.size() < 2) {
                    int size = iconInfo.size();
                    if (size > 1) {
                        uraVar.z1((dimens * size) + (dimens2 * size));
                    } else if (size == 1) {
                        uraVar.z1(dimens + dimens2);
                    } else {
                        uraVar.z1(0);
                    }
                } else {
                    uraVar.z1((dimens * 2) + (dimens2 * 2));
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (sy9Var != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(sy9Var.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !uraVar.t().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, i2, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = uraVar.t().getAvater();
                String avatarUrl = uraVar.t().getAvatarUrl();
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, uraVar.t().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_target_scheme, uraVar.t().getTargetScheme());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, uraVar.t().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, uraVar.t().getVirtualUserUrl());
                if (statisticItem != null) {
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, statisticItem);
                }
                String name_show = uraVar.t().getName_show();
                String userName = uraVar.t().getUserName();
                if (NickNameActivitySwitch.isOn() && !TextUtils.equals(name_show, userName)) {
                    pbCommenFloorItemViewHolder.h.setText(hq9.b(context, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, hq9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (uraVar.t().getPendantData() != null && !StringUtils.isNull(uraVar.t().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(uraVar.t());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    iu9.a(pbCommenFloorItemViewHolder.F.getHeadView(), avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(uraVar.t().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme(uraVar.t().getTargetScheme());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(uraVar.t().getUserName());
                    pbCommenFloorItemViewHolder.F.getHeadView().setFid(str2);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFName(str3);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFloor(uraVar.J());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTid(uraVar.T());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.F.i(uraVar.t());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, uraVar.t(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(uraVar.t().getUserId());
                    pbCommenFloorItemViewHolder.q.setTargetScheme(uraVar.t().getTargetScheme());
                    pbCommenFloorItemViewHolder.q.setFid(str2);
                    pbCommenFloorItemViewHolder.q.setFName(str3);
                    pbCommenFloorItemViewHolder.q.setFloor(uraVar.J());
                    pbCommenFloorItemViewHolder.q.setTid(uraVar.T());
                    pbCommenFloorItemViewHolder.q.setUserName(uraVar.t().getUserName(), uraVar.t0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, uraVar.t().getVirtualUserUrl());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    iu9.a(pbCommenFloorItemViewHolder.q, avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                if (uraVar.t() != null && uraVar.t().getAlaInfo() != null && uraVar.t().getAlaUserData() != null && uraVar.t().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(uraVar.t().getAlaInfo());
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(uraVar.t().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
                }
                F(pbCommenFloorItemViewHolder.i, uraVar, str, z3, pbCommenFloorItemViewHolder.j);
                if (z && TbSingleton.getInstance().isUserGrowthOpen() && uraVar.t().getUserGrowthData() != null) {
                    final int a2 = uraVar.t().getUserGrowthData().a();
                    if (a2 >= 0 && a2 < 11) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        pbCommenFloorItemViewHolder.k.setImageResource(rs.b(a2));
                        pbCommenFloorItemViewHolder.k.setVisibility(0);
                        pbCommenFloorItemViewHolder.k.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ay9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                    cy9.j(context, a2, view3);
                                }
                            }
                        });
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                    } else {
                        pbCommenFloorItemViewHolder.k.setVisibility(8);
                    }
                }
            }
            if (z2 && uraVar.t() != null) {
                i4 = uraVar.t().getLevel_id();
                str5 = uraVar.t().getLevelName();
            } else {
                str5 = str4;
                i4 = 0;
            }
            if (z3) {
                i4 = 0;
            }
            if (i4 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i4, str5);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (z) {
                if (uraVar.V() == 1 && threadData.isQuestionThread() && !b(threadData, uraVar)) {
                    uraVar.c1(true);
                    pbCommenFloorItemViewHolder.y0.setVisibility(0);
                    if (!uraVar.y0()) {
                        Boolean U = uraVar.U();
                        Intrinsics.checkNotNullExpressionValue(U, "postData.getIsShowAskView()");
                        if (U.booleanValue()) {
                            pbCommenFloorItemViewHolder.z0.setVisibility(0);
                            pbCommenFloorItemViewHolder.d0.setVisibility(8);
                            pbCommenFloorItemViewHolder.e0.setVisibility(8);
                            pbCommenFloorItemViewHolder.z0.postDelayed(new Runnable() { // from class: com.baidu.tieba.zx9
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        cy9.k(PbCommenFloorItemViewHolder.this, uraVar);
                                    }
                                }
                            }, 3000L);
                        } else {
                            pbCommenFloorItemViewHolder.z0.setVisibility(8);
                            B(pbCommenFloorItemViewHolder, uraVar);
                            pbCommenFloorItemViewHolder.e0.setVisibility(0);
                        }
                    }
                } else {
                    uraVar.c1(false);
                    pbCommenFloorItemViewHolder.y0.setVisibility(8);
                    if (!uraVar.y0()) {
                        pbCommenFloorItemViewHolder.z0.setVisibility(8);
                        B(pbCommenFloorItemViewHolder, uraVar);
                        pbCommenFloorItemViewHolder.e0.setVisibility(0);
                    }
                }
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.y0, R.color.CAM_X0204);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0105, 1);
            }
            a(uraVar, pbCommenFloorItemViewHolder, sy9Var, 2);
            if (uraVar.t() != null && uraVar.t().getName_show() != null) {
                str6 = uraVar.t().getName_show();
            } else {
                str6 = str4;
            }
            pbCommenFloorItemViewHolder.f.post(new Runnable() { // from class: com.baidu.tieba.by9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        cy9.l(PbCommenFloorItemViewHolder.this, str6);
                    }
                }
            });
            if (!StringUtils.isNull(uraVar.t().getDiplayIntro())) {
                pbCommenFloorItemViewHolder.A0.setVisibility(0);
                pbCommenFloorItemViewHolder.A0.setText(uraVar.t().getDiplayIntro());
            } else {
                pbCommenFloorItemViewHolder.A0.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, uraVar);
            sparseArray.put(R.id.tag_load_sub_data, uraVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(uraVar.J()));
            sparseArray.put(R.id.tag_forbid_user_post_id, uraVar.T());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.valueOf(z3));
            if (uraVar.t() != null && !StringUtils.isNull(uraVar.t().getVirtualUserUrl())) {
                i5 = i3;
                z4 = true;
            } else {
                i5 = i3;
                z4 = false;
            }
            if (i5 != 0 && !v(threadData)) {
                if (i5 != 1002 && i5 != 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i5 != 3 && !z3) {
                    z5 = true;
                    z6 = true;
                } else {
                    z5 = false;
                    z6 = false;
                }
                if (uraVar.t() != null) {
                    String userId2 = uraVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z11 = false;
                    }
                    if (userId2 != null) {
                        if (!Intrinsics.areEqual(obj, userId2)) {
                        }
                    }
                }
                z7 = z11;
                if (threadData.getAuthor() != null && uraVar.t() != null) {
                    userId = threadData.getAuthor().getUserId();
                    String userId3 = uraVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        if (UtilHelper.isCurrentAccount(userId3)) {
                            z8 = false;
                            z5 = true;
                            z9 = true;
                        } else {
                            z8 = true;
                            z5 = true;
                            z9 = false;
                        }
                        z10 = true;
                        if (uraVar.t() != null && UtilHelper.isCurrentAccount(uraVar.t().getUserId())) {
                            z5 = true;
                            z9 = true;
                        }
                        if (z4) {
                            z8 = false;
                            z5 = false;
                            z7 = false;
                        }
                        int i6 = 1;
                        if (uraVar.J() == 1) {
                            i6 = 0;
                        }
                        if (z3) {
                            z8 = false;
                            z7 = false;
                        }
                        if (z7) {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            if (uraVar.t() != null) {
                                sparseArray.put(R.id.tag_forbid_user_name, uraVar.t().getUserName());
                                sparseArray.put(R.id.tag_forbid_user_name_show, uraVar.t().getName_show());
                                sparseArray.put(R.id.tag_forbid_user_portrait, uraVar.t().getPortrait());
                            }
                        } else {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                        }
                        if (z8) {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (uraVar.t() != null) {
                                sparseArray.put(R.id.tag_user_mute_mute_userid, uraVar.t().getUserId());
                                sparseArray.put(R.id.tag_user_mute_mute_username, uraVar.t().getUserName());
                                sparseArray.put(R.id.tag_user_mute_mute_nameshow, uraVar.t().getName_show());
                            }
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                            sparseArray.put(R.id.tag_user_mute_post_id, uraVar.T());
                        } else {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(uraVar.A0()));
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z9));
                            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                            sparseArray.put(R.id.tag_del_post_id, uraVar.T());
                        } else {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                        pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    }
                }
                z8 = false;
                z9 = false;
                z10 = false;
                if (uraVar.t() != null) {
                    z5 = true;
                    z9 = true;
                }
                if (z4) {
                }
                int i62 = 1;
                if (uraVar.J() == 1) {
                }
                if (z3) {
                }
                if (z7) {
                }
                if (z8) {
                }
                if (z5) {
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (threadData.getAuthor() != null) {
                userId = threadData.getAuthor().getUserId();
                String userId32 = uraVar.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z8 = false;
            z9 = false;
            z10 = false;
            if (uraVar.t() != null) {
            }
            if (z4) {
            }
            int i622 = 1;
            if (uraVar.J() == 1) {
            }
            if (z3) {
            }
            if (z7) {
            }
            if (z8) {
            }
            if (z5) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public static final void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ura uraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, pbCommenFloorItemViewHolder, uraVar) == null) {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
            B(pbCommenFloorItemViewHolder, uraVar);
            pbCommenFloorItemViewHolder.e0.setVisibility(0);
        }
    }

    @JvmStatic
    public static final StatisticItem m(ds9 ds9Var, ura postData) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, ds9Var, postData)) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            if (postData.f0) {
                i = 2;
            } else {
                i = 8;
            }
            return c1a.k(ds9Var, postData, postData.g0, i, 2);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static final void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, pbCommenFloorItemViewHolder, str) == null) {
            int measuredWidth = pbCommenFloorItemViewHolder.f.getMeasuredWidth();
            ArrayList arrayList = new ArrayList();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
            Intrinsics.checkNotNullExpressionValue(userIconBox, "holder.mVipIconBox");
            arrayList.add(userIconBox);
            TextView textView = pbCommenFloorItemViewHolder.i;
            Intrinsics.checkNotNullExpressionValue(textView, "holder.mFloorAuthorView");
            arrayList.add(textView);
            TbImageView tbImageView = pbCommenFloorItemViewHolder.j;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "holder.mFloorAuthorImageView");
            arrayList.add(tbImageView);
            TbImageView tbImageView2 = pbCommenFloorItemViewHolder.k;
            if (tbImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(tbImageView2, "holder.mPbCommonUserGrowthLevel");
                arrayList.add(tbImageView2);
            }
            RelativeLayout relativeLayout = pbCommenFloorItemViewHolder.y0;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.rlAgreeShow");
            arrayList.add(relativeLayout);
            TbLevelView tbLevelView = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView, "holder.mForumLevelIcon");
            arrayList.add(tbLevelView);
            TextView textView2 = pbCommenFloorItemViewHolder.g;
            Intrinsics.checkNotNullExpressionValue(textView2, "holder.mUserNameView");
            TbLevelView tbLevelView2 = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView2, "holder.mForumLevelIcon");
            mu5.c(measuredWidth, str, textView2, tbLevelView2, arrayList, pbCommenFloorItemViewHolder.H);
            ou5.a(pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.G, pbCommenFloorItemViewHolder.k, pbCommenFloorItemViewHolder.E, pbCommenFloorItemViewHolder.H, 1);
        }
    }
}
