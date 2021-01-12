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
/* loaded from: classes10.dex */
public class b extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c gJY;
    private CheckedTextView gJZ;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_one, (ViewGroup) null));
        this.gJZ = (CheckedTextView) getView().findViewById(a.f.category_one_name_tv);
        this.gJZ.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.gJY = cVar;
            boolean z = !StringUtils.isNull(this.gJY.getId()) && TextUtils.equals(this.gJY.getId(), str);
            this.gJZ.setText(this.gJY.getName());
            this.gJZ.setBackgroundColor(this.gJZ.getContext().getResources().getColor(z ? a.c.bg_category_one_selected : a.c.bg_category_one_normal));
            this.gJZ.setTextColor(this.gJZ.getContext().getResources().getColor(z ? a.c.sdk_color_ff1e66 : a.c.sdk_white_alpha60));
            this.gJZ.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gJZ.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.gJY));
        }
    }
}
