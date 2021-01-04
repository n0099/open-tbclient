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
    private bz aim;
    private String aji;
    private final View ghM;
    private HeadImageView ioZ;
    private ConstrainImageGroup iwa;
    private TextView ixP;
    private TextView ixQ;
    private TextView ixR;
    private t ixS;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ioZ = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.ioZ.setIsRound(true);
        this.ioZ.setDefaultResource(R.drawable.pic_head_topic);
        this.ixP = (TextView) view.findViewById(R.id.card_topic_name);
        this.ixR = (TextView) view.findViewById(R.id.card_thread_title);
        this.ixQ = (TextView) view.findViewById(R.id.card_reply_time);
        this.iwa = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.ghM = view.findViewById(R.id.card_divider_line);
        this.iwa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.iwa.setImageProcessor(fVar);
        this.iwa.setSinglePicUseStyleV10(true);
        this.iwa.setFromCDN(true);
        this.iwa.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ioZ.invalidate();
        ao.setViewTextColor(this.ixP, R.color.CAM_X0105);
        ao.setViewTextColor(this.ixQ, R.color.CAM_X0109);
        ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
        this.iwa.onChangeSkinType();
        this.ioZ.setDefaultBgResource(i);
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
        this.aim = bzVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bzVar.brq() != null) {
            this.ixP.setText(bzVar.brq().getName_show());
        }
        this.ixQ.setText(at.getFormatTime(bzVar.brj() * 1000));
        String str = bzVar.bsY() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bzVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.ixR.setText(spannableStringBuilder);
        ArrayList<MediaData> brz = bzVar.brz();
        if (com.baidu.tbadk.core.k.bou().isShowImages() && com.baidu.tbadk.core.util.x.getCount(brz) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < brz.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(brz, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.getCount(arrayList) > 0) {
                this.iwa.setVisibility(0);
                this.iwa.setImageMediaList(arrayList);
            } else {
                this.iwa.setVisibility(8);
            }
        } else {
            this.iwa.setVisibility(8);
        }
        m.a(this.ixR, this.aim.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aim != null) {
            if (cuC() != null) {
                cuC().a(view, (View) this.aim, (Object) this.ixS);
            }
            if (view == getView()) {
                m.Jo(this.aim.getTid());
                m.a(this.ixR, this.aim.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
                cvb();
            }
        }
    }

    private void cvb() {
        if (this.aim != null && this.aim.brq() != null && this.aim.brq().getName_show() != null) {
            long fid = this.aim.getFid();
            if (this.aim.eVM != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.aim.eVM.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.lr(true) && !com.baidu.tbadk.plugins.b.bIb()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aim.brq().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aim.btb(), this.aim.btc(), com.baidu.adp.lib.f.b.toLong(this.aim.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bwu().b(this.mPageContext, new String[]{this.aim.btd()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwa != null) {
            this.iwa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwa != null) {
            this.iwa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }
}
