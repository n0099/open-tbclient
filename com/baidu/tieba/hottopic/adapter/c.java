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
/* loaded from: classes7.dex */
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
    /* renamed from: ca */
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
            hotRankListNormaItemHolder.kxV.setVisibility(8);
            if (cVar.cTu() == 1) {
                hotRankListNormaItemHolder.kxS.setText("");
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxS, R.drawable.icon_grade_shaitu1);
                hotRankListNormaItemHolder.kxV.setVisibility(0);
                hotRankListNormaItemHolder.kxW.setText(fp(StringUtils.isNull(cVar.cTr()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cTr(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                hotRankListNormaItemHolder.kxO.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxZ, R.drawable.hot_topic_ranklist_bg);
                hotRankListNormaItemHolder.kxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            String cTs = cVar.cTs();
                            if (!StringUtils.isNull(cTs)) {
                                bf.bsY().b(c.this.mPageContext, new String[]{cTs});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cTu() == 2) {
                hotRankListNormaItemHolder.kxS.setText("");
                hotRankListNormaItemHolder.kxO.setVisibility(8);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxS, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cTu() == 3) {
                hotRankListNormaItemHolder.kxS.setText("");
                hotRankListNormaItemHolder.kxO.setVisibility(8);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxS, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cTu();
                if (cVar.cTu() < 10) {
                    str = "0" + str;
                }
                hotRankListNormaItemHolder.kxS.setText(str);
                hotRankListNormaItemHolder.kxO.setVisibility(8);
                hotRankListNormaItemHolder.kxS.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                hotRankListNormaItemHolder.kxU.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxU, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                hotRankListNormaItemHolder.kxU.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxU, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                hotRankListNormaItemHolder.kxU.setVisibility(0);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxU, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                hotRankListNormaItemHolder.kxU.setVisibility(8);
            }
            String numFormat9999W = au.numFormat9999W(cVar.cTt());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            hotRankListNormaItemHolder.kxL.setText(str2);
            hotRankListNormaItemHolder.kxT.setText(numFormat9999W);
            hotRankListNormaItemHolder.kxY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.2
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
            if (hotRankListNormaItemHolder.aln != this.mSkinType) {
                hotRankListNormaItemHolder.aln = this.mSkinType;
                ap.setBackgroundColor(hotRankListNormaItemHolder.getView(), R.color.CAM_X0201);
                ap.setViewTextColor(hotRankListNormaItemHolder.kxS, R.color.CAM_X0110, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kxL, R.color.CAM_X0105, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kxT, R.color.CAM_X0110, 1);
                ap.setBackgroundColor(hotRankListNormaItemHolder.kxO, R.color.CAM_X0204);
                ap.setBackgroundColor(hotRankListNormaItemHolder.kxP, R.color.CAM_X0204);
                ap.setBackgroundResource(hotRankListNormaItemHolder.kxY, R.drawable.hot_topic_ranklist_bg);
                ap.setViewTextColor(hotRankListNormaItemHolder.kxX, R.color.CAM_X0302, 1);
                ap.setViewTextColor(hotRankListNormaItemHolder.kxW, R.color.CAM_X0109, 1);
            }
        }
    }

    public void Mp(String str) {
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
