package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class w {
    private static w a = null;
    private String d;
    private List<c> b = new ArrayList();
    private List<Uri> c = new ArrayList();
    private boolean e = false;

    public static w a() {
        if (a == null) {
            a = new w();
        }
        return a;
    }

    private w() {
    }

    public final int b() {
        return this.b.size();
    }

    public final int a(Uri uri) {
        if (uri == null || this.b == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return -1;
            }
            if (!this.b.get(i2).d.equals(uri)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public final void a(c cVar) {
        this.b.add(cVar);
    }

    public final void c() {
        this.b.clear();
    }

    public final c a(int i) {
        return this.b.get(i);
    }

    public final int a(Context context) {
        return d().size();
    }

    public final boolean a(Context context, Uri uri) {
        boolean z;
        if (a(context) >= 10) {
            return false;
        }
        try {
            int dimension = (int) context.getResources().getDimension(com.baidu.tbadk.h.jigsawSelectedImageWidth);
            if (b.b(context, uri, dimension, dimension) == null) {
                z.a(com.baidu.tbadk.l.open_error);
                return false;
            }
            Iterator<Uri> it = d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().equals(uri)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return false;
            }
            d().add(uri);
            return true;
        } catch (OtherException e) {
            e.printStackTrace();
            z.a(com.baidu.tbadk.l.open_error);
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            z.a(com.baidu.tbadk.l.open_error);
            return false;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            z.a(com.baidu.tbadk.l.open_error);
            return false;
        }
    }

    public final void b(Context context, Uri uri) {
        d().remove(uri);
    }

    public final void b(Context context) {
        d().clear();
    }

    public final List<Uri> d() {
        this.c.size();
        return this.c;
    }

    private int d(Context context) {
        return d().size();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final String e() {
        return this.d;
    }

    public final String c(Context context) {
        return String.format(context.getResources().getString(com.baidu.tbadk.l.jigsaw_selected_text), Integer.valueOf(d(context)), Integer.valueOf(10 - d(context)));
    }

    public static Bitmap a(Context context, c cVar, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(cVar.c));
        try {
            Bitmap a2 = b.a(context, parse, i, i);
            if (a2 == null) {
                return null;
            }
            try {
                int a3 = x.a(context, parse);
                if (a3 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(a3);
                    return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
                }
                return a2;
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap2;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmap;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return null;
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final boolean f() {
        boolean z = this.e;
        this.e = false;
        return z;
    }

    public final boolean b(Uri uri) {
        for (Uri uri2 : this.c) {
            if (uri2.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    public final Intent g() {
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Uri uri : this.c) {
            arrayList.add(uri.toString());
        }
        intent.putStringArrayListExtra("selected_uris", arrayList);
        return intent;
    }
}
