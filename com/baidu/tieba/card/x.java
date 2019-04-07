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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class x extends a<bg> implements com.baidu.tieba.a.e {
    private bg XS;
    private String YA;
    private final View cKM;
    private HeadImageView ejM;
    private TextView ejN;
    private TextView ejO;
    private TextView ejP;
    private u ejQ;
    private FrsBaseVideoView ejR;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ejM = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.ejM.setIsRound(true);
        this.ejM.setDefaultResource(d.f.pic_head_topic);
        this.ejN = (TextView) view.findViewById(d.g.card_topic_name);
        this.ejP = (TextView) view.findViewById(d.g.card_thread_title);
        this.ejO = (TextView) view.findViewById(d.g.card_reply_time);
        this.cKM = view.findViewById(d.g.card_divider_line);
        this.ejR = (FrsBaseVideoView) view.findViewById(d.g.base_video_view);
        this.ejR.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ejM.invalidate();
        al.j(this.ejN, d.C0277d.cp_cont_b);
        al.k(getView(), d.f.addresslist_item_bg);
        al.l(this.cKM, d.C0277d.cp_bg_line_e);
        if (this.ejR != null) {
            this.ejR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_hottopic_video_card;
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
        if (this.ejR != null) {
            this.ejR.a(this.XS, bgVar.Yx());
        }
        if (bgVar.YO() != null) {
            this.ejN.setText(bgVar.YO().getName_show());
        }
        this.ejO.setText(ap.ao(bgVar.YH() * 1000));
        String str = bgVar.aaq() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 33);
        this.ejP.setText(spannableStringBuilder);
        n.a(this.ejP, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XS != null) {
            if (aQf() != null) {
                aQf().a(view, (View) this.XS, (Object) this.ejQ);
            }
            n.tz(this.XS.getTid());
            n.a(this.ejP, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            aQE();
        }
    }

    private void aQE() {
        if (this.XS != null && this.XS.YO() != null && this.XS.YO().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fi(true) && !com.baidu.tbadk.plugins.b.apy()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.XS.YO().getName_show() + "", "3");
                createNormalConfig.setExtra(this.XS.getFid(), this.XS.aau(), this.XS.aav(), com.baidu.adp.lib.g.b.d(this.XS.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.adA().c(this.mPageContext, new String[]{this.XS.aaw()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }
}
