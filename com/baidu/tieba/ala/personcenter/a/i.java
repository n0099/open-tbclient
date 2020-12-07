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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes6.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.l, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TextView gBU;
    private String hMT;
    private TbPageContext mPageContext;
    private String user_id;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.l.hNA);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.csM() == null) {
            return null;
        }
        a(lVar, aVar.csM());
        aVar.csM().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.click();
            }
        });
        return aVar.csM().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.l lVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = lVar.getPersonCenterData();
        if (personCenterData != null && aVar != null) {
            this.gBU = aVar.cno();
            this.user_id = personCenterData.cmP().user_id;
            a(personCenterData, aVar);
            aVar.xD(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_privilege));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(com.baidu.tieba.ala.personcenter.c.c cVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (cVar == null || aVar == null) {
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
        a(this.gBU, this.hMT, false);
        ar arVar = new ar("c13333");
        arVar.dY("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
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
