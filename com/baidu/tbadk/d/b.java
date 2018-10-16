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
    protected static WeakReference<TbPageContext<?>> aij = null;
    protected static boolean ail = false;
    protected String aih = "183322726";
    protected boolean aik = true;
    protected transient List<String> aii = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bx(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vi();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vo();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void vr();

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
        if (aij == null) {
            aij = new WeakReference<>(tbPageContext);
            return;
        }
        aij.clear();
        aij = null;
        aij = new WeakReference<>(tbPageContext);
    }

    public boolean vm() {
        return ail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void az(boolean z) {
        this.aik = z;
    }

    public void vj() {
        if (aij != null) {
            aij.get();
            aij.clear();
            aij = null;
        }
    }
}
