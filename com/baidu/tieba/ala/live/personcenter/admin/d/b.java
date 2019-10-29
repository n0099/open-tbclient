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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class b extends TypeAdapter.ViewHolder {
    private HeadImageView dPu;
    private TextView dRf;
    private TextView dRg;
    private com.baidu.tieba.ala.live.personcenter.admin.b.b dRh;

    public b(Context context, final BdUniqueId bdUniqueId) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_prc_person_adminlist_item, (ViewGroup) null));
        this.dPu = (HeadImageView) getView().findViewById(a.g.view_header);
        this.dPu.setIsRound(true);
        this.dRf = (TextView) getView().findViewById(a.g.text_user_name);
        this.dRg = (TextView) getView().findViewById(a.g.btn_right);
        this.dRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomMessage customMessage = new CustomMessage(2913050, b.this.dRh);
                customMessage.setTag(bdUniqueId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913050, b.this.dRh);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        });
    }

    public void b(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        this.dRh = bVar;
        j.a(this.dPu, bVar.getPortrait(), false, false);
        this.dRf.setText(bVar.asc());
    }
}
