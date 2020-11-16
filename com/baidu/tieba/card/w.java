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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class w extends b<bx> implements com.baidu.tieba.a.e {
    private bx agB;
    private String ahw;
    private final View fPU;
    private HeadImageView hRE;
    private ConstrainImageGroup hYG;
    private TextView iaw;
    private TextView iax;
    private TextView iay;
    private u iaz;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hRE = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hRE.setIsRound(true);
        this.hRE.setDefaultResource(R.drawable.pic_head_topic);
        this.iaw = (TextView) view.findViewById(R.id.card_topic_name);
        this.iay = (TextView) view.findViewById(R.id.card_thread_title);
        this.iax = (TextView) view.findViewById(R.id.card_reply_time);
        this.hYG = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fPU = view.findViewById(R.id.card_divider_line);
        this.hYG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.hYG.setImageProcessor(fVar);
        this.hYG.setSinglePicUseStyleV10(true);
        this.hYG.setFromCDN(true);
        this.hYG.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hRE.invalidate();
        ap.setViewTextColor(this.iaw, R.color.CAM_X0105);
        ap.setViewTextColor(this.iax, R.color.CAM_X0109);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fPU, R.color.CAM_X0204);
        this.hYG.onChangeSkinType();
        this.hRE.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        if (bxVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agB = bxVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bxVar.blC() != null) {
            this.iaw.setText(bxVar.blC().getName_show());
        }
        this.iax.setText(au.getFormatTime(bxVar.blv() * 1000));
        String str = bxVar.bnj() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bxVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.iay.setText(spannableStringBuilder);
        ArrayList<MediaData> blL = bxVar.blL();
        if (com.baidu.tbadk.core.k.biL().isShowImages() && com.baidu.tbadk.core.util.y.getCount(blL) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hYG.setVisibility(0);
                this.hYG.setImageMediaList(arrayList);
            } else {
                this.hYG.setVisibility(8);
            }
        } else {
            this.hYG.setVisibility(8);
        }
        n.a(this.iay, this.agB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agB != null) {
            if (cnv() != null) {
                cnv().a(view, (View) this.agB, (Object) this.iaz);
            }
            if (view == getView()) {
                n.IA(this.agB.getTid());
                n.a(this.iay, this.agB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                cnU();
            }
        }
    }

    private void cnU() {
        if (this.agB != null && this.agB.blC() != null && this.agB.blC().getName_show() != null) {
            long fid = this.agB.getFid();
            if (this.agB.eEQ != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.agB.eEQ.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.kC(true) && !com.baidu.tbadk.plugins.b.bCf()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agB.blC().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.agB.bnm(), this.agB.bnn(), com.baidu.adp.lib.f.b.toLong(this.agB.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bqF().b(this.mPageContext, new String[]{this.agB.bno()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYG != null) {
            this.hYG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYG != null) {
            this.hYG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }
}
