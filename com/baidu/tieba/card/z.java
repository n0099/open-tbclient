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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class z extends a<bb> implements com.baidu.tieba.a.e {
    private bb atD;
    private String bHB;
    private final View bkE;
    private HeadImageView cAR;
    private TextView cAS;
    private TextView cAT;
    private TextView cAU;
    private w cAV;
    private FrsBaseVideoView cAW;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cAR = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.cAR.setIsRound(true);
        this.cAR.setDefaultResource(d.f.pic_head_topic);
        this.cAS = (TextView) view.findViewById(d.g.card_topic_name);
        this.cAU = (TextView) view.findViewById(d.g.card_thread_title);
        this.cAT = (TextView) view.findViewById(d.g.card_reply_time);
        this.bkE = view.findViewById(d.g.card_divider_line);
        this.cAW = (FrsBaseVideoView) view.findViewById(d.g.base_video_view);
        this.cAW.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cAR.invalidate();
        am.h(this.cAS, d.C0140d.cp_cont_b);
        am.i(getView(), d.f.addresslist_item_bg);
        am.j(this.bkE, d.C0140d.cp_bg_line_e);
        if (this.cAW != null) {
            this.cAW.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_hottopic_video_card;
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
        this.atD = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cAW != null) {
            this.cAW.a(this.atD, bbVar.uU());
        }
        if (bbVar.vk() != null) {
            this.cAS.setText(bbVar.vk().getName_show());
        }
        this.cAT.setText(ap.w(bbVar.vd() * 1000));
        String str = bbVar.wA() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_c)), 0, str.length(), 33);
        this.cAU.setText(spannableStringBuilder);
        o.a(this.cAU, this.atD.getTid(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atD != null) {
            if (aiz() != null) {
                aiz().a(view, this.atD, this.cAV);
            }
            o.kW(this.atD.getTid());
            o.a(this.cAU, this.atD.getTid(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            aiZ();
        }
    }

    private void aiZ() {
        if (this.atD != null && this.atD.vk() != null && this.atD.vk().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.cb(true) && !com.baidu.tbadk.plugins.b.KS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.atD.vk().getName_show() + "", "3");
                createNormalConfig.setExtra(this.atD.getFid(), this.atD.wE(), this.atD.wF(), com.baidu.adp.lib.g.b.c(this.atD.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.zK().c(this.mPageContext, new String[]{this.atD.wG()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }
}
