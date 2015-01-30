package com.baidu.tbadk.motu_gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;
/* loaded from: classes.dex */
public class v {
    private static final String[] ACCEPTABLE_IMAGE_TYPES = {"image/jpeg", "image/png", "image/gif"};
    static final String[] IMAGE_PROJECTION = {"_id", "datetaken", "date_added", "orientation", "_data"};

    protected static String wK() {
        return "(mime_type in (?, ?, ?))";
    }

    protected static String[] wL() {
        return ACCEPTABLE_IMAGE_TYPES;
    }

    protected static String sortOrder() {
        return String.valueOf("case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end") + " DESC, _id DESC";
    }

    protected static Cursor createCursor(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        try {
            if (uri.getScheme().startsWith("file")) {
                String[] strArr = {""};
                strArr[0] = uri.getPath();
                query = MediaStore.Images.Media.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION, "(_data=?)", strArr, sortOrder());
            } else {
                query = MediaStore.Images.Media.query(contentResolver, uri, IMAGE_PROJECTION, wK(), wL(), sortOrder());
            }
            return query;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int a(Context context, Uri uri, boolean z) {
        int i = 0;
        Cursor createCursor = createCursor(context.getContentResolver(), uri);
        if (createCursor != null) {
            try {
                createCursor.moveToFirst();
                i = createCursor.getInt(3);
                if (createCursor != null) {
                    try {
                        createCursor.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (createCursor != null) {
                    try {
                        createCursor.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (createCursor != null) {
                    try {
                        createCursor.close();
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
        int a = a(contentResolver, uri);
        if (a == 0) {
            Cursor createCursor = createCursor(contentResolver, uri);
            if (createCursor == null) {
                return 0;
            }
            try {
                createCursor.moveToFirst();
                int i = createCursor.getInt(3);
                if (createCursor == null) {
                    return i;
                }
                try {
                    createCursor.close();
                    return i;
                } catch (Exception e) {
                    e.printStackTrace();
                    return i;
                }
            } catch (Exception e2) {
                if (createCursor != null) {
                    try {
                        createCursor.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th) {
                if (createCursor != null) {
                    try {
                        createCursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return a;
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
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
