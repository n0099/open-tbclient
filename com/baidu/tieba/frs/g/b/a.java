package com.baidu.tieba.frs.g.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.frs.g.a<b> {
    private final View.OnClickListener enQ;

    public a(@NonNull TbPageContext tbPageContext) {
        super(tbPageContext);
        this.enQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b item = a.this.getItem(0);
                if (item != null && !TextUtils.isEmpty(item.getUrl())) {
                    ay.Es().a((TbPageContext<?>) a.this.aJZ(), new String[]{item.getUrl()}, true);
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.g.a
    protected View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(e.h.frs_header_youhua_hot_title_item, viewGroup, false);
            inflate.setOnClickListener(this.enQ);
            al.i(inflate.findViewById(e.g.top_youhua_thread_title_item_layout), e.f.home_thread_card_item_bg);
            al.h(inflate.findViewById(e.g.frs_top_youhua_thread_title_label), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.frs_top_youhua_thread_title_all_label), e.d.cp_cont_j);
            al.c((ImageView) inflate.findViewById(e.g.frs_top_youhua_thread_title_arrow), e.f.icon_arrow_more_gray_n);
            return inflate;
        }
        return view;
    }
}
