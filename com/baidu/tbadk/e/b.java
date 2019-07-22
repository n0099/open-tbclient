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
    protected static WeakReference<TbPageContext<?>> bBD = null;
    protected static boolean bBF = false;
    protected String bBB = "183322726";
    protected boolean bBE = true;
    protected transient List<String> bBC = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaM();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aaQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void gq(int i);

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
        if (bBD == null) {
            bBD = new WeakReference<>(tbPageContext);
            return;
        }
        bBD.clear();
        bBD = null;
        bBD = new WeakReference<>(tbPageContext);
    }

    public boolean aaL() {
        return bBF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dy(boolean z) {
        this.bBE = z;
    }

    public void aaI() {
        if (bBD != null) {
            bBD.get();
            bBD.clear();
            bBD = null;
        }
    }
}
