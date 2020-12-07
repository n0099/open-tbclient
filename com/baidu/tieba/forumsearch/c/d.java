package com.baidu.tieba.forumsearch.c;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
/* loaded from: classes24.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener iQD;
    private BarImageView iRt;
    private TextView iRu;
    private TextView iRv;
    private TextView iRw;
    private com.baidu.tieba.forumsearch.b.b iRx;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.iRt = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.iRu = (TextView) getView().findViewById(R.id.forum_name);
        this.iRv = (TextView) getView().findViewById(R.id.forum_attention);
        this.iRw = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void z(View.OnClickListener onClickListener) {
        this.iQD = onClickListener;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iRu, R.color.CAM_X0105);
            ap.setViewTextColor(this.iRv, R.color.CAM_X0109);
            ap.setViewTextColor(this.iRw, R.color.CAM_X0109);
            ap.setBackgroundResource(getView(), R.drawable.square_search_item_bg);
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
            this.iRx = bVar;
            this.iRt.startLoad(bVar.getAvatar(), 10, false);
            this.iRu.setText(eW(bVar.getForumName(), bVar.cAS()));
            this.iRv.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.cAQ()));
            this.iRw.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.cAR()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder eW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
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
        if (this.iRx != null) {
            TiebaStatic.log("c12261");
            e.KF(this.iRx.cAS());
            view.setTag(this.iRx);
            if (this.iQD != null) {
                this.iQD.onClick(view);
            }
        }
    }
}
