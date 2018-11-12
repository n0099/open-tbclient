package com.baidu.tbadk.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> aiW = null;
    protected static boolean aiY = false;
    protected String aiU = "183322726";
    protected boolean aiX = true;
    protected transient List<String> aiV = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bM(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vs();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vx();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vz();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContext(TbPageContext<?> tbPageContext) {
        if (aiW == null) {
            aiW = new WeakReference<>(tbPageContext);
            return;
        }
        aiW.clear();
        aiW = null;
        aiW = new WeakReference<>(tbPageContext);
    }

    public boolean vw() {
        return aiY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aP(boolean z) {
        this.aiX = z;
    }

    public void vt() {
        if (aiW != null) {
            aiW.get();
            aiW.clear();
            aiW = null;
        }
    }
}
