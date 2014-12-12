package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData Ro;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.Ro = null;
        this.Ro = personChangeData;
        if (this.Ro == null) {
            this.Ro = new PersonChangeData();
        }
    }

    public PersonChangeData sl() {
        return this.Ro;
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
