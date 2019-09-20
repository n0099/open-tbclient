package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> bCb = null;
    protected static boolean bCd = false;
    protected String bBZ = "183322726";
    protected boolean bCc = true;
    protected transient List<String> bCa = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaS();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaT();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void gr(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbPageContext<?> tbPageContext) {
        if (bCb == null) {
            bCb = new WeakReference<>(tbPageContext);
            return;
        }
        bCb.clear();
        bCb = null;
        bCb = new WeakReference<>(tbPageContext);
    }

    public boolean aaP() {
        return bCd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dy(boolean z) {
        this.bCc = z;
    }

    public void aaM() {
        if (bCb != null) {
            bCb.get();
            bCb.clear();
            bCb = null;
        }
    }
}
