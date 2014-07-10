package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalPicModel extends com.baidu.adp.base.e implements Serializable {
    private static final long serialVersionUID = -339604626740227228L;
    private String mDName;
    private String mDPath;
    private ab mImageTask = null;
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public boolean getData() {
        if (this.mImageTask != null) {
            return false;
        }
        this.mImageTask = new ab(this, null);
        this.mImageTask.setSelfExecute(true);
        this.mImageTask.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.mImageTask != null) {
            this.mImageTask.cancel();
            return true;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public class ResponseData implements Serializable {
        private static final long serialVersionUID = -9099542245580007084L;
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
