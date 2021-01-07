package com.baidu.tieba.faceshop.emotioncenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.data.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext<?> eXu;
    private View rootView;
    Pattern iWR = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> akC = null;
    private c iWS = null;
    private d<com.baidu.tbadk.core.flow.a.a> eZB = new d<com.baidu.tbadk.core.flow.a.a>() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.2
        @Override // com.baidu.tbadk.core.flow.a.d
        public void e(int i, String str) {
            c.a aVar = (c.a) a.this.akC.pQ(i);
            if (aVar != null) {
                Matcher matcher = a.this.iWR.matcher(aVar.bpn());
                if (matcher.find()) {
                    a.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(a.this.eXu.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
                }
            }
        }

        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
            if (aVar != null && (aVar instanceof c.a)) {
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eXu = null;
        this.eXu = tbPageContext;
        initUI();
    }

    private void initUI() {
        if (this.eXu != null) {
            this.rootView = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
            if (this.rootView != null) {
                this.akC = (CoverFlowView) this.rootView.findViewById(R.id.square_banner_cover_flow_view);
                b bVar = new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.1
                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public e tH() {
                        e eVar = new e();
                        eVar.setHeight((int) (l.getEquipmentWidth(a.this.eXu.getPageActivity()) / 2.5714285f));
                        return eVar;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public com.baidu.tbadk.core.flow.a.c tI() {
                        com.baidu.tbadk.core.flow.a.c tI = super.tI();
                        if (tI != null) {
                            tI.setGravity(81);
                            tI.pT(R.dimen.ds20);
                        }
                        return tI;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public TbImageView W(Context context) {
                        TbImageView tbImageView = new TbImageView(context);
                        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        tbImageView.setGifIconSupport(false);
                        return tbImageView;
                    }
                };
                this.akC.setDisableParentEvent(false);
                this.akC.setCoverFlowFactory(bVar);
                this.akC.setCallback(this.eZB);
            }
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void byV() {
        if (this.akC != null) {
            this.akC.buJ();
        }
    }

    public void a(c cVar) {
        if (cVar != null && cVar != this.iWS) {
            this.akC.setData(cVar.cCB());
            this.iWS = cVar;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
