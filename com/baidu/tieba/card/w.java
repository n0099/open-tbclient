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
/* loaded from: classes20.dex */
public class w extends b<bw> implements com.baidu.tieba.a.e {
    private bw agf;
    private String ahc;
    private final View fpN;
    private HeadImageView hjQ;
    private TextView hsH;
    private TextView hsI;
    private TextView hsJ;
    private t hsK;
    private FrsBaseVideoView hsL;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hjQ = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hjQ.setIsRound(true);
        this.hjQ.setDefaultResource(R.drawable.pic_head_topic);
        this.hsH = (TextView) view.findViewById(R.id.card_topic_name);
        this.hsJ = (TextView) view.findViewById(R.id.card_thread_title);
        this.hsI = (TextView) view.findViewById(R.id.card_reply_time);
        this.fpN = view.findViewById(R.id.card_divider_line);
        this.hsL = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.hsL.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hjQ.invalidate();
        ap.setViewTextColor(this.hsH, R.color.cp_cont_b);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
        if (this.hsL != null) {
            this.hsL.onChangeSkinType(i);
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
        this.agf = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.hsL != null) {
            this.hsL.a(this.agf, bwVar.bfg());
        }
        if (bwVar.bfy() != null) {
            this.hsH.setText(bwVar.bfy().getName_show());
        }
        this.hsI.setText(at.getFormatTime(bwVar.bfr() * 1000));
        String str = bwVar.bhd() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hsJ.setText(spannableStringBuilder);
        m.a(this.hsJ, this.agf.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agf != null) {
            if (ceP() != null) {
                ceP().a(view, (View) this.agf, (Object) this.hsK);
            }
            m.Hw(this.agf.getTid());
            m.a(this.hsJ, this.agf.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
            cfo();
        }
    }

    private void cfo() {
        if (this.agf != null && this.agf.bfy() != null && this.agf.bfy().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.jH(true) && !com.baidu.tbadk.plugins.b.bvK()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agf.bfy().getName_show() + "", "3");
                createNormalConfig.setExtra(this.agf.getFid(), this.agf.bhg(), this.agf.bhh(), com.baidu.adp.lib.f.b.toLong(this.agf.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bkp().b(this.mPageContext, new String[]{this.agf.bhi()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }
}
