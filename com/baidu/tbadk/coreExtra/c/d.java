package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    PersonChangeData aix;

    public d(PersonChangeData personChangeData) {
        super(null);
        this.aix = null;
        this.aix = personChangeData;
        if (this.aix == null) {
            this.aix = new PersonChangeData();
        }
    }

    public PersonChangeData xY() {
        return this.aix;
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
