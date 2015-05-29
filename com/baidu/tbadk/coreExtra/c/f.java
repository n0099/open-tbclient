package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData adf;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.adf = null;
        this.adf = personChangeData;
        if (this.adf == null) {
            this.adf = new PersonChangeData();
        }
    }

    public PersonChangeData wH() {
        return this.adf;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
