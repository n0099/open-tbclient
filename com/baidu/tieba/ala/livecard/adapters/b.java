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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<bh> data;
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
    /* renamed from: mY */
    public bh getItem(int i) {
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
        AlaInfoData aiZ;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.dSX.setIsRound(true);
            aVar2.dSX.setDrawBorder(false);
            aVar2.dSX.setAutoChangeStyle(true);
            aVar2.dSX.setGifIconSupport(false);
            int equipmentWidth = (l.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i2 = (equipmentWidth * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.dSZ.getLayoutParams();
            layoutParams.height = equipmentWidth;
            layoutParams.width = i2;
            aVar2.dSZ.setLayoutParams(layoutParams);
            AbsHListView.f fVar = new AbsHListView.f(-1, -1);
            fVar.width = i2;
            view.setLayoutParams(fVar);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bh item = getItem(i);
        if (item != null && (aiZ = item.aiZ()) != null) {
            aVar.dSX.startLoad(aiZ.cover, 10, false);
            aVar.dSY.setData(item);
            aVar.dSY.setUserHeadImgVisible(8);
            aVar.dTa.setText(item.getTitle());
            aVar.dSY.onChangeSkinType(this.mPageContext);
            am.setViewTextColor(aVar.dTa, R.color.cp_cont_b, TbadkCoreApplication.getInst().getSkinType());
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return null;
    }

    public void setData(List<bh> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TbImageView dSX;
        public AlaCardBottomUserInfoLayout dSY;
        public RelativeLayout dSZ;
        public TextView dTa;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.dSX = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.dSY = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.dSZ = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.dTa = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }
}
