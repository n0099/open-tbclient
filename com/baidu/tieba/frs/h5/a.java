package com.baidu.tieba.frs.h5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends bx<g, k> {
    private final LinkedList<BaseWebView> bsJ;
    private final LinkedList<c> bsK;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bsJ = new LinkedList<>();
        this.bsK = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public k b(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(t.e.ds18)));
        at.l(view, t.d.cp_bg_line_c);
        c cVar = new c(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(cVar);
        this.bsJ.add(cVar.getWebView());
        this.bsK.add(cVar);
        return new k(linearLayout, cVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, k kVar) {
        c cVar = kVar.bsR;
        if (cVar == null) {
            return null;
        }
        BaseWebView webView = cVar.getWebView();
        webView.setOnLoadUrlListener(new b(this, gVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!cVar.SW() && gVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, gVar.url);
            cVar.setWebViewLoading(true);
        }
        if (kVar.Xu != null) {
            at.l(kVar.Xu, t.d.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bx
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bsJ.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bsJ.clear();
        Iterator<c> it2 = this.bsK.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bsK.clear();
    }
}
