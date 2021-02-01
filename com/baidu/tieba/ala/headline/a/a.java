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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.k.a {
    private ab aJZ;
    private TbPageContext bDU;
    private ViewGroup bRb;
    private boolean bzt;
    protected com.baidu.tieba.ala.headline.view.a hdD;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bDU = tbPageContext;
        this.mContext = this.bDU.getPageActivity();
        bWD();
    }

    private void bWD() {
        this.hdD = new com.baidu.tieba.ala.headline.view.a(this.bDU);
        this.hdD.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.k.a
    public void a(ViewGroup viewGroup, ab abVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aJZ = abVar;
        if (viewGroup != null) {
            this.bRb = viewGroup;
            if (this.bRb.indexOfChild(this.hdD.getRootView()) < 0) {
                this.bRb.addView(this.hdD.getRootView(), layoutParams);
            }
            if (this.bRb.indexOfChild(this.hdD.bWG()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bRb.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bRb.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bRb.addView(this.hdD.bWG(), layoutParams2);
            }
            this.hdD.setOtherParams(str);
            if (z(abVar)) {
                this.hdD.b(abVar, false);
            }
        }
    }

    private boolean z(ab abVar) {
        if (abVar == null || abVar.aIB == null) {
            this.hdD.nt(false);
            return false;
        }
        q qVar = abVar.aIB;
        if (qVar.serverTime == 0 || qVar.endTime == 0) {
            this.hdD.nt(false);
            return false;
        } else if (!abVar.aIB.aHr) {
            this.hdD.nt(false);
            return false;
        } else {
            if (this.hdD != null) {
                this.hdD.bWP();
            }
            this.bzt = true;
            return true;
        }
    }

    @Override // com.baidu.live.k.a
    public void a(ab abVar) {
        this.aJZ = abVar;
        if (z(abVar) && this.hdD != null) {
            this.hdD.b(abVar, false);
        }
    }

    @Override // com.baidu.live.k.a
    public void l(b bVar) {
        JSONObject jSONObject;
        if (bVar != null && this.bzt && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aR(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aR(JSONObject jSONObject) {
        if (this.aJZ != null && this.bzt && jSONObject != null && jSONObject.has("headline")) {
            q qVar = new q();
            qVar.serverTime = jSONObject.optLong("sysTime");
            qVar.parser(jSONObject.optJSONObject("headline"));
            this.aJZ.aIB = qVar;
            this.hdD.b(this.aJZ, true);
        }
    }

    @Override // com.baidu.live.k.a
    public void setCanVisible(boolean z) {
        if (this.aJZ != null && this.aJZ.aIB != null && z(this.aJZ) && this.hdD.getRootView() != null) {
            if (z) {
                this.hdD.getRootView().setVisibility(0);
            } else {
                this.hdD.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.k.a
    public boolean isShowing() {
        return this.bzt;
    }

    @Override // com.baidu.live.k.a
    public void xh() {
        this.bzt = false;
        if (this.hdD != null) {
            this.hdD.IZ();
        }
    }

    @Override // com.baidu.live.k.a
    public void cK(int i) {
        if (this.bRb != null && this.hdD != null) {
            ViewGroup.LayoutParams layoutParams = this.hdD.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.hdD.cK(i);
        }
    }

    @Override // com.baidu.live.k.a
    public void onDestroy() {
        this.bzt = false;
        if (this.hdD != null) {
            this.hdD.onDestory();
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
    }
}
