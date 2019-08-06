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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class x extends a<bh> implements com.baidu.tieba.a.e {
    private String WN;
    private bh We;
    private final View cUD;
    private TextView eEG;
    private TextView eEH;
    private TextView eEI;
    private u eEJ;
    private FrsBaseVideoView eEK;
    private HeadImageView evL;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.evL = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.evL.setIsRound(true);
        this.evL.setDefaultResource(R.drawable.pic_head_topic);
        this.eEG = (TextView) view.findViewById(R.id.card_topic_name);
        this.eEI = (TextView) view.findViewById(R.id.card_thread_title);
        this.eEH = (TextView) view.findViewById(R.id.card_reply_time);
        this.cUD = view.findViewById(R.id.card_divider_line);
        this.eEK = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.eEK.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.evL.invalidate();
        am.j(this.eEG, R.color.cp_cont_b);
        am.k(getView(), R.drawable.addresslist_item_bg);
        am.l(this.cUD, R.color.cp_bg_line_e);
        if (this.eEK != null) {
            this.eEK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.We = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.eEK != null) {
            this.eEK.a(this.We, bhVar.aeh());
        }
        if (bhVar.aey() != null) {
            this.eEG.setText(bhVar.aey().getName_show());
        }
        this.eEH.setText(aq.aD(bhVar.aer() * 1000));
        String str = bhVar.aga() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bhVar.o(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eEI.setText(spannableStringBuilder);
        n.a(this.eEI, this.We.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.We != null) {
            if (aZq() != null) {
                aZq().a(view, (View) this.We, (Object) this.eEJ);
            }
            n.vx(this.We.getTid());
            n.a(this.eEI, this.We.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            aZQ();
        }
    }

    private void aZQ() {
        if (this.We != null && this.We.aey() != null && this.We.aey().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fI(true) && !com.baidu.tbadk.plugins.b.avM()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.We.aey().getName_show() + "", "3");
                createNormalConfig.setExtra(this.We.getFid(), this.We.age(), this.We.agf(), com.baidu.adp.lib.g.b.c(this.We.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            bb.ajE().c(this.mPageContext, new String[]{this.We.agg()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }
}
