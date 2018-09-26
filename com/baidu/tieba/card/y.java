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
/* loaded from: classes2.dex */
public class y extends a<bb> implements com.baidu.tieba.a.e {
    private bb awf;
    private String bNq;
    private final View bqy;
    private ConstrainImageGroup cET;
    private HeadImageView cGG;
    private TextView cGH;
    private TextView cGI;
    private TextView cGJ;
    private w cGK;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.cGG = (HeadImageView) view.findViewById(e.g.topic_icon);
        this.cGG.setIsRound(true);
        this.cGG.setDefaultResource(e.f.pic_head_topic);
        this.cGH = (TextView) view.findViewById(e.g.card_topic_name);
        this.cGJ = (TextView) view.findViewById(e.g.card_thread_title);
        this.cGI = (TextView) view.findViewById(e.g.card_reply_time);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.card_img_layout);
        this.bqy = view.findViewById(e.g.card_divider_line);
        this.cET.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20));
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cET.setImageProcessor(eVar);
        this.cET.setFromCDN(true);
        this.cET.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        this.cGG.invalidate();
        al.h(this.cGH, e.d.cp_cont_b);
        al.h(this.cGI, e.d.cp_cont_d);
        al.i(getView(), e.f.addresslist_item_bg);
        al.j(this.bqy, e.d.cp_bg_line_e);
        this.cET.onChangeSkinType();
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
        this.awf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bbVar.wm() != null) {
            this.cGH.setText(bbVar.wm().getName_show());
        }
        this.cGI.setText(ao.A(bbVar.wf() * 1000));
        String str = bbVar.xG() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bbVar.i(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 33);
        this.cGJ.setText(spannableStringBuilder);
        ArrayList<MediaData> wx = bbVar.wx();
        if (com.baidu.tbadk.core.i.uj().un() && com.baidu.tbadk.core.util.v.y(wx) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < wx.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(wx, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.y(arrayList) > 0) {
                this.cET.setVisibility(0);
                this.cET.setImageMediaList(arrayList);
            } else {
                this.cET.setVisibility(8);
            }
        } else {
            this.cET.setVisibility(8);
        }
        o.a(this.cGJ, this.awf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.awf != null) {
            if (akm() != null) {
                akm().a(view, this.awf, this.cGK);
            }
            if (view == getView()) {
                o.lA(this.awf.getTid());
                o.a(this.cGJ, this.awf.getTid(), e.d.cp_cont_b, e.d.cp_cont_d);
                akN();
            }
        }
    }

    private void akN() {
        if (this.awf != null && this.awf.wm() != null && this.awf.wm().getName_show() != null) {
            long fid = this.awf.getFid();
            if (this.awf.amu != null) {
                fid = com.baidu.adp.lib.g.b.d(this.awf.amu.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.co(true) && !com.baidu.tbadk.plugins.b.Mm()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.awf.wm().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.awf.xK(), this.awf.xL(), com.baidu.adp.lib.g.b.d(this.awf.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ay.AN().c(this.mPageContext, new String[]{this.awf.xM()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cET != null) {
            this.cET.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cET != null) {
            this.cET.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public void a(w wVar) {
        this.cGK = wVar;
    }
}
