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
    private bg XS;
    private String YA;
    private final View cKK;
    private ConstrainImageGroup ein;
    private HeadImageView eka;
    private TextView ekb;
    private TextView ekc;
    private TextView ekd;
    private u eke;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eka = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.eka.setIsRound(true);
        this.eka.setDefaultResource(d.f.pic_head_topic);
        this.ekb = (TextView) view.findViewById(d.g.card_topic_name);
        this.ekd = (TextView) view.findViewById(d.g.card_thread_title);
        this.ekc = (TextView) view.findViewById(d.g.card_reply_time);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.card_img_layout);
        this.cKK = view.findViewById(d.g.card_divider_line);
        this.ein.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.ein.setImageProcessor(fVar);
        this.ein.setFromCDN(true);
        this.ein.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eka.invalidate();
        al.j(this.ekb, d.C0277d.cp_cont_b);
        al.j(this.ekc, d.C0277d.cp_cont_d);
        al.k(getView(), d.f.addresslist_item_bg);
        al.l(this.cKK, d.C0277d.cp_bg_line_e);
        this.ein.onChangeSkinType();
        this.eka.setDefaultBgResource(i);
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
        this.XS = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bgVar.YR() != null) {
            this.ekb.setText(bgVar.YR().getName_show());
        }
        this.ekc.setText(ap.ao(bgVar.YK() * 1000));
        String str = bgVar.aat() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 33);
        this.ekd.setText(spannableStringBuilder);
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (com.baidu.tbadk.core.i.Wy().WC() && com.baidu.tbadk.core.util.v.S(Zb) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.S(arrayList) > 0) {
                this.ein.setVisibility(0);
                this.ein.setImageMediaList(arrayList);
            } else {
                this.ein.setVisibility(8);
            }
        } else {
            this.ein.setVisibility(8);
        }
        n.a(this.ekd, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XS != null) {
            if (aQh() != null) {
                aQh().a(view, (View) this.XS, (Object) this.eke);
            }
            if (view == getView()) {
                n.tA(this.XS.getTid());
                n.a(this.ekd, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                aQG();
            }
        }
    }

    private void aQG() {
        if (this.XS != null && this.XS.YR() != null && this.XS.YR().getName_show() != null) {
            long fid = this.XS.getFid();
            if (this.XS.bDE != null) {
                fid = com.baidu.adp.lib.g.b.d(this.XS.bDE.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fi(true) && !com.baidu.tbadk.plugins.b.apB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.XS.YR().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.XS.aax(), this.XS.aay(), com.baidu.adp.lib.g.b.d(this.XS.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.adD().c(this.mPageContext, new String[]{this.XS.aaz()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public void a(u uVar) {
        this.eke = uVar;
    }
}
