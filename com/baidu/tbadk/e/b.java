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
    protected static WeakReference<TbPageContext<?>> alw = null;
    protected static boolean dUp = false;
    protected String dUm = "183322726";
    protected boolean dUo = true;
    protected transient List<String> dUn = new ArrayList(5);

    /* loaded from: classes23.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bbA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bbE();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bbF();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bbG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bbH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mR(int i);

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
        if (alw == null) {
            alw = new WeakReference<>(tbPageContext);
            return;
        }
        alw.clear();
        alw = null;
        alw = new WeakReference<>(tbPageContext);
    }

    public boolean bbD() {
        return dUp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hz(boolean z) {
        this.dUo = z;
    }

    public void resetContext() {
        if (alw != null) {
            alw.get();
            alw.clear();
            alw = null;
        }
    }
}
