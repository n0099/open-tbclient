package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class x extends LinearLayout {
    ImageView Xf;
    Bitmap Xg;
    Context mContext;
    Uri mUri;

    public x(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.motu_albums_selected_item, this);
        this.Xf = (ImageView) findViewById(com.baidu.tieba.v.image);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean g(Uri uri) {
        boolean z = true;
        this.mUri = uri;
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.jigsawSelectedImageWidth);
        if (uri != null) {
            try {
                this.Xg = b.b(this.mContext, uri, dimension, dimension);
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
        if (this.Xg != null) {
            this.Xf.setImageBitmap(this.Xg);
        } else {
            z = false;
        }
        if (!z) {
            y.dc(com.baidu.tieba.y.open_error);
        }
        return z;
    }
}
