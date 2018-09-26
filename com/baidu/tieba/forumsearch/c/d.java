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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.b> {
    private View.OnClickListener dqw;
    private BarImageView dri;
    private TextView drj;
    private TextView drk;
    private TextView drl;
    private com.baidu.tieba.forumsearch.b.b drm;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dri = (BarImageView) getView().findViewById(e.g.forum_avatar);
        this.drj = (TextView) getView().findViewById(e.g.forum_name);
        this.drk = (TextView) getView().findViewById(e.g.forum_attention);
        this.drl = (TextView) getView().findViewById(e.g.forum_thread_count);
        getView().setOnClickListener(this);
        d(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void p(View.OnClickListener onClickListener) {
        this.dqw = onClickListener;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.drj, e.d.cp_cont_b);
            al.h(this.drk, e.d.cp_cont_d);
            al.h(this.drl, e.d.cp_cont_d);
            al.i(getView(), e.f.square_search_item_bg);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.forum_search_result_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            this.drm = bVar;
            this.dri.startLoad(bVar.getAvatar(), 10, false);
            this.drj.setText(bl(bVar.getForumName(), bVar.avn()));
            this.drk.setText(String.format(this.mTbPageContext.getString(e.j.concern), bVar.avl()));
            this.drl.setText(String.format(this.mTbPageContext.getString(e.j.search_bar_thread), bVar.avm()));
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public SpannableStringBuilder bl(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        String trim = str2.trim();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_h));
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
        if (this.drm != null) {
            TiebaStatic.log("c12261");
            com.baidu.tieba.forumsearch.controller.e.mU(this.drm.avn());
            view.setTag(this.drm);
            if (this.dqw != null) {
                this.dqw.onClick(view);
            }
        }
    }
}
