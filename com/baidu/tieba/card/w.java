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
/* loaded from: classes21.dex */
public class w extends b<bw> implements com.baidu.tieba.a.e {
    private bw agw;
    private String aht;
    private final View fCa;
    private TextView hHB;
    private TextView hHC;
    private TextView hHD;
    private t hHE;
    private FrsBaseVideoView hHF;
    private HeadImageView hyL;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hyL = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hyL.setIsRound(true);
        this.hyL.setDefaultResource(R.drawable.pic_head_topic);
        this.hHB = (TextView) view.findViewById(R.id.card_topic_name);
        this.hHD = (TextView) view.findViewById(R.id.card_thread_title);
        this.hHC = (TextView) view.findViewById(R.id.card_reply_time);
        this.fCa = view.findViewById(R.id.card_divider_line);
        this.hHF = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.hHF.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hyL.invalidate();
        ap.setViewTextColor(this.hHB, R.color.cp_cont_b);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
        if (this.hHF != null) {
            this.hHF.onChangeSkinType(i);
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
        this.agw = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.hHF != null) {
            this.hHF.a(this.agw, bwVar.bhP());
        }
        if (bwVar.bih() != null) {
            this.hHB.setText(bwVar.bih().getName_show());
        }
        this.hHC.setText(at.getFormatTime(bwVar.bia() * 1000));
        String str = bwVar.bjM() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hHD.setText(spannableStringBuilder);
        m.a(this.hHD, this.agw.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agw != null) {
            if (cil() != null) {
                cil().a(view, (View) this.agw, (Object) this.hHE);
            }
            m.Ij(this.agw.getTid());
            m.a(this.hHD, this.agw.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
            ciK();
        }
    }

    private void ciK() {
        if (this.agw != null && this.agw.bih() != null && this.agw.bih().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.kf(true) && !com.baidu.tbadk.plugins.b.byu()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agw.bih().getName_show() + "", "3");
                createNormalConfig.setExtra(this.agw.getFid(), this.agw.bjP(), this.agw.bjQ(), com.baidu.adp.lib.f.b.toLong(this.agw.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bmY().b(this.mPageContext, new String[]{this.agw.bjR()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }
}
