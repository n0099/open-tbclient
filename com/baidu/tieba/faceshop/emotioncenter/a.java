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
    private TbPageContext<?> eSJ;
    private View rootView;
    Pattern iSk = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> ajL = null;
    private c iSl = null;
    private d<com.baidu.tbadk.core.flow.a.a> eUQ = new d<com.baidu.tbadk.core.flow.a.a>() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.2
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            c.a aVar = (c.a) a.this.ajL.oj(i);
            if (aVar != null) {
                Matcher matcher = a.this.iSk.matcher(aVar.blt());
                if (matcher.find()) {
                    a.this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(a.this.eSJ.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
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
        this.eSJ = null;
        this.eSJ = tbPageContext;
        initUI();
    }

    private void initUI() {
        if (this.eSJ != null) {
            this.rootView = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
            if (this.rootView != null) {
                this.ajL = (CoverFlowView) this.rootView.findViewById(R.id.square_banner_cover_flow_view);
                b bVar = new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.a.1
                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public e tw() {
                        e eVar = new e();
                        eVar.setHeight((int) (l.getEquipmentWidth(a.this.eSJ.getPageActivity()) / 2.5714285f));
                        return eVar;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public com.baidu.tbadk.core.flow.a.c tx() {
                        com.baidu.tbadk.core.flow.a.c tx = super.tx();
                        if (tx != null) {
                            tx.setGravity(81);
                            tx.om(R.dimen.ds20);
                        }
                        return tx;
                    }

                    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
                    public TbImageView V(Context context) {
                        TbImageView tbImageView = new TbImageView(context);
                        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        tbImageView.setGifIconSupport(false);
                        return tbImageView;
                    }
                };
                this.ajL.setDisableParentEvent(false);
                this.ajL.setCoverFlowFactory(bVar);
                this.ajL.setCallback(this.eUQ);
            }
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void bvb() {
        if (this.ajL != null) {
            this.ajL.bqP();
        }
    }

    public void a(c cVar) {
        if (cVar != null && cVar != this.iSl) {
            this.ajL.setData(cVar.cyJ());
            this.iSl = cVar;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
