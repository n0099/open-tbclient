package com.baidu.tieba.danmu.layout.retainer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.layout.retainer.BottomRetainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.repackage.a26;
import com.repackage.f26;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequenceScope;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$RangeHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tieba.danmu.layout.retainer.BottomRetainer$AkRetainer$layout$1$targetHolders$1", f = "BottomRetainer.kt", i = {0, 0, 0, 1, 1, 1}, l = {220, w0.k, 225}, m = "invokeSuspend", n = {"$this$sequence", "lastTop", "h", "$this$sequence", "lastTop", "h"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes3.dex */
public final class BottomRetainer$AkRetainer$layout$1$targetHolders$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super a26.b>, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ f26 $displayer;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int $margin;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public final /* synthetic */ BottomRetainer.AkRetainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomRetainer$AkRetainer$layout$1$targetHolders$1(f26 f26Var, BottomRetainer.AkRetainer akRetainer, int i, Continuation<? super BottomRetainer$AkRetainer$layout$1$targetHolders$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f26Var, akRetainer, Integer.valueOf(i), continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$displayer = f26Var;
        this.this$0 = akRetainer;
        this.$margin = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) {
            BottomRetainer$AkRetainer$layout$1$targetHolders$1 bottomRetainer$AkRetainer$layout$1$targetHolders$1 = new BottomRetainer$AkRetainer$layout$1$targetHolders$1(this.$displayer, this.this$0, this.$margin, continuation);
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$0 = obj;
            return bottomRetainer$AkRetainer$layout$1$targetHolders$1;
        }
        return (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super a26.b> sequenceScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sequenceScope, continuation)) == null) ? ((BottomRetainer$AkRetainer$layout$1$targetHolders$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00dd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00d2 -> B:25:0x00d5). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        TreeSet treeSet;
        SequenceScope sequenceScope;
        Ref.IntRef intRef;
        int i;
        BottomRetainer$AkRetainer$layout$1$targetHolders$1 bottomRetainer$AkRetainer$layout$1$targetHolders$1;
        Iterator it;
        a26.d dVar;
        a26.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, obj)) != null) {
            return invokeL.objValue;
        }
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = this.$displayer.getHeight();
            treeSet = this.this$0.b;
            int i3 = this.$margin;
            sequenceScope = (SequenceScope) this.L$0;
            intRef = intRef2;
            i = i3;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1 = this;
            it = treeSet.iterator();
            if (!it.hasNext()) {
            }
        } else if (i2 == 1) {
            i = this.I$0;
            dVar = (a26.d) this.L$3;
            it = (Iterator) this.L$2;
            intRef = (Ref.IntRef) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            bottomRetainer$AkRetainer$layout$1$targetHolders$1 = this;
            bVar = new a26.b(dVar, new IntRange(dVar.g(), dVar.a()));
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$0 = sequenceScope;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$1 = intRef;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$2 = it;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$3 = dVar;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.I$0 = i;
            bottomRetainer$AkRetainer$layout$1$targetHolders$1.label = 2;
            if (sequenceScope.yield(bVar, bottomRetainer$AkRetainer$layout$1$targetHolders$1) == coroutine_suspended) {
            }
            intRef.element = dVar.g() - i;
            if (!it.hasNext()) {
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            i = this.I$0;
            dVar = (a26.d) this.L$3;
            it = (Iterator) this.L$2;
            intRef = (Ref.IntRef) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            bottomRetainer$AkRetainer$layout$1$targetHolders$1 = this;
            intRef.element = dVar.g() - i;
            if (!it.hasNext()) {
                dVar = (a26.d) it.next();
                if (dVar.a() + i < intRef.element) {
                    a26.b bVar2 = new a26.b(null, new IntRange(dVar.a() + i, intRef.element));
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$0 = sequenceScope;
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$1 = intRef;
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$2 = it;
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$3 = dVar;
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.I$0 = i;
                    bottomRetainer$AkRetainer$layout$1$targetHolders$1.label = 1;
                    if (sequenceScope.yield(bVar2, bottomRetainer$AkRetainer$layout$1$targetHolders$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                bVar = new a26.b(dVar, new IntRange(dVar.g(), dVar.a()));
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$0 = sequenceScope;
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$1 = intRef;
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$2 = it;
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$3 = dVar;
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.I$0 = i;
                bottomRetainer$AkRetainer$layout$1$targetHolders$1.label = 2;
                if (sequenceScope.yield(bVar, bottomRetainer$AkRetainer$layout$1$targetHolders$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRef.element = dVar.g() - i;
                if (!it.hasNext()) {
                    if (intRef.element > bottomRetainer$AkRetainer$layout$1$targetHolders$1.$displayer.e() + (bottomRetainer$AkRetainer$layout$1$targetHolders$1.$displayer.getHeight() * bottomRetainer$AkRetainer$layout$1$targetHolders$1.this$0.d())) {
                        a26.b bVar3 = new a26.b(null, new IntRange((int) bottomRetainer$AkRetainer$layout$1$targetHolders$1.$displayer.e(), intRef.element));
                        bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$0 = null;
                        bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$1 = null;
                        bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$2 = null;
                        bottomRetainer$AkRetainer$layout$1$targetHolders$1.L$3 = null;
                        bottomRetainer$AkRetainer$layout$1$targetHolders$1.label = 3;
                        if (sequenceScope.yield(bVar3, bottomRetainer$AkRetainer$layout$1$targetHolders$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
