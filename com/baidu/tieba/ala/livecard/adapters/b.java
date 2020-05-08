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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private List<bj> data;
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
    /* renamed from: pW */
    public bj getItem(int i) {
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
        AlaInfoData aKV;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.fsa.setIsRound(true);
            aVar2.fsa.setDrawBorder(false);
            aVar2.fsa.setAutoChangeStyle(true);
            aVar2.fsa.setGifIconSupport(false);
            int equipmentWidth = (l.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i2 = (equipmentWidth * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.fsc.getLayoutParams();
            layoutParams.height = equipmentWidth;
            layoutParams.width = i2;
            aVar2.fsc.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            layoutParams2.width = i2;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bj item = getItem(i);
        if (item != null && (aKV = item.aKV()) != null) {
            aVar.fsa.startLoad(aKV.cover, 10, false);
            aVar.fsb.setData(item);
            aVar.fsb.setUserHeadImgVisible(8);
            aVar.fsd.setText(item.getTitle());
            aVar.fsb.onChangeSkinType(this.mPageContext);
            am.setViewTextColor(aVar.fsd, R.color.cp_cont_b, TbadkCoreApplication.getInst().getSkinType());
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return null;
    }

    public void setData(List<bj> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView fsa;
        public AlaCardBottomUserInfoLayout fsb;
        public RelativeLayout fsc;
        public TextView fsd;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fsa = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.fsb = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.fsc = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.fsd = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }
}
