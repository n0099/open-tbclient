package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalPicModel extends com.baidu.adp.a.d implements Serializable {
    private String mDName;
    private String mDPath;
    private j mImageTask = null;
    private String mSName;
    private String mSPath;

    public LocalPicModel(String str, String str2, String str3, String str4) {
        this.mSPath = null;
        this.mSName = null;
        this.mDPath = null;
        this.mDName = null;
        this.mSPath = str;
        this.mSName = str2;
        this.mDPath = str3;
        this.mDName = str4;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    public boolean getData() {
        if (this.mImageTask != null) {
            return false;
        }
        this.mImageTask = new j(this, (byte) 0);
        this.mImageTask.setSelfExecute(true);
        this.mImageTask.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.mImageTask != null) {
            this.mImageTask.cancel();
            return true;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public class ResponseData implements Serializable {
        private Bitmap mBitmap;
        private String mDPathGen;
        private String mSPathGen;

        public ResponseData(Bitmap bitmap, String str, String str2) {
            this.mBitmap = null;
            this.mSPathGen = null;
            this.mDPathGen = null;
            this.mBitmap = bitmap;
            this.mSPathGen = str;
            this.mDPathGen = str2;
        }

        public String getSPathGen() {
            return this.mSPathGen;
        }

        public String getDPathGen() {
            return this.mDPathGen;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }
    }
}
