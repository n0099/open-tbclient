package com.baidu.tieba.ala.personcenter.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TextView epY;
    private String foe;
    private TbPageContext mPageContext;
    private String user_id;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), j.foE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.btc() == null) {
            return null;
        }
        a(jVar, aVar.btc());
        aVar.btc().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.click();
            }
        });
        return aVar.btc().getView();
    }

    private void a(j jVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = jVar.getPersonCenterData();
        if (personCenterData != null && aVar != null) {
            this.epY = aVar.bpY();
            this.user_id = personCenterData.bpA().user_id;
            a(personCenterData, aVar);
            aVar.qE(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_privilege));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(com.baidu.tieba.ala.personcenter.c.b bVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (bVar == null || aVar == null) {
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
    public void click() {
        AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
        a(this.epY, this.foe, false);
        an anVar = new an("c13333");
        anVar.cp("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
        if (string != null) {
            if (string.endsWith("/")) {
                string = string.substring(0, string.length() - 1);
            }
            String str = this.user_id;
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(str);
            if (!string.contains("?")) {
                sb.insert(0, "?");
            } else {
                sb.insert(0, ETAG.ITEM_SEPARATOR);
            }
            sb.insert(0, string);
            com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), sb.toString());
        }
    }
}
