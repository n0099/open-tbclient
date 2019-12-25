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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView eCJ;
    private TextView eFQ;
    private TextView eFR;
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.b eHl;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_forbiddenlist_item, (ViewGroup) null));
        this.eCJ = (HeadImageView) getView().findViewById(a.g.view_header);
        this.eCJ.setIsRound(true);
        this.eFQ = (TextView) getView().findViewById(a.g.text_user_name);
        this.eFR = (TextView) getView().findViewById(a.g.btn_right);
        this.eFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913051, b.this.eHl);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913051, b.this.eHl);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.eHl = bVar;
        k.a(this.eCJ, bVar.getPortrait(), false, false);
        this.eFQ.setText(bVar.aJz());
    }
}
