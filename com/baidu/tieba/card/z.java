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
/* loaded from: classes2.dex */
public class z extends a<bb> implements com.baidu.tieba.a.e {
    private bb awf;
    private String bNq;
    private final View bqy;
    private HeadImageView cGG;
    private TextView cGH;
    private TextView cGI;
    private TextView cGJ;
    private w cGK;
    private FrsBaseVideoView cGL;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cGG = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cGG.setIsRound(true);
        this.cGG.setDefaultResource(e.f.pic_head_topic);
        this.cGH = (TextView) view.findViewById(e.g.card_topic_name);
        this.cGJ = (TextView) view.findViewById(e.g.card_thread_title);
        this.cGI = (TextView) view.findViewById(e.g.card_reply_time);
        this.bqy = view.findViewById(e.g.card_divider_line);
        this.cGL = (FrsBaseVideoView) view.findViewById(e.g.base_video_view);
        this.cGL.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cGG.invalidate();
        al.h(this.cGH, e.d.cp_cont_b);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.bqy, e.d.cp_bg_line_e);
        if (this.cGL != null) {
            this.cGL.onChangeSkinType(i);
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
        this.awf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.cGL != null) {
            this.cGL.a(this.awf, bbVar.vW());
        }
        if (bbVar.wm() != null) {
            this.cGH.setText(bbVar.wm().getName_show());
        }
        this.cGI.setText(ao.A(bbVar.wf() * 1000));
        String str = bbVar.xG() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cGJ.setText(spannableStringBuilder);
        o.a(this.cGJ, this.awf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.awf != null) {
            if (akm() != null) {
                akm().a(view, this.awf, this.cGK);
            }
            o.lA(this.awf.getTid());
            o.a(this.cGJ, this.awf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
            akN();
        }
    }

    private void akN() {
        if (this.awf != null && this.awf.wm() != null && this.awf.wm().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.co(true) && !com.baidu.tbadk.plugins.b.Mm()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.awf.wm().getName_show() + "", "3");
                createNormalConfig.setExtra(this.awf.getFid(), this.awf.xK(), this.awf.xL(), com.baidu.adp.lib.g.b.d(this.awf.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.AN().c(this.mPageContext, new String[]{this.awf.xM()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }
}
