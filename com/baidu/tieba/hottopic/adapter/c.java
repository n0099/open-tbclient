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
import com.baidu.tieba.hottopic.holder.HotRankListNormaItemHolder;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.c, HotRankListNormaItemHolder> {
    private TbPageContext mPageContext;
    protected int mSkinType;
    private String type;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mPageContext = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cb */
    public HotRankListNormaItemHolder e(ViewGroup viewGroup) {
        return new HotRankListNormaItemHolder(LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_ranklist_normal_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (cVar != null) {
            a(hotRankListNormaItemHolder);
            a(i, hotRankListNormaItemHolder, cVar);
        }
        return view;
    }

    private void a(int i, HotRankListNormaItemHolder hotRankListNormaItemHolder, final com.baidu.tieba.hottopic.data.c cVar) {
        if (hotRankListNormaItemHolder != null && cVar != null) {
            hotRankListNormaItemHolder.kvF.setVisibility(8);
            if (cVar.cTg() == 1) {
                hotRankListNormaItemHolder.kvC.setText("");
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvC, R.drawable.icon_grade_shaitu1);
                hotRankListNormaItemHolder.kvF.setVisibility(0);
                hotRankListNormaItemHolder.kvG.setText(fp(StringUtils.isNull(cVar.cTd()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cTd(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                hotRankListNormaItemHolder.kvy.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvJ, R.drawable.hot_topic_ranklist_bg);
                hotRankListNormaItemHolder.kvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            String cTe = cVar.cTe();
                            if (!StringUtils.isNull(cTe)) {
                                bf.bsV().b(c.this.mPageContext, new String[]{cTe});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cTg() == 2) {
                hotRankListNormaItemHolder.kvC.setText("");
                hotRankListNormaItemHolder.kvy.setVisibility(8);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvC, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cTg() == 3) {
                hotRankListNormaItemHolder.kvC.setText("");
                hotRankListNormaItemHolder.kvy.setVisibility(8);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvC, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cTg();
                if (cVar.cTg() < 10) {
                    str = "0" + str;
                }
                hotRankListNormaItemHolder.kvC.setText(str);
                hotRankListNormaItemHolder.kvy.setVisibility(8);
                hotRankListNormaItemHolder.kvC.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                hotRankListNormaItemHolder.kvE.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvE, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                hotRankListNormaItemHolder.kvE.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvE, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                hotRankListNormaItemHolder.kvE.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvE, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                hotRankListNormaItemHolder.kvE.setVisibility(8);
            }
            String numFormat9999W = au.numFormat9999W(cVar.cTf());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            hotRankListNormaItemHolder.kvv.setText(str2);
            hotRankListNormaItemHolder.kvD.setText(numFormat9999W);
            hotRankListNormaItemHolder.kvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new ar("c11237").dR("obj_id", String.valueOf(cVar.getId())).dR("obj_locate", c.this.type));
                }
            });
        }
    }

    private void a(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (hotRankListNormaItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (hotRankListNormaItemHolder.ajU != this.mSkinType) {
                hotRankListNormaItemHolder.ajU = this.mSkinType;
                ap.setBackgroundColor(hotRankListNormaItemHolder.getView(), R.color.CAM_X0201);
                ap.setViewTextColor(hotRankListNormaItemHolder.kvC, R.color.CAM_X0110, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kvv, R.color.CAM_X0105, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kvD, R.color.CAM_X0110, 1);
                ap.setBackgroundColor(hotRankListNormaItemHolder.kvy, R.color.CAM_X0204);
                ap.setBackgroundColor(hotRankListNormaItemHolder.kvz, R.color.CAM_X0204);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kvI, R.drawable.hot_topic_ranklist_bg);
                ap.setViewTextColor(hotRankListNormaItemHolder.kvH, R.color.CAM_X0302, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kvG, R.color.CAM_X0109, 1);
            }
        }
    }

    public void Mi(String str) {
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
