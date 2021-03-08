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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
/* loaded from: classes10.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView hdo;
    private TextView hmh;
    private TextView hmi;
    private com.baidu.tieba.ala.live.personcenter.admin.b.b hmj;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.g.sdk_prc_person_adminlist_item, (ViewGroup) null));
        this.hdo = (HeadImageView) getView().findViewById(a.f.view_header);
        this.hdo.setIsRound(true);
        this.hmh = (TextView) getView().findViewById(a.f.text_user_name);
        this.hmi = (TextView) getView().findViewById(a.f.btn_right);
        this.hmi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913050, b.this.hmj);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913050, b.this.hmj);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        this.hmj = bVar;
        m.a(this.hdo, bVar.getPortrait(), false, false);
        this.hmh.setText(bVar.bzd());
    }
}
