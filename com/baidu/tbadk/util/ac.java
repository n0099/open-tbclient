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
public class ac {
    private static Point fNo;
    private b fNq;
    private long fNr;
    private a fNs;
    private a fNt;
    private Context mContext;
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private static final String[] fNl = {"_data", "datetaken"};
    private static final String[] fNm = {"_data", "datetaken", "width", "height"};
    private static final String[] fNn = {StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static final List<String> fNp = new ArrayList();

    /* loaded from: classes.dex */
    public interface b {
        void onShot(String str);
    }

    public ac(Context context) {
        this.mContext = context;
        if (fNo == null) {
            fNo = bFJ();
            if (fNo != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + fNo.x + " * " + fNo.y);
            } else {
                BdLog.d("ScreenShotListenManager: Get screen real size failed.");
            }
        }
    }

    public void startListen() {
        if (bFK()) {
            this.fNr = System.currentTimeMillis();
            this.fNs = new a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
            this.fNt = new a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
            if (Build.VERSION.SDK_INT >= 29) {
                this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.fNs);
                this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fNt);
                return;
            }
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.fNs);
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.fNt);
        }
    }

    public void stopListen() {
        if (bFK()) {
            if (this.fNs != null) {
                try {
                    this.mContext.getContentResolver().unregisterContentObserver(this.fNs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.fNs = null;
            }
            if (this.fNt != null) {
                try {
                    this.mContext.getContentResolver().unregisterContentObserver(this.fNt);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.fNt = null;
            }
            this.fNr = 0L;
            this.fNq = null;
        }
    }

    private boolean DR(String str) {
        if (fNp.contains(str)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
            return true;
        }
        if (fNp.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                fNp.remove(0);
            }
        }
        fNp.add(str);
        return false;
    }

    private Point bFJ() {
        Exception e;
        Point point;
        Point point2 = null;
        if (!bFK() || this.mContext == null) {
            return null;
        }
        try {
            point = new Point();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                try {
                    point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                } catch (Exception e3) {
                    point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    BdLog.e(e3);
                }
            }
            return point;
        } catch (Exception e4) {
            e = e4;
            point2 = point;
            BdLog.e(e);
            return point2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=6, 260=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public void A(Uri uri) {
        Cursor cursor;
        int i;
        int i2;
        int i3;
        int i4;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mContext.getContentResolver().query(uri, Build.VERSION.SDK_INT < 16 ? fNl : fNm, null, null, "date_added desc limit 1");
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
                        int columnIndex3 = query.getColumnIndex("width");
                        i = query.getColumnIndex("height");
                        i2 = columnIndex3;
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    String string = query.getString(columnIndex);
                    long j = query.getLong(columnIndex2);
                    if (i2 < 0 || i < 0) {
                        Point DS = DS(string);
                        i3 = DS.x;
                        i4 = DS.y;
                    } else {
                        i3 = query.getInt(i2);
                        i4 = query.getInt(i);
                    }
                    a(string, j, i3, i4);
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

    private Point DS(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    private void a(String str, long j, int i, int i2) {
        if (b(str, j, i, i2)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
            if (this.fNq != null && !DR(str)) {
                this.fNq.onShot(str);
                return;
            }
            return;
        }
        BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
    }

    private boolean b(String str, long j, int i, int i2) {
        if (j < this.fNr || System.currentTimeMillis() - j > 10000) {
            return false;
        }
        if ((fNo == null || ((i <= fNo.x && i2 <= fNo.y) || (i2 <= fNo.x && i <= fNo.y))) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            for (String str2 : fNn) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean bFK() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void a(b bVar) {
        this.fNq = bVar;
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
            ac.this.A(this.mContentUri);
        }
    }
}
