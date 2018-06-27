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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class z extends a<bc> implements com.baidu.tieba.a.e {
    private bc atZ;
    private String bGM;
    private final View bjZ;
    private HeadImageView cyo;
    private TextView cyp;
    private TextView cyq;
    private TextView cyr;
    private w cys;
    private FrsBaseVideoView cyt;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cyo = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.cyo.setIsRound(true);
        this.cyo.setDefaultResource(d.f.pic_head_topic);
        this.cyp = (TextView) view.findViewById(d.g.card_topic_name);
        this.cyr = (TextView) view.findViewById(d.g.card_thread_title);
        this.cyq = (TextView) view.findViewById(d.g.card_reply_time);
        this.bjZ = view.findViewById(d.g.card_divider_line);
        this.cyt = (FrsBaseVideoView) view.findViewById(d.g.base_video_view);
        this.cyt.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cyo.invalidate();
        am.h(this.cyp, d.C0142d.cp_cont_b);
        am.i(getView(), d.f.addresslist_item_bg);
        am.j(this.bjZ, d.C0142d.cp_bg_line_e);
        if (this.cyt != null) {
            this.cyt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        if (bcVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atZ = bcVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cyt != null) {
            this.cyt.a(this.atZ, bcVar.vg());
        }
        if (bcVar.vw() != null) {
            this.cyp.setText(bcVar.vw().getName_show());
        }
        this.cyq.setText(ap.w(bcVar.vp() * 1000));
        String str = bcVar.wL() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bcVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_c)), 0, str.length(), 33);
        this.cyr.setText(spannableStringBuilder);
        o.a(this.cyr, this.atZ.getTid(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atZ != null) {
            if (aia() != null) {
                aia().a(view, this.atZ, this.cys);
            }
            o.kY(this.atZ.getTid());
            o.a(this.cyr, this.atZ.getTid(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            aiA();
        }
    }

    private void aiA() {
        if (this.atZ != null && this.atZ.vw() != null && this.atZ.vw().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.cd(true) && !com.baidu.tbadk.plugins.b.KX()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.atZ.vw().getName_show() + "", "3");
                createNormalConfig.setExtra(this.atZ.getFid(), this.atZ.wP(), this.atZ.wQ(), com.baidu.adp.lib.g.b.c(this.atZ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            az.zV().c(this.mPageContext, new String[]{this.atZ.wR()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }
}
