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
    private BarImageView fuS;
    private TextView fuT;
    private TextView fuU;
    private TextView fuV;
    private com.baidu.tieba.forumsearch.b.b fuW;
    private View.OnClickListener fue;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fuS = (BarImageView) getView().findViewById(R.id.forum_avatar);
        this.fuT = (TextView) getView().findViewById(R.id.forum_name);
        this.fuU = (TextView) getView().findViewById(R.id.forum_attention);
        this.fuV = (TextView) getView().findViewById(R.id.forum_thread_count);
        getView().setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void u(View.OnClickListener onClickListener) {
        this.fue = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.fuT, R.color.cp_cont_b);
            am.j(this.fuU, R.color.cp_cont_d);
            am.j(this.fuV, R.color.cp_cont_d);
            am.k(getView(), R.drawable.square_search_item_bg);
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
            this.fuW = bVar;
            this.fuS.startLoad(bVar.getAvatar(), 10, false);
            this.fuT.setText(cY(bVar.getForumName(), bVar.blN()));
            this.fuU.setText(String.format(this.mTbPageContext.getString(R.string.concern), bVar.blL()));
            this.fuV.setText(String.format(this.mTbPageContext.getString(R.string.search_bar_thread), bVar.blM()));
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder cY(String str, String str2) {
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
        if (this.fuW != null) {
            TiebaStatic.log("c12261");
            e.xr(this.fuW.blN());
            view.setTag(this.fuW);
            if (this.fue != null) {
                this.fue.onClick(view);
            }
        }
    }
}
