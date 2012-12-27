package com.baidu.tieba.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.baidu.tieba.TiebaApplication;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class e {
    private static volatile Hashtable a = new Hashtable();

    public static Bitmap a(int i) {
        Bitmap bitmap = (Bitmap) a.get(Integer.valueOf(i));
        if (bitmap == null && (bitmap = a(TiebaApplication.a(), i)) != null) {
            a.put(Integer.valueOf(i), bitmap);
        }
        return bitmap;
    }

    public static Bitmap a(Context context, int i) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            } else {
                options.inPreferredConfig = com.baidu.tieba.a.h.f;
            }
            bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
            return bitmap;
        } catch (Exception e) {
            ae.b("BitmapHelper", "getResBitmap", "error = " + e.getMessage());
            return bitmap;
        }
    }

    public static Bitmap a(Context context, Uri uri, int i) {
        ParcelFileDescriptor parcelFileDescriptor;
        int i2 = 1;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = com.baidu.tieba.a.h.f;
                options.inDither = false;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                while (true) {
                    if (options.outWidth / (i2 + 1) <= i && options.outHeight / (i2 + 1) <= i) {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        return BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    }
                    i2++;
                }
            } catch (Exception e) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                        return null;
                    } catch (Exception e2) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e3) {
            parcelFileDescriptor = null;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (bitmap.isRecycled()) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        return a(bitmap, i, i);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = ((float) i2) / ((float) height) > ((float) i) / ((float) width) ? i / width : i2 / height;
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap a(String str, int i) {
        int i2 = 1;
        if (str == null || str.length() <= 0 || i <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream g = o.g(str);
            BitmapFactory.decodeStream(g, null, options);
            options.inPreferredConfig = com.baidu.tieba.a.h.f;
            try {
                g.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true) {
                if (options.outWidth / (i2 * 2) <= i && options.outHeight / (i2 * 2) <= i) {
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = i2;
                    InputStream g2 = o.g(str);
                    Bitmap decodeStream = BitmapFactory.decodeStream(g2, null, options);
                    try {
                        g2.close();
                        return decodeStream;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return decodeStream;
                    }
                }
                i2 *= 2;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public static Bitmap a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = com.baidu.tieba.a.h.f;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        return b(bitmap, i, i);
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = ((float) i2) / ((float) height) < ((float) i) / ((float) width) ? i / width : i2 / height;
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            return createBitmap;
        }
        return bitmap;
    }

    public static byte[] c(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap d(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (i == 0) {
            matrix.postRotate(-90.0f);
        } else if (i == 1) {
            matrix.postRotate(90.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap e(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i == 3) {
            matrix.setScale(-1.0f, 1.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        matrix.setRotate(180.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        if (createBitmap != createBitmap2) {
            createBitmap.recycle();
        }
        if (bitmap != createBitmap2) {
            bitmap.recycle();
        }
        return createBitmap2;
    }
}
