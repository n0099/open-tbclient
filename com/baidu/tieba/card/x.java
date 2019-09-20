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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class x extends a<bh> implements com.baidu.tieba.a.e {
    private String WM;
    private bh Wd;
    private final View cVw;
    private TextView eGp;
    private TextView eGq;
    private TextView eGr;
    private u eGs;
    private FrsBaseVideoView eGt;
    private HeadImageView exw;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.exw = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.exw.setIsRound(true);
        this.exw.setDefaultResource(R.drawable.pic_head_topic);
        this.eGp = (TextView) view.findViewById(R.id.card_topic_name);
        this.eGr = (TextView) view.findViewById(R.id.card_thread_title);
        this.eGq = (TextView) view.findViewById(R.id.card_reply_time);
        this.cVw = view.findViewById(R.id.card_divider_line);
        this.eGt = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.eGt.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.exw.invalidate();
        am.j(this.eGp, R.color.cp_cont_b);
        am.k(getView(), R.drawable.addresslist_item_bg);
        am.l(this.cVw, R.color.cp_bg_line_c);
        if (this.eGt != null) {
            this.eGt.onChangeSkinType(i);
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
        this.Wd = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.eGt != null) {
            this.eGt.a(this.Wd, bhVar.ael());
        }
        if (bhVar.aeC() != null) {
            this.eGp.setText(bhVar.aeC().getName_show());
        }
        this.eGq.setText(aq.aD(bhVar.aev() * 1000));
        String str = bhVar.age() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bhVar.o(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eGr.setText(spannableStringBuilder);
        n.a(this.eGr, this.Wd.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Wd != null) {
            if (aZU() != null) {
                aZU().a(view, (View) this.Wd, (Object) this.eGs);
            }
            n.vW(this.Wd.getTid());
            n.a(this.eGr, this.Wd.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bau();
        }
    }

    private void bau() {
        if (this.Wd != null && this.Wd.aeC() != null && this.Wd.aeC().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fL(true) && !com.baidu.tbadk.plugins.b.avY()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Wd.aeC().getName_show() + "", "3");
                createNormalConfig.setExtra(this.Wd.getFid(), this.Wd.agi(), this.Wd.agj(), com.baidu.adp.lib.g.b.e(this.Wd.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.ajK().c(this.mPageContext, new String[]{this.Wd.agk()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }
}
