package com.baidu.tieba.forum.management;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.b77;
import com.baidu.tieba.forum.management.ThreadManageDialog$showGoodClassListDialog$1;
import com.baidu.tieba.jq5;
import com.baidu.tieba.wx4;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "goodDataList", "Ljava/util/ArrayList;", "Lcom/baidu/tbadk/core/data/GoodData;", "Lkotlin/collections/ArrayList;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ThreadManageDialog$showGoodClassListDialog$1 extends Lambda implements Function1<ArrayList<wx4>, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ThreadManageDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadManageDialog$showGoodClassListDialog$1(ThreadManageDialog threadManageDialog) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadManageDialog};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = threadManageDialog;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m138invoke$lambda0(Dialog mGoodClassListDialog, ThreadManageDialog this$0, View view2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, mGoodClassListDialog, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(mGoodClassListDialog, "$mGoodClassListDialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            tbPageContext = this$0.l;
            yb.b(mGoodClassListDialog, tbPageContext);
        }
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m139invoke$lambda1(Dialog mGoodClassListDialog, ThreadManageDialog this$0, View view2) {
        TbPageContext tbPageContext;
        b77 b77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, mGoodClassListDialog, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(mGoodClassListDialog, "$mGoodClassListDialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            tbPageContext = this$0.l;
            yb.b(mGoodClassListDialog, tbPageContext);
            b77Var = this$0.s;
            this$0.W(b77Var, this$0.r, false);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<wx4> arrayList) {
        invoke2(arrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ArrayList<wx4> arrayList) {
        TbPageContext tbPageContext;
        String N;
        BlueCheckRadioButton K;
        ArrayList arrayList2;
        ArrayList arrayList3;
        TbPageContext tbPageContext2;
        b77 b77Var;
        BlueCheckRadioButton K2;
        ArrayList arrayList4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            WindowManager.LayoutParams layoutParams = null;
            View inflate = LayoutInflater.from(this.this$0.n).inflate(R.layout.commit_good, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R.layout.commit_good, null)");
            final Dialog dialog = new Dialog(this.this$0.n, R.style.obfuscated_res_0x7f1003c6);
            boolean z = true;
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            Window window = dialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            }
            if (layoutParams != null) {
                layoutParams.width = BdUtilHelper.getDimens(this.this$0.n, R.dimen.obfuscated_res_0x7f0703f6);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
            View findViewById = inflate.findViewById(R.id.dialog_button_cancel);
            final ThreadManageDialog threadManageDialog = this.this$0;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xk7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ThreadManageDialog$showGoodClassListDialog$1.m138invoke$lambda0(dialog, threadManageDialog, view2);
                    }
                }
            });
            View findViewById2 = inflate.findViewById(R.id.dialog_button_ok);
            final ThreadManageDialog threadManageDialog2 = this.this$0;
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bl7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ThreadManageDialog$showGoodClassListDialog$1.m139invoke$lambda1(dialog, threadManageDialog2, view2);
                    }
                }
            });
            View findViewById3 = dialog.findViewById(R.id.commit_good_layout);
            tbPageContext = this.this$0.l;
            jq5.a(tbPageContext, findViewById3);
            View findViewById4 = dialog.findViewById(R.id.good_class_group);
            if (findViewById4 != null) {
                LinearLayout linearLayout = (LinearLayout) findViewById4;
                linearLayout.removeAllViews();
                this.this$0.t = new ArrayList();
                ThreadManageDialog threadManageDialog3 = this.this$0;
                N = threadManageDialog3.N(R.string.thread_good_class, new Object[0]);
                K = threadManageDialog3.K("0", N);
                K.setChecked(true);
                linearLayout.addView(K);
                arrayList2 = this.this$0.t;
                if (arrayList2 != null) {
                    arrayList2.add(K);
                }
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        wx4 wx4Var = arrayList.get(i);
                        Intrinsics.checkNotNullExpressionValue(wx4Var, "goodDataList[i]");
                        wx4 wx4Var2 = wx4Var;
                        if (!TextUtils.isEmpty(wx4Var2.b()) && wx4Var2.a() > 0) {
                            K2 = this.this$0.K(String.valueOf(wx4Var2.a()), wx4Var2.b());
                            arrayList4 = this.this$0.t;
                            if (arrayList4 != null) {
                                arrayList4.add(K2);
                            }
                            View view2 = new View(this.this$0.n);
                            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.this$0.n, R.dimen.obfuscated_res_0x7f070198)));
                            linearLayout.addView(view2);
                            linearLayout.addView(K2);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        }
                    }
                    View findViewById5 = dialog.findViewById(R.id.good_scroll);
                    if (findViewById5 != null) {
                        ScrollView scrollView = (ScrollView) findViewById5;
                        ViewGroup.LayoutParams layoutParams2 = scrollView.getLayoutParams();
                        int size2 = arrayList.size();
                        if (size2 != 0 && size2 != 1) {
                            if (size2 != 2) {
                                layoutParams2.height = BdUtilHelper.dip2px(this.this$0.n, 220.0f);
                            } else {
                                layoutParams2.height = BdUtilHelper.dip2px(this.this$0.n, 186.0f);
                            }
                        } else {
                            layoutParams2.height = BdUtilHelper.dip2px(this.this$0.n, 120.0f);
                        }
                        scrollView.setLayoutParams(layoutParams2);
                        scrollView.removeAllViews();
                        scrollView.addView(linearLayout);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
                    }
                }
                arrayList3 = this.this$0.t;
                if ((arrayList3 == null || arrayList3.size() != 1) ? false : false) {
                    this.this$0.r = "0";
                    ThreadManageDialog threadManageDialog4 = this.this$0;
                    b77Var = threadManageDialog4.s;
                    threadManageDialog4.W(b77Var, this.this$0.r, false);
                    return;
                }
                tbPageContext2 = this.this$0.l;
                yb.j(dialog, tbPageContext2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
    }
}
