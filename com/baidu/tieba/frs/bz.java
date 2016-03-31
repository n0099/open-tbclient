package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bz {
    private com.baidu.tieba.tbadkCore.w MY;
    private LinearLayout bna;
    private View bnb;
    private TextView bnc;
    private ImageView bnd;
    private TextView bne;
    private View bnf;
    private List<FeedForumData> bnh;
    TbPageContext<FrsActivity> mTbPageContext;
    private int mType;
    private List<cf> bng = new ArrayList();
    private Handler mHandler = new Handler();
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean bni = false;
    private View.OnClickListener mOnClickListener = new ca(this);
    private com.baidu.adp.base.g bbu = new cb(this);

    public bz(TbPageContext<FrsActivity> tbPageContext, View view, int i) {
        this.mType = 1;
        this.mTbPageContext = tbPageContext;
        this.bna = (LinearLayout) view.findViewById(t.g.frs_header_feed_forums);
        this.bnb = view.findViewById(t.g.frs_header_feed_forums_divider);
        this.bnf = view.findViewById(t.g.layout_like_feed_forum_header);
        this.bnc = (TextView) this.bna.findViewById(t.g.like_feed_forums_label);
        this.bnd = (ImageView) this.bna.findViewById(t.g.like_feed_forums_arrow);
        this.bnd.setOnClickListener(this.mOnClickListener);
        this.bne = (TextView) this.bna.findViewById(t.g.feed_forums_more);
        this.bne.setOnClickListener(this.mOnClickListener);
        this.MY = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MY.setLoadDataCallBack(this.bbu);
        this.mType = i;
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if (oVar.avu() != null && oVar.avu().isLike() == 0) {
                hide();
                return;
            }
            if (oVar.avu() != null) {
                this.mForumId = oVar.avu().getId();
            }
            this.bnh = oVar.aRU();
            xg();
            if (this.mType == 1 && !this.bni) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10027").ac("fid", this.mForumId));
                this.bni = true;
            }
        }
    }

    public void c(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.bnh = list;
        xg();
        if (this.mType == 2 && !this.bni) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10035").ac("fid", this.mForumId));
            this.bni = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        int i;
        if (com.baidu.tbadk.core.util.y.p(this.bnh) == 0) {
            hide();
            return;
        }
        show();
        int size = this.bnh.size() > 2 ? 2 : this.bnh.size();
        int size2 = size - this.bng.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = t.h.frs_header_feed_forum_item;
                } else {
                    i = t.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.bna.addView(inflate);
                this.bng.add(new cf(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.bng.size() - 1;
                this.bna.removeView(this.bng.get(size3).aNr);
                this.bng.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.bnh.get(i4);
            cf cfVar = this.bng.get(i4);
            if (feedForumData != null && cfVar != null) {
                cfVar.aNr.setTag(feedForumData);
                cfVar.aNr.setOnClickListener(this.mOnClickListener);
                cfVar.bnm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                cfVar.bnm.c(feedForumData.getAvatar(), 15, false);
                cfVar.aSh.setText(feedForumData.getForumName());
                cfVar.bnn.setText(String.format(this.mTbPageContext.getPageActivity().getString(t.j.attention_post_count), gJ(feedForumData.getMemberCount()), gJ(feedForumData.getPostNum())));
                cfVar.bno.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    cfVar.bnp.setClickable(true);
                    cfVar.bnp.setOnClickListener(this.mOnClickListener);
                    cfVar.bnp.setTag(feedForumData);
                    cfVar.bnp.setText(t.j.attention_n);
                    cfVar.bnp.setEnabled(true);
                } else {
                    a(cfVar);
                }
            }
        }
        Rx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cf cfVar) {
        if (cfVar != null && cfVar.bnp != null) {
            cfVar.bnp.setText(this.mTbPageContext.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_e, 1);
            cfVar.bnp.setEnabled(false);
        }
    }

    private String gJ(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.cC(this.mTbPageContext.getPageActivity().getString(t.j.not_intrested));
        aVar.a(t.j.alert_yes_button, new cd(this));
        aVar.b(t.j.alert_no_button, new ce(this));
        aVar.b(this.mTbPageContext).up();
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            Rx();
        }
        this.mSkinType = i;
    }

    private void Rx() {
        com.baidu.tbadk.core.util.at.l(this.bna, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.bnb, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(this.bnf, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.b(this.bnc, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.bnd, t.f.icon_frs_recommend_arrow_down);
        com.baidu.tbadk.core.util.at.b(this.bne, t.d.cp_cont_e, 1);
        for (cf cfVar : this.bng) {
            com.baidu.tbadk.core.util.at.k(cfVar.aNr, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.at.b(cfVar.aSh, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bnn, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bno, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.at.k(cfVar.bnp, t.f.btn_frs_feed_forum_attention);
            if (cfVar.bnp.isEnabled()) {
                com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_e, 1);
            }
        }
    }

    public void hide() {
        this.bna.setVisibility(8);
    }

    public void show() {
        this.bna.setVisibility(0);
    }
}
