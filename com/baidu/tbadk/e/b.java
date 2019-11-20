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
    protected static WeakReference<TbPageContext<?>> bTF = null;
    protected static boolean bTH = false;
    protected String bTD = "183322726";
    protected boolean bTG = true;
    protected transient List<String> bTE = new ArrayList(5);

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afw();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afx();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void afy();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void hl(int i);

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
        if (bTF == null) {
            bTF = new WeakReference<>(tbPageContext);
            return;
        }
        bTF.clear();
        bTF = null;
        bTF = new WeakReference<>(tbPageContext);
    }

    public boolean afu() {
        return bTH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(boolean z) {
        this.bTG = z;
    }

    public void afr() {
        if (bTF != null) {
            bTF.get();
            bTF.clear();
            bTF = null;
        }
    }
}
