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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
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
            hotRankListNormaItemHolder.ksd.setVisibility(8);
            if (cVar.cUY() == 1) {
                hotRankListNormaItemHolder.ksa.setText("");
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksa, R.drawable.icon_grade_shaitu1);
                hotRankListNormaItemHolder.ksd.setVisibility(0);
                hotRankListNormaItemHolder.kse.setText(fq(StringUtils.isNull(cVar.cUV()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cUV(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                hotRankListNormaItemHolder.krW.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksh, R.drawable.hot_topic_ranklist_bg);
                hotRankListNormaItemHolder.ksh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            String cUW = cVar.cUW();
                            if (!StringUtils.isNull(cUW)) {
                                be.bwu().b(c.this.mPageContext, new String[]{cUW});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cUY() == 2) {
                hotRankListNormaItemHolder.ksa.setText("");
                hotRankListNormaItemHolder.krW.setVisibility(8);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksa, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cUY() == 3) {
                hotRankListNormaItemHolder.ksa.setText("");
                hotRankListNormaItemHolder.krW.setVisibility(8);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksa, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cUY();
                if (cVar.cUY() < 10) {
                    str = "0" + str;
                }
                hotRankListNormaItemHolder.ksa.setText(str);
                hotRankListNormaItemHolder.krW.setVisibility(8);
                hotRankListNormaItemHolder.ksa.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                hotRankListNormaItemHolder.ksc.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksc, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                hotRankListNormaItemHolder.ksc.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksc, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                hotRankListNormaItemHolder.ksc.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksc, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                hotRankListNormaItemHolder.ksc.setVisibility(8);
            }
            String numFormat9999W = at.numFormat9999W(cVar.cUX());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            hotRankListNormaItemHolder.krT.setText(str2);
            hotRankListNormaItemHolder.ksb.setText(numFormat9999W);
            hotRankListNormaItemHolder.ksg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new aq("c11237").dX("obj_id", String.valueOf(cVar.getId())).dX("obj_locate", c.this.type));
                }
            });
        }
    }

    private void a(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (hotRankListNormaItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (hotRankListNormaItemHolder.akW != this.mSkinType) {
                hotRankListNormaItemHolder.akW = this.mSkinType;
                ao.setBackgroundColor(hotRankListNormaItemHolder.getView(), R.color.CAM_X0201);
                ao.setViewTextColor(hotRankListNormaItemHolder.ksa, R.color.CAM_X0110, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.krT, R.color.CAM_X0105, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.ksb, R.color.CAM_X0110, 1);
                ao.setBackgroundColor(hotRankListNormaItemHolder.krW, R.color.CAM_X0204);
                ao.setBackgroundColor(hotRankListNormaItemHolder.krX, R.color.CAM_X0204);
                ao.setBackgroundResource(hotRankListNormaItemHolder.ksg, R.drawable.hot_topic_ranklist_bg);
                ao.setViewTextColor(hotRankListNormaItemHolder.ksf, R.color.CAM_X0302, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.kse, R.color.CAM_X0109, 1);
            }
        }
    }

    public void MC(String str) {
        this.type = str;
    }

    private SpannableString fq(String str, String str2) {
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
