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
/* loaded from: classes6.dex */
public class u extends a<bj> implements com.baidu.tieba.a.e {
    private bj Kn;
    private String Lg;
    private final View caf;
    private HeadImageView fAx;
    private ConstrainImageGroup fHq;
    private TextView fJc;
    private TextView fJd;
    private TextView fJe;
    private s fJf;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fAx = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fAx.setIsRound(true);
        this.fAx.setDefaultResource(R.drawable.pic_head_topic);
        this.fJc = (TextView) view.findViewById(R.id.card_topic_name);
        this.fJe = (TextView) view.findViewById(R.id.card_thread_title);
        this.fJd = (TextView) view.findViewById(R.id.card_reply_time);
        this.fHq = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.caf = view.findViewById(R.id.card_divider_line);
        this.fHq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.fHq.setImageProcessor(fVar);
        this.fHq.setFromCDN(true);
        this.fHq.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fAx.invalidate();
        am.setViewTextColor(this.fJc, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fJd, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.caf, R.color.cp_bg_line_c);
        this.fHq.onChangeSkinType();
        this.fAx.setDefaultBgResource(i);
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
        this.Kn = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bjVar.azX() != null) {
            this.fJc.setText(bjVar.azX().getName_show());
        }
        this.fJd.setText(aq.getFormatTime(bjVar.azQ() * 1000));
        String str = bjVar.aBz() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.r(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fJe.setText(spannableStringBuilder);
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (com.baidu.tbadk.core.i.axy().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aAh) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.fHq.setVisibility(0);
                this.fHq.setImageMediaList(arrayList);
            } else {
                this.fHq.setVisibility(8);
            }
        } else {
            this.fHq.setVisibility(8);
        }
        l.a(this.fJe, this.Kn.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Kn != null) {
            if (bta() != null) {
                bta().a(view, (View) this.Kn, (Object) this.fJf);
            }
            if (view == getView()) {
                l.zC(this.Kn.getTid());
                l.a(this.fJe, this.Kn.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                btB();
            }
        }
    }

    private void btB() {
        if (this.Kn != null && this.Kn.azX() != null && this.Kn.azX().getName_show() != null) {
            long fid = this.Kn.getFid();
            if (this.Kn.cPX != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.Kn.cPX.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.gQ(true) && !com.baidu.tbadk.plugins.b.aPl()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Kn.azX().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.Kn.aBD(), this.Kn.aBE(), com.baidu.adp.lib.f.b.toLong(this.Kn.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aEt().b(this.mPageContext, new String[]{this.Kn.aBF()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fHq != null) {
            this.fHq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fHq != null) {
            this.fHq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public void a(s sVar) {
        this.fJf = sVar;
    }
}
