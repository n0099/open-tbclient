package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.d.b<j, k> implements com.baidu.tbadk.mvc.model.d<k> {
    private FrsGroupActivity aWQ;
    private i aWR;
    private b aWS;
    private j aWT;
    private m aWU;
    private com.baidu.tbadk.mvc.e.a aWV;
    private int index;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(FrsGroupActivity frsGroupActivity, int i, BdUniqueId bdUniqueId) {
        super(frsGroupActivity);
        this.aWQ = frsGroupActivity;
        this.index = i;
        this.unique_id = bdUniqueId;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void b(Bundle bundle) {
        super.b(bundle);
        this.aWT = new j();
        this.aWT.initWithBundle(bundle);
        this.aWT.setType(this.index + 1);
        this.aWR = new i(this.aWQ, this.aWT);
        this.aWR.a((com.baidu.tbadk.mvc.model.k) this);
        this.aWR.setUniqueId(this.unique_id);
        this.aWS = new b(this.aWQ);
        this.aWS.a(this);
        this.aWS.setUniqueId(this.unique_id);
        this.aWU = new m(this.index);
        this.aWV = new com.baidu.tbadk.mvc.e.a(this.index);
        this.aWU.groupPerm = (GroupPermData) bundle.getSerializable("group_perm");
        ta().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean aB(boolean z) {
        if (this.aWT.getRn() == 50 && z) {
            if (this.aWS.tC()) {
                return false;
            }
            this.aWS.a((com.baidu.tbadk.mvc.b.d) this.aWT);
            this.aWV.aC(true);
            a(this.aWV);
            return true;
        } else if (this.aWR.tS()) {
            return false;
        } else {
            if (this.aWU != null) {
                this.aWU.clear();
            }
            this.aWU.groupPerm = null;
            this.aWR.setNeedCache(true);
            this.aWT.setOffset(0);
            this.aWT.setRn(50);
            this.aWV.aC(true);
            a(this.aWV);
            this.aWR.tN();
            return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean tA() {
        if (!this.aWR.tS() && this.aWV.tZ()) {
            this.aWV.aF(true);
            this.aWV.aD(true);
            a(this.aWV);
            this.aWR.setNeedCache(false);
            this.aWR.tN();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean tz() {
        a(this.aWU);
        if (this.aWU.groups == null) {
            aB(true);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(j jVar, k kVar) {
        if (jVar == null || kVar == null) {
            return false;
        }
        return a(jVar, kVar, false);
    }

    public void setGroupPerm(GroupPermData groupPermData) {
        this.aWU.groupPerm = groupPermData;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<k>> readCacheRespMsg, ReadCacheMessage<k> readCacheMessage) {
        k kVar;
        if (readCacheMessage != null && (readCacheMessage.getRequestData() instanceof j)) {
            j jVar = (j) readCacheMessage.getRequestData();
            this.aWR.setNeedCache(true);
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0 && (kVar = readCacheRespMsg.getData().get(0)) != null) {
                aB(false);
                a(jVar, kVar, true);
                return;
            }
        }
        aB(false);
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<k>> writeCacheRespMsg, WriteCacheMessage<k> writeCacheMessage) {
    }

    private boolean a(j jVar, k kVar, boolean z) {
        this.aWV.aC(false);
        this.aWV.aD(false);
        if (kVar.groups.size() != jVar.getRn()) {
            this.aWV.aE(false);
        } else {
            this.aWV.aE(true);
        }
        this.aWU.a(kVar);
        if (!z) {
            jVar.Nv();
        }
        a(this.aWU);
        a(this.aWV);
        return true;
    }
}
