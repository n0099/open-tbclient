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
    private final View fYf;
    private HeadImageView icz;
    private ConstrainImageGroup ijF;
    private TextView ilu;
    private TextView ilv;
    private TextView ilw;
    private u ilx;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.icz = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.icz.setIsRound(true);
        this.icz.setDefaultResource(R.drawable.pic_head_topic);
        this.ilu = (TextView) view.findViewById(R.id.card_topic_name);
        this.ilw = (TextView) view.findViewById(R.id.card_thread_title);
        this.ilv = (TextView) view.findViewById(R.id.card_reply_time);
        this.ijF = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fYf = view.findViewById(R.id.card_divider_line);
        this.ijF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.ijF.setImageProcessor(fVar);
        this.ijF.setSinglePicUseStyleV10(true);
        this.ijF.setFromCDN(true);
        this.ijF.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.icz.invalidate();
        ap.setViewTextColor(this.ilu, R.color.CAM_X0105);
        ap.setViewTextColor(this.ilv, R.color.CAM_X0109);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fYf, R.color.CAM_X0204);
        this.ijF.onChangeSkinType();
        this.icz.setDefaultBgResource(i);
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
            this.ilu.setText(byVar.boP().getName_show());
        }
        this.ilv.setText(au.getFormatTime(byVar.boI() * 1000));
        String str = byVar.bqw() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) byVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.ilw.setText(spannableStringBuilder);
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
                this.ijF.setVisibility(0);
                this.ijF.setImageMediaList(arrayList);
            } else {
                this.ijF.setVisibility(8);
            }
        } else {
            this.ijF.setVisibility(8);
        }
        n.a(this.ilw, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahA != null) {
            if (crJ() != null) {
                crJ().a(view, (View) this.ahA, (Object) this.ilx);
            }
            if (view == getView()) {
                n.Jq(this.ahA.getTid());
                n.a(this.ilw, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                csi();
            }
        }
    }

    private void csi() {
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
        if (this.ijF != null) {
            this.ijF.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijF != null) {
            this.ijF.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }
}
