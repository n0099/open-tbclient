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
    protected static WeakReference<TbPageContext<?>> amS = null;
    protected static boolean amU = false;
    protected String amQ = "183322726";
    protected boolean amT = true;
    protected transient List<String> amR = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ca(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wD();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wM();

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
        if (amS == null) {
            amS = new WeakReference<>(tbPageContext);
            return;
        }
        amS.clear();
        amS = null;
        amS = new WeakReference<>(tbPageContext);
    }

    public boolean wH() {
        return amU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(boolean z) {
        this.amT = z;
    }

    public void wE() {
        if (amS != null) {
            amS.get();
            amS.clear();
            amS = null;
        }
    }
}
