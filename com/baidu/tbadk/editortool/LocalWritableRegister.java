package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class LocalWritableRegister extends e {
    private static LocalWritableRegister mInstance = new LocalWritableRegister();
    private LinkedList<af> mGroups;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized LocalWritableRegister getInstance() {
        LocalWritableRegister localWritableRegister;
        synchronized (LocalWritableRegister.class) {
            localWritableRegister = mInstance;
        }
        return localWritableRegister;
    }

    @Override // com.baidu.tbadk.editortool.e
    public List<af> getGroups() {
        return this.mGroups;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void getEmotions(f fVar) {
        if (this.mGroups == null) {
            this.mGroups = new LinkedList<>();
            if (TbFaceManager.a().b() > 0) {
                z zVar = new z();
                this.mGroups.add(zVar);
                if (fVar != null) {
                    fVar.a(zVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<af> it = this.mGroups.iterator();
        while (it.hasNext()) {
            af next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void register() {
    }

    @Override // com.baidu.tbadk.editortool.e
    public boolean isEmpty() {
        return this.mGroups == null || this.mGroups.size() == 0;
    }
}
