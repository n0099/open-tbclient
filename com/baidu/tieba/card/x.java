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
    private bg VK;
    private String Wt;
    private final View cSY;
    private HeadImageView eqF;
    private TextView ezC;
    private TextView ezD;
    private TextView ezE;
    private u ezF;
    private FrsBaseVideoView ezG;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eqF = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.eqF.setIsRound(true);
        this.eqF.setDefaultResource(R.drawable.pic_head_topic);
        this.ezC = (TextView) view.findViewById(R.id.card_topic_name);
        this.ezE = (TextView) view.findViewById(R.id.card_thread_title);
        this.ezD = (TextView) view.findViewById(R.id.card_reply_time);
        this.cSY = view.findViewById(R.id.card_divider_line);
        this.ezG = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.ezG.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eqF.invalidate();
        al.j(this.ezC, R.color.cp_cont_b);
        al.k(getView(), R.drawable.addresslist_item_bg);
        al.l(this.cSY, R.color.cp_bg_line_e);
        if (this.ezG != null) {
            this.ezG.onChangeSkinType(i);
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
        this.VK = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ezG != null) {
            this.ezG.a(this.VK, bgVar.ade());
        }
        if (bgVar.adv() != null) {
            this.ezC.setText(bgVar.adv().getName_show());
        }
        this.ezD.setText(ap.aC(bgVar.ado() * 1000));
        String str = bgVar.aeX() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.ezE.setText(spannableStringBuilder);
        n.a(this.ezE, this.VK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.VK != null) {
            if (aXo() != null) {
                aXo().a(view, (View) this.VK, (Object) this.ezF);
            }
            n.uS(this.VK.getTid());
            n.a(this.ezE, this.VK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            aXN();
        }
    }

    private void aXN() {
        if (this.VK != null && this.VK.adv() != null && this.VK.adv().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fE(true) && !com.baidu.tbadk.plugins.b.auB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.VK.adv().getName_show() + "", "3");
                createNormalConfig.setExtra(this.VK.getFid(), this.VK.afb(), this.VK.afc(), com.baidu.adp.lib.g.b.c(this.VK.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.aiz().c(this.mPageContext, new String[]{this.VK.afd()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }
}
