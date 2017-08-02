package com.baidu.tbadk.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> Qs = null;
    protected static boolean Qu = false;
    protected String Qp = "183322726";
    protected boolean Qt = true;
    protected transient List<String> Qq = new ArrayList(5);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, int i2, ag agVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(TbPageContext tbPageContext, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void aW(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nR();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void nS();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b b(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOTOLIVE_MANAGER_FRAGMENTACTIVITY, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOTOLIVE_MANAGER_ACTIVITY, b.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbPageContext<?> tbPageContext) {
        if (Qs == null) {
            Qs = new WeakReference<>(tbPageContext);
            return;
        }
        Qs.clear();
        Qs = null;
        Qs = new WeakReference<>(tbPageContext);
    }

    public boolean nN() {
        return Qu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ad(boolean z) {
        this.Qt = z;
    }

    public boolean nH() {
        return this.Qt;
    }

    public void nJ() {
        if (Qs != null) {
            Qs.get();
            Qs.clear();
            Qs = null;
        }
    }
}
