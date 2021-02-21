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
import com.baidu.tieba.ala.alasquare.holder.SquareLiveCategoryViewHolder;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live.b.b, SquareLiveCategoryViewHolder> {
    private IAlaSquareTabController gzi;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public SquareLiveCategoryViewHolder e(ViewGroup viewGroup) {
        return new SquareLiveCategoryViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.square_live_category_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.alasquare.live.b.b bVar, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        View findViewById = squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_top_line);
        TextView textView = (TextView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_name);
        TextView textView2 = (TextView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_tv);
        ImageView imageView = (ImageView) squareLiveCategoryViewHolder.mView.findViewById(R.id.live_category_entry_img);
        if (i == 0) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        ap.setBackgroundColor(findViewById, R.color.CAM_X0205);
        ap.setBackgroundColor(squareLiveCategoryViewHolder.mView, R.color.CAM_X0201);
        ap.setViewTextColor(textView, R.color.CAM_X0106);
        ap.setViewTextColor(textView2, R.color.CAM_X0109);
        ap.setImageResource(imageView, R.drawable.icon_arrow_tab);
        textView.setText(!TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gzi != null) {
                    int tabIndex = a.this.gzi.getTabIndex(bVar.tabId);
                    if (tabIndex >= 0) {
                        a.this.gzi.goToTab(tabIndex);
                        return;
                    } else {
                        a.this.a(bVar);
                        return;
                    }
                }
                a.this.a(bVar);
            }
        });
        return squareLiveCategoryViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.alasquare.live.b.b bVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(this.mContext, bVar.bitmapRatio, bVar.entryName, bVar.labelName, (bVar.gzv == null || !(bVar.gzv instanceof ArrayList)) ? null : (ArrayList) bVar.gzv)));
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gzi = iAlaSquareTabController;
    }
}
