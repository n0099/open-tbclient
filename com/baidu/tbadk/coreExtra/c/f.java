package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData abZ;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.abZ = null;
        this.abZ = personChangeData;
        if (this.abZ == null) {
            this.abZ = new PersonChangeData();
        }
    }

    public PersonChangeData vX() {
        return this.abZ;
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
