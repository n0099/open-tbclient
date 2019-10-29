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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class w extends a<bh> implements com.baidu.tieba.a.e {
    private bh FT;
    private String GC;
    private final View deR;
    private HeadImageView eGf;
    private ConstrainImageGroup eNi;
    private TextView eOW;
    private TextView eOX;
    private TextView eOY;
    private u eOZ;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.eGf = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.eGf.setIsRound(true);
        this.eGf.setDefaultResource(R.drawable.pic_head_topic);
        this.eOW = (TextView) view.findViewById(R.id.card_topic_name);
        this.eOY = (TextView) view.findViewById(R.id.card_thread_title);
        this.eOX = (TextView) view.findViewById(R.id.card_reply_time);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.deR = view.findViewById(R.id.card_divider_line);
        this.eNi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.eNi.setImageProcessor(fVar);
        this.eNi.setFromCDN(true);
        this.eNi.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eGf.invalidate();
        am.setViewTextColor(this.eOW, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eOX, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
        this.eNi.onChangeSkinType();
        this.eGf.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.FT = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bhVar.aiG() != null) {
            this.eOW.setText(bhVar.aiG().getName_show());
        }
        this.eOX.setText(aq.getFormatTime(bhVar.aiz() * 1000));
        String str = bhVar.akh() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bhVar.s(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eOY.setText(spannableStringBuilder);
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aiQ) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.eNi.setVisibility(0);
                this.eNi.setImageMediaList(arrayList);
            } else {
                this.eNi.setVisibility(8);
            }
        } else {
            this.eNi.setVisibility(8);
        }
        n.a(this.eOY, this.FT.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FT != null) {
            if (aZX() != null) {
                aZX().a(view, (View) this.FT, (Object) this.eOZ);
            }
            if (view == getView()) {
                n.uz(this.FT.getTid());
                n.a(this.eOY, this.FT.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bax();
            }
        }
    }

    private void bax() {
        if (this.FT != null && this.FT.aiG() != null && this.FT.aiG().getName_show() != null) {
            long fid = this.FT.getFid();
            if (this.FT.cem != null) {
                fid = com.baidu.adp.lib.g.b.toLong(this.FT.cem.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fA(true) && !com.baidu.tbadk.plugins.b.axd()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.FT.aiG().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.FT.akl(), this.FT.akm(), com.baidu.adp.lib.g.b.toLong(this.FT.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.amQ().b(this.mPageContext, new String[]{this.FT.akn()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public void a(u uVar) {
        this.eOZ = uVar;
    }
}
