package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public cb gyA;
    private boolean gyL;
    public int locate;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eQK;
    }

    public ar az(String str, boolean z) {
        if (this.gyA == null) {
            return null;
        }
        int i = 1;
        if (this.gyA.bpe()) {
            i = 2;
        } else if (this.gyA.bpi() != null && this.gyA.bpi().eUx != 0) {
            i = 3;
        }
        ar dR = new ar(str).dR("tid", this.gyA.getTid()).ap("obj_type", i).dR("obj_param1", this.gyA.mRecomWeight).dR("obj_source", this.gyA.mRecomSource).ap("obj_locate", this.locate).dR("ab_tag", this.gyA.mRecomAbTag).dR(TiebaInitialize.Params.OBJ_PARAM3, getAspectRatio() > 1.0f ? "1" : "0");
        if (z) {
            dR.dR(TiebaInitialize.Params.OBJ_PARAM2, this.gyA.boe() > 0 ? "0" : "1");
        }
        return dR;
    }

    public float getAspectRatio() {
        if (this.gyA == null || this.gyA.boh() == null || this.gyA.boh().video_height.intValue() <= 0) {
            return 0.0f;
        }
        return this.gyA.boh().video_width.intValue() / this.gyA.boh().video_height.intValue();
    }

    public boolean bQZ() {
        return this.gyL;
    }
}
