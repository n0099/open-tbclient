package com.baidu.tieba.ala.livecard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.view.card.AlaCardBottomUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private List<bk> data;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.data)) {
            return 0;
        }
        return this.data.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qx */
    public bk getItem(int i) {
        if (this.data != null && i >= 0 && i <= this.data.size()) {
            return this.data.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AlaInfoData aQS;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.fFS.setIsRound(true);
            aVar2.fFS.setDrawBorder(false);
            aVar2.fFS.setAutoChangeStyle(true);
            aVar2.fFS.setGifIconSupport(false);
            int equipmentWidth = (l.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i2 = (equipmentWidth * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fFU.getLayoutParams();
            layoutParams.height = equipmentWidth;
            layoutParams.width = i2;
            aVar2.fFU.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            layoutParams2.width = i2;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bk item = getItem(i);
        if (item != null && (aQS = item.aQS()) != null) {
            aVar.fFS.startLoad(aQS.cover, 10, false);
            aVar.fFT.setData(item);
            aVar.fFT.setUserHeadImgVisible(8);
            aVar.fFV.setText(item.getTitle());
            aVar.fFT.onChangeSkinType(this.mPageContext);
            am.setViewTextColor(aVar.fFV, R.color.cp_cont_b, TbadkCoreApplication.getInst().getSkinType());
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return null;
    }

    public void setData(List<bk> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView fFS;
        public AlaCardBottomUserInfoLayout fFT;
        public RelativeLayout fFU;
        public TextView fFV;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fFS = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.fFT = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.fFU = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.fFV = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }
}
