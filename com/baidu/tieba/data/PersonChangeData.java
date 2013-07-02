package com.baidu.tieba.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PersonChangeData implements Serializable {
    private static final long serialVersionUID = 4345761658406426272L;
    private String mIntro = null;
    private int mSex = 1;
    private String mName = null;
    private String mPortrait = null;
    private boolean mPhotoChanged = false;

    public String getIntro() {
        return this.mIntro;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setPhotoChanged(boolean z) {
        this.mPhotoChanged = z;
    }

    public boolean getPhotoChanged() {
        return this.mPhotoChanged;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }
}
