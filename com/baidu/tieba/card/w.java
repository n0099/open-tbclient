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
    private String WM;
    private bh Wd;
    private final View cVw;
    private ConstrainImageGroup eEC;
    private TextView eGp;
    private TextView eGq;
    private TextView eGr;
    private u eGs;
    private HeadImageView exw;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.exw = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.exw.setIsRound(true);
        this.exw.setDefaultResource(R.drawable.pic_head_topic);
        this.eGp = (TextView) view.findViewById(R.id.card_topic_name);
        this.eGr = (TextView) view.findViewById(R.id.card_thread_title);
        this.eGq = (TextView) view.findViewById(R.id.card_reply_time);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.cVw = view.findViewById(R.id.card_divider_line);
        this.eEC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.eEC.setImageProcessor(fVar);
        this.eEC.setFromCDN(true);
        this.eEC.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.exw.invalidate();
        am.j(this.eGp, R.color.cp_cont_b);
        am.j(this.eGq, R.color.cp_cont_d);
        am.k(getView(), R.drawable.addresslist_item_bg);
        am.l(this.cVw, R.color.cp_bg_line_c);
        this.eEC.onChangeSkinType();
        this.exw.setDefaultBgResource(i);
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
        this.Wd = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bhVar.aeC() != null) {
            this.eGp.setText(bhVar.aeC().getName_show());
        }
        this.eGq.setText(aq.aD(bhVar.aev() * 1000));
        String str = bhVar.age() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bhVar.o(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.eGr.setText(spannableStringBuilder);
        ArrayList<MediaData> aeM = bhVar.aeM();
        if (com.baidu.tbadk.core.i.ace().aci() && com.baidu.tbadk.core.util.v.Z(aeM) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < aeM.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.Z(arrayList) > 0) {
                this.eEC.setVisibility(0);
                this.eEC.setImageMediaList(arrayList);
            } else {
                this.eEC.setVisibility(8);
            }
        } else {
            this.eEC.setVisibility(8);
        }
        n.a(this.eGr, this.Wd.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Wd != null) {
            if (aZU() != null) {
                aZU().a(view, (View) this.Wd, (Object) this.eGs);
            }
            if (view == getView()) {
                n.vW(this.Wd.getTid());
                n.a(this.eGr, this.Wd.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                bau();
            }
        }
    }

    private void bau() {
        if (this.Wd != null && this.Wd.aeC() != null && this.Wd.aeC().getName_show() != null) {
            long fid = this.Wd.getFid();
            if (this.Wd.bMD != null) {
                fid = com.baidu.adp.lib.g.b.e(this.Wd.bMD.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.fL(true) && !com.baidu.tbadk.plugins.b.avY()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.Wd.aeC().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.Wd.agi(), this.Wd.agj(), com.baidu.adp.lib.g.b.e(this.Wd.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                return;
            }
            ba.ajK().c(this.mPageContext, new String[]{this.Wd.agk()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public void a(u uVar) {
        this.eGs = uVar;
    }
}
