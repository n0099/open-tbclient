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
    private TextView exv;
    private long exw;
    private long exx;
    private String exy;
    private TbPageContext mPageContext;
    private String user_id;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), j.exV);
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
        if (aVar.baZ() == null) {
            return null;
        }
        a(jVar, aVar.baZ());
        aVar.baZ().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.zg();
            }
        });
        return aVar.baZ().getView();
    }

    private void a(j jVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = jVar.getPersonCenterData();
        if (personCenterData != null && aVar != null) {
            this.exv = aVar.aYe();
            this.user_id = personCenterData.aXE().user_id;
            a(personCenterData, aVar);
            aVar.om(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_privilege));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(com.baidu.tieba.ala.personcenter.c.b bVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        if (bVar != null && aVar != null) {
            if (AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, false)) {
                if (bVar.aXE() != null && bVar.aXE().mark_count != null) {
                    this.exw = bVar.aXE().mark_count.user_mark_count;
                    this.exx = bVar.aXE().mark_count.user_enter_effect_count;
                    StringBuilder sb = new StringBuilder();
                    if (this.exw == 0) {
                        if (this.exx != 0) {
                            sb.append(this.exx).append("个特效");
                        }
                    } else if (this.exx == 0) {
                        sb.append(this.exw).append("枚勋章");
                    } else {
                        sb.append(this.exw).append("枚勋章，").append(this.exx).append("个特效");
                    }
                    this.exy = sb.toString();
                    a(this.exv, this.exy, false);
                    return;
                }
                a(this.exv, null, false);
                return;
            }
            a(this.exv, null, true);
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
    public void zg() {
        AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
        a(this.exv, this.exy, false);
        an anVar = new an("c13333");
        anVar.bS("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPrivilegeListActivityConfig(this.mPageContext.getPageActivity(), this.user_id, this.exw, this.exx)));
    }
}
