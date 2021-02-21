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
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c gMS;
    private TextView gMU;
    private ImageView gMV;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_two, (ViewGroup) null));
        this.gMU = (TextView) getView().findViewById(a.f.category_two_name_tv);
        this.gMV = (ImageView) getView().findViewById(a.f.cb_iv);
        this.gMV.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.gMS = cVar;
            this.gMU.setText(this.gMS.getName());
            this.gMV.setSelected(!StringUtils.isNull(this.gMS.getId()) && TextUtils.equals(this.gMS.getId(), str));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gMU.isSelected()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913201, this.gMS));
        }
    }
}
