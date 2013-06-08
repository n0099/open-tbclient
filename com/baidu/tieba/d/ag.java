package com.baidu.tieba.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.pb.WebBdActivity;
import com.baidu.tieba.service.PerformMonitorService;
import com.slidingmenu.lib.R;
import java.lang.reflect.Field;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class ag {
    private static boolean a = false;
    private static float b;
    private static int c;
    private static int d;

    private static void f(Context context) {
        b = context.getResources().getDisplayMetrics().density;
        c = context.getResources().getDisplayMetrics().widthPixels;
        d = context.getResources().getDisplayMetrics().heightPixels;
        a = true;
    }

    public static int a(Context context, float f) {
        if (!a) {
            f(context);
        }
        return (int) ((b * f) + 0.5f);
    }

    public static int a(Context context) {
        if (!a) {
            f(context);
        }
        return c;
    }

    public static int b(Context context) {
        if (!a) {
            f(context);
        }
        return d;
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(TiebaApplication.d(), str, 0);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static void a(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new ah(activity)).setNegativeButton(R.string.alert_no_button, new ai()).create().show();
    }

    public static void a(Context context, View view) {
        if (view != null) {
            try {
                if (view.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            } catch (Throwable th) {
                ae.b("UtilHelper", "hideSoftKeyPad", "error = " + th.getMessage());
            }
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            ae.b("UtilHelper", "showSoftKeyPad", "error = " + th.getMessage());
        }
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
        int i3 = BdWebErrorView.ERROR_CODE_400;
        int[] iArr = new int[2];
        int b2 = kVar.b();
        int c2 = kVar.c();
        int i4 = i <= 0 ? 1 : i;
        if (i4 <= 400) {
            i3 = i4;
        }
        int i5 = (int) (i3 * 1.62f);
        if (c2 > i5) {
            i2 = (b2 * i5) / c2;
        } else {
            i5 = c2;
            i2 = b2;
        }
        if (i2 > i3) {
            i5 = (i5 * i3) / i2;
        } else {
            i3 = i2;
        }
        iArr[0] = i3;
        iArr[1] = i5;
        return iArr;
    }

    public static int c(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        ae.e("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
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

    public static void b(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("cuid=");
        sb.append(TiebaApplication.d().j());
        sb.append("&timestamp=");
        sb.append(Long.toString(System.currentTimeMillis()));
        return sb.toString();
    }

    public static String b(String str) {
        return String.valueOf(str) + "&_client_version=" + com.baidu.tieba.a.i.i();
    }

    public static void c(Context context, String str) {
        try {
            Token b2 = com.baidu.tieba.account.a.b(TiebaApplication.C());
            int i = Build.VERSION.SDK_INT;
            String b3 = b(a(str));
            if (TiebaApplication.d().m() == 1) {
                if (b2 != null) {
                    WebActivity.a(context, b3, b2.mBduss, b2.mPtoken);
                } else {
                    WebActivity.a(context, b3, null, null);
                }
            } else if (i >= 7 && TiebaApplication.d().m() == 2) {
                if (b2 != null) {
                    WebBdActivity.a(context, b3, b2.mBduss, b2.mPtoken);
                } else {
                    WebBdActivity.a(context, b3, null, null);
                }
            } else {
                e(context, b3);
            }
        } catch (Exception e) {
            ae.b("UtilHelper", "startWebActivity", e.getMessage());
        }
    }

    public static void d(Context context, String str) {
        String b2 = b(a(str));
        try {
            int i = Build.VERSION.SDK_INT;
            Token b3 = com.baidu.tieba.account.a.b(TiebaApplication.C());
            if (i > 7 && TiebaApplication.d().m() == 2) {
                if (b3 != null) {
                    WebBdActivity.a(context, b2, b3.mBduss, b3.mPtoken);
                } else {
                    WebBdActivity.a(context, b2, null, null);
                }
            } else if (b3 != null) {
                WebActivity.a(context, b2, b3.mBduss, b3.mPtoken);
            } else {
                WebActivity.a(context, b2, null, null);
            }
        } catch (Exception e) {
            ae.b("UtilHelper", "startInternalWebActivity", e.getMessage());
        }
    }

    public static void e(Context context, String str) {
        String b2 = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b2));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            ae.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
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

    public static int b(Context context, float f) {
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

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null && str4 != null) {
            try {
                if (str3.length() > 140) {
                    str3 = str3.substring(0, 140);
                }
                String str5 = "http://tieba.baidu.com/p/" + str2 + "?share=9105";
                if (str != null) {
                    new com.baidu.tieba.account.af(str, str2).start();
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
            } catch (Exception e) {
                ae.b("UtilHelper", "share", e.toString());
            }
        }
    }

    public static void e(Context context) {
        context.startService(new Intent(context, PerformMonitorService.class));
    }
}
