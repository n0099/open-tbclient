package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    PersonChangeData aio;

    public d(PersonChangeData personChangeData) {
        super(null);
        this.aio = null;
        this.aio = personChangeData;
        if (this.aio == null) {
            this.aio = new PersonChangeData();
        }
    }

    public PersonChangeData xR() {
        return this.aio;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
