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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends a<bd> implements com.baidu.tieba.a.e {
    private bd atn;
    private String bER;
    private final View biz;
    private HeadImageView cAv;
    private TextView cAw;
    private TextView cAx;
    private TextView cAy;
    private w cAz;
    private ConstrainImageGroup cyH;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cAv = (HeadImageView) view.findViewById(d.g.topic_icon);
        this.cAv.setIsRound(true);
        this.cAv.setDefaultResource(d.f.pic_head_topic);
        this.cAw = (TextView) view.findViewById(d.g.card_topic_name);
        this.cAy = (TextView) view.findViewById(d.g.card_thread_title);
        this.cAx = (TextView) view.findViewById(d.g.card_reply_time);
        this.cyH = (ConstrainImageGroup) view.findViewById(d.g.card_img_layout);
        this.biz = view.findViewById(d.g.card_divider_line);
        this.cyH.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.j(1.0d);
        this.cyH.setImageProcessor(eVar);
        this.cyH.setFromCDN(true);
        this.cyH.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cAv.invalidate();
        al.h(this.cAw, d.C0141d.cp_cont_b);
        al.h(this.cAx, d.C0141d.cp_cont_d);
        al.i(getView(), d.f.addresslist_item_bg);
        al.j(this.biz, d.C0141d.cp_bg_line_e);
        this.cyH.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atn = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bdVar.vm() != null) {
            this.cAw.setText(bdVar.vm().getName_show());
        }
        this.cAx.setText(ao.v(bdVar.vg() * 1000));
        String str = bdVar.wB() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bdVar.g(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_c)), 0, str.length(), 33);
        this.cAy.setText(spannableStringBuilder);
        ArrayList<MediaData> vw = bdVar.vw();
        if (com.baidu.tbadk.core.i.tt().tz() && com.baidu.tbadk.core.util.w.y(vw) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < vw.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.c(vw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.y(arrayList) > 0) {
                this.cyH.setVisibility(0);
                this.cyH.setImageMediaList(arrayList);
            } else {
                this.cyH.setVisibility(8);
            }
        } else {
            this.cyH.setVisibility(8);
        }
        o.a(this.cAy, this.atn.getTid(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atn != null) {
            if (aiI() != null) {
                aiI().a(view, this.atn, this.cAz);
            }
            if (view == getView()) {
                o.lb(this.atn.getTid());
                o.a(this.cAy, this.atn.getTid(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                aji();
            }
        }
    }

    private void aji() {
        if (this.atn != null && this.atn.vm() != null && this.atn.vm().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.ca(true) && !com.baidu.tbadk.plugins.b.KF()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.atn.vm().getName_show() + "", "3");
                createNormalConfig.setExtra(this.atn.getFid(), this.atn.wF(), this.atn.wG());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.zG().c(this.mPageContext, new String[]{this.atn.wH()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public void a(w wVar) {
        this.cAz = wVar;
    }
}
