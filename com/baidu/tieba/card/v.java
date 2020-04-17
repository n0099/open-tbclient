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
    private bj adG;
    private String aey;
    private final View cDw;
    private HeadImageView giw;
    private TextView grd;
    private TextView gre;
    private TextView grf;
    private s grg;
    private FrsBaseVideoView grh;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.giw = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.giw.setIsRound(true);
        this.giw.setDefaultResource(R.drawable.pic_head_topic);
        this.grd = (TextView) view.findViewById(R.id.card_topic_name);
        this.grf = (TextView) view.findViewById(R.id.card_thread_title);
        this.gre = (TextView) view.findViewById(R.id.card_reply_time);
        this.cDw = view.findViewById(R.id.card_divider_line);
        this.grh = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.grh.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.giw.invalidate();
        am.setViewTextColor(this.grd, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
        if (this.grh != null) {
            this.grh.onChangeSkinType(i);
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
        this.adG = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.grh != null) {
            this.grh.a(this.adG, bjVar.aKm());
        }
        if (bjVar.aKE() != null) {
            this.grd.setText(bjVar.aKE().getName_show());
        }
        this.gre.setText(aq.getFormatTime(bjVar.aKx() * 1000));
        String str = bjVar.aMg() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.grf.setText(spannableStringBuilder);
        l.a(this.grf, this.adG.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adG != null) {
            if (bEy() != null) {
                bEy().a(view, (View) this.adG, (Object) this.grg);
            }
            l.BB(this.adG.getTid());
            l.a(this.grf, this.adG.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bEZ();
        }
    }

    private void bEZ() {
        if (this.adG != null && this.adG.aKE() != null && this.adG.aKE().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.hW(true) && !com.baidu.tbadk.plugins.b.aZS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.adG.aKE().getName_show() + "", "3");
                createNormalConfig.setExtra(this.adG.getFid(), this.adG.aMk(), this.adG.aMl(), com.baidu.adp.lib.f.b.toLong(this.adG.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aOY().b(this.mPageContext, new String[]{this.adG.aMm()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }
}
