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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w extends b<cb> implements com.baidu.tieba.a.e {
    private cb aiB;
    private String ajx;
    private final View ghb;
    private TextView iAP;
    private TextView iAQ;
    private TextView iAR;
    private u iAS;
    private HeadImageView irV;
    private ConstrainImageGroup iyU;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.irV = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.irV.setIsRound(true);
        this.irV.setDefaultResource(R.drawable.pic_head_topic);
        this.iAP = (TextView) view.findViewById(R.id.card_topic_name);
        this.iAR = (TextView) view.findViewById(R.id.card_thread_title);
        this.iAQ = (TextView) view.findViewById(R.id.card_reply_time);
        this.iyU = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.ghb = view.findViewById(R.id.card_divider_line);
        this.iyU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.iyU.setImageProcessor(fVar);
        this.iyU.setSinglePicUseStyleV10(true);
        this.iyU.setFromCDN(true);
        this.iyU.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.irV.invalidate();
        ap.setViewTextColor(this.iAP, R.color.CAM_X0105);
        ap.setViewTextColor(this.iAQ, R.color.CAM_X0109);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
        this.iyU.onChangeSkinType();
        this.irV.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        if (cbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiB = cbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (cbVar.bnS() != null) {
            this.iAP.setText(cbVar.bnS().getName_show());
        }
        this.iAQ.setText(au.getFormatTime(cbVar.bnL() * 1000));
        String str = cbVar.bpz() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) cbVar.A(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.iAR.setText(spannableStringBuilder);
        ArrayList<MediaData> bob = cbVar.bob();
        if (com.baidu.tbadk.core.k.bkV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bob) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.iyU.setVisibility(0);
                this.iyU.setImageMediaList(arrayList);
            } else {
                this.iyU.setVisibility(8);
            }
        } else {
            this.iyU.setVisibility(8);
        }
        m.a(this.iAR, this.aiB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiB != null) {
            if (csi() != null) {
                csi().a(view, (View) this.aiB, (Object) this.iAS);
            }
            if (view == getView()) {
                m.IW(this.aiB.getTid());
                m.a(this.iAR, this.aiB.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                csI();
            }
        }
    }

    private void csI() {
        if (this.aiB != null && this.aiB.bnS() != null && this.aiB.bnS().getName_show() != null) {
            long fid = this.aiB.getFid();
            if (this.aiB.eUO != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.aiB.eUO.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.lq(true) && !com.baidu.tbadk.plugins.b.bEG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aiB.bnS().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aiB.bpC(), this.aiB.bpD(), com.baidu.adp.lib.f.b.toLong(this.aiB.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bsY().b(this.mPageContext, new String[]{this.aiB.bpE()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }
}
