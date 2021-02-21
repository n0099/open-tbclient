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
/* loaded from: classes11.dex */
public class b extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c gMS;
    private CheckedTextView gMT;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_one, (ViewGroup) null));
        this.gMT = (CheckedTextView) getView().findViewById(a.f.category_one_name_tv);
        this.gMT.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.gMS = cVar;
            boolean z = !StringUtils.isNull(this.gMS.getId()) && TextUtils.equals(this.gMS.getId(), str);
            this.gMT.setText(this.gMS.getName());
            this.gMT.setBackgroundColor(this.gMT.getContext().getResources().getColor(z ? a.c.bg_category_one_selected : a.c.bg_category_one_normal));
            this.gMT.setTextColor(this.gMT.getContext().getResources().getColor(z ? a.c.sdk_color_ff1e66 : a.c.sdk_white_alpha60));
            this.gMT.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gMT.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.gMS));
        }
    }
}
