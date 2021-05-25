package com.baidu.tieba.face.data;

import android.text.TextUtils;
import d.a.n0.l0.c.b;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class SingleBarEmotionRecommendData implements Serializable, b {
    public static final long serialVersionUID = 1;
    public String cover;
    public String pkg_id;

    @Override // d.a.n0.l0.c.b
    public boolean IsValid() {
        return !TextUtils.isEmpty(this.cover);
    }

    @Override // d.a.n0.l0.c.b
    public String getGroupId() {
        return this.pkg_id;
    }

    public void setGroupId(String str) {
        this.pkg_id = str;
    }
}
