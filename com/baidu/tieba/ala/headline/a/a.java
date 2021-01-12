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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.l.a {
    private x aHu;
    private TbPageContext bAo;
    private ViewGroup bNl;
    private boolean bvR;
    protected com.baidu.tieba.ala.headline.view.a haT;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bAo = tbPageContext;
        this.mContext = this.bAo.getPageActivity();
        bVZ();
    }

    private void bVZ() {
        this.haT = new com.baidu.tieba.ala.headline.view.a(this.bAo);
        this.haT.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.l.a
    public void a(ViewGroup viewGroup, x xVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aHu = xVar;
        if (viewGroup != null) {
            this.bNl = viewGroup;
            if (this.bNl.indexOfChild(this.haT.getRootView()) < 0) {
                this.bNl.addView(this.haT.getRootView(), layoutParams);
            }
            if (this.bNl.indexOfChild(this.haT.bWc()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bNl.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bNl.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bNl.addView(this.haT.bWc(), layoutParams2);
            }
            this.haT.setOtherParams(str);
            if (z(xVar)) {
                this.haT.b(xVar, false);
            }
        }
    }

    private boolean z(x xVar) {
        if (xVar == null || xVar.aGf == null) {
            this.haT.no(false);
            return false;
        }
        m mVar = xVar.aGf;
        if (mVar.serverTime == 0 || mVar.endTime == 0) {
            this.haT.no(false);
            return false;
        } else if (!xVar.aGf.aEV) {
            this.haT.no(false);
            return false;
        } else {
            if (this.haT != null) {
                this.haT.bWl();
            }
            this.bvR = true;
            return true;
        }
    }

    @Override // com.baidu.live.l.a
    public void a(x xVar) {
        this.aHu = xVar;
        if (z(xVar) && this.haT != null) {
            this.haT.b(xVar, false);
        }
    }

    @Override // com.baidu.live.l.a
    public void l(b bVar) {
        JSONObject jSONObject;
        if (bVar != null && this.bvR && bVar.getMsgType() == 13) {
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
        if (this.aHu != null && this.bvR && jSONObject != null && jSONObject.has("headline")) {
            m mVar = new m();
            mVar.serverTime = jSONObject.optLong("sysTime");
            mVar.parser(jSONObject.optJSONObject("headline"));
            this.aHu.aGf = mVar;
            this.haT.b(this.aHu, true);
        }
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.aHu != null && this.aHu.aGf != null && z(this.aHu) && this.haT.getRootView() != null) {
            if (z) {
                this.haT.getRootView().setVisibility(0);
            } else {
                this.haT.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.l.a
    public boolean isShowing() {
        return this.bvR;
    }

    @Override // com.baidu.live.l.a
    public void xk() {
        this.bvR = false;
        if (this.haT != null) {
            this.haT.HJ();
        }
    }

    @Override // com.baidu.live.l.a
    public void cF(int i) {
        if (this.bNl != null && this.haT != null) {
            ViewGroup.LayoutParams layoutParams = this.haT.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.haT.cF(i);
        }
    }

    @Override // com.baidu.live.l.a
    public void onDestroy() {
        this.bvR = false;
        if (this.haT != null) {
            this.haT.onDestory();
        }
    }

    @Override // com.baidu.live.l.a
    public void onResume() {
    }

    @Override // com.baidu.live.l.a
    public void onPause() {
    }
}
