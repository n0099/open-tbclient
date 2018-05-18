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
    private final View ban;
    private String bwO;
    private ConstrainImageGroup cqe;
    private HeadImageView crS;
    private TextView crT;
    private TextView crU;
    private TextView crV;
    private w crW;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view2 = getView();
        view2.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.crS = (HeadImageView) view2.findViewById(d.g.topic_icon);
        this.crS.setIsRound(true);
        this.crS.setDefaultResource(d.f.pic_head_topic);
        this.crT = (TextView) view2.findViewById(d.g.card_topic_name);
        this.crV = (TextView) view2.findViewById(d.g.card_thread_title);
        this.crU = (TextView) view2.findViewById(d.g.card_reply_time);
        this.cqe = (ConstrainImageGroup) view2.findViewById(d.g.card_img_layout);
        this.ban = view2.findViewById(d.g.card_divider_line);
        this.cqe.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cqe.setImageProcessor(eVar);
        this.cqe.setFromCDN(true);
        this.cqe.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.crS.invalidate();
        ak.h(this.crT, d.C0126d.cp_cont_b);
        ak.i(getView(), d.f.addresslist_item_bg);
        ak.j(this.ban, d.C0126d.cp_bg_line_e);
        this.cqe.onChangeSkinType();
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
        if (bdVar.rP() != null) {
            this.crT.setText(bdVar.rP().getName_show());
        }
        this.crU.setText(an.s(bdVar.rJ() * 1000));
        String str = bdVar.te() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bdVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_c)), 0, str.length(), 33);
        this.crV.setText(spannableStringBuilder);
        ArrayList<MediaData> rZ = bdVar.rZ();
        if (com.baidu.tbadk.core.i.pX().qd() && com.baidu.tbadk.core.util.v.v(rZ) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < rZ.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(arrayList) > 0) {
                this.cqe.setVisibility(0);
                this.cqe.setImageMediaList(arrayList);
            } else {
                this.cqe.setVisibility(8);
            }
        } else {
            this.cqe.setVisibility(8);
        }
        o.a(this.crV, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.alf != null) {
            if (aeZ() != null) {
                aeZ().a(view2, this.alf, this.crW);
            }
            if (view2 == getView()) {
                o.ky(this.alf.getTid());
                o.a(this.crV, this.alf.getTid(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                afB();
            }
        }
    }

    private void afB() {
        if (this.alf != null && this.alf.rP() != null && this.alf.rP().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.bV(true) && !com.baidu.tbadk.plugins.b.Hl()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.alf.rP().getName_show() + "", "");
                createNormalConfig.setExtra(this.alf.getFid(), this.alf.tg(), this.alf.th());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ax.wf().c(this.mPageContext, new String[]{this.alf.ti()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cqe != null) {
            this.cqe.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cqe != null) {
            this.cqe.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public void a(w wVar) {
        this.crW = wVar;
    }
}
