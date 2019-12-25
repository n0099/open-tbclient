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
/* loaded from: classes5.dex */
public class u extends a<bj> implements com.baidu.tieba.a.e {
    private bj Ki;
    private String La;
    private final View bZT;
    private ConstrainImageGroup fEg;
    private TextView fFS;
    private TextView fFT;
    private TextView fFU;
    private s fFV;
    private HeadImageView fxm;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fxm = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fxm.setIsRound(true);
        this.fxm.setDefaultResource(R.drawable.pic_head_topic);
        this.fFS = (TextView) view.findViewById(R.id.card_topic_name);
        this.fFU = (TextView) view.findViewById(R.id.card_thread_title);
        this.fFT = (TextView) view.findViewById(R.id.card_reply_time);
        this.fEg = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.bZT = view.findViewById(R.id.card_divider_line);
        this.fEg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.fEg.setImageProcessor(fVar);
        this.fEg.setFromCDN(true);
        this.fEg.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fxm.invalidate();
        am.setViewTextColor(this.fFS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fFT, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
        this.fEg.onChangeSkinType();
        this.fxm.setDefaultBgResource(i);
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
        this.Ki = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bjVar.azE() != null) {
            this.fFS.setText(bjVar.azE().getName_show());
        }
        this.fFT.setText(aq.getFormatTime(bjVar.azx() * 1000));
        String str = bjVar.aBg() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.s(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fFU.setText(spannableStringBuilder);
        ArrayList<MediaData> azO = bjVar.azO();
        if (com.baidu.tbadk.core.i.axf().isShowImages() && com.baidu.tbadk.core.util.v.getCount(azO) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < azO.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.fEg.setVisibility(0);
                this.fEg.setImageMediaList(arrayList);
            } else {
                this.fEg.setVisibility(8);
            }
        } else {
            this.fEg.setVisibility(8);
        }
        l.a(this.fFU, this.Ki.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ki != null) {
            if (brY() != null) {
                brY().a(view, (View) this.Ki, (Object) this.fFV);
            }
            if (view == getView()) {
                l.zs(this.Ki.getTid());
                l.a(this.fFU, this.Ki.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bsz();
            }
        }
    }

    private void bsz() {
        if (this.Ki != null && this.Ki.azE() != null && this.Ki.azE().getName_show() != null) {
            long fid = this.Ki.getFid();
            if (this.Ki.cPN != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.Ki.cPN.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.gL(true) && !com.baidu.tbadk.plugins.b.aOS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Ki.azE().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.Ki.aBk(), this.Ki.aBl(), com.baidu.adp.lib.f.b.toLong(this.Ki.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aEa().b(this.mPageContext, new String[]{this.Ki.aBm()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public void a(s sVar) {
        this.fFV = sVar;
    }
}
