package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class y extends a<bb> implements com.baidu.tieba.a.e {
    private bb aFJ;
    private final View bzH;
    private ConstrainImageGroup cYC;
    private String cbl;
    private HeadImageView dap;
    private TextView daq;
    private TextView dar;
    private TextView das;
    private w dau;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.dap = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.dap.setIsRound(true);
        this.dap.setDefaultResource(e.f.pic_head_topic);
        this.daq = (TextView) view.findViewById(e.g.card_topic_name);
        this.das = (TextView) view.findViewById(e.g.card_thread_title);
        this.dar = (TextView) view.findViewById(e.g.card_reply_time);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.card_img_layout);
        this.bzH = view.findViewById(e.g.card_divider_line);
        this.cYC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYC.setImageProcessor(eVar);
        this.cYC.setFromCDN(true);
        this.cYC.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.dap.invalidate();
        al.h(this.daq, e.d.cp_cont_b);
        al.h(this.dar, e.d.cp_cont_d);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.bzH, e.d.cp_bg_line_e);
        this.cYC.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aFJ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bbVar.zT() != null) {
            this.daq.setText(bbVar.zT().getName_show());
        }
        this.dar.setText(ao.M(bbVar.zM() * 1000));
        String str = bbVar.Bn() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.das.setText(spannableStringBuilder);
        ArrayList<MediaData> Ae = bbVar.Ae();
        if (com.baidu.tbadk.core.i.xR().xV() && com.baidu.tbadk.core.util.v.H(Ae) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Ae.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(Ae, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(arrayList) > 0) {
                this.cYC.setVisibility(0);
                this.cYC.setImageMediaList(arrayList);
            } else {
                this.cYC.setVisibility(8);
            }
        } else {
            this.cYC.setVisibility(8);
        }
        o.a(this.das, this.aFJ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFJ != null) {
            if (aqp() != null) {
                aqp().a(view, this.aFJ, this.dau);
            }
            if (view == getView()) {
                o.mW(this.aFJ.getTid());
                o.a(this.das, this.aFJ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
                aqQ();
            }
        }
    }

    private void aqQ() {
        if (this.aFJ != null && this.aFJ.zT() != null && this.aFJ.zT().getName_show() != null) {
            long fid = this.aFJ.getFid();
            if (this.aFJ.awf != null) {
                fid = com.baidu.adp.lib.g.b.d(this.aFJ.awf.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.cS(true) && !com.baidu.tbadk.plugins.b.PR()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aFJ.zT().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aFJ.Br(), this.aFJ.Bs(), com.baidu.adp.lib.g.b.d(this.aFJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.Es().c(this.mPageContext, new String[]{this.aFJ.Bt()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public void a(w wVar) {
        this.dau = wVar;
    }
}
