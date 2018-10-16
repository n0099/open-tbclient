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
    private bb aAQ;
    private String bVS;
    private final View buH;
    private ConstrainImageGroup cNn;
    private HeadImageView cPa;
    private TextView cPb;
    private TextView cPc;
    private TextView cPd;
    private w cPe;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cPa = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cPa.setIsRound(true);
        this.cPa.setDefaultResource(e.f.pic_head_topic);
        this.cPb = (TextView) view.findViewById(e.g.card_topic_name);
        this.cPd = (TextView) view.findViewById(e.g.card_thread_title);
        this.cPc = (TextView) view.findViewById(e.g.card_reply_time);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.card_img_layout);
        this.buH = view.findViewById(e.g.card_divider_line);
        this.cNn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn.setImageProcessor(eVar);
        this.cNn.setFromCDN(true);
        this.cNn.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cPa.invalidate();
        al.h(this.cPb, e.d.cp_cont_b);
        al.h(this.cPc, e.d.cp_cont_d);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.buH, e.d.cp_bg_line_e);
        this.cNn.onChangeSkinType();
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
        this.aAQ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bbVar.yv() != null) {
            this.cPb.setText(bbVar.yv().getName_show());
        }
        this.cPc.setText(ao.C(bbVar.yo() * 1000));
        String str = bbVar.zP() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cPd.setText(spannableStringBuilder);
        ArrayList<MediaData> yG = bbVar.yG();
        if (com.baidu.tbadk.core.i.ws().ww() && com.baidu.tbadk.core.util.v.I(yG) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < yG.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(yG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.I(arrayList) > 0) {
                this.cNn.setVisibility(0);
                this.cNn.setImageMediaList(arrayList);
            } else {
                this.cNn.setVisibility(8);
            }
        } else {
            this.cNn.setVisibility(8);
        }
        o.a(this.cPd, this.aAQ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAQ != null) {
            if (anO() != null) {
                anO().a(view, this.aAQ, this.cPe);
            }
            if (view == getView()) {
                o.md(this.aAQ.getTid());
                o.a(this.cPd, this.aAQ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
                aop();
            }
        }
    }

    private void aop() {
        if (this.aAQ != null && this.aAQ.yv() != null && this.aAQ.yv().getName_show() != null) {
            long fid = this.aAQ.getFid();
            if (this.aAQ.arp != null) {
                fid = com.baidu.adp.lib.g.b.d(this.aAQ.arp.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.cx(true) && !com.baidu.tbadk.plugins.b.Ok()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aAQ.yv().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aAQ.zT(), this.aAQ.zU(), com.baidu.adp.lib.g.b.d(this.aAQ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.CU().c(this.mPageContext, new String[]{this.aAQ.zV()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public void a(w wVar) {
        this.cPe = wVar;
    }
}
