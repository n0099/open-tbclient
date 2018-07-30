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
    protected static WeakReference<TbPageContext<?>> aaH = null;
    protected static boolean aaJ = false;
    protected String aaF = "183322726";
    protected boolean aaI = true;
    protected transient List<String> aaG = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bc(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rT();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sa();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sb();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sc();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sd();

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
        if (aaH == null) {
            aaH = new WeakReference<>(tbPageContext);
            return;
        }
        aaH.clear();
        aaH = null;
        aaH = new WeakReference<>(tbPageContext);
    }

    public boolean rY() {
        return aaJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(boolean z) {
        this.aaI = z;
    }

    public void rU() {
        if (aaH != null) {
            aaH.get();
            aaH.clear();
            aaH = null;
        }
    }
}
