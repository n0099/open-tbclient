package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener fsA;
    private BarImageView fto;
    private TextView ftp;
    private TextView ftq;
    private TextView ftr;
    private com.baidu.tieba.forumsearch.b.b fts;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fto = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.ftp = (TextView) getView().findViewById(R.id.forum_name);
        this.ftq = (TextView) getView().findViewById(R.id.forum_attention);
        this.ftr = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void v(View.OnClickListener onClickListener) {
        this.fsA = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ftp, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ftq, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ftr, (int) R.color.cp_cont_d);
            am.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
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
            this.fts = bVar;
            this.fto.startLoad(bVar.getAvatar(), 10, false);
            this.ftp.setText(cJ(bVar.getForumName(), bVar.biR()));
            this.ftq.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.biP()));
            this.ftr.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.biQ()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder cJ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
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
        if (this.fts != null) {
            TiebaStatic.log("c12261");
            e.vJ(this.fts.biR());
            view.setTag(this.fts);
            if (this.fsA != null) {
                this.fsA.onClick(view);
            }
        }
    }
}
