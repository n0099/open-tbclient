package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public abstract boolean aOO();

    public abstract String aOP();

    public abstract WriteData vj(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public DataModel(com.baidu.adp.base.e<T> eVar) {
        super(eVar);
    }
}
