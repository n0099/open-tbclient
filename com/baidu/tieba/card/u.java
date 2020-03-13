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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class u extends a<bj> implements com.baidu.tieba.a.e {
    private bj KJ;
    private String LC;
    private final View cen;
    private HeadImageView fDk;
    private ConstrainImageGroup fKc;
    private TextView fLO;
    private TextView fLP;
    private TextView fLQ;
    private s fLR;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fDk = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fDk.setIsRound(true);
        this.fDk.setDefaultResource(R.drawable.pic_head_topic);
        this.fLO = (TextView) view.findViewById(R.id.card_topic_name);
        this.fLQ = (TextView) view.findViewById(R.id.card_thread_title);
        this.fLP = (TextView) view.findViewById(R.id.card_reply_time);
        this.fKc = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cen = view.findViewById(R.id.card_divider_line);
        this.fKc.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.fKc.setImageProcessor(fVar);
        this.fKc.setFromCDN(true);
        this.fKc.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fDk.invalidate();
        am.setViewTextColor(this.fLO, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fLP, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cen, R.color.cp_bg_line_c);
        this.fKc.onChangeSkinType();
        this.fDk.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.KJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bjVar.aCo() != null) {
            this.fLO.setText(bjVar.aCo().getName_show());
        }
        this.fLP.setText(aq.getFormatTime(bjVar.aCh() * 1000));
        String str = bjVar.aDO() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.v(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fLQ.setText(spannableStringBuilder);
        ArrayList<MediaData> aCy = bjVar.aCy();
        if (com.baidu.tbadk.core.i.azO().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCy) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aCy.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.fKc.setVisibility(0);
                this.fKc.setImageMediaList(arrayList);
            } else {
                this.fKc.setVisibility(8);
            }
        } else {
            this.fKc.setVisibility(8);
        }
        l.a(this.fLQ, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KJ != null) {
            if (buH() != null) {
                buH().a(view, (View) this.KJ, (Object) this.fLR);
            }
            if (view == getView()) {
                l.zT(this.KJ.getTid());
                l.a(this.fLQ, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bvi();
            }
        }
    }

    private void bvi() {
        if (this.KJ != null && this.KJ.aCo() != null && this.KJ.aCo().getName_show() != null) {
            long fid = this.KJ.getFid();
            if (this.KJ.cUb != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.KJ.cUb.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.gX(true) && !com.baidu.tbadk.plugins.b.aRE()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.KJ.aCo().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.KJ.aDS(), this.KJ.aDT(), com.baidu.adp.lib.f.b.toLong(this.KJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aGG().b(this.mPageContext, new String[]{this.KJ.aDU()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKc != null) {
            this.fKc.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKc != null) {
            this.fKc.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public void a(s sVar) {
        this.fLR = sVar;
    }
}
