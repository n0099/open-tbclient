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
    protected static boolean eEX = false;
    protected String eEU = "183322726";
    protected boolean eEW = true;
    protected transient List<String> eEV = new ArrayList(5);

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bjK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bjP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bjQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bjR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bjS();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mH(int i);

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

    public boolean bjO() {
        return eEX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iZ(boolean z) {
        this.eEW = z;
    }

    public void bjL() {
        if (mWeakContext != null) {
            mWeakContext.get();
            mWeakContext.clear();
            mWeakContext = null;
        }
    }
}
