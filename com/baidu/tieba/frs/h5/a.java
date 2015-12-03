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
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends bm<g, k> {
    private final LinkedList<BaseWebView> bgY;
    private final LinkedList<c> bgZ;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bgY = new LinkedList<>();
        this.bgZ = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public k a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(n.d.ds18)));
        as.j(view, n.c.cp_bg_line_c);
        c cVar = new c(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(cVar);
        this.bgY.add(cVar.getWebView());
        this.bgZ.add(cVar);
        return new k(linearLayout, cVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, k kVar) {
        c cVar = kVar.bhg;
        if (cVar == null) {
            return null;
        }
        BaseWebView webView = cVar.getWebView();
        webView.setOnLoadUrlListener(new b(this, gVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!cVar.ON() && gVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, gVar.url);
            cVar.setWebViewLoading(true);
        }
        if (kVar.Yb != null) {
            as.j(kVar.Yb, n.c.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bm
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bgY.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bgY.clear();
        Iterator<c> it2 = this.bgZ.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bgZ.clear();
    }
}
