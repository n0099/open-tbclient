package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> alP = null;
    protected static boolean eoP = false;
    protected String eoM = "183322726";
    protected boolean eoO = true;
    protected transient List<String> eoN = new ArrayList(5);

    /* loaded from: classes24.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bgb();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bgf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bgg();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bgh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bgi();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nz(int i);

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
        if (alP == null) {
            alP = new WeakReference<>(tbPageContext);
            return;
        }
        alP.clear();
        alP = null;
        alP = new WeakReference<>(tbPageContext);
    }

    public boolean bge() {
        return eoP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ii(boolean z) {
        this.eoO = z;
    }

    public void resetContext() {
        if (alP != null) {
            alP.get();
            alP.clear();
            alP = null;
        }
    }
}
