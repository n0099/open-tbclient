package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener fmT;
    private BarImageView fnH;
    private TextView fnI;
    private TextView fnJ;
    private TextView fnK;
    private com.baidu.tieba.forumsearch.b.b fnL;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fnH = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.fnI = (TextView) getView().findViewById(R.id.forum_name);
        this.fnJ = (TextView) getView().findViewById(R.id.forum_attention);
        this.fnK = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void u(View.OnClickListener onClickListener) {
        this.fmT = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fnI, R.color.cp_cont_b);
            al.j(this.fnJ, R.color.cp_cont_d);
            al.j(this.fnK, R.color.cp_cont_d);
            al.k(getView(), R.drawable.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.fnL = bVar;
            this.fnH.startLoad(bVar.getAvatar(), 10, false);
            this.fnI.setText(cW(bVar.getForumName(), bVar.biT()));
            this.fnJ.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.biR()));
            this.fnK.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.biS()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder cW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_h));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(trim);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fnL != null) {
            TiebaStatic.log("c12261");
            e.wn(this.fnL.biT());
            view.setTag(this.fnL);
            if (this.fmT != null) {
                this.fmT.onClick(view);
            }
        }
    }
}
