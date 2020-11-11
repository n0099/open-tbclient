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
    private w aKv;
    private ViewGroup bJN;
    private boolean bss;
    private TbPageContext bwO;
    protected com.baidu.tieba.ala.headline.view.a gKR;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bwO = tbPageContext;
        this.mContext = this.bwO.getPageActivity();
        bUh();
    }

    private void bUh() {
        this.gKR = new com.baidu.tieba.ala.headline.view.a(this.bwO);
        this.gKR.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, w wVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aKv = wVar;
        if (viewGroup != null) {
            this.bJN = viewGroup;
            if (this.bJN.indexOfChild(this.gKR.getRootView()) < 0) {
                this.bJN.addView(this.gKR.getRootView(), layoutParams);
            }
            if (this.bJN.indexOfChild(this.gKR.bUl()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bJN.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bJN.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bJN.addView(this.gKR.bUl(), layoutParams2);
            }
            this.gKR.setOtherParams(str);
            if (x(wVar)) {
                this.gKR.y(wVar);
            }
        }
    }

    private boolean x(w wVar) {
        if (wVar == null || wVar.aJt == null) {
            this.gKR.mw(false);
            return false;
        }
        l lVar = wVar.aJt;
        if (lVar.serverTime == 0 || lVar.endTime == 0) {
            this.gKR.mw(false);
            return false;
        } else if (!wVar.aJt.aIl) {
            this.gKR.mw(false);
            return false;
        } else {
            if (this.gKR != null) {
                this.gKR.bUu();
            }
            this.bss = true;
            return true;
        }
    }

    @Override // com.baidu.live.i.a
    public void a(w wVar) {
        this.aKv = wVar;
        if (x(wVar) && this.gKR != null) {
            this.gKR.y(wVar);
        }
    }

    @Override // com.baidu.live.i.a
    public void l(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && this.bss && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aQ(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aQ(JSONObject jSONObject) {
        if (this.aKv != null && this.bss && jSONObject != null && jSONObject.has("headline")) {
            l lVar = new l();
            lVar.serverTime = jSONObject.optLong("sysTime");
            lVar.parser(jSONObject.optJSONObject("headline"));
            this.aKv.aJt = lVar;
            this.gKR.y(this.aKv);
        }
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.aKv != null && this.aKv.aJt != null && x(this.aKv) && this.gKR.getRootView() != null) {
            if (z) {
                this.gKR.getRootView().setVisibility(0);
            } else {
                this.gKR.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.i.a
    public boolean isShowing() {
        return this.bss;
    }

    @Override // com.baidu.live.i.a
    public void KJ() {
        this.bss = false;
        if (this.gKR != null) {
            this.gKR.KN();
        }
    }

    @Override // com.baidu.live.i.a
    public void dX(int i) {
        if (this.bJN != null && this.gKR != null) {
            ViewGroup.LayoutParams layoutParams = this.gKR.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.gKR.dX(i);
        }
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        this.bss = false;
        if (this.gKR != null) {
            this.gKR.onDestory();
        }
    }

    @Override // com.baidu.live.i.a
    public void onResume() {
    }

    @Override // com.baidu.live.i.a
    public void onPause() {
    }
}
