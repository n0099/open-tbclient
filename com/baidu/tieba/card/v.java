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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends b<bz> implements com.baidu.tieba.a.e {
    private bz ahu;
    private String air;
    private final View gde;
    private HeadImageView ikq;
    private ConstrainImageGroup irt;
    private TextView iti;
    private TextView itj;
    private TextView itk;
    private t itl;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ikq = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.ikq.setIsRound(true);
        this.ikq.setDefaultResource(R.drawable.pic_head_topic);
        this.iti = (TextView) view.findViewById(R.id.card_topic_name);
        this.itk = (TextView) view.findViewById(R.id.card_thread_title);
        this.itj = (TextView) view.findViewById(R.id.card_reply_time);
        this.irt = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.gde = view.findViewById(R.id.card_divider_line);
        this.irt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.irt.setImageProcessor(fVar);
        this.irt.setSinglePicUseStyleV10(true);
        this.irt.setFromCDN(true);
        this.irt.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ikq.invalidate();
        ao.setViewTextColor(this.iti, R.color.CAM_X0105);
        ao.setViewTextColor(this.itj, R.color.CAM_X0109);
        ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ao.setBackgroundColor(this.gde, R.color.CAM_X0204);
        this.irt.onChangeSkinType();
        this.ikq.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        if (bzVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahu = bzVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bzVar.bnx() != null) {
            this.iti.setText(bzVar.bnx().getName_show());
        }
        this.itj.setText(at.getFormatTime(bzVar.bnq() * 1000));
        String str = bzVar.bpf() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bzVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.itk.setText(spannableStringBuilder);
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (com.baidu.tbadk.core.k.bkB().isShowImages() && com.baidu.tbadk.core.util.x.getCount(bnG) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.getCount(arrayList) > 0) {
                this.irt.setVisibility(0);
                this.irt.setImageMediaList(arrayList);
            } else {
                this.irt.setVisibility(8);
            }
        } else {
            this.irt.setVisibility(8);
        }
        m.a(this.itk, this.ahu.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahu != null) {
            if (cqL() != null) {
                cqL().a(view, (View) this.ahu, (Object) this.itl);
            }
            if (view == getView()) {
                m.Ic(this.ahu.getTid());
                m.a(this.itk, this.ahu.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                crk();
            }
        }
    }

    private void crk() {
        if (this.ahu != null && this.ahu.bnx() != null && this.ahu.bnx().getName_show() != null) {
            long fid = this.ahu.getFid();
            if (this.ahu.eRb != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.ahu.eRb.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.ln(true) && !com.baidu.tbadk.plugins.b.bEk()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.ahu.bnx().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.ahu.bpi(), this.ahu.bpj(), com.baidu.adp.lib.f.b.toLong(this.ahu.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bsB().b(this.mPageContext, new String[]{this.ahu.bpk()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }
}
