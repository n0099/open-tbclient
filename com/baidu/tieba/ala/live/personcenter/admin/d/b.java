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
    private HeadImageView fAB;
    private TextView fDW;
    private TextView fDX;
    private com.baidu.tieba.ala.live.personcenter.admin.b.b fDY;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_adminlist_item, (ViewGroup) null));
        this.fAB = (HeadImageView) getView().findViewById(a.g.view_header);
        this.fAB.setIsRound(true);
        this.fDW = (TextView) getView().findViewById(a.g.text_user_name);
        this.fDX = (TextView) getView().findViewById(a.g.btn_right);
        this.fDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913050, b.this.fDY);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913050, b.this.fDY);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        this.fDY = bVar;
        k.a(this.fAB, bVar.getPortrait(), false, false);
        this.fDW.setText(bVar.baZ());
    }
}
