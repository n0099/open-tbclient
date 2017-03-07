package com.baidu.tieba.frs.h5;

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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends at<h, l> {
    private final LinkedList<BaseWebView> bXB;
    private final LinkedList<d> bXC;
    private XiubaTbJsBridge bXD;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bXB = new LinkedList<>();
        this.bXC = new LinkedList<>();
    }

    @Override // com.baidu.tieba.frs.at
    public void e(BaseActivity<?> baseActivity) {
        super.e(baseActivity);
        if (this.bXD == null && baseActivity != null) {
            this.bXD = new XiubaTbJsBridge(baseActivity.getPageContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(w.f.ds18)));
        aq.k(view, w.e.cp_bg_line_c);
        d dVar = new d(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(dVar);
        this.bXB.add(dVar.getWebView());
        this.bXC.add(dVar);
        return new l(linearLayout, dVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, l lVar) {
        d dVar = lVar.bXL;
        if (dVar == null) {
            return null;
        }
        BaseWebView webView = dVar.getWebView();
        this.bXD.setBaseWebView(webView);
        webView.setWebChromeClient(new b(this));
        webView.setOnLoadUrlListener(new c(this, hVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!dVar.aci() && hVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, hVar.url);
            dVar.setWebViewLoading(true);
        }
        if (lVar.abc != null) {
            aq.k(lVar.abc, w.e.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.at
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bXB.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bXB.clear();
        Iterator<d> it2 = this.bXC.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bXC.clear();
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
            return this.bXD.dealJsInterface(optString, optString2, optString3, jsPromptResult);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
