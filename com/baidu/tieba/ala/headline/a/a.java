package com.baidu.tieba.ala.headline.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.i.a {
    private w aIK;
    private ViewGroup bIc;
    private boolean bqH;
    private TbPageContext bvd;
    protected com.baidu.tieba.ala.headline.view.a gKy;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bvd = tbPageContext;
        this.mContext = this.bvd.getPageActivity();
        bTA();
    }

    private void bTA() {
        this.gKy = new com.baidu.tieba.ala.headline.view.a(this.bvd);
        this.gKy.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, w wVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aIK = wVar;
        if (viewGroup != null) {
            this.bIc = viewGroup;
            if (this.bIc.indexOfChild(this.gKy.getRootView()) < 0) {
                this.bIc.addView(this.gKy.getRootView(), layoutParams);
            }
            if (this.bIc.indexOfChild(this.gKy.bTE()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bIc.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bIc.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bIc.addView(this.gKy.bTE(), layoutParams2);
            }
            this.gKy.setOtherParams(str);
            if (x(wVar)) {
                this.gKy.y(wVar);
            }
        }
    }

    private boolean x(w wVar) {
        if (wVar == null || wVar.aHI == null) {
            this.gKy.mx(false);
            return false;
        }
        l lVar = wVar.aHI;
        if (lVar.serverTime == 0 || lVar.endTime == 0) {
            this.gKy.mx(false);
            return false;
        } else if (!wVar.aHI.aGA) {
            this.gKy.mx(false);
            return false;
        } else {
            if (this.gKy != null) {
                this.gKy.bTN();
            }
            this.bqH = true;
            return true;
        }
    }

    @Override // com.baidu.live.i.a
    public void a(w wVar) {
        this.aIK = wVar;
        if (x(wVar) && this.gKy != null) {
            this.gKy.y(wVar);
        }
    }

    @Override // com.baidu.live.i.a
    public void l(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && this.bqH && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aK(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aK(JSONObject jSONObject) {
        if (this.aIK != null && this.bqH && jSONObject != null && jSONObject.has("headline")) {
            l lVar = new l();
            lVar.serverTime = jSONObject.optLong("sysTime");
            lVar.parser(jSONObject.optJSONObject("headline"));
            this.aIK.aHI = lVar;
            this.gKy.y(this.aIK);
        }
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.aIK != null && this.aIK.aHI != null && x(this.aIK) && this.gKy.getRootView() != null) {
            if (z) {
                this.gKy.getRootView().setVisibility(0);
            } else {
                this.gKy.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.i.a
    public boolean isShowing() {
        return this.bqH;
    }

    @Override // com.baidu.live.i.a
    public void Ka() {
        this.bqH = false;
        if (this.gKy != null) {
            this.gKy.Ke();
        }
    }

    @Override // com.baidu.live.i.a
    public void dT(int i) {
        if (this.bIc != null && this.gKy != null) {
            ViewGroup.LayoutParams layoutParams = this.gKy.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.gKy.dT(i);
        }
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        this.bqH = false;
        if (this.gKy != null) {
            this.gKy.onDestory();
        }
    }

    @Override // com.baidu.live.i.a
    public void onResume() {
    }

    @Override // com.baidu.live.i.a
    public void onPause() {
    }
}
