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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class y extends a<bb> implements com.baidu.tieba.a.e {
    private bb aFf;
    private final View byP;
    private ConstrainImageGroup cVa;
    private HeadImageView cWN;
    private TextView cWO;
    private TextView cWP;
    private TextView cWQ;
    private w cWR;
    private String caw;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cWN = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cWN.setIsRound(true);
        this.cWN.setDefaultResource(e.f.pic_head_topic);
        this.cWO = (TextView) view.findViewById(e.g.card_topic_name);
        this.cWQ = (TextView) view.findViewById(e.g.card_thread_title);
        this.cWP = (TextView) view.findViewById(e.g.card_reply_time);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.card_img_layout);
        this.byP = view.findViewById(e.g.card_divider_line);
        this.cVa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cVa.setImageProcessor(eVar);
        this.cVa.setFromCDN(true);
        this.cVa.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cWN.invalidate();
        al.h(this.cWO, e.d.cp_cont_b);
        al.h(this.cWP, e.d.cp_cont_d);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.byP, e.d.cp_bg_line_e);
        this.cVa.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aFf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bbVar.zG() != null) {
            this.cWO.setText(bbVar.zG().getName_show());
        }
        this.cWP.setText(ao.L(bbVar.zz() * 1000));
        String str = bbVar.Ba() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cWQ.setText(spannableStringBuilder);
        ArrayList<MediaData> zR = bbVar.zR();
        if (com.baidu.tbadk.core.i.xE().xI() && com.baidu.tbadk.core.util.v.H(zR) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < zR.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(zR, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(arrayList) > 0) {
                this.cVa.setVisibility(0);
                this.cVa.setImageMediaList(arrayList);
            } else {
                this.cVa.setVisibility(8);
            }
        } else {
            this.cVa.setVisibility(8);
        }
        o.a(this.cWQ, this.aFf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFf != null) {
            if (apc() != null) {
                apc().a(view, this.aFf, this.cWR);
            }
            if (view == getView()) {
                o.mD(this.aFf.getTid());
                o.a(this.cWQ, this.aFf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
                apE();
            }
        }
    }

    private void apE() {
        if (this.aFf != null && this.aFf.zG() != null && this.aFf.zG().getName_show() != null) {
            long fid = this.aFf.getFid();
            if (this.aFf.avC != null) {
                fid = com.baidu.adp.lib.g.b.d(this.aFf.avC.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.cP(true) && !com.baidu.tbadk.plugins.b.Px()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aFf.zG().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.aFf.Be(), this.aFf.Bf(), com.baidu.adp.lib.g.b.d(this.aFf.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.Ef().c(this.mPageContext, new String[]{this.aFf.Bg()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public void a(w wVar) {
        this.cWR = wVar;
    }
}
