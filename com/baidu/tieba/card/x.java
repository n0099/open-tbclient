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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class x extends a<bg> implements com.baidu.tieba.a.e {
    private bg XS;
    private String YA;
    private final View cKK;
    private HeadImageView eka;
    private TextView ekb;
    private TextView ekc;
    private TextView ekd;
    private u eke;
    private FrsBaseVideoView ekf;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eka = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.eka.setIsRound(true);
        this.eka.setDefaultResource(d.f.pic_head_topic);
        this.ekb = (TextView) view.findViewById(d.g.card_topic_name);
        this.ekd = (TextView) view.findViewById(d.g.card_thread_title);
        this.ekc = (TextView) view.findViewById(d.g.card_reply_time);
        this.cKK = view.findViewById(d.g.card_divider_line);
        this.ekf = (FrsBaseVideoView) view.findViewById(d.g.base_video_view);
        this.ekf.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eka.invalidate();
        al.j(this.ekb, d.C0277d.cp_cont_b);
        al.k(getView(), d.f.addresslist_item_bg);
        al.l(this.cKK, d.C0277d.cp_bg_line_e);
        if (this.ekf != null) {
            this.ekf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.XS = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ekf != null) {
            this.ekf.a(this.XS, bgVar.YA());
        }
        if (bgVar.YR() != null) {
            this.ekb.setText(bgVar.YR().getName_show());
        }
        this.ekc.setText(ap.ao(bgVar.YK() * 1000));
        String str = bgVar.aat() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 33);
        this.ekd.setText(spannableStringBuilder);
        n.a(this.ekd, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XS != null) {
            if (aQh() != null) {
                aQh().a(view, (View) this.XS, (Object) this.eke);
            }
            n.tA(this.XS.getTid());
            n.a(this.ekd, this.XS.getTid(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            aQG();
        }
    }

    private void aQG() {
        if (this.XS != null && this.XS.YR() != null && this.XS.YR().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fi(true) && !com.baidu.tbadk.plugins.b.apB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.XS.YR().getName_show() + "", "3");
                createNormalConfig.setExtra(this.XS.getFid(), this.XS.aax(), this.XS.aay(), com.baidu.adp.lib.g.b.d(this.XS.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.adD().c(this.mPageContext, new String[]{this.XS.aaz()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }
}
