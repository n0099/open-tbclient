package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes3.dex */
public class cz2 extends ResponseBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ResponseBody a;
    public final zy2 b;
    public BufferedSource c;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ cz2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cz2 cz2Var, Source source) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz2Var, source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Source) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cz2Var;
            this.a = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, buffer, j)) == null) {
                long read = super.read(buffer, j);
                long j3 = this.a;
                int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
                if (i != 0) {
                    j2 = read;
                } else {
                    j2 = 0;
                }
                this.a = j3 + j2;
                zy2 zy2Var = this.b.b;
                long j4 = this.a;
                long contentLength = this.b.a.contentLength();
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                zy2Var.a(j4, contentLength, z);
                return read;
            }
            return invokeLJ.longValue;
        }
    }

    public cz2(ResponseBody responseBody, zy2 zy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {responseBody, zy2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = responseBody;
        this.b = zy2Var;
    }

    public final Source c(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, source)) == null) {
            return new a(this, source);
        }
        return (Source) invokeL.objValue;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.contentLength();
        }
        return invokeV.longValue;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.contentType();
        }
        return (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == null) {
                this.c = Okio.buffer(c(this.a.source()));
            }
            return this.c;
        }
        return (BufferedSource) invokeV.objValue;
    }
}
