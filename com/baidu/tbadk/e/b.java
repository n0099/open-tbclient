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
    protected static WeakReference<TbPageContext<?>> Pg = null;
    protected static boolean cKH = false;
    protected String cKE = "183322726";
    protected boolean cKG = true;
    protected transient List<String> cKF = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayU();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayY();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ayZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aza();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void azb();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void jn(int i);

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
        if (Pg == null) {
            Pg = new WeakReference<>(tbPageContext);
            return;
        }
        Pg.clear();
        Pg = null;
        Pg = new WeakReference<>(tbPageContext);
    }

    public boolean ayX() {
        return cKH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fo(boolean z) {
        this.cKG = z;
    }

    public void resetContext() {
        if (Pg != null) {
            Pg.get();
            Pg.clear();
            Pg = null;
        }
    }
}
