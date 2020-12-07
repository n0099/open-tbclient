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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<by> data;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.data)) {
            return 0;
        }
        return this.data.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wj */
    public by getItem(int i) {
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
        AlaInfoData bpj;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.hbp.setIsRound(true);
            aVar2.hbp.setDrawBorder(false);
            aVar2.hbp.setAutoChangeStyle(true);
            aVar2.hbp.setGifIconSupport(false);
            int equipmentWidth = (l.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i2 = (equipmentWidth * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar2.hbr.getLayoutParams();
            layoutParams.height = equipmentWidth;
            layoutParams.width = i2;
            aVar2.hbr.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            layoutParams2.width = i2;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        by item = getItem(i);
        if (item != null && (bpj = item.bpj()) != null) {
            aVar.hbp.startLoad(bpj.cover, 10, false);
            aVar.hbq.setData(item);
            aVar.hbq.setUserHeadImgVisible(8);
            aVar.hbs.setText(item.getTitle());
            aVar.hbq.onChangeSkinType(this.mPageContext);
            ap.setViewTextColor(aVar.hbs, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return null;
    }

    public void setData(List<by> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TbImageView hbp;
        public AlaCardBottomUserInfoLayout hbq;
        public RelativeLayout hbr;
        public TextView hbs;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hbp = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.hbq = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.hbr = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.hbs = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }
}
