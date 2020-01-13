package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> OC = null;
    protected static boolean cGq = false;
    protected String cGn = "183322726";
    protected boolean cGp = true;
    protected transient List<String> cGo = new ArrayList(5);

    /* loaded from: classes9.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void awJ();

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
        if (OC == null) {
            OC = new WeakReference<>(tbPageContext);
            return;
        }
        OC.clear();
        OC = null;
        OC = new WeakReference<>(tbPageContext);
    }

    public boolean awF() {
        return cGq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fg(boolean z) {
        this.cGp = z;
    }

    public void resetContext() {
        if (OC != null) {
            OC.get();
            OC.clear();
            OC = null;
        }
    }
}
