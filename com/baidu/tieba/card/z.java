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
    private bb aBF;
    private String bWE;
    private final View bvs;
    private HeadImageView cQg;
    private TextView cQh;
    private TextView cQi;
    private TextView cQj;
    private w cQk;
    private FrsBaseVideoView cQl;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cQg = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cQg.setIsRound(true);
        this.cQg.setDefaultResource(e.f.pic_head_topic);
        this.cQh = (TextView) view.findViewById(e.g.card_topic_name);
        this.cQj = (TextView) view.findViewById(e.g.card_thread_title);
        this.cQi = (TextView) view.findViewById(e.g.card_reply_time);
        this.bvs = view.findViewById(e.g.card_divider_line);
        this.cQl = (FrsBaseVideoView) view.findViewById(e.g.base_video_view);
        this.cQl.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cQg.invalidate();
        al.h(this.cQh, e.d.cp_cont_b);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.bvs, e.d.cp_bg_line_e);
        if (this.cQl != null) {
            this.cQl.onChangeSkinType(i);
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
        this.aBF = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cQl != null) {
            this.cQl.a(this.aBF, bbVar.ym());
        }
        if (bbVar.yC() != null) {
            this.cQh.setText(bbVar.yC().getName_show());
        }
        this.cQi.setText(ao.E(bbVar.yv() * 1000));
        String str = bbVar.zW() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cQj.setText(spannableStringBuilder);
        o.a(this.cQj, this.aBF.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBF != null) {
            if (anq() != null) {
                anq().a(view, this.aBF, this.cQk);
            }
            o.me(this.aBF.getTid());
            o.a(this.cQj, this.aBF.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
            anR();
        }
    }

    private void anR() {
        if (this.aBF != null && this.aBF.yC() != null && this.aBF.yC().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.cO(true) && !com.baidu.tbadk.plugins.b.Ot()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aBF.yC().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aBF.getFid(), this.aBF.Aa(), this.aBF.Ab(), com.baidu.adp.lib.g.b.d(this.aBF.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.Db().c(this.mPageContext, new String[]{this.aBF.Ac()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }
}
