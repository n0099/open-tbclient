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
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private BarImageView gmZ;
    private View.OnClickListener gmj;
    private TextView gna;
    private TextView gnb;
    private TextView gnc;
    private com.baidu.tieba.forumsearch.b.b gnd;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gmZ = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.gna = (TextView) getView().findViewById(R.id.forum_name);
        this.gnb = (TextView) getView().findViewById(R.id.forum_attention);
        this.gnc = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void x(View.OnClickListener onClickListener) {
        this.gmj = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gna, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gnb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gnc, (int) R.color.cp_cont_d);
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
            this.gnd = bVar;
            this.gmZ.startLoad(bVar.getAvatar(), 10, false);
            this.gna.setText(m34do(bVar.getForumName(), bVar.bCS()));
            this.gnb.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.bCQ()));
            this.gnc.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.bCR()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* renamed from: do  reason: not valid java name */
    public SpannableStringBuilder m34do(String str, String str2) {
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
        if (this.gnd != null) {
            TiebaStatic.log("c12261");
            e.Bb(this.gnd.bCS());
            view.setTag(this.gnd);
            if (this.gmj != null) {
                this.gmj.onClick(view);
            }
        }
    }
}
