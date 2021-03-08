package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> mWeakContext = null;
    protected static boolean eIF = false;
    protected String eIC = "183322726";
    protected boolean eIE = true;
    protected transient List<String> eID = new ArrayList(5);

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bkh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bkl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bkm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bkn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bko();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mL(int i);

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

    public boolean bkk() {
        return eIF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jb(boolean z) {
        this.eIE = z;
    }

    public void resetContext() {
        if (mWeakContext != null) {
            mWeakContext.get();
            mWeakContext.clear();
            mWeakContext = null;
        }
    }
}
