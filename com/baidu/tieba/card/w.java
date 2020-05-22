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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class w extends b<bk> implements com.baidu.tieba.a.e {
    private String aeX;
    private bk aee;
    private final View eLg;
    private TextView gFY;
    private TextView gFZ;
    private TextView gGa;
    private t gGb;
    private FrsBaseVideoView gGc;
    private HeadImageView gxs;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.gxs = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.gxs.setIsRound(true);
        this.gxs.setDefaultResource(R.drawable.pic_head_topic);
        this.gFY = (TextView) view.findViewById(R.id.card_topic_name);
        this.gGa = (TextView) view.findViewById(R.id.card_thread_title);
        this.gFZ = (TextView) view.findViewById(R.id.card_reply_time);
        this.eLg = view.findViewById(R.id.card_divider_line);
        this.gGc = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.gGc.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gxs.invalidate();
        am.setViewTextColor(this.gFY, (int) R.color.cp_cont_b);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
        if (this.gGc != null) {
            this.gGc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aee = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.gGc != null) {
            this.gGc.a(this.aee, bkVar.aQf());
        }
        if (bkVar.aQx() != null) {
            this.gFY.setText(bkVar.aQx().getName_show());
        }
        this.gFZ.setText(aq.getFormatTime(bkVar.aQq() * 1000));
        String str = bkVar.aSd() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bkVar.x(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.gGa.setText(spannableStringBuilder);
        m.a(this.gGa, this.aee.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aee != null) {
            if (bKS() != null) {
                bKS().a(view, (View) this.aee, (Object) this.gGb);
            }
            m.Dn(this.aee.getTid());
            m.a(this.gGa, this.aee.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            bLr();
        }
    }

    private void bLr() {
        if (this.aee != null && this.aee.aQx() != null && this.aee.aQx().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.is(true) && !com.baidu.tbadk.plugins.b.bga()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aee.aQx().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aee.getFid(), this.aee.aSh(), this.aee.aSi(), com.baidu.adp.lib.f.b.toLong(this.aee.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aUZ().b(this.mPageContext, new String[]{this.aee.aSj()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }
}
