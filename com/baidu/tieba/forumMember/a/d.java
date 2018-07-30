package com.baidu.tieba.forumMember.a;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class d extends h<e, f> {
    private View.OnClickListener mOnItemClickListener;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = (e) view.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.mContext, eVar.getUserId(), eVar.getName(), "")));
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(d.h.manito_item_member, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, f fVar) {
        super.onFillViewHolder(i, view, viewGroup, eVar, fVar);
        if (eVar != null && fVar != null) {
            if (fVar.mSkinType != this.mSkinType) {
                am.i(fVar.getView(), d.f.frs_member_manito_bg);
                am.c(fVar.bwj, d.C0140d.cp_cont_b, 1);
                am.c(fVar.cDY, d.C0140d.cp_cont_c, 1);
                am.j(fVar.bkw, d.C0140d.cp_bg_line_c);
                am.c(fVar.diO, d.C0140d.cp_cont_c, 1);
            }
            fVar.diN.startLoad(eVar.asZ(), 12, false);
            fVar.bwj.setText(w.C(eVar.getNameShow(), 16));
            if (StringUtils.isNull(eVar.getIntro())) {
                fVar.cDY.setText(d.j.god_intro_default);
            } else {
                fVar.cDY.setText(w.C(eVar.getIntro(), 30));
            }
            int color = am.getColor(d.C0140d.cp_cont_h);
            String A = ap.A(eVar.getFansNum());
            fVar.diO.setText(a(String.format(this.mContext.getResources().getString(d.j.fans_count), A), new String[]{A}, new int[]{color}));
            fVar.getView().setTag(eVar);
            fVar.getView().setOnClickListener(this.mOnItemClickListener);
            fVar.mSkinType = this.mSkinType;
        }
        return view;
    }

    private SpannableStringBuilder a(String str, String[] strArr, int[] iArr) {
        int indexOf;
        if (str == null || strArr == null || iArr == null || strArr.length <= 0 || iArr.length <= 0 || strArr.length != iArr.length) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(str);
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && (indexOf = str.indexOf(strArr[i])) >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(iArr[i]), indexOf, strArr[i].length() + indexOf, 17);
            }
        }
        spannableStringBuilder.append((CharSequence) spannableString);
        return spannableStringBuilder;
    }
}
