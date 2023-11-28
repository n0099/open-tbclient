package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.c05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes6.dex */
public final class fl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bdUniqueId) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921465);
            if (bdUniqueId != null) {
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2921465, bdUniqueId));
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public static final void b(String forumId, String threadId, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, forumId, threadId, bdUniqueId) == null) {
            Intrinsics.checkNotNullParameter(forumId, "forumId");
            Intrinsics.checkNotNullParameter(threadId, "threadId");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
            httpMessage.addParam("forum_id", forumId);
            httpMessage.addParam("thread_id", threadId);
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static final void c(ImageView imageView, boolean z) {
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, imageView, z) == null) {
            if (z) {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(maskDrawable);
        }
    }

    public static final void d(final TbPageContext<?> context, final String forumId, final String threadId, m57 bawuThrones, final Function3<? super String, ? super String, ? super BdUniqueId, Unit> onConfirm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, forumId, threadId, bawuThrones, onConfirm) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(forumId, "forumId");
            Intrinsics.checkNotNullParameter(threadId, "threadId");
            Intrinsics.checkNotNullParameter(bawuThrones, "bawuThrones");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            final c05 c05Var = new c05(context.getPageActivity());
            c05Var.setContentViewSize(1);
            c05Var.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(context.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context.pageActivit…ans_dialog_content, null)");
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092683);
            textView.setText(R.string.frs_recommend_thread_sure_title);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            TextView textView2 = (TextView) inflate.findViewById(R.id.call_fans_intro);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.frs_recommend_thread_sure_content);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…mend_thread_sure_content)");
            String format = String.format(string, Arrays.copyOf(new Object[]{bawuThrones.a(), Integer.valueOf(bawuThrones.b()), Integer.valueOf(bawuThrones.b() - bawuThrones.c())}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView2.setText(format);
            final ImageView noTipAgainCheckBox = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090731);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.no_tip_again_text), (int) R.color.CAM_X0107);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Intrinsics.checkNotNullExpressionValue(noTipAgainCheckBox, "noTipAgainCheckBox");
            c(noTipAgainCheckBox, booleanRef.element);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.cl7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        fl7.e(Ref.BooleanRef.this, noTipAgainCheckBox, view2);
                    }
                }
            });
            c05Var.setContentView(inflate);
            c05Var.setPositiveButton(context.getString(R.string.frs_recommend_thread_confirm), new c05.e() { // from class: com.baidu.tieba.zk7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c05.e
                public final void onClick(c05 c05Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c05Var2) == null) {
                        fl7.f(Ref.BooleanRef.this, onConfirm, forumId, threadId, context, c05Var, c05Var2);
                    }
                }
            });
            c05Var.setNegativeButton(context.getString(R.string.next_time), new c05.e() { // from class: com.baidu.tieba.al7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c05.e
                public final void onClick(c05 c05Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c05Var2) == null) {
                        fl7.g(Ref.BooleanRef.this, c05Var, c05Var2);
                    }
                }
            });
            c05Var.create(context).show();
        }
    }

    public static final void e(Ref.BooleanRef isChecked, ImageView noTipAgainCheckBox, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, isChecked, noTipAgainCheckBox, view2) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            isChecked.element = !isChecked.element;
            Intrinsics.checkNotNullExpressionValue(noTipAgainCheckBox, "noTipAgainCheckBox");
            c(noTipAgainCheckBox, isChecked.element);
        }
    }

    public static final void g(Ref.BooleanRef isChecked, c05 alertDialog, c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, isChecked, alertDialog, c05Var) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            isChecked.element = false;
            alertDialog.dismiss();
        }
    }

    public static final void f(Ref.BooleanRef isChecked, Function3 onConfirm, String forumId, String threadId, TbPageContext context, c05 alertDialog, c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{isChecked, onConfirm, forumId, threadId, context, alertDialog, c05Var}) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
            Intrinsics.checkNotNullParameter(forumId, "$forumId");
            Intrinsics.checkNotNullParameter(threadId, "$threadId");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            SharedPrefHelper.getInstance().putBoolean("key_frs_recommend_tip", !isChecked.element);
            onConfirm.invoke(forumId, threadId, context.getUniqueId());
            alertDialog.dismiss();
        }
    }
}
