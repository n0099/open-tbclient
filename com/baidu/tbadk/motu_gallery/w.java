package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.z;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    ImageView adD;
    Bitmap adE;
    Context mContext;
    Uri mUri;

    public w(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.motu_albums_selected_item, this);
        this.adD = (ImageView) findViewById(com.baidu.tieba.w.image);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean h(Uri uri) {
        boolean z = true;
        this.mUri = uri;
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.jigsawSelectedImageWidth);
        if (uri != null) {
            try {
                this.adE = b.a(this.mContext, uri, dimension, dimension);
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
        if (this.adE != null) {
            this.adD.setImageBitmap(this.adE);
        } else {
            z = false;
        }
        if (!z) {
            x.showToastLong(z.open_error);
        }
        return z;
    }
}
