package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public class fpc<T> implements doc.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final eoc<? super T> a;
    public final doc<T> b;

    /* loaded from: classes6.dex */
    public static final class a<T> extends joc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final joc<? super T> e;
        public final eoc<? super T> f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(joc<? super T> jocVar, eoc<? super T> eocVar) {
            super(jocVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jocVar, eocVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((joc) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jocVar;
            this.f = eocVar;
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.g) {
                return;
            }
            try {
                this.f.onCompleted();
                this.g = true;
                this.e.onCompleted();
            } catch (Throwable th) {
                poc.f(th, this);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g) {
                    tsc.j(th);
                    return;
                }
                this.g = true;
                try {
                    this.f.onError(th);
                    this.e.onError(th);
                } catch (Throwable th2) {
                    poc.e(th2);
                    this.e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) != null) || this.g) {
                return;
            }
            try {
                this.f.onNext(t);
                this.e.onNext(t);
            } catch (Throwable th) {
                poc.g(th, this, t);
            }
        }
    }

    public fpc(doc<T> docVar, eoc<? super T> eocVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {docVar, eocVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = docVar;
        this.a = eocVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(joc<? super T> jocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jocVar) == null) {
            this.b.O(new a(jocVar, this.a));
        }
    }
}
