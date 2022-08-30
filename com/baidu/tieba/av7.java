package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.uz5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class av7 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                sx7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.h, pbCommenFloorItemViewHolder.H, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.J);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947628711, "Lcom/baidu/tieba/av7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947628711, "Lcom/baidu/tieba/av7;");
                return;
            }
        }
        new SparseArray();
        a = new SparseIntArray();
        k(R.dimen.tbds16);
    }

    public static void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, null, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k = (((ri.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int k2 = k - (z ? k(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(k2);
        tbRichTextView.getLayoutStrategy().H = k2 - k(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, pbCommenFloorItemViewHolder, postData, z) == null) {
            if (!TextUtils.isEmpty(postData.t()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams.topMargin = k(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = k(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.p.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.p.k0(null);
            }
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = pbCommenFloorItemViewHolder.w) == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.E.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe1));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(zu7 zu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zu7Var, pbCommenFloorItemViewHolder, postData, threadData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.B() > 0 && threadData != null && !threadData.isBjh()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0981), Integer.valueOf(postData.B()));
            pbCommenFloorItemViewHolder.G.setVisibility(0);
            pbCommenFloorItemViewHolder.G.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.G.setVisibility(8);
            z = false;
        }
        p15 R = postData.R();
        z2 = (R == null || StringUtils.isNull(R.b()) || threadData == null || threadData.isBjh()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.k.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.k.setVisibility(8);
        }
        if (z2) {
            pbCommenFloorItemViewHolder.l.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.l.setVisibility(8);
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
            pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.e0()));
        } else {
            pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.e0()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            pbCommenFloorItemViewHolder.m.setText(R.b());
            return;
        }
        pbCommenFloorItemViewHolder.m.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbCommenFloorItemViewHolder, postData, threadData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (threadData != null) {
            postData.q().threadId = threadData.getTid();
            postData.q().forumId = String.valueOf(threadData.getFid());
        }
        if (i == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z2) {
            pbCommenFloorItemViewHolder.n.A(true);
        } else {
            pbCommenFloorItemViewHolder.n.A(false);
        }
        if (z) {
            pbCommenFloorItemViewHolder.F.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.F.setData(postData.q());
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setData(postData.q());
    }

    public static void f(zu7 zu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{zu7Var, pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = zu7Var.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ri.f(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = ri.f(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081211);
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        a(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.p.setText(postData.V(), true, sVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092003, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ffd, sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(zu7 zu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{zu7Var, pbCommenFloorItemViewHolder, postData, view2, threadData, Boolean.valueOf(z)}) != null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092007, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092009, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091ffa, postData.K());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ba, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b8, pbCommenFloorItemViewHolder.v);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b9, pbCommenFloorItemViewHolder.w);
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (zu7Var.T() == 0 || m(threadData)) {
            z2 = false;
            z3 = false;
            z4 = false;
        } else {
            z2 = (zu7Var.T() == 1002 || zu7Var.T() == 3) ? false : true;
            if (zu7Var.T() == 3 || threadData.isUgcThreadType()) {
                z3 = false;
                z4 = false;
            } else {
                z3 = true;
                z4 = true;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z2 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z2 = false;
                }
            }
        }
        if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
            String userId2 = threadData.getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z3 = true;
                    z5 = false;
                    z6 = true;
                } else {
                    z3 = true;
                    z5 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z3 = true;
                    z6 = true;
                }
                if (z8) {
                    z2 = false;
                    z3 = false;
                    z5 = false;
                }
                int i = postData.B() != 1 ? 0 : 1;
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(zu7Var.T()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff9, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092001, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092042, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092043, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092041, postData.s().getName_show());
                    }
                    if (threadData != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092045, threadData.getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.valueOf(postData.n0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(zu7Var.T()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fec, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z4));
                sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z7));
                sparseArray.put(R.id.obfuscated_res_0x7f092003, Boolean.valueOf(pbCommenFloorItemViewHolder.Z != 0));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                if (!z) {
                    pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.n0.setTag(null);
                    return;
                }
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData.s() != null) {
            z3 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.B() != 1) {
        }
        if (!z2) {
        }
        if (!z5) {
        }
        if (!z3) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z4));
        sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z7));
        sparseArray.put(R.id.obfuscated_res_0x7f092003, Boolean.valueOf(pbCommenFloorItemViewHolder.Z != 0));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        if (!z) {
        }
    }

    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, view2, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(4);
                if (!z2 && !postData.f0) {
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                }
                if (postData.f0) {
                    pbCommenFloorItemViewHolder.i0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.i0.bringToFront();
                    pbCommenFloorItemViewHolder.i0.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.j0.setVisibility(8);
                pbCommenFloorItemViewHolder.i0.setVisibility(8);
                pbCommenFloorItemViewHolder.m0.setVisibility(8);
                if (z2) {
                    pbCommenFloorItemViewHolder.c0.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.r.setVisibility(0);
                }
                postData.P0(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092007, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f092009, view2);
            pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setAlpha(0.5f);
            if (postData.f0) {
                pbCommenFloorItemViewHolder.m0.setOnClickListener(null);
            }
            if (postData != null) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.m0, (postData.p0() || postData.f0) ? R.color.CAM_X0201 : R.color.transparent);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.k0;
                boolean p0 = postData.p0();
                int i = R.color.CAM_X0304;
                SkinManager.setViewTextColor(eMTextView, p0 ? R.color.CAM_X0304 : R.color.CAM_X0107);
                ImageView imageView = pbCommenFloorItemViewHolder.l0;
                int i2 = postData.p0() ? R.drawable.obfuscated_res_0x7f080966 : R.drawable.obfuscated_res_0x7f080965;
                if (!postData.p0()) {
                    i = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i2, i, null);
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.b0() != null) {
                TbRichText V = postData.V();
                c28.c(postData.b0(), pbCommenFloorItemViewHolder.N, false, false, V != null && StringUtils.isNull(V.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i, zu7 zu7Var, ThreadData threadData, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Integer.valueOf(i), zu7Var, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        boolean z9 = false;
        if (postData.P) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        String userId = (threadData == null || threadData.getAuthor() == null) ? null : threadData.getAuthor().getUserId();
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.I.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.K;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f09203f, postData.s().getUserId());
                pbCommenFloorItemViewHolder.K.setOnClickListener(zu7Var.z0().c);
                int f = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.K;
                i2 = R.id.obfuscated_res_0x7f09203f;
                userIconBox2.g(iconInfo, 2, f, f, f2);
            } else {
                i2 = R.id.obfuscated_res_0x7f09203f;
            }
            if (pbCommenFloorItemViewHolder.J != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.J.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.J.setOnClickListener(zu7Var.z0().e);
                int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.J.h(tShowInfoNew, 3, f3, f3, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        sx7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        os4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            pbCommenFloorItemViewHolder.f.setTag(i2, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092049, postData.s().getVirtualUserUrl());
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(ns7.b(zu7Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092014, ns7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.I.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.I.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.I.setVisibility(0);
                pbCommenFloorItemViewHolder.I.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.I.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.I.getHeadView().setUserName(postData.s().getUserName());
                pbCommenFloorItemViewHolder.I.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.g0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092049, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.I.setVisibility(8);
            }
            o(pbCommenFloorItemViewHolder.h, postData, userId, threadData);
        }
        int level_id = (!zu7Var.u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        if (threadData != null && threadData.isUgcThreadType()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.H.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.H, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.H.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.K.getChildCount() != 1) {
            pbCommenFloorItemViewHolder.K.getChildCount();
        }
        pbCommenFloorItemViewHolder.h.getVisibility();
        pbCommenFloorItemViewHolder.J.getChildCount();
        int e = sx7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d = pf5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i3 = e - 2;
            if (d > i3) {
                name_show2 = pf5.n(name_show2, i3) + StringHelper.STRING_MORE;
            }
        } else if (d > e) {
            name_show2 = pf5.n(name_show2, e) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(l(zu7Var, postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new a(pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092007, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092009, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092018, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f092017, Integer.valueOf(postData.B()));
        sparseArray.put(R.id.obfuscated_res_0x7f091ffa, postData.K());
        boolean z10 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (threadData == null || zu7Var.T() == 0 || m(threadData)) {
            z3 = false;
            z4 = false;
            z5 = false;
        } else {
            z3 = (zu7Var.T() == 1002 || zu7Var.T() == 3) ? false : true;
            if (zu7Var.T() == 3 || threadData.isBjh()) {
                z4 = false;
                z5 = false;
            } else {
                z4 = true;
                z5 = true;
            }
            if (postData != null && postData.s() != null) {
                String userId2 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
            String userId3 = threadData.getAuthor().getUserId();
            String userId4 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z6 = false;
                    z4 = true;
                    z7 = true;
                } else {
                    z6 = true;
                    z4 = true;
                    z7 = false;
                }
                z8 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z7 = true;
                }
                if (z10) {
                    z3 = false;
                    z6 = false;
                    z4 = false;
                }
                int i4 = postData.B() != 1 ? 0 : 1;
                if (threadData != null && threadData.isUgcThreadType()) {
                    z3 = false;
                    z6 = false;
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(zu7Var.T()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff9, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092001, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092042, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092043, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092041, postData.s().getName_show());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092045, threadData.getId());
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                }
                if (!z4 && threadData != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(zu7Var.T()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z7));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fec, postData.K());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.valueOf((z2 || postData.n0()) ? true : true));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z5));
                sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z8));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                if (z) {
                    return;
                }
                pbCommenFloorItemViewHolder.L.setTag(sparseArray);
                return;
            }
        }
        z6 = false;
        z7 = false;
        z8 = false;
        if (postData != null) {
            z4 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (postData.B() != 1) {
        }
        if (threadData != null) {
            z3 = false;
            z6 = false;
        }
        if (!z3) {
        }
        if (!z6) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z5));
        sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z8));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        if (z) {
        }
    }

    public static int k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            int i2 = a.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            a.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public static SpannableStringBuilder l(zu7 zu7Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, zu7Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new uz5.a(str, R.drawable.pic_smalldot_title));
            return uz5.h(zu7Var.getPageContext().getPageActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static boolean m(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static void n(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mt7 mt7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65550, null, pbCommenFloorItemViewHolder, mt7Var, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    sx7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    os4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.G, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.q.b();
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.L, R.drawable.obfuscated_res_0x7f0805ee, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.D, R.drawable.obfuscated_res_0x7f08098c, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.B, R.drawable.obfuscated_res_0x7f08098d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.E, (int) R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.v, R.drawable.obfuscated_res_0x7f08098c, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.w, R.drawable.obfuscated_res_0x7f08098d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (mt7Var != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.t, (int) R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.u, (int) R.color.CAM_X0108);
                SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.s, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                pbCommenFloorItemViewHolder.s.d();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.R, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.S, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, (int) R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.T.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.t.setVisibility(8);
                    pbCommenFloorItemViewHolder.u.setVisibility(8);
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f03f7);
                } else if (StringUtils.isNull(mt7Var.k())) {
                    pbCommenFloorItemViewHolder.V.setText(mt7Var.k());
                } else {
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f05d9);
                }
            } else {
                pbCommenFloorItemViewHolder.s.setVisibility(8);
                pbCommenFloorItemViewHolder.t.setVisibility(8);
                pbCommenFloorItemViewHolder.u.setVisibility(8);
                pbCommenFloorItemViewHolder.O.setVisibility(8);
                pbCommenFloorItemViewHolder.V.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void o(TextView textView, PostData postData, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, textView, postData, str, threadData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                if (str != null && !str.equals("0") && str.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f086a);
                    textView.setBackgroundColor(0);
                    os4 d = os4.d(textView);
                    d.n(R.string.J_X04);
                    d.l(R.dimen.L_X01);
                    d.v(R.color.CAM_X0302);
                    d.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.o0()) {
                    os4 d2 = os4.d(textView);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0342);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    os4 d3 = os4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fb);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    os4 d4 = os4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    os4 d5 = os4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f8);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    os4 d6 = os4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f9);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
