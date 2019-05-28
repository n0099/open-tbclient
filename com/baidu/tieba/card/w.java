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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class w extends a<bg> implements com.baidu.tieba.a.e {
    private bg VK;
    private String Wt;
    private final View cSZ;
    private HeadImageView eqG;
    private ConstrainImageGroup exO;
    private TextView ezD;
    private TextView ezE;
    private TextView ezF;
    private u ezG;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eqG = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.eqG.setIsRound(true);
        this.eqG.setDefaultResource(R.drawable.pic_head_topic);
        this.ezD = (TextView) view.findViewById(R.id.card_topic_name);
        this.ezF = (TextView) view.findViewById(R.id.card_thread_title);
        this.ezE = (TextView) view.findViewById(R.id.card_reply_time);
        this.exO = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cSZ = view.findViewById(R.id.card_divider_line);
        this.exO.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.exO.setImageProcessor(fVar);
        this.exO.setFromCDN(true);
        this.exO.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eqG.invalidate();
        al.j(this.ezD, R.color.cp_cont_b);
        al.j(this.ezE, R.color.cp_cont_d);
        al.k(getView(), R.drawable.addresslist_item_bg);
        al.l(this.cSZ, R.color.cp_bg_line_e);
        this.exO.onChangeSkinType();
        this.eqG.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
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
        this.VK = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bgVar.adv() != null) {
            this.ezD.setText(bgVar.adv().getName_show());
        }
        this.ezE.setText(ap.aC(bgVar.ado() * 1000));
        String str = bgVar.aeX() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.ezF.setText(spannableStringBuilder);
        ArrayList<MediaData> adF = bgVar.adF();
        if (com.baidu.tbadk.core.i.abb().abf() && com.baidu.tbadk.core.util.v.Z(adF) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.Z(arrayList) > 0) {
                this.exO.setVisibility(0);
                this.exO.setImageMediaList(arrayList);
            } else {
                this.exO.setVisibility(8);
            }
        } else {
            this.exO.setVisibility(8);
        }
        n.a(this.ezF, this.VK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.VK != null) {
            if (aXr() != null) {
                aXr().a(view, (View) this.VK, (Object) this.ezG);
            }
            if (view == getView()) {
                n.uS(this.VK.getTid());
                n.a(this.ezF, this.VK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                aXQ();
            }
        }
    }

    private void aXQ() {
        if (this.VK != null && this.VK.adv() != null && this.VK.adv().getName_show() != null) {
            long fid = this.VK.getFid();
            if (this.VK.bKZ != null) {
                fid = com.baidu.adp.lib.g.b.c(this.VK.bKZ.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fE(true) && !com.baidu.tbadk.plugins.b.auB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.VK.adv().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.VK.afb(), this.VK.afc(), com.baidu.adp.lib.g.b.c(this.VK.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.aiz().c(this.mPageContext, new String[]{this.VK.afd()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public void a(u uVar) {
        this.ezG = uVar;
    }
}
