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
public class x extends b<bw> implements com.baidu.tieba.a.e {
    private bw agx;
    private String ahu;
    private final View fQl;
    private HeadImageView hRe;
    private TextView hZV;
    private TextView hZW;
    private TextView hZX;
    private u hZY;
    private FrsBaseVideoView hZZ;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hRe = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hRe.setIsRound(true);
        this.hRe.setDefaultResource(R.drawable.pic_head_topic);
        this.hZV = (TextView) view.findViewById(R.id.card_topic_name);
        this.hZX = (TextView) view.findViewById(R.id.card_thread_title);
        this.hZW = (TextView) view.findViewById(R.id.card_reply_time);
        this.fQl = view.findViewById(R.id.card_divider_line);
        this.hZZ = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.hZZ.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hRe.invalidate();
        ap.setViewTextColor(this.hZV, R.color.cp_cont_b);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
        if (this.hZZ != null) {
            this.hZZ.onChangeSkinType(i);
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
        this.agx = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.hZZ != null) {
            this.hZZ.a(this.agx, bwVar.bmi());
        }
        if (bwVar.bmA() != null) {
            this.hZV.setText(bwVar.bmA().getName_show());
        }
        this.hZW.setText(at.getFormatTime(bwVar.bmt() * 1000));
        String str = bwVar.bof() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hZX.setText(spannableStringBuilder);
        n.a(this.hZX, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agx != null) {
            if (cnT() != null) {
                cnT().a(view, (View) this.agx, (Object) this.hZY);
            }
            n.IZ(this.agx.getTid());
            n.a(this.hZX, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
            cos();
        }
    }

    private void cos() {
        if (this.agx != null && this.agx.bmA() != null && this.agx.bmA().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.kB(true) && !com.baidu.tbadk.plugins.b.bCM()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agx.bmA().getName_show() + "", "3");
                createNormalConfig.setExtra(this.agx.getFid(), this.agx.boi(), this.agx.boj(), com.baidu.adp.lib.f.b.toLong(this.agx.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.brr().b(this.mPageContext, new String[]{this.agx.bok()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }
}
