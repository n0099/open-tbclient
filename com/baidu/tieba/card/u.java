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
    private bj adJ;
    private String aeB;
    private final View cDC;
    private HeadImageView giC;
    private ConstrainImageGroup gpx;
    private TextView grj;
    private TextView grk;
    private TextView grl;
    private s grm;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.giC = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.giC.setIsRound(true);
        this.giC.setDefaultResource(R.drawable.pic_head_topic);
        this.grj = (TextView) view.findViewById(R.id.card_topic_name);
        this.grl = (TextView) view.findViewById(R.id.card_thread_title);
        this.grk = (TextView) view.findViewById(R.id.card_reply_time);
        this.gpx = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cDC = view.findViewById(R.id.card_divider_line);
        this.gpx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.n(1.0d);
        this.gpx.setImageProcessor(fVar);
        this.gpx.setFromCDN(true);
        this.gpx.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.giC.invalidate();
        am.setViewTextColor(this.grj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.grk, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
        this.gpx.onChangeSkinType();
        this.giC.setDefaultBgResource(i);
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
        this.adJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bjVar.aKC() != null) {
            this.grj.setText(bjVar.aKC().getName_show());
        }
        this.grk.setText(aq.getFormatTime(bjVar.aKv() * 1000));
        String str = bjVar.aMe() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.grl.setText(spannableStringBuilder);
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (com.baidu.tbadk.core.i.aIc().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKM) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aKM.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.gpx.setVisibility(0);
                this.gpx.setImageMediaList(arrayList);
            } else {
                this.gpx.setVisibility(8);
            }
        } else {
            this.gpx.setVisibility(8);
        }
        l.a(this.grl, this.adJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adJ != null) {
            if (bEw() != null) {
                bEw().a(view, (View) this.adJ, (Object) this.grm);
            }
            if (view == getView()) {
                l.BE(this.adJ.getTid());
                l.a(this.grl, this.adJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bEX();
            }
        }
    }

    private void bEX() {
        if (this.adJ != null && this.adJ.aKC() != null && this.adJ.aKC().getName_show() != null) {
            long fid = this.adJ.getFid();
            if (this.adJ.dtD != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.adJ.dtD.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.hW(true) && !com.baidu.tbadk.plugins.b.aZQ()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.adJ.aKC().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.adJ.aMi(), this.adJ.aMj(), com.baidu.adp.lib.f.b.toLong(this.adJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aOV().b(this.mPageContext, new String[]{this.adJ.aMk()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public void a(s sVar) {
        this.grm = sVar;
    }
}
