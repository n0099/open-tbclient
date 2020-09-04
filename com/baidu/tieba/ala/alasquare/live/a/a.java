package com.baidu.tieba.ala.alasquare.live.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live.b.b, com.baidu.tieba.ala.alasquare.b.a> {
    private IAlaSquareTabController fCM;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public com.baidu.tieba.ala.alasquare.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.ala.alasquare.b.a(LayoutInflater.from(this.mContext).inflate(R.layout.square_live_category_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.alasquare.live.b.b bVar, com.baidu.tieba.ala.alasquare.b.a aVar) {
        View findViewById = aVar.mView.findViewById(R.id.live_category_top_line);
        TextView textView = (TextView) aVar.mView.findViewById(R.id.live_category_entry_name);
        TextView textView2 = (TextView) aVar.mView.findViewById(R.id.live_category_entry_tv);
        ImageView imageView = (ImageView) aVar.mView.findViewById(R.id.live_category_entry_img);
        if (i == 0) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        ap.setBackgroundColor(findViewById, R.color.cp_bg_line_e);
        ap.setBackgroundColor(aVar.mView, R.color.cp_bg_line_d);
        ap.setViewTextColor(textView, (int) R.color.cp_cont_f);
        ap.setViewTextColor(textView2, (int) R.color.cp_cont_d);
        ap.setImageResource(imageView, R.drawable.icon_arrow_tab);
        textView.setText(!TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fCM != null) {
                    int tabIndex = a.this.fCM.getTabIndex(bVar.tabId);
                    if (tabIndex >= 0) {
                        a.this.fCM.goToTab(tabIndex);
                        return;
                    } else {
                        a.this.a(bVar);
                        return;
                    }
                }
                a.this.a(bVar);
            }
        });
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.alasquare.live.b.b bVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(this.mContext, bVar.bitmapRatio, bVar.entryName, bVar.labelName, (bVar.fCZ == null || !(bVar.fCZ instanceof ArrayList)) ? null : (ArrayList) bVar.fCZ)));
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fCM = iAlaSquareTabController;
    }
}
