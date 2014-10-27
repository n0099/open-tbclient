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
    private FrsGroupActivity aWC;
    private i aWD;
    private b aWE;
    private j aWF;
    private m aWG;
    private com.baidu.tbadk.mvc.e.a aWH;
    private int index;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(FrsGroupActivity frsGroupActivity, int i, BdUniqueId bdUniqueId) {
        super(frsGroupActivity);
        this.aWC = frsGroupActivity;
        this.index = i;
        this.unique_id = bdUniqueId;
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void b(Bundle bundle) {
        super.b(bundle);
        this.aWF = new j();
        this.aWF.initWithBundle(bundle);
        this.aWF.setType(this.index + 1);
        this.aWD = new i(this.aWC, this.aWF);
        this.aWD.a((com.baidu.tbadk.mvc.model.k) this);
        this.aWD.setUniqueId(this.unique_id);
        this.aWE = new b(this.aWC);
        this.aWE.a(this);
        this.aWE.setUniqueId(this.unique_id);
        this.aWG = new m(this.index);
        this.aWH = new com.baidu.tbadk.mvc.e.a(this.index);
        this.aWG.groupPerm = (GroupPermData) bundle.getSerializable("group_perm");
        sY().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean aB(boolean z) {
        if (this.aWF.getRn() == 50 && z) {
            if (this.aWE.tA()) {
                return false;
            }
            this.aWE.a((com.baidu.tbadk.mvc.b.d) this.aWF);
            this.aWH.aC(true);
            a(this.aWH);
            return true;
        } else if (this.aWD.tQ()) {
            return false;
        } else {
            if (this.aWG != null) {
                this.aWG.clear();
            }
            this.aWG.groupPerm = null;
            this.aWD.setNeedCache(true);
            this.aWF.setOffset(0);
            this.aWF.setRn(50);
            this.aWH.aC(true);
            a(this.aWH);
            this.aWD.tL();
            return true;
        }
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean ty() {
        if (!this.aWD.tQ() && this.aWH.tX()) {
            this.aWH.aF(true);
            this.aWH.aD(true);
            a(this.aWH);
            this.aWD.setNeedCache(false);
            this.aWD.tL();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean tx() {
        a(this.aWG);
        a(this.aWH);
        if (this.aWG.groups == null) {
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
        this.aWG.groupPerm = groupPermData;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<k>> readCacheRespMsg, ReadCacheMessage<k> readCacheMessage) {
        k kVar;
        if (readCacheMessage != null && (readCacheMessage.getRequestData() instanceof j)) {
            j jVar = (j) readCacheMessage.getRequestData();
            this.aWD.setNeedCache(true);
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
        this.aWH.aC(false);
        this.aWH.aD(false);
        if (kVar.groups.size() != jVar.getRn()) {
            this.aWH.aE(false);
        } else {
            this.aWH.aE(true);
        }
        this.aWG.a(kVar);
        if (!z) {
            jVar.Nr();
        }
        a(this.aWG);
        a(this.aWH);
        return true;
    }
}
