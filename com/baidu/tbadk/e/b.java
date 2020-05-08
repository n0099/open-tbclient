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
    protected static WeakReference<TbPageContext<?>> ahK = null;
    protected static boolean djR = false;
    protected String djO = "183322726";
    protected boolean djQ = true;
    protected transient List<String> djP = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHi();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ju(int i);

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
        if (ahK == null) {
            ahK = new WeakReference<>(tbPageContext);
            return;
        }
        ahK.clear();
        ahK = null;
        ahK = new WeakReference<>(tbPageContext);
    }

    public boolean aHg() {
        return djR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gl(boolean z) {
        this.djQ = z;
    }

    public void resetContext() {
        if (ahK != null) {
            ahK.get();
            ahK.clear();
            ahK = null;
        }
    }
}
