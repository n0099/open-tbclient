package com.baidu.tieba.face.data;

import com.baidu.tbadk.img.ImageFileInfo;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class FaceData implements Comparable<FaceData>, Serializable {
    public static final int TYPE_ADD_ICON = 4;
    public static final int TYPE_ALBUM = 3;
    public static final int TYPE_COLLECT = 1;
    public static final int TYPE_SEARCH = 2;
    public EmotionImageData emotionImageData;
    public int height;
    public ImageFileInfo imageFileInfo;
    public int index;
    public String pid;
    public int type;
    public int width;

    public FaceData() {
    }

    public FaceData(int i2) {
        this.type = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FaceData faceData) {
        if (this == faceData) {
            return 0;
        }
        return (faceData == null || this.index <= faceData.index) ? -1 : 1;
    }
}
