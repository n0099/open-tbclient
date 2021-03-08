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
    private com.baidu.tieba.ala.category.b.c gOB;
    private CheckedTextView gOC;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_one, (ViewGroup) null));
        this.gOC = (CheckedTextView) getView().findViewById(a.f.category_one_name_tv);
        this.gOC.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.gOB = cVar;
            boolean z = !StringUtils.isNull(this.gOB.getId()) && TextUtils.equals(this.gOB.getId(), str);
            this.gOC.setText(this.gOB.getName());
            this.gOC.setBackgroundColor(this.gOC.getContext().getResources().getColor(z ? a.c.bg_category_one_selected : a.c.bg_category_one_normal));
            this.gOC.setTextColor(this.gOC.getContext().getResources().getColor(z ? a.c.sdk_color_ff1e66 : a.c.sdk_white_alpha60));
            this.gOC.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gOC.isChecked()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913200, this.gOB));
        }
    }
}
