package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData abR;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.abR = null;
        this.abR = personChangeData;
        if (this.abR == null) {
            this.abR = new PersonChangeData();
        }
    }

    public PersonChangeData vR() {
        return this.abR;
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
