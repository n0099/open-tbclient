package com.baidu.tieba.forum.controller;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tieba.forum.controller.PushPermissionController$showPushPermissionDialog$1;
import com.baidu.tieba.sb5;
import com.baidu.tieba.yfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PushPermissionController$showPushPermissionDialog$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Date $currentDate;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String $fid;
    public final /* synthetic */ TbPageContext<BaseFragmentActivity> $pageContext;
    public final /* synthetic */ yfa $pushGuide;
    public final /* synthetic */ PushPermissionController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushPermissionController$showPushPermissionDialog$1(PushPermissionController pushPermissionController, TbPageContext<BaseFragmentActivity> tbPageContext, yfa yfaVar, String str, Date date) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushPermissionController, tbPageContext, yfaVar, str, date};
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
        this.this$0 = pushPermissionController;
        this.$pageContext = tbPageContext;
        this.$pushGuide = yfaVar;
        this.$fid = str;
        this.$currentDate = date;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m137invoke$lambda0(TbPageContext pageContext, yfa yfaVar, PushPermissionController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, pageContext, yfaVar, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            new yfa.b(pageContext, yfaVar).a();
            this$0.p();
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            if (this.this$0.s() != null) {
                sb5 s = this.this$0.s();
                Intrinsics.checkNotNull(s);
                s.o();
            }
            this.this$0.w(PushOpenUtil.showPushOpenView(this.$pageContext, this.$pushGuide.h(), 2000L, hashMap));
            if (this.this$0.s() != null) {
                sb5 s2 = this.this$0.s();
                Intrinsics.checkNotNull(s2);
                final TbPageContext<BaseFragmentActivity> tbPageContext = this.$pageContext;
                final yfa yfaVar = this.$pushGuide;
                final PushPermissionController pushPermissionController = this.this$0;
                s2.v(new View.OnClickListener() { // from class: com.baidu.tieba.qg7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            PushPermissionController$showPushPermissionDialog$1.m137invoke$lambda0(TbPageContext.this, yfaVar, pushPermissionController, view2);
                        }
                    }
                });
                this.$pushGuide.g();
            }
            Map<String, Date> q = this.this$0.q();
            Intrinsics.checkNotNull(q);
            q.put(this.$fid, this.$currentDate);
            TbSingleton.getInstance().setHasShowTip(this.this$0.q());
        }
    }
}
