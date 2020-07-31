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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class v extends b<bv> implements com.baidu.tieba.a.e {
    private bv aeA;
    private String afx;
    private final View fbk;
    private HeadImageView gPX;
    private ConstrainImageGroup gWS;
    private TextView gYH;
    private TextView gYI;
    private TextView gYJ;
    private t gYK;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.gPX = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.gPX.setIsRound(true);
        this.gPX.setDefaultResource(R.drawable.pic_head_topic);
        this.gYH = (TextView) view.findViewById(R.id.card_topic_name);
        this.gYJ = (TextView) view.findViewById(R.id.card_thread_title);
        this.gYI = (TextView) view.findViewById(R.id.card_reply_time);
        this.gWS = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fbk = view.findViewById(R.id.card_divider_line);
        this.gWS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.o(1.0d);
        this.gWS.setImageProcessor(fVar);
        this.gWS.setSinglePicUseStyleV10(true);
        this.gWS.setFromCDN(true);
        this.gWS.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gPX.invalidate();
        ao.setViewTextColor(this.gYH, R.color.cp_cont_b);
        ao.setViewTextColor(this.gYI, R.color.cp_cont_d);
        ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
        this.gWS.onChangeSkinType();
        this.gPX.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        if (bvVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeA = bvVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bvVar.aWl() != null) {
            this.gYH.setText(bvVar.aWl().getName_show());
        }
        this.gYI.setText(as.getFormatTime(bvVar.aWe() * 1000));
        String str = bvVar.aXQ() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bvVar.y(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.gYJ.setText(spannableStringBuilder);
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (com.baidu.tbadk.core.k.aTv().isShowImages() && com.baidu.tbadk.core.util.x.getCount(aWu) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.getCount(arrayList) > 0) {
                this.gWS.setVisibility(0);
                this.gWS.setImageMediaList(arrayList);
            } else {
                this.gWS.setVisibility(8);
            }
        } else {
            this.gWS.setVisibility(8);
        }
        m.a(this.gYJ, this.aeA.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeA != null) {
            if (bRn() != null) {
                bRn().a(view, (View) this.aeA, (Object) this.gYK);
            }
            if (view == getView()) {
                m.Ez(this.aeA.getTid());
                m.a(this.gYJ, this.aeA.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                bRM();
            }
        }
    }

    private void bRM() {
        if (this.aeA != null && this.aeA.aWl() != null && this.aeA.aWl().getName_show() != null) {
            long fid = this.aeA.getFid();
            if (this.aeA.dUt != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.aeA.dUt.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.jg(true) && !com.baidu.tbadk.plugins.b.blS()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aeA.aWl().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aeA.aXT(), this.aeA.aXU(), com.baidu.adp.lib.f.b.toLong(this.aeA.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bd.baV().b(this.mPageContext, new String[]{this.aeA.aXV()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }
}
