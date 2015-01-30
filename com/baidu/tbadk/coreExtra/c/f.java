package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    PersonChangeData RS;

    public f(PersonChangeData personChangeData) {
        super(null);
        this.RS = null;
        this.RS = personChangeData;
        if (this.RS == null) {
            this.RS = new PersonChangeData();
        }
    }

    public PersonChangeData sB() {
        return this.RS;
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
