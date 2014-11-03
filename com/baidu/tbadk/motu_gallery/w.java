package com.baidu.tbadk.motu_gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;
/* loaded from: classes.dex */
public class w {
    private static final String[] Xd = {"image/jpeg", "image/png", "image/gif"};
    static final String[] Xe = {"_id", "datetaken", "date_added", "orientation", "_data"};

    protected static String sS() {
        return "(mime_type in (?, ?, ?))";
    }

    protected static String[] sT() {
        return Xd;
    }

    protected static String sU() {
        return String.valueOf("case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end") + " DESC, _id DESC";
    }

    protected static Cursor a(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        try {
            if (uri.getScheme().startsWith("file")) {
                String[] strArr = {""};
                strArr[0] = uri.getPath();
                query = MediaStore.Images.Media.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Xe, "(_data=?)", strArr, sU());
            } else {
                query = MediaStore.Images.Media.query(contentResolver, uri, Xe, sS(), sT(), sU());
            }
            return query;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int a(Context context, Uri uri, boolean z) {
        int i = 0;
        Cursor a = a(context.getContentResolver(), uri);
        if (a != null) {
            try {
                a.moveToFirst();
                i = a.getInt(3);
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int b(Context context, Uri uri, boolean z) {
        ContentResolver contentResolver = context.getContentResolver();
        int b = b(contentResolver, uri);
        if (b == 0) {
            Cursor a = a(contentResolver, uri);
            if (a == null) {
                return 0;
            }
            try {
                a.moveToFirst();
                int i = a.getInt(3);
                if (a == null) {
                    return i;
                }
                try {
                    a.close();
                    return i;
                } catch (Exception e) {
                    e.printStackTrace();
                    return i;
                }
            } catch (Exception e2) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return b;
    }

    private static int b(ContentResolver contentResolver, Uri uri) {
        if (!uri.getScheme().startsWith("file")) {
            return 0;
        }
        try {
            int intValue = Integer.valueOf(new ExifInterface(uri.getPath()).getAttribute("Orientation")).intValue();
            if (6 == intValue) {
                return 90;
            }
            if (3 == intValue) {
                return 180;
            }
            if (8 != intValue) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
