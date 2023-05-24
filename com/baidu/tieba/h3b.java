package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes5.dex */
public class h3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public char[] g;

    public h3b(X500Principal x500Principal) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x500Principal};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    public final int a(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i4 = i + 1;
            if (i4 < this.b) {
                char c = this.g[i];
                if (c >= '0' && c <= '9') {
                    i2 = c - TransactionIdCreater.FILL_BYTE;
                } else if (c >= 'a' && c <= 'f') {
                    i2 = c - 'W';
                } else if (c >= 'A' && c <= 'F') {
                    i2 = c - '7';
                } else {
                    throw new IllegalStateException("Malformed DN: " + this.a);
                }
                char c2 = this.g[i4];
                if (c2 >= '0' && c2 <= '9') {
                    i3 = c2 - TransactionIdCreater.FILL_BYTE;
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i3 = c2 - 'W';
                } else if (c2 >= 'A' && c2 <= 'F') {
                    i3 = c2 - '7';
                } else {
                    throw new IllegalStateException("Malformed DN: " + this.a);
                }
                return (i2 << 4) + i3;
            }
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        return invokeI.intValue;
    }

    public List<String> d(String str) {
        InterceptResult invokeL;
        String h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = this.a.toCharArray();
            List<String> emptyList = Collections.emptyList();
            String g = g();
            if (g == null) {
                return emptyList;
            }
            do {
                int i = this.c;
                if (i < this.b) {
                    char c = this.g[i];
                    if (c != '\"') {
                        if (c != '#') {
                            if (c != '+' && c != ',' && c != ';') {
                                h = b();
                            } else {
                                h = "";
                            }
                        } else {
                            h = f();
                        }
                    } else {
                        h = h();
                    }
                    if (str.equalsIgnoreCase(g)) {
                        if (emptyList.isEmpty()) {
                            emptyList = new ArrayList<>();
                        }
                        emptyList.add(h);
                    }
                    int i2 = this.c;
                    if (i2 < this.b) {
                        char[] cArr = this.g;
                        if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                            throw new IllegalStateException("Malformed DN: " + this.a);
                        }
                        this.c++;
                        g = g();
                    }
                }
                return emptyList;
            } while (g != null);
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        return new java.lang.String(r1, r2, r8.f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.c;
            this.d = i;
            this.e = i;
            while (true) {
                int i2 = this.c;
                if (i2 >= this.b) {
                    char[] cArr = this.g;
                    int i3 = this.d;
                    return new String(cArr, i3, this.e - i3);
                }
                char[] cArr2 = this.g;
                char c = cArr2[i2];
                if (c != ' ') {
                    if (c == ';') {
                        break;
                    } else if (c != '\\') {
                        if (c == '+' || c == ',') {
                            break;
                        }
                        int i4 = this.e;
                        this.e = i4 + 1;
                        cArr2[i4] = cArr2[i2];
                        this.c = i2 + 1;
                    } else {
                        int i5 = this.e;
                        this.e = i5 + 1;
                        cArr2[i5] = c();
                        this.c++;
                    }
                } else {
                    int i6 = this.e;
                    this.f = i6;
                    this.c = i2 + 1;
                    this.e = i6 + 1;
                    cArr2[i6] = WebvttCueParser.CHAR_SPACE;
                    while (true) {
                        int i7 = this.c;
                        if (i7 >= this.b) {
                            break;
                        }
                        char[] cArr3 = this.g;
                        if (cArr3[i7] != ' ') {
                            break;
                        }
                        int i8 = this.e;
                        this.e = i8 + 1;
                        cArr3[i8] = WebvttCueParser.CHAR_SPACE;
                        this.c = i7 + 1;
                    }
                    int i9 = this.c;
                    if (i9 == this.b) {
                        break;
                    }
                    char[] cArr4 = this.g;
                    if (cArr4[i9] == ',' || cArr4[i9] == '+' || cArr4[i9] == ';') {
                        break;
                    }
                }
            }
            char[] cArr5 = this.g;
            int i10 = this.d;
            return new String(cArr5, i10, this.e - i10);
        }
        return (String) invokeV.objValue;
    }

    public final char c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.c + 1;
            this.c = i;
            if (i != this.b) {
                char[] cArr = this.g;
                char c = cArr[i];
                if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
                    switch (c) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return e();
                            }
                    }
                }
                return cArr[i];
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        return invokeV.charValue;
    }

    public final char e() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int a = a(this.c);
            this.c++;
            if (a < 128) {
                return (char) a;
            }
            if (a < 192 || a > 247) {
                return RFC1522Codec.SEP;
            }
            if (a <= 223) {
                i2 = a & 31;
                i = 1;
            } else if (a <= 239) {
                i = 2;
                i2 = a & 15;
            } else {
                i = 3;
                i2 = a & 7;
            }
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = this.c + 1;
                this.c = i4;
                if (i4 == this.b || this.g[i4] != '\\') {
                    return RFC1522Codec.SEP;
                }
                int i5 = i4 + 1;
                this.c = i5;
                int a2 = a(i5);
                this.c++;
                if ((a2 & 192) != 128) {
                    return RFC1522Codec.SEP;
                }
                i2 = (i2 << 6) + (a2 & 63);
            }
            return (char) i2;
        }
        return invokeV.charValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.c + 1;
            this.c = i;
            this.d = i;
            this.e = i;
            while (true) {
                int i2 = this.c;
                if (i2 != this.b) {
                    char[] cArr = this.g;
                    if (cArr[i2] == '\"') {
                        this.c = i2 + 1;
                        while (true) {
                            int i3 = this.c;
                            if (i3 >= this.b || this.g[i3] != ' ') {
                                break;
                            }
                            this.c = i3 + 1;
                        }
                        char[] cArr2 = this.g;
                        int i4 = this.d;
                        return new String(cArr2, i4, this.e - i4);
                    }
                    if (cArr[i2] == '\\') {
                        cArr[this.e] = c();
                    } else {
                        cArr[this.e] = cArr[i2];
                    }
                    this.c++;
                    this.e++;
                } else {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.c;
            if (i + 4 < this.b) {
                this.d = i;
                this.c = i + 1;
                while (true) {
                    int i2 = this.c;
                    if (i2 == this.b) {
                        break;
                    }
                    char[] cArr = this.g;
                    if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                        break;
                    } else if (cArr[i2] == ' ') {
                        this.e = i2;
                        this.c = i2 + 1;
                        while (true) {
                            int i3 = this.c;
                            if (i3 >= this.b || this.g[i3] != ' ') {
                                break;
                            }
                            this.c = i3 + 1;
                        }
                    } else {
                        if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                            cArr[i2] = (char) (cArr[i2] + WebvttCueParser.CHAR_SPACE);
                        }
                        this.c++;
                    }
                }
                this.e = this.c;
                int i4 = this.e;
                int i5 = this.d;
                int i6 = i4 - i5;
                if (i6 >= 5 && (i6 & 1) != 0) {
                    int i7 = i6 / 2;
                    byte[] bArr = new byte[i7];
                    int i8 = i5 + 1;
                    for (int i9 = 0; i9 < i7; i9++) {
                        bArr[i9] = (byte) a(i8);
                        i8 += 2;
                    }
                    return new String(this.g, this.d, i6);
                }
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            while (true) {
                int i = this.c;
                if (i >= this.b || this.g[i] != ' ') {
                    break;
                }
                this.c = i + 1;
            }
            int i2 = this.c;
            if (i2 == this.b) {
                return null;
            }
            this.d = i2;
            this.c = i2 + 1;
            while (true) {
                int i3 = this.c;
                if (i3 >= this.b) {
                    break;
                }
                char[] cArr = this.g;
                if (cArr[i3] == '=' || cArr[i3] == ' ') {
                    break;
                }
                this.c = i3 + 1;
            }
            int i4 = this.c;
            if (i4 < this.b) {
                this.e = i4;
                if (this.g[i4] == ' ') {
                    while (true) {
                        int i5 = this.c;
                        if (i5 >= this.b) {
                            break;
                        }
                        char[] cArr2 = this.g;
                        if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                            break;
                        }
                        this.c = i5 + 1;
                    }
                    char[] cArr3 = this.g;
                    int i6 = this.c;
                    if (cArr3[i6] != '=' || i6 == this.b) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.a);
                    }
                }
                this.c++;
                while (true) {
                    int i7 = this.c;
                    if (i7 >= this.b || this.g[i7] != ' ') {
                        break;
                    }
                    this.c = i7 + 1;
                }
                int i8 = this.e;
                int i9 = this.d;
                if (i8 - i9 > 4) {
                    char[] cArr4 = this.g;
                    if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                        char[] cArr5 = this.g;
                        int i10 = this.d + 1;
                        if (cArr5[i10] == 'I' || cArr5[i10] == 'i') {
                            char[] cArr6 = this.g;
                            int i11 = this.d + 2;
                            if (cArr6[i11] == 'D' || cArr6[i11] == 'd') {
                                this.d += 4;
                            }
                        }
                    }
                }
                char[] cArr7 = this.g;
                int i12 = this.d;
                return new String(cArr7, i12, this.e - i12);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        return (String) invokeV.objValue;
    }
}
