package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> mWeakContext = null;
    protected static boolean eJI = false;
    protected String eJF = "183322726";
    protected boolean eJH = true;
    protected transient List<String> eJG = new ArrayList(5);

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bnD();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bnI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bnJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bnK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bnL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void on(int i);

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
        if (mWeakContext == null) {
            mWeakContext = new WeakReference<>(tbPageContext);
            return;
        }
        mWeakContext.clear();
        mWeakContext = null;
        mWeakContext = new WeakReference<>(tbPageContext);
    }

    public boolean bnH() {
        return eJI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jd(boolean z) {
        this.eJH = z;
    }

    public void bnE() {
        if (mWeakContext != null) {
            mWeakContext.get();
            mWeakContext.clear();
            mWeakContext = null;
        }
    }
}
