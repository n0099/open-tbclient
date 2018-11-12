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
    private bb aBF;
    private String bWE;
    private final View bvs;
    private ConstrainImageGroup cOt;
    private HeadImageView cQg;
    private TextView cQh;
    private TextView cQi;
    private TextView cQj;
    private w cQk;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cQg = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cQg.setIsRound(true);
        this.cQg.setDefaultResource(e.f.pic_head_topic);
        this.cQh = (TextView) view.findViewById(e.g.card_topic_name);
        this.cQj = (TextView) view.findViewById(e.g.card_thread_title);
        this.cQi = (TextView) view.findViewById(e.g.card_reply_time);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.card_img_layout);
        this.bvs = view.findViewById(e.g.card_divider_line);
        this.cOt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt.setImageProcessor(eVar);
        this.cOt.setFromCDN(true);
        this.cOt.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cQg.invalidate();
        al.h(this.cQh, e.d.cp_cont_b);
        al.h(this.cQi, e.d.cp_cont_d);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.bvs, e.d.cp_bg_line_e);
        this.cOt.onChangeSkinType();
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
        this.aBF = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bbVar.yC() != null) {
            this.cQh.setText(bbVar.yC().getName_show());
        }
        this.cQi.setText(ao.E(bbVar.yv() * 1000));
        String str = bbVar.zW() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cQj.setText(spannableStringBuilder);
        ArrayList<MediaData> yN = bbVar.yN();
        if (com.baidu.tbadk.core.i.wA().wE() && com.baidu.tbadk.core.util.v.H(yN) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < yN.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(yN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(arrayList) > 0) {
                this.cOt.setVisibility(0);
                this.cOt.setImageMediaList(arrayList);
            } else {
                this.cOt.setVisibility(8);
            }
        } else {
            this.cOt.setVisibility(8);
        }
        o.a(this.cQj, this.aBF.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBF != null) {
            if (anq() != null) {
                anq().a(view, this.aBF, this.cQk);
            }
            if (view == getView()) {
                o.me(this.aBF.getTid());
                o.a(this.cQj, this.aBF.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
                anR();
            }
        }
    }

    private void anR() {
        if (this.aBF != null && this.aBF.yC() != null && this.aBF.yC().getName_show() != null) {
            long fid = this.aBF.getFid();
            if (this.aBF.asc != null) {
                fid = com.baidu.adp.lib.g.b.d(this.aBF.asc.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.cO(true) && !com.baidu.tbadk.plugins.b.Ot()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aBF.yC().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aBF.Aa(), this.aBF.Ab(), com.baidu.adp.lib.g.b.d(this.aBF.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.Db().c(this.mPageContext, new String[]{this.aBF.Ac()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public void a(w wVar) {
        this.cQk = wVar;
    }
}
