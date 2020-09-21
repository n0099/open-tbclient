package com.baidu.tieba.hottopic.adapter;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes20.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.c, com.baidu.tieba.hottopic.a.b> {
    private TbPageContext mPageContext;
    protected int mSkinType;
    private String type;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mPageContext = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public com.baidu.tieba.hottopic.a.b c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.a.b(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_ranklist_normal_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.c cVar, com.baidu.tieba.hottopic.a.b bVar) {
        if (cVar != null) {
            a(bVar);
            a(i, bVar, cVar);
        }
        return view;
    }

    private void a(int i, com.baidu.tieba.hottopic.a.b bVar, final com.baidu.tieba.hottopic.data.c cVar) {
        if (bVar != null && cVar != null) {
            bVar.jjg.setVisibility(8);
            if (cVar.cDF() == 1) {
                bVar.jjd.setText("");
                ap.setBackgroundResource(bVar.jjd, R.drawable.icon_grade_shaitu1);
                bVar.jjg.setVisibility(0);
                bVar.jjh.setText(eY(StringUtils.isNull(cVar.cDC()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cDC(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                bVar.jiZ.setVisibility(0);
                ap.setBackgroundResource(bVar.jjk, R.drawable.hot_topic_ranklist_bg);
                bVar.jjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (d.this.mPageContext != null) {
                            String cDD = cVar.cDD();
                            if (!StringUtils.isNull(cDD)) {
                                be.bkp().b(d.this.mPageContext, new String[]{cDD});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cDF() == 2) {
                bVar.jjd.setText("");
                bVar.jiZ.setVisibility(8);
                ap.setBackgroundResource(bVar.jjd, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cDF() == 3) {
                bVar.jjd.setText("");
                bVar.jiZ.setVisibility(8);
                ap.setBackgroundResource(bVar.jjd, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cDF();
                if (cVar.cDF() < 10) {
                    str = "0" + str;
                }
                bVar.jjd.setText(str);
                bVar.jiZ.setVisibility(8);
                bVar.jjd.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                bVar.jjf.setVisibility(0);
                ap.setBackgroundResource(bVar.jjf, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                bVar.jjf.setVisibility(0);
                ap.setBackgroundResource(bVar.jjf, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                bVar.jjf.setVisibility(0);
                ap.setBackgroundResource(bVar.jjf, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                bVar.jjf.setVisibility(8);
            }
            String numFormat9999W = at.numFormat9999W(cVar.cDE());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            bVar.jiW.setText(str2);
            bVar.jje.setText(numFormat9999W);
            bVar.jjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new aq("c11237").dF("obj_id", String.valueOf(cVar.getId())).dF("obj_locate", d.this.type));
                }
            });
        }
    }

    private void a(com.baidu.tieba.hottopic.a.b bVar) {
        if (bVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (bVar.aiX != this.mSkinType) {
                bVar.aiX = this.mSkinType;
                ap.setBackgroundColor(bVar.getView(), R.color.cp_bg_line_d);
                ap.setViewTextColor(bVar.jjd, R.color.cp_cont_e, 1);
                ap.setViewTextColor(bVar.jiW, R.color.cp_cont_b, 1);
                ap.setViewTextColor(bVar.jje, R.color.cp_cont_e, 1);
                ap.setBackgroundColor(bVar.jiZ, R.color.cp_bg_line_c);
                ap.setBackgroundColor(bVar.jja, R.color.cp_bg_line_c);
                ap.setBackgroundResource(bVar.jjj, R.drawable.hot_topic_ranklist_bg);
                ap.setViewTextColor(bVar.jji, R.color.cp_link_tip_a, 1);
                ap.setViewTextColor(bVar.jjh, R.color.cp_cont_d, 1);
            }
        }
    }

    public void Kq(String str) {
        this.type = str;
    }

    private SpannableString eY(String str, String str2) {
        int length = !StringUtils.isNull(str) ? str.length() : 0;
        int length2 = !StringUtils.isNull(str2) ? str2.length() : 0;
        SpannableString spannableString = new SpannableString("" + str + str2);
        if (length <= 0 || length2 <= 0) {
            return spannableString;
        }
        spannableString.setSpan(new TextAppearanceSpan(this.mPageContext.getPageActivity(), R.style.hot_ranklist_module_name_stysle), 0, length, 33);
        spannableString.setSpan(new TextAppearanceSpan(this.mPageContext.getPageActivity(), R.style.hot_ranklist_module_tip_stysle), length, spannableString.length(), 33);
        return spannableString;
    }
}
