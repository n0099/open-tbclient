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
    private bw afL;
    private String agJ;
    private final View fmI;
    private HeadImageView hcR;
    private TextView hlE;
    private TextView hlF;
    private TextView hlG;
    private t hlH;
    private FrsBaseVideoView hlI;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hcR = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hcR.setIsRound(true);
        this.hcR.setDefaultResource(R.drawable.pic_head_topic);
        this.hlE = (TextView) view.findViewById(R.id.card_topic_name);
        this.hlG = (TextView) view.findViewById(R.id.card_thread_title);
        this.hlF = (TextView) view.findViewById(R.id.card_reply_time);
        this.fmI = view.findViewById(R.id.card_divider_line);
        this.hlI = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.hlI.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hcR.invalidate();
        ap.setViewTextColor(this.hlE, R.color.cp_cont_b);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
        if (this.hlI != null) {
            this.hlI.onChangeSkinType(i);
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
        this.afL = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.hlI != null) {
            this.hlI.a(this.afL, bwVar.bem());
        }
        if (bwVar.beE() != null) {
            this.hlE.setText(bwVar.beE().getName_show());
        }
        this.hlF.setText(at.getFormatTime(bwVar.bex() * 1000));
        String str = bwVar.bgj() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hlG.setText(spannableStringBuilder);
        m.a(this.hlG, this.afL.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afL != null) {
            if (cbA() != null) {
                cbA().a(view, (View) this.afL, (Object) this.hlH);
            }
            m.GZ(this.afL.getTid());
            m.a(this.hlG, this.afL.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
            cbZ();
        }
    }

    private void cbZ() {
        if (this.afL != null && this.afL.beE() != null && this.afL.beE().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.jG(true) && !com.baidu.tbadk.plugins.b.buG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.afL.beE().getName_show() + "", "3");
                createNormalConfig.setExtra(this.afL.getFid(), this.afL.bgm(), this.afL.bgn(), com.baidu.adp.lib.f.b.toLong(this.afL.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bju().b(this.mPageContext, new String[]{this.afL.bgo()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }
}
