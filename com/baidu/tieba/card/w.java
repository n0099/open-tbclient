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
    private cb ahi;
    private String aif;
    private final View gft;
    private HeadImageView ipY;
    private ConstrainImageGroup iwX;
    private TextView iyS;
    private TextView iyT;
    private TextView iyU;
    private u iyV;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ipY = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.ipY.setIsRound(true);
        this.ipY.setDefaultResource(R.drawable.pic_head_topic);
        this.iyS = (TextView) view.findViewById(R.id.card_topic_name);
        this.iyU = (TextView) view.findViewById(R.id.card_thread_title);
        this.iyT = (TextView) view.findViewById(R.id.card_reply_time);
        this.iwX = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.gft = view.findViewById(R.id.card_divider_line);
        this.iwX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.iwX.setImageProcessor(fVar);
        this.iwX.setSinglePicUseStyleV10(true);
        this.iwX.setFromCDN(true);
        this.iwX.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ipY.invalidate();
        ap.setViewTextColor(this.iyS, R.color.CAM_X0105);
        ap.setViewTextColor(this.iyT, R.color.CAM_X0109);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.gft, R.color.CAM_X0204);
        this.iwX.onChangeSkinType();
        this.ipY.setDefaultBgResource(i);
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
        this.ahi = cbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (cbVar.bnQ() != null) {
            this.iyS.setText(cbVar.bnQ().getName_show());
        }
        this.iyT.setText(au.getFormatTime(cbVar.bnJ() * 1000));
        String str = cbVar.bpx() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) cbVar.A(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.iyU.setText(spannableStringBuilder);
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (com.baidu.tbadk.core.k.bkT().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bnZ) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.iwX.setVisibility(0);
                this.iwX.setImageMediaList(arrayList);
            } else {
                this.iwX.setVisibility(8);
            }
        } else {
            this.iwX.setVisibility(8);
        }
        m.a(this.iyU, this.ahi.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahi != null) {
            if (crV() != null) {
                crV().a(view, (View) this.ahi, (Object) this.iyV);
            }
            if (view == getView()) {
                m.IM(this.ahi.getTid());
                m.a(this.iyU, this.ahi.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                csv();
            }
        }
    }

    private void csv() {
        if (this.ahi != null && this.ahi.bnQ() != null && this.ahi.bnQ().getName_show() != null) {
            long fid = this.ahi.getFid();
            if (this.ahi.eTn != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.ahi.eTn.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.lq(true) && !com.baidu.tbadk.plugins.b.bEC()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.ahi.bnQ().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.ahi.bpA(), this.ahi.bpB(), com.baidu.adp.lib.f.b.toLong(this.ahi.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bsV().b(this.mPageContext, new String[]{this.ahi.bpC()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwX != null) {
            this.iwX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwX != null) {
            this.iwX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }
}
