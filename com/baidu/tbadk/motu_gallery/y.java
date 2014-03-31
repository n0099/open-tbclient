package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public final class y extends LinearLayout {
    ImageView a;
    Uri b;
    Context c;
    Bitmap d;

    public y(Context context) {
        super(context);
        this.c = context;
        ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(com.baidu.tbadk.k.motu_albums_selected_item, this);
        this.a = (ImageView) findViewById(com.baidu.tbadk.j.image);
    }

    public final Uri getUri() {
        return this.b;
    }

    public final boolean a(Uri uri) {
        boolean z = true;
        this.b = uri;
        int dimension = (int) this.c.getResources().getDimension(com.baidu.tbadk.h.jigsawSelectedImageWidth);
        if (uri != null) {
            try {
                this.d = b.b(this.c, uri, dimension, dimension);
            } catch (OtherException e) {
                e.printStackTrace();
                z = false;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                z = false;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                z = false;
            }
        }
        if (this.d != null) {
            this.a.setImageBitmap(this.d);
        } else {
            z = false;
        }
        if (!z) {
            z.a(com.baidu.tbadk.l.open_error);
        }
        return z;
    }
}
