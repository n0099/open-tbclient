package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class z extends a<bb> implements com.baidu.tieba.a.e {
    private bb atE;
    private String bHB;
    private final View bkJ;
    private HeadImageView cAO;
    private TextView cAP;
    private TextView cAQ;
    private TextView cAR;
    private w cAS;
    private FrsBaseVideoView cAT;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cAO = (HeadImageView) view.findViewById(f.g.topic_icon);
        this.cAO.setIsRound(true);
        this.cAO.setDefaultResource(f.C0146f.pic_head_topic);
        this.cAP = (TextView) view.findViewById(f.g.card_topic_name);
        this.cAR = (TextView) view.findViewById(f.g.card_thread_title);
        this.cAQ = (TextView) view.findViewById(f.g.card_reply_time);
        this.bkJ = view.findViewById(f.g.card_divider_line);
        this.cAT = (FrsBaseVideoView) view.findViewById(f.g.base_video_view);
        this.cAT.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cAO.invalidate();
        am.h(this.cAP, f.d.cp_cont_b);
        am.i(getView(), f.C0146f.addresslist_item_bg);
        am.j(this.bkJ, f.d.cp_bg_line_e);
        if (this.cAT != null) {
            this.cAT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atE = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cAT != null) {
            this.cAT.a(this.atE, bbVar.uT());
        }
        if (bbVar.vj() != null) {
            this.cAP.setText(bbVar.vj().getName_show());
        }
        this.cAQ.setText(ap.w(bbVar.vc() * 1000));
        String str = bbVar.wz() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cAR.setText(spannableStringBuilder);
        o.a(this.cAR, this.atE.getTid(), f.d.cp_cont_b, f.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atE != null) {
            if (aiC() != null) {
                aiC().a(view, this.atE, this.cAS);
            }
            o.kY(this.atE.getTid());
            o.a(this.cAR, this.atE.getTid(), f.d.cp_cont_b, f.d.cp_cont_d);
            ajc();
        }
    }

    private void ajc() {
        if (this.atE != null && this.atE.vj() != null && this.atE.vj().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.cc(true) && !com.baidu.tbadk.plugins.b.KW()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.atE.vj().getName_show() + "", "3");
                createNormalConfig.setExtra(this.atE.getFid(), this.atE.wD(), this.atE.wE(), com.baidu.adp.lib.g.b.c(this.atE.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            az.zI().c(this.mPageContext, new String[]{this.atE.wF()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }
}
