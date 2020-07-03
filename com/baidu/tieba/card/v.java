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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class v extends b<bu> implements com.baidu.tieba.a.e {
    private bu aeK;
    private String afG;
    private final View eVD;
    private HeadImageView gKr;
    private ConstrainImageGroup gRn;
    private TextView gTc;
    private TextView gTd;
    private TextView gTe;
    private t gTf;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.gKr = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.gKr.setIsRound(true);
        this.gKr.setDefaultResource(R.drawable.pic_head_topic);
        this.gTc = (TextView) view.findViewById(R.id.card_topic_name);
        this.gTe = (TextView) view.findViewById(R.id.card_thread_title);
        this.gTd = (TextView) view.findViewById(R.id.card_reply_time);
        this.gRn = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.eVD = view.findViewById(R.id.card_divider_line);
        this.gRn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.o(1.0d);
        this.gRn.setImageProcessor(fVar);
        this.gRn.setSinglePicUseStyleV10(true);
        this.gRn.setFromCDN(true);
        this.gRn.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gKr.invalidate();
        an.setViewTextColor(this.gTc, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.gTd, (int) R.color.cp_cont_d);
        an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
        this.gRn.onChangeSkinType();
        this.gKr.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        if (buVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeK = buVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (buVar.aSp() != null) {
            this.gTc.setText(buVar.aSp().getName_show());
        }
        this.gTd.setText(ar.getFormatTime(buVar.aSi() * 1000));
        String str = buVar.aTU() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) buVar.x(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.gTe.setText(spannableStringBuilder);
        ArrayList<MediaData> aSy = buVar.aSy();
        if (com.baidu.tbadk.core.k.aPA().isShowImages() && com.baidu.tbadk.core.util.w.getCount(aSy) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.getCount(arrayList) > 0) {
                this.gRn.setVisibility(0);
                this.gRn.setImageMediaList(arrayList);
            } else {
                this.gRn.setVisibility(8);
            }
        } else {
            this.gRn.setVisibility(8);
        }
        m.a(this.gTe, this.aeK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeK != null) {
            if (bOc() != null) {
                bOc().a(view, (View) this.aeK, (Object) this.gTf);
            }
            if (view == getView()) {
                m.DO(this.aeK.getTid());
                m.a(this.gTe, this.aeK.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bOB();
            }
        }
    }

    private void bOB() {
        if (this.aeK != null && this.aeK.aSp() != null && this.aeK.aSp().getName_show() != null) {
            long fid = this.aeK.getFid();
            if (this.aeK.dOi != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.aeK.dOi.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.iB(true) && !com.baidu.tbadk.plugins.b.bih()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aeK.aSp().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aeK.aTX(), this.aeK.aTY(), com.baidu.adp.lib.f.b.toLong(this.aeK.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bc.aWU().b(this.mPageContext, new String[]{this.aeK.aTZ()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }
}
