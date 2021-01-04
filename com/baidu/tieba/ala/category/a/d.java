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
    private com.baidu.tieba.ala.category.b.c gOE;
    private TextView gOG;
    private ImageView gOH;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.item_live_category_two, (ViewGroup) null));
        this.gOG = (TextView) getView().findViewById(a.f.category_two_name_tv);
        this.gOH = (ImageView) getView().findViewById(a.f.cb_iv);
        this.gOH.setOnClickListener(this);
    }

    public void a(com.baidu.tieba.ala.category.b.c cVar, String str) {
        if (cVar != null) {
            this.gOE = cVar;
            this.gOG.setText(this.gOE.getName());
            this.gOH.setSelected(!StringUtils.isNull(this.gOE.getId()) && TextUtils.equals(this.gOE.getId(), str));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gOG.isSelected()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913201, this.gOE));
        }
    }
}
