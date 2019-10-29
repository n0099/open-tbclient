package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> bUw = null;
    protected static boolean bUy = false;
    protected String bUu = "183322726";
    protected boolean bUx = true;
    protected transient List<String> bUv = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afs();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afx();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afz();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void hm(int i);

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
        if (bUw == null) {
            bUw = new WeakReference<>(tbPageContext);
            return;
        }
        bUw.clear();
        bUw = null;
        bUw = new WeakReference<>(tbPageContext);
    }

    public boolean afw() {
        return bUy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(boolean z) {
        this.bUx = z;
    }

    public void aft() {
        if (bUw != null) {
            bUw.get();
            bUw.clear();
            bUw = null;
        }
    }
}
