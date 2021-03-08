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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class x extends b<cb> implements com.baidu.tieba.a.e {
    private cb aiB;
    private String ajx;
    private final View ghb;
    private TextView iAP;
    private TextView iAQ;
    private TextView iAR;
    private u iAS;
    private FrsBaseVideoView iAT;
    private HeadImageView irV;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.irV = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.irV.setIsRound(true);
        this.irV.setDefaultResource(R.drawable.pic_head_topic);
        this.iAP = (TextView) view.findViewById(R.id.card_topic_name);
        this.iAR = (TextView) view.findViewById(R.id.card_thread_title);
        this.iAQ = (TextView) view.findViewById(R.id.card_reply_time);
        this.ghb = view.findViewById(R.id.card_divider_line);
        this.iAT = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.iAT.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.irV.invalidate();
        ap.setViewTextColor(this.iAP, R.color.CAM_X0105);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
        if (this.iAT != null) {
            this.iAT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        if (cbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiB = cbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.iAT != null) {
            this.iAT.a(this.aiB, cbVar.bnA());
        }
        if (cbVar.bnS() != null) {
            this.iAP.setText(cbVar.bnS().getName_show());
        }
        this.iAQ.setText(au.getFormatTime(cbVar.bnL() * 1000));
        String str = cbVar.bpz() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) cbVar.A(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.iAR.setText(spannableStringBuilder);
        m.a(this.iAR, this.aiB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiB != null) {
            if (csi() != null) {
                csi().a(view, (View) this.aiB, (Object) this.iAS);
            }
            m.IW(this.aiB.getTid());
            m.a(this.iAR, this.aiB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            csI();
        }
    }

    private void csI() {
        if (this.aiB != null && this.aiB.bnS() != null && this.aiB.bnS().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.lq(true) && !com.baidu.tbadk.plugins.b.bEG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aiB.bnS().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aiB.getFid(), this.aiB.bpC(), this.aiB.bpD(), com.baidu.adp.lib.f.b.toLong(this.aiB.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bsY().b(this.mPageContext, new String[]{this.aiB.bpE()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }
}
