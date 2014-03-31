package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<d> {
    public UpdateAttentionMessage(d dVar) {
        super(2001118, dVar);
    }

    public final boolean b() {
        if (a() == null || !(a() instanceof d)) {
            return false;
        }
        return a().a;
    }

    public final boolean c() {
        if (a() == null || !(a() instanceof d)) {
            return false;
        }
        return a().d;
    }
}
