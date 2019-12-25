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
/* loaded from: classes5.dex */
public class v extends a<bj> implements com.baidu.tieba.a.e {
    private bj Ki;
    private String La;
    private final View bZT;
    private TextView fFS;
    private TextView fFT;
    private TextView fFU;
    private s fFV;
    private FrsBaseVideoView fFW;
    private HeadImageView fxm;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fxm = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fxm.setIsRound(true);
        this.fxm.setDefaultResource(R.drawable.pic_head_topic);
        this.fFS = (TextView) view.findViewById(R.id.card_topic_name);
        this.fFU = (TextView) view.findViewById(R.id.card_thread_title);
        this.fFT = (TextView) view.findViewById(R.id.card_reply_time);
        this.bZT = view.findViewById(R.id.card_divider_line);
        this.fFW = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.fFW.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fxm.invalidate();
        am.setViewTextColor(this.fFS, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
        if (this.fFW != null) {
            this.fFW.onChangeSkinType(i);
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
        this.Ki = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.fFW != null) {
            this.fFW.a(this.Ki, bjVar.azm());
        }
        if (bjVar.azE() != null) {
            this.fFS.setText(bjVar.azE().getName_show());
        }
        this.fFT.setText(aq.getFormatTime(bjVar.azx() * 1000));
        String str = bjVar.aBg() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.s(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fFU.setText(spannableStringBuilder);
        l.a(this.fFU, this.Ki.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ki != null) {
            if (brY() != null) {
                brY().a(view, (View) this.Ki, (Object) this.fFV);
            }
            l.zs(this.Ki.getTid());
            l.a(this.fFU, this.Ki.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bsz();
        }
    }

    private void bsz() {
        if (this.Ki != null && this.Ki.azE() != null && this.Ki.azE().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.gL(true) && !com.baidu.tbadk.plugins.b.aOS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Ki.azE().getName_show() + "", "3");
                createNormalConfig.setExtra(this.Ki.getFid(), this.Ki.aBk(), this.Ki.aBl(), com.baidu.adp.lib.f.b.toLong(this.Ki.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aEa().b(this.mPageContext, new String[]{this.Ki.aBm()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }
}
