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
/* loaded from: classes3.dex */
public class b extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c fyE;
    private CheckedTextView fyF;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.item_live_category_one, (ViewGroup) null));
        this.fyF = (CheckedTextView) getView().findViewById(a.g.category_one_name_tv);
        this.fyF.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.fyE = cVar;
            boolean z = !StringUtils.isNull(this.fyE.getId()) && TextUtils.equals(this.fyE.getId(), str);
            this.fyF.setText(this.fyE.getName());
            this.fyF.setBackgroundColor(this.fyF.getContext().getResources().getColor(z ? a.d.bg_category_one_selected : a.d.bg_category_one_normal));
            this.fyF.setTextColor(this.fyF.getContext().getResources().getColor(z ? a.d.sdk_color_ff1e66 : a.d.sdk_white_alpha60));
            this.fyF.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fyF.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.fyE));
        }
    }
}
