package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> ajF = null;
    protected static boolean dIU = false;
    protected String dIR = "183322726";
    protected boolean dIT = true;
    protected transient List<String> dIS = new ArrayList(5);

    /* loaded from: classes18.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aSp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aSt();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aSu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aSv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aSw();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void kA(int i);

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
        if (ajF == null) {
            ajF = new WeakReference<>(tbPageContext);
            return;
        }
        ajF.clear();
        ajF = null;
        ajF = new WeakReference<>(tbPageContext);
    }

    public boolean aSs() {
        return dIU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hf(boolean z) {
        this.dIT = z;
    }

    public void resetContext() {
        if (ajF != null) {
            ajF.get();
            ajF.clear();
            ajF = null;
        }
    }
}
