package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public abstract boolean CM();

    public abstract String CN();

    public abstract WriteData fq(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public DataModel(com.baidu.adp.base.g<T> gVar) {
        super(gVar);
    }
}
