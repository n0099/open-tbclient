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
    protected static WeakReference<TbPageContext<?>> ajK = null;
    protected static boolean dCX = false;
    protected String dCU = "183322726";
    protected boolean dCW = true;
    protected transient List<String> dCV = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aOA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aOB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aOu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aOy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aOz();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void kh(int i);

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
        if (ajK == null) {
            ajK = new WeakReference<>(tbPageContext);
            return;
        }
        ajK.clear();
        ajK = null;
        ajK = new WeakReference<>(tbPageContext);
    }

    public boolean aOx() {
        return dCX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gK(boolean z) {
        this.dCW = z;
    }

    public void resetContext() {
        if (ajK != null) {
            ajK.get();
            ajK.clear();
            ajK = null;
        }
    }
}
