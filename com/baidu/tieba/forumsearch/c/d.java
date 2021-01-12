package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener iYk;
    private BarImageView iZa;
    private TextView iZb;
    private TextView iZc;
    private TextView iZd;
    private com.baidu.tieba.forumsearch.b.b iZe;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.iZa = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.iZb = (TextView) getView().findViewById(R.id.forum_name);
        this.iZc = (TextView) getView().findViewById(R.id.forum_attention);
        this.iZd = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(View.OnClickListener onClickListener) {
        this.iYk = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.iZb, R.color.CAM_X0105);
            ao.setViewTextColor(this.iZc, R.color.CAM_X0109);
            ao.setViewTextColor(this.iZd, R.color.CAM_X0109);
            ao.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: c */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.iZe = bVar;
            this.iZa.startLoad(bVar.getAvatar(), 10, false);
            this.iZb.setText(eW(bVar.getForumName(), bVar.czV()));
            this.iZc.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.czT()));
            this.iZd.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.czU()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder eW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301));
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
        if (this.iZe != null) {
            TiebaStatic.log("c12261");
            e.Jr(this.iZe.czV());
            view.setTag(this.iZe);
            if (this.iYk != null) {
                this.iYk.onClick(view);
            }
        }
    }
}
