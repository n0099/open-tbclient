package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public abstract class DataModel<T> extends BdBaseModel<T> {
    public abstract WriteData DN(String str);

    public abstract boolean bFk();

    public abstract String bFl();

    /* JADX INFO: Access modifiers changed from: protected */
    public DataModel(com.baidu.adp.base.f<T> fVar) {
        super(fVar);
    }
}
