package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public abstract boolean Dk();

    public abstract String Dl();

    public abstract WriteData fn(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public DataModel(com.baidu.adp.base.g<T> gVar) {
        super(gVar);
    }
}
