package com.baidu.tieba.frs.h5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.bn;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends bn<g, k> {
    private final LinkedList<BaseWebView> bam;
    private final LinkedList<c> ban;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bam = new LinkedList<>();
        this.ban = new LinkedList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public k a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(i.d.ds18)));
        an.j(view, i.c.cp_bg_line_c);
        c cVar = new c(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(cVar);
        this.bam.add(cVar.getWebView());
        this.ban.add(cVar);
        return new k(linearLayout, cVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, k kVar) {
        c cVar = kVar.bav;
        if (cVar == null) {
            return null;
        }
        BaseWebView webView = cVar.getWebView();
        webView.setOnLoadUrlListener(new b(this, gVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!cVar.MX() && gVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, gVar.url);
            cVar.setWebViewLoading(true);
        }
        if (kVar.Xl != null) {
            an.j(kVar.Xl, i.c.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bn
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bam.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bam.clear();
        Iterator<c> it2 = this.ban.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.ban.clear();
    }
}
