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
    private View.OnClickListener gWk;
    private BarImageView gXb;
    private TextView gXc;
    private TextView gXd;
    private TextView gXe;
    private com.baidu.tieba.forumsearch.b.b gXf;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gXb = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.gXc = (TextView) getView().findViewById(R.id.forum_name);
        this.gXd = (TextView) getView().findViewById(R.id.forum_attention);
        this.gXe = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(View.OnClickListener onClickListener) {
        this.gWk = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gXc, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gXd, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gXe, (int) R.color.cp_cont_d);
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
    /* renamed from: c */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.gXf = bVar;
            this.gXb.startLoad(bVar.getAvatar(), 10, false);
            this.gXc.setText(dB(bVar.getForumName(), bVar.bNz()));
            this.gXd.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.bNx()));
            this.gXe.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.bNy()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder dB(String str, String str2) {
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
        if (this.gXf != null) {
            TiebaStatic.log("c12261");
            e.CO(this.gXf.bNz());
            view.setTag(this.gXf);
            if (this.gWk != null) {
                this.gWk.onClick(view);
            }
        }
    }
}
