package com.baidu.tieba.hottopic.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.c, com.baidu.tieba.hottopic.b.b> {
    private TbPageContext Nw;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.Nw = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.hottopic.b.b b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.b(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_ranklist_normal_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.c cVar, com.baidu.tieba.hottopic.b.b bVar) {
        if (cVar != null) {
            a(bVar);
            a(i, bVar, cVar);
        }
        return view;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00f9: INVOKE  (r1v0 int A[REMOVE]) = (r11v0 com.baidu.tieba.hottopic.data.c) type: VIRTUAL call: com.baidu.tieba.hottopic.data.c.XN():int)] */
    private void a(int i, com.baidu.tieba.hottopic.b.b bVar, com.baidu.tieba.hottopic.data.c cVar) {
        if (bVar != null && cVar != null) {
            if (cVar.XN() == 1) {
                bVar.bLP.setText("");
                ar.k(bVar.bLP, t.f.icon_grade_shaitu1);
                bVar.bLS.setVisibility(0);
                bVar.bLT.setText(aB(StringUtils.isNull(cVar.XK()) ? this.mContext.getResources().getString(t.j.hot_topic_hot_list) : cVar.XK(), StringUtils.isNull(cVar.getTips()) ? this.mContext.getResources().getString(t.j.hot_topic_update_time) : cVar.getTips()));
                bVar.bLL.setVisibility(0);
                ar.k(bVar.bLW, t.f.hot_topic_ranklist_bg);
                bVar.bLW.setOnClickListener(new e(this, cVar));
            } else if (cVar.XN() == 2) {
                bVar.bLP.setText("");
                bVar.bLL.setVisibility(8);
                ar.k(bVar.bLP, t.f.icon_grade_shaitu2);
            } else if (cVar.XN() == 3) {
                bVar.bLP.setText("");
                bVar.bLL.setVisibility(8);
                ar.k(bVar.bLP, t.f.icon_grade_shaitu3);
            } else {
                String sb = new StringBuilder().append(cVar.XN()).toString();
                if (cVar.XN() < 10) {
                    sb = "0" + sb;
                }
                bVar.bLP.setText(sb);
                bVar.bLL.setVisibility(8);
                bVar.bLP.setBackgroundDrawable(null);
                bVar.bLS.setVisibility(8);
            }
            if (cVar.getTag() == 1) {
                bVar.bLR.setVisibility(0);
                ar.k(bVar.bLR, t.f.icon_topic_ranklist_new);
            } else if (cVar.getTag() == 2) {
                bVar.bLR.setVisibility(0);
                ar.k(bVar.bLR, t.f.icon_topic_ranklist_hot);
            } else if (cVar.getTag() == 3) {
                bVar.bLR.setVisibility(0);
                ar.k(bVar.bLR, t.f.icon_topic_ranklist_tuijian);
            } else {
                bVar.bLR.setVisibility(8);
            }
            String B = aw.B(cVar.XM());
            String str = "";
            if (!TextUtils.isEmpty(cVar.getName())) {
                str = UtilHelper.getFixedText(cVar.getName(), 10);
            }
            bVar.bLI.setText(str);
            bVar.bLQ.setText(B);
            bVar.bLV.setOnClickListener(new f(this, cVar));
        }
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar) {
        if (bVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (bVar.ahU != this.mSkinType) {
                bVar.ahU = this.mSkinType;
                ar.l(bVar.getView(), t.d.cp_bg_line_d);
                ar.b(bVar.bLP, t.d.cp_cont_e, 1);
                ar.b(bVar.bLI, t.d.cp_cont_b, 1);
                ar.b(bVar.bLQ, t.d.cp_cont_e, 1);
                ar.l(bVar.bLL, t.d.cp_bg_line_c);
                ar.l(bVar.bLM, t.d.cp_bg_line_c);
                ar.k(bVar.bLV, t.f.hot_topic_ranklist_bg);
                ar.b(bVar.bLU, t.d.cp_link_tip_c, 1);
                ar.k(bVar.bLX, t.f.btn_explain_blue);
                ar.b(bVar.bLT, t.d.cp_cont_d, 1);
            }
        }
    }

    private SpannableString aB(String str, String str2) {
        int length = !StringUtils.isNull(str) ? str.length() : 0;
        int length2 = !StringUtils.isNull(str2) ? str2.length() : 0;
        SpannableString spannableString = new SpannableString(str + str2);
        if (length <= 0 || length2 <= 0) {
            return spannableString;
        }
        spannableString.setSpan(new TextAppearanceSpan(this.Nw.getPageActivity(), t.k.hot_ranklist_module_name_stysle), 0, length, 33);
        spannableString.setSpan(new TextAppearanceSpan(this.Nw.getPageActivity(), t.k.hot_ranklist_module_tip_stysle), length, spannableString.length(), 33);
        return spannableString;
    }
}
