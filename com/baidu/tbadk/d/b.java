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
    protected static WeakReference<TbPageContext<?>> amy = null;
    protected static boolean amA = false;
    protected String amw = "183322726";
    protected boolean amz = true;
    protected transient List<String> amx = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ca(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wD();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wE();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void wF();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ww();

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
        if (amy == null) {
            amy = new WeakReference<>(tbPageContext);
            return;
        }
        amy.clear();
        amy = null;
        amy = new WeakReference<>(tbPageContext);
    }

    public boolean wA() {
        return amA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQ(boolean z) {
        this.amz = z;
    }

    public void wx() {
        if (amy != null) {
            amy.get();
            amy.clear();
            amy = null;
        }
    }
}
