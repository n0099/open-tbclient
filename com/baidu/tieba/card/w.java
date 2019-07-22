package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class w extends a<bg> implements com.baidu.tieba.a.e {
    private String WN;
    private bg We;
    private final View cUw;
    private ConstrainImageGroup eCM;
    private TextView eEA;
    private TextView eEB;
    private u eEC;
    private TextView eEz;
    private HeadImageView evE;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.evE = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.evE.setIsRound(true);
        this.evE.setDefaultResource(R.drawable.pic_head_topic);
        this.eEz = (TextView) view.findViewById(R.id.card_topic_name);
        this.eEB = (TextView) view.findViewById(R.id.card_thread_title);
        this.eEA = (TextView) view.findViewById(R.id.card_reply_time);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cUw = view.findViewById(R.id.card_divider_line);
        this.eCM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.eCM.setImageProcessor(fVar);
        this.eCM.setFromCDN(true);
        this.eCM.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.evE.invalidate();
        am.j(this.eEz, R.color.cp_cont_b);
        am.j(this.eEA, R.color.cp_cont_d);
        am.k(getView(), R.drawable.addresslist_item_bg);
        am.l(this.cUw, R.color.cp_bg_line_e);
        this.eCM.onChangeSkinType();
        this.evE.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.We = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bgVar.aex() != null) {
            this.eEz.setText(bgVar.aex().getName_show());
        }
        this.eEA.setText(aq.aD(bgVar.aeq() * 1000));
        String str = bgVar.afZ() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bgVar.o(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eEB.setText(spannableStringBuilder);
        ArrayList<MediaData> aeH = bgVar.aeH();
        if (com.baidu.tbadk.core.i.aca().ace() && com.baidu.tbadk.core.util.v.Z(aeH) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aeH.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.Z(arrayList) > 0) {
                this.eCM.setVisibility(0);
                this.eCM.setImageMediaList(arrayList);
            } else {
                this.eCM.setVisibility(8);
            }
        } else {
            this.eCM.setVisibility(8);
        }
        n.a(this.eEB, this.We.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.We != null) {
            if (aZo() != null) {
                aZo().a(view, (View) this.We, (Object) this.eEC);
            }
            if (view == getView()) {
                n.vw(this.We.getTid());
                n.a(this.eEB, this.We.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                aZO();
            }
        }
    }

    private void aZO() {
        if (this.We != null && this.We.aex() != null && this.We.aex().getName_show() != null) {
            long fid = this.We.getFid();
            if (this.We.bMa != null) {
                fid = com.baidu.adp.lib.g.b.c(this.We.bMa.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fI(true) && !com.baidu.tbadk.plugins.b.avK()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.We.aex().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.We.agd(), this.We.age(), com.baidu.adp.lib.g.b.c(this.We.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            bb.ajC().c(this.mPageContext, new String[]{this.We.agf()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public void a(u uVar) {
        this.eEC = uVar;
    }
}
