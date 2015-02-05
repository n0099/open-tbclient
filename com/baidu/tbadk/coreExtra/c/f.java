package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData RP;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.RP = null;
        this.RP = personChangeData;
        if (this.RP == null) {
            this.RP = new PersonChangeData();
        }
    }

    public PersonChangeData sv() {
        return this.RP;
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
