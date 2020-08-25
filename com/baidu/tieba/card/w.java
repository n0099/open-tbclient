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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class w extends b<bw> implements com.baidu.tieba.a.e {
    private bw afJ;
    private String agH;
    private final View fmE;
    private HeadImageView hcN;
    private TextView hlA;
    private TextView hlB;
    private TextView hlC;
    private t hlD;
    private FrsBaseVideoView hlE;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hcN = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hcN.setIsRound(true);
        this.hcN.setDefaultResource(R.drawable.pic_head_topic);
        this.hlA = (TextView) view.findViewById(R.id.card_topic_name);
        this.hlC = (TextView) view.findViewById(R.id.card_thread_title);
        this.hlB = (TextView) view.findViewById(R.id.card_reply_time);
        this.fmE = view.findViewById(R.id.card_divider_line);
        this.hlE = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.hlE.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hcN.invalidate();
        ap.setViewTextColor(this.hlA, R.color.cp_cont_b);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
        if (this.hlE != null) {
            this.hlE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.afJ = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.hlE != null) {
            this.hlE.a(this.afJ, bwVar.bem());
        }
        if (bwVar.beE() != null) {
            this.hlA.setText(bwVar.beE().getName_show());
        }
        this.hlB.setText(at.getFormatTime(bwVar.bex() * 1000));
        String str = bwVar.bgj() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hlC.setText(spannableStringBuilder);
        m.a(this.hlC, this.afJ.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afJ != null) {
            if (cbz() != null) {
                cbz().a(view, (View) this.afJ, (Object) this.hlD);
            }
            m.GY(this.afJ.getTid());
            m.a(this.hlC, this.afJ.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
            cbY();
        }
    }

    private void cbY() {
        if (this.afJ != null && this.afJ.beE() != null && this.afJ.beE().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.jE(true) && !com.baidu.tbadk.plugins.b.buF()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.afJ.beE().getName_show() + "", "3");
                createNormalConfig.setExtra(this.afJ.getFid(), this.afJ.bgm(), this.afJ.bgn(), com.baidu.adp.lib.f.b.toLong(this.afJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bju().b(this.mPageContext, new String[]{this.afJ.bgo()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }
}
