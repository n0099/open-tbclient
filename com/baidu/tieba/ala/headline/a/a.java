package com.baidu.tieba.ala.headline.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.k.a {
    private w aLD;
    private TbPageContext bAn;
    private ViewGroup bNk;
    private boolean bvS;
    protected com.baidu.tieba.ala.headline.view.a gTK;
    private Context mContext;

    public a(TbPageContext tbPageContext) {
        this.bAn = tbPageContext;
        this.mContext = this.bAn.getPageActivity();
        bXk();
    }

    private void bXk() {
        this.gTK = new com.baidu.tieba.ala.headline.view.a(this.bAn);
        this.gTK.getRootView().setId(a.f.ala_head_line_entry_id);
    }

    @Override // com.baidu.live.k.a
    public void a(ViewGroup viewGroup, w wVar, ViewGroup.LayoutParams layoutParams, String str) {
        this.aLD = wVar;
        if (viewGroup != null) {
            this.bNk = viewGroup;
            if (this.bNk.indexOfChild(this.gTK.getRootView()) < 0) {
                this.bNk.addView(this.gTK.getRootView(), layoutParams);
            }
            if (this.bNk.indexOfChild(this.gTK.bXn()) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.bNk.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds300), this.bNk.getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds150));
                layoutParams2.addRule(11);
                layoutParams2.addRule(3, a.f.ala_liveroom_hostheader);
                layoutParams2.topMargin = -BdUtilHelper.dip2px(this.mContext, 20.0f);
                this.bNk.addView(this.gTK.bXn(), layoutParams2);
            }
            this.gTK.setOtherParams(str);
            if (y(wVar)) {
                this.gTK.z(wVar);
            }
        }
    }

    private boolean y(w wVar) {
        if (wVar == null || wVar.aKt == null) {
            this.gTK.mS(false);
            return false;
        }
        l lVar = wVar.aKt;
        if (lVar.serverTime == 0 || lVar.endTime == 0) {
            this.gTK.mS(false);
            return false;
        } else if (!wVar.aKt.aJk) {
            this.gTK.mS(false);
            return false;
        } else {
            if (this.gTK != null) {
                this.gTK.bXw();
            }
            this.bvS = true;
            return true;
        }
    }

    @Override // com.baidu.live.k.a
    public void a(w wVar) {
        this.aLD = wVar;
        if (y(wVar) && this.gTK != null) {
            this.gTK.z(wVar);
        }
    }

    @Override // com.baidu.live.k.a
    public void l(b bVar) {
        JSONObject jSONObject;
        if (bVar != null && this.bvS && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "headline_data_im".equals(jSONObject.optString("content_type"))) {
                    aM(jSONObject.optJSONObject("content_data"));
                }
            } catch (JSONException e) {
            }
        }
    }

    private void aM(JSONObject jSONObject) {
        if (this.aLD != null && this.bvS && jSONObject != null && jSONObject.has("headline")) {
            l lVar = new l();
            lVar.serverTime = jSONObject.optLong("sysTime");
            lVar.parser(jSONObject.optJSONObject("headline"));
            this.aLD.aKt = lVar;
            this.gTK.z(this.aLD);
        }
    }

    @Override // com.baidu.live.k.a
    public void setCanVisible(boolean z) {
        if (this.aLD != null && this.aLD.aKt != null && y(this.aLD) && this.gTK.getRootView() != null) {
            if (z) {
                this.gTK.getRootView().setVisibility(0);
            } else {
                this.gTK.getRootView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.live.k.a
    public boolean isShowing() {
        return this.bvS;
    }

    @Override // com.baidu.live.k.a
    public void Do() {
        this.bvS = false;
        if (this.gTK != null) {
            this.gTK.Mg();
        }
    }

    @Override // com.baidu.live.k.a
    public void en(int i) {
        if (this.bNk != null && this.gTK != null) {
            ViewGroup.LayoutParams layoutParams = this.gTK.getRootView().getLayoutParams();
            if (i == 2) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_audience_count_layout);
                }
            } else if (i == 1 && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, a.f.ala_liveroom_hostheader);
            }
            this.gTK.en(i);
        }
    }

    @Override // com.baidu.live.k.a
    public void onDestroy() {
        this.bvS = false;
        if (this.gTK != null) {
            this.gTK.onDestory();
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
    }
}
