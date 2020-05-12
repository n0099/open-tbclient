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
    private bj adJ;
    private String aeB;
    private final View cDC;
    private HeadImageView giC;
    private TextView grj;
    private TextView grk;
    private TextView grl;
    private s grm;
    private FrsBaseVideoView grn;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.giC = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.giC.setIsRound(true);
        this.giC.setDefaultResource(R.drawable.pic_head_topic);
        this.grj = (TextView) view.findViewById(R.id.card_topic_name);
        this.grl = (TextView) view.findViewById(R.id.card_thread_title);
        this.grk = (TextView) view.findViewById(R.id.card_reply_time);
        this.cDC = view.findViewById(R.id.card_divider_line);
        this.grn = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.grn.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.giC.invalidate();
        am.setViewTextColor(this.grj, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
        if (this.grn != null) {
            this.grn.onChangeSkinType(i);
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
        this.adJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.grn != null) {
            this.grn.a(this.adJ, bjVar.aKk());
        }
        if (bjVar.aKC() != null) {
            this.grj.setText(bjVar.aKC().getName_show());
        }
        this.grk.setText(aq.getFormatTime(bjVar.aKv() * 1000));
        String str = bjVar.aMe() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.grl.setText(spannableStringBuilder);
        l.a(this.grl, this.adJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adJ != null) {
            if (bEx() != null) {
                bEx().a(view, (View) this.adJ, (Object) this.grm);
            }
            l.BE(this.adJ.getTid());
            l.a(this.grl, this.adJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bEY();
        }
    }

    private void bEY() {
        if (this.adJ != null && this.adJ.aKC() != null && this.adJ.aKC().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.hW(true) && !com.baidu.tbadk.plugins.b.aZQ()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.adJ.aKC().getName_show() + "", "3");
                createNormalConfig.setExtra(this.adJ.getFid(), this.adJ.aMi(), this.adJ.aMj(), com.baidu.adp.lib.f.b.toLong(this.adJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aOV().b(this.mPageContext, new String[]{this.adJ.aMk()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }
}
