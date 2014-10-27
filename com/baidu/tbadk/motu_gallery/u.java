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
public class u {
    private static u WU = null;
    private List<c> WV = new ArrayList();
    private List<Uri> WW;
    private String WX;
    private boolean WY;

    public static u sM() {
        if (WU == null) {
            WU = new u();
        }
        return WU;
    }

    private u() {
        q(new ArrayList());
        this.WY = false;
    }

    public int getCount() {
        return this.WV.size();
    }

    public int e(Uri uri) {
        if (uri == null || this.WV == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.WV.size()) {
                return -1;
            }
            if (!this.WV.get(i2).uri.equals(uri)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(c cVar) {
        this.WV.add(cVar);
    }

    public void removeAll() {
        this.WV.clear();
    }

    public c db(int i) {
        return this.WV.get(i);
    }

    public int A(Context context) {
        return C(context).size();
    }

    public boolean a(Context context, Uri uri) {
        boolean z;
        if (A(context) >= 10) {
            return false;
        }
        try {
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.jigsawSelectedImageWidth);
            if (b.b(context, uri, dimension, dimension) == null) {
                y.dc(com.baidu.tieba.y.open_error);
                return false;
            }
            Iterator<Uri> it = C(context).iterator();
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
            C(context).add(uri);
            return true;
        } catch (OtherException e) {
            e.printStackTrace();
            y.dc(com.baidu.tieba.y.open_error);
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            y.dc(com.baidu.tieba.y.open_error);
            return false;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            y.dc(com.baidu.tieba.y.open_error);
            return false;
        }
    }

    public void b(Context context, Uri uri) {
        C(context).remove(uri);
        F(context);
    }

    public void B(Context context) {
        C(context).clear();
        F(context);
    }

    private void q(List<Uri> list) {
        this.WW = list;
    }

    public List<Uri> C(Context context) {
        this.WW.size();
        return this.WW;
    }

    public int D(Context context) {
        return C(context).size();
    }

    public void dK(String str) {
        this.WX = str;
    }

    public String sN() {
        return this.WX;
    }

    public String E(Context context) {
        return String.format(context.getResources().getString(com.baidu.tieba.y.jigsaw_selected_text), Integer.valueOf(D(context)), Integer.valueOf(10 - D(context)));
    }

    public Bitmap a(Context context, c cVar, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(cVar.Wb));
        try {
            Bitmap a = b.a(context, parse, i, i);
            if (a == null) {
                return null;
            }
            try {
                int a2 = w.a(context, parse, false);
                if (a2 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(a2);
                    return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
                }
                return a;
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

    public boolean sO() {
        boolean z = this.WY;
        this.WY = false;
        return z;
    }

    private void F(Context context) {
    }

    public boolean f(Uri uri) {
        for (Uri uri2 : this.WW) {
            if (uri2.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    public Intent sP() {
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Uri uri : this.WW) {
            arrayList.add(uri.toString());
        }
        intent.putStringArrayListExtra("selected_uris", arrayList);
        return intent;
    }
}
