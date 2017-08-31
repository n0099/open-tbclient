package com.baidu.tieba.face.data;

import android.text.TextUtils;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SingleBarEmotionRecommendData implements b, Serializable {
    private static final long serialVersionUID = 1;
    public String cover;
    public String pkg_id;

    @Override // com.baidu.tieba.face.data.b
    public String getGroupId() {
        return this.pkg_id;
    }

    public void setGroupId(String str) {
        this.pkg_id = str;
    }

    @Override // com.baidu.tieba.face.data.b
    public boolean IsValid() {
        return !TextUtils.isEmpty(this.cover);
    }
}
