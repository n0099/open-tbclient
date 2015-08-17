package com.baidu.tieba.frs.h5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends bc<g, k> {
    private final LinkedList<BaseWebView> aZQ;
    private final LinkedList<c> aZR;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aZQ = new LinkedList<>();
        this.aZR = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public k a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(i.d.ds18)));
        al.j(view, i.c.cp_bg_line_c);
        c cVar = new c(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(cVar);
        this.aZQ.add(cVar.getWebView());
        this.aZR.add(cVar);
        return new k(linearLayout, cVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, k kVar) {
        c cVar = kVar.aZW;
        if (cVar == null) {
            return null;
        }
        BaseWebView webView = cVar.getWebView();
        webView.setOnLoadUrlListener(new b(this));
        webView.setHorizontalScrollBarEnabled(false);
        CompatibleUtile.getInstance().loadUrl(webView, gVar.url);
        if (kVar.Xi != null) {
            al.j(kVar.Xi, i.c.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bc
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.aZQ.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.aZQ.clear();
        Iterator<c> it2 = this.aZR.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.aZR.clear();
    }
}
