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
    private final View cel;
    private HeadImageView fCV;
    private TextView fLA;
    private TextView fLB;
    private s fLC;
    private FrsBaseVideoView fLD;
    private TextView fLz;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fCV = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fCV.setIsRound(true);
        this.fCV.setDefaultResource(R.drawable.pic_head_topic);
        this.fLz = (TextView) view.findViewById(R.id.card_topic_name);
        this.fLB = (TextView) view.findViewById(R.id.card_thread_title);
        this.fLA = (TextView) view.findViewById(R.id.card_reply_time);
        this.cel = view.findViewById(R.id.card_divider_line);
        this.fLD = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.fLD.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fCV.invalidate();
        am.setViewTextColor(this.fLz, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
        if (this.fLD != null) {
            this.fLD.onChangeSkinType(i);
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
        if (this.fLD != null) {
            this.fLD.a(this.KJ, bjVar.aBU());
        }
        if (bjVar.aCm() != null) {
            this.fLz.setText(bjVar.aCm().getName_show());
        }
        this.fLA.setText(aq.getFormatTime(bjVar.aCf() * 1000));
        String str = bjVar.aDM() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fLB.setText(spannableStringBuilder);
        l.a(this.fLB, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KJ != null) {
            if (buE() != null) {
                buE().a(view, (View) this.KJ, (Object) this.fLC);
            }
            l.zS(this.KJ.getTid());
            l.a(this.fLB, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bvf();
        }
    }

    private void bvf() {
        if (this.KJ != null && this.KJ.aCm() != null && this.KJ.aCm().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.gX(true) && !com.baidu.tbadk.plugins.b.aRB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.KJ.aCm().getName_show() + "", "3");
                createNormalConfig.setExtra(this.KJ.getFid(), this.KJ.aDQ(), this.KJ.aDR(), com.baidu.adp.lib.f.b.toLong(this.KJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aGE().b(this.mPageContext, new String[]{this.KJ.aDS()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }
}
