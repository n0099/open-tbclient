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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class x extends a<bg> implements com.baidu.tieba.a.e {
    private bg VJ;
    private String Ws;
    private final View cTa;
    private HeadImageView eqG;
    private TextView ezD;
    private TextView ezE;
    private TextView ezF;
    private u ezG;
    private FrsBaseVideoView ezH;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.cTa = view.findViewById(R.id.card_divider_line);
        this.ezH = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.ezH.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eqG.invalidate();
        al.j(this.ezD, R.color.cp_cont_b);
        al.k(getView(), R.drawable.addresslist_item_bg);
        al.l(this.cTa, R.color.cp_bg_line_e);
        if (this.ezH != null) {
            this.ezH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
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
        this.VJ = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ezH != null) {
            this.ezH.a(this.VJ, bgVar.ade());
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
        n.a(this.ezF, this.VJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.VJ != null) {
            if (aXr() != null) {
                aXr().a(view, (View) this.VJ, (Object) this.ezG);
            }
            n.uR(this.VJ.getTid());
            n.a(this.ezF, this.VJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            aXQ();
        }
    }

    private void aXQ() {
        if (this.VJ != null && this.VJ.adv() != null && this.VJ.adv().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fE(true) && !com.baidu.tbadk.plugins.b.auB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.VJ.adv().getName_show() + "", "3");
                createNormalConfig.setExtra(this.VJ.getFid(), this.VJ.afb(), this.VJ.afc(), com.baidu.adp.lib.g.b.c(this.VJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.aiz().c(this.mPageContext, new String[]{this.VJ.afd()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }
}
