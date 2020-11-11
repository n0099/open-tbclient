package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public abstract WriteData DK(String str);

    public abstract boolean bzY();

    public abstract String bzZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public DataModel(com.baidu.adp.base.e<T> eVar) {
        super(eVar);
    }
}
