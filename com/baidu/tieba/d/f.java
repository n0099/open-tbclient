package com.baidu.tieba.d;

import android.database.Cursor;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class f {
    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                ae.b("CloseUtil", "error on close the inputstream.", e.getMessage());
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                ae.b("CloseUtil", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }
}
