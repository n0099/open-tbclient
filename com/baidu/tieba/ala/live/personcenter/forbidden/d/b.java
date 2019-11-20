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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView dOD;
    private TextView dQo;
    private TextView dQp;
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.b dRE;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_forbiddenlist_item, (ViewGroup) null));
        this.dOD = (HeadImageView) getView().findViewById(a.g.view_header);
        this.dOD.setIsRound(true);
        this.dQo = (TextView) getView().findViewById(a.g.text_user_name);
        this.dQp = (TextView) getView().findViewById(a.g.btn_right);
        this.dQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913051, b.this.dRE);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913051, b.this.dRE);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.dRE = bVar;
        j.a(this.dOD, bVar.getPortrait(), false, false);
        this.dQo.setText(bVar.asa());
    }
}
