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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.u;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends bj<h, l> {
    private final LinkedList<BaseWebView> bPL;
    private final LinkedList<d> bPM;
    private XiubaTbJsBridge bPN;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bPL = new LinkedList<>();
        this.bPM = new LinkedList<>();
    }

    @Override // com.baidu.tieba.frs.bj
    public void e(BaseActivity<?> baseActivity) {
        super.e(baseActivity);
        if (this.bPN == null && baseActivity != null) {
            this.bPN = new XiubaTbJsBridge(baseActivity.getPageContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public l a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelOffset(u.e.ds18)));
        av.l(view, u.d.cp_bg_line_c);
        d dVar = new d(this.mContext);
        linearLayout.addView(view);
        linearLayout.addView(dVar);
        this.bPL.add(dVar.getWebView());
        this.bPM.add(dVar);
        return new l(linearLayout, dVar, view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, l lVar) {
        d dVar = lVar.bPV;
        if (dVar == null) {
            return null;
        }
        BaseWebView webView = dVar.getWebView();
        this.bPN.setBaseWebView(webView);
        webView.setWebChromeClient(new b(this));
        webView.setOnLoadUrlListener(new c(this, hVar));
        webView.setHorizontalScrollBarEnabled(false);
        if (!dVar.Zp() && hVar != null) {
            CompatibleUtile.getInstance().loadUrl(webView, hVar.url);
            dVar.setWebViewLoading(true);
        }
        if (lVar.TH != null) {
            av.l(lVar.TH, u.d.cp_bg_line_c);
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.frs.bj
    public void release() {
        super.release();
        Iterator<BaseWebView> it = this.bPL.iterator();
        while (it.hasNext()) {
            BaseWebView next = it.next();
            if (next != null) {
                next.removeAllViews();
                next.destroy();
            }
        }
        this.bPL.clear();
        Iterator<d> it2 = this.bPM.iterator();
        while (it2.hasNext()) {
            it2.next().removeAllViews();
        }
        this.bPM.clear();
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
            return this.bPN.dealJsInterface(optString, optString2, optString3, jsPromptResult);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
