package com.baidu.tieba.frs.b;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends av<h, j> {
    private final LinkedList<BaseWebView> bZH;
    private final LinkedList<d> bZI;
    private XiubaTbJsBridge bZJ;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bZH = new LinkedList<>();
        this.bZI = new LinkedList<>();
    }

    @Override // com.baidu.tieba.frs.av
    public void e(BaseActivity<?> baseActivity) {
        super.e(baseActivity);
        if (this.bZJ == null && baseActivity != null) {
            this.bZJ = new XiubaTbJsBridge(baseActivity.getPageContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(w.f.ds18)));
        aq.k(view, w.e.cp_bg_line_c);
        d dVar = new d(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(dVar);
        this.bZH.add(dVar.getWebView());
        this.bZI.add(dVar);
        return new j(linearLayout, dVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, j jVar) {
        d dVar = jVar.bZR;
        if (dVar == null) {
            return null;
        }
        BaseWebView webView = dVar.getWebView();
        if (jVar.abt != null) {
            aq.k(jVar.abt, w.e.cp_bg_line_c);
        }
        if (!webView.getIsLoaded()) {
            this.bZJ.setBaseWebView(webView);
            webView.setWebChromeClient(new b(this));
            webView.setOnLoadUrlListener(new c(this, hVar));
            webView.setHorizontalScrollBarEnabled(false);
            if (!dVar.adF() && hVar != null) {
                CompatibleUtile.getInstance().loadUrl(webView, hVar.url);
                dVar.setWebViewLoading(true);
                return view;
            }
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.av
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bZH.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bZH.clear();
        Iterator<d> it2 = this.bZI.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bZI.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("interfaceName");
            String optString2 = jSONObject.optString("methodName");
            String optString3 = jSONObject.optString("param");
            if (StringUtils.isNull(optString) || StringUtils.isNull(optString2) || StringUtils.isNull(optString3)) {
                return false;
            }
            return this.bZJ.dealJsInterface(optString, optString2, optString3, jsPromptResult);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
