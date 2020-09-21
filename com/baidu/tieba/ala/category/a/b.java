package com.baidu.tieba.ala.category.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class b extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c fSr;
    private CheckedTextView fSs;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.item_live_category_one, (ViewGroup) null));
        this.fSs = (CheckedTextView) getView().findViewById(a.g.category_one_name_tv);
        this.fSs.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.fSr = cVar;
            boolean z = !StringUtils.isNull(this.fSr.getId()) && TextUtils.equals(this.fSr.getId(), str);
            this.fSs.setText(this.fSr.getName());
            this.fSs.setBackgroundColor(this.fSs.getContext().getResources().getColor(z ? a.d.bg_category_one_selected : a.d.bg_category_one_normal));
            this.fSs.setTextColor(this.fSs.getContext().getResources().getColor(z ? a.d.sdk_color_ff1e66 : a.d.sdk_white_alpha60));
            this.fSs.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fSs.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.fSr));
        }
    }
}
