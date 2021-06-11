package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
import d.a.c.a.f;
/* loaded from: classes3.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public DataModel(f<T> fVar) {
        super(fVar);
    }

    public abstract String w();

    public abstract WriteData x(String str);

    public abstract boolean y();
}
