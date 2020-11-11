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
/* loaded from: classes4.dex */
public class d extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tieba.ala.category.b.c guA;
    private TextView guC;
    private ImageView guD;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_two, (ViewGroup) null));
        this.guC = (TextView) getView().findViewById(a.f.category_two_name_tv);
        this.guD = (ImageView) getView().findViewById(a.f.cb_iv);
        this.guD.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.guA = cVar;
            this.guC.setText(this.guA.getName());
            this.guD.setSelected(!StringUtils.isNull(this.guA.getId()) && TextUtils.equals(this.guA.getId(), str));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.guC.isSelected()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913201, this.guA));
        }
    }
}
