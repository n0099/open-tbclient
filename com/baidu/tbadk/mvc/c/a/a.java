package com.baidu.tbadk.mvc.c.a;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    private List<com.baidu.tbadk.mvc.c.a> eventDelegates;
    private boolean isDispatchMvcEventing = false;

    public void addEventDelegate(com.baidu.tbadk.mvc.c.a aVar) {
        if (this.isDispatchMvcEventing) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        if (this.eventDelegates == null) {
            this.eventDelegates = new ArrayList();
        }
        this.eventDelegates.add(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        boolean z;
        boolean z2;
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
                    if (aVar == null || (aVar.tk() && !(aVar.tk() && bVar.getUniqueId() == aVar.getUniqueId()))) {
                        z2 = z;
                    } else {
                        z2 = aVar.a(bVar);
                        if (z2) {
                            try {
                                if (bVar.tx()) {
                                    this.isDispatchMvcEventing = false;
                                    return true;
                                }
                            } catch (Throwable th) {
                                z = z2;
                                this.isDispatchMvcEventing = false;
                                return z;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                    z = z2;
                } catch (Throwable th2) {
                }
            }
            this.isDispatchMvcEventing = false;
            return z;
        } catch (Throwable th3) {
            z = false;
        }
    }

    protected void onBeforeDispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
    }
}
