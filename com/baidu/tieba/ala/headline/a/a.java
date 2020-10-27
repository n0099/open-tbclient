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
    private w aJv;
    private ViewGroup bEg;
    private boolean bqZ;
    private TbPageContext gFe;
    protected com.baidu.tieba.ala.headline.view.a gFf;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.gFe = tbPageContext;
        this.mContext = this.gFe.getPageActivity();
        bRI();
    }

    private void bRI() {
        this.gFf = new com.baidu.tieba.ala.headline.view.a(this.gFe);
        this.gFf.getRootView().setId(a.g.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, w wVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aJv = wVar;
        if (viewGroup != null) {
            this.bEg = viewGroup;
            if (this.bEg.indexOfChild(this.gFf.getRootView()) < 0) {
                this.bEg.addView(this.gFf.getRootView(), layoutParams);
            }
            if (this.bEg.indexOfChild(this.gFf.bRM()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bEg.getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds300), this.bEg.getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.g.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bEg.addView(this.gFf.bRM(), layoutParams2);
            }
            this.gFf.setOtherParams(str);
            if (s(wVar)) {
                this.gFf.t(wVar);
            }
        }
    }

    private boolean s(w wVar) {
        if (wVar == null || wVar.aIC == null) {
            this.gFf.mn(false);
            return false;
        }
        l lVar = wVar.aIC;
        if (lVar.serverTime == 0 || lVar.endTime == 0) {
            this.gFf.mn(false);
            return false;
        } else if (!wVar.aIC.aHt) {
            this.gFf.mn(false);
            return false;
        } else {
            if (this.gFf != null) {
                this.gFf.bRV();
            }
            this.bqZ = true;
            return true;
        }
    }

    @Override // com.baidu.live.i.a
    public void a(w wVar) {
        this.aJv = wVar;
        if (s(wVar) && this.gFf != null) {
            this.gFf.t(wVar);
        }
    }

    @Override // com.baidu.live.i.a
    public void l(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && this.bqZ && aVar.getMsgType() == 13) {
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
        if (this.aJv != null && this.bqZ && jSONObject != null && jSONObject.has("headline")) {
            l lVar = new l();
            lVar.serverTime = jSONObject.optLong("sysTime");
            lVar.parser(jSONObject.optJSONObject("headline"));
            this.aJv.aIC = lVar;
            this.gFf.t(this.aJv);
        }
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.aJv != null && this.aJv.aIC != null && s(this.aJv) && this.gFf.getRootView() != null) {
            if (z) {
                this.gFf.getRootView().setVisibility(0);
            } else {
                this.gFf.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.i.a
    public boolean isShowing() {
        return this.bqZ;
    }

    @Override // com.baidu.live.i.a
    public void Kj() {
        this.bqZ = false;
        if (this.gFf != null) {
            this.gFf.Kn();
        }
    }

    @Override // com.baidu.live.i.a
    public void dX(int i) {
        if (this.bEg != null && this.gFf != null) {
            ViewGroup.LayoutParams layoutParams = this.gFf.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.g.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.g.ala_liveroom_hostheader);
            }
            this.gFf.dX(i);
        }
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        this.bqZ = false;
        if (this.gFf != null) {
            this.gFf.onDestory();
        }
    }

    @Override // com.baidu.live.i.a
    public void onResume() {
    }

    @Override // com.baidu.live.i.a
    public void onPause() {
    }
}
