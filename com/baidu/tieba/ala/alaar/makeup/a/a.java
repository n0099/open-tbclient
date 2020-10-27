package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.ar.k;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Makeup;
/* loaded from: classes4.dex */
public class a implements k.a {
    private String mResPath;
    private String mType;
    private float mValue;

    public String getResPath() {
        return this.mResPath;
    }

    public void setResPath(String str) {
        this.mResPath = str;
    }

    public float getValue() {
        return this.mValue;
    }

    @Override // com.baidu.live.ar.k.a
    public void setValue(float f) {
        this.mValue = f;
    }

    @Override // com.baidu.live.ar.k.a
    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.baidu.live.ar.k.a
    public Object Cm() {
        Makeup makeup = new Makeup();
        makeup.setResPath(getResPath());
        makeup.setType(BeautyType.valueOf(getType()));
        makeup.setValue(getValue());
        return makeup;
    }
}
