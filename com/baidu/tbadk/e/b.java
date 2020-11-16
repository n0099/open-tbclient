package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> alV = null;
    protected static boolean etd = false;
    protected String esZ = "183322726";
    protected boolean etb = true;
    protected transient List<String> eta = new ArrayList(5);

    /* loaded from: classes23.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bhV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bhZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bia();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bib();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bic();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nF(int i);

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
        if (alV == null) {
            alV = new WeakReference<>(tbPageContext);
            return;
        }
        alV.clear();
        alV = null;
        alV = new WeakReference<>(tbPageContext);
    }

    public boolean bhY() {
        return etd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void it(boolean z) {
        this.etb = z;
    }

    public void resetContext() {
        if (alV != null) {
            alV.get();
            alV.clear();
            alV = null;
        }
    }
}
