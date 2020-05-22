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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class v extends b<bk> implements com.baidu.tieba.a.e {
    private String aeX;
    private bk aee;
    private final View eLg;
    private ConstrainImageGroup gEm;
    private TextView gFY;
    private TextView gFZ;
    private TextView gGa;
    private t gGb;
    private HeadImageView gxs;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.gxs = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.gxs.setIsRound(true);
        this.gxs.setDefaultResource(R.drawable.pic_head_topic);
        this.gFY = (TextView) view.findViewById(R.id.card_topic_name);
        this.gGa = (TextView) view.findViewById(R.id.card_thread_title);
        this.gFZ = (TextView) view.findViewById(R.id.card_reply_time);
        this.gEm = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.eLg = view.findViewById(R.id.card_divider_line);
        this.gEm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.o(1.0d);
        this.gEm.setImageProcessor(fVar);
        this.gEm.setSinglePicUseStyleV10(true);
        this.gEm.setFromCDN(true);
        this.gEm.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gxs.invalidate();
        am.setViewTextColor(this.gFY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gFZ, (int) R.color.cp_cont_d);
        am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
        this.gEm.onChangeSkinType();
        this.gxs.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aee = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bkVar.aQx() != null) {
            this.gFY.setText(bkVar.aQx().getName_show());
        }
        this.gFZ.setText(aq.getFormatTime(bkVar.aQq() * 1000));
        String str = bkVar.aSd() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bkVar.x(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.gGa.setText(spannableStringBuilder);
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (com.baidu.tbadk.core.k.aNQ().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aQH) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList) > 0) {
                this.gEm.setVisibility(0);
                this.gEm.setImageMediaList(arrayList);
            } else {
                this.gEm.setVisibility(8);
            }
        } else {
            this.gEm.setVisibility(8);
        }
        m.a(this.gGa, this.aee.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aee != null) {
            if (bKS() != null) {
                bKS().a(view, (View) this.aee, (Object) this.gGb);
            }
            if (view == getView()) {
                m.Dn(this.aee.getTid());
                m.a(this.gGa, this.aee.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bLr();
            }
        }
    }

    private void bLr() {
        if (this.aee != null && this.aee.aQx() != null && this.aee.aQx().getName_show() != null) {
            long fid = this.aee.getFid();
            if (this.aee.dHw != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.aee.dHw.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.is(true) && !com.baidu.tbadk.plugins.b.bga()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aee.aQx().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aee.aSh(), this.aee.aSi(), com.baidu.adp.lib.f.b.toLong(this.aee.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            ba.aUZ().b(this.mPageContext, new String[]{this.aee.aSj()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEm != null) {
            this.gEm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEm != null) {
            this.gEm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }
}
