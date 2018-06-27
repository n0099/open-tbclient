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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends a<bc> implements com.baidu.tieba.a.e {
    private bc atZ;
    private String bGM;
    private final View bjZ;
    private ConstrainImageGroup cwB;
    private HeadImageView cyo;
    private TextView cyp;
    private TextView cyq;
    private TextView cyr;
    private w cys;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cyo = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.cyo.setIsRound(true);
        this.cyo.setDefaultResource(d.f.pic_head_topic);
        this.cyp = (TextView) view.findViewById(d.g.card_topic_name);
        this.cyr = (TextView) view.findViewById(d.g.card_thread_title);
        this.cyq = (TextView) view.findViewById(d.g.card_reply_time);
        this.cwB = (ConstrainImageGroup) view.findViewById(d.g.card_img_layout);
        this.bjZ = view.findViewById(d.g.card_divider_line);
        this.cwB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cwB.setImageProcessor(eVar);
        this.cwB.setFromCDN(true);
        this.cwB.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cyo.invalidate();
        am.h(this.cyp, d.C0142d.cp_cont_b);
        am.h(this.cyq, d.C0142d.cp_cont_d);
        am.i(getView(), d.f.addresslist_item_bg);
        am.j(this.bjZ, d.C0142d.cp_bg_line_e);
        this.cwB.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        if (bcVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atZ = bcVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bcVar.vw() != null) {
            this.cyp.setText(bcVar.vw().getName_show());
        }
        this.cyq.setText(ap.w(bcVar.vp() * 1000));
        String str = bcVar.wL() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bcVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_c)), 0, str.length(), 33);
        this.cyr.setText(spannableStringBuilder);
        ArrayList<MediaData> vG = bcVar.vG();
        if (com.baidu.tbadk.core.i.tt().tz() && com.baidu.tbadk.core.util.w.z(vG) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < vG.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.d(vG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.z(arrayList) > 0) {
                this.cwB.setVisibility(0);
                this.cwB.setImageMediaList(arrayList);
            } else {
                this.cwB.setVisibility(8);
            }
        } else {
            this.cwB.setVisibility(8);
        }
        o.a(this.cyr, this.atZ.getTid(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atZ != null) {
            if (aia() != null) {
                aia().a(view, this.atZ, this.cys);
            }
            if (view == getView()) {
                o.kY(this.atZ.getTid());
                o.a(this.cyr, this.atZ.getTid(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                aiA();
            }
        }
    }

    private void aiA() {
        if (this.atZ != null && this.atZ.vw() != null && this.atZ.vw().getName_show() != null) {
            long fid = this.atZ.getFid();
            if (this.atZ.akt != null) {
                fid = com.baidu.adp.lib.g.b.c(this.atZ.akt.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.cd(true) && !com.baidu.tbadk.plugins.b.KX()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.atZ.vw().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.atZ.wP(), this.atZ.wQ(), com.baidu.adp.lib.g.b.c(this.atZ.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            az.zV().c(this.mPageContext, new String[]{this.atZ.wR()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public void a(w wVar) {
        this.cys = wVar;
    }
}
