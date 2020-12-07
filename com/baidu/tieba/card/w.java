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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class w extends b<by> implements com.baidu.tieba.a.e {
    private by ahA;
    private String aiw;
    private final View fYd;
    private HeadImageView icx;
    private ConstrainImageGroup ijD;
    private TextView ils;
    private TextView ilt;
    private TextView ilu;
    private u ilv;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.icx = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.icx.setIsRound(true);
        this.icx.setDefaultResource(R.drawable.pic_head_topic);
        this.ils = (TextView) view.findViewById(R.id.card_topic_name);
        this.ilu = (TextView) view.findViewById(R.id.card_thread_title);
        this.ilt = (TextView) view.findViewById(R.id.card_reply_time);
        this.ijD = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fYd = view.findViewById(R.id.card_divider_line);
        this.ijD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.ijD.setImageProcessor(fVar);
        this.ijD.setSinglePicUseStyleV10(true);
        this.ijD.setFromCDN(true);
        this.ijD.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.icx.invalidate();
        ap.setViewTextColor(this.ils, R.color.CAM_X0105);
        ap.setViewTextColor(this.ilt, R.color.CAM_X0109);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fYd, R.color.CAM_X0204);
        this.ijD.onChangeSkinType();
        this.icx.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        if (byVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahA = byVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (byVar.boP() != null) {
            this.ils.setText(byVar.boP().getName_show());
        }
        this.ilt.setText(au.getFormatTime(byVar.boI() * 1000));
        String str = byVar.bqw() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) byVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.ilu.setText(spannableStringBuilder);
        ArrayList<MediaData> boY = byVar.boY();
        if (com.baidu.tbadk.core.k.blV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(boY) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.ijD.setVisibility(0);
                this.ijD.setImageMediaList(arrayList);
            } else {
                this.ijD.setVisibility(8);
            }
        } else {
            this.ijD.setVisibility(8);
        }
        n.a(this.ilu, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahA != null) {
            if (crI() != null) {
                crI().a(view, (View) this.ahA, (Object) this.ilv);
            }
            if (view == getView()) {
                n.Jq(this.ahA.getTid());
                n.a(this.ilu, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                csh();
            }
        }
    }

    private void csh() {
        if (this.ahA != null && this.ahA.boP() != null && this.ahA.boP().getName_show() != null) {
            long fid = this.ahA.getFid();
            if (this.ahA.eLS != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.ahA.eLS.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.kV(true) && !com.baidu.tbadk.plugins.b.bFG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.ahA.boP().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.ahA.bqz(), this.ahA.bqA(), com.baidu.adp.lib.f.b.toLong(this.ahA.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bua().b(this.mPageContext, new String[]{this.ahA.bqB()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijD != null) {
            this.ijD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijD != null) {
            this.ijD.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }
}
