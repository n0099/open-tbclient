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
/* loaded from: classes8.dex */
public class a {
    private TbPageContext<?> eWx;
    private View rootView;
    Pattern iZO = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> akS = null;
    private c iZP = null;
    private d<com.baidu.tbadk.core.flow.a.a> eYF = new d<com.baidu.tbadk.core.flow.a.a>() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.2
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            c.a aVar = (c.a) a.this.akS.op(i);
            if (aVar != null) {
                Matcher matcher = a.this.iZO.matcher(aVar.blN());
                if (matcher.find()) {
                    a.this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(a.this.eWx.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
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
        this.eWx = null;
        this.eWx = tbPageContext;
        initUI();
    }

    private void initUI() {
        if (this.eWx != null) {
            this.rootView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
            if (this.rootView != null) {
                this.akS = (CoverFlowView) this.rootView.findViewById(R.id.square_banner_cover_flow_view);
                b bVar = new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.1
                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public e tt() {
                        e eVar = new e();
                        eVar.setHeight((int) (l.getEquipmentWidth(a.this.eWx.getPageActivity()) / 2.5714285f));
                        return eVar;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public com.baidu.tbadk.core.flow.a.c tu() {
                        com.baidu.tbadk.core.flow.a.c tu = super.tu();
                        if (tu != null) {
                            tu.setGravity(81);
                            tu.os(R.dimen.ds20);
                        }
                        return tu;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public TbImageView U(Context context) {
                        TbImageView tbImageView = new TbImageView(context);
                        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        tbImageView.setGifIconSupport(false);
                        return tbImageView;
                    }
                };
                this.akS.setDisableParentEvent(false);
                this.akS.setCoverFlowFactory(bVar);
                this.akS.setCallback(this.eYF);
            }
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void bvy() {
        if (this.akS != null) {
            this.akS.brj();
        }
    }

    public void a(c cVar) {
        if (cVar != null && cVar != this.iZP) {
            this.akS.setData(cVar.cAh());
            this.iZP = cVar;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
