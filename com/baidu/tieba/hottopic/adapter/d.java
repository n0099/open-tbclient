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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes21.dex */
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
    /* renamed from: bM */
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
            bVar.keP.setVisibility(8);
            if (cVar.cRR() == 1) {
                bVar.keM.setText("");
                ap.setBackgroundResource(bVar.keM, R.drawable.icon_grade_shaitu1);
                bVar.keP.setVisibility(0);
                bVar.keQ.setText(fp(StringUtils.isNull(cVar.cRO()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cRO(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                bVar.keI.setVisibility(0);
                ap.setBackgroundResource(bVar.keT, R.drawable.hot_topic_ranklist_bg);
                bVar.keT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (d.this.mPageContext != null) {
                            String cRP = cVar.cRP();
                            if (!StringUtils.isNull(cRP)) {
                                bf.bua().b(d.this.mPageContext, new String[]{cRP});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cRR() == 2) {
                bVar.keM.setText("");
                bVar.keI.setVisibility(8);
                ap.setBackgroundResource(bVar.keM, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cRR() == 3) {
                bVar.keM.setText("");
                bVar.keI.setVisibility(8);
                ap.setBackgroundResource(bVar.keM, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cRR();
                if (cVar.cRR() < 10) {
                    str = "0" + str;
                }
                bVar.keM.setText(str);
                bVar.keI.setVisibility(8);
                bVar.keM.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                bVar.keO.setVisibility(0);
                ap.setBackgroundResource(bVar.keO, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                bVar.keO.setVisibility(0);
                ap.setBackgroundResource(bVar.keO, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                bVar.keO.setVisibility(0);
                ap.setBackgroundResource(bVar.keO, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                bVar.keO.setVisibility(8);
            }
            String numFormat9999W = au.numFormat9999W(cVar.cRQ());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            bVar.keF.setText(str2);
            bVar.keN.setText(numFormat9999W);
            bVar.keS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new ar("c11237").dY("obj_id", String.valueOf(cVar.getId())).dY("obj_locate", d.this.type));
                }
            });
        }
    }

    private void a(com.baidu.tieba.hottopic.a.b bVar) {
        if (bVar != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (bVar.aku != this.mSkinType) {
                bVar.aku = this.mSkinType;
                ap.setBackgroundColor(bVar.getView(), R.color.CAM_X0201);
                ap.setViewTextColor(bVar.keM, R.color.CAM_X0110, 1);
                ap.setViewTextColor(bVar.keF, R.color.CAM_X0105, 1);
                ap.setViewTextColor(bVar.keN, R.color.CAM_X0110, 1);
                ap.setBackgroundColor(bVar.keI, R.color.CAM_X0204);
                ap.setBackgroundColor(bVar.keJ, R.color.CAM_X0204);
                ap.setBackgroundResource(bVar.keS, R.drawable.hot_topic_ranklist_bg);
                ap.setViewTextColor(bVar.keR, R.color.CAM_X0302, 1);
                ap.setViewTextColor(bVar.keQ, R.color.CAM_X0109, 1);
            }
        }
    }

    public void MC(String str) {
        this.type = str;
    }

    private SpannableString fp(String str, String str2) {
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
