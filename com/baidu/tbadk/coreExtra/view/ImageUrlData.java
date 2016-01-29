package com.baidu.tbadk.coreExtra.view;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ImageUrlData implements Serializable {
    private static final long serialVersionUID = 2037469186418617574L;
    public String imageUrl;
    public String originalUrl;
    public int urlType;
    public long originalSize = 0;
    public int originalProcess = -1;
    public long threadId = -1;
    public long postId = -1;
    public boolean mIsReserver = true;
    public boolean mIsSeeHost = false;
    public long overAllIndex = 0;
    public int mThreadType = 0;
}
