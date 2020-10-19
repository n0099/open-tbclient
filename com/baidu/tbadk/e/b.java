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
    protected static WeakReference<TbPageContext<?>> alO = null;
    protected static boolean egr = false;
    protected String ego = "183322726";
    protected boolean egq = true;
    protected transient List<String> egp = new ArrayList(5);

    /* loaded from: classes24.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bei();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bem();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ben();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void beo();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bep();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void no(int i);

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
        if (alO == null) {
            alO = new WeakReference<>(tbPageContext);
            return;
        }
        alO.clear();
        alO = null;
        alO = new WeakReference<>(tbPageContext);
    }

    public boolean bel() {
        return egr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hV(boolean z) {
        this.egq = z;
    }

    public void resetContext() {
        if (alO != null) {
            alO.get();
            alO.clear();
            alO = null;
        }
    }
}
