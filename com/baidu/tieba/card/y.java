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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends a<bd> implements com.baidu.tieba.a.e {
    private bd alf;
    private final View bam;
    private String bvX;
    private ConstrainImageGroup coU;
    private HeadImageView cqI;
    private TextView cqJ;
    private TextView cqK;
    private TextView cqL;
    private w cqM;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view2 = getView();
        view2.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cqI = (HeadImageView) view2.findViewById(d.g.topic_icon);
        this.cqI.setIsRound(true);
        this.cqI.setDefaultResource(d.f.pic_head_topic);
        this.cqJ = (TextView) view2.findViewById(d.g.card_topic_name);
        this.cqL = (TextView) view2.findViewById(d.g.card_thread_title);
        this.cqK = (TextView) view2.findViewById(d.g.card_reply_time);
        this.coU = (ConstrainImageGroup) view2.findViewById(d.g.card_img_layout);
        this.bam = view2.findViewById(d.g.card_divider_line);
        this.coU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coU.setImageProcessor(eVar);
        this.coU.setFromCDN(true);
        this.coU.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cqI.invalidate();
        ak.h(this.cqJ, d.C0126d.cp_cont_b);
        ak.i(getView(), d.f.addresslist_item_bg);
        ak.j(this.bam, d.C0126d.cp_bg_line_e);
        this.coU.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.alf = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bdVar.rQ() != null) {
            this.cqJ.setText(bdVar.rQ().getName_show());
        }
        this.cqK.setText(an.s(bdVar.rK() * 1000));
        String str = bdVar.tf() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bdVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_c)), 0, str.length(), 33);
        this.cqL.setText(spannableStringBuilder);
        ArrayList<MediaData> sa = bdVar.sa();
        if (com.baidu.tbadk.core.i.pY().qe() && com.baidu.tbadk.core.util.v.v(sa) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sa.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(sa, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(arrayList) > 0) {
                this.coU.setVisibility(0);
                this.coU.setImageMediaList(arrayList);
            } else {
                this.coU.setVisibility(8);
            }
        } else {
            this.coU.setVisibility(8);
        }
        o.a(this.cqL, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.alf != null) {
            if (aeZ() != null) {
                aeZ().a(view2, this.alf, this.cqM);
            }
            if (view2 == getView()) {
                o.kv(this.alf.getTid());
                o.a(this.cqL, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                afB();
            }
        }
    }

    private void afB() {
        if (this.alf != null && this.alf.rQ() != null && this.alf.rQ().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.bV(true) && !com.baidu.tbadk.plugins.b.Hn()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.alf.rQ().getName_show() + "", "");
                createNormalConfig.setExtra(this.alf.getFid(), this.alf.th(), this.alf.ti());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ax.wg().c(this.mPageContext, new String[]{this.alf.tj()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coU != null) {
            this.coU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coU != null) {
            this.coU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public void a(w wVar) {
        this.cqM = wVar;
    }
}
