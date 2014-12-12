package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.tieba.z;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u ade = null;
    private List<c> adf = new ArrayList();
    private List<Uri> adg;
    private String adh;
    private boolean adi;

    public static u wq() {
        if (ade == null) {
            ade = new u();
        }
        return ade;
    }

    private u() {
        u(new ArrayList());
        this.adi = false;
    }

    public int getCount() {
        return this.adf.size();
    }

    public int f(Uri uri) {
        if (uri == null || this.adf == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.adf.size()) {
                return -1;
            }
            if (!this.adf.get(i2).uri.equals(uri)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(c cVar) {
        this.adf.add(cVar);
    }

    public void removeAll() {
        this.adf.clear();
    }

    public c dy(int i) {
        return this.adf.get(i);
    }

    public int X(Context context) {
        return Z(context).size();
    }

    public boolean c(Context context, Uri uri) {
        boolean z;
        if (X(context) >= 10) {
            return false;
        }
        try {
            int dimension = (int) context.getResources().getDimension(com.baidu.tieba.u.jigsawSelectedImageWidth);
            if (b.a(context, uri, dimension, dimension) == null) {
                y.showToastLong(z.open_error);
                return false;
            }
            Iterator<Uri> it = Z(context).iterator();
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
            Z(context).add(uri);
            return true;
        } catch (OtherException e) {
            e.printStackTrace();
            y.showToastLong(z.open_error);
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            y.showToastLong(z.open_error);
            return false;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            y.showToastLong(z.open_error);
            return false;
        }
    }

    public void d(Context context, Uri uri) {
        Z(context).remove(uri);
        ac(context);
    }

    public void Y(Context context) {
        Z(context).clear();
        ac(context);
    }

    private void u(List<Uri> list) {
        this.adg = list;
    }

    public List<Uri> Z(Context context) {
        this.adg.size();
        return this.adg;
    }

    public int aa(Context context) {
        return Z(context).size();
    }

    public void ex(String str) {
        this.adh = str;
    }

    public String wr() {
        return this.adh;
    }

    public String ab(Context context) {
        return String.format(context.getResources().getString(z.jigsaw_selected_text), Integer.valueOf(aa(context)), Integer.valueOf(10 - aa(context)));
    }

    public Bitmap a(Context context, c cVar, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(cVar.ack));
        try {
            Bitmap bitmapSample = b.getBitmapSample(context, parse, i, i);
            if (bitmapSample == null) {
                return null;
            }
            try {
                int a = w.a(context, parse, false);
                if (a != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(a);
                    return Bitmap.createBitmap(bitmapSample, 0, 0, bitmapSample.getWidth(), bitmapSample.getHeight(), matrix, true);
                }
                return bitmapSample;
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

    public boolean ws() {
        boolean z = this.adi;
        this.adi = false;
        return z;
    }

    private void ac(Context context) {
    }

    public boolean g(Uri uri) {
        for (Uri uri2 : this.adg) {
            if (uri2.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    public Intent wt() {
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Uri uri : this.adg) {
            arrayList.add(uri.toString());
        }
        intent.putStringArrayListExtra("selected_uris", arrayList);
        return intent;
    }
}
