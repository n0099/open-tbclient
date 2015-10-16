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
    public int apS;
    private HotTopicActivity bod;
    private BarImageView bqc;
    private TextView bqd;
    private TextView bqg;
    private RelateForumItemData bqk;
    private LinearLayout bql;
    private LinearLayout bqm;
    private LinearLayout bqn;
    private TextView bqo;
    private TextView bqp;
    private TextView bqq;

    public b(HotTopicActivity hotTopicActivity) {
        super(hotTopicActivity.getPageContext().getPageActivity());
        this.apS = 3;
        this.bod = hotTopicActivity;
        initView();
        Ri();
    }

    private void initView() {
        View inflate = ((LayoutInflater) this.bod.getPageContext().getPageActivity().getSystemService("layout_inflater")).inflate(i.g.hot_topic_relate_forum_recommendinfo, this);
        this.bql = (LinearLayout) inflate.findViewById(i.f.forum_info_card_root);
        this.bqc = (BarImageView) inflate.findViewById(i.f.forum_avatar);
        this.bqm = (LinearLayout) inflate.findViewById(i.f.forum_text_info);
        this.bqd = (TextView) inflate.findViewById(i.f.forum_name);
        this.bqn = (LinearLayout) inflate.findViewById(i.f.forum_info_text_center);
        this.bqo = (TextView) inflate.findViewById(i.f.forum_follows_count);
        this.bqp = (TextView) inflate.findViewById(i.f.forum_thread_count);
        this.bqq = (TextView) inflate.findViewById(i.f.forum_intro);
        this.bqg = (TextView) inflate.findViewById(i.f.forum_add_love);
    }

    private void Ri() {
        an.b(this.bqd, i.c.cp_cont_b, 1);
        an.b(this.bqo, i.c.cp_cont_c, 1);
        an.b(this.bqp, i.c.cp_cont_c, 1);
        an.b(this.bqq, i.c.cp_cont_d, 1);
        an.i((View) this.bqg, i.e.btn_appdownload);
        an.i(this.bql, i.e.list_item_selector);
    }

    public void setData(RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null && !StringUtils.isNull(relateForumItemData.forumName)) {
            this.bqk = relateForumItemData;
            if (!StringUtils.isNull(relateForumItemData.forumAvatar)) {
                this.bqc.d(relateForumItemData.forumAvatar, 10, false);
            }
            if (!StringUtils.isNull(relateForumItemData.forumName)) {
                this.bqd.setSingleLine();
                this.bqd.setText(as.d(relateForumItemData.forumName.trim(), 14, "..."));
            }
            this.bqo.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv)) + " " + ax(relateForumItemData.followNum));
            this.bqp.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_thread_tv)) + " " + ax(relateForumItemData.postNum));
            relateForumItemData.forumAbstract = relateForumItemData.forumAbstract.trim();
            if (!StringUtils.isNull(relateForumItemData.forumAbstract)) {
                this.bqq.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.bqq.setText(relateForumItemData.forumAbstract);
            }
            cD(relateForumItemData.isLiked);
            registerListener();
            QK();
        }
    }

    public void QK() {
        if (TbadkCoreApplication.m411getInst().getSkinType() != this.apS) {
            Ri();
            if (this.bqk != null) {
                cD(this.bqk.isLiked);
            }
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void cD(boolean z) {
        if (z) {
            this.bqg.setEnabled(false);
            an.b(this.bqg, i.c.cp_cont_e, 1);
            this.bqg.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_is_followed));
            this.bqg.setBackgroundDrawable(null);
            return;
        }
        an.b(this.bqg, i.c.cp_cont_i, 1);
        this.bqg.setText(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv));
        an.i((View) this.bqg, i.e.btn_appdownload);
        this.bqg.setEnabled(true);
    }

    private void registerListener() {
        if (this.bqk != null) {
            String valueOf = String.valueOf(this.bqk.forumId);
            String str = this.bqk.forumName;
            this.bql.setClickable(true);
            this.bql.setOnClickListener(new c(this, str));
            this.bqg.setClickable(true);
            this.bqg.setOnClickListener(new d(this, str, valueOf));
        }
    }

    private String ax(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }
}
