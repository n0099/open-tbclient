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
    protected static WeakReference<TbPageContext<?>> aaI = null;
    protected static boolean aaK = false;
    protected String aaG = "183322726";
    protected boolean aaJ = true;
    protected transient List<String> aaH = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bc(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sa();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sb();

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
        if (aaI == null) {
            aaI = new WeakReference<>(tbPageContext);
            return;
        }
        aaI.clear();
        aaI = null;
        aaI = new WeakReference<>(tbPageContext);
    }

    public boolean rW() {
        return aaK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af(boolean z) {
        this.aaJ = z;
    }

    public void rS() {
        if (aaI != null) {
            aaI.get();
            aaI.clear();
            aaI = null;
        }
    }
}
