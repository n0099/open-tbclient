package com.baidu.tieba.ala.personcenter.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.ala.atomdata.AlaPrivilegeListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.j;
/* loaded from: classes6.dex */
public class h extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a>> {
    private TextView ewD;
    private long ewE;
    private long ewF;
    private String ewG;
    private TbPageContext mPageContext;
    private String user_id;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), j.exd);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.d.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        a(jVar, aVar.baX());
        aVar.baX().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.zh();
            }
        });
        return aVar.baX().getView();
    }

    private void a(j jVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = jVar.getPersonCenterData();
        if (personCenterData != null && aVar != null) {
            this.ewD = aVar.aYc();
            this.user_id = personCenterData.aXC().user_id;
            a(personCenterData, aVar);
            aVar.ol(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_privilege));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(com.baidu.tieba.ala.personcenter.c.b bVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        if (bVar != null && aVar != null) {
            if (AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, false)) {
                if (bVar.aXC() != null && bVar.aXC().mark_count != null) {
                    this.ewE = bVar.aXC().mark_count.user_mark_count;
                    this.ewF = bVar.aXC().mark_count.user_enter_effect_count;
                    StringBuilder sb = new StringBuilder();
                    if (this.ewE == 0) {
                        if (this.ewF != 0) {
                            sb.append(this.ewF).append("个特效");
                        }
                    } else if (this.ewF == 0) {
                        sb.append(this.ewE).append("枚勋章");
                    } else {
                        sb.append(this.ewE).append("枚勋章，").append(this.ewF).append("个特效");
                    }
                    this.ewG = sb.toString();
                    a(this.ewD, this.ewG, false);
                    return;
                }
                a(this.ewD, null, false);
                return;
            }
            a(this.ewD, null, true);
        }
    }

    private void a(TextView textView, String str, boolean z) {
        if (textView != null && this.mPageContext != null) {
            if (z) {
                textView.setText("");
                Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText("");
            }
            textView.setCompoundDrawables(null, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
        a(this.ewD, this.ewG, false);
        an anVar = new an("c13333");
        anVar.bS("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPrivilegeListActivityConfig(this.mPageContext.getPageActivity(), this.user_id, this.ewE, this.ewF)));
    }
}
