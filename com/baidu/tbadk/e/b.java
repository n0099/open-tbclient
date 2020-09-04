package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> akW = null;
    protected static boolean dSf = false;
    protected String dSc = "183322726";
    protected boolean dSe = true;
    protected transient List<String> dSd = new ArrayList(5);

    /* loaded from: classes18.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void baG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void baK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void baL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void baM();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void baN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mG(int i);

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
        if (akW == null) {
            akW = new WeakReference<>(tbPageContext);
            return;
        }
        akW.clear();
        akW = null;
        akW = new WeakReference<>(tbPageContext);
    }

    public boolean baJ() {
        return dSf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hC(boolean z) {
        this.dSe = z;
    }

    public void resetContext() {
        if (akW != null) {
            akW.get();
            akW.clear();
            akW = null;
        }
    }
}
