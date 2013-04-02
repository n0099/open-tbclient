package com.baidu.tieba.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.baidu.loginshare.Token;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.pb.WebBdActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class ai {
    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(TiebaApplication.b(), str, 0);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static void a(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new aj(activity)).setNegativeButton(R.string.alert_no_button, new ak()).create().show();
    }

    public static void a(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            ag.b("UtilHelper", "hideSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Exception e) {
            ag.b("UtilHelper", "showSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public static int b(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static void b(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(o.c(str)), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static int[] a(com.baidu.tieba.a.k kVar, int i) {
        int i2;
        int[] iArr = new int[2];
        int b = kVar.b();
        int c = kVar.c();
        int i3 = i <= 0 ? 1 : i;
        int i4 = i3 <= 350 ? i3 : 350;
        int i5 = (int) (i4 * 1.62f);
        if (c > i5) {
            i2 = (b * i5) / c;
        } else {
            i5 = c;
            i2 = b;
        }
        if (i2 > i4) {
            i5 = (i5 * i4) / i2;
        } else {
            i4 = i2;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        return iArr;
    }

    public static int c(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        ag.e("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static boolean a(byte[] bArr) {
        try {
            if (bArr[0] == 71 && bArr[1] == 73) {
                if (bArr[2] == 70) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static void c(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (str.indexOf("?") > 0) {
            stringBuffer.append("&");
        } else {
            stringBuffer.append("?");
        }
        stringBuffer.append("cuid=");
        stringBuffer.append(TiebaApplication.b().h());
        stringBuffer.append("&timestamp=");
        stringBuffer.append(Long.toString(System.currentTimeMillis()));
        return stringBuffer.toString();
    }

    public static String b(String str) {
        return String.valueOf(str) + "&_client_version=" + com.baidu.tieba.a.i.h();
    }

    public static void c(Context context, String str) {
        try {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.z());
            int i = Build.VERSION.SDK_INT;
            String b2 = b(a(str));
            if (TiebaApplication.b().j() == 1) {
                if (b != null) {
                    WebActivity.a(context, b2, b.mBduss, b.mPtoken);
                } else {
                    WebActivity.a(context, b2, null, null);
                }
            } else if (i >= 7 && TiebaApplication.b().j() == 2) {
                if (b != null) {
                    WebBdActivity.a(context, b2, b.mBduss, b.mPtoken);
                } else {
                    WebBdActivity.a(context, b2, null, null);
                }
            } else {
                e(context, b2);
            }
        } catch (Exception e) {
            ag.b("UtilHelper", "startWebActivity", e.getMessage());
        }
    }

    public static void d(Context context, String str) {
        String b = b(a(str));
        try {
            int i = Build.VERSION.SDK_INT;
            Token b2 = com.baidu.tieba.account.a.b(TiebaApplication.z());
            if (i > 7 && TiebaApplication.b().j() == 2) {
                if (b2 != null) {
                    WebBdActivity.a(context, b, b2.mBduss, b2.mPtoken);
                } else {
                    WebBdActivity.a(context, b, null, null);
                }
            } else if (b2 != null) {
                WebActivity.a(context, b, b2.mBduss, b2.mPtoken);
            } else {
                WebActivity.a(context, b, null, null);
            }
        } catch (Exception e) {
            ag.b("UtilHelper", "startInternalWebActivity", e.getMessage());
        }
    }

    public static void e(Context context, String str) {
        String b = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            ag.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    public static DisplayMetrics d(Activity activity) {
        DisplayMetrics displayMetrics;
        Exception e;
        try {
            displayMetrics = new DisplayMetrics();
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            } catch (Exception e2) {
                e = e2;
                ag.a("UtilHelper", "getScreenSize", e.toString());
                return displayMetrics;
            }
        } catch (Exception e3) {
            displayMetrics = null;
            e = e3;
        }
        return displayMetrics;
    }

    public static float a(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static TextPaint a(Context context, TextPaint textPaint, float f) {
        Resources resources;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        if (resources != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, f, resources.getDisplayMetrics()));
        }
        return textPaint;
    }

    public static int c(Context context, float f) {
        TextPaint textPaint = new TextPaint();
        a(context, textPaint, f);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static String a(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.indexOf("?") < 0) {
                str = String.valueOf(str) + "?";
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                str = String.valueOf(str) + "&";
            }
            return String.valueOf(str) + str2;
        }
        return str;
    }
}
