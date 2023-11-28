package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.TagsInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public final class f2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(nwa postData, PbCommenFloorItemViewHolder holder, v2a v2aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, postData, holder, v2aVar, i) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder.H != null && postData.u() != null) {
                holder.H.setTag(R.id.tag_user_id, postData.u().getUserId());
                if (v2aVar != null) {
                    holder.H.setOnClickListener(v2aVar.c);
                }
                ArrayList<IconData> iconInfo = postData.u().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                holder.H.g(iconInfo, i, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            Boolean h0 = postData.h0();
            Intrinsics.checkNotNullExpressionValue(h0, "postData.showIdentify");
            if (h0.booleanValue() && !postData.T()) {
                holder.i.setVisibility(0);
            } else {
                holder.i.setVisibility(8);
            }
        }
    }

    public static final boolean b(ThreadData threadData, nwa nwaVar) {
        InterceptResult invokeLL;
        MetaData author;
        String userId;
        String str;
        MetaData u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, nwaVar)) == null) {
            if (threadData != null && (author = threadData.getAuthor()) != null && (userId = author.getUserId()) != null) {
                if (nwaVar != null && (u = nwaVar.u()) != null) {
                    str = u.getUserId();
                } else {
                    str = null;
                }
                return userId.equals(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final void v(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, pbCommenFloorItemViewHolder, nwaVar) == null) {
            boolean z = true;
            z = (nwaVar == null || !nwaVar.z0()) ? false : false;
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

    public static final void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, vv9 vv9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, pbCommenFloorItemViewHolder, nwaVar, vv9Var) == null) && nwaVar != null && vv9Var != null) {
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

    public static final void w(TextView textView, vv9 vv9Var, String str) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, textView, vv9Var, str) == null) {
            if (textView != null) {
                obj = textView.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof nwa)) {
                return;
            }
            y(textView, (nwa) obj, str, u(vv9Var));
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, int i, boolean z) {
        boolean z2;
        String str;
        boolean z3;
        zc5 a0;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, nwaVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            boolean z4 = true;
            if (nwaVar.L() > 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5e);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.is_floor)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(nwaVar.L())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z2 = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z2 = false;
            }
            String str2 = null;
            if (nwaVar.u() != null) {
                str = nwaVar.u().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z3 = true;
                    a0 = nwaVar.a0();
                    if (a0 != null) {
                        str2 = a0.b();
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    z4 = (a0 != null || StringUtils.isNull(str2) || z) ? false : false;
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
                    if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(nwaVar.r0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(nwaVar.r0()));
                    } else {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(nwaVar.r0()));
                    }
                    if (!z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setText(str);
                    } else if (z4) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(i, 0, 0, 0);
                        if (nwaVar.f0) {
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
            a0 = nwaVar.a0();
            if (a0 != null) {
            }
            if (str2 == null) {
            }
            if (a0 != null) {
            }
            if (!z2) {
            }
            if (z4) {
            }
            pbCommenFloorItemViewHolder.n.setVisibility(0);
            i3 = i;
            pbCommenFloorItemViewHolder.l.setPadding(i2, 0, i3, 0);
            if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(nwaVar.r0()), "yyyy"))) {
            }
            if (!z3) {
            }
            pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public static final void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, vv9 vv9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, pbCommenFloorItemViewHolder, nwaVar, vv9Var, i) == null) {
            d(pbCommenFloorItemViewHolder, nwaVar, i, u(vv9Var));
        }
    }

    public static final void x(TextView textView, nwa nwaVar, vv9 vv9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, null, textView, nwaVar, vv9Var, str) == null) {
            y(textView, nwaVar, str, u(vv9Var));
        }
    }

    public static final void y(TextView textView, nwa nwaVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{textView, nwaVar, str, Boolean.valueOf(z)}) == null) {
            z(textView, nwaVar, str, z, null);
        }
    }

    public static final void f(xx9 identityImageView, ThemeColorInfo imgInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, identityImageView, imgInfo) == null) {
            Intrinsics.checkNotNullParameter(identityImageView, "identityImageView");
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            String g = z5b.g(imgInfo);
            if (g.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                identityImageView.setVisibility(8);
                return;
            }
            int h = z5b.h(imgInfo);
            int i = z5b.i(imgInfo);
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

    public static final StatisticItem g(vv9 vv9Var, nwa postData) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, vv9Var, postData)) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            if (postData.g0) {
                i = 2;
            } else {
                i = 8;
            }
            return x5a.k(vv9Var, postData, postData.h0, i, 2);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static final String h(ThreadData threadData) {
        InterceptResult invokeL;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadData)) == null) {
            if (threadData == null || (l = Long.valueOf(threadData.getFid()).toString()) == null) {
                return "";
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    public static final String i(vv9 vv9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, vv9Var)) == null) {
            if (vv9Var != null) {
                str = vv9Var.o();
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

    public static final String j(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
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

    public static final String k(vv9 vv9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, vv9Var)) == null) {
            if (vv9Var != null) {
                str = vv9Var.p();
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

    public static final v2a l(hy9<?> hy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, hy9Var)) == null) {
            if (hy9Var != null) {
                return hy9Var.o1();
            }
            return null;
        }
        return (v2a) invokeL.objValue;
    }

    public static final v2a m(d6a d6aVar) {
        InterceptResult invokeL;
        AbsPbActivity u0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, d6aVar)) == null) {
            if (d6aVar != null && (u0 = d6aVar.u0()) != null) {
                return u0.c;
            }
            return null;
        }
        return (v2a) invokeL.objValue;
    }

    public static final int n(vv9 vv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, vv9Var)) == null) {
            if (vv9Var != null) {
                return vv9Var.Z();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int o(hy9<?> hy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, hy9Var)) == null) {
            if (hy9Var != null) {
                return hy9Var.z0();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final boolean p(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean q(vv9 vv9Var) {
        InterceptResult invokeL;
        ThreadData R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, vv9Var)) == null) {
            if (vv9Var != null && (R = vv9Var.R()) != null) {
                return R.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean r(hy9<?> hy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, hy9Var)) == null) {
            if (hy9Var != null) {
                return hy9Var.e1();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean s(d6a d6aVar) {
        InterceptResult invokeL;
        AbsPbActivity u0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, d6aVar)) == null) {
            if (d6aVar != null && (u0 = d6aVar.u0()) != null) {
                return u0.e1();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean t(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isUgcThreadType();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean u(vv9 vv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, vv9Var)) == null) {
            if (vv9Var != null) {
                return vv9Var.a();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void z(TextView textView, nwa nwaVar, String str, boolean z, xx9 xx9Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{textView, nwaVar, str, Boolean.valueOf(z), xx9Var}) == null) && textView != null && nwaVar != null) {
            if (xx9Var != null) {
                xx9Var.setVisibility(8);
            }
            textView.setTag(nwaVar);
            if (z) {
                nwaVar.s1(Boolean.FALSE);
                nwaVar.g1(0);
                textView.setTag(null);
            } else if (nwaVar.u() != null) {
                MetaData u = nwaVar.u();
                Intrinsics.checkNotNullExpressionValue(u, "postData.author");
                if (str != null && !Intrinsics.areEqual(str, "0") && Intrinsics.areEqual(str, u.getUserId())) {
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                    return;
                }
                boolean z3 = true;
                if (u.getIs_bawu() == 1 && nwaVar.F0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("manager", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("pri_content_assist", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("pri_manage_assist", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    nwaVar.s1(Boolean.TRUE);
                    nwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    ArrayList<TagsInfo> tags = u.getTags();
                    if (tags != null && !tags.isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        nwaVar.s1(Boolean.FALSE);
                        ThemeColorInfo info = u.getTags().get(0).img_info;
                        Intrinsics.checkNotNullExpressionValue(info, "info");
                        if (z5b.g(info).length() != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            nwaVar.g1(0);
                            if (xx9Var != null) {
                                xx9Var.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        nwaVar.g1(z5b.i(info));
                        if (xx9Var != null) {
                            f(xx9Var, info);
                            return;
                        }
                        return;
                    }
                    nwaVar.s1(Boolean.FALSE);
                    nwaVar.g1(0);
                }
            } else {
                nwaVar.s1(Boolean.FALSE);
                nwaVar.g1(0);
            }
        }
    }
}
