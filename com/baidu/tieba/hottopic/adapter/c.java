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
            hotRankListNormaItemHolder.kny.setVisibility(8);
            if (cVar.cRh() == 1) {
                hotRankListNormaItemHolder.knv.setText("");
                ao.setBackgroundResource(hotRankListNormaItemHolder.knv, R.drawable.icon_grade_shaitu1);
                hotRankListNormaItemHolder.kny.setVisibility(0);
                hotRankListNormaItemHolder.knz.setText(fp(StringUtils.isNull(cVar.cRe()) ? this.mContext.getResources().getString(R.string.hot_topic_hot_list) : cVar.cRe(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(R.string.hot_topic_update_time) : cVar.getTips()));
                hotRankListNormaItemHolder.knr.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knC, R.drawable.hot_topic_ranklist_bg);
                hotRankListNormaItemHolder.knC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            String cRf = cVar.cRf();
                            if (!StringUtils.isNull(cRf)) {
                                be.bsB().b(c.this.mPageContext, new String[]{cRf});
                            }
                        }
                        TiebaStatic.log("c10820");
                    }
                });
            } else if (cVar.cRh() == 2) {
                hotRankListNormaItemHolder.knv.setText("");
                hotRankListNormaItemHolder.knr.setVisibility(8);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knv, R.drawable.icon_grade_shaitu2);
            } else if (cVar.cRh() == 3) {
                hotRankListNormaItemHolder.knv.setText("");
                hotRankListNormaItemHolder.knr.setVisibility(8);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knv, R.drawable.icon_grade_shaitu3);
            } else {
                String str = "" + cVar.cRh();
                if (cVar.cRh() < 10) {
                    str = "0" + str;
                }
                hotRankListNormaItemHolder.knv.setText(str);
                hotRankListNormaItemHolder.knr.setVisibility(8);
                hotRankListNormaItemHolder.knv.setBackgroundDrawable(null);
            }
            if (cVar.getTag() == 1) {
                hotRankListNormaItemHolder.knx.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knx, R.drawable.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                hotRankListNormaItemHolder.knx.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knx, R.drawable.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                hotRankListNormaItemHolder.knx.setVisibility(0);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knx, R.drawable.icon_topic_ranklist_tuijian);
            } else {
                hotRankListNormaItemHolder.knx.setVisibility(8);
            }
            String numFormat9999W = at.numFormat9999W(cVar.cRg());
            String str2 = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str2 = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            hotRankListNormaItemHolder.kno.setText(str2);
            hotRankListNormaItemHolder.knw.setText(numFormat9999W);
            hotRankListNormaItemHolder.knB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(cVar.getId()), cVar.getName(), "5")));
                    TiebaStatic.log(new aq("c11237").dW("obj_id", String.valueOf(cVar.getId())).dW("obj_locate", c.this.type));
                }
            });
        }
    }

    private void a(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (hotRankListNormaItemHolder != null) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (hotRankListNormaItemHolder.akf != this.mSkinType) {
                hotRankListNormaItemHolder.akf = this.mSkinType;
                ao.setBackgroundColor(hotRankListNormaItemHolder.getView(), R.color.CAM_X0201);
                ao.setViewTextColor(hotRankListNormaItemHolder.knv, R.color.CAM_X0110, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.kno, R.color.CAM_X0105, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.knw, R.color.CAM_X0110, 1);
                ao.setBackgroundColor(hotRankListNormaItemHolder.knr, R.color.CAM_X0204);
                ao.setBackgroundColor(hotRankListNormaItemHolder.kns, R.color.CAM_X0204);
                ao.setBackgroundResource(hotRankListNormaItemHolder.knB, R.drawable.hot_topic_ranklist_bg);
                ao.setViewTextColor(hotRankListNormaItemHolder.knA, R.color.CAM_X0302, 1);
                ao.setViewTextColor(hotRankListNormaItemHolder.knz, R.color.CAM_X0109, 1);
            }
        }
    }

    public void Lu(String str) {
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
