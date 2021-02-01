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
    private TbPageContext<?> eUY;
    private View rootView;
    Pattern iXR = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> ajA = null;
    private c iXS = null;
    private d<com.baidu.tbadk.core.flow.a.a> eXg = new d<com.baidu.tbadk.core.flow.a.a>() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.2
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            c.a aVar = (c.a) a.this.ajA.oo(i);
            if (aVar != null) {
                Matcher matcher = a.this.iXR.matcher(aVar.blL());
                if (matcher.find()) {
                    a.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(a.this.eUY.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
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
        this.eUY = null;
        this.eUY = tbPageContext;
        initUI();
    }

    private void initUI() {
        if (this.eUY != null) {
            this.rootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
            if (this.rootView != null) {
                this.ajA = (CoverFlowView) this.rootView.findViewById(R.id.square_banner_cover_flow_view);
                b bVar = new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.1
                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public e tt() {
                        e eVar = new e();
                        eVar.setHeight((int) (l.getEquipmentWidth(a.this.eUY.getPageActivity()) / 2.5714285f));
                        return eVar;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public com.baidu.tbadk.core.flow.a.c tu() {
                        com.baidu.tbadk.core.flow.a.c tu = super.tu();
                        if (tu != null) {
                            tu.setGravity(81);
                            tu.or(R.dimen.ds20);
                        }
                        return tu;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public TbImageView V(Context context) {
                        TbImageView tbImageView = new TbImageView(context);
                        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        tbImageView.setGifIconSupport(false);
                        return tbImageView;
                    }
                };
                this.ajA.setDisableParentEvent(false);
                this.ajA.setCoverFlowFactory(bVar);
                this.ajA.setCallback(this.eXg);
            }
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void bvv() {
        if (this.ajA != null) {
            this.ajA.bri();
        }
    }

    public void a(c cVar) {
        if (cVar != null && cVar != this.iXS) {
            this.ajA.setData(cVar.czU());
            this.iXS = cVar;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
