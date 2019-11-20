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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class x extends a<bh> implements com.baidu.tieba.a.e {
    private bh Fs;
    private String Gc;
    private final View ddZ;
    private HeadImageView eFo;
    private TextView eOf;
    private TextView eOg;
    private TextView eOh;
    private u eOi;
    private FrsBaseVideoView eOj;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eFo = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.eFo.setIsRound(true);
        this.eFo.setDefaultResource(R.drawable.pic_head_topic);
        this.eOf = (TextView) view.findViewById(R.id.card_topic_name);
        this.eOh = (TextView) view.findViewById(R.id.card_thread_title);
        this.eOg = (TextView) view.findViewById(R.id.card_reply_time);
        this.ddZ = view.findViewById(R.id.card_divider_line);
        this.eOj = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.eOj.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eFo.invalidate();
        am.setViewTextColor(this.eOf, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
        if (this.eOj != null) {
            this.eOj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.Fs = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.eOj != null) {
            this.eOj.a(this.Fs, bhVar.ain());
        }
        if (bhVar.aiE() != null) {
            this.eOf.setText(bhVar.aiE().getName_show());
        }
        this.eOg.setText(aq.getFormatTime(bhVar.aix() * 1000));
        String str = bhVar.akf() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bhVar.s(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eOh.setText(spannableStringBuilder);
        n.a(this.eOh, this.Fs.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Fs != null) {
            if (aZV() != null) {
                aZV().a(view, (View) this.Fs, (Object) this.eOi);
            }
            n.uz(this.Fs.getTid());
            n.a(this.eOh, this.Fs.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bav();
        }
    }

    private void bav() {
        if (this.Fs != null && this.Fs.aiE() != null && this.Fs.aiE().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fA(true) && !com.baidu.tbadk.plugins.b.axb()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Fs.aiE().getName_show() + "", "3");
                createNormalConfig.setExtra(this.Fs.getFid(), this.Fs.akj(), this.Fs.akk(), com.baidu.adp.lib.g.b.toLong(this.Fs.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.amO().b(this.mPageContext, new String[]{this.Fs.akl()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }
}
