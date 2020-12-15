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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView gRA;
    private TextView gYM;
    private TextView gYN;
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.b hae;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.sdk_prc_person_forbiddenlist_item, (ViewGroup) null));
        this.gRA = (HeadImageView) getView().findViewById(a.f.view_header);
        this.gRA.setIsRound(true);
        this.gYM = (TextView) getView().findViewById(a.f.text_user_name);
        this.gYN = (TextView) getView().findViewById(a.f.btn_right);
        this.gYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913051, b.this.hae);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913051, b.this.hae);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.hae = bVar;
        l.a(this.gRA, bVar.getPortrait(), false, false);
        this.gYM.setText(bVar.bAh());
    }
}
