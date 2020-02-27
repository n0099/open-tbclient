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
    private final View cel;
    private HeadImageView fCV;
    private ConstrainImageGroup fJN;
    private TextView fLA;
    private TextView fLB;
    private s fLC;
    private TextView fLz;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fCV = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fCV.setIsRound(true);
        this.fCV.setDefaultResource(R.drawable.pic_head_topic);
        this.fLz = (TextView) view.findViewById(R.id.card_topic_name);
        this.fLB = (TextView) view.findViewById(R.id.card_thread_title);
        this.fLA = (TextView) view.findViewById(R.id.card_reply_time);
        this.fJN = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cel = view.findViewById(R.id.card_divider_line);
        this.fJN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.fJN.setImageProcessor(fVar);
        this.fJN.setFromCDN(true);
        this.fJN.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fCV.invalidate();
        am.setViewTextColor(this.fLz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fLA, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
        this.fJN.onChangeSkinType();
        this.fCV.setDefaultBgResource(i);
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
        if (bjVar.aCm() != null) {
            this.fLz.setText(bjVar.aCm().getName_show());
        }
        this.fLA.setText(aq.getFormatTime(bjVar.aCf() * 1000));
        String str = bjVar.aDM() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fLB.setText(spannableStringBuilder);
        ArrayList<MediaData> aCw = bjVar.aCw();
        if (com.baidu.tbadk.core.i.azM().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCw) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aCw.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.fJN.setVisibility(0);
                this.fJN.setImageMediaList(arrayList);
            } else {
                this.fJN.setVisibility(8);
            }
        } else {
            this.fJN.setVisibility(8);
        }
        l.a(this.fLB, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KJ != null) {
            if (buE() != null) {
                buE().a(view, (View) this.KJ, (Object) this.fLC);
            }
            if (view == getView()) {
                l.zS(this.KJ.getTid());
                l.a(this.fLB, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bvf();
            }
        }
    }

    private void bvf() {
        if (this.KJ != null && this.KJ.aCm() != null && this.KJ.aCm().getName_show() != null) {
            long fid = this.KJ.getFid();
            if (this.KJ.cTZ != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.KJ.cTZ.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.gX(true) && !com.baidu.tbadk.plugins.b.aRB()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.KJ.aCm().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.KJ.aDQ(), this.KJ.aDR(), com.baidu.adp.lib.f.b.toLong(this.KJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aGE().b(this.mPageContext, new String[]{this.KJ.aDS()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJN != null) {
            this.fJN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJN != null) {
            this.fJN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public void a(s sVar) {
        this.fLC = sVar;
    }
}
