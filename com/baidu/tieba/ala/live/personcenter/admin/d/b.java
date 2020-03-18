package com.baidu.tieba.ala.live.personcenter.admin.d;

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
    private HeadImageView eIy;
    private TextView eLE;
    private TextView eLF;
    private com.baidu.tieba.ala.live.personcenter.admin.b.b eLG;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_adminlist_item, (ViewGroup) null));
        this.eIy = (HeadImageView) getView().findViewById(a.g.view_header);
        this.eIy.setIsRound(true);
        this.eLE = (TextView) getView().findViewById(a.g.text_user_name);
        this.eLF = (TextView) getView().findViewById(a.g.btn_right);
        this.eLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913050, b.this.eLG);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913050, b.this.eLG);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        this.eLG = bVar;
        k.a(this.eIy, bVar.getPortrait(), false, false);
        this.eLE.setText(bVar.aMu());
    }
}
