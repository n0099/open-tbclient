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
    protected static WeakReference<TbPageContext<?>> btE = null;
    protected static boolean btG = false;
    protected String btC = "183322726";
    protected boolean btF = true;
    protected transient List<String> btD = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Ve();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fB(int i);

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
        if (btE == null) {
            btE = new WeakReference<>(tbPageContext);
            return;
        }
        btE.clear();
        btE = null;
        btE = new WeakReference<>(tbPageContext);
    }

    public boolean Vi() {
        return btG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(boolean z) {
        this.btF = z;
    }

    public void Vf() {
        if (btE != null) {
            btE.get();
            btE.clear();
            btE = null;
        }
    }
}
