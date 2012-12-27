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
import android.provider.Settings;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.WebActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class ag {
    public static float a(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static TextPaint a(Context context, TextPaint textPaint, float f) {
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        if (system != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, f, system.getDisplayMetrics()));
        }
        return textPaint;
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize != null) {
            return ellipsize.toString();
        }
        return null;
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

    public static void a(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new ah(activity)).setNegativeButton(R.string.alert_no_button, new ai()).create().show();
    }

    public static void a(Activity activity, float f) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f;
        activity.getWindow().setAttributes(attributes);
    }

    public static void a(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            ae.b("UtilHelper", "hideSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public static void a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Toast makeText = Toast.makeText(TiebaApplication.a(), str, 0);
        makeText.setGravity(17, 0, a(context, 100.0f));
        makeText.show();
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
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

    public static int[] a(com.baidu.tieba.a.j jVar, int i) {
        int i2;
        int[] iArr = new int[2];
        int b = jVar.b();
        int c = jVar.c();
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

    public static int b(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Exception e) {
            ae.b("UtilHelper", "showSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public static void b(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(o.c(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static int c(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        ae.c("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static int c(Context context, float f) {
        TextPaint textPaint = new TextPaint();
        a(context, textPaint, f);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static void c(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static void c(Context context, String str) {
        try {
            if (TiebaApplication.a().h() == 1) {
                WebActivity.a(context, str);
            } else {
                d(context, str);
            }
        } catch (Exception e) {
            ae.b("UtilHelper", "startWebActivity", e.getMessage());
        }
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
                ae.a("UtilHelper", "getScreenSize", e.toString());
                return displayMetrics;
            }
        } catch (Exception e3) {
            displayMetrics = null;
            e = e3;
        }
        return displayMetrics;
    }

    public static void d(Context context, String str) {
        try {
            String spanned = Html.fromHtml(str).toString();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(spanned));
            context.startActivity(intent);
        } catch (Exception e) {
            ae.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static void e(Activity activity) {
        if (activity == null) {
            return;
        }
        Activity parent = activity.getParent() != null ? activity.getParent() : activity;
        if (TiebaApplication.a().ac() == 0.0f) {
            a(parent, f(activity));
        } else {
            a(parent, TiebaApplication.a().ac());
        }
    }

    public static int f(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            ae.b("UtilHelper", "getScreenBrightness", "error = " + e.getMessage());
            return 0;
        }
    }
}
