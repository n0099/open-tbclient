package com.baidu.tieba.hottopic.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    public int arf;
    private HotTopicActivity boH;
    private BarImageView bqG;
    private TextView bqH;
    private TextView bqK;
    private RelateForumItemData bqO;
    private LinearLayout bqP;
    private LinearLayout bqQ;
    private LinearLayout bqR;
    private TextView bqS;
    private TextView bqT;
    private TextView bqU;

    public b(HotTopicActivity hotTopicActivity) {
        super(hotTopicActivity.getPageContext().getPageActivity());
        this.arf = 3;
        this.boH = hotTopicActivity;
        initView();
        RA();
    }

    private void initView() {
        View inflate = ((LayoutInflater) this.boH.getPageContext().getPageActivity().getSystemService("layout_inflater")).inflate(i.g.hot_topic_relate_forum_recommendinfo, this);
        this.bqP = (LinearLayout) inflate.findViewById(i.f.forum_info_card_root);
        this.bqG = (BarImageView) inflate.findViewById(i.f.forum_avatar);
        this.bqQ = (LinearLayout) inflate.findViewById(i.f.forum_text_info);
        this.bqH = (TextView) inflate.findViewById(i.f.forum_name);
        this.bqR = (LinearLayout) inflate.findViewById(i.f.forum_info_text_center);
        this.bqS = (TextView) inflate.findViewById(i.f.forum_follows_count);
        this.bqT = (TextView) inflate.findViewById(i.f.forum_thread_count);
        this.bqU = (TextView) inflate.findViewById(i.f.forum_intro);
        this.bqK = (TextView) inflate.findViewById(i.f.forum_add_love);
    }

    private void RA() {
        an.b(this.bqH, i.c.cp_cont_b, 1);
        an.b(this.bqS, i.c.cp_cont_c, 1);
        an.b(this.bqT, i.c.cp_cont_c, 1);
        an.b(this.bqU, i.c.cp_cont_d, 1);
        an.i((View) this.bqK, i.e.btn_appdownload);
        an.i(this.bqP, i.e.list_item_selector);
    }

    public void setData(RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null && !StringUtils.isNull(relateForumItemData.forumName)) {
            this.bqO = relateForumItemData;
            if (!StringUtils.isNull(relateForumItemData.forumAvatar)) {
                this.bqG.d(relateForumItemData.forumAvatar, 10, false);
            }
            if (!StringUtils.isNull(relateForumItemData.forumName)) {
                this.bqH.setSingleLine();
                this.bqH.setText(as.d(relateForumItemData.forumName.trim(), 14, "..."));
            }
            this.bqS.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv)) + " " + av(relateForumItemData.followNum));
            this.bqT.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_thread_tv)) + " " + av(relateForumItemData.postNum));
            relateForumItemData.forumAbstract = relateForumItemData.forumAbstract.trim();
            if (!StringUtils.isNull(relateForumItemData.forumAbstract)) {
                this.bqU.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.bqU.setText(relateForumItemData.forumAbstract);
            }
            cF(relateForumItemData.isLiked);
            registerListener();
            Rc();
        }
    }

    public void Rc() {
        if (TbadkCoreApplication.m411getInst().getSkinType() != this.arf) {
            RA();
            if (this.bqO != null) {
                cF(this.bqO.isLiked);
            }
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void cF(boolean z) {
        if (z) {
            this.bqK.setEnabled(false);
            an.b(this.bqK, i.c.cp_cont_e, 1);
            this.bqK.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_is_followed));
            this.bqK.setBackgroundDrawable(null);
            return;
        }
        an.b(this.bqK, i.c.cp_cont_i, 1);
        this.bqK.setText(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv));
        an.i((View) this.bqK, i.e.btn_appdownload);
        this.bqK.setEnabled(true);
    }

    private void registerListener() {
        if (this.bqO != null) {
            String valueOf = String.valueOf(this.bqO.forumId);
            String str = this.bqO.forumName;
            this.bqP.setClickable(true);
            this.bqP.setOnClickListener(new c(this, str));
            this.bqK.setClickable(true);
            this.bqK.setOnClickListener(new d(this, str, valueOf));
        }
    }

    private String av(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }
}
