package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> aio = null;
    protected static boolean dxR = false;
    protected String dxO = "183322726";
    protected boolean dxQ = true;
    protected transient List<String> dxP = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aMR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aMV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aMW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aMX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aMY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void jU(int i);

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
        if (aio == null) {
            aio = new WeakReference<>(tbPageContext);
            return;
        }
        aio.clear();
        aio = null;
        aio = new WeakReference<>(tbPageContext);
    }

    public boolean aMU() {
        return dxR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gD(boolean z) {
        this.dxQ = z;
    }

    public void resetContext() {
        if (aio != null) {
            aio.get();
            aio.clear();
            aio = null;
        }
    }
}
