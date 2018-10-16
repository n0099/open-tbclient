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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class z extends a<bb> implements com.baidu.tieba.a.e {
    private bb aAQ;
    private String bVS;
    private final View buH;
    private HeadImageView cPa;
    private TextView cPb;
    private TextView cPc;
    private TextView cPd;
    private w cPe;
    private FrsBaseVideoView cPf;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cPa = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cPa.setIsRound(true);
        this.cPa.setDefaultResource(e.f.pic_head_topic);
        this.cPb = (TextView) view.findViewById(e.g.card_topic_name);
        this.cPd = (TextView) view.findViewById(e.g.card_thread_title);
        this.cPc = (TextView) view.findViewById(e.g.card_reply_time);
        this.buH = view.findViewById(e.g.card_divider_line);
        this.cPf = (FrsBaseVideoView) view.findViewById(e.g.base_video_view);
        this.cPf.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cPa.invalidate();
        al.h(this.cPb, e.d.cp_cont_b);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.buH, e.d.cp_bg_line_e);
        if (this.cPf != null) {
            this.cPf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aAQ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cPf != null) {
            this.cPf.a(this.aAQ, bbVar.yf());
        }
        if (bbVar.yv() != null) {
            this.cPb.setText(bbVar.yv().getName_show());
        }
        this.cPc.setText(ao.C(bbVar.yo() * 1000));
        String str = bbVar.zP() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cPd.setText(spannableStringBuilder);
        o.a(this.cPd, this.aAQ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAQ != null) {
            if (anO() != null) {
                anO().a(view, this.aAQ, this.cPe);
            }
            o.md(this.aAQ.getTid());
            o.a(this.cPd, this.aAQ.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
            aop();
        }
    }

    private void aop() {
        if (this.aAQ != null && this.aAQ.yv() != null && this.aAQ.yv().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.cx(true) && !com.baidu.tbadk.plugins.b.Ok()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aAQ.yv().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aAQ.getFid(), this.aAQ.zT(), this.aAQ.zU(), com.baidu.adp.lib.g.b.d(this.aAQ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.CU().c(this.mPageContext, new String[]{this.aAQ.zV()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }
}
