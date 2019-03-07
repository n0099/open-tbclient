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
import com.baidu.tieba.a.e;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class x extends a<bg> implements e {
    private bg XR;
    private String Yz;
    private final View cKN;
    private HeadImageView eke;
    private TextView ekf;
    private TextView ekg;
    private TextView ekh;
    private u eki;
    private FrsBaseVideoView ekj;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eke = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.eke.setIsRound(true);
        this.eke.setDefaultResource(d.f.pic_head_topic);
        this.ekf = (TextView) view.findViewById(d.g.card_topic_name);
        this.ekh = (TextView) view.findViewById(d.g.card_thread_title);
        this.ekg = (TextView) view.findViewById(d.g.card_reply_time);
        this.cKN = view.findViewById(d.g.card_divider_line);
        this.ekj = (FrsBaseVideoView) view.findViewById(d.g.base_video_view);
        this.ekj.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eke.invalidate();
        al.j(this.ekf, d.C0236d.cp_cont_b);
        al.k(getView(), d.f.addresslist_item_bg);
        al.l(this.cKN, d.C0236d.cp_bg_line_e);
        if (this.ekj != null) {
            this.ekj.onChangeSkinType(i);
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
        this.XR = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ekj != null) {
            this.ekj.a(this.XR, bgVar.YA());
        }
        if (bgVar.YR() != null) {
            this.ekf.setText(bgVar.YR().getName_show());
        }
        this.ekg.setText(ap.ao(bgVar.YK() * 1000));
        String str = bgVar.aat() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.m(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_c)), 0, str.length(), 33);
        this.ekh.setText(spannableStringBuilder);
        n.a(this.ekh, this.XR.getTid(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XR != null) {
            if (aQh() != null) {
                aQh().a(view, (View) this.XR, (Object) this.eki);
            }
            n.tB(this.XR.getTid());
            n.a(this.ekh, this.XR.getTid(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            aQG();
        }
    }

    private void aQG() {
        if (this.XR != null && this.XR.YR() != null && this.XR.YR().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.fi(true) && !com.baidu.tbadk.plugins.b.apC()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.XR.YR().getName_show() + "", "3");
                createNormalConfig.setExtra(this.XR.getFid(), this.XR.aax(), this.XR.aay(), com.baidu.adp.lib.g.b.d(this.XR.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.adD().c(this.mPageContext, new String[]{this.XR.aaz()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }
}
