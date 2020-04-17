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
    private bj adG;
    private String aey;
    private final View cDw;
    private HeadImageView giw;
    private ConstrainImageGroup gpr;
    private TextView grd;
    private TextView gre;
    private TextView grf;
    private s grg;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.giw = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.giw.setIsRound(true);
        this.giw.setDefaultResource(R.drawable.pic_head_topic);
        this.grd = (TextView) view.findViewById(R.id.card_topic_name);
        this.grf = (TextView) view.findViewById(R.id.card_thread_title);
        this.gre = (TextView) view.findViewById(R.id.card_reply_time);
        this.gpr = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cDw = view.findViewById(R.id.card_divider_line);
        this.gpr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.n(1.0d);
        this.gpr.setImageProcessor(fVar);
        this.gpr.setFromCDN(true);
        this.gpr.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.giw.invalidate();
        am.setViewTextColor(this.grd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gre, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
        this.gpr.onChangeSkinType();
        this.giw.setDefaultBgResource(i);
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
        this.adG = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bjVar.aKE() != null) {
            this.grd.setText(bjVar.aKE().getName_show());
        }
        this.gre.setText(aq.getFormatTime(bjVar.aKx() * 1000));
        String str = bjVar.aMg() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.u(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.grf.setText(spannableStringBuilder);
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (com.baidu.tbadk.core.i.aIe().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKO) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.gpr.setVisibility(0);
                this.gpr.setImageMediaList(arrayList);
            } else {
                this.gpr.setVisibility(8);
            }
        } else {
            this.gpr.setVisibility(8);
        }
        l.a(this.grf, this.adG.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adG != null) {
            if (bEy() != null) {
                bEy().a(view, (View) this.adG, (Object) this.grg);
            }
            if (view == getView()) {
                l.BB(this.adG.getTid());
                l.a(this.grf, this.adG.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bEZ();
            }
        }
    }

    private void bEZ() {
        if (this.adG != null && this.adG.aKE() != null && this.adG.aKE().getName_show() != null) {
            long fid = this.adG.getFid();
            if (this.adG.dtz != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.adG.dtz.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.hW(true) && !com.baidu.tbadk.plugins.b.aZS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.adG.aKE().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.adG.aMk(), this.adG.aMl(), com.baidu.adp.lib.f.b.toLong(this.adG.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aOY().b(this.mPageContext, new String[]{this.adG.aMm()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public void a(s sVar) {
        this.grg = sVar;
    }
}
