package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    private List<com.baidu.tbadk.mvc.c.a> eventDelegates;
    private boolean isDispatchMvcEventing = false;
    private BdUniqueId uniqueId;

    public void addEventDelegate(com.baidu.tbadk.mvc.c.a aVar) {
        if (this.eventDelegates == null) {
            this.eventDelegates = new ArrayList();
        }
        if (!this.eventDelegates.contains(aVar)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.m255getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(aVar);
        }
    }

    public void removeEventDelegate(com.baidu.tbadk.mvc.c.a aVar) {
        if (this.eventDelegates != null && this.eventDelegates.contains(aVar)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.m255getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(aVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        boolean z;
        boolean z2;
        if (bVar != null && bVar.getUniqueId() == null) {
            bVar.setUniqueId(this.uniqueId);
        }
        if (this.eventDelegates == null) {
            return false;
        }
        try {
            this.isDispatchMvcEventing = true;
            onBeforeDispatchMvcEvent(bVar);
            int size = this.eventDelegates.size();
            int i = 0;
            z = false;
            while (i < size) {
                try {
                    com.baidu.tbadk.mvc.c.a aVar = this.eventDelegates.get(i);
                    if (aVar == null || (aVar.wO() && !(aVar.wO() && bVar.getUniqueId() == aVar.getUniqueId()))) {
                        z2 = z;
                    } else {
                        z2 = aVar.a(bVar);
                        if (z2) {
                            try {
                                if (bVar.xy()) {
                                    return true;
                                }
                            } catch (Throwable th) {
                                z = z2;
                                th = th;
                                try {
                                    BdLog.e(th);
                                    if (TbadkCoreApplication.m255getInst().isDebugMode()) {
                                        throw new RuntimeException(th);
                                    }
                                    return z;
                                } finally {
                                    this.isDispatchMvcEventing = false;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                    z = z2;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    protected void onBeforeDispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
    }

    public void setDefaultUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
