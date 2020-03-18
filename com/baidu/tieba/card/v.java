package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class v extends a<bj> implements com.baidu.tieba.a.e {
    private bj KJ;
    private String LC;
    private final View cey;
    private HeadImageView fDS;
    private FrsBaseVideoView fMA;
    private TextView fMw;
    private TextView fMx;
    private TextView fMy;
    private s fMz;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fDS = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fDS.setIsRound(true);
        this.fDS.setDefaultResource(R.drawable.pic_head_topic);
        this.fMw = (TextView) view.findViewById(R.id.card_topic_name);
        this.fMy = (TextView) view.findViewById(R.id.card_thread_title);
        this.fMx = (TextView) view.findViewById(R.id.card_reply_time);
        this.cey = view.findViewById(R.id.card_divider_line);
        this.fMA = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.fMA.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fDS.invalidate();
        am.setViewTextColor(this.fMw, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
        if (this.fMA != null) {
            this.fMA.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.KJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.fMA != null) {
            this.fMA.a(this.KJ, bjVar.aBZ());
        }
        if (bjVar.aCr() != null) {
            this.fMw.setText(bjVar.aCr().getName_show());
        }
        this.fMx.setText(aq.getFormatTime(bjVar.aCk() * 1000));
        String str = bjVar.aDS() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.v(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fMy.setText(spannableStringBuilder);
        l.a(this.fMy, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KJ != null) {
            if (buM() != null) {
                buM().a(view, (View) this.KJ, (Object) this.fMz);
            }
            l.zU(this.KJ.getTid());
            l.a(this.fMy, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bvn();
        }
    }

    private void bvn() {
        if (this.KJ != null && this.KJ.aCr() != null && this.KJ.aCr().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.gY(true) && !com.baidu.tbadk.plugins.b.aRI()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.KJ.aCr().getName_show() + "", "3");
                createNormalConfig.setExtra(this.KJ.getFid(), this.KJ.aDW(), this.KJ.aDX(), com.baidu.adp.lib.f.b.toLong(this.KJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aGK().b(this.mPageContext, new String[]{this.KJ.aDY()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }
}
