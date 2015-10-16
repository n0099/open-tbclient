package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.GetGiftMyList.GiftList;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private com.baidu.tbadk.core.view.m awg;
    private List<GiftList> bna;
    private MyGiftListActivity bnb;
    private boolean mIsHost;
    private int bmZ = 1;
    private boolean bnc = false;
    private String bnd = null;
    View.OnClickListener adY = new k(this);

    public j(MyGiftListActivity myGiftListActivity, boolean z) {
        this.bnb = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnc) {
            return 1;
        }
        if (this.bna != null && this.bna.size() != 0) {
            return this.bna.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gD */
    public GiftList getItem(int i) {
        if (this.bnc) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.bna == null || this.bna.size() == 0 || itemId < 0 || itemId >= this.bna.size()) {
            return null;
        }
        return this.bna.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.bmZ;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.bnc) {
            return createNoDataView();
        }
        if (view == null || view.getTag(i.f.tag_first) == null) {
            view = LayoutInflater.from(this.bnb.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.bgK = (HeadImageView) view.findViewById(i.f.item_portrait);
            aVar2.bgK.setOnClickListener(this.adY);
            aVar2.aYR = (TextView) view.findViewById(i.f.user_name);
            aVar2.bnh = (TextView) view.findViewById(i.f.gift_num);
            aVar2.bng = (TbClipImageView) view.findViewById(i.f.gift_icon);
            aVar2.bnf = (TextView) view.findViewById(i.f.gift_name);
            aVar2.aPX = (TextView) view.findViewById(i.f.time);
            aVar2.bni = (TextView) view.findViewById(i.f.paly_icon);
            view.setTag(i.f.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(i.f.tag_first);
        }
        if (!this.mIsHost) {
            aVar.aPX.setVisibility(8);
        }
        GiftList item = getItem(i);
        if (item.sender != null) {
            aVar.bgK.d(item.sender.portrait, 28, false);
            aVar.bgK.setAutoChangeStyle(false);
            aVar.bgK.setDrawBorder(false);
            aVar.aYR.setText(item.sender.name_show);
            aVar.bgK.setTag(i.f.tag_first, item.sender.id);
            aVar.bgK.setTag(i.f.tag_second, item.sender.name_show);
        }
        if (item.gift != null) {
            aVar.bng.d(item.gift.thumbnail_url, 10, false);
            aVar.bnf.setText(String.valueOf(this.bnb.getPageContext().getString(i.h.send_to_you)) + item.gift.name);
            aVar.bng.setAutoChangeStyle(false);
            aVar.bng.setDrawBorder(false);
            aVar.bnh.setText(String.valueOf(this.bnb.getPageContext().getString(i.h.mutil_sign)) + item.gift.num);
            aVar.aPX.setText(as.o(item.gift.send_time.intValue() * 1000));
            this.bnd = item.gift.play_url;
            boolean isEmpty = TextUtils.isEmpty(this.bnd);
            if (this.mIsHost && !isEmpty && com.baidu.adp.lib.util.k.jg()) {
                aVar.bni.setVisibility(0);
            } else {
                aVar.bni.setVisibility(8);
            }
        }
        applyNightMode(view);
        if (com.baidu.adp.lib.util.k.jg()) {
            view.setTag(i.f.tag_second, this.bnd);
            return view;
        }
        return view;
    }

    private View createNoDataView() {
        View inflate = LayoutInflater.from(this.bnb.getPageContext().getPageActivity()).inflate(i.g.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bnb.getResources().getString(i.h.send_gift), this.bnb.Qv()));
        int dimension = (int) this.bnb.getResources().getDimension(i.d.ds22);
        int dimension2 = (int) this.bnb.getResources().getDimension(i.d.ds140);
        String Qx = this.bnb.Qx();
        String string = this.bnb.getPageContext().getString(i.h.no_gift);
        String string2 = this.bnb.getPageContext().getString(i.h.come_on);
        String format = String.format(this.bnb.getPageContext().getString(i.h.send_him_gift_note), Qx);
        Activity pageActivity = this.bnb.getPageContext().getPageActivity();
        NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.GIFT;
        if (!this.mIsHost) {
            dimension = dimension2;
        }
        this.awg = NoDataViewFactory.a(pageActivity, inflate, NoDataViewFactory.c.a(imgType, dimension), NoDataViewFactory.d.ag(string, this.mIsHost ? string2 : format), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.bnb.getLayoutMode().ad(skinType == 1);
        this.bnb.getLayoutMode().k(inflate);
        this.awg.onChangeSkinType(this.bnb.getPageContext(), skinType);
        this.awg.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aPX;
        TextView aYR;
        HeadImageView bgK;
        TextView bnf;
        TbClipImageView bng;
        TextView bnh;
        TextView bni;

        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }
    }

    public void setData(List<GiftList> list) {
        if (list == null) {
            this.bnc = true;
        } else {
            this.bnc = false;
        }
        this.bna = list;
        notifyDataSetChanged();
    }

    private void applyNightMode(View view) {
        this.bnb.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.bnb.getLayoutMode().k(view);
    }
}
