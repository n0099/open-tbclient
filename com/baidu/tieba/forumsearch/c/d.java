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
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener jcR;
    private BarImageView jdH;
    private TextView jdI;
    private TextView jdJ;
    private TextView jdK;
    private com.baidu.tieba.forumsearch.b.b jdL;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.jdH = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.jdI = (TextView) getView().findViewById(R.id.forum_name);
        this.jdJ = (TextView) getView().findViewById(R.id.forum_attention);
        this.jdK = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(View.OnClickListener onClickListener) {
        this.jcR = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.jdI, R.color.CAM_X0105);
            ao.setViewTextColor(this.jdJ, R.color.CAM_X0109);
            ao.setViewTextColor(this.jdK, R.color.CAM_X0109);
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
            this.jdL = bVar;
            this.jdH.startLoad(bVar.getAvatar(), 10, false);
            this.jdI.setText(eX(bVar.getForumName(), bVar.cDM()));
            this.jdJ.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.cDK()));
            this.jdK.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.cDL()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder eX(String str, String str2) {
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
        if (this.jdL != null) {
            TiebaStatic.log("c12261");
            e.KD(this.jdL.cDM());
            view.setTag(this.jdL);
            if (this.jcR != null) {
                this.jcR.onClick(view);
            }
        }
    }
}
