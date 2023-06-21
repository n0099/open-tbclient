package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a80 implements v70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection a;
    public int b;

    /* loaded from: classes4.dex */
    public class a extends InputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public InputStream a;
        public final /* synthetic */ a80 b;

        public a(a80 a80Var, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a80Var, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a80Var;
            this.a = inputStream;
        }

        public final IOException a(IOException iOException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iOException)) == null) {
                this.b.disconnect();
                if (TextUtils.isEmpty(iOException.getMessage())) {
                    return new IOException(iOException.getClass().getName(), iOException);
                }
                return iOException;
            }
            return (IOException) invokeL.objValue;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                synchronized (this) {
                    this.a.mark(i);
                }
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
                try {
                    return read(bArr, 0, bArr.length);
                } catch (IOException e) {
                    throw a(e);
                }
            }
            return invokeL.intValue;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                try {
                    return this.a.skip(j);
                } catch (IOException e) {
                    throw a(e);
                }
            }
            return invokeJ.longValue;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return this.a.available();
                } catch (IOException e) {
                    throw a(e);
                }
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    if (read() >= 0) {
                        this.a.close();
                        this.b.disconnect();
                        return;
                    }
                    this.a.close();
                } catch (IOException e) {
                    throw a(e);
                }
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.markSupported();
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                try {
                    return this.a.read();
                } catch (IOException e) {
                    throw a(e);
                }
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    try {
                        this.a.reset();
                    } catch (IOException e) {
                        throw a(e);
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i, i2)) == null) {
                try {
                    return this.a.read(bArr, i, i2);
                } catch (IOException e) {
                    throw a(e);
                }
            }
            return invokeLII.intValue;
        }
    }

    public a80(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 4;
        this.a = httpURLConnection;
    }

    @Override // com.baidu.tieba.v70
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (httpURLConnection = this.a) != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.baidu.tieba.v70
    public void disconnect() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (httpURLConnection = this.a) != null) {
            try {
                httpURLConnection.disconnect();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.v70
    public int getCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return this.a.getResponseCode();
            } catch (IOException e) {
                disconnect();
                throw e;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v70
    public Map<String, List<String>> getHeaders() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.getHeaderFields();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v70
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                InputStream inputStream = this.a.getInputStream();
                if (inputStream == null) {
                    disconnect();
                    return inputStream;
                }
                return new BufferedInputStream(new a(this, inputStream));
            } catch (IOException e) {
                disconnect();
                throw e;
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v70
    public String getMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return this.a.getResponseMessage();
            } catch (IOException e) {
                disconnect();
                throw e;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v70
    public InputStream t() throws IOException {
        InterceptResult invokeV;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getCode() >= 400) {
                inputStream = this.a.getErrorStream();
            } else {
                inputStream = null;
            }
            if (inputStream != null) {
                return new a(this, inputStream);
            }
            return inputStream;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v70
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }
}
