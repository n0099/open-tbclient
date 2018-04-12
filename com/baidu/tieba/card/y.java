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
    private ConstrainImageGroup coX;
    private HeadImageView cqL;
    private TextView cqM;
    private TextView cqN;
    private TextView cqO;
    private w cqP;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view2 = getView();
        view2.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cqL = (HeadImageView) view2.findViewById(d.g.topic_icon);
        this.cqL.setIsRound(true);
        this.cqL.setDefaultResource(d.f.pic_head_topic);
        this.cqM = (TextView) view2.findViewById(d.g.card_topic_name);
        this.cqO = (TextView) view2.findViewById(d.g.card_thread_title);
        this.cqN = (TextView) view2.findViewById(d.g.card_reply_time);
        this.coX = (ConstrainImageGroup) view2.findViewById(d.g.card_img_layout);
        this.bam = view2.findViewById(d.g.card_divider_line);
        this.coX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coX.setImageProcessor(eVar);
        this.coX.setFromCDN(true);
        this.coX.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cqL.invalidate();
        ak.h(this.cqM, d.C0126d.cp_cont_b);
        ak.i(getView(), d.f.addresslist_item_bg);
        ak.j(this.bam, d.C0126d.cp_bg_line_e);
        this.coX.onChangeSkinType();
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
            this.cqM.setText(bdVar.rQ().getName_show());
        }
        this.cqN.setText(an.s(bdVar.rK() * 1000));
        String str = bdVar.tf() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bdVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_c)), 0, str.length(), 33);
        this.cqO.setText(spannableStringBuilder);
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
                this.coX.setVisibility(0);
                this.coX.setImageMediaList(arrayList);
            } else {
                this.coX.setVisibility(8);
            }
        } else {
            this.coX.setVisibility(8);
        }
        o.a(this.cqO, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.alf != null) {
            if (aeZ() != null) {
                aeZ().a(view2, this.alf, this.cqP);
            }
            if (view2 == getView()) {
                o.kv(this.alf.getTid());
                o.a(this.cqO, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
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
        if (this.coX != null) {
            this.coX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coX != null) {
            this.coX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public void a(w wVar) {
        this.cqP = wVar;
    }
}
