package com.baidu.tieba.ala.headline.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.data.x;
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.l.a {
    private x aMh;
    private boolean bAD;
    private TbPageContext bFa;
    private ViewGroup bRX;
    protected com.baidu.tieba.ala.headline.view.a hfz;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bFa = tbPageContext;
        this.mContext = this.bFa.getPageActivity();
        bZQ();
    }

    private void bZQ() {
        this.hfz = new com.baidu.tieba.ala.headline.view.a(this.bFa);
        this.hfz.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.l.a
    public void a(ViewGroup viewGroup, x xVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aMh = xVar;
        if (viewGroup != null) {
            this.bRX = viewGroup;
            if (this.bRX.indexOfChild(this.hfz.getRootView()) < 0) {
                this.bRX.addView(this.hfz.getRootView(), layoutParams);
            }
            if (this.bRX.indexOfChild(this.hfz.bZT()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bRX.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bRX.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bRX.addView(this.hfz.bZT(), layoutParams2);
            }
            this.hfz.setOtherParams(str);
            if (z(xVar)) {
                this.hfz.b(xVar, false);
            }
        }
    }

    private boolean z(x xVar) {
        if (xVar == null || xVar.aKS == null) {
            this.hfz.ns(false);
            return false;
        }
        m mVar = xVar.aKS;
        if (mVar.serverTime == 0 || mVar.endTime == 0) {
            this.hfz.ns(false);
            return false;
        } else if (!xVar.aKS.aJI) {
            this.hfz.ns(false);
            return false;
        } else {
            if (this.hfz != null) {
                this.hfz.cac();
            }
            this.bAD = true;
            return true;
        }
    }

    @Override // com.baidu.live.l.a
    public void a(x xVar) {
        this.aMh = xVar;
        if (z(xVar) && this.hfz != null) {
            this.hfz.b(xVar, false);
        }
    }

    @Override // com.baidu.live.l.a
    public void l(b bVar) {
        JSONObject jSONObject;
        if (bVar != null && this.bAD && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aU(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aU(JSONObject jSONObject) {
        if (this.aMh != null && this.bAD && jSONObject != null && jSONObject.has("headline")) {
            m mVar = new m();
            mVar.serverTime = jSONObject.optLong("sysTime");
            mVar.parser(jSONObject.optJSONObject("headline"));
            this.aMh.aKS = mVar;
            this.hfz.b(this.aMh, true);
        }
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.aMh != null && this.aMh.aKS != null && z(this.aMh) && this.hfz.getRootView() != null) {
            if (z) {
                this.hfz.getRootView().setVisibility(0);
            } else {
                this.hfz.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.l.a
    public boolean isShowing() {
        return this.bAD;
    }

    @Override // com.baidu.live.l.a
    public void Bf() {
        this.bAD = false;
        if (this.hfz != null) {
            this.hfz.LE();
        }
    }

    @Override // com.baidu.live.l.a
    public void el(int i) {
        if (this.bRX != null && this.hfz != null) {
            ViewGroup.LayoutParams layoutParams = this.hfz.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.hfz.el(i);
        }
    }

    @Override // com.baidu.live.l.a
    public void onDestroy() {
        this.bAD = false;
        if (this.hfz != null) {
            this.hfz.onDestory();
        }
    }

    @Override // com.baidu.live.l.a
    public void onResume() {
    }

    @Override // com.baidu.live.l.a
    public void onPause() {
    }
}
