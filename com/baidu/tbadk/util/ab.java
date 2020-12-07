package com.baidu.tbadk.util;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ab {
    private static Point fGh;
    private b fGj;
    private long fGk;
    private a fGl;
    private a fGm;
    private Context mContext;
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private static final String[] fGe = {"_data", "datetaken"};
    private static final String[] fGf = {"_data", "datetaken", "width", "height"};
    private static final String[] fGg = {StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static final List<String> fGi = new ArrayList();

    /* loaded from: classes.dex */
    public interface b {
        void onShot(String str);
    }

    public ab(Context context) {
        this.mContext = context;
        if (fGh == null) {
            fGh = bGO();
            if (fGh != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + fGh.x + " * " + fGh.y);
            } else {
                BdLog.d("ScreenShotListenManager: Get screen real size failed.");
            }
        }
    }

    public void startListen() {
        if (bGP()) {
            this.fGk = System.currentTimeMillis();
            this.fGl = new a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
            this.fGm = new a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
            if (Build.VERSION.SDK_INT >= 29) {
                this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.fGl);
                this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fGm);
                return;
            }
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.fGl);
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.fGm);
        }
    }

    public void stopListen() {
        if (bGP()) {
            if (this.fGl != null) {
                try {
                    this.mContext.getContentResolver().unregisterContentObserver(this.fGl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.fGl = null;
            }
            if (this.fGm != null) {
                try {
                    this.mContext.getContentResolver().unregisterContentObserver(this.fGm);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.fGm = null;
            }
            this.fGk = 0L;
            this.fGj = null;
        }
    }

    private boolean EN(String str) {
        if (fGi.contains(str)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
            return true;
        }
        if (fGi.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                fGi.remove(0);
            }
        }
        fGi.add(str);
        return false;
    }

    private Point bGO() {
        Point point;
        Point point2 = null;
        if (!bGP() || this.mContext == null) {
            return null;
        }
        try {
            point = new Point();
        } catch (Exception e) {
            e = e;
        }
        try {
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                try {
                    point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                } catch (Exception e2) {
                    point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    BdLog.e(e2);
                }
            }
            return point;
        } catch (Exception e3) {
            point2 = point;
            e = e3;
            BdLog.e(e);
            return point2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=6, 260=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public void v(Uri uri) {
        Cursor cursor;
        int i;
        int i2;
        int i3;
        int i4 = -1;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mContext.getContentResolver().query(uri, Build.VERSION.SDK_INT < 16 ? fGe : fGf, null, null, "date_added desc limit 1");
                if (query == null) {
                    if (query == null || query.isClosed()) {
                        return;
                    }
                    query.close();
                    return;
                }
                try {
                    if (!query.moveToFirst()) {
                        if (query == null || query.isClosed()) {
                            return;
                        }
                        query.close();
                        return;
                    }
                    int columnIndex = query.getColumnIndex("_data");
                    int columnIndex2 = query.getColumnIndex("datetaken");
                    if (Build.VERSION.SDK_INT >= 16) {
                        i4 = query.getColumnIndex("width");
                        i = query.getColumnIndex("height");
                    } else {
                        i = -1;
                    }
                    String string = query.getString(columnIndex);
                    long j = query.getLong(columnIndex2);
                    if (i4 < 0 || i < 0) {
                        Point EO = EO(string);
                        i2 = EO.x;
                        i3 = EO.y;
                    } else {
                        i2 = query.getInt(i4);
                        i3 = query.getInt(i);
                    }
                    a(string, j, i2, i3);
                    if (query == null || query.isClosed()) {
                        return;
                    }
                    query.close();
                } catch (Exception e) {
                    e = e;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor == null || cursor.isClosed()) {
                            return;
                        }
                        cursor.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private Point EO(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    private void a(String str, long j, int i, int i2) {
        if (b(str, j, i, i2)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
            if (this.fGj != null && !EN(str)) {
                this.fGj.onShot(str);
                return;
            }
            return;
        }
        BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
    }

    private boolean b(String str, long j, int i, int i2) {
        if (j < this.fGk || System.currentTimeMillis() - j > 10000) {
            return false;
        }
        if ((fGh == null || ((i <= fGh.x && i2 <= fGh.y) || (i2 <= fGh.x && i <= fGh.y))) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            for (String str2 : fGg) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean bGP() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void a(b bVar) {
        this.fGj = bVar;
    }

    /* loaded from: classes.dex */
    private class a extends ContentObserver {
        private Uri mContentUri;

        public a(Uri uri, Handler handler) {
            super(handler);
            this.mContentUri = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            ab.this.v(this.mContentUri);
        }
    }
}
