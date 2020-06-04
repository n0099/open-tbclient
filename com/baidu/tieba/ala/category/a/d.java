package com.baidu.tieba.ala.category.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c fnq;
    private TextView fns;
    private ImageView fnt;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.item_live_category_two, (ViewGroup) null));
        this.fns = (TextView) getView().findViewById(a.g.category_two_name_tv);
        this.fnt = (ImageView) getView().findViewById(a.g.cb_iv);
        this.fnt.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.fnq = cVar;
            this.fns.setText(this.fnq.getName());
            this.fnt.setSelected(!StringUtils.isNull(this.fnq.getId()) && TextUtils.equals(this.fnq.getId(), str));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fns.isSelected()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913201, this.fnq));
        }
    }
}
