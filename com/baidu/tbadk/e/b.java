package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Pf = null;
    protected static boolean cKw = false;
    protected String cKt = "183322726";
    protected boolean cKv = true;
    protected transient List<String> cKu = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void jn(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void removeCallBack();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOTOLIVE_MANAGER_FRAGMENTACTIVITY, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbPageContext<?> tbPageContext) {
        if (Pf == null) {
            Pf = new WeakReference<>(tbPageContext);
            return;
        }
        Pf.clear();
        Pf = null;
        Pf = new WeakReference<>(tbPageContext);
    }

    public boolean ayU() {
        return cKw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fn(boolean z) {
        this.cKv = z;
    }

    public void resetContext() {
        if (Pf != null) {
            Pf.get();
            Pf.clear();
            Pf = null;
        }
    }
}
