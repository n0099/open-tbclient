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
    protected static WeakReference<TbPageContext<?>> Oy = null;
    protected static boolean cGe = false;
    protected String cGb = "183322726";
    protected boolean cGd = true;
    protected transient List<String> cGc = new ArrayList(5);

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awo();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void iW(int i);

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
        if (Oy == null) {
            Oy = new WeakReference<>(tbPageContext);
            return;
        }
        Oy.clear();
        Oy = null;
        Oy = new WeakReference<>(tbPageContext);
    }

    public boolean awm() {
        return cGe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fb(boolean z) {
        this.cGd = z;
    }

    public void resetContext() {
        if (Oy != null) {
            Oy.get();
            Oy.clear();
            Oy = null;
        }
    }
}
