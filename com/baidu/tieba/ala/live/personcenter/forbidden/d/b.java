package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView eHO;
    private TextView eKU;
    private TextView eKV;
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.b eMp;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_forbiddenlist_item, (ViewGroup) null));
        this.eHO = (HeadImageView) getView().findViewById(a.g.view_header);
        this.eHO.setIsRound(true);
        this.eKU = (TextView) getView().findViewById(a.g.text_user_name);
        this.eKV = (TextView) getView().findViewById(a.g.btn_right);
        this.eKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913051, b.this.eMp);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913051, b.this.eMp);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.eMp = bVar;
        k.a(this.eHO, bVar.getPortrait(), false, false);
        this.eKU.setText(bVar.aMn());
    }
}
