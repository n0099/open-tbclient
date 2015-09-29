package com.baidu.tieba.hottopic.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    public int apR;
    private HotTopicActivity bnS;
    private BarImageView bpR;
    private TextView bpS;
    private TextView bpV;
    private RelateForumItemData bpZ;
    private LinearLayout bqa;
    private LinearLayout bqb;
    private LinearLayout bqc;
    private TextView bqd;
    private TextView bqe;
    private TextView bqf;

    public b(HotTopicActivity hotTopicActivity) {
        super(hotTopicActivity.getPageContext().getPageActivity());
        this.apR = 3;
        this.bnS = hotTopicActivity;
        initView();
        Ri();
    }

    private void initView() {
        View inflate = ((LayoutInflater) this.bnS.getPageContext().getPageActivity().getSystemService("layout_inflater")).inflate(i.g.hot_topic_relate_forum_recommendinfo, this);
        this.bqa = (LinearLayout) inflate.findViewById(i.f.forum_info_card_root);
        this.bpR = (BarImageView) inflate.findViewById(i.f.forum_avatar);
        this.bqb = (LinearLayout) inflate.findViewById(i.f.forum_text_info);
        this.bpS = (TextView) inflate.findViewById(i.f.forum_name);
        this.bqc = (LinearLayout) inflate.findViewById(i.f.forum_info_text_center);
        this.bqd = (TextView) inflate.findViewById(i.f.forum_follows_count);
        this.bqe = (TextView) inflate.findViewById(i.f.forum_thread_count);
        this.bqf = (TextView) inflate.findViewById(i.f.forum_intro);
        this.bpV = (TextView) inflate.findViewById(i.f.forum_add_love);
    }

    private void Ri() {
        am.b(this.bpS, i.c.cp_cont_b, 1);
        am.b(this.bqd, i.c.cp_cont_c, 1);
        am.b(this.bqe, i.c.cp_cont_c, 1);
        am.b(this.bqf, i.c.cp_cont_d, 1);
        am.i((View) this.bpV, i.e.btn_appdownload);
        am.i(this.bqa, i.e.list_item_selector);
    }

    public void setData(RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null && !StringUtils.isNull(relateForumItemData.forumName)) {
            this.bpZ = relateForumItemData;
            if (!StringUtils.isNull(relateForumItemData.forumAvatar)) {
                this.bpR.d(relateForumItemData.forumAvatar, 10, false);
            }
            if (!StringUtils.isNull(relateForumItemData.forumName)) {
                this.bpS.setSingleLine();
                this.bpS.setText(ar.d(relateForumItemData.forumName.trim(), 14, "..."));
            }
            this.bqd.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv)) + " " + an(relateForumItemData.followNum));
            this.bqe.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_thread_tv)) + " " + an(relateForumItemData.postNum));
            relateForumItemData.forumAbstract = relateForumItemData.forumAbstract.trim();
            if (!StringUtils.isNull(relateForumItemData.forumAbstract)) {
                this.bqf.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.bqf.setText(relateForumItemData.forumAbstract);
            }
            cD(relateForumItemData.isLiked);
            registerListener();
            QK();
        }
    }

    public void QK() {
        if (TbadkCoreApplication.m411getInst().getSkinType() != this.apR) {
            Ri();
            if (this.bpZ != null) {
                cD(this.bpZ.isLiked);
            }
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void cD(boolean z) {
        if (z) {
            this.bpV.setEnabled(false);
            am.b(this.bpV, i.c.cp_cont_e, 1);
            this.bpV.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_is_followed));
            this.bpV.setBackgroundDrawable(null);
            return;
        }
        am.b(this.bpV, i.c.cp_cont_i, 1);
        this.bpV.setText(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv));
        am.i((View) this.bpV, i.e.btn_appdownload);
        this.bpV.setEnabled(true);
    }

    private void registerListener() {
        if (this.bpZ != null) {
            String valueOf = String.valueOf(this.bpZ.forumId);
            String str = this.bpZ.forumName;
            this.bqa.setClickable(true);
            this.bqa.setOnClickListener(new c(this, str));
            this.bpV.setClickable(true);
            this.bpV.setOnClickListener(new d(this, str, valueOf));
        }
    }

    private String an(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }
}
