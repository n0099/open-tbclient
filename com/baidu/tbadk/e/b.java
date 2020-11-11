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
    protected static boolean euI = false;
    protected String euF = "183322726";
    protected boolean euH = true;
    protected transient List<String> euG = new ArrayList(5);

    /* loaded from: classes24.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biF();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void biI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nJ(int i);

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

    public boolean biE() {
        return euI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ir(boolean z) {
        this.euH = z;
    }

    public void resetContext() {
        if (alP != null) {
            alP.get();
            alP.clear();
            alP = null;
        }
    }
}
