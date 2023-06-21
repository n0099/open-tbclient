package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.xn6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import tbclient.CallRobotEntrance;
import tbclient.StyleConf;
import tbclient.StyleConfExtra;
/* loaded from: classes5.dex */
public class c69 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0a a;
        public final /* synthetic */ TbPageContext b;

        public a(b0a b0aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b0aVar;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q() != null && this.a.q().getPortrait() != null && !TextUtils.isEmpty(this.a.q().getPortrait())) {
                String str2 = null;
                if (this.a.u0() != null) {
                    str2 = this.a.u0().getFigureUrl();
                    str = this.a.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                g36.a(this.b, this.a.q().getPortrait(), str2, str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626851, "Lcom/baidu/tieba/c69;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626851, "Lcom/baidu/tieba/c69;");
                return;
            }
        }
        a = new SparseIntArray();
        b = 3.88d;
    }

    public static void a(TbAlphaVideo tbAlphaVideo, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbAlphaVideo, view2) == null) && tbAlphaVideo != null && view2 != null) {
            int g = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds150);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (g * b), g);
            layoutParams.addRule(11);
            tbAlphaVideo.setLayoutParams(layoutParams);
        }
    }

    public static void b(TbRichTextView tbRichTextView, View view2, boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && tbRichTextView != null && view2 != null) {
            int l = ((((wi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                l = (l - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i2 = n(R.dimen.tbds90);
            } else {
                i2 = 0;
            }
            int i3 = l - i2;
            tbRichTextView.getLayoutStrategy().r(i3);
            tbRichTextView.getLayoutStrategy().J = i3 - n(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (l * 1.618f));
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, j49 j49Var) {
        StyleConf styleConf;
        StyleConfExtra styleConfExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pbCommenFloorItemViewHolder, j49Var) == null) {
            View view2 = pbCommenFloorItemViewHolder.n0;
            if (view2 != null) {
                view2.setVisibility(0);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(null);
            }
            pbCommenFloorItemViewHolder.c0.setAlpha(n75.b(R.string.A_X09));
            pbCommenFloorItemViewHolder.c0.setOnClickListener(null);
            TextView textView = pbCommenFloorItemViewHolder.n;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            CallRobotEntrance callRobotEntrance = j49Var.N().getCallRobotEntrance();
            if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null && (styleConfExtra = styleConf.android_extra) != null) {
                String str = styleConfExtra.bot_reply_content;
                if (!TextUtils.isEmpty(str)) {
                    pbCommenFloorItemViewHolder.n.setText(str);
                    pbCommenFloorItemViewHolder.n.setVisibility(0);
                }
            }
        }
    }

    public static void r(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, pbCommenFloorItemViewHolder, b0aVar) == null) {
            View view2 = pbCommenFloorItemViewHolder.n0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.c0.setAlpha(n75.b(R.string.A_X01));
            if (pbCommenFloorItemViewHolder.n == null) {
                return;
            }
            String u = b0aVar.u();
            if (!TextUtils.isEmpty(u)) {
                pbCommenFloorItemViewHolder.n.setVisibility(0);
                pbCommenFloorItemViewHolder.n.setText(u);
            } else {
                pbCommenFloorItemViewHolder.n.setVisibility(8);
            }
            if (b0aVar.A0()) {
                p(pbCommenFloorItemViewHolder);
            }
        }
    }

    public static void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbCommenFloorItemViewHolder, b0aVar, j49Var) == null) {
            if (b0aVar.l() != 0) {
                c(pbCommenFloorItemViewHolder, j49Var);
                p(pbCommenFloorItemViewHolder);
                return;
            }
            r(pbCommenFloorItemViewHolder, b0aVar);
        }
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, pbCommenFloorItemViewHolder, b0aVar, view2, onTouchListener) == null) {
            f(pbCommenFloorItemViewHolder, b0aVar, view2, !TextUtils.isEmpty(b0aVar.t()), onTouchListener);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{pbCommenFloorItemViewHolder, b0aVar, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(b0aVar.t()) && z) {
                fea.c(b0aVar, pbCommenFloorItemViewHolder.r);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = n(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = n(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(b0aVar.B())) {
                    pbCommenFloorItemViewHolder.t.setVisibility(0);
                    pbCommenFloorItemViewHolder.t.k(mw4.a(b0aVar.B()));
                    a(pbCommenFloorItemViewHolder.t, view2);
                } else {
                    pbCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.r.p0(b0aVar.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.t.setVisibility(8);
            }
            if (onTouchListener != null) {
                pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(onTouchListener);
            }
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
        }
    }

    public static void g(b69 b69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65543, null, b69Var, pbCommenFloorItemViewHolder, b0aVar, threadData) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            boolean z2 = true;
            if (b0aVar.I() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b09), Integer.valueOf(b0aVar.I()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            bh5 Z = b0aVar.Z();
            z2 = (Z == null || StringUtils.isNull(Z.b()) || threadData == null || threadData.isBjh()) ? false : false;
            if (z) {
                pbCommenFloorItemViewHolder.l.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.l.setVisibility(8);
            }
            if (z2) {
                pbCommenFloorItemViewHolder.m.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.m.setVisibility(8);
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b0aVar.p0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(b0aVar.p0()));
            } else {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(b0aVar.p0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.o.setText(Z.b());
                return;
            }
            pbCommenFloorItemViewHolder.o.setVisibility(8);
        }
    }

    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, b0aVar, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null && b0aVar.o() != null) {
            if (threadData != null) {
                b0aVar.o().threadId = threadData.getTid();
                b0aVar.o().forumId = String.valueOf(threadData.getFid());
            }
            if (i == 0) {
                b0aVar.o().objType = 1;
            } else {
                b0aVar.o().objType = 2;
            }
            b0aVar.o().isInPost = true;
            pbCommenFloorItemViewHolder.p.F(z);
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setData(b0aVar.o());
        }
    }

    public static void i(b69 b69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{b69Var, pbCommenFloorItemViewHolder, b0aVar, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tVar}) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            Activity pageActivity = b69Var.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = wi.g(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = wi.g(pageActivity, R.dimen.tbds148);
            boolean z4 = false;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            if (!TextUtils.isEmpty(b0aVar.t()) && z) {
                z4 = true;
            }
            fea.b(b0aVar, pbCommenFloorItemViewHolder.r, z4);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            b(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(b0aVar.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.r.setText(b0aVar.e0(), true, tVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, b0aVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
        }
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
    /* JADX WARN: Removed duplicated region for block: B:87:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(b69 b69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{b69Var, pbCommenFloorItemViewHolder, b0aVar, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, b0aVar);
            sparseArray.put(R.id.tag_load_sub_data, b0aVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_forbid_user_post_id, b0aVar.S());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            boolean z9 = true;
            if (b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (b69Var.c0() != 0 && !q(threadData)) {
                if (b69Var.c0() != 1002 && b69Var.c0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (b69Var.c0() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (b0aVar.q() != null) {
                    String userId = b0aVar.q().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z3 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z3 = false;
                    }
                }
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
            }
            if (threadData != null && threadData.getAuthor() != null && b0aVar.q() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = b0aVar.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z4 = true;
                        z6 = false;
                        z7 = true;
                    } else {
                        z4 = true;
                        z6 = true;
                        z7 = false;
                    }
                    z8 = true;
                    if (b0aVar.q() != null && UtilHelper.isCurrentAccount(b0aVar.q().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (b0aVar.I() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(b69Var.c0()));
                        if (b0aVar.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, b0aVar.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, b0aVar.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, b0aVar.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (b0aVar.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, b0aVar.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, b0aVar.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, b0aVar.q().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, b0aVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(b0aVar.z0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(b69Var.c0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, b0aVar.S());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                    if (pbCommenFloorItemViewHolder.Z == 0) {
                        z9 = false;
                    }
                    sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
                    pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    if (!z) {
                        pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
                        return;
                    } else {
                        pbCommenFloorItemViewHolder.o0.setTag(null);
                        return;
                    }
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (b0aVar.q() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (b0aVar.I() != 1) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
            if (pbCommenFloorItemViewHolder.Z == 0) {
            }
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            if (!z) {
            }
        }
    }

    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, b0a b0aVar, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{pbCommenFloorItemViewHolder, view2, b0aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(4);
                if (!z2 && !b0aVar.i0) {
                    pbCommenFloorItemViewHolder.v.setVisibility(8);
                }
                if (b0aVar.i0) {
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
                    pbCommenFloorItemViewHolder.v.setVisibility(0);
                }
                b0aVar.f1(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_load_sub_data, b0aVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setAlpha(0.5f);
            if (b0aVar.i0) {
                pbCommenFloorItemViewHolder.m0.setOnClickListener(null);
            }
            if (b0aVar != null) {
                View view3 = pbCommenFloorItemViewHolder.m0;
                if (!b0aVar.C0() && !b0aVar.i0) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.k0;
                boolean C0 = b0aVar.C0();
                int i4 = R.color.CAM_X0304;
                if (C0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.l0;
                if (b0aVar.C0()) {
                    i3 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i3 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!b0aVar.C0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, pbCommenFloorItemViewHolder, b0aVar) == null) {
            if (b0aVar != null && b0aVar.q() != null && b0aVar.l0() != null) {
                TbRichText e0 = b0aVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(b0aVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (b0aVar.q().getSmallTailThemeData() != null) {
                    str = b0aVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                uc9.c(b0aVar.l0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, b0aVar.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, int i, b69 b69Var, ThreadData threadData, boolean z) {
        String str;
        String str2;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbCommenFloorItemViewHolder, b0aVar, view2, Integer.valueOf(i), b69Var, threadData, Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            boolean z9 = false;
            if (b0aVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            if (threadData != null && threadData.getAuthor() != null) {
                str = threadData.getAuthor().getUserId();
            } else {
                str = null;
            }
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            if (b0aVar.q() != null) {
                if (str != null && !str.equals("0") && str.equals(b0aVar.q().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = b0aVar.q().getIconInfo();
                ArrayList<IconData> tShowInfoNew = b0aVar.q().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, b0aVar.q().getUserId());
                    pbCommenFloorItemViewHolder.H.setOnClickListener(b69Var.I0().c);
                    int g = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g2 = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.H;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, g, g, g2);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.G.setOnClickListener(b69Var.I0().e);
                    int g3 = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !b0aVar.q().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = b0aVar.q().getAvater();
                pbCommenFloorItemViewHolder.g.setTag(i4, b0aVar.q().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, b0aVar.q().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, b0aVar.q().getVirtualUserUrl());
                String name_show = b0aVar.q().getName_show();
                String userName = b0aVar.q().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(k39.b(b69Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, k39.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (b0aVar.q().getPendantData() != null && !StringUtils.isNull(b0aVar.q().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(b0aVar.q());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().N(avater, 28, false);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(b0aVar.q().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(b0aVar.q().getUserName());
                    pbCommenFloorItemViewHolder.F.i(b0aVar.q());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, b0aVar.q(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(b0aVar.q().getUserId());
                    pbCommenFloorItemViewHolder.q.setUserName(b0aVar.q().getUserName(), b0aVar.s0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, b0aVar.q().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.q.N(avater, 28, false);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                t(pbCommenFloorItemViewHolder.i, b0aVar, str, threadData);
            }
            String str3 = "";
            if (!b69Var.z0() || b0aVar.q() == null) {
                str2 = "";
                i2 = 0;
            } else {
                i2 = b0aVar.q().getLevel_id();
                str2 = b0aVar.q().getLevelName();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i2, str2);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.H.getChildCount() != 1) {
                pbCommenFloorItemViewHolder.H.getChildCount();
            }
            pbCommenFloorItemViewHolder.i.getVisibility();
            pbCommenFloorItemViewHolder.G.getChildCount();
            int l = q89.l();
            if (b0aVar.q() != null) {
                str3 = b0aVar.q().getName_show();
            }
            int e = ux5.e(str3);
            if (b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getSealPrefix())) {
                int i5 = l - 2;
                if (e > i5) {
                    str3 = ux5.m(str3, i5) + "...";
                }
            } else if (e > l) {
                str3 = ux5.m(str3, l) + "...";
            }
            if (b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(o(b69Var, b0aVar.q().getSealPrefix(), str3));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str3);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, b0aVar);
            sparseArray.put(R.id.tag_load_sub_data, b0aVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(b0aVar.I()));
            sparseArray.put(R.id.tag_forbid_user_post_id, b0aVar.S());
            if (b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (threadData != null && b69Var.c0() != 0 && !q(threadData)) {
                if (b69Var.c0() != 1002 && b69Var.c0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (b69Var.c0() != 3 && !threadData.isBjh()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (b0aVar != null && b0aVar.q() != null) {
                    String userId = b0aVar.q().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z3 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z3 = false;
                    }
                }
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
            }
            if (threadData != null && threadData.getAuthor() != null && b0aVar.q() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = b0aVar.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z6 = false;
                        z4 = true;
                        z7 = true;
                    } else {
                        z6 = true;
                        z4 = true;
                        z7 = false;
                    }
                    z8 = true;
                    if (b0aVar != null && b0aVar.q() != null && UtilHelper.isCurrentAccount(b0aVar.q().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z6 = false;
                        z4 = false;
                    }
                    if (b0aVar.I() != 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (threadData != null && threadData.isUgcThreadType()) {
                        z3 = false;
                        z6 = false;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(b69Var.c0()));
                        if (b0aVar.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, b0aVar.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, b0aVar.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, b0aVar.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (b0aVar.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, b0aVar.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, b0aVar.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, b0aVar.q().getName_show());
                        }
                        sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        sparseArray.put(R.id.tag_user_mute_post_id, b0aVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4 && threadData != null) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(b69Var.c0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, b0aVar.S());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z || b0aVar.z0()) ? true : true));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                    pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (b0aVar != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (b0aVar.I() != 1) {
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
            sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
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

    public static void p(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, pbCommenFloorItemViewHolder) == null) && (tbImageView = pbCommenFloorItemViewHolder.j) != null && pbCommenFloorItemViewHolder.i != null && pbCommenFloorItemViewHolder.E != null) {
            tbImageView.setVisibility(8);
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
    }

    public static boolean q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static SpannableStringBuilder o(b69 b69Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, b69Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new xn6.a(str, R.drawable.pic_smalldot_title));
                return xn6.h(b69Var.getPageContext().getPageActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static void u(TbPageContext<?> tbPageContext, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65557, null, tbPageContext, pbCommenFloorItemViewHolder, b0aVar) == null) && b0aVar != null && WorldCupEnableSwitch.isOn()) {
            pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            pbCommenFloorItemViewHolder.C0.setImageResource(R.drawable.obfuscated_res_0x7f0809ff);
            pbCommenFloorItemViewHolder.C0.setOnClickListener(new a(b0aVar, tbPageContext));
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.D0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(b0aVar.q());
            }
        }
    }

    public static void s(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.u.b();
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(TbadkCoreApplication.getInst().getSkinType());
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b83, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080b84, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.N.setVisibility(8);
            pbCommenFloorItemViewHolder.U.setVisibility(8);
            pbCommenFloorItemViewHolder.r.setFestivalTipViewSkin();
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void t(TextView textView, b0a b0aVar, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, textView, b0aVar, str, threadData) == null) {
            if (textView == null && b0aVar == null) {
                return;
            }
            textView.setTag(b0aVar);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (b0aVar.q() != null) {
                MetaData q = b0aVar.q();
                if (str != null && !str.equals("0") && str.equals(q.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    p75 d = p75.d(textView);
                    d.o(R.string.J_X04);
                    d.m(R.dimen.L_X01);
                    d.x(R.color.CAM_X0302);
                    d.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && b0aVar.B0()) {
                    p75 d2 = p75.d(textView);
                    d2.x(R.color.CAM_X0101);
                    d2.o(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    p75 d3 = p75.d(textView);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    p75 d4 = p75.d(textView);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    p75 d5 = p75.d(textView);
                    d5.x(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    p75 d6 = p75.d(textView);
                    d6.x(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
