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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c fnq;
    private CheckedTextView fnr;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.item_live_category_one, (ViewGroup) null));
        this.fnr = (CheckedTextView) getView().findViewById(a.g.category_one_name_tv);
        this.fnr.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.fnq = cVar;
            boolean z = !StringUtils.isNull(this.fnq.getId()) && TextUtils.equals(this.fnq.getId(), str);
            this.fnr.setText(this.fnq.getName());
            this.fnr.setBackgroundColor(this.fnr.getContext().getResources().getColor(z ? a.d.bg_category_one_selected : a.d.bg_category_one_normal));
            this.fnr.setTextColor(this.fnr.getContext().getResources().getColor(z ? a.d.sdk_color_ff1e66 : a.d.sdk_white_alpha60));
            this.fnr.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fnr.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.fnq));
        }
    }
}
