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
    protected static WeakReference<TbPageContext<?>> ahH = null;
    protected static boolean djN = false;
    protected String djK = "183322726";
    protected boolean djM = true;
    protected transient List<String> djL = new ArrayList(5);

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHj();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aHm();

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
        if (ahH == null) {
            ahH = new WeakReference<>(tbPageContext);
            return;
        }
        ahH.clear();
        ahH = null;
        ahH = new WeakReference<>(tbPageContext);
    }

    public boolean aHi() {
        return djN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gl(boolean z) {
        this.djM = z;
    }

    public void resetContext() {
        if (ahH != null) {
            ahH.get();
            ahH.clear();
            ahH = null;
        }
    }
}
