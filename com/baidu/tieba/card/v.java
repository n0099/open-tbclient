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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class v extends b<bw> implements com.baidu.tieba.a.e {
    private bw agf;
    private String ahc;
    private final View fpN;
    private HeadImageView hjQ;
    private ConstrainImageGroup hqS;
    private TextView hsH;
    private TextView hsI;
    private TextView hsJ;
    private t hsK;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hjQ = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hjQ.setIsRound(true);
        this.hjQ.setDefaultResource(R.drawable.pic_head_topic);
        this.hsH = (TextView) view.findViewById(R.id.card_topic_name);
        this.hsJ = (TextView) view.findViewById(R.id.card_thread_title);
        this.hsI = (TextView) view.findViewById(R.id.card_reply_time);
        this.hqS = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fpN = view.findViewById(R.id.card_divider_line);
        this.hqS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.u(1.0d);
        this.hqS.setImageProcessor(fVar);
        this.hqS.setSinglePicUseStyleV10(true);
        this.hqS.setFromCDN(true);
        this.hqS.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hjQ.invalidate();
        ap.setViewTextColor(this.hsH, R.color.cp_cont_b);
        ap.setViewTextColor(this.hsI, R.color.cp_cont_d);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
        this.hqS.onChangeSkinType();
        this.hjQ.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agf = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bwVar.bfy() != null) {
            this.hsH.setText(bwVar.bfy().getName_show());
        }
        this.hsI.setText(at.getFormatTime(bwVar.bfr() * 1000));
        String str = bwVar.bhd() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hsJ.setText(spannableStringBuilder);
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (com.baidu.tbadk.core.k.bcG().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bfH) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hqS.setVisibility(0);
                this.hqS.setImageMediaList(arrayList);
            } else {
                this.hqS.setVisibility(8);
            }
        } else {
            this.hqS.setVisibility(8);
        }
        m.a(this.hsJ, this.agf.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agf != null) {
            if (ceP() != null) {
                ceP().a(view, (View) this.agf, (Object) this.hsK);
            }
            if (view == getView()) {
                m.Hw(this.agf.getTid());
                m.a(this.hsJ, this.agf.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                cfo();
            }
        }
    }

    private void cfo() {
        if (this.agf != null && this.agf.bfy() != null && this.agf.bfy().getName_show() != null) {
            long fid = this.agf.getFid();
            if (this.agf.egd != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.agf.egd.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.jH(true) && !com.baidu.tbadk.plugins.b.bvK()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agf.bfy().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.agf.bhg(), this.agf.bhh(), com.baidu.adp.lib.f.b.toLong(this.agf.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bkp().b(this.mPageContext, new String[]{this.agf.bhi()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }
}
