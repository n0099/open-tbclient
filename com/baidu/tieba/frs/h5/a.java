package com.baidu.tieba.frs.h5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends bp<g, k> {
    private final LinkedList<BaseWebView> bkP;
    private final LinkedList<c> bkQ;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkP = new LinkedList<>();
        this.bkQ = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public k a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(n.e.ds18)));
        as.j(view, n.d.cp_bg_line_c);
        c cVar = new c(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(cVar);
        this.bkP.add(cVar.getWebView());
        this.bkQ.add(cVar);
        return new k(linearLayout, cVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, k kVar) {
        c cVar = kVar.bkX;
        if (cVar == null) {
            return null;
        }
        BaseWebView webView = cVar.getWebView();
        webView.setOnLoadUrlListener(new b(this, gVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!cVar.Pf() && gVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, gVar.url);
            cVar.setWebViewLoading(true);
        }
        if (kVar.YE != null) {
            as.j(kVar.YE, n.d.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bp
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bkP.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bkP.clear();
        Iterator<c> it2 = this.bkQ.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bkQ.clear();
    }
}
