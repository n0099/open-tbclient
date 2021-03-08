package com.baidu.tieba.ala.headline.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.q;
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.k.a {
    private ab aLz;
    private boolean bAT;
    private TbPageContext bFu;
    private ViewGroup bSB;
    protected com.baidu.tieba.ala.headline.view.a hfA;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bFu = tbPageContext;
        this.mContext = this.bFu.getPageActivity();
        bWQ();
    }

    private void bWQ() {
        this.hfA = new com.baidu.tieba.ala.headline.view.a(this.bFu);
        this.hfA.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.k.a
    public void a(ViewGroup viewGroup, ab abVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aLz = abVar;
        if (viewGroup != null) {
            this.bSB = viewGroup;
            if (this.bSB.indexOfChild(this.hfA.getRootView()) < 0) {
                this.bSB.addView(this.hfA.getRootView(), layoutParams);
            }
            if (this.bSB.indexOfChild(this.hfA.bWT()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bSB.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bSB.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bSB.addView(this.hfA.bWT(), layoutParams2);
            }
            this.hfA.setOtherParams(str);
            if (z(abVar)) {
                this.hfA.b(abVar, false);
            }
        }
    }

    private boolean z(ab abVar) {
        if (abVar == null || abVar.aKb == null) {
            this.hfA.nt(false);
            return false;
        }
        q qVar = abVar.aKb;
        if (qVar.serverTime == 0 || qVar.endTime == 0) {
            this.hfA.nt(false);
            return false;
        } else if (!abVar.aKb.aIR) {
            this.hfA.nt(false);
            return false;
        } else {
            if (this.hfA != null) {
                this.hfA.bXc();
            }
            this.bAT = true;
            return true;
        }
    }

    @Override // com.baidu.live.k.a
    public void a(ab abVar) {
        this.aLz = abVar;
        if (z(abVar) && this.hfA != null) {
            this.hfA.b(abVar, false);
        }
    }

    @Override // com.baidu.live.k.a
    public void l(b bVar) {
        JSONObject jSONObject;
        if (bVar != null && this.bAT && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aT(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aT(JSONObject jSONObject) {
        if (this.aLz != null && this.bAT && jSONObject != null && jSONObject.has("headline")) {
            q qVar = new q();
            qVar.serverTime = jSONObject.optLong("sysTime");
            qVar.parser(jSONObject.optJSONObject("headline"));
            this.aLz.aKb = qVar;
            this.hfA.b(this.aLz, true);
        }
    }

    @Override // com.baidu.live.k.a
    public void setCanVisible(boolean z) {
        if (this.aLz != null && this.aLz.aKb != null && z(this.aLz) && this.hfA.getRootView() != null) {
            if (z) {
                this.hfA.getRootView().setVisibility(0);
            } else {
                this.hfA.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.k.a
    public boolean isShowing() {
        return this.bAT;
    }

    @Override // com.baidu.live.k.a
    public void xk() {
        this.bAT = false;
        if (this.hfA != null) {
            this.hfA.Jc();
        }
    }

    @Override // com.baidu.live.k.a
    public void cL(int i) {
        if (this.bSB != null && this.hfA != null) {
            ViewGroup.LayoutParams layoutParams = this.hfA.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.hfA.cL(i);
        }
    }

    @Override // com.baidu.live.k.a
    public void onDestroy() {
        this.bAT = false;
        if (this.hfA != null) {
            this.hfA.onDestory();
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
    }
}
