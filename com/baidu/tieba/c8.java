package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes3.dex */
public final class c8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0132, code lost:
        if (r11 != 3) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(x7<String, String> x7Var, Reader reader) throws IOException {
        char c;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65536, null, x7Var, reader) != null) {
            return;
        }
        if (x7Var == null) {
            throw new NullPointerException("properties cannot be null");
        }
        if (reader != null) {
            char[] cArr = new char[40];
            BufferedReader bufferedReader = new BufferedReader(reader);
            char c3 = 2;
            char c4 = 1;
            int i = 0;
            char c5 = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = -1;
                boolean z = true;
                while (true) {
                    int read = bufferedReader.read();
                    if (read == -1) {
                        if (c5 == c3 && i2 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
                        }
                        if (i4 == -1 && i > 0) {
                            i4 = i;
                        }
                        if (i4 >= 0) {
                            String str = new String(cArr, 0, i);
                            String substring = str.substring(0, i4);
                            String substring2 = str.substring(i4);
                            if (c5 == c4) {
                                substring2 = substring2 + "\u0000";
                            }
                            x7Var.i(substring, substring2);
                            return;
                        }
                        return;
                    }
                    char c6 = (char) read;
                    if (i == cArr.length) {
                        char[] cArr2 = new char[cArr.length * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, i);
                        cArr = cArr2;
                    }
                    if (c5 == c3) {
                        int digit = Character.digit(c6, 16);
                        if (digit >= 0) {
                            i3 = (i3 << 4) + digit;
                            i2++;
                            if (i2 < 4) {
                                c3 = 2;
                            }
                        } else if (i2 <= 4) {
                            throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                        }
                        cArr[i] = (char) i3;
                        i++;
                        if (c6 != '\n') {
                            c3 = 2;
                            c5 = 0;
                        } else {
                            c5 = 0;
                        }
                    }
                    if (c5 != c4) {
                        if (c6 == '\n') {
                            if (c5 != 3) {
                                break;
                            }
                            c3 = 2;
                            c4 = 1;
                            c5 = 5;
                        } else if (c6 == '\r') {
                            break;
                        } else {
                            if (c6 == '!' || c6 == '#') {
                                if (z) {
                                    do {
                                        int read2 = bufferedReader.read();
                                        if (read2 == -1 || (c = (char) read2) == '\r') {
                                            break;
                                        }
                                    } while (c != '\n');
                                    c3 = 2;
                                    c4 = 1;
                                }
                            } else if (c6 == ':' || c6 == '=') {
                                if (i4 == -1) {
                                    i4 = i;
                                    c3 = 2;
                                    c4 = 1;
                                    c5 = 0;
                                }
                            } else if (c6 == '\\') {
                                if (c5 == 4) {
                                    i4 = i;
                                }
                                c3 = 2;
                                c4 = 1;
                                c5 = 1;
                            }
                            if (Character.isSpace(c6)) {
                                if (c5 == 3) {
                                    c5 = 5;
                                }
                                if (i != 0 && i != i4) {
                                    c2 = 5;
                                    if (c5 != 5) {
                                        if (i4 == -1) {
                                            c3 = 2;
                                            c4 = 1;
                                            c5 = 4;
                                        }
                                    }
                                }
                                c3 = 2;
                                c4 = 1;
                            } else {
                                c2 = 5;
                            }
                            if (c5 != c2) {
                            }
                            c5 = 0;
                        }
                    } else if (c6 == '\n') {
                        c3 = 2;
                        c5 = 5;
                    } else if (c6 != '\r') {
                        if (c6 == 'b') {
                            c6 = '\b';
                        } else if (c6 == 'f') {
                            c6 = '\f';
                        } else if (c6 == 'n') {
                            c6 = '\n';
                        } else if (c6 == 'r') {
                            c6 = '\r';
                        } else if (c6 == 't') {
                            c6 = '\t';
                        } else if (c6 == 'u') {
                            c3 = 2;
                            c5 = 2;
                            i2 = 0;
                            i3 = 0;
                        }
                        c5 = 0;
                    } else {
                        c3 = 2;
                        c5 = 3;
                    }
                    if (c5 == 4) {
                        i4 = i;
                        c5 = 0;
                    }
                    cArr[i] = c6;
                    i++;
                    c3 = 2;
                    c4 = 1;
                    z = false;
                }
                if (i > 0 || (i == 0 && i4 == 0)) {
                    if (i4 == -1) {
                        i4 = i;
                    }
                    String str2 = new String(cArr, 0, i);
                    x7Var.i(str2.substring(0, i4), str2.substring(i4));
                }
                c3 = 2;
                c4 = 1;
                i = 0;
                c5 = 0;
            }
        } else {
            throw new NullPointerException("reader cannot be null");
        }
    }
}
