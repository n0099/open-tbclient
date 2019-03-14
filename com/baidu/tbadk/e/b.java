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
    protected static WeakReference<TbPageContext<?>> btA = null;
    protected static boolean btC = false;
    protected String bty = "183322726";
    protected boolean btB = true;
    protected transient List<String> btz = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vo();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Vq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void fC(int i);

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
        if (btA == null) {
            btA = new WeakReference<>(tbPageContext);
            return;
        }
        btA.clear();
        btA = null;
        btA = new WeakReference<>(tbPageContext);
    }

    public boolean Vl() {
        return btC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(boolean z) {
        this.btB = z;
    }

    public void Vi() {
        if (btA != null) {
            btA.get();
            btA.clear();
            btA = null;
        }
    }
}
