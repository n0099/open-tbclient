package com.baidu.tbadk.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b {
    protected static WeakReference<TbPageContext<?>> adl = null;
    protected static boolean adn = false;
    protected String adj = "183322726";
    protected boolean adm = true;
    protected transient List<String> adk = new ArrayList(5);

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bm(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void td();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void te();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void tf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void tg();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void th();

    /* JADX INFO: Access modifiers changed from: protected */
    public static b c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContext(TbPageContext<?> tbPageContext) {
        if (adl == null) {
            adl = new WeakReference<>(tbPageContext);
            return;
        }
        adl.clear();
        adl = null;
        adl = new WeakReference<>(tbPageContext);
    }

    public boolean tc() {
        return adn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(boolean z) {
        this.adm = z;
    }

    public void sY() {
        if (adl != null) {
            adl.get();
            adl.clear();
            adl = null;
        }
    }
}
