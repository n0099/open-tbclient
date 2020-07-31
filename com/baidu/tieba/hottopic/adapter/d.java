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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes15.dex */
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
    /* renamed from: bL */
    public com.baidu.tieba.hottopic.a.b b(ViewGroup viewGroup) {
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
            bVar.iLu.setVisibility(8);
            if (cVar.cpe() == 1) {
                bVar.iLr.setText("");
                ao.setBackgroundResource(bVar.iLr, R.drawable.icon_grade_shaitu1);
                bVar.iLu.setVisibility(0);
                bVar.iLv.setText(et(StringUtils.isNull(cVar.cpb()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cpb(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                bVar.iLn.setVisibility(0);
                ao.setBackgroundResource(bVar.iLy, R.drawable.hot_topic_ranklist_bg);
                bVar.iLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (d.this.mPageContext != null) {
                            String cpc = cVar.cpc();
                            if (!StringUtils.isNull(cpc)) {
                                bd.baV().b(d.this.mPageContext, new String[]{cpc});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cpe() == 2) {
                bVar.iLr.setText("");
                bVar.iLn.setVisibility(8);
                ao.setBackgroundResource(bVar.iLr, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cpe() == 3) {
                bVar.iLr.setText("");
                bVar.iLn.setVisibility(8);
                ao.setBackgroundResource(bVar.iLr, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cpe();
                if (cVar.cpe() < 10) {
                    str = "0" + str;
                }
                bVar.iLr.setText(str);
                bVar.iLn.setVisibility(8);
                bVar.iLr.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                bVar.iLt.setVisibility(0);
                ao.setBackgroundResource(bVar.iLt, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                bVar.iLt.setVisibility(0);
                ao.setBackgroundResource(bVar.iLt, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                bVar.iLt.setVisibility(0);
                ao.setBackgroundResource(bVar.iLt, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                bVar.iLt.setVisibility(8);
            }
            String numFormat9999W = as.numFormat9999W(cVar.cpd());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            bVar.iLk.setText(str2);
            bVar.iLs.setText(numFormat9999W);
            bVar.iLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new ap("c11237").dn("obj_id", String.valueOf(cVar.getId())).dn("obj_locate", d.this.type));
                }
            });
        }
    }

    private void a(com.baidu.tieba.hottopic.a.b bVar) {
        if (bVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (bVar.aho != this.mSkinType) {
                bVar.aho = this.mSkinType;
                ao.setBackgroundColor(bVar.getView(), R.color.cp_bg_line_d);
                ao.setViewTextColor(bVar.iLr, R.color.cp_cont_e, 1);
                ao.setViewTextColor(bVar.iLk, R.color.cp_cont_b, 1);
                ao.setViewTextColor(bVar.iLs, R.color.cp_cont_e, 1);
                ao.setBackgroundColor(bVar.iLn, R.color.cp_bg_line_c);
                ao.setBackgroundColor(bVar.iLo, R.color.cp_bg_line_c);
                ao.setBackgroundResource(bVar.iLx, R.drawable.hot_topic_ranklist_bg);
                ao.setViewTextColor(bVar.iLw, R.color.cp_link_tip_a, 1);
                ao.setViewTextColor(bVar.iLv, R.color.cp_cont_d, 1);
            }
        }
    }

    public void GV(String str) {
        this.type = str;
    }

    private SpannableString et(String str, String str2) {
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
