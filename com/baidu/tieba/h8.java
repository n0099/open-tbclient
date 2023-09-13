package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UShort;
/* loaded from: classes6.dex */
public class h8 implements w6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public h8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    @Override // com.baidu.tieba.w6
    public JsonValue a(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d3Var)) == null) {
            try {
                return d(d3Var.l(8192));
            } catch (Exception e) {
                throw new SerializationException("Error parsing file: " + d3Var, e);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue d(InputStream inputStream) {
        InterceptResult invokeL;
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) {
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(inputStream);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                JsonValue b = b(dataInputStream);
                c8.a(dataInputStream);
                return b;
            } catch (IOException e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                throw new SerializationException(e);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                c8.a(dataInputStream2);
                throw th;
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue b(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataInputStream)) == null) {
            try {
                return c(dataInputStream, dataInputStream.readByte());
            } finally {
                c8.a(dataInputStream);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public short m(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dataInputStream)) == null) {
            return (short) (dataInputStream.readByte() & 255);
        }
        return invokeL.shortValue;
    }

    public long n(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dataInputStream)) == null) {
            return dataInputStream.readInt() & (-1);
        }
        return invokeL.longValue;
    }

    public int o(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dataInputStream)) == null) {
            return dataInputStream.readShort() & UShort.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public JsonValue c(DataInputStream dataInputStream, byte b) throws IOException {
        InterceptResult invokeCommon;
        int readShort;
        short readByte;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dataInputStream, Byte.valueOf(b)})) == null) {
            if (b == 91) {
                return e(dataInputStream);
            }
            if (b == 123) {
                return g(dataInputStream);
            }
            if (b == 90) {
                return new JsonValue(JsonValue.ValueType.nullValue);
            }
            if (b == 84) {
                return new JsonValue(true);
            }
            if (b == 70) {
                return new JsonValue(false);
            }
            if (b == 66) {
                return new JsonValue(m(dataInputStream));
            }
            if (b == 85) {
                return new JsonValue(m(dataInputStream));
            }
            if (b == 105) {
                if (this.a) {
                    readByte = dataInputStream.readShort();
                } else {
                    readByte = dataInputStream.readByte();
                }
                return new JsonValue(readByte);
            } else if (b == 73) {
                if (this.a) {
                    readShort = dataInputStream.readInt();
                } else {
                    readShort = dataInputStream.readShort();
                }
                return new JsonValue(readShort);
            } else if (b == 108) {
                return new JsonValue(dataInputStream.readInt());
            } else {
                if (b == 76) {
                    return new JsonValue(dataInputStream.readLong());
                }
                if (b == 100) {
                    return new JsonValue(dataInputStream.readFloat());
                }
                if (b == 68) {
                    return new JsonValue(dataInputStream.readDouble());
                }
                if (b != 115 && b != 83) {
                    if (b != 97 && b != 65) {
                        if (b == 67) {
                            return new JsonValue(dataInputStream.readChar());
                        }
                        throw new GdxRuntimeException("Unrecognized data type");
                    }
                    return f(dataInputStream, b);
                }
                return new JsonValue(j(dataInputStream, b));
            }
        }
        return (JsonValue) invokeCommon.objValue;
    }

    public JsonValue e(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        byte b;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dataInputStream)) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            byte readByte = dataInputStream.readByte();
            if (readByte == 36) {
                b = dataInputStream.readByte();
                readByte = dataInputStream.readByte();
            } else {
                b = 0;
            }
            long j = -1;
            if (readByte == 35) {
                j = i(dataInputStream, false, -1L);
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i == 0) {
                        return jsonValue;
                    }
                    if (b == 0) {
                        readByte = dataInputStream.readByte();
                    } else {
                        readByte = b;
                    }
                } else {
                    throw new GdxRuntimeException("Unrecognized data type");
                }
            }
            JsonValue jsonValue2 = null;
            long j2 = 0;
            while (dataInputStream.available() > 0 && readByte != 93) {
                JsonValue c = c(dataInputStream, readByte);
                c.g = jsonValue;
                if (jsonValue2 != null) {
                    c.i = jsonValue2;
                    jsonValue2.h = c;
                    jsonValue.j++;
                } else {
                    jsonValue.f = c;
                    jsonValue.j = 1;
                }
                if (j > 0) {
                    j2++;
                    if (j2 >= j) {
                        break;
                    }
                }
                if (b == 0) {
                    b2 = dataInputStream.readByte();
                } else {
                    b2 = b;
                }
                byte b3 = b2;
                jsonValue2 = c;
                readByte = b3;
            }
            return jsonValue;
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue g(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        byte b;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dataInputStream)) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
            byte readByte = dataInputStream.readByte();
            if (readByte == 36) {
                b = dataInputStream.readByte();
                readByte = dataInputStream.readByte();
            } else {
                b = 0;
            }
            long j = -1;
            if (readByte == 35) {
                j = i(dataInputStream, false, -1L);
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i == 0) {
                        return jsonValue;
                    }
                    readByte = dataInputStream.readByte();
                } else {
                    throw new GdxRuntimeException("Unrecognized data type");
                }
            }
            JsonValue jsonValue2 = null;
            long j2 = 0;
            while (dataInputStream.available() > 0 && readByte != 125) {
                String k = k(dataInputStream, true, readByte);
                if (b == 0) {
                    b2 = dataInputStream.readByte();
                } else {
                    b2 = b;
                }
                JsonValue c = c(dataInputStream, b2);
                c.P(k);
                c.g = jsonValue;
                if (jsonValue2 != null) {
                    c.i = jsonValue2;
                    jsonValue2.h = c;
                    jsonValue.j++;
                } else {
                    jsonValue.f = c;
                    jsonValue.j = 1;
                }
                if (j > 0) {
                    j2++;
                    if (j2 >= j) {
                        break;
                    }
                }
                readByte = dataInputStream.readByte();
                jsonValue2 = c;
            }
            return jsonValue;
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue f(DataInputStream dataInputStream, byte b) throws IOException {
        InterceptResult invokeCommon;
        long m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{dataInputStream, Byte.valueOf(b)})) == null) {
            byte readByte = dataInputStream.readByte();
            if (b == 65) {
                m = n(dataInputStream);
            } else {
                m = m(dataInputStream);
            }
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            JsonValue jsonValue2 = null;
            long j = 0;
            while (j < m) {
                JsonValue c = c(dataInputStream, readByte);
                c.g = jsonValue;
                if (jsonValue2 != null) {
                    jsonValue2.h = c;
                    jsonValue.j++;
                } else {
                    jsonValue.f = c;
                    jsonValue.j = 1;
                }
                j++;
                jsonValue2 = c;
            }
            return jsonValue;
        }
        return (JsonValue) invokeCommon.objValue;
    }

    public long h(DataInputStream dataInputStream, byte b, boolean z, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{dataInputStream, Byte.valueOf(b), Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            if (b == 105) {
                return m(dataInputStream);
            }
            if (b == 73) {
                return o(dataInputStream);
            }
            if (b == 108) {
                return n(dataInputStream);
            }
            if (b == 76) {
                return dataInputStream.readLong();
            }
            if (z) {
                return ((b & 255) << 24) | ((dataInputStream.readByte() & 255) << 16) | ((dataInputStream.readByte() & 255) << 8) | (dataInputStream.readByte() & 255);
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    public long i(DataInputStream dataInputStream, boolean z, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dataInputStream, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            return h(dataInputStream, dataInputStream.readByte(), z, j);
        }
        return invokeCommon.longValue;
    }

    public String j(DataInputStream dataInputStream, byte b) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{dataInputStream, Byte.valueOf(b)})) == null) {
            return k(dataInputStream, false, b);
        }
        return (String) invokeCommon.objValue;
    }

    public String l(DataInputStream dataInputStream, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, dataInputStream, j)) == null) {
            byte[] bArr = new byte[(int) j];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        }
        return (String) invokeLJ.objValue;
    }

    public String k(DataInputStream dataInputStream, boolean z, byte b) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{dataInputStream, Boolean.valueOf(z), Byte.valueOf(b)})) == null) {
            long j = -1;
            if (b == 83) {
                j = i(dataInputStream, true, -1L);
            } else if (b == 115) {
                j = m(dataInputStream);
            } else if (z) {
                j = h(dataInputStream, b, false, -1L);
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    return l(dataInputStream, j);
                }
                return "";
            }
            throw new GdxRuntimeException("Unrecognized data type, string expected");
        }
        return (String) invokeCommon.objValue;
    }
}
