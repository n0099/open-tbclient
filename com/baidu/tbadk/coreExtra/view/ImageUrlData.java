package com.baidu.tbadk.coreExtra.view;

import android.graphics.Rect;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ImageUrlData extends OrmObject implements Serializable, Comparable<ImageUrlData> {
    public static final int IMAGE_TYPE_CHUDIAN = 1;
    private static final long serialVersionUID = 2037469186418617574L;
    public String id;
    public String imageUrl;
    public boolean isBlockedPic;
    public Rect mSourceImageRectInScreen;
    public String originalUrl;
    public int urlType;
    public boolean mIsShowOrigonButton = true;
    public boolean isLongPic = false;
    public long originalSize = 0;
    public int originalProcess = -1;
    public long threadId = -1;
    public long postId = -1;
    public boolean mIsReserver = true;
    public boolean mIsSeeHost = false;
    public long overAllIndex = 0;
    public int mThreadType = 0;
    public int mPicType = 0;
    public String mTagName = "";

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ImageUrlData imageUrlData) {
        return (int) (this.overAllIndex - imageUrlData.overAllIndex);
    }
}
