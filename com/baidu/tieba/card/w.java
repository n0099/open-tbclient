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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends b<bu> implements com.baidu.tieba.a.e {
    private bu aeK;
    private String afG;
    private final View eVD;
    private HeadImageView gKr;
    private TextView gTc;
    private TextView gTd;
    private TextView gTe;
    private t gTf;
    private FrsBaseVideoView gTg;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.gKr = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.gKr.setIsRound(true);
        this.gKr.setDefaultResource(R.drawable.pic_head_topic);
        this.gTc = (TextView) view.findViewById(R.id.card_topic_name);
        this.gTe = (TextView) view.findViewById(R.id.card_thread_title);
        this.gTd = (TextView) view.findViewById(R.id.card_reply_time);
        this.eVD = view.findViewById(R.id.card_divider_line);
        this.gTg = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.gTg.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gKr.invalidate();
        an.setViewTextColor(this.gTc, (int) R.color.cp_cont_b);
        an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
        if (this.gTg != null) {
            this.gTg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        if (buVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeK = buVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.gTg != null) {
            this.gTg.a(this.aeK, buVar.aRX());
        }
        if (buVar.aSp() != null) {
            this.gTc.setText(buVar.aSp().getName_show());
        }
        this.gTd.setText(ar.getFormatTime(buVar.aSi() * 1000));
        String str = buVar.aTU() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) buVar.x(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.gTe.setText(spannableStringBuilder);
        m.a(this.gTe, this.aeK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeK != null) {
            if (bOd() != null) {
                bOd().a(view, (View) this.aeK, (Object) this.gTf);
            }
            m.DO(this.aeK.getTid());
            m.a(this.gTe, this.aeK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bOC();
        }
    }

    private void bOC() {
        if (this.aeK != null && this.aeK.aSp() != null && this.aeK.aSp().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.iB(true) && !com.baidu.tbadk.plugins.b.bih()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aeK.aSp().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aeK.getFid(), this.aeK.aTX(), this.aeK.aTY(), com.baidu.adp.lib.f.b.toLong(this.aeK.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bc.aWU().b(this.mPageContext, new String[]{this.aeK.aTZ()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }
}
