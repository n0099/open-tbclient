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
    private final View cey;
    private HeadImageView fDS;
    private ConstrainImageGroup fKK;
    private TextView fMw;
    private TextView fMx;
    private TextView fMy;
    private s fMz;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.fDS = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.fDS.setIsRound(true);
        this.fDS.setDefaultResource(R.drawable.pic_head_topic);
        this.fMw = (TextView) view.findViewById(R.id.card_topic_name);
        this.fMy = (TextView) view.findViewById(R.id.card_thread_title);
        this.fMx = (TextView) view.findViewById(R.id.card_reply_time);
        this.fKK = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cey = view.findViewById(R.id.card_divider_line);
        this.fKK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.fKK.setImageProcessor(fVar);
        this.fKK.setFromCDN(true);
        this.fKK.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fDS.invalidate();
        am.setViewTextColor(this.fMw, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fMx, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
        this.fKK.onChangeSkinType();
        this.fDS.setDefaultBgResource(i);
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
        if (bjVar.aCr() != null) {
            this.fMw.setText(bjVar.aCr().getName_show());
        }
        this.fMx.setText(aq.getFormatTime(bjVar.aCk() * 1000));
        String str = bjVar.aDS() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bjVar.v(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.fMy.setText(spannableStringBuilder);
        ArrayList<MediaData> aCB = bjVar.aCB();
        if (com.baidu.tbadk.core.i.azR().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCB) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aCB.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.fKK.setVisibility(0);
                this.fKK.setImageMediaList(arrayList);
            } else {
                this.fKK.setVisibility(8);
            }
        } else {
            this.fKK.setVisibility(8);
        }
        l.a(this.fMy, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KJ != null) {
            if (buM() != null) {
                buM().a(view, (View) this.KJ, (Object) this.fMz);
            }
            if (view == getView()) {
                l.zV(this.KJ.getTid());
                l.a(this.fMy, this.KJ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bvn();
            }
        }
    }

    private void bvn() {
        if (this.KJ != null && this.KJ.aCr() != null && this.KJ.aCr().getName_show() != null) {
            long fid = this.KJ.getFid();
            if (this.KJ.cUo != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.KJ.cUo.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.gY(true) && !com.baidu.tbadk.plugins.b.aRI()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.KJ.aCr().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.KJ.aDW(), this.KJ.aDX(), com.baidu.adp.lib.f.b.toLong(this.KJ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aGK().b(this.mPageContext, new String[]{this.KJ.aDY()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKK != null) {
            this.fKK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKK != null) {
            this.fKK.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public void a(s sVar) {
        this.fMz = sVar;
    }
}
