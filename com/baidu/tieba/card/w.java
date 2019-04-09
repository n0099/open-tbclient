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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class w extends a<bg> implements com.baidu.tieba.a.e {
    private bg XT;
    private String YB;
    private final View cKN;
    private ConstrainImageGroup eia;
    private HeadImageView ejN;
    private TextView ejO;
    private TextView ejP;
    private TextView ejQ;
    private u ejR;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ejN = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.ejN.setIsRound(true);
        this.ejN.setDefaultResource(d.f.pic_head_topic);
        this.ejO = (TextView) view.findViewById(d.g.card_topic_name);
        this.ejQ = (TextView) view.findViewById(d.g.card_thread_title);
        this.ejP = (TextView) view.findViewById(d.g.card_reply_time);
        this.eia = (ConstrainImageGroup) view.findViewById(d.g.card_img_layout);
        this.cKN = view.findViewById(d.g.card_divider_line);
        this.eia.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.eia.setImageProcessor(fVar);
        this.eia.setFromCDN(true);
        this.eia.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ejN.invalidate();
        al.j(this.ejO, d.C0277d.cp_cont_b);
        al.j(this.ejP, d.C0277d.cp_cont_d);
        al.k(getView(), d.f.addresslist_item_bg);
        al.l(this.cKN, d.C0277d.cp_bg_line_e);
        this.eia.onChangeSkinType();
        this.ejN.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.XT = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bgVar.YO() != null) {
            this.ejO.setText(bgVar.YO().getName_show());
        }
        this.ejP.setText(ap.ao(bgVar.YH() * 1000));
        String str = bgVar.aaq() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 33);
        this.ejQ.setText(spannableStringBuilder);
        ArrayList<MediaData> YY = bgVar.YY();
        if (com.baidu.tbadk.core.i.Wv().Wz() && com.baidu.tbadk.core.util.v.S(YY) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.S(arrayList) > 0) {
                this.eia.setVisibility(0);
                this.eia.setImageMediaList(arrayList);
            } else {
                this.eia.setVisibility(8);
            }
        } else {
            this.eia.setVisibility(8);
        }
        n.a(this.ejQ, this.XT.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XT != null) {
            if (aQf() != null) {
                aQf().a(view, (View) this.XT, (Object) this.ejR);
            }
            if (view == getView()) {
                n.tz(this.XT.getTid());
                n.a(this.ejQ, this.XT.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                aQE();
            }
        }
    }

    private void aQE() {
        if (this.XT != null && this.XT.YO() != null && this.XT.YO().getName_show() != null) {
            long fid = this.XT.getFid();
            if (this.XT.bDI != null) {
                fid = com.baidu.adp.lib.g.b.d(this.XT.bDI.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fi(true) && !com.baidu.tbadk.plugins.b.apy()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.XT.YO().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.XT.aau(), this.XT.aav(), com.baidu.adp.lib.g.b.d(this.XT.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.adA().c(this.mPageContext, new String[]{this.XT.aaw()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public void a(u uVar) {
        this.ejR = uVar;
    }
}
